public class Test6877254 {
	static byte var_1;

	static java.lang.String var_2 = "";

	static byte var_3;

	static float var_4 = 0;

	public static void main(java.lang.String[] args) {
		int i = 0;
		for (java.lang.String var_tmp = compiler.c2.Test6877254.var_2; i < 11; compiler.c2.Test6877254.var_1 = 0 , i++) {
			compiler.c2.Test6877254.var_2 = compiler.c2.Test6877254.var_2;
			compiler.c2.Test6877254.var_4 *= compiler.c2.Test6877254.var_4 *= compiler.c2.Test6877254.var_3 = 0;
		}
		java.lang.System.out.println("var_1 = " + compiler.c2.Test6877254.var_1);
		java.lang.System.out.println("var_2 = " + compiler.c2.Test6877254.var_2);
		java.lang.System.out.println("var_3 = " + compiler.c2.Test6877254.var_3);
		java.lang.System.out.println("var_4 = " + compiler.c2.Test6877254.var_4);
	}
}