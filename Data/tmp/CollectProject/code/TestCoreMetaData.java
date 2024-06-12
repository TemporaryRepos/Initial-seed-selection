public class TestCoreMetaData {
	public static void main(java.lang.String[] args) {
		final class DumpGrp implements com.tictactec.ta.lib.meta.TaGrpService {
			public void execute(java.lang.String group, java.util.Set<com.tictactec.ta.lib.meta.CoreMetaData> set) {
				java.lang.System.out.println("GROUP " + group);
				for (com.tictactec.ta.lib.meta.CoreMetaData mi : set) {
					java.lang.System.out.println("        " + mi.getFuncInfo().name());
				}
			}
		}
		final class DumpFunc implements com.tictactec.ta.lib.meta.TaFuncService {
			public void execute(com.tictactec.ta.lib.meta.CoreMetaData mi) {
				java.lang.System.out.println(mi.getFuncInfo().name());
				for (int i = 0; i < mi.getFuncInfo().nbInput(); i++) {
					com.tictactec.ta.lib.meta.annotation.InputParameterInfo pinfo = mi.getInputParameterInfo(i);
					java.lang.System.out.println("    " + pinfo.paramName());
					java.lang.System.out.println("        " + pinfo.type());
				}
				for (int i = 0; i < mi.getFuncInfo().nbOptInput(); i++) {
					com.tictactec.ta.lib.meta.annotation.OptInputParameterInfo pinfo = mi.getOptInputParameterInfo(i);
					java.lang.System.out.println("    " + pinfo.paramName());
					java.lang.System.out.println("        " + pinfo.type());
					switch (pinfo.type()) {
						case TA_OptInput_RealRange :
							com.tictactec.ta.lib.meta.annotation.RealRange rrange = mi.getOptInputRealRange(i);
							java.lang.System.out.println("            min=" + rrange.min());
							java.lang.System.out.println("            max=" + rrange.max());
							java.lang.System.out.println("            precision=" + rrange.precision());
							java.lang.System.out.println("            default=" + rrange.defaultValue());
							break;
						case TA_OptInput_RealList :
							com.tictactec.ta.lib.meta.annotation.RealList rlist = mi.getOptInputRealList(i);
							java.lang.System.out.print("            value=");
							for (double value : rlist.value()) {
								java.lang.System.out.print(value);
								java.lang.System.out.print(" ");
							}
							java.lang.System.out.println();
							java.lang.System.out.print("            string=" + rlist.string());
							for (java.lang.String string : rlist.string()) {
								java.lang.System.out.print(string);
								java.lang.System.out.print(" ");
							}
							java.lang.System.out.println();
							break;
						case TA_OptInput_IntegerRange :
							com.tictactec.ta.lib.meta.annotation.IntegerRange irange = mi.getOptInputIntegerRange(i);
							java.lang.System.out.println("            min=" + irange.min());
							java.lang.System.out.println("            max=" + irange.max());
							java.lang.System.out.println("            default=" + irange.defaultValue());
							break;
						case TA_OptInput_IntegerList :
							com.tictactec.ta.lib.meta.annotation.IntegerList ilist = mi.getOptInputIntegerList(i);
							java.lang.System.out.print("            value=");
							for (int value : ilist.value()) {
								java.lang.System.out.print(value);
								java.lang.System.out.print(" ");
							}
							java.lang.System.out.println();
							java.lang.System.out.print("            string=");
							for (java.lang.String string : ilist.string()) {
								java.lang.System.out.print(string);
								java.lang.System.out.print(" ");
							}
							java.lang.System.out.println();
							break;
					}
				}
				for (int i = 0; i < mi.getFuncInfo().nbOutput(); i++) {
					com.tictactec.ta.lib.meta.annotation.OutputParameterInfo pinfo = mi.getOutputParameterInfo(i);
					java.lang.System.out.println("    " + pinfo.paramName());
					java.lang.System.out.println("        " + pinfo.type());
				}
			}
		}
		com.tictactec.ta.lib.meta.TaGrpService grpServ = new DumpGrp();
		try {
			com.tictactec.ta.lib.meta.CoreMetaData.forEachGrp(grpServ);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		java.lang.System.out.println("=  =  =  =  =  =  =  =  =  =  =  =  =");
		com.tictactec.ta.lib.meta.TaFuncService funcServ = new DumpFunc();
		try {
			com.tictactec.ta.lib.meta.CoreMetaData.forEachFunc(funcServ);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		java.lang.System.out.println("=====================================");
		com.tictactec.ta.lib.meta.helpers.SimpleHelper calc;
		double[] open = new double[]{ 1.4054, 1.406, 1.4062, 1.4059, 1.4057, 1.4057, 1.4051, 1.4054, 1.4056, 1.4056, 1.4054, 1.406, 1.4062, 1.4059, 1.4057, 1.4057, 1.4051, 1.4054, 1.4056, 1.4056, 1.4054, 1.406, 1.4062, 1.4059, 1.4057, 1.4057, 1.4051, 1.4054, 1.4056, 1.4056, 1.4054, 1.406, 1.4062, 1.4059, 1.4057, 1.4057, 1.4051, 1.4054, 1.4056, 1.4056, 1.4054, 1.406, 1.4062, 1.4059, 1.4057, 1.4057, 1.4051, 1.4054, 1.4056, 1.4056, 1.4054, 1.406, 1.4062, 1.4059, 1.4057, 1.4057, 1.4051, 1.4054, 1.4056, 1.4056 };
		double[] high = new double[]{ 1.4654, 1.466, 1.4662, 1.4659, 1.4657, 1.4657, 1.4651, 1.4654, 1.4656, 1.4656, 1.4654, 1.466, 1.4662, 1.4659, 1.4657, 1.4657, 1.4651, 1.4654, 1.4656, 1.4656, 1.4654, 1.466, 1.4662, 1.4659, 1.4657, 1.4657, 1.4651, 1.4654, 1.4656, 1.4656, 1.4654, 1.466, 1.4662, 1.4659, 1.4657, 1.4657, 1.4651, 1.4654, 1.4656, 1.4656, 1.4654, 1.466, 1.4662, 1.4659, 1.4657, 1.4657, 1.4651, 1.4654, 1.4656, 1.4656, 1.4654, 1.466, 1.4662, 1.4659, 1.4657, 1.4657, 1.4651, 1.4654, 1.4656, 1.4656 };
		double[] low = new double[]{ 1.3954, 1.396, 1.3962, 1.3959, 1.3957, 1.3957, 1.3951, 1.3954, 1.3956, 1.3956, 1.3954, 1.396, 1.3962, 1.3959, 1.3957, 1.3957, 1.3951, 1.3954, 1.3956, 1.3956, 1.3954, 1.396, 1.3962, 1.3959, 1.3957, 1.3957, 1.3951, 1.3954, 1.3956, 1.3956, 1.3954, 1.396, 1.3962, 1.3959, 1.3957, 1.3957, 1.3951, 1.3954, 1.3956, 1.3956, 1.3954, 1.396, 1.3962, 1.3959, 1.3957, 1.3957, 1.3951, 1.3954, 1.3956, 1.3956, 1.3954, 1.396, 1.3962, 1.3959, 1.3957, 1.3957, 1.3951, 1.3954, 1.3956, 1.3956 };
		double[] close = new double[]{ 1.4554, 1.456, 1.4562, 1.4559, 1.4557, 1.4557, 1.4551, 1.4554, 1.4556, 1.4556, 1.4554, 1.456, 1.4562, 1.4559, 1.4557, 1.4557, 1.4551, 1.4554, 1.4556, 1.4556, 1.4554, 1.456, 1.4562, 1.4559, 1.4557, 1.4557, 1.4551, 1.4554, 1.4556, 1.4556, 1.4554, 1.456, 1.4562, 1.4559, 1.4557, 1.4557, 1.4551, 1.4554, 1.4556, 1.4556, 1.4554, 1.456, 1.4562, 1.4559, 1.4557, 1.4557, 1.4551, 1.4554, 1.4556, 1.4556, 1.4554, 1.456, 1.4562, 1.4559, 1.4557, 1.4557, 1.4551, 1.4554, 1.4556, 1.4556 };
		double[] output1 = new double[60];
		double[] output2 = new double[60];
		double[] output3 = new double[60];
		com.tictactec.ta.lib.MInteger lOutIdx = new com.tictactec.ta.lib.MInteger();
		com.tictactec.ta.lib.MInteger lOutSize = new com.tictactec.ta.lib.MInteger();
		java.lang.String func;
		java.util.List<java.lang.String> params = new java.util.ArrayList<java.lang.String>();
		try {
			func = "MAMA";
			params.clear();
			params.add("0.2");
			params.add("0.02");
			calc = new com.tictactec.ta.lib.meta.helpers.SimpleHelper(func, params);
			java.lang.System.out.println("===============================================");
			java.lang.System.out.println(func);
			calc.calculate(0, 59, new java.lang.Object[]{ close }, new java.lang.Object[]{ output1, output2 }, lOutIdx, lOutSize);
			java.lang.System.out.println("lookback=" + calc.getLookback());
			java.lang.System.out.println((("outBegIdx    = " + lOutIdx.value) + "    outNbElement = ") + lOutSize.value);
			for (int i = 0; i < lOutSize.value; i++) {
				java.lang.System.out.println(((((((("output1[" + i) + "]=") + output1[i]) + "     ") + "output2[") + i) + "]=") + output2[i]);
			}
			func = "bbands";
			params.clear();
			params.add("8");
			params.add("0.02");
			params.add("0.04");
			params.add("dEmA");
			calc = new com.tictactec.ta.lib.meta.helpers.SimpleHelper(func, params);
			java.lang.System.out.println("===============================================");
			java.lang.System.out.println(func);
			calc.calculate(0, 59, new java.lang.Object[]{ close }, new java.lang.Object[]{ output1, output2, output3 }, lOutIdx, lOutSize);
			java.lang.System.out.println("lookback=" + calc.getLookback());
			java.lang.System.out.println((("outBegIdx    = " + lOutIdx.value) + "    outNbElement = ") + lOutSize.value);
			for (int i = 0; i < lOutSize.value; i++) {
				java.lang.System.out.println((((((((((((("output1[" + i) + "]=") + output1[i]) + "     ") + "output2[") + i) + "]=") + output2[i]) + "     ") + "output3[") + i) + "]=") + output3[i]);
			}
			func = "Adx";
			params.clear();
			params.add("8");
			calc = new com.tictactec.ta.lib.meta.helpers.SimpleHelper(func, params);
			java.lang.System.out.println("===============================================");
			java.lang.System.out.println(func);
			int flags = calc.getMetaData().getInputParameterInfo(0).flags();
			com.tictactec.ta.lib.meta.PriceHolder price = new com.tictactec.ta.lib.meta.PriceInputParameter(flags, open, high, low, close, null, null);
			calc.calculate(0, 59, new java.lang.Object[]{ price }, new java.lang.Object[]{ output1 }, lOutIdx, lOutSize);
			java.lang.System.out.println("lookback=" + calc.getLookback());
			java.lang.System.out.println((("outBegIdx    = " + lOutIdx.value) + "    outNbElement = ") + lOutSize.value);
			for (int i = 0; i < lOutSize.value; i++) {
				java.lang.System.out.println((("output1[" + i) + "]=") + output1[i]);
			}
			func = "rsi";
			params.clear();
			params.add("8");
			calc = new com.tictactec.ta.lib.meta.helpers.SimpleHelper(func, params);
			java.lang.System.out.println("===============================================");
			java.lang.System.out.println(func);
			calc.calculate(0, 59, new java.lang.Object[]{ close }, new java.lang.Object[]{ output1 }, lOutIdx, lOutSize);
			java.lang.System.out.println("lookback=" + calc.getLookback());
			java.lang.System.out.println((("outBegIdx    = " + lOutIdx.value) + "    outNbElement = ") + lOutSize.value);
			for (int i = 0; i < lOutSize.value; i++) {
				java.lang.System.out.println((("output1[" + i) + "]=") + output1[i]);
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}