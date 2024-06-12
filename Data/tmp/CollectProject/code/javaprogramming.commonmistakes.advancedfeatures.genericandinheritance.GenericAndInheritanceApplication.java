public class GenericAndInheritanceApplication {
	public static void main(java.lang.String[] args) {
		javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.GenericAndInheritanceApplication.wrong3();
	}

	public static void wrong1() {
		javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child1 child1 = new javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child1();
		java.util.Arrays.stream(child1.getClass().getMethods()).filter(( method) -> method.getName().equals("setValue")).forEach(( method) -> {
			try {
				method.invoke(child1, "test");
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		});
		java.lang.System.out.println(child1.toString());
	}

	public static void wrong2() {
		javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child1 child1 = new javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child1();
		java.util.Arrays.stream(child1.getClass().getDeclaredMethods()).filter(( method) -> method.getName().equals("setValue")).forEach(( method) -> {
			try {
				method.invoke(child1, "test");
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		});
		java.lang.System.out.println(child1.toString());
	}

	public static void wrong3() {
		javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child2 child2 = new javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child2();
		java.util.Arrays.stream(child2.getClass().getDeclaredMethods()).filter(( method) -> method.getName().equals("setValue")).forEach(( method) -> {
			try {
				method.invoke(child2, "test");
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		});
		java.lang.System.out.println(child2.toString());
	}

	public static void right() {
		javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child2 child2 = new javaprogramming.commonmistakes.advancedfeatures.genericandinheritance.Child2();
		java.util.Arrays.stream(child2.getClass().getDeclaredMethods()).filter(( method) -> method.getName().equals("setValue") && (!method.isBridge())).findFirst().ifPresent(( method) -> {
			try {
				method.invoke(child2, "test");
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		});
		java.lang.System.out.println(child2.toString());
	}
}