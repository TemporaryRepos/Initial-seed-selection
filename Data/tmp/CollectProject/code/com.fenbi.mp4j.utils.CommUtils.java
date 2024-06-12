public class CommUtils {
	public static void isfromsTosLegal(int[] froms, int[] tos) throws com.fenbi.mp4j.exception.Mp4jException {
		if (froms.length != tos.length) {
			throw new com.fenbi.mp4j.exception.Mp4jException("froms, tos's length must be equal!");
		}
		for (int i = 0; i < froms.length; i++) {
			if (froms[i] < 0) {
				throw new com.fenbi.mp4j.exception.Mp4jException("froms[i] must be >= 0!");
			}
			if (tos[i] < 0) {
				throw new com.fenbi.mp4j.exception.Mp4jException("tos[i] must be >= 0!");
			}
			if (froms[i] > tos[i]) {
				throw new com.fenbi.mp4j.exception.Mp4jException("froms[i] must be <= tos[i]!");
			}
			if (i >= 1) {
				if (froms[i] < tos[i - 1]) {
					throw new com.fenbi.mp4j.exception.Mp4jException("froms[i] must be >= to[i - 1]");
				}
			}
		}
	}

	public static void isfromsTosLegal(int[][] froms, int[][] tos, int threadNum) throws com.fenbi.mp4j.exception.Mp4jException {
		int len = froms.length;
		for (int i = 0; i < len; i++) {
			com.fenbi.mp4j.utils.CommUtils.isfromsTosLegal(froms[i], tos[i]);
			if (froms[i].length != threadNum) {
				throw new com.fenbi.mp4j.exception.Mp4jException("froms arrays must be array[slaveNum][threadNum]");
			}
			if (tos[i].length != threadNum) {
				throw new com.fenbi.mp4j.exception.Mp4jException("tos arrays must be array[slaveNum][threadNum]");
			}
		}
		int[] processFroms = new int[len];
		int[] processTos = new int[len];
		for (int i = 0; i < len; i++) {
			processFroms[i] = froms[i][0];
			processTos[i] = tos[i][tos[i].length - 1];
		}
		com.fenbi.mp4j.utils.CommUtils.isfromsTosLegal(processFroms, processTos);
	}

	public static void isFromCountsLegal(int from, int[] counts) throws com.fenbi.mp4j.exception.Mp4jException {
		if (from < 0) {
			throw new com.fenbi.mp4j.exception.Mp4jException("from must be >= 0!");
		}
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] < 0) {
				throw new com.fenbi.mp4j.exception.Mp4jException("counts[i] must be >= 0!");
			}
		}
	}

	public static void isFromCountsLegal(int from, int[][] counts) throws com.fenbi.mp4j.exception.Mp4jException {
		if (from < 0) {
			throw new com.fenbi.mp4j.exception.Mp4jException("from must be >= 0!");
		}
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i].length; j++) {
				if (counts[i][j] < 0) {
					throw new com.fenbi.mp4j.exception.Mp4jException("counts[i][j] must be >= 0!");
				}
			}
		}
	}

	public static int[] getFromsFromCount(int from, int[] counts, int slaveNum) {
		int[] froms = new int[slaveNum];
		for (int i = 0; i < slaveNum; i++) {
			froms[i] = from;
			from += counts[i];
		}
		return froms;
	}

	public static int[] getTosFromCount(int from, int[] counts, int slaveNum) {
		int[] tos = new int[slaveNum];
		for (int i = 0; i < slaveNum; i++) {
			tos[i] = from + counts[i];
			from += counts[i];
		}
		return tos;
	}

	public static void isFromToLegal(int from, int to) throws com.fenbi.mp4j.exception.Mp4jException {
		if (from < 0) {
			throw new com.fenbi.mp4j.exception.Mp4jException("from must be >= 0!");
		}
		if (to < 0) {
			throw new com.fenbi.mp4j.exception.Mp4jException("to must be >= 0!");
		}
		if (from > to) {
			throw new com.fenbi.mp4j.exception.Mp4jException("from must be <= to!");
		}
	}

	public static int[] getProcessFroms(int[][] froms) {
		int len = froms.length;
		int[] processFroms = new int[len];
		for (int i = 0; i < len; i++) {
			processFroms[i] = froms[i][0];
		}
		return processFroms;
	}

	public static int[] getProcessTos(int[][] tos) {
		int len = tos.length;
		int[] processTos = new int[len];
		for (int i = 0; i < len; i++) {
			processTos[i] = tos[i][tos[i].length - 1];
		}
		return processTos;
	}

	public static int[] createProcessArrayFroms(int size, int slaveNum) {
		int avgNum = size / slaveNum;
		int[] froms = new int[slaveNum];
		for (int r = 0; r < slaveNum; r++) {
			froms[r] = r * avgNum;
		}
		return froms;
	}

	public static int[] createProcessArrayTos(int size, int slaveNum) {
		int avgNum = size / slaveNum;
		int[] tos = new int[slaveNum];
		for (int r = 0; r < slaveNum; r++) {
			tos[r] = (r + 1) * avgNum;
			if (r == (slaveNum - 1)) {
				tos[r] = size;
			}
		}
		return tos;
	}

	public static int[][] createThreadArrayFroms(int size, int slaveNum, int threadNum) {
		int[] processFroms = com.fenbi.mp4j.utils.CommUtils.createProcessArrayFroms(size, slaveNum);
		int[] processTos = com.fenbi.mp4j.utils.CommUtils.createProcessArrayTos(size, slaveNum);
		int[][] froms = new int[slaveNum][threadNum];
		for (int r = 0; r < slaveNum; r++) {
			int processFrom = processFroms[r];
			int processTo = processTos[r];
			int processSize = processTo - processFrom;
			int[] threadFroms = com.fenbi.mp4j.utils.CommUtils.createProcessArrayFroms(processSize, threadNum);
			for (int t = 0; t < threadNum; t++) {
				threadFroms[t] += processFrom;
			}
			froms[r] = threadFroms;
		}
		return froms;
	}

	public static int[][] createThreadArrayTos(int size, int slaveNum, int threadNum) {
		int[] processFroms = com.fenbi.mp4j.utils.CommUtils.createProcessArrayFroms(size, slaveNum);
		int[] processTos = com.fenbi.mp4j.utils.CommUtils.createProcessArrayTos(size, slaveNum);
		int[][] tos = new int[slaveNum][threadNum];
		for (int r = 0; r < slaveNum; r++) {
			int processFrom = processFroms[r];
			int processTo = processTos[r];
			int processSize = processTo - processFrom;
			int[] threadTos = com.fenbi.mp4j.utils.CommUtils.createProcessArrayTos(processSize, threadNum);
			for (int t = 0; t < threadNum; t++) {
				threadTos[t] += processFrom;
			}
			tos[r] = threadTos;
		}
		return tos;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("process froms:" + java.util.Arrays.toString(com.fenbi.mp4j.utils.CommUtils.createProcessArrayFroms(101, 4)));
		java.lang.System.out.println("process tos:" + java.util.Arrays.toString(com.fenbi.mp4j.utils.CommUtils.createProcessArrayTos(101, 4)));
		int[][] froms = com.fenbi.mp4j.utils.CommUtils.createThreadArrayFroms(101, 4, 2);
		int[][] tos = com.fenbi.mp4j.utils.CommUtils.createThreadArrayTos(101, 4, 2);
		for (int i = 0; i < froms.length; i++) {
			java.lang.System.out.println((("process:" + i) + ", threadFroms:") + java.util.Arrays.toString(froms[i]));
			java.lang.System.out.println((("process:" + i) + ", threadTos:") + java.util.Arrays.toString(tos[i]));
		}
	}
}