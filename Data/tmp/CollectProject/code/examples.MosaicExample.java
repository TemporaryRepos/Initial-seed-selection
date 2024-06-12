public class MosaicExample {
	private final java.nio.file.Path ffmpegBin;

	private final java.util.List<java.lang.String> inputs;

	private final int sampleRate = 44100;

	private final int frameRate = 25;

	public static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(examples.MosaicExample.class);

	public MosaicExample(java.lang.String ffmpegBin, java.util.List<java.lang.String> inputs) {
		this.ffmpegBin = java.nio.file.Paths.get(ffmpegBin);
		this.inputs = inputs;
	}

	public void execute() {
		final java.util.List<com.github.kokorin.jaffree.ffmpeg.FFmpegResult> results = new java.util.concurrent.CopyOnWriteArrayList<>();
		java.util.List<examples.MosaicExample.FrameIterator> frameIterators = new java.util.ArrayList<>();
		for (int i = 0; i < inputs.size(); i++) {
			java.lang.String input = inputs.get(i);
			boolean hasAudioStream = false;
			com.github.kokorin.jaffree.ffprobe.FFprobeResult probeResult = com.github.kokorin.jaffree.ffprobe.FFprobe.atPath(ffmpegBin).setShowStreams(true).setInput(java.nio.file.Paths.get(input)).execute();
			for (com.github.kokorin.jaffree.ffmpeg.Stream stream : probeResult.getStreams()) {
				if (com.github.kokorin.jaffree.StreamType.AUDIO == stream.getCodecType()) {
					hasAudioStream = true;
					break;
				}
			}
			examples.MosaicExample.FrameIterator frameIterator = new examples.MosaicExample.FrameIterator();
			frameIterators.add(frameIterator);
			final com.github.kokorin.jaffree.ffmpeg.FFmpeg ffmpeg = com.github.kokorin.jaffree.ffmpeg.FFmpeg.atPath(ffmpegBin).addInput(com.github.kokorin.jaffree.ffmpeg.UrlInput.fromUrl(input).setDuration(15000)).addOutput(com.github.kokorin.jaffree.ffmpeg.FrameOutput.withConsumer(frameIterator.getConsumer()).setFrameRate(frameRate).addArguments("-ac", "1").addArguments("-ar", java.lang.Integer.toString(sampleRate))).setContextName("input" + i);
			if (!hasAudioStream) {
				ffmpeg.addInput(com.github.kokorin.jaffree.ffmpeg.UrlInput.fromUrl("anullsrc").setFormat("lavfi")).addArgument("-shortest");
			}
			java.lang.Thread ffmpegThread = new java.lang.Thread(new java.lang.Runnable() {
				@java.lang.Override
				public void run() {
					com.github.kokorin.jaffree.ffmpeg.FFmpegResult result = ffmpeg.execute();
					results.add(result);
				}
			}, ("Reader-" + i) + "-main");
			ffmpegThread.setDaemon(true);
			ffmpegThread.start();
		}
		com.github.kokorin.jaffree.ffmpeg.FrameProducer frameProducer = produceMosaic(frameIterators);
		com.github.kokorin.jaffree.ffmpeg.FFmpegResult mosaicResult = com.github.kokorin.jaffree.ffmpeg.FFmpeg.atPath(ffmpegBin).addInput(com.github.kokorin.jaffree.ffmpeg.FrameInput.withProducer(frameProducer, ImageFormats.BGR24, 5000L).setFrameRate(frameRate)).setOverwriteOutput(true).setLogLevel(LogLevel.TRACE).addOutput(com.github.kokorin.jaffree.ffmpeg.UrlOutput.toUrl("mosaic.mp4")).addArguments("-filter_complex", "amix=inputs=" + inputs.size()).setContextName("result").execute();
	}

	private com.github.kokorin.jaffree.ffmpeg.FrameProducer produceMosaic(final java.util.List<examples.MosaicExample.FrameIterator> frameIterators) {
		final int rows = ((int) (java.lang.Math.round(java.lang.Math.sqrt(frameIterators.size()))));
		final int columns = ((int) (java.lang.Math.ceil((1.0 * frameIterators.size()) / rows)));
		return new com.github.kokorin.jaffree.ffmpeg.FrameProducer() {
			private final int elementWidth = 320;

			private final int elementHeight = 240;

			private final int mosaicWidth = columns * elementWidth;

			private final int mosaicHeight = rows * elementHeight;

			private final long videoFrameDuration = 1000 / frameRate;

			private final java.util.Map<java.lang.Integer, java.util.Deque<com.github.kokorin.jaffree.ffmpeg.Frame>> audioQueues = new java.util.HashMap<>();

			private long timecode = 0;

			private final com.github.kokorin.jaffree.ffmpeg.Frame[] nextVideoFrames = new com.github.kokorin.jaffree.ffmpeg.Frame[frameIterators.size()];

			private long nextVideoFrameTimecode = 0;

			private long nextAudioFrameTimecode = 0;

			@java.lang.Override
			public java.util.List<com.github.kokorin.jaffree.ffmpeg.Stream> produceStreams() {
				java.util.List<com.github.kokorin.jaffree.ffmpeg.Stream> streams = new java.util.ArrayList<>();
				streams.add(new com.github.kokorin.jaffree.ffmpeg.Stream().setId(0).setType(Stream.Type.VIDEO).setTimebase(1000L).setWidth(mosaicWidth).setHeight(mosaicHeight));
				for (int i = 0; i < frameIterators.size(); i++) {
					streams.add(new com.github.kokorin.jaffree.ffmpeg.Stream().setId(1 + i).setType(Stream.Type.AUDIO).setTimebase(((long) (sampleRate))).setChannels(1).setSampleRate(sampleRate));
				}
				return streams;
			}

			@java.lang.Override
			public com.github.kokorin.jaffree.ffmpeg.Frame produce() {
				com.github.kokorin.jaffree.ffmpeg.Frame result = null;
				if (nextVideoFrameTimecode <= timecode) {
					if (nextVideoFrameTimecode == 0) {
						readNextVideoFrames(nextVideoFrameTimecode);
					}
					result = produceVideoFrame(nextVideoFrames);
					readNextVideoFrames(nextVideoFrameTimecode);
				} else if (nextAudioFrameTimecode <= timecode) {
					result = produceAudioFrame();
				}
				timecode = java.lang.Math.min(nextVideoFrameTimecode, nextAudioFrameTimecode);
				return result;
			}

			public com.github.kokorin.jaffree.ffmpeg.Frame produceVideoFrame(com.github.kokorin.jaffree.ffmpeg.Frame[] videoFrames) {
				java.awt.image.BufferedImage mosaic = new java.awt.image.BufferedImage(mosaicWidth, mosaicHeight, java.awt.image.BufferedImage.TYPE_3BYTE_BGR);
				java.awt.Graphics mosaicGraphics = mosaic.getGraphics();
				mosaicGraphics.setColor(new java.awt.Color(0));
				mosaicGraphics.fillRect(0, 0, mosaicWidth, mosaicHeight);
				boolean atLeastHasOneElement = false;
				for (int i = 0; i < videoFrames.length; i++) {
					com.github.kokorin.jaffree.ffmpeg.Frame videoFrame = videoFrames[i];
					if (videoFrame == null) {
						continue;
					}
					atLeastHasOneElement = true;
					java.awt.image.BufferedImage element = videoFrame.getImage();
					int row = i / columns;
					int column = i % columns;
					java.awt.image.ImageObserver observer = new java.awt.image.ImageObserver() {
						@java.lang.Override
						public boolean imageUpdate(java.awt.Image img, int infoflags, int x, int y, int width, int height) {
							return false;
						}
					};
					int dx1 = column * elementWidth;
					int dy1 = row * elementHeight;
					int dx2 = dx1 + elementWidth;
					int dy2 = dy1 + elementHeight;
					mosaicGraphics.drawImage(element, dx1, dy1, dx2, dy2, 0, 0, element.getWidth(), element.getHeight(), observer);
				}
				if (!atLeastHasOneElement) {
					return null;
				}
				com.github.kokorin.jaffree.ffmpeg.Frame result = com.github.kokorin.jaffree.ffmpeg.Frame.createVideoFrame(0, nextVideoFrameTimecode, mosaic);
				nextVideoFrameTimecode += videoFrameDuration;
				return result;
			}

			private com.github.kokorin.jaffree.ffmpeg.Frame produceAudioFrame() {
				long minPts = java.lang.Long.MAX_VALUE;
				long nextPts = java.lang.Long.MAX_VALUE;
				int minI = -1;
				for (int i = 0; i < frameIterators.size(); i++) {
					java.util.Deque<com.github.kokorin.jaffree.ffmpeg.Frame> aQueue = audioQueues.get(i);
					com.github.kokorin.jaffree.ffmpeg.Frame frame = aQueue.peekFirst();
					if (frame == null) {
						continue;
					}
					long queuePts = frame.getPts();
					if (queuePts < minPts) {
						nextPts = minPts;
						minPts = queuePts;
						minI = i;
						continue;
					}
					if (queuePts < nextPts) {
						nextPts = queuePts;
					}
				}
				if (minI == (-1)) {
					return null;
				}
				com.github.kokorin.jaffree.ffmpeg.Frame aFrame = audioQueues.get(minI).pollFirst();
				if (aFrame == null) {
					return null;
				}
				aFrame = com.github.kokorin.jaffree.ffmpeg.Frame.createAudioFrame(1 + minI, aFrame.getPts(), aFrame.getSamples());
				if (nextPts != java.lang.Long.MAX_VALUE) {
					nextAudioFrameTimecode = (1000L * nextPts) / sampleRate;
				} else {
					nextAudioFrameTimecode = nextVideoFrameTimecode;
				}
				return aFrame;
			}

			private void readNextVideoFrames(long videoTs) {
				for (int i = 0; i < frameIterators.size(); i++) {
					examples.MosaicExample.FrameIterator iter = frameIterators.get(i);
					if (!iter.hasNext) {
						nextVideoFrames[i] = null;
					}
					while (iter.hasNext) {
						com.github.kokorin.jaffree.ffmpeg.Frame frame = iter.next();
						if (frame == null) {
							break;
						}
						com.github.kokorin.jaffree.ffmpeg.Stream stream = iter.getStream(frame.getStreamId());
						if (stream == null) {
							break;
						}
						switch (stream.getType()) {
							case VIDEO :
								nextVideoFrames[i] = frame;
								break;
							case AUDIO :
								java.util.Deque<com.github.kokorin.jaffree.ffmpeg.Frame> aQueue = audioQueues.get(i);
								if (aQueue == null) {
									aQueue = new java.util.LinkedList<>();
									audioQueues.put(i, aQueue);
								}
								aQueue.addLast(frame);
								break;
						}
						long frameTs = (1000L * frame.getPts()) / stream.getTimebase();
						if (frameTs >= videoTs) {
							break;
						}
					} 
				}
			}
		};
	}

	public static void main(java.lang.String[] args) {
		java.util.Iterator<java.lang.String> argIter = java.util.Arrays.asList(args).iterator();
		java.lang.String ffmpegBin = null;
		java.util.List<java.lang.String> inputs = new java.util.ArrayList<>();
		while (argIter.hasNext()) {
			java.lang.String arg = argIter.next();
			if ("-ffmpeg_bin".equals(arg)) {
				ffmpegBin = argIter.next();
			} else {
				inputs.add(arg);
			}
		} 
		if ((ffmpegBin == null) || inputs.isEmpty()) {
			java.lang.System.err.println("Arguments: -ffmpeg_bin </path/to/ffmpeg/bin>");
			return;
		}
		new examples.MosaicExample(ffmpegBin, inputs).execute();
	}

	public static class FrameIterator implements java.util.Iterator<com.github.kokorin.jaffree.ffmpeg.Frame> {
		private volatile boolean hasNext = true;

		private volatile com.github.kokorin.jaffree.ffmpeg.Frame next = null;

		private volatile java.util.List<com.github.kokorin.jaffree.ffmpeg.Stream> tracks;

		private final com.github.kokorin.jaffree.ffmpeg.FrameConsumer consumer = new com.github.kokorin.jaffree.ffmpeg.FrameConsumer() {
			@java.lang.Override
			public void consumeStreams(java.util.List<com.github.kokorin.jaffree.ffmpeg.Stream> tracks) {
				examples.MosaicExample.FrameIterator.this.tracks = tracks;
			}

			@java.lang.Override
			public void consume(com.github.kokorin.jaffree.ffmpeg.Frame frame) {
				while (next != null) {
					try {
						java.lang.Thread.sleep(10);
					} catch (java.lang.InterruptedException e) {
						examples.MosaicExample.LOGGER.warn("Exception while supplying frame", e);
					}
				} 
				hasNext = frame != null;
				next = frame;
			}
		};

		@java.lang.Override
		public boolean hasNext() {
			waitForNextFrame();
			return hasNext;
		}

		@java.lang.Override
		public com.github.kokorin.jaffree.ffmpeg.Frame next() {
			waitForNextFrame();
			com.github.kokorin.jaffree.ffmpeg.Frame result = next;
			next = null;
			return result;
		}

		@java.lang.Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException("remove");
		}

		public com.github.kokorin.jaffree.ffmpeg.FrameConsumer getConsumer() {
			return consumer;
		}

		public java.util.List<com.github.kokorin.jaffree.ffmpeg.Stream> getTracks() {
			return tracks;
		}

		public com.github.kokorin.jaffree.ffmpeg.Stream getStream(int id) {
			for (com.github.kokorin.jaffree.ffmpeg.Stream stream : tracks) {
				if (stream.getId() == id) {
					return stream;
				}
			}
			return null;
		}

		private void waitForNextFrame() {
			while (hasNext && (next == null)) {
				try {
					java.lang.Thread.sleep(10);
				} catch (java.lang.InterruptedException e) {
					examples.MosaicExample.LOGGER.warn("Exception while waiting for frame", e);
				}
			} 
		}
	}
}