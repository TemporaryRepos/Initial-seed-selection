public class QueueUsingTwoStacks {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.others.QueueWithStack myQueue = new com.thealgorithms.others.QueueWithStack();
		myQueue.insert(1);
		java.lang.System.out.println(myQueue.peekBack());
		myQueue.insert(2);
		java.lang.System.out.println(myQueue.peekBack());
		myQueue.insert(3);
		java.lang.System.out.println(myQueue.peekBack());
		myQueue.insert(4);
		java.lang.System.out.println(myQueue.peekBack());
		java.lang.System.out.println(myQueue.isEmpty());
		java.lang.System.out.println(myQueue.remove());
		java.lang.System.out.println(myQueue.isInStackEmpty() ? "null" : myQueue.peekBack());
		myQueue.insert(5);
		java.lang.System.out.println(myQueue.peekFront());
		myQueue.remove();
		java.lang.System.out.println(myQueue.peekFront());
		myQueue.remove();
		java.lang.System.out.println(myQueue.peekFront());
		myQueue.remove();
		java.lang.System.out.println(myQueue.peekFront());
		myQueue.remove();
		java.lang.System.out.println(myQueue.isEmpty());
	}
}