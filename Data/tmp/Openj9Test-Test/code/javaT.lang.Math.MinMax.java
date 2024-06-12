public class MinMax {
	static void go(java.lang.String what, float result, float correctResult) {
		java.lang.String v = (((what + ": got ") + result) + ", expected ") + correctResult;
		if (!java.lang.Float.toString(result).equals(java.lang.Float.toString(correctResult))) {
			throw new java.lang.RuntimeException(v);
		}
		java.lang.System.err.println(v);
	}

	static void go(java.lang.String what, double result, double correctResult) {
		java.lang.String v = (((what + ": got ") + result) + ", expected ") + correctResult;
		if (!java.lang.Double.toString(result).equals(java.lang.Double.toString(correctResult))) {
			throw new java.lang.RuntimeException(v);
		}
		java.lang.System.err.println(v);
	}

	public static void main(java.lang.String[] args) {
		float fnz = -0.0F;
		float fpz = +0.0F;
		javaT.lang.Math.MinMax.go("Math.min(fnz, fnz)", java.lang.Math.min(fnz, fnz), fnz);
		javaT.lang.Math.MinMax.go("Math.min(fnz, fpz)", java.lang.Math.min(fnz, fpz), fnz);
		javaT.lang.Math.MinMax.go("Math.min(fpz, fnz)", java.lang.Math.min(fpz, fnz), fnz);
		javaT.lang.Math.MinMax.go("Math.min(fpz, fpz)", java.lang.Math.min(fpz, fpz), fpz);
		javaT.lang.Math.MinMax.go("Math.min(-1.0f, fnz)", java.lang.Math.min(-1.0F, fnz), -1.0F);
		javaT.lang.Math.MinMax.go("Math.min(-1.0f, fpz)", java.lang.Math.min(-1.0F, fpz), -1.0F);
		javaT.lang.Math.MinMax.go("Math.min(+1.0f, fnz)", java.lang.Math.min(+1.0F, fnz), fnz);
		javaT.lang.Math.MinMax.go("Math.min(+1.0f, fpz)", java.lang.Math.min(+1.0F, fpz), fpz);
		javaT.lang.Math.MinMax.go("Math.min(-1.0f, +1.0f)", java.lang.Math.min(-1.0F, +1.0F), -1.0F);
		javaT.lang.Math.MinMax.go("Math.min(fnz, -1.0f)", java.lang.Math.min(fnz, -1.0F), -1.0F);
		javaT.lang.Math.MinMax.go("Math.min(fpz, -1.0f)", java.lang.Math.min(fpz, -1.0F), -1.0F);
		javaT.lang.Math.MinMax.go("Math.min(fnz, +1.0f)", java.lang.Math.min(fnz, +1.0F), fnz);
		javaT.lang.Math.MinMax.go("Math.min(fpz, +1.0f)", java.lang.Math.min(fpz, +1.0F), fpz);
		javaT.lang.Math.MinMax.go("Math.min(+1.0f, -1.0f)", java.lang.Math.min(+1.0F, -1.0F), -1.0F);
		javaT.lang.Math.MinMax.go("Math.max(fnz, fnz)", java.lang.Math.max(fnz, fnz), fnz);
		javaT.lang.Math.MinMax.go("Math.max(fnz, fpz)", java.lang.Math.max(fnz, fpz), fpz);
		javaT.lang.Math.MinMax.go("Math.max(fpz, fnz)", java.lang.Math.max(fpz, fnz), fpz);
		javaT.lang.Math.MinMax.go("Math.max(fpz, fpz)", java.lang.Math.max(fpz, fpz), fpz);
		javaT.lang.Math.MinMax.go("Math.max(-1.0f, fnz)", java.lang.Math.max(-1.0F, fnz), fnz);
		javaT.lang.Math.MinMax.go("Math.max(-1.0f, fpz)", java.lang.Math.max(-1.0F, fpz), fpz);
		javaT.lang.Math.MinMax.go("Math.max(+1.0f, fnz)", java.lang.Math.max(+1.0F, fnz), +1.0F);
		javaT.lang.Math.MinMax.go("Math.max(+1.0f, fpz)", java.lang.Math.max(+1.0F, fpz), +1.0F);
		javaT.lang.Math.MinMax.go("Math.max(-1.0f, +1.0f)", java.lang.Math.max(-1.0F, +1.0F), +1.0F);
		javaT.lang.Math.MinMax.go("Math.max(fnz, -1.0f)", java.lang.Math.max(fnz, -1.0F), fnz);
		javaT.lang.Math.MinMax.go("Math.max(fpz, -1.0f)", java.lang.Math.max(fpz, -1.0F), fpz);
		javaT.lang.Math.MinMax.go("Math.max(fnz, +1.0f)", java.lang.Math.max(fnz, +1.0F), +1.0F);
		javaT.lang.Math.MinMax.go("Math.max(fpz, +1.0f)", java.lang.Math.max(fpz, +1.0F), +1.0F);
		javaT.lang.Math.MinMax.go("Math.max(+1.0f, -1.0f)", java.lang.Math.max(+1.0F, -1.0F), +1.0F);
		double dnz = -0.0;
		double dpz = +0.0;
		javaT.lang.Math.MinMax.go("Math.min(dnz, dnz)", java.lang.Math.min(dnz, dnz), dnz);
		javaT.lang.Math.MinMax.go("Math.min(dnz, dpz)", java.lang.Math.min(dnz, dpz), dnz);
		javaT.lang.Math.MinMax.go("Math.min(dpz, dnz)", java.lang.Math.min(dpz, dnz), dnz);
		javaT.lang.Math.MinMax.go("Math.min(dpz, dpz)", java.lang.Math.min(dpz, dpz), dpz);
		javaT.lang.Math.MinMax.go("Math.min(-1.0d, dnz)", java.lang.Math.min(-1.0, dnz), -1.0);
		javaT.lang.Math.MinMax.go("Math.min(-1.0d, dpz)", java.lang.Math.min(-1.0, dpz), -1.0);
		javaT.lang.Math.MinMax.go("Math.min(+1.0d, dnz)", java.lang.Math.min(+1.0, dnz), dnz);
		javaT.lang.Math.MinMax.go("Math.min(+1.0d, dpz)", java.lang.Math.min(+1.0, dpz), dpz);
		javaT.lang.Math.MinMax.go("Math.min(-1.0d, +1.0d)", java.lang.Math.min(-1.0, +1.0), -1.0);
		javaT.lang.Math.MinMax.go("Math.min(dnz, -1.0d)", java.lang.Math.min(dnz, -1.0), -1.0);
		javaT.lang.Math.MinMax.go("Math.min(dpz, -1.0d)", java.lang.Math.min(dpz, -1.0), -1.0);
		javaT.lang.Math.MinMax.go("Math.min(dnz, +1.0d)", java.lang.Math.min(dnz, +1.0), dnz);
		javaT.lang.Math.MinMax.go("Math.min(dpz, +1.0d)", java.lang.Math.min(dpz, +1.0), dpz);
		javaT.lang.Math.MinMax.go("Math.min(+1.0d, -1.0d)", java.lang.Math.min(+1.0, -1.0), -1.0);
		javaT.lang.Math.MinMax.go("Math.max(dnz, dnz)", java.lang.Math.max(dnz, dnz), dnz);
		javaT.lang.Math.MinMax.go("Math.max(dnz, dpz)", java.lang.Math.max(dnz, dpz), dpz);
		javaT.lang.Math.MinMax.go("Math.max(dpz, dnz)", java.lang.Math.max(dpz, dnz), dpz);
		javaT.lang.Math.MinMax.go("Math.max(dpz, dpz)", java.lang.Math.max(dpz, dpz), dpz);
		javaT.lang.Math.MinMax.go("Math.max(-1.0d, dnz)", java.lang.Math.max(-1.0, dnz), dnz);
		javaT.lang.Math.MinMax.go("Math.max(-1.0d, dpz)", java.lang.Math.max(-1.0, dpz), dpz);
		javaT.lang.Math.MinMax.go("Math.max(+1.0d, dnz)", java.lang.Math.max(+1.0, dnz), +1.0);
		javaT.lang.Math.MinMax.go("Math.max(+1.0d, dpz)", java.lang.Math.max(+1.0, dpz), +1.0);
		javaT.lang.Math.MinMax.go("Math.max(-1.0d, +1.0d)", java.lang.Math.max(-1.0, +1.0), +1.0);
		javaT.lang.Math.MinMax.go("Math.max(dnz, -1.0d)", java.lang.Math.max(dnz, -1.0), dnz);
		javaT.lang.Math.MinMax.go("Math.max(dpz, -1.0d)", java.lang.Math.max(dpz, -1.0), dpz);
		javaT.lang.Math.MinMax.go("Math.max(dnz, +1.0d)", java.lang.Math.max(dnz, +1.0), +1.0);
		javaT.lang.Math.MinMax.go("Math.max(dpz, +1.0d)", java.lang.Math.max(dpz, +1.0), +1.0);
		javaT.lang.Math.MinMax.go("Math.max(+1.0d, -1.0d)", java.lang.Math.max(+1.0, -1.0), +1.0);
	}
}