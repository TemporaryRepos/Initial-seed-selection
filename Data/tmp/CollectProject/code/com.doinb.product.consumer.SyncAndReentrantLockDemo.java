public class SyncAndReentrantLockDemo {
	public static void main(java.lang.String[] args) {
		com.doinb.product.consumer.ShareResource2 shareResource = new com.doinb.product.consumer.ShareResource2();
		new java.lang.Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				shareResource.print(5, 1);
			}
		}, "AAA").start();
		new java.lang.Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				shareResource.print(10, 2);
			}
		}, "BBB").start();
		new java.lang.Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				shareResource.print(15, 3);
			}
		}, "CCC").start();
	}
}