public class BadPredicateAfterPartialPeel {
	static void not_inlined1() {
	}

	static void not_inlined4() {
	}

	static int m_helper(int i, int i3, int i4) {
		return i3 == 4 ? i4 : i;
	}

	static float[] array = new float[1000];

	static int[] array2 = new int[1000];

	boolean flag;

	int j;

	static void m(compiler.loopopts.BadPredicateAfterPartialPeel o1, compiler.loopopts.BadPredicateAfterPartialPeel o2, compiler.loopopts.BadPredicateAfterPartialPeel o, int i4) {
		int i1 = 1;
		int i2 = 0;
		for (; i2 < 10; i2 += i1);
		i2 = i2 / 10;
		int i3 = 2;
		for (; i3 < 4; i3 *= 2);
		int i = 0;
		boolean b = true;
		compiler.loopopts.BadPredicateAfterPartialPeel.not_inlined1();
		compiler.loopopts.BadPredicateAfterPartialPeel.array[0] = -1;
		do {
			o.flag = false;
			o.j = 0;
			if (b) {
				compiler.loopopts.BadPredicateAfterPartialPeel.array[i] = 0;
			}
			if (compiler.loopopts.BadPredicateAfterPartialPeel.array[0] != 0) {
			}
			if (i >= 10) {
				return;
			}
			i += i2;
			b = false;
			int i5 = compiler.loopopts.BadPredicateAfterPartialPeel.m_helper(i, i3, i4);
			if (compiler.loopopts.BadPredicateAfterPartialPeel.array[i5] != 0) {
			}
			if (o2.flag) {
			}
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[0] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[1] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[2] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[3] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[4] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[5] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[6] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[7] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[8] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[9] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[10] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[11] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[12] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[13] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[14] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[15] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[16] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[17] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[18] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[19] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[20] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[21] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[22] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[23] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[24] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[25] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[26] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[27] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[28] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[29] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[30] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[31] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[32] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[33] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[34] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[35] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[36] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[37] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[38] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[39] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[40] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[41] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[42] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[43] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[44] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[45] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[46] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[47] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[48] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[49] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[50] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[51] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[52] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[53] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[54] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[55] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[56] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[57] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[58] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[59] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[60] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[61] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[62] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[63] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[64] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[65] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[66] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[67] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[68] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[69] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[70] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[71] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[72] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[73] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[74] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[75] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[76] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[77] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[78] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[79] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[80] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[81] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[82] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[83] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[84] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[85] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[86] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[87] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[88] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[89] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[90] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[91] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[92] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[93] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[94] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[95] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[96] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[97] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[98] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[99] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[100] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[101] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[102] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[103] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[104] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[105] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[106] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[107] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[108] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[109] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[110] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[111] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[112] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[113] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[114] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[115] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[116] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[117] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[118] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[119] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[120] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[121] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[122] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[123] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[124] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[125] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[126] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[127] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[128] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[129] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[130] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[131] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[132] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[133] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[134] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[135] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[136] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[137] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[138] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[139] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[140] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[141] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[142] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[143] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[144] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[145] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[146] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[147] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[148] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[149] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[150] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[151] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[152] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[153] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[154] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[155] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[156] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[157] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[158] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[159] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[160] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[161] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[162] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[163] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[164] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[165] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[166] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[167] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[168] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[169] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[170] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[171] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[172] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[173] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[174] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[175] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[176] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[177] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[178] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[179] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[180] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[181] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[182] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[183] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[184] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[185] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[186] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[187] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[188] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[189] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[190] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[191] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[192] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[193] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[194] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[195] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[196] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[197] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[198] = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.array2[199] = 0;
			if (o1.j >= 20) {
				break;
			}
			o1.j++;
		} while (true );
		compiler.loopopts.BadPredicateAfterPartialPeel.not_inlined4();
	}

	public static void main(java.lang.String[] args) {
		compiler.loopopts.BadPredicateAfterPartialPeel o1 = new compiler.loopopts.BadPredicateAfterPartialPeel();
		compiler.loopopts.BadPredicateAfterPartialPeel o2 = new compiler.loopopts.BadPredicateAfterPartialPeel();
		for (int i = 0; i < 20000; i++) {
			o1.j = 0;
			compiler.loopopts.BadPredicateAfterPartialPeel.m(o1, o2, o2, 0);
			compiler.loopopts.BadPredicateAfterPartialPeel.m_helper(i, 2, i);
		}
	}
}