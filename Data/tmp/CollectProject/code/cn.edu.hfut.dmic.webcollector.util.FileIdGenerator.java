public class FileIdGenerator {
	protected java.io.File baseDir;

	protected java.util.concurrent.atomic.AtomicInteger lastId;

	public void initLastId() {
		lastId = new java.util.concurrent.atomic.AtomicInteger(-1);
		if (baseDir.exists()) {
			for (java.io.File file : baseDir.listFiles()) {
				int id = java.lang.Integer.valueOf(file.getName().split("\\.")[0]);
				if (id > lastId.get()) {
					lastId.set(id);
				}
			}
		}
	}

	public int generate() {
		return lastId.incrementAndGet();
	}

	public FileIdGenerator(java.io.File baseDir) {
		this.baseDir = baseDir;
		initLastId();
	}

	public FileIdGenerator(java.lang.String baseDirPath) {
		this(new java.io.File(baseDirPath));
	}

	public static void main(java.lang.String[] args) {
		cn.edu.hfut.dmic.webcollector.util.FileIdGenerator generator = new cn.edu.hfut.dmic.webcollector.util.FileIdGenerator("test");
		for (int i = 0; i < 100; i++) {
			java.lang.System.out.println(generator.generate());
		}
	}
}