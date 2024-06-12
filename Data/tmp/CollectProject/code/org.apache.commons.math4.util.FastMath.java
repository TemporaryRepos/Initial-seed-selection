public class FastMath {
	public static final double PI = (1.05414357E8 / 3.3554432E7) + 1.984187159361081E-9;

	public static final double E = (2850325.0 / 1048576.0) + 8.254840070411029E-8;

	static final int EXP_INT_TABLE_MAX_INDEX = 750;

	static final int EXP_INT_TABLE_LEN = org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX * 2;

	static final int LN_MANT_LEN = 1024;

	static final int EXP_FRAC_TABLE_LEN = 1025;

	private static final double LOG_MAX_VALUE = java.lang.StrictMath.log(java.lang.Double.MAX_VALUE);

	private static final boolean RECOMPUTE_TABLES_AT_RUNTIME = false;

	private static final double LN_2_A = 0.6931470632553101;

	private static final double LN_2_B = 1.1730463525082348E-7;

	private static final double[][] LN_QUICK_COEF = new double[][]{ new double[]{ 1.0, 5.669184079525E-24 }, new double[]{ -0.25, -0.25 }, new double[]{ 0.3333333134651184, 1.986821492305628E-8 }, new double[]{ -0.25, -6.663542893624021E-14 }, new double[]{ 0.19999998807907104, 1.1921056801463227E-8 }, new double[]{ -0.1666666567325592, -7.800414592973399E-9 }, new double[]{ 0.1428571343421936, 5.650007086920087E-9 }, new double[]{ -0.12502530217170715, -7.44321345601866E-11 }, new double[]{ 0.11113807559013367, 9.219544613762692E-9 } };

	private static final double[][] LN_HI_PREC_COEF = new double[][]{ new double[]{ 1.0, -6.032174644509064E-23 }, new double[]{ -0.25, -0.25 }, new double[]{ 0.3333333134651184, 1.9868161777724352E-8 }, new double[]{ -0.2499999701976776, -2.957007209750105E-8 }, new double[]{ 0.19999954104423523, 1.5830993332061267E-10 }, new double[]{ -0.16624879837036133, -2.6033824355191673E-8 } };

	private static final int SINE_TABLE_LEN = 14;

	private static final double[] SINE_TABLE_A = new double[]{ +0.0, +0.1246747374534607, +0.24740394949913025, +0.366272509098053, +0.4794255495071411, +0.5850973129272461, +0.6816387176513672, +0.7675435543060303, +0.8414709568023682, +0.902267575263977, +0.9489846229553223, +0.9808930158615112, +0.9974949359893799, +0.9985313415527344 };

	private static final double[] SINE_TABLE_B = new double[]{ +0.0, -4.068233003401932E-9, +9.755392680573412E-9, +1.9987994582857286E-8, -1.0902938113007961E-8, -3.9986783938944604E-8, +4.23719669792332E-8, -5.207000323380292E-8, +2.800552834259E-8, +1.883511811213715E-8, -3.5997360512765566E-9, +4.116164446561962E-8, +5.0614674548127384E-8, -1.0129027912496858E-9 };

	private static final double[] COSINE_TABLE_A = new double[]{ +1.0, +0.9921976327896118, +0.9689123630523682, +0.9305076599121094, +0.8775825500488281, +0.8109631538391113, +0.7316888570785522, +0.6409968137741089, +0.5403022766113281, +0.4311765432357788, +0.3153223395347595, +0.19454771280288696, +0.07073719799518585, -0.05417713522911072 };

	private static final double[] COSINE_TABLE_B = new double[]{ +0.0, +3.4439717236742845E-8, +5.865827662008209E-8, -3.7999795083850525E-8, +1.184154459111628E-8, -3.43338934259355E-8, +1.1795268640216787E-8, +4.438921624363781E-8, +2.925681159240093E-8, -2.6437112632041807E-8, +2.2860509143963117E-8, -4.813899778443457E-9, +3.6725170580355583E-9, +2.0217439756338078E-10 };

	private static final double[] TANGENT_TABLE_A = new double[]{ +0.0, +0.1256551444530487, +0.25534194707870483, +0.3936265707015991, +0.5463024377822876, +0.7214844226837158, +0.9315965175628662, +1.1974215507507324, +1.5574076175689697, +2.092571258544922, +3.0095696449279785, +5.041914939880371, +14.101419448852539, -18.430862426757812 };

	private static final double[] TANGENT_TABLE_B = new double[]{ +0.0, -7.877917738262007E-9, -2.5857668567479893E-8, +5.2240336371356666E-9, +5.206150291559893E-8, +1.8307188599677033E-8, -5.7618793749770706E-8, +7.848361555046424E-8, +1.0708593250394448E-7, +1.7827257129423813E-8, +2.893485277253286E-8, +3.1660099222737955E-7, +4.983191803254889E-7, -3.356118100840571E-7 };

	private static final long[] RECIP_2PI = new long[]{ (0x28be60dbL << 32) | 0x9391054aL, (0x7f09d5f4L << 32) | 0x7d4d3770L, (0x36d8a566L << 32) | 0x4f10e410L, (0x7f9458eaL << 32) | 0xf7aef158L, (0x6dc91b8eL << 32) | 0x909374b8L, (0x1924bbaL << 32) | 0x82746487L, (0x3f877ac7L << 32) | 0x2c4a69cfL, (0xba208d7dL << 32) | 0x4baed121L, (0x3a671c09L << 32) | 0xad17df90L, (0x4e64758eL << 32) | 0x60d4ce7dL, (0x272117e2L << 32) | 0xef7e4a0eL, (0xc7fe25ffL << 32) | 0xf7816603L, (0xfbcbc462L << 32) | 0xd6829b47L, (0xdb4d9fb3L << 32) | 0xc9f2c26dL, (0xd3d18fd9L << 32) | 0xa797fa8bL, (0x5d49eeb1L << 32) | 0xfaf97c5eL, (0xcf41ce7dL << 32) | 0xe294a4baL, 0x9afed7ecL << 32 };

	private static final long[] PI_O_4_BITS = new long[]{ (0xc90fdaa2L << 32) | 0x2168c234L, (0xc4c6628bL << 32) | 0x80dc1cd1L };

	private static final double[] EIGHTHS = new double[]{ 0, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1.0, 1.125, 1.25, 1.375, 1.5, 1.625 };

	private static final double[] CBRTTWO = new double[]{ 0.6299605249474366, 0.7937005259840998, 1.0, 1.2599210498948732, 1.5874010519681994 };

	private static final long HEX_40000000 = 0x40000000L;

	private static final long MASK_30BITS = (-1L) - (org.apache.commons.math4.util.FastMath.HEX_40000000 - 1);

	private static final int MASK_NON_SIGN_INT = 0x7fffffff;

	private static final long MASK_NON_SIGN_LONG = 0x7fffffffffffffffL;

	private static final long MASK_DOUBLE_EXPONENT = 0x7ff0000000000000L;

	private static final long MASK_DOUBLE_MANTISSA = 0xfffffffffffffL;

	private static final long IMPLICIT_HIGH_BIT = 0x10000000000000L;

	private static final double TWO_POWER_52 = 4.503599627370496E15;

	private static final double F_1_3 = 1.0 / 3.0;

	private static final double F_1_5 = 1.0 / 5.0;

	private static final double F_1_7 = 1.0 / 7.0;

	private static final double F_1_9 = 1.0 / 9.0;

	private static final double F_1_11 = 1.0 / 11.0;

	private static final double F_1_13 = 1.0 / 13.0;

	private static final double F_1_15 = 1.0 / 15.0;

	private static final double F_1_17 = 1.0 / 17.0;

	private static final double F_3_4 = 3.0 / 4.0;

	private static final double F_15_16 = 15.0 / 16.0;

	private static final double F_13_14 = 13.0 / 14.0;

	private static final double F_11_12 = 11.0 / 12.0;

	private static final double F_9_10 = 9.0 / 10.0;

	private static final double F_7_8 = 7.0 / 8.0;

	private static final double F_5_6 = 5.0 / 6.0;

	private static final double F_1_2 = 1.0 / 2.0;

	private static final double F_1_4 = 1.0 / 4.0;

	private FastMath() {
	}

	private static double doubleHighPart(double d) {
		if ((d > (-org.apache.commons.math4.util.Precision.SAFE_MIN)) && (d < org.apache.commons.math4.util.Precision.SAFE_MIN)) {
			return d;
		}
		long xl = java.lang.Double.doubleToRawLongBits(d);
		xl &= org.apache.commons.math4.util.FastMath.MASK_30BITS;
		return java.lang.Double.longBitsToDouble(xl);
	}

	public static double sqrt(final double a) {
		return java.lang.Math.sqrt(a);
	}

	public static double cosh(double x) {
		if (java.lang.Double.isNaN(x)) {
			return x;
		}
		if (x > 20) {
			if (x >= org.apache.commons.math4.util.FastMath.LOG_MAX_VALUE) {
				final double t = org.apache.commons.math4.util.FastMath.exp(0.5 * x);
				return (0.5 * t) * t;
			} else {
				return 0.5 * org.apache.commons.math4.util.FastMath.exp(x);
			}
		} else if (x < (-20)) {
			if (x <= (-org.apache.commons.math4.util.FastMath.LOG_MAX_VALUE)) {
				final double t = org.apache.commons.math4.util.FastMath.exp((-0.5) * x);
				return (0.5 * t) * t;
			} else {
				return 0.5 * org.apache.commons.math4.util.FastMath.exp(-x);
			}
		}
		final double[] hiPrec = new double[2];
		if (x < 0.0) {
			x = -x;
		}
		org.apache.commons.math4.util.FastMath.exp(x, 0.0, hiPrec);
		double ya = hiPrec[0] + hiPrec[1];
		double yb = -((ya - hiPrec[0]) - hiPrec[1]);
		double temp = ya * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double yaa = (ya + temp) - temp;
		double yab = ya - yaa;
		double recip = 1.0 / ya;
		temp = recip * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double recipa = (recip + temp) - temp;
		double recipb = recip - recipa;
		recipb += ((((1.0 - (yaa * recipa)) - (yaa * recipb)) - (yab * recipa)) - (yab * recipb)) * recip;
		recipb += ((-yb) * recip) * recip;
		temp = ya + recipa;
		yb += -((temp - ya) - recipa);
		ya = temp;
		temp = ya + recipb;
		yb += -((temp - ya) - recipb);
		ya = temp;
		double result = ya + yb;
		result *= 0.5;
		return result;
	}

	public static double sinh(double x) {
		boolean negate = false;
		if (java.lang.Double.isNaN(x)) {
			return x;
		}
		if (x > 20) {
			if (x >= org.apache.commons.math4.util.FastMath.LOG_MAX_VALUE) {
				final double t = org.apache.commons.math4.util.FastMath.exp(0.5 * x);
				return (0.5 * t) * t;
			} else {
				return 0.5 * org.apache.commons.math4.util.FastMath.exp(x);
			}
		} else if (x < (-20)) {
			if (x <= (-org.apache.commons.math4.util.FastMath.LOG_MAX_VALUE)) {
				final double t = org.apache.commons.math4.util.FastMath.exp((-0.5) * x);
				return ((-0.5) * t) * t;
			} else {
				return (-0.5) * org.apache.commons.math4.util.FastMath.exp(-x);
			}
		}
		if (x == 0) {
			return x;
		}
		if (x < 0.0) {
			x = -x;
			negate = true;
		}
		double result;
		if (x > 0.25) {
			double[] hiPrec = new double[2];
			org.apache.commons.math4.util.FastMath.exp(x, 0.0, hiPrec);
			double ya = hiPrec[0] + hiPrec[1];
			double yb = -((ya - hiPrec[0]) - hiPrec[1]);
			double temp = ya * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double yaa = (ya + temp) - temp;
			double yab = ya - yaa;
			double recip = 1.0 / ya;
			temp = recip * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double recipa = (recip + temp) - temp;
			double recipb = recip - recipa;
			recipb += ((((1.0 - (yaa * recipa)) - (yaa * recipb)) - (yab * recipa)) - (yab * recipb)) * recip;
			recipb += ((-yb) * recip) * recip;
			recipa = -recipa;
			recipb = -recipb;
			temp = ya + recipa;
			yb += -((temp - ya) - recipa);
			ya = temp;
			temp = ya + recipb;
			yb += -((temp - ya) - recipb);
			ya = temp;
			result = ya + yb;
			result *= 0.5;
		} else {
			double[] hiPrec = new double[2];
			org.apache.commons.math4.util.FastMath.expm1(x, hiPrec);
			double ya = hiPrec[0] + hiPrec[1];
			double yb = -((ya - hiPrec[0]) - hiPrec[1]);
			double denom = 1.0 + ya;
			double denomr = 1.0 / denom;
			double denomb = (-((denom - 1.0) - ya)) + yb;
			double ratio = ya * denomr;
			double temp = ratio * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double ra = (ratio + temp) - temp;
			double rb = ratio - ra;
			temp = denom * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double za = (denom + temp) - temp;
			double zb = denom - za;
			rb += ((((ya - (za * ra)) - (za * rb)) - (zb * ra)) - (zb * rb)) * denomr;
			rb += yb * denomr;
			rb += (((-ya) * denomb) * denomr) * denomr;
			temp = ya + ra;
			yb += -((temp - ya) - ra);
			ya = temp;
			temp = ya + rb;
			yb += -((temp - ya) - rb);
			ya = temp;
			result = ya + yb;
			result *= 0.5;
		}
		if (negate) {
			result = -result;
		}
		return result;
	}

	public static double tanh(double x) {
		boolean negate = false;
		if (java.lang.Double.isNaN(x)) {
			return x;
		}
		if (x > 20.0) {
			return 1.0;
		}
		if (x < (-20)) {
			return -1.0;
		}
		if (x == 0) {
			return x;
		}
		if (x < 0.0) {
			x = -x;
			negate = true;
		}
		double result;
		if (x >= 0.5) {
			double[] hiPrec = new double[2];
			org.apache.commons.math4.util.FastMath.exp(x * 2.0, 0.0, hiPrec);
			double ya = hiPrec[0] + hiPrec[1];
			double yb = -((ya - hiPrec[0]) - hiPrec[1]);
			double na = (-1.0) + ya;
			double nb = -((na + 1.0) - ya);
			double temp = na + yb;
			nb += -((temp - na) - yb);
			na = temp;
			double da = 1.0 + ya;
			double db = -((da - 1.0) - ya);
			temp = da + yb;
			db += -((temp - da) - yb);
			da = temp;
			temp = da * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double daa = (da + temp) - temp;
			double dab = da - daa;
			double ratio = na / da;
			temp = ratio * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double ratioa = (ratio + temp) - temp;
			double ratiob = ratio - ratioa;
			ratiob += ((((na - (daa * ratioa)) - (daa * ratiob)) - (dab * ratioa)) - (dab * ratiob)) / da;
			ratiob += nb / da;
			ratiob += (((-db) * na) / da) / da;
			result = ratioa + ratiob;
		} else {
			double[] hiPrec = new double[2];
			org.apache.commons.math4.util.FastMath.expm1(x * 2.0, hiPrec);
			double ya = hiPrec[0] + hiPrec[1];
			double yb = -((ya - hiPrec[0]) - hiPrec[1]);
			double na = ya;
			double nb = yb;
			double da = 2.0 + ya;
			double db = -((da - 2.0) - ya);
			double temp = da + yb;
			db += -((temp - da) - yb);
			da = temp;
			temp = da * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double daa = (da + temp) - temp;
			double dab = da - daa;
			double ratio = na / da;
			temp = ratio * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double ratioa = (ratio + temp) - temp;
			double ratiob = ratio - ratioa;
			ratiob += ((((na - (daa * ratioa)) - (daa * ratiob)) - (dab * ratioa)) - (dab * ratiob)) / da;
			ratiob += nb / da;
			ratiob += (((-db) * na) / da) / da;
			result = ratioa + ratiob;
		}
		if (negate) {
			result = -result;
		}
		return result;
	}

	public static double acosh(final double a) {
		return org.apache.commons.math4.util.FastMath.log(a + org.apache.commons.math4.util.FastMath.sqrt((a * a) - 1));
	}

	public static double asinh(double a) {
		boolean negative = false;
		if (a < 0) {
			negative = true;
			a = -a;
		}
		double absAsinh;
		if (a > 0.167) {
			absAsinh = org.apache.commons.math4.util.FastMath.log(org.apache.commons.math4.util.FastMath.sqrt((a * a) + 1) + a);
		} else {
			final double a2 = a * a;
			if (a > 0.097) {
				absAsinh = a * (1 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_3 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_5 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_7 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_9 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_11 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_13 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_15 - ((a2 * org.apache.commons.math4.util.FastMath.F_1_17) * org.apache.commons.math4.util.FastMath.F_15_16))) * org.apache.commons.math4.util.FastMath.F_13_14))) * org.apache.commons.math4.util.FastMath.F_11_12))) * org.apache.commons.math4.util.FastMath.F_9_10))) * org.apache.commons.math4.util.FastMath.F_7_8))) * org.apache.commons.math4.util.FastMath.F_5_6))) * org.apache.commons.math4.util.FastMath.F_3_4))) * org.apache.commons.math4.util.FastMath.F_1_2));
			} else if (a > 0.036) {
				absAsinh = a * (1 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_3 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_5 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_7 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_9 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_11 - ((a2 * org.apache.commons.math4.util.FastMath.F_1_13) * org.apache.commons.math4.util.FastMath.F_11_12))) * org.apache.commons.math4.util.FastMath.F_9_10))) * org.apache.commons.math4.util.FastMath.F_7_8))) * org.apache.commons.math4.util.FastMath.F_5_6))) * org.apache.commons.math4.util.FastMath.F_3_4))) * org.apache.commons.math4.util.FastMath.F_1_2));
			} else if (a > 0.0036) {
				absAsinh = a * (1 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_3 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_5 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_7 - ((a2 * org.apache.commons.math4.util.FastMath.F_1_9) * org.apache.commons.math4.util.FastMath.F_7_8))) * org.apache.commons.math4.util.FastMath.F_5_6))) * org.apache.commons.math4.util.FastMath.F_3_4))) * org.apache.commons.math4.util.FastMath.F_1_2));
			} else {
				absAsinh = a * (1 - ((a2 * (org.apache.commons.math4.util.FastMath.F_1_3 - ((a2 * org.apache.commons.math4.util.FastMath.F_1_5) * org.apache.commons.math4.util.FastMath.F_3_4))) * org.apache.commons.math4.util.FastMath.F_1_2));
			}
		}
		return negative ? -absAsinh : absAsinh;
	}

	public static double atanh(double a) {
		boolean negative = false;
		if (a < 0) {
			negative = true;
			a = -a;
		}
		double absAtanh;
		if (a > 0.15) {
			absAtanh = 0.5 * org.apache.commons.math4.util.FastMath.log((1 + a) / (1 - a));
		} else {
			final double a2 = a * a;
			if (a > 0.087) {
				absAtanh = a * (1 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_3 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_5 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_7 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_9 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_11 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_13 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_15 + (a2 * org.apache.commons.math4.util.FastMath.F_1_17))))))))))))))));
			} else if (a > 0.031) {
				absAtanh = a * (1 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_3 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_5 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_7 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_9 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_11 + (a2 * org.apache.commons.math4.util.FastMath.F_1_13))))))))))));
			} else if (a > 0.003) {
				absAtanh = a * (1 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_3 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_5 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_7 + (a2 * org.apache.commons.math4.util.FastMath.F_1_9))))))));
			} else {
				absAtanh = a * (1 + (a2 * (org.apache.commons.math4.util.FastMath.F_1_3 + (a2 * org.apache.commons.math4.util.FastMath.F_1_5))));
			}
		}
		return negative ? -absAtanh : absAtanh;
	}

	public static double signum(final double a) {
		return a < 0.0 ? -1.0 : a > 0.0 ? 1.0 : a;
	}

	public static float signum(final float a) {
		return a < 0.0F ? -1.0F : a > 0.0F ? 1.0F : a;
	}

	public static double nextUp(final double a) {
		return org.apache.commons.math4.util.FastMath.nextAfter(a, java.lang.Double.POSITIVE_INFINITY);
	}

	public static float nextUp(final float a) {
		return org.apache.commons.math4.util.FastMath.nextAfter(a, java.lang.Float.POSITIVE_INFINITY);
	}

	public static double nextDown(final double a) {
		return org.apache.commons.math4.util.FastMath.nextAfter(a, java.lang.Double.NEGATIVE_INFINITY);
	}

	public static float nextDown(final float a) {
		return org.apache.commons.math4.util.FastMath.nextAfter(a, java.lang.Float.NEGATIVE_INFINITY);
	}

	public static double random() {
		return java.lang.Math.random();
	}

	public static double exp(double x) {
		return org.apache.commons.math4.util.FastMath.exp(x, 0.0, null);
	}

	private static double exp(double x, double extra, double[] hiPrec) {
		double intPartA;
		double intPartB;
		int intVal = ((int) (x));
		if (x < 0.0) {
			if (x < (-746.0)) {
				if (hiPrec != null) {
					hiPrec[0] = 0.0;
					hiPrec[1] = 0.0;
				}
				return 0.0;
			}
			if (intVal < (-709)) {
				final double result = org.apache.commons.math4.util.FastMath.exp(x + 40.19140625, extra, hiPrec) / 2.85040095144011776E17;
				if (hiPrec != null) {
					hiPrec[0] /= 2.85040095144011776E17;
					hiPrec[1] /= 2.85040095144011776E17;
				}
				return result;
			}
			if (intVal == (-709)) {
				final double result = org.apache.commons.math4.util.FastMath.exp(x + 1.494140625, extra, hiPrec) / 4.455505956692757;
				if (hiPrec != null) {
					hiPrec[0] /= 4.455505956692757;
					hiPrec[1] /= 4.455505956692757;
				}
				return result;
			}
			intVal--;
		} else if (intVal > 709) {
			if (hiPrec != null) {
				hiPrec[0] = java.lang.Double.POSITIVE_INFINITY;
				hiPrec[1] = 0.0;
			}
			return java.lang.Double.POSITIVE_INFINITY;
		}
		intPartA = org.apache.commons.math4.util.FastMath.ExpIntTable.EXP_INT_TABLE_A[org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX + intVal];
		intPartB = org.apache.commons.math4.util.FastMath.ExpIntTable.EXP_INT_TABLE_B[org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX + intVal];
		final int intFrac = ((int) ((x - intVal) * 1024.0));
		final double fracPartA = org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_A[intFrac];
		final double fracPartB = org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_B[intFrac];
		final double epsilon = x - (intVal + (intFrac / 1024.0));
		double z = 0.04168701738764507;
		z = (z * epsilon) + 0.1666666505023083;
		z = (z * epsilon) + 0.5000000000042687;
		z = (z * epsilon) + 1.0;
		z = (z * epsilon) + (-3.940510424527919E-20);
		double tempA = intPartA * fracPartA;
		double tempB = ((intPartA * fracPartB) + (intPartB * fracPartA)) + (intPartB * fracPartB);
		final double tempC = tempB + tempA;
		if (tempC == java.lang.Double.POSITIVE_INFINITY) {
			return java.lang.Double.POSITIVE_INFINITY;
		}
		final double result;
		if (extra != 0.0) {
			result = (((((tempC * extra) * z) + (tempC * extra)) + (tempC * z)) + tempB) + tempA;
		} else {
			result = ((tempC * z) + tempB) + tempA;
		}
		if (hiPrec != null) {
			hiPrec[0] = tempA;
			hiPrec[1] = ((((tempC * extra) * z) + (tempC * extra)) + (tempC * z)) + tempB;
		}
		return result;
	}

	public static double expm1(double x) {
		return org.apache.commons.math4.util.FastMath.expm1(x, null);
	}

	private static double expm1(double x, double[] hiPrecOut) {
		if (java.lang.Double.isNaN(x) || (x == 0.0)) {
			return x;
		}
		if ((x <= (-1.0)) || (x >= 1.0)) {
			double[] hiPrec = new double[2];
			org.apache.commons.math4.util.FastMath.exp(x, 0.0, hiPrec);
			if (x > 0.0) {
				return ((-1.0) + hiPrec[0]) + hiPrec[1];
			} else {
				final double ra = (-1.0) + hiPrec[0];
				double rb = -((ra + 1.0) - hiPrec[0]);
				rb += hiPrec[1];
				return ra + rb;
			}
		}
		double baseA;
		double baseB;
		double epsilon;
		boolean negative = false;
		if (x < 0.0) {
			x = -x;
			negative = true;
		}
		{
			int intFrac = ((int) (x * 1024.0));
			double tempA = org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_A[intFrac] - 1.0;
			double tempB = org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_B[intFrac];
			double temp = tempA + tempB;
			tempB = -((temp - tempA) - tempB);
			tempA = temp;
			temp = tempA * org.apache.commons.math4.util.FastMath.HEX_40000000;
			baseA = (tempA + temp) - temp;
			baseB = tempB + (tempA - baseA);
			epsilon = x - (intFrac / 1024.0);
		}
		double zb = 0.008336750013465571;
		zb = (zb * epsilon) + 0.041666663879186654;
		zb = (zb * epsilon) + 0.16666666666745392;
		zb = (zb * epsilon) + 0.49999999999999994;
		zb *= epsilon;
		zb *= epsilon;
		double za = epsilon;
		double temp = za + zb;
		zb = -((temp - za) - zb);
		za = temp;
		temp = za * org.apache.commons.math4.util.FastMath.HEX_40000000;
		temp = (za + temp) - temp;
		zb += za - temp;
		za = temp;
		double ya = za * baseA;
		temp = ya + (za * baseB);
		double yb = -((temp - ya) - (za * baseB));
		ya = temp;
		temp = ya + (zb * baseA);
		yb += -((temp - ya) - (zb * baseA));
		ya = temp;
		temp = ya + (zb * baseB);
		yb += -((temp - ya) - (zb * baseB));
		ya = temp;
		temp = ya + baseA;
		yb += -((temp - baseA) - ya);
		ya = temp;
		temp = ya + za;
		yb += -((temp - ya) - za);
		ya = temp;
		temp = ya + baseB;
		yb += -((temp - ya) - baseB);
		ya = temp;
		temp = ya + zb;
		yb += -((temp - ya) - zb);
		ya = temp;
		if (negative) {
			double denom = 1.0 + ya;
			double denomr = 1.0 / denom;
			double denomb = (-((denom - 1.0) - ya)) + yb;
			double ratio = ya * denomr;
			temp = ratio * org.apache.commons.math4.util.FastMath.HEX_40000000;
			final double ra = (ratio + temp) - temp;
			double rb = ratio - ra;
			temp = denom * org.apache.commons.math4.util.FastMath.HEX_40000000;
			za = (denom + temp) - temp;
			zb = denom - za;
			rb += ((((ya - (za * ra)) - (za * rb)) - (zb * ra)) - (zb * rb)) * denomr;
			rb += yb * denomr;
			rb += (((-ya) * denomb) * denomr) * denomr;
			ya = -ra;
			yb = -rb;
		}
		if (hiPrecOut != null) {
			hiPrecOut[0] = ya;
			hiPrecOut[1] = yb;
		}
		return ya + yb;
	}

	public static double log(final double x) {
		return org.apache.commons.math4.util.FastMath.log(x, null);
	}

	private static double log(final double x, final double[] hiPrec) {
		if (x == 0) {
			return java.lang.Double.NEGATIVE_INFINITY;
		}
		long bits = java.lang.Double.doubleToRawLongBits(x);
		if ((((bits & 0x8000000000000000L) != 0) || java.lang.Double.isNaN(x)) && (x != 0.0)) {
			if (hiPrec != null) {
				hiPrec[0] = java.lang.Double.NaN;
			}
			return java.lang.Double.NaN;
		}
		if (x == java.lang.Double.POSITIVE_INFINITY) {
			if (hiPrec != null) {
				hiPrec[0] = java.lang.Double.POSITIVE_INFINITY;
			}
			return java.lang.Double.POSITIVE_INFINITY;
		}
		int exp = ((int) (bits >> 52)) - 1023;
		if ((bits & 0x7ff0000000000000L) == 0) {
			if (x == 0) {
				if (hiPrec != null) {
					hiPrec[0] = java.lang.Double.NEGATIVE_INFINITY;
				}
				return java.lang.Double.NEGATIVE_INFINITY;
			}
			bits <<= 1;
			while ((bits & 0x10000000000000L) == 0) {
				--exp;
				bits <<= 1;
			} 
		}
		if (((((exp == (-1)) || (exp == 0)) && (x < 1.01)) && (x > 0.99)) && (hiPrec == null)) {
			double xa = x - 1.0;
			double xb = (xa - x) + 1.0;
			double tmp = xa * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double aa = (xa + tmp) - tmp;
			double ab = xa - aa;
			xa = aa;
			xb = ab;
			final double[] lnCoef_last = org.apache.commons.math4.util.FastMath.LN_QUICK_COEF[org.apache.commons.math4.util.FastMath.LN_QUICK_COEF.length - 1];
			double ya = lnCoef_last[0];
			double yb = lnCoef_last[1];
			for (int i = org.apache.commons.math4.util.FastMath.LN_QUICK_COEF.length - 2; i >= 0; i--) {
				aa = ya * xa;
				ab = ((ya * xb) + (yb * xa)) + (yb * xb);
				tmp = aa * org.apache.commons.math4.util.FastMath.HEX_40000000;
				ya = (aa + tmp) - tmp;
				yb = (aa - ya) + ab;
				final double[] lnCoef_i = org.apache.commons.math4.util.FastMath.LN_QUICK_COEF[i];
				aa = ya + lnCoef_i[0];
				ab = yb + lnCoef_i[1];
				tmp = aa * org.apache.commons.math4.util.FastMath.HEX_40000000;
				ya = (aa + tmp) - tmp;
				yb = (aa - ya) + ab;
			}
			aa = ya * xa;
			ab = ((ya * xb) + (yb * xa)) + (yb * xb);
			tmp = aa * org.apache.commons.math4.util.FastMath.HEX_40000000;
			ya = (aa + tmp) - tmp;
			yb = (aa - ya) + ab;
			return ya + yb;
		}
		final double[] lnm = org.apache.commons.math4.util.FastMath.lnMant.LN_MANT[((int) ((bits & 0xffc0000000000L) >> 42))];
		final double epsilon = (bits & 0x3ffffffffffL) / (org.apache.commons.math4.util.FastMath.TWO_POWER_52 + (bits & 0xffc0000000000L));
		double lnza = 0.0;
		double lnzb = 0.0;
		if (hiPrec != null) {
			double tmp = epsilon * org.apache.commons.math4.util.FastMath.HEX_40000000;
			double aa = (epsilon + tmp) - tmp;
			double ab = epsilon - aa;
			double xa = aa;
			double xb = ab;
			final double numer = bits & 0x3ffffffffffL;
			final double denom = org.apache.commons.math4.util.FastMath.TWO_POWER_52 + (bits & 0xffc0000000000L);
			aa = (numer - (xa * denom)) - (xb * denom);
			xb += aa / denom;
			final double[] lnCoef_last = org.apache.commons.math4.util.FastMath.LN_HI_PREC_COEF[org.apache.commons.math4.util.FastMath.LN_HI_PREC_COEF.length - 1];
			double ya = lnCoef_last[0];
			double yb = lnCoef_last[1];
			for (int i = org.apache.commons.math4.util.FastMath.LN_HI_PREC_COEF.length - 2; i >= 0; i--) {
				aa = ya * xa;
				ab = ((ya * xb) + (yb * xa)) + (yb * xb);
				tmp = aa * org.apache.commons.math4.util.FastMath.HEX_40000000;
				ya = (aa + tmp) - tmp;
				yb = (aa - ya) + ab;
				final double[] lnCoef_i = org.apache.commons.math4.util.FastMath.LN_HI_PREC_COEF[i];
				aa = ya + lnCoef_i[0];
				ab = yb + lnCoef_i[1];
				tmp = aa * org.apache.commons.math4.util.FastMath.HEX_40000000;
				ya = (aa + tmp) - tmp;
				yb = (aa - ya) + ab;
			}
			aa = ya * xa;
			ab = ((ya * xb) + (yb * xa)) + (yb * xb);
			lnza = aa + ab;
			lnzb = -((lnza - aa) - ab);
		} else {
			lnza = -0.16624882440418567;
			lnza = (lnza * epsilon) + 0.19999954120254515;
			lnza = (lnza * epsilon) + (-0.2499999997677497);
			lnza = (lnza * epsilon) + 0.3333333333332802;
			lnza = (lnza * epsilon) + (-0.5);
			lnza = (lnza * epsilon) + 1.0;
			lnza *= epsilon;
		}
		double a = org.apache.commons.math4.util.FastMath.LN_2_A * exp;
		double b = 0.0;
		double c = a + lnm[0];
		double d = -((c - a) - lnm[0]);
		a = c;
		b += d;
		c = a + lnza;
		d = -((c - a) - lnza);
		a = c;
		b += d;
		c = a + (org.apache.commons.math4.util.FastMath.LN_2_B * exp);
		d = -((c - a) - (org.apache.commons.math4.util.FastMath.LN_2_B * exp));
		a = c;
		b += d;
		c = a + lnm[1];
		d = -((c - a) - lnm[1]);
		a = c;
		b += d;
		c = a + lnzb;
		d = -((c - a) - lnzb);
		a = c;
		b += d;
		if (hiPrec != null) {
			hiPrec[0] = a;
			hiPrec[1] = b;
		}
		return a + b;
	}

	public static double log1p(final double x) {
		if (x == (-1)) {
			return java.lang.Double.NEGATIVE_INFINITY;
		}
		if (x == java.lang.Double.POSITIVE_INFINITY) {
			return java.lang.Double.POSITIVE_INFINITY;
		}
		if ((x > 1.0E-6) || (x < (-1.0E-6))) {
			final double xpa = 1 + x;
			final double xpb = -((xpa - 1) - x);
			final double[] hiPrec = new double[2];
			final double lores = org.apache.commons.math4.util.FastMath.log(xpa, hiPrec);
			if (java.lang.Double.isInfinite(lores)) {
				return lores;
			}
			final double fx1 = xpb / xpa;
			final double epsilon = (0.5 * fx1) + 1;
			return ((epsilon * fx1) + hiPrec[1]) + hiPrec[0];
		} else {
			final double y = (((x * org.apache.commons.math4.util.FastMath.F_1_3) - org.apache.commons.math4.util.FastMath.F_1_2) * x) + 1;
			return y * x;
		}
	}

	public static double log10(final double x) {
		final double[] hiPrec = new double[2];
		final double lores = org.apache.commons.math4.util.FastMath.log(x, hiPrec);
		if (java.lang.Double.isInfinite(lores)) {
			return lores;
		}
		final double tmp = hiPrec[0] * org.apache.commons.math4.util.FastMath.HEX_40000000;
		final double lna = (hiPrec[0] + tmp) - tmp;
		final double lnb = (hiPrec[0] - lna) + hiPrec[1];
		final double rln10a = 0.4342944622039795;
		final double rln10b = 1.9699272335463627E-8;
		return (((rln10b * lnb) + (rln10b * lna)) + (rln10a * lnb)) + (rln10a * lna);
	}

	public static double log(double base, double x) {
		return org.apache.commons.math4.util.FastMath.log(x) / org.apache.commons.math4.util.FastMath.log(base);
	}

	public static double pow(final double x, final double y) {
		if (y == 0) {
			return 1.0;
		} else {
			final long yBits = java.lang.Double.doubleToRawLongBits(y);
			final int yRawExp = ((int) ((yBits & org.apache.commons.math4.util.FastMath.MASK_DOUBLE_EXPONENT) >> 52));
			final long yRawMantissa = yBits & org.apache.commons.math4.util.FastMath.MASK_DOUBLE_MANTISSA;
			final long xBits = java.lang.Double.doubleToRawLongBits(x);
			final int xRawExp = ((int) ((xBits & org.apache.commons.math4.util.FastMath.MASK_DOUBLE_EXPONENT) >> 52));
			final long xRawMantissa = xBits & org.apache.commons.math4.util.FastMath.MASK_DOUBLE_MANTISSA;
			if (yRawExp > 1085) {
				if (((yRawExp == 2047) && (yRawMantissa != 0)) || ((xRawExp == 2047) && (xRawMantissa != 0))) {
					return java.lang.Double.NaN;
				} else if ((xRawExp == 1023) && (xRawMantissa == 0)) {
					if (yRawExp == 2047) {
						return java.lang.Double.NaN;
					} else {
						return 1.0;
					}
				} else if ((y > 0) ^ (xRawExp < 1023)) {
					return java.lang.Double.POSITIVE_INFINITY;
				} else {
					return +0.0;
				}
			} else {
				if (yRawExp >= 1023) {
					final long yFullMantissa = org.apache.commons.math4.util.FastMath.IMPLICIT_HIGH_BIT | yRawMantissa;
					if (yRawExp < 1075) {
						final long integralMask = (-1L) << (1075 - yRawExp);
						if ((yFullMantissa & integralMask) == yFullMantissa) {
							final long l = yFullMantissa >> (1075 - yRawExp);
							return org.apache.commons.math4.util.FastMath.pow(x, y < 0 ? -l : l);
						}
					} else {
						final long l = yFullMantissa << (yRawExp - 1075);
						return org.apache.commons.math4.util.FastMath.pow(x, y < 0 ? -l : l);
					}
				}
				if (x == 0) {
					return y < 0 ? java.lang.Double.POSITIVE_INFINITY : +0.0;
				} else if (xRawExp == 2047) {
					if (xRawMantissa == 0) {
						return y < 0 ? +0.0 : java.lang.Double.POSITIVE_INFINITY;
					} else {
						return java.lang.Double.NaN;
					}
				} else if (x < 0) {
					return java.lang.Double.NaN;
				} else {
					final double tmp = y * org.apache.commons.math4.util.FastMath.HEX_40000000;
					final double ya = (y + tmp) - tmp;
					final double yb = y - ya;
					final double[] lns = new double[2];
					final double lores = org.apache.commons.math4.util.FastMath.log(x, lns);
					if (java.lang.Double.isInfinite(lores)) {
						return lores;
					}
					double lna = lns[0];
					double lnb = lns[1];
					final double tmp1 = lna * org.apache.commons.math4.util.FastMath.HEX_40000000;
					final double tmp2 = (lna + tmp1) - tmp1;
					lnb += lna - tmp2;
					lna = tmp2;
					final double aa = lna * ya;
					final double ab = ((lna * yb) + (lnb * ya)) + (lnb * yb);
					lna = aa + ab;
					lnb = -((lna - aa) - ab);
					double z = 1.0 / 120.0;
					z = (z * lnb) + (1.0 / 24.0);
					z = (z * lnb) + (1.0 / 6.0);
					z = (z * lnb) + 0.5;
					z = (z * lnb) + 1.0;
					z *= lnb;
					final double result = org.apache.commons.math4.util.FastMath.exp(lna, z, null);
					return result;
				}
			}
		}
	}

	public static double pow(double d, int e) {
		return org.apache.commons.math4.util.FastMath.pow(d, ((long) (e)));
	}

	public static double pow(double d, long e) {
		if (e == 0) {
			return 1.0;
		} else if (e > 0) {
			return new org.apache.commons.math4.util.FastMath.Split(d).pow(e).full;
		} else {
			return new org.apache.commons.math4.util.FastMath.Split(d).reciprocal().pow(-e).full;
		}
	}

	private static class Split {
		public static final org.apache.commons.math4.util.FastMath.Split NAN = new org.apache.commons.math4.util.FastMath.Split(java.lang.Double.NaN, 0);

		public static final org.apache.commons.math4.util.FastMath.Split POSITIVE_INFINITY = new org.apache.commons.math4.util.FastMath.Split(java.lang.Double.POSITIVE_INFINITY, 0);

		public static final org.apache.commons.math4.util.FastMath.Split NEGATIVE_INFINITY = new org.apache.commons.math4.util.FastMath.Split(java.lang.Double.NEGATIVE_INFINITY, 0);

		private final double full;

		private final double high;

		private final double low;

		Split(final double x) {
			full = x;
			high = java.lang.Double.longBitsToDouble(java.lang.Double.doubleToRawLongBits(x) & ((-1L) << 27));
			low = x - high;
		}

		Split(final double high, final double low) {
			this(high == 0.0 ? (low == 0.0) && (java.lang.Double.doubleToRawLongBits(high) == java.lang.Long.MIN_VALUE) ? -0.0 : low : high + low, high, low);
		}

		Split(final double full, final double high, final double low) {
			this.full = full;
			this.high = high;
			this.low = low;
		}

		public org.apache.commons.math4.util.FastMath.Split multiply(final org.apache.commons.math4.util.FastMath.Split b) {
			final org.apache.commons.math4.util.FastMath.Split mulBasic = new org.apache.commons.math4.util.FastMath.Split(full * b.full);
			final double mulError = (low * b.low) - (((mulBasic.full - (high * b.high)) - (low * b.high)) - (high * b.low));
			return new org.apache.commons.math4.util.FastMath.Split(mulBasic.high, mulBasic.low + mulError);
		}

		public org.apache.commons.math4.util.FastMath.Split reciprocal() {
			final double approximateInv = 1.0 / full;
			final org.apache.commons.math4.util.FastMath.Split splitInv = new org.apache.commons.math4.util.FastMath.Split(approximateInv);
			final org.apache.commons.math4.util.FastMath.Split product = multiply(splitInv);
			final double error = (product.high - 1) + product.low;
			return java.lang.Double.isNaN(error) ? splitInv : new org.apache.commons.math4.util.FastMath.Split(splitInv.high, splitInv.low - (error / full));
		}

		private org.apache.commons.math4.util.FastMath.Split pow(final long e) {
			org.apache.commons.math4.util.FastMath.Split result = new org.apache.commons.math4.util.FastMath.Split(1);
			org.apache.commons.math4.util.FastMath.Split d2p = new org.apache.commons.math4.util.FastMath.Split(full, high, low);
			for (long p = e; p != 0; p >>>= 1) {
				if ((p & 0x1) != 0) {
					result = result.multiply(d2p);
				}
				d2p = d2p.multiply(d2p);
			}
			if (java.lang.Double.isNaN(result.full)) {
				if (java.lang.Double.isNaN(full)) {
					return org.apache.commons.math4.util.FastMath.Split.NAN;
				} else if (org.apache.commons.math4.util.FastMath.abs(full) < 1) {
					return new org.apache.commons.math4.util.FastMath.Split(org.apache.commons.math4.util.FastMath.copySign(0.0, full), 0.0);
				} else if ((full < 0) && ((e & 0x1) == 1)) {
					return org.apache.commons.math4.util.FastMath.Split.NEGATIVE_INFINITY;
				} else {
					return org.apache.commons.math4.util.FastMath.Split.POSITIVE_INFINITY;
				}
			} else {
				return result;
			}
		}
	}

	private static double polySine(final double x) {
		double x2 = x * x;
		double p = 2.7553817452272217E-6;
		p = (p * x2) + (-1.9841269659586505E-4);
		p = (p * x2) + 0.008333333333329196;
		p = (p * x2) + (-0.16666666666666666);
		p = (p * x2) * x;
		return p;
	}

	private static double polyCosine(double x) {
		double x2 = x * x;
		double p = 2.479773539153719E-5;
		p = (p * x2) + (-0.0013888888689039883);
		p = (p * x2) + 0.041666666666621166;
		p = (p * x2) + (-0.49999999999999994);
		p *= x2;
		return p;
	}

	private static double sinQ(double xa, double xb) {
		int idx = ((int) ((xa * 8.0) + 0.5));
		final double epsilon = xa - org.apache.commons.math4.util.FastMath.EIGHTHS[idx];
		final double sintA = org.apache.commons.math4.util.FastMath.SINE_TABLE_A[idx];
		final double sintB = org.apache.commons.math4.util.FastMath.SINE_TABLE_B[idx];
		final double costA = org.apache.commons.math4.util.FastMath.COSINE_TABLE_A[idx];
		final double costB = org.apache.commons.math4.util.FastMath.COSINE_TABLE_B[idx];
		double sinEpsA = epsilon;
		double sinEpsB = org.apache.commons.math4.util.FastMath.polySine(epsilon);
		final double cosEpsA = 1.0;
		final double cosEpsB = org.apache.commons.math4.util.FastMath.polyCosine(epsilon);
		final double temp = sinEpsA * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double temp2 = (sinEpsA + temp) - temp;
		sinEpsB += sinEpsA - temp2;
		sinEpsA = temp2;
		double result;
		double a = 0;
		double b = 0;
		double t = sintA;
		double c = a + t;
		double d = -((c - a) - t);
		a = c;
		b += d;
		t = costA * sinEpsA;
		c = a + t;
		d = -((c - a) - t);
		a = c;
		b += d;
		b = (b + (sintA * cosEpsB)) + (costA * sinEpsB);
		b = (((b + sintB) + (costB * sinEpsA)) + (sintB * cosEpsB)) + (costB * sinEpsB);
		if (xb != 0.0) {
			t = (((costA + costB) * (cosEpsA + cosEpsB)) - ((sintA + sintB) * (sinEpsA + sinEpsB))) * xb;
			c = a + t;
			d = -((c - a) - t);
			a = c;
			b += d;
		}
		result = a + b;
		return result;
	}

	private static double cosQ(double xa, double xb) {
		final double pi2a = 1.5707963267948966;
		final double pi2b = 6.123233995736766E-17;
		final double a = pi2a - xa;
		double b = -((a - pi2a) + xa);
		b += pi2b - xb;
		return org.apache.commons.math4.util.FastMath.sinQ(a, b);
	}

	private static double tanQ(double xa, double xb, boolean cotanFlag) {
		int idx = ((int) ((xa * 8.0) + 0.5));
		final double epsilon = xa - org.apache.commons.math4.util.FastMath.EIGHTHS[idx];
		final double sintA = org.apache.commons.math4.util.FastMath.SINE_TABLE_A[idx];
		final double sintB = org.apache.commons.math4.util.FastMath.SINE_TABLE_B[idx];
		final double costA = org.apache.commons.math4.util.FastMath.COSINE_TABLE_A[idx];
		final double costB = org.apache.commons.math4.util.FastMath.COSINE_TABLE_B[idx];
		double sinEpsA = epsilon;
		double sinEpsB = org.apache.commons.math4.util.FastMath.polySine(epsilon);
		final double cosEpsA = 1.0;
		final double cosEpsB = org.apache.commons.math4.util.FastMath.polyCosine(epsilon);
		double temp = sinEpsA * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double temp2 = (sinEpsA + temp) - temp;
		sinEpsB += sinEpsA - temp2;
		sinEpsA = temp2;
		double a = 0;
		double b = 0;
		double t = sintA;
		double c = a + t;
		double d = -((c - a) - t);
		a = c;
		b += d;
		t = costA * sinEpsA;
		c = a + t;
		d = -((c - a) - t);
		a = c;
		b += d;
		b += (sintA * cosEpsB) + (costA * sinEpsB);
		b += ((sintB + (costB * sinEpsA)) + (sintB * cosEpsB)) + (costB * sinEpsB);
		double sina = a + b;
		double sinb = -((sina - a) - b);
		a = b = c = d = 0.0;
		t = costA * cosEpsA;
		c = a + t;
		d = -((c - a) - t);
		a = c;
		b += d;
		t = (-sintA) * sinEpsA;
		c = a + t;
		d = -((c - a) - t);
		a = c;
		b += d;
		b += ((costB * cosEpsA) + (costA * cosEpsB)) + (costB * cosEpsB);
		b -= ((sintB * sinEpsA) + (sintA * sinEpsB)) + (sintB * sinEpsB);
		double cosa = a + b;
		double cosb = -((cosa - a) - b);
		if (cotanFlag) {
			double tmp;
			tmp = cosa;
			cosa = sina;
			sina = tmp;
			tmp = cosb;
			cosb = sinb;
			sinb = tmp;
		}
		double est = sina / cosa;
		temp = est * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double esta = (est + temp) - temp;
		double estb = est - esta;
		temp = cosa * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double cosaa = (cosa + temp) - temp;
		double cosab = cosa - cosaa;
		double err = ((((sina - (esta * cosaa)) - (esta * cosab)) - (estb * cosaa)) - (estb * cosab)) / cosa;
		err += sinb / cosa;
		err += (((-sina) * cosb) / cosa) / cosa;
		if (xb != 0.0) {
			double xbadj = xb + ((est * est) * xb);
			if (cotanFlag) {
				xbadj = -xbadj;
			}
			err += xbadj;
		}
		return est + err;
	}

	private static void reducePayneHanek(double x, double[] result) {
		long inbits = java.lang.Double.doubleToRawLongBits(x);
		int exponent = ((int) ((inbits >> 52) & 0x7ff)) - 1023;
		inbits &= 0xfffffffffffffL;
		inbits |= 0x10000000000000L;
		exponent++;
		inbits <<= 11;
		long shpi0;
		long shpiA;
		long shpiB;
		int idx = exponent >> 6;
		int shift = exponent - (idx << 6);
		if (shift != 0) {
			shpi0 = (idx == 0) ? 0 : org.apache.commons.math4.util.FastMath.RECIP_2PI[idx - 1] << shift;
			shpi0 |= org.apache.commons.math4.util.FastMath.RECIP_2PI[idx] >>> (64 - shift);
			shpiA = (org.apache.commons.math4.util.FastMath.RECIP_2PI[idx] << shift) | (org.apache.commons.math4.util.FastMath.RECIP_2PI[idx + 1] >>> (64 - shift));
			shpiB = (org.apache.commons.math4.util.FastMath.RECIP_2PI[idx + 1] << shift) | (org.apache.commons.math4.util.FastMath.RECIP_2PI[idx + 2] >>> (64 - shift));
		} else {
			shpi0 = (idx == 0) ? 0 : org.apache.commons.math4.util.FastMath.RECIP_2PI[idx - 1];
			shpiA = org.apache.commons.math4.util.FastMath.RECIP_2PI[idx];
			shpiB = org.apache.commons.math4.util.FastMath.RECIP_2PI[idx + 1];
		}
		long a = inbits >>> 32;
		long b = inbits & 0xffffffffL;
		long c = shpiA >>> 32;
		long d = shpiA & 0xffffffffL;
		long ac = a * c;
		long bd = b * d;
		long bc = b * c;
		long ad = a * d;
		long prodB = bd + (ad << 32);
		long prodA = ac + (ad >>> 32);
		boolean bita = (bd & 0x8000000000000000L) != 0;
		boolean bitb = (ad & 0x80000000L) != 0;
		boolean bitsum = (prodB & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prodA++;
		}
		bita = (prodB & 0x8000000000000000L) != 0;
		bitb = (bc & 0x80000000L) != 0;
		prodB += bc << 32;
		prodA += bc >>> 32;
		bitsum = (prodB & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prodA++;
		}
		c = shpiB >>> 32;
		d = shpiB & 0xffffffffL;
		ac = a * c;
		bc = b * c;
		ad = a * d;
		ac += (bc + ad) >>> 32;
		bita = (prodB & 0x8000000000000000L) != 0;
		bitb = (ac & 0x8000000000000000L) != 0;
		prodB += ac;
		bitsum = (prodB & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prodA++;
		}
		c = shpi0 >>> 32;
		d = shpi0 & 0xffffffffL;
		bd = b * d;
		bc = b * c;
		ad = a * d;
		prodA += bd + ((bc + ad) << 32);
		int intPart = ((int) (prodA >>> 62));
		prodA <<= 2;
		prodA |= prodB >>> 62;
		prodB <<= 2;
		a = prodA >>> 32;
		b = prodA & 0xffffffffL;
		c = org.apache.commons.math4.util.FastMath.PI_O_4_BITS[0] >>> 32;
		d = org.apache.commons.math4.util.FastMath.PI_O_4_BITS[0] & 0xffffffffL;
		ac = a * c;
		bd = b * d;
		bc = b * c;
		ad = a * d;
		long prod2B = bd + (ad << 32);
		long prod2A = ac + (ad >>> 32);
		bita = (bd & 0x8000000000000000L) != 0;
		bitb = (ad & 0x80000000L) != 0;
		bitsum = (prod2B & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prod2A++;
		}
		bita = (prod2B & 0x8000000000000000L) != 0;
		bitb = (bc & 0x80000000L) != 0;
		prod2B += bc << 32;
		prod2A += bc >>> 32;
		bitsum = (prod2B & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prod2A++;
		}
		c = org.apache.commons.math4.util.FastMath.PI_O_4_BITS[1] >>> 32;
		d = org.apache.commons.math4.util.FastMath.PI_O_4_BITS[1] & 0xffffffffL;
		ac = a * c;
		bc = b * c;
		ad = a * d;
		ac += (bc + ad) >>> 32;
		bita = (prod2B & 0x8000000000000000L) != 0;
		bitb = (ac & 0x8000000000000000L) != 0;
		prod2B += ac;
		bitsum = (prod2B & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prod2A++;
		}
		a = prodB >>> 32;
		b = prodB & 0xffffffffL;
		c = org.apache.commons.math4.util.FastMath.PI_O_4_BITS[0] >>> 32;
		d = org.apache.commons.math4.util.FastMath.PI_O_4_BITS[0] & 0xffffffffL;
		ac = a * c;
		bc = b * c;
		ad = a * d;
		ac += (bc + ad) >>> 32;
		bita = (prod2B & 0x8000000000000000L) != 0;
		bitb = (ac & 0x8000000000000000L) != 0;
		prod2B += ac;
		bitsum = (prod2B & 0x8000000000000000L) != 0;
		if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
			prod2A++;
		}
		double tmpA = (prod2A >>> 12) / org.apache.commons.math4.util.FastMath.TWO_POWER_52;
		double tmpB = ((((prod2A & 0xfffL) << 40) + (prod2B >>> 24)) / org.apache.commons.math4.util.FastMath.TWO_POWER_52) / org.apache.commons.math4.util.FastMath.TWO_POWER_52;
		double sumA = tmpA + tmpB;
		double sumB = -((sumA - tmpA) - tmpB);
		result[0] = intPart;
		result[1] = sumA * 2.0;
		result[2] = sumB * 2.0;
	}

	public static double sin(double x) {
		boolean negative = false;
		int quadrant = 0;
		double xa;
		double xb = 0.0;
		xa = x;
		if (x < 0) {
			negative = true;
			xa = -xa;
		}
		if (xa == 0.0) {
			long bits = java.lang.Double.doubleToRawLongBits(x);
			if (bits < 0) {
				return -0.0;
			}
			return 0.0;
		}
		if ((xa != xa) || (xa == java.lang.Double.POSITIVE_INFINITY)) {
			return java.lang.Double.NaN;
		}
		if (xa > 3294198.0) {
			double[] reduceResults = new double[3];
			org.apache.commons.math4.util.FastMath.reducePayneHanek(xa, reduceResults);
			quadrant = ((int) (reduceResults[0])) & 3;
			xa = reduceResults[1];
			xb = reduceResults[2];
		} else if (xa > 1.5707963267948966) {
			final org.apache.commons.math4.util.FastMath.CodyWaite cw = new org.apache.commons.math4.util.FastMath.CodyWaite(xa);
			quadrant = cw.getK() & 3;
			xa = cw.getRemA();
			xb = cw.getRemB();
		}
		if (negative) {
			quadrant ^= 2;
		}
		switch (quadrant) {
			case 0 :
				return org.apache.commons.math4.util.FastMath.sinQ(xa, xb);
			case 1 :
				return org.apache.commons.math4.util.FastMath.cosQ(xa, xb);
			case 2 :
				return -org.apache.commons.math4.util.FastMath.sinQ(xa, xb);
			case 3 :
				return -org.apache.commons.math4.util.FastMath.cosQ(xa, xb);
			default :
				return java.lang.Double.NaN;
		}
	}

	public static double cos(double x) {
		int quadrant = 0;
		double xa = x;
		if (x < 0) {
			xa = -xa;
		}
		if ((xa != xa) || (xa == java.lang.Double.POSITIVE_INFINITY)) {
			return java.lang.Double.NaN;
		}
		double xb = 0;
		if (xa > 3294198.0) {
			double[] reduceResults = new double[3];
			org.apache.commons.math4.util.FastMath.reducePayneHanek(xa, reduceResults);
			quadrant = ((int) (reduceResults[0])) & 3;
			xa = reduceResults[1];
			xb = reduceResults[2];
		} else if (xa > 1.5707963267948966) {
			final org.apache.commons.math4.util.FastMath.CodyWaite cw = new org.apache.commons.math4.util.FastMath.CodyWaite(xa);
			quadrant = cw.getK() & 3;
			xa = cw.getRemA();
			xb = cw.getRemB();
		}
		switch (quadrant) {
			case 0 :
				return org.apache.commons.math4.util.FastMath.cosQ(xa, xb);
			case 1 :
				return -org.apache.commons.math4.util.FastMath.sinQ(xa, xb);
			case 2 :
				return -org.apache.commons.math4.util.FastMath.cosQ(xa, xb);
			case 3 :
				return org.apache.commons.math4.util.FastMath.sinQ(xa, xb);
			default :
				return java.lang.Double.NaN;
		}
	}

	public static double tan(double x) {
		boolean negative = false;
		int quadrant = 0;
		double xa = x;
		if (x < 0) {
			negative = true;
			xa = -xa;
		}
		if (xa == 0.0) {
			long bits = java.lang.Double.doubleToRawLongBits(x);
			if (bits < 0) {
				return -0.0;
			}
			return 0.0;
		}
		if ((xa != xa) || (xa == java.lang.Double.POSITIVE_INFINITY)) {
			return java.lang.Double.NaN;
		}
		double xb = 0;
		if (xa > 3294198.0) {
			double[] reduceResults = new double[3];
			org.apache.commons.math4.util.FastMath.reducePayneHanek(xa, reduceResults);
			quadrant = ((int) (reduceResults[0])) & 3;
			xa = reduceResults[1];
			xb = reduceResults[2];
		} else if (xa > 1.5707963267948966) {
			final org.apache.commons.math4.util.FastMath.CodyWaite cw = new org.apache.commons.math4.util.FastMath.CodyWaite(xa);
			quadrant = cw.getK() & 3;
			xa = cw.getRemA();
			xb = cw.getRemB();
		}
		if (xa > 1.5) {
			final double pi2a = 1.5707963267948966;
			final double pi2b = 6.123233995736766E-17;
			final double a = pi2a - xa;
			double b = -((a - pi2a) + xa);
			b += pi2b - xb;
			xa = a + b;
			xb = -((xa - a) - b);
			quadrant ^= 1;
			negative ^= true;
		}
		double result;
		if ((quadrant & 1) == 0) {
			result = org.apache.commons.math4.util.FastMath.tanQ(xa, xb, false);
		} else {
			result = -org.apache.commons.math4.util.FastMath.tanQ(xa, xb, true);
		}
		if (negative) {
			result = -result;
		}
		return result;
	}

	public static double atan(double x) {
		return org.apache.commons.math4.util.FastMath.atan(x, 0.0, false);
	}

	private static double atan(double xa, double xb, boolean leftPlane) {
		if (xa == 0.0) {
			return leftPlane ? org.apache.commons.math4.util.FastMath.copySign(java.lang.Math.PI, xa) : xa;
		}
		final boolean negate;
		if (xa < 0) {
			xa = -xa;
			xb = -xb;
			negate = true;
		} else {
			negate = false;
		}
		if (xa > 1.633123935319537E16) {
			return negate ^ leftPlane ? (-java.lang.Math.PI) * org.apache.commons.math4.util.FastMath.F_1_2 : java.lang.Math.PI * org.apache.commons.math4.util.FastMath.F_1_2;
		}
		final int idx;
		if (xa < 1) {
			idx = ((int) ((((((-1.7168146928204135) * xa) * xa) + 8.0) * xa) + 0.5));
		} else {
			final double oneOverXa = 1 / xa;
			idx = ((int) ((-(((((-1.7168146928204135) * oneOverXa) * oneOverXa) + 8.0) * oneOverXa)) + 13.07));
		}
		final double ttA = org.apache.commons.math4.util.FastMath.TANGENT_TABLE_A[idx];
		final double ttB = org.apache.commons.math4.util.FastMath.TANGENT_TABLE_B[idx];
		double epsA = xa - ttA;
		double epsB = -((epsA - xa) + ttA);
		epsB += xb - ttB;
		double temp = epsA + epsB;
		epsB = -((temp - epsA) - epsB);
		epsA = temp;
		temp = xa * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double ya = (xa + temp) - temp;
		double yb = (xb + xa) - ya;
		xa = ya;
		xb += yb;
		if (idx == 0) {
			final double denom = 1.0 / (1.0 + ((xa + xb) * (ttA + ttB)));
			ya = epsA * denom;
			yb = epsB * denom;
		} else {
			double temp2 = xa * ttA;
			double za = 1.0 + temp2;
			double zb = -((za - 1.0) - temp2);
			temp2 = (xb * ttA) + (xa * ttB);
			temp = za + temp2;
			zb += -((temp - za) - temp2);
			za = temp;
			zb += xb * ttB;
			ya = epsA / za;
			temp = ya * org.apache.commons.math4.util.FastMath.HEX_40000000;
			final double yaa = (ya + temp) - temp;
			final double yab = ya - yaa;
			temp = za * org.apache.commons.math4.util.FastMath.HEX_40000000;
			final double zaa = (za + temp) - temp;
			final double zab = za - zaa;
			yb = ((((epsA - (yaa * zaa)) - (yaa * zab)) - (yab * zaa)) - (yab * zab)) / za;
			yb += (((-epsA) * zb) / za) / za;
			yb += epsB / za;
		}
		epsA = ya;
		epsB = yb;
		final double epsA2 = epsA * epsA;
		yb = 0.07490822288864472;
		yb = (yb * epsA2) - 0.09088450866185192;
		yb = (yb * epsA2) + 0.11111095942313305;
		yb = (yb * epsA2) - 0.1428571423679182;
		yb = (yb * epsA2) + 0.19999999999923582;
		yb = (yb * epsA2) - 0.33333333333333287;
		yb = (yb * epsA2) * epsA;
		ya = epsA;
		temp = ya + yb;
		yb = -((temp - ya) - yb);
		ya = temp;
		yb += epsB / (1.0 + (epsA * epsA));
		final double eighths = org.apache.commons.math4.util.FastMath.EIGHTHS[idx];
		double za = eighths + ya;
		double zb = -((za - eighths) - ya);
		temp = za + yb;
		zb += -((temp - za) - yb);
		za = temp;
		double result = za + zb;
		if (leftPlane) {
			final double resultb = -((result - za) - zb);
			final double pia = 1.5707963267948966 * 2;
			final double pib = 6.123233995736766E-17 * 2;
			za = pia - result;
			zb = -((za - pia) + result);
			zb += pib - resultb;
			result = za + zb;
		}
		if (negate ^ leftPlane) {
			result = -result;
		}
		return result;
	}

	public static double atan2(double y, double x) {
		if (java.lang.Double.isNaN(x) || java.lang.Double.isNaN(y)) {
			return java.lang.Double.NaN;
		}
		if (y == 0) {
			final double result = x * y;
			final double invx = 1.0 / x;
			final double invy = 1.0 / y;
			if (invx == 0) {
				if (x > 0) {
					return y;
				} else {
					return org.apache.commons.math4.util.FastMath.copySign(java.lang.Math.PI, y);
				}
			}
			if ((x < 0) || (invx < 0)) {
				if ((y < 0) || (invy < 0)) {
					return -java.lang.Math.PI;
				} else {
					return java.lang.Math.PI;
				}
			} else {
				return result;
			}
		}
		if (y == java.lang.Double.POSITIVE_INFINITY) {
			if (x == java.lang.Double.POSITIVE_INFINITY) {
				return java.lang.Math.PI * org.apache.commons.math4.util.FastMath.F_1_4;
			}
			if (x == java.lang.Double.NEGATIVE_INFINITY) {
				return java.lang.Math.PI * org.apache.commons.math4.util.FastMath.F_3_4;
			}
			return java.lang.Math.PI * org.apache.commons.math4.util.FastMath.F_1_2;
		}
		if (y == java.lang.Double.NEGATIVE_INFINITY) {
			if (x == java.lang.Double.POSITIVE_INFINITY) {
				return (-java.lang.Math.PI) * org.apache.commons.math4.util.FastMath.F_1_4;
			}
			if (x == java.lang.Double.NEGATIVE_INFINITY) {
				return (-java.lang.Math.PI) * org.apache.commons.math4.util.FastMath.F_3_4;
			}
			return (-java.lang.Math.PI) * org.apache.commons.math4.util.FastMath.F_1_2;
		}
		if (x == java.lang.Double.POSITIVE_INFINITY) {
			if ((y > 0) || ((1 / y) > 0)) {
				return 0.0;
			}
			if ((y < 0) || ((1 / y) < 0)) {
				return -0.0;
			}
		}
		if (x == java.lang.Double.NEGATIVE_INFINITY) {
			if ((y > 0.0) || ((1 / y) > 0.0)) {
				return java.lang.Math.PI;
			}
			if ((y < 0) || ((1 / y) < 0)) {
				return -java.lang.Math.PI;
			}
		}
		if (x == 0) {
			if ((y > 0) || ((1 / y) > 0)) {
				return java.lang.Math.PI * org.apache.commons.math4.util.FastMath.F_1_2;
			}
			if ((y < 0) || ((1 / y) < 0)) {
				return (-java.lang.Math.PI) * org.apache.commons.math4.util.FastMath.F_1_2;
			}
		}
		final double r = y / x;
		if (java.lang.Double.isInfinite(r)) {
			return org.apache.commons.math4.util.FastMath.atan(r, 0, x < 0);
		}
		double ra = org.apache.commons.math4.util.FastMath.doubleHighPart(r);
		double rb = r - ra;
		final double xa = org.apache.commons.math4.util.FastMath.doubleHighPart(x);
		final double xb = x - xa;
		rb += ((((y - (ra * xa)) - (ra * xb)) - (rb * xa)) - (rb * xb)) / x;
		final double temp = ra + rb;
		rb = -((temp - ra) - rb);
		ra = temp;
		if (ra == 0) {
			ra = org.apache.commons.math4.util.FastMath.copySign(0.0, y);
		}
		final double result = org.apache.commons.math4.util.FastMath.atan(ra, rb, x < 0);
		return result;
	}

	public static double asin(double x) {
		if (java.lang.Double.isNaN(x)) {
			return java.lang.Double.NaN;
		}
		if ((x > 1.0) || (x < (-1.0))) {
			return java.lang.Double.NaN;
		}
		if (x == 1.0) {
			return java.lang.Math.PI / 2.0;
		}
		if (x == (-1.0)) {
			return (-java.lang.Math.PI) / 2.0;
		}
		if (x == 0.0) {
			return x;
		}
		double temp = x * org.apache.commons.math4.util.FastMath.HEX_40000000;
		final double xa = (x + temp) - temp;
		final double xb = x - xa;
		double ya = xa * xa;
		double yb = ((xa * xb) * 2.0) + (xb * xb);
		ya = -ya;
		yb = -yb;
		double za = 1.0 + ya;
		double zb = -((za - 1.0) - ya);
		temp = za + yb;
		zb += -((temp - za) - yb);
		za = temp;
		double y;
		y = org.apache.commons.math4.util.FastMath.sqrt(za);
		temp = y * org.apache.commons.math4.util.FastMath.HEX_40000000;
		ya = (y + temp) - temp;
		yb = y - ya;
		yb += (((za - (ya * ya)) - ((2 * ya) * yb)) - (yb * yb)) / (2.0 * y);
		double dx = zb / (2.0 * y);
		double r = x / y;
		temp = r * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double ra = (r + temp) - temp;
		double rb = r - ra;
		rb += ((((x - (ra * ya)) - (ra * yb)) - (rb * ya)) - (rb * yb)) / y;
		rb += (((-x) * dx) / y) / y;
		temp = ra + rb;
		rb = -((temp - ra) - rb);
		ra = temp;
		return org.apache.commons.math4.util.FastMath.atan(ra, rb, false);
	}

	public static double acos(double x) {
		if (java.lang.Double.isNaN(x)) {
			return java.lang.Double.NaN;
		}
		if ((x > 1.0) || (x < (-1.0))) {
			return java.lang.Double.NaN;
		}
		if (x == (-1.0)) {
			return java.lang.Math.PI;
		}
		if (x == 1.0) {
			return 0.0;
		}
		if (x == 0) {
			return java.lang.Math.PI / 2.0;
		}
		double temp = x * org.apache.commons.math4.util.FastMath.HEX_40000000;
		final double xa = (x + temp) - temp;
		final double xb = x - xa;
		double ya = xa * xa;
		double yb = ((xa * xb) * 2.0) + (xb * xb);
		ya = -ya;
		yb = -yb;
		double za = 1.0 + ya;
		double zb = -((za - 1.0) - ya);
		temp = za + yb;
		zb += -((temp - za) - yb);
		za = temp;
		double y = org.apache.commons.math4.util.FastMath.sqrt(za);
		temp = y * org.apache.commons.math4.util.FastMath.HEX_40000000;
		ya = (y + temp) - temp;
		yb = y - ya;
		yb += (((za - (ya * ya)) - ((2 * ya) * yb)) - (yb * yb)) / (2.0 * y);
		yb += zb / (2.0 * y);
		y = ya + yb;
		yb = -((y - ya) - yb);
		double r = y / x;
		if (java.lang.Double.isInfinite(r)) {
			return java.lang.Math.PI / 2;
		}
		double ra = org.apache.commons.math4.util.FastMath.doubleHighPart(r);
		double rb = r - ra;
		rb += ((((y - (ra * xa)) - (ra * xb)) - (rb * xa)) - (rb * xb)) / x;
		rb += yb / x;
		temp = ra + rb;
		rb = -((temp - ra) - rb);
		ra = temp;
		return org.apache.commons.math4.util.FastMath.atan(ra, rb, x < 0);
	}

	public static double cbrt(double x) {
		long inbits = java.lang.Double.doubleToRawLongBits(x);
		int exponent = ((int) ((inbits >> 52) & 0x7ff)) - 1023;
		boolean subnormal = false;
		if (exponent == (-1023)) {
			if (x == 0) {
				return x;
			}
			subnormal = true;
			x *= 1.8014398509481984E16;
			inbits = java.lang.Double.doubleToRawLongBits(x);
			exponent = ((int) ((inbits >> 52) & 0x7ff)) - 1023;
		}
		if (exponent == 1024) {
			return x;
		}
		int exp3 = exponent / 3;
		double p2 = java.lang.Double.longBitsToDouble((inbits & 0x8000000000000000L) | (((long) ((exp3 + 1023) & 0x7ff)) << 52));
		final double mant = java.lang.Double.longBitsToDouble((inbits & 0xfffffffffffffL) | 0x3ff0000000000000L);
		double est = -0.010714690733195933;
		est = (est * mant) + 0.0875862700108075;
		est = (est * mant) + (-0.3058015757857271);
		est = (est * mant) + 0.7249995199969751;
		est = (est * mant) + 0.5039018405998233;
		est *= org.apache.commons.math4.util.FastMath.CBRTTWO[(exponent % 3) + 2];
		final double xs = x / ((p2 * p2) * p2);
		est += (xs - ((est * est) * est)) / ((3 * est) * est);
		est += (xs - ((est * est) * est)) / ((3 * est) * est);
		double temp = est * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double ya = (est + temp) - temp;
		double yb = est - ya;
		double za = ya * ya;
		double zb = ((ya * yb) * 2.0) + (yb * yb);
		temp = za * org.apache.commons.math4.util.FastMath.HEX_40000000;
		double temp2 = (za + temp) - temp;
		zb += za - temp2;
		za = temp2;
		zb = ((za * yb) + (ya * zb)) + (zb * yb);
		za *= ya;
		double na = xs - za;
		double nb = -((na - xs) + za);
		nb -= zb;
		est += (na + nb) / ((3 * est) * est);
		est *= p2;
		if (subnormal) {
			est *= 3.814697265625E-6;
		}
		return est;
	}

	public static double toRadians(double x) {
		if (java.lang.Double.isInfinite(x) || (x == 0.0)) {
			return x;
		}
		final double facta = 0.01745329052209854;
		final double factb = 1.997844754509471E-9;
		double xa = org.apache.commons.math4.util.FastMath.doubleHighPart(x);
		double xb = x - xa;
		double result = (((xb * factb) + (xb * facta)) + (xa * factb)) + (xa * facta);
		if (result == 0) {
			result *= x;
		}
		return result;
	}

	public static double toDegrees(double x) {
		if (java.lang.Double.isInfinite(x) || (x == 0.0)) {
			return x;
		}
		final double facta = 57.2957763671875;
		final double factb = 3.145894820876798E-6;
		double xa = org.apache.commons.math4.util.FastMath.doubleHighPart(x);
		double xb = x - xa;
		return (((xb * factb) + (xb * facta)) + (xa * factb)) + (xa * facta);
	}

	public static int abs(final int x) {
		final int i = x >>> 31;
		return (x ^ ((~i) + 1)) + i;
	}

	public static long abs(final long x) {
		final long l = x >>> 63;
		return (x ^ ((~l) + 1)) + l;
	}

	public static float abs(final float x) {
		return java.lang.Float.intBitsToFloat(org.apache.commons.math4.util.FastMath.MASK_NON_SIGN_INT & java.lang.Float.floatToRawIntBits(x));
	}

	public static double abs(double x) {
		return java.lang.Double.longBitsToDouble(org.apache.commons.math4.util.FastMath.MASK_NON_SIGN_LONG & java.lang.Double.doubleToRawLongBits(x));
	}

	public static double ulp(double x) {
		if (java.lang.Double.isInfinite(x)) {
			return java.lang.Double.POSITIVE_INFINITY;
		}
		return org.apache.commons.math4.util.FastMath.abs(x - java.lang.Double.longBitsToDouble(java.lang.Double.doubleToRawLongBits(x) ^ 1));
	}

	public static float ulp(float x) {
		if (java.lang.Float.isInfinite(x)) {
			return java.lang.Float.POSITIVE_INFINITY;
		}
		return org.apache.commons.math4.util.FastMath.abs(x - java.lang.Float.intBitsToFloat(java.lang.Float.floatToIntBits(x) ^ 1));
	}

	public static double scalb(final double d, final int n) {
		if ((n > (-1023)) && (n < 1024)) {
			return d * java.lang.Double.longBitsToDouble(((long) (n + 1023)) << 52);
		}
		if ((java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d)) || (d == 0)) {
			return d;
		}
		if (n < (-2098)) {
			return d > 0 ? 0.0 : -0.0;
		}
		if (n > 2097) {
			return d > 0 ? java.lang.Double.POSITIVE_INFINITY : java.lang.Double.NEGATIVE_INFINITY;
		}
		final long bits = java.lang.Double.doubleToRawLongBits(d);
		final long sign = bits & 0x8000000000000000L;
		int exponent = ((int) (bits >>> 52)) & 0x7ff;
		long mantissa = bits & 0xfffffffffffffL;
		int scaledExponent = exponent + n;
		if (n < 0) {
			if (scaledExponent > 0) {
				return java.lang.Double.longBitsToDouble((sign | (((long) (scaledExponent)) << 52)) | mantissa);
			} else if (scaledExponent > (-53)) {
				mantissa |= 1L << 52;
				final long mostSignificantLostBit = mantissa & (1L << (-scaledExponent));
				mantissa >>>= 1 - scaledExponent;
				if (mostSignificantLostBit != 0) {
					mantissa++;
				}
				return java.lang.Double.longBitsToDouble(sign | mantissa);
			} else {
				return sign == 0L ? 0.0 : -0.0;
			}
		} else if (exponent == 0) {
			while ((mantissa >>> 52) != 1) {
				mantissa <<= 1;
				--scaledExponent;
			} 
			++scaledExponent;
			mantissa &= 0xfffffffffffffL;
			if (scaledExponent < 2047) {
				return java.lang.Double.longBitsToDouble((sign | (((long) (scaledExponent)) << 52)) | mantissa);
			} else {
				return sign == 0L ? java.lang.Double.POSITIVE_INFINITY : java.lang.Double.NEGATIVE_INFINITY;
			}
		} else if (scaledExponent < 2047) {
			return java.lang.Double.longBitsToDouble((sign | (((long) (scaledExponent)) << 52)) | mantissa);
		} else {
			return sign == 0L ? java.lang.Double.POSITIVE_INFINITY : java.lang.Double.NEGATIVE_INFINITY;
		}
	}

	public static float scalb(final float f, final int n) {
		if ((n > (-127)) && (n < 128)) {
			return f * java.lang.Float.intBitsToFloat((n + 127) << 23);
		}
		if ((java.lang.Float.isNaN(f) || java.lang.Float.isInfinite(f)) || (f == 0.0F)) {
			return f;
		}
		if (n < (-277)) {
			return f > 0 ? 0.0F : -0.0F;
		}
		if (n > 276) {
			return f > 0 ? java.lang.Float.POSITIVE_INFINITY : java.lang.Float.NEGATIVE_INFINITY;
		}
		final int bits = java.lang.Float.floatToIntBits(f);
		final int sign = bits & 0x80000000;
		int exponent = (bits >>> 23) & 0xff;
		int mantissa = bits & 0x7fffff;
		int scaledExponent = exponent + n;
		if (n < 0) {
			if (scaledExponent > 0) {
				return java.lang.Float.intBitsToFloat((sign | (scaledExponent << 23)) | mantissa);
			} else if (scaledExponent > (-24)) {
				mantissa |= 1 << 23;
				final int mostSignificantLostBit = mantissa & (1 << (-scaledExponent));
				mantissa >>>= 1 - scaledExponent;
				if (mostSignificantLostBit != 0) {
					mantissa++;
				}
				return java.lang.Float.intBitsToFloat(sign | mantissa);
			} else {
				return sign == 0 ? 0.0F : -0.0F;
			}
		} else if (exponent == 0) {
			while ((mantissa >>> 23) != 1) {
				mantissa <<= 1;
				--scaledExponent;
			} 
			++scaledExponent;
			mantissa &= 0x7fffff;
			if (scaledExponent < 255) {
				return java.lang.Float.intBitsToFloat((sign | (scaledExponent << 23)) | mantissa);
			} else {
				return sign == 0 ? java.lang.Float.POSITIVE_INFINITY : java.lang.Float.NEGATIVE_INFINITY;
			}
		} else if (scaledExponent < 255) {
			return java.lang.Float.intBitsToFloat((sign | (scaledExponent << 23)) | mantissa);
		} else {
			return sign == 0 ? java.lang.Float.POSITIVE_INFINITY : java.lang.Float.NEGATIVE_INFINITY;
		}
	}

	public static double nextAfter(double d, double direction) {
		if (java.lang.Double.isNaN(d) || java.lang.Double.isNaN(direction)) {
			return java.lang.Double.NaN;
		} else if (d == direction) {
			return direction;
		} else if (java.lang.Double.isInfinite(d)) {
			return d < 0 ? -java.lang.Double.MAX_VALUE : java.lang.Double.MAX_VALUE;
		} else if (d == 0) {
			return direction < 0 ? -java.lang.Double.MIN_VALUE : java.lang.Double.MIN_VALUE;
		}
		final long bits = java.lang.Double.doubleToRawLongBits(d);
		final long sign = bits & 0x8000000000000000L;
		if ((direction < d) ^ (sign == 0L)) {
			return java.lang.Double.longBitsToDouble(sign | ((bits & 0x7fffffffffffffffL) + 1));
		} else {
			return java.lang.Double.longBitsToDouble(sign | ((bits & 0x7fffffffffffffffL) - 1));
		}
	}

	public static float nextAfter(final float f, final double direction) {
		if (java.lang.Double.isNaN(f) || java.lang.Double.isNaN(direction)) {
			return java.lang.Float.NaN;
		} else if (f == direction) {
			return ((float) (direction));
		} else if (java.lang.Float.isInfinite(f)) {
			return f < 0.0F ? -java.lang.Float.MAX_VALUE : java.lang.Float.MAX_VALUE;
		} else if (f == 0.0F) {
			return direction < 0 ? -java.lang.Float.MIN_VALUE : java.lang.Float.MIN_VALUE;
		}
		final int bits = java.lang.Float.floatToIntBits(f);
		final int sign = bits & 0x80000000;
		if ((direction < f) ^ (sign == 0)) {
			return java.lang.Float.intBitsToFloat(sign | ((bits & 0x7fffffff) + 1));
		} else {
			return java.lang.Float.intBitsToFloat(sign | ((bits & 0x7fffffff) - 1));
		}
	}

	public static double floor(double x) {
		long y;
		if (java.lang.Double.isNaN(x)) {
			return x;
		}
		if ((x >= org.apache.commons.math4.util.FastMath.TWO_POWER_52) || (x <= (-org.apache.commons.math4.util.FastMath.TWO_POWER_52))) {
			return x;
		}
		y = ((long) (x));
		if ((x < 0) && (y != x)) {
			y--;
		}
		if (y == 0) {
			return x * y;
		}
		return y;
	}

	public static double ceil(double x) {
		double y;
		if (java.lang.Double.isNaN(x)) {
			return x;
		}
		y = org.apache.commons.math4.util.FastMath.floor(x);
		if (y == x) {
			return y;
		}
		y += 1.0;
		if (y == 0) {
			return x * y;
		}
		return y;
	}

	public static double rint(double x) {
		double y = org.apache.commons.math4.util.FastMath.floor(x);
		double d = x - y;
		if (d > 0.5) {
			if (y == (-1.0)) {
				return -0.0;
			}
			return y + 1.0;
		}
		if (d < 0.5) {
			return y;
		}
		long z = ((long) (y));
		return (z & 1) == 0 ? y : y + 1.0;
	}

	public static long round(double x) {
		return ((long) (org.apache.commons.math4.util.FastMath.floor(x + 0.5)));
	}

	public static int round(final float x) {
		return ((int) (org.apache.commons.math4.util.FastMath.floor(x + 0.5F)));
	}

	public static int min(final int a, final int b) {
		return a <= b ? a : b;
	}

	public static long min(final long a, final long b) {
		return a <= b ? a : b;
	}

	public static float min(final float a, final float b) {
		if (a > b) {
			return b;
		}
		if (a < b) {
			return a;
		}
		if (a != b) {
			return java.lang.Float.NaN;
		}
		int bits = java.lang.Float.floatToRawIntBits(a);
		if (bits == 0x80000000) {
			return a;
		}
		return b;
	}

	public static double min(final double a, final double b) {
		if (a > b) {
			return b;
		}
		if (a < b) {
			return a;
		}
		if (a != b) {
			return java.lang.Double.NaN;
		}
		long bits = java.lang.Double.doubleToRawLongBits(a);
		if (bits == 0x8000000000000000L) {
			return a;
		}
		return b;
	}

	public static int max(final int a, final int b) {
		return a <= b ? b : a;
	}

	public static long max(final long a, final long b) {
		return a <= b ? b : a;
	}

	public static float max(final float a, final float b) {
		if (a > b) {
			return a;
		}
		if (a < b) {
			return b;
		}
		if (a != b) {
			return java.lang.Float.NaN;
		}
		int bits = java.lang.Float.floatToRawIntBits(a);
		if (bits == 0x80000000) {
			return b;
		}
		return a;
	}

	public static double max(final double a, final double b) {
		if (a > b) {
			return a;
		}
		if (a < b) {
			return b;
		}
		if (a != b) {
			return java.lang.Double.NaN;
		}
		long bits = java.lang.Double.doubleToRawLongBits(a);
		if (bits == 0x8000000000000000L) {
			return b;
		}
		return a;
	}

	public static double hypot(final double x, final double y) {
		if (java.lang.Double.isInfinite(x) || java.lang.Double.isInfinite(y)) {
			return java.lang.Double.POSITIVE_INFINITY;
		} else if (java.lang.Double.isNaN(x) || java.lang.Double.isNaN(y)) {
			return java.lang.Double.NaN;
		} else {
			final int expX = org.apache.commons.math4.util.FastMath.getExponent(x);
			final int expY = org.apache.commons.math4.util.FastMath.getExponent(y);
			if (expX > (expY + 27)) {
				return org.apache.commons.math4.util.FastMath.abs(x);
			} else if (expY > (expX + 27)) {
				return org.apache.commons.math4.util.FastMath.abs(y);
			} else {
				final int middleExp = (expX + expY) / 2;
				final double scaledX = org.apache.commons.math4.util.FastMath.scalb(x, -middleExp);
				final double scaledY = org.apache.commons.math4.util.FastMath.scalb(y, -middleExp);
				final double scaledH = org.apache.commons.math4.util.FastMath.sqrt((scaledX * scaledX) + (scaledY * scaledY));
				return org.apache.commons.math4.util.FastMath.scalb(scaledH, middleExp);
			}
		}
	}

	public static double IEEEremainder(final double dividend, final double divisor) {
		if (((org.apache.commons.math4.util.FastMath.getExponent(dividend) == 1024) || (org.apache.commons.math4.util.FastMath.getExponent(divisor) == 1024)) || (divisor == 0.0)) {
			if (java.lang.Double.isInfinite(divisor) && (!java.lang.Double.isInfinite(dividend))) {
				return dividend;
			} else {
				return java.lang.Double.NaN;
			}
		} else {
			final double n = org.apache.commons.math4.util.FastMath.rint(dividend / divisor);
			final double remainder = (java.lang.Double.isInfinite(n)) ? 0.0 : dividend - (divisor * n);
			return remainder == 0 ? org.apache.commons.math4.util.FastMath.copySign(remainder, dividend) : remainder;
		}
	}

	public static int toIntExact(final long n) throws org.apache.commons.math4.exception.MathArithmeticException {
		if ((n < java.lang.Integer.MIN_VALUE) || (n > java.lang.Integer.MAX_VALUE)) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW);
		}
		return ((int) (n));
	}

	public static int incrementExact(final int n) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (n == java.lang.Integer.MAX_VALUE) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_ADDITION, n, 1);
		}
		return n + 1;
	}

	public static long incrementExact(final long n) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (n == java.lang.Long.MAX_VALUE) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_ADDITION, n, 1);
		}
		return n + 1;
	}

	public static int decrementExact(final int n) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (n == java.lang.Integer.MIN_VALUE) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_SUBTRACTION, n, 1);
		}
		return n - 1;
	}

	public static long decrementExact(final long n) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (n == java.lang.Long.MIN_VALUE) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_SUBTRACTION, n, 1);
		}
		return n - 1;
	}

	public static int addExact(final int a, final int b) throws org.apache.commons.math4.exception.MathArithmeticException {
		final int sum = a + b;
		if (((a ^ b) >= 0) && ((sum ^ b) < 0)) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_ADDITION, a, b);
		}
		return sum;
	}

	public static long addExact(final long a, final long b) throws org.apache.commons.math4.exception.MathArithmeticException {
		final long sum = a + b;
		if (((a ^ b) >= 0) && ((sum ^ b) < 0)) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_ADDITION, a, b);
		}
		return sum;
	}

	public static int subtractExact(final int a, final int b) {
		final int sub = a - b;
		if (((a ^ b) < 0) && ((sub ^ b) >= 0)) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_SUBTRACTION, a, b);
		}
		return sub;
	}

	public static long subtractExact(final long a, final long b) {
		final long sub = a - b;
		if (((a ^ b) < 0) && ((sub ^ b) >= 0)) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_SUBTRACTION, a, b);
		}
		return sub;
	}

	public static int multiplyExact(final int a, final int b) {
		if ((((b > 0) && ((a > (java.lang.Integer.MAX_VALUE / b)) || (a < (java.lang.Integer.MIN_VALUE / b)))) || ((b < (-1)) && ((a > (java.lang.Integer.MIN_VALUE / b)) || (a < (java.lang.Integer.MAX_VALUE / b))))) || ((b == (-1)) && (a == java.lang.Integer.MIN_VALUE))) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, a, b);
		}
		return a * b;
	}

	public static long multiplyExact(final long a, final long b) {
		if ((((b > 0L) && ((a > (java.lang.Long.MAX_VALUE / b)) || (a < (java.lang.Long.MIN_VALUE / b)))) || ((b < (-1L)) && ((a > (java.lang.Long.MIN_VALUE / b)) || (a < (java.lang.Long.MAX_VALUE / b))))) || ((b == (-1L)) && (a == java.lang.Long.MIN_VALUE))) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, a, b);
		}
		return a * b;
	}

	public static int floorDiv(final int a, final int b) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (b == 0) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.ZERO_DENOMINATOR);
		}
		final int m = a % b;
		if (((a ^ b) >= 0) || (m == 0)) {
			return a / b;
		} else {
			return (a / b) - 1;
		}
	}

	public static long floorDiv(final long a, final long b) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (b == 0L) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.ZERO_DENOMINATOR);
		}
		final long m = a % b;
		if (((a ^ b) >= 0L) || (m == 0L)) {
			return a / b;
		} else {
			return (a / b) - 1L;
		}
	}

	public static int floorMod(final int a, final int b) throws org.apache.commons.math4.exception.MathArithmeticException {
		if (b == 0) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.ZERO_DENOMINATOR);
		}
		final int m = a % b;
		if (((a ^ b) >= 0) || (m == 0)) {
			return m;
		} else {
			return b + m;
		}
	}

	public static long floorMod(final long a, final long b) {
		if (b == 0L) {
			throw new org.apache.commons.math4.exception.MathArithmeticException(org.apache.commons.math4.exception.util.LocalizedFormats.ZERO_DENOMINATOR);
		}
		final long m = a % b;
		if (((a ^ b) >= 0L) || (m == 0L)) {
			return m;
		} else {
			return b + m;
		}
	}

	public static double copySign(double magnitude, double sign) {
		final long m = java.lang.Double.doubleToRawLongBits(magnitude);
		final long s = java.lang.Double.doubleToRawLongBits(sign);
		if ((m ^ s) >= 0) {
			return magnitude;
		}
		return -magnitude;
	}

	public static float copySign(float magnitude, float sign) {
		final int m = java.lang.Float.floatToRawIntBits(magnitude);
		final int s = java.lang.Float.floatToRawIntBits(sign);
		if ((m ^ s) >= 0) {
			return magnitude;
		}
		return -magnitude;
	}

	public static int getExponent(final double d) {
		return ((int) ((java.lang.Double.doubleToRawLongBits(d) >>> 52) & 0x7ff)) - 1023;
	}

	public static int getExponent(final float f) {
		return ((java.lang.Float.floatToRawIntBits(f) >>> 23) & 0xff) - 127;
	}

	public static void main(java.lang.String[] a) {
		java.io.PrintStream out = java.lang.System.out;
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "EXP_INT_TABLE_A", org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_LEN, org.apache.commons.math4.util.FastMath.ExpIntTable.EXP_INT_TABLE_A);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "EXP_INT_TABLE_B", org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_LEN, org.apache.commons.math4.util.FastMath.ExpIntTable.EXP_INT_TABLE_B);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "EXP_FRAC_TABLE_A", org.apache.commons.math4.util.FastMath.EXP_FRAC_TABLE_LEN, org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_A);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "EXP_FRAC_TABLE_B", org.apache.commons.math4.util.FastMath.EXP_FRAC_TABLE_LEN, org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_B);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "LN_MANT", org.apache.commons.math4.util.FastMath.LN_MANT_LEN, org.apache.commons.math4.util.FastMath.lnMant.LN_MANT);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "SINE_TABLE_A", org.apache.commons.math4.util.FastMath.SINE_TABLE_LEN, org.apache.commons.math4.util.FastMath.SINE_TABLE_A);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "SINE_TABLE_B", org.apache.commons.math4.util.FastMath.SINE_TABLE_LEN, org.apache.commons.math4.util.FastMath.SINE_TABLE_B);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "COSINE_TABLE_A", org.apache.commons.math4.util.FastMath.SINE_TABLE_LEN, org.apache.commons.math4.util.FastMath.COSINE_TABLE_A);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "COSINE_TABLE_B", org.apache.commons.math4.util.FastMath.SINE_TABLE_LEN, org.apache.commons.math4.util.FastMath.COSINE_TABLE_B);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "TANGENT_TABLE_A", org.apache.commons.math4.util.FastMath.SINE_TABLE_LEN, org.apache.commons.math4.util.FastMath.TANGENT_TABLE_A);
		org.apache.commons.math4.util.FastMathCalc.printarray(out, "TANGENT_TABLE_B", org.apache.commons.math4.util.FastMath.SINE_TABLE_LEN, org.apache.commons.math4.util.FastMath.TANGENT_TABLE_B);
	}

	private static class ExpIntTable {
		private static final double[] EXP_INT_TABLE_A;

		private static final double[] EXP_INT_TABLE_B;

		static {
			if (org.apache.commons.math4.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME) {
				EXP_INT_TABLE_A = new double[org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_LEN];
				EXP_INT_TABLE_B = new double[org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_LEN];
				final double[] tmp = new double[2];
				final double[] recip = new double[2];
				for (int i = 0; i < org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX; i++) {
					org.apache.commons.math4.util.FastMathCalc.expint(i, tmp);
					EXP_INT_TABLE_A[i + org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX] = tmp[0];
					EXP_INT_TABLE_B[i + org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX] = tmp[1];
					if (i != 0) {
						org.apache.commons.math4.util.FastMathCalc.splitReciprocal(tmp, recip);
						EXP_INT_TABLE_A[org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX - i] = recip[0];
						EXP_INT_TABLE_B[org.apache.commons.math4.util.FastMath.EXP_INT_TABLE_MAX_INDEX - i] = recip[1];
					}
				}
			} else {
				EXP_INT_TABLE_A = org.apache.commons.math4.util.FastMathLiteralArrays.loadExpIntA();
				EXP_INT_TABLE_B = org.apache.commons.math4.util.FastMathLiteralArrays.loadExpIntB();
			}
		}
	}

	private static class ExpFracTable {
		private static final double[] EXP_FRAC_TABLE_A;

		private static final double[] EXP_FRAC_TABLE_B;

		static {
			if (org.apache.commons.math4.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME) {
				EXP_FRAC_TABLE_A = new double[org.apache.commons.math4.util.FastMath.EXP_FRAC_TABLE_LEN];
				EXP_FRAC_TABLE_B = new double[org.apache.commons.math4.util.FastMath.EXP_FRAC_TABLE_LEN];
				final double[] tmp = new double[2];
				final double factor = 1.0 / (org.apache.commons.math4.util.FastMath.EXP_FRAC_TABLE_LEN - 1);
				for (int i = 0; i < org.apache.commons.math4.util.FastMath.ExpFracTable.EXP_FRAC_TABLE_A.length; i++) {
					org.apache.commons.math4.util.FastMathCalc.slowexp(i * factor, tmp);
					EXP_FRAC_TABLE_A[i] = tmp[0];
					EXP_FRAC_TABLE_B[i] = tmp[1];
				}
			} else {
				EXP_FRAC_TABLE_A = org.apache.commons.math4.util.FastMathLiteralArrays.loadExpFracA();
				EXP_FRAC_TABLE_B = org.apache.commons.math4.util.FastMathLiteralArrays.loadExpFracB();
			}
		}
	}

	private static class lnMant {
		private static final double[][] LN_MANT;

		static {
			if (org.apache.commons.math4.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME) {
				LN_MANT = new double[org.apache.commons.math4.util.FastMath.LN_MANT_LEN][];
				for (int i = 0; i < org.apache.commons.math4.util.FastMath.lnMant.LN_MANT.length; i++) {
					final double d = java.lang.Double.longBitsToDouble((((long) (i)) << 42) | 0x3ff0000000000000L);
					LN_MANT[i] = org.apache.commons.math4.util.FastMathCalc.slowLog(d);
				}
			} else {
				LN_MANT = org.apache.commons.math4.util.FastMathLiteralArrays.loadLnMant();
			}
		}
	}

	private static class CodyWaite {
		private final int finalK;

		private final double finalRemA;

		private final double finalRemB;

		CodyWaite(double xa) {
			int k = ((int) (xa * 0.6366197723675814));
			double remA;
			double remB;
			while (true) {
				double a = (-k) * 1.570796251296997;
				remA = xa + a;
				remB = -((remA - xa) - a);
				a = (-k) * 7.549789948768648E-8;
				double b = remA;
				remA = a + b;
				remB += -((remA - b) - a);
				a = (-k) * 6.123233995736766E-17;
				b = remA;
				remA = a + b;
				remB += -((remA - b) - a);
				if (remA > 0) {
					break;
				}
				--k;
			} 
			this.finalK = k;
			this.finalRemA = remA;
			this.finalRemB = remB;
		}

		int getK() {
			return finalK;
		}

		double getRemA() {
			return finalRemA;
		}

		double getRemB() {
			return finalRemB;
		}
	}
}