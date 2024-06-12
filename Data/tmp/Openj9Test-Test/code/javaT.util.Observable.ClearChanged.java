public class ClearChanged extends java.util.Observable {
	boolean clearChangedCalled = false;

	public static void main(java.lang.String[] args) {
		javaT.util.Observable.ClearChanged test = new javaT.util.Observable.ClearChanged();
		test.setChanged();
		test.notifyObservers(new java.lang.Object());
		if (!test.clearChangedCalled) {
			throw new java.lang.RuntimeException("setChanged method not called.");
		}
	}

	public void clearChanged() {
		clearChangedCalled = true;
		super.clearChanged();
	}
}