public final class Processes {
	public static void main(java.lang.String[] args) throws java.io.IOException, java.lang.InterruptedException {
		com.github.davidmoten.rx.Processes.execute("ls").map(new rx.functions.Func1<byte[], java.lang.String>() {
			@java.lang.Override
			public java.lang.String call(byte[] bytes) {
				return new java.lang.String(bytes);
			}
		});
	}

	public static rx.Observable<byte[]> execute(java.lang.String... command) {
		return com.github.davidmoten.rx.Processes.execute(new com.github.davidmoten.rx.Processes.Parameters(java.util.Arrays.asList(command), com.github.davidmoten.util.Optional.<java.util.Map<java.lang.String, java.lang.String>>absent(), true, new java.io.File("."), com.github.davidmoten.util.Optional.<java.lang.Long>absent()));
	}

	public static rx.Observable<byte[]> execute(final com.github.davidmoten.rx.Processes.Parameters parameters) {
		rx.functions.Func0<java.lang.Process> resourceFactory = new rx.functions.Func0<java.lang.Process>() {
			@java.lang.Override
			public java.lang.Process call() {
				java.lang.ProcessBuilder b = new java.lang.ProcessBuilder(parameters.command());
				if (parameters.env().isPresent()) {
					if (parameters.appendEnv()) {
						b.environment().clear();
					}
					b.environment().putAll(parameters.env().get());
				}
				b.directory(parameters.directory());
				b.redirectErrorStream(true);
				try {
					return b.start();
				} catch (java.io.IOException e) {
					throw new java.lang.RuntimeException(e);
				}
			}
		};
		rx.functions.Func1<java.lang.Process, rx.Observable<byte[]>> factory = new rx.functions.Func1<java.lang.Process, rx.Observable<byte[]>>() {
			@java.lang.Override
			public rx.Observable<byte[]> call(final java.lang.Process process) {
				java.io.InputStream is = process.getInputStream();
				rx.Observable<byte[]> output;
				if (is != null) {
					output = com.github.davidmoten.rx.Bytes.from(is);
				} else {
					output = rx.Observable.empty();
				}
				rx.Observable<byte[]> completion = rx.Observable.create(new rx.Observable.OnSubscribe<byte[]>() {
					@java.lang.Override
					public void call(rx.Subscriber<? super byte[]> sub) {
						try {
							if (parameters.waitForMs().isPresent()) {
								sub.onError(new java.lang.IllegalArgumentException("not implemented yet"));
							} else {
								int exitCode = process.waitFor();
								if (exitCode != 0) {
									sub.onError(new com.github.davidmoten.rx.Processes.ProcessException(exitCode));
								}
								return;
							}
							sub.onCompleted();
						} catch (java.lang.InterruptedException e) {
							sub.onError(e);
						}
					}
				}).subscribeOn(rx.schedulers.Schedulers.io());
				return output.concatWith(completion);
			}
		};
		rx.functions.Action1<? super java.lang.Process> disposeAction = new rx.functions.Action1<java.lang.Process>() {
			@java.lang.Override
			public void call(java.lang.Process process) {
				process.destroy();
			}
		};
		return rx.Observable.using(resourceFactory, factory, disposeAction);
	}

	public static class ProcessException extends java.lang.RuntimeException {
		private static final long serialVersionUID = 722422557667123473L;

		private final int exitCode;

		public ProcessException(int exitCode) {
			super("process returned exitCode " + exitCode);
			this.exitCode = exitCode;
		}

		public int exitCode() {
			return exitCode;
		}
	}

	public static final class Parameters {
		private final java.util.List<java.lang.String> command;

		private final com.github.davidmoten.util.Optional<java.util.Map<java.lang.String, java.lang.String>> env;

		private final boolean appendEnv;

		private final java.io.File directory;

		private final com.github.davidmoten.util.Optional<java.lang.Long> waitForMs;

		public Parameters(java.util.List<java.lang.String> command, com.github.davidmoten.util.Optional<java.util.Map<java.lang.String, java.lang.String>> env, boolean appendEnv, java.io.File directory, com.github.davidmoten.util.Optional<java.lang.Long> waitForMs) {
			this.command = command;
			this.env = env;
			this.appendEnv = appendEnv;
			this.directory = directory;
			this.waitForMs = waitForMs;
		}

		public com.github.davidmoten.util.Optional<java.lang.Long> waitForMs() {
			return waitForMs;
		}

		public java.io.File directory() {
			return directory;
		}

		public java.util.List<java.lang.String> command() {
			return command;
		}

		public com.github.davidmoten.util.Optional<java.util.Map<java.lang.String, java.lang.String>> env() {
			return env;
		}

		public boolean appendEnv() {
			return appendEnv;
		}
	}
}