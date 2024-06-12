public class Test8168712 {
	static java.util.HashSet<compiler.runtime.Test8168712> m = new java.util.HashSet<>();

	public static void main(java.lang.String[] args) {
		int i = 0;
		while ((i++) < 15000) {
			compiler.runtime.Test8168712.test();
		} 
	}

	static compiler.runtime.Test8168712 test() {
		return new compiler.runtime.Test8168712();
	}

	protected void finalize() {
		compiler.runtime.Test8168712.m.add(this);
	}
}