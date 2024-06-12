public class Queues {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.queues.Queue myQueue = new com.thealgorithms.datastructures.queues.Queue(4);
		myQueue.insert(10);
		myQueue.insert(2);
		myQueue.insert(5);
		myQueue.insert(3);
		java.lang.System.out.println(myQueue.isFull());
		myQueue.remove();
		myQueue.insert(7);
		java.lang.System.out.println(myQueue.peekFront());
		java.lang.System.out.println(myQueue.peekRear());
		java.lang.System.out.println(myQueue);
	}
}