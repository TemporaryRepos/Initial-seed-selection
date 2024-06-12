public class lookup {
	public static void printAnswer(java.lang.String name, org.xbill.DNS.Lookup lookup) {
		java.lang.System.out.print(name + ":");
		int result = lookup.getResult();
		if (result != org.xbill.DNS.Lookup.SUCCESSFUL) {
			java.lang.System.out.print(" " + lookup.getErrorString());
		}
		java.lang.System.out.println();
		org.xbill.DNS.Name[] aliases = lookup.getAliases();
		if (aliases.length > 0) {
			java.lang.System.out.print("# aliases: ");
			for (int i = 0; i < aliases.length; i++) {
				java.lang.System.out.print(aliases[i]);
				if (i < (aliases.length - 1)) {
					java.lang.System.out.print(" ");
				}
			}
			java.lang.System.out.println();
		}
		if (lookup.getResult() == org.xbill.DNS.Lookup.SUCCESSFUL) {
			org.xbill.DNS.Record[] answers = lookup.getAnswers();
			for (org.xbill.DNS.Record answer : answers) {
				java.lang.System.out.println(answer);
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int type = org.xbill.DNS.Type.A;
		int start = 0;
		if ((args.length > 2) && args[0].equals("-t")) {
			type = org.xbill.DNS.Type.value(args[1]);
			if (type < 0) {
				throw new java.lang.IllegalArgumentException("invalid type");
			}
			start = 2;
		}
		for (int i = start; i < args.length; i++) {
			org.xbill.DNS.Lookup l = new org.xbill.DNS.Lookup(args[i], type);
			l.run();
			org.xbill.DNS.tools.lookup.printAnswer(args[i], l);
		}
	}
}