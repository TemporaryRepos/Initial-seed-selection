public class H264Filter {
	private static java.nio.MappedByteBuffer mappedByteBuffer;

	private static byte[] buffer = new byte[(1024 * 1024) * 10];

	public static void main(java.lang.String[] args) throws java.io.IOException {
		site.alice.liveman.videofilter.H264Filter.simplest_h264_parser(new java.io.File("C:\\Users\\hasee\\Desktop\\5410.ts"));
	}

	static int FindStartCode2(int startPos, byte[] Buf) {
		if (((Buf[startPos] != 0) || (Buf[startPos + 1] != 0)) || (Buf[startPos + 2] != 1)) {
			return 0;
		} else {
			return 1;
		}
	}

	static int FindStartCode3(int startPos, byte[] Buf) {
		if ((((Buf[startPos] != 0) || (Buf[startPos + 1] != 0)) || (Buf[startPos + 2] != 0)) || (Buf[startPos + 3] != 1)) {
			return 0;
		} else {
			return 1;
		}
	}

	static int GetAnnexbNALU(site.alice.liveman.videofilter.h264.NALUStruct nalu) throws java.io.IOException {
		int pos = 0;
		boolean StartCodeFound;
		int rewind;
		nalu.startCode = site.alice.liveman.videofilter.h264.NALUStruct.START_CODE3;
		if (site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.remaining() < 3) {
			return -1;
		}
		site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.get(site.alice.liveman.videofilter.H264Filter.buffer, 0, 3);
		pos = 3;
		int info2 = site.alice.liveman.videofilter.H264Filter.FindStartCode2(0, site.alice.liveman.videofilter.H264Filter.buffer);
		int info3 = 0;
		if (info2 != 1) {
			if (site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.remaining() < 1) {
				return -1;
			}
			site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.get(site.alice.liveman.videofilter.H264Filter.buffer, 3, 1);
			info3 = site.alice.liveman.videofilter.H264Filter.FindStartCode3(0, site.alice.liveman.videofilter.H264Filter.buffer);
			pos = 4;
			if (info3 != 1) {
				nalu.startCode = site.alice.liveman.videofilter.h264.NALUStruct.START_CODE0;
			} else {
				nalu.startCode = site.alice.liveman.videofilter.h264.NALUStruct.START_CODE4;
			}
		} else {
			nalu.startCode = site.alice.liveman.videofilter.h264.NALUStruct.START_CODE3;
		}
		StartCodeFound = false;
		info2 = 0;
		info3 = 0;
		nalu.startPos = site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.position();
		while (!StartCodeFound) {
			try {
				site.alice.liveman.videofilter.H264Filter.buffer[pos++] = site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.get();
				info3 = site.alice.liveman.videofilter.H264Filter.FindStartCode3(pos - 4, site.alice.liveman.videofilter.H264Filter.buffer);
				if (info3 != 1) {
					info2 = site.alice.liveman.videofilter.H264Filter.FindStartCode2(pos - 3, site.alice.liveman.videofilter.H264Filter.buffer);
				}
				StartCodeFound = (info2 == 1) || (info3 == 1);
			} catch (java.nio.BufferUnderflowException e) {
				nalu.len = (pos - 1) - nalu.startCode.length;
				if (nalu.len >= 0) {
					nalu.buf = new byte[nalu.len];
					java.lang.System.arraycopy(site.alice.liveman.videofilter.H264Filter.buffer, nalu.startCode.length, nalu.buf, 0, nalu.len);
				}
				if (nalu.startCode.length > 0) {
					nalu.forbiddenBit = nalu.buf[0] & 0x80;
					int naluPriority = (nalu.buf[0] & 0x60) >> 5;
					if (naluPriority < site.alice.liveman.videofilter.h264.ReferenceIdc.values().length) {
						nalu.referenceIdc = site.alice.liveman.videofilter.h264.ReferenceIdc.values()[naluPriority];
					}
					int naluType = nalu.buf[0] & 0x1f;
					if (naluType < site.alice.liveman.videofilter.h264.UnitType.values().length) {
						nalu.unitType = site.alice.liveman.videofilter.h264.UnitType.values()[naluType];
					}
				}
				return pos - 1;
			}
		} 
		rewind = (info3 == 1) ? -4 : -3;
		site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.position(site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.position() + rewind);
		nalu.len = (pos + rewind) - nalu.startCode.length;
		if (nalu.len >= 0) {
			nalu.buf = new byte[nalu.len];
			java.lang.System.arraycopy(site.alice.liveman.videofilter.H264Filter.buffer, nalu.startCode.length, nalu.buf, 0, nalu.len);
		}
		if (nalu.startCode.length > 0) {
			nalu.forbiddenBit = nalu.buf[0] & 0x80;
			int naluPriority = (nalu.buf[0] & 0x60) >> 5;
			if (naluPriority < site.alice.liveman.videofilter.h264.ReferenceIdc.values().length) {
				nalu.referenceIdc = site.alice.liveman.videofilter.h264.ReferenceIdc.values()[naluPriority];
			}
			int naluType = nalu.buf[0] & 0x1f;
			if (naluType < site.alice.liveman.videofilter.h264.UnitType.values().length) {
				nalu.unitType = site.alice.liveman.videofilter.h264.UnitType.values()[naluType];
			}
		}
		return pos + rewind;
	}

	static int simplest_h264_parser(java.io.File h264File) throws java.io.IOException {
		java.util.List<site.alice.liveman.videofilter.PayloadStruct> payloadStructList = new java.util.ArrayList<>();
		java.io.RandomAccessFile mediaFileStream = new java.io.RandomAccessFile(h264File, "rw");
		site.alice.liveman.videofilter.H264Filter.mappedByteBuffer = mediaFileStream.getChannel().map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0, mediaFileStream.length());
		while (true) {
			site.alice.liveman.videofilter.h264.NALUStruct naluStruct = new site.alice.liveman.videofilter.h264.NALUStruct();
			if (site.alice.liveman.videofilter.H264Filter.GetAnnexbNALU(naluStruct) == (-1)) {
				break;
			}
			if (payloadStructList.isEmpty() || (((naluStruct.unitType != site.alice.liveman.videofilter.h264.UnitType.OTHER) && (naluStruct.unitType != site.alice.liveman.videofilter.h264.UnitType.NALU_TYPE_PADDING)) && (naluStruct.referenceIdc != site.alice.liveman.videofilter.h264.ReferenceIdc.OTHER))) {
				if (!payloadStructList.isEmpty()) {
					site.alice.liveman.videofilter.h264.NALUStruct prevNaluStruct = ((site.alice.liveman.videofilter.h264.NALUStruct) (payloadStructList.get(payloadStructList.size() - 1)));
					if (((prevNaluStruct.unitType == site.alice.liveman.videofilter.h264.UnitType.OTHER) || (prevNaluStruct.referenceIdc == site.alice.liveman.videofilter.h264.ReferenceIdc.OTHER)) || (prevNaluStruct.unitType == site.alice.liveman.videofilter.h264.UnitType.NALU_TYPE_PADDING)) {
						byte[] buffer = prevNaluStruct.buf;
						if (prevNaluStruct.len >= 7) {
							for (int i = 0; i < prevNaluStruct.len; i++) {
								if ((buffer[i] == ((byte) (0xff))) && ((buffer[i + 1] & 0xf0) == 0xf0)) {
									int size = 0;
									size |= (buffer[i + 3] & 0x3) << 11;
									size |= buffer[i + 4] << 3;
									size |= (buffer[i + 5] & 0xe0) >> 5;
									if (size > 0) {
										int profile = (buffer[i + 2] & 0xc0) >> 6;
										int frequence = (buffer[i + 2] & 0x3c) >> 2;
										if ((frequence < site.alice.liveman.videofilter.aac.FrequenceEnum.values().length) && (profile < site.alice.liveman.videofilter.aac.ProfileEnum.values().length)) {
											if (((i + 7) + size) < buffer.length) {
												site.alice.liveman.videofilter.aac.ADTSStruct adtsStruct = new site.alice.liveman.videofilter.aac.ADTSStruct(new byte[]{ buffer[i], buffer[i + 1] });
												adtsStruct.buf = new byte[size];
												java.lang.System.arraycopy(buffer, i + 7, adtsStruct.buf, 0, size);
												adtsStruct.startPos = (prevNaluStruct.startPos + i) + 7;
												adtsStruct.len = size;
												adtsStruct.frequence = site.alice.liveman.videofilter.aac.FrequenceEnum.values()[frequence];
												adtsStruct.profile = site.alice.liveman.videofilter.aac.ProfileEnum.values()[profile];
												payloadStructList.add(adtsStruct);
												i = (i + 7) + size;
											}
										}
									}
								}
							}
						}
					}
				}
				payloadStructList.add(naluStruct);
			} else {
				site.alice.liveman.videofilter.h264.NALUStruct prevNaluStruct = ((site.alice.liveman.videofilter.h264.NALUStruct) (payloadStructList.get(payloadStructList.size() - 1)));
				if (((prevNaluStruct.unitType == site.alice.liveman.videofilter.h264.UnitType.OTHER) || (prevNaluStruct.referenceIdc == site.alice.liveman.videofilter.h264.ReferenceIdc.OTHER)) || (prevNaluStruct.unitType == site.alice.liveman.videofilter.h264.UnitType.NALU_TYPE_PADDING)) {
					prevNaluStruct.buf = org.apache.commons.lang.ArrayUtils.addAll(prevNaluStruct.buf, naluStruct.buf);
					prevNaluStruct.len = prevNaluStruct.buf.length;
				} else {
					payloadStructList.add(naluStruct);
				}
			}
		} 
		for (site.alice.liveman.videofilter.PayloadStruct payloadStruct : payloadStructList) {
			java.lang.System.out.println(payloadStruct);
			if (payloadStruct instanceof site.alice.liveman.videofilter.h264.NALUStruct) {
				site.alice.liveman.videofilter.h264.NALUStruct naluStruct = ((site.alice.liveman.videofilter.h264.NALUStruct) (payloadStruct));
				if (!((naluStruct.unitType == site.alice.liveman.videofilter.h264.UnitType.NALU_TYPE_IDR) || (naluStruct.unitType == site.alice.liveman.videofilter.h264.UnitType.NALU_TYPE_SLICE))) {
					continue;
				}
			} else if (payloadStruct instanceof site.alice.liveman.videofilter.aac.ADTSStruct) {
				continue;
			}
			site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.position(((int) (payloadStruct.startPos + 64)));
			byte[] buf = payloadStruct.buf;
			for (int i = 64; i < buf.length; i++) {
				site.alice.liveman.videofilter.H264Filter.mappedByteBuffer.put(((byte) (buf[i] ^ 0xac)));
			}
		}
		mediaFileStream.close();
		return 0;
	}
}