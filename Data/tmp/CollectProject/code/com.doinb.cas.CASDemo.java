public class CASDemo {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(5);
		java.lang.System.out.println((atomicInteger.compareAndSet(5, 2019) + "\t current data: ") + atomicInteger.get());
		java.lang.System.out.println((atomicInteger.compareAndSet(2019, 1024 << 1) + "\t current data: ") + atomicInteger.get());
		java.lang.System.out.println((atomicInteger.compareAndSet(5, 1024 << 2) + "\t current data: ") + atomicInteger.get());
		atomicInteger.getAndIncrement();
	}
}