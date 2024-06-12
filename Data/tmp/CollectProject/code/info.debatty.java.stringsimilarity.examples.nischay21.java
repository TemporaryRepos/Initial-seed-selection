public class nischay21 {
	public static void main(java.lang.String[] args) {
		java.lang.String s1 = "MINI GRINDER KIT";
		java.lang.String s2 = "Weiler 13001 Mini Grinder Accessory Kit, For Use With Small Right Angle Grinders";
		java.lang.String s3 = "Milwaukee Video Borescope, Rotating Inspection Scope, Series: M-SPECTOR 360, 2.7 in 640 x 480 pixels High-Resolution LCD, Plastic, Black/Red";
		java.util.LinkedList<info.debatty.java.stringsimilarity.interfaces.StringDistance> algos = new java.util.LinkedList<info.debatty.java.stringsimilarity.interfaces.StringDistance>();
		algos.add(new info.debatty.java.stringsimilarity.JaroWinkler());
		algos.add(new info.debatty.java.stringsimilarity.Levenshtein());
		algos.add(new info.debatty.java.stringsimilarity.NGram());
		algos.add(new info.debatty.java.stringsimilarity.Damerau());
		algos.add(new info.debatty.java.stringsimilarity.Jaccard());
		algos.add(new info.debatty.java.stringsimilarity.SorensenDice());
		algos.add(new info.debatty.java.stringsimilarity.Cosine());
		java.lang.System.out.println("S1 vs S2");
		for (info.debatty.java.stringsimilarity.interfaces.StringDistance algo : algos) {
			java.lang.System.out.print(algo.getClass().getSimpleName() + " : ");
			java.lang.System.out.println(algo.distance(s1, s2));
		}
		java.lang.System.out.println();
		java.lang.System.out.println("S1 vs S3");
		for (info.debatty.java.stringsimilarity.interfaces.StringDistance algo : algos) {
			java.lang.System.out.print(algo.getClass().getSimpleName() + " : ");
			java.lang.System.out.println(algo.distance(s1, s3));
		}
		java.lang.System.out.println();
		java.lang.System.out.println("With .toLower()");
		java.lang.System.out.println("S1 vs S2");
		for (info.debatty.java.stringsimilarity.interfaces.StringDistance algo : algos) {
			java.lang.System.out.print(algo.getClass().getSimpleName() + " : ");
			java.lang.System.out.println(algo.distance(s1.toLowerCase(), s2.toLowerCase()));
		}
		java.lang.System.out.println();
		java.lang.System.out.println("S1 vs S3");
		for (info.debatty.java.stringsimilarity.interfaces.StringDistance algo : algos) {
			java.lang.System.out.print(algo.getClass().getSimpleName() + " : ");
			java.lang.System.out.println(algo.distance(s1.toLowerCase(), s3.toLowerCase()));
		}
		java.lang.System.out.println();
	}
}