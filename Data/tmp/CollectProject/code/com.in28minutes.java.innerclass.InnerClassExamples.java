public class InnerClassExamples {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.innerclass.OuterClass.StaticNestedClass staticNestedClass1 = new com.in28minutes.java.innerclass.OuterClass.StaticNestedClass();
		staticNestedClass1.setStaticNestedClassVariable(5);
		com.in28minutes.java.innerclass.OuterClass.StaticNestedClass staticNestedClass2 = new com.in28minutes.java.innerclass.OuterClass.StaticNestedClass();
		staticNestedClass2.setStaticNestedClassVariable(10);
		java.lang.System.out.println(staticNestedClass1.getStaticNestedClassVariable());
		java.lang.System.out.println(staticNestedClass2.getStaticNestedClassVariable());
		com.in28minutes.java.innerclass.OuterClass example = new com.in28minutes.java.innerclass.OuterClass();
		com.in28minutes.java.innerclass.OuterClass.InnerClass innerClass = example.new InnerClass();
	}
}