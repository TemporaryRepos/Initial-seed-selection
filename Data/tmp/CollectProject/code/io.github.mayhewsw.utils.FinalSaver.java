public class FinalSaver {
	public static void save(java.lang.String origfolder, java.lang.String romanfolder, java.lang.String outfolder) throws java.io.IOException {
		if (new java.io.File(outfolder).exists()) {
			edu.illinois.cs.cogcomp.nlp.corpusreaders.CoNLLNerReader cnl = new edu.illinois.cs.cogcomp.nlp.corpusreaders.CoNLLNerReader(romanfolder);
			while (cnl.hasNext()) {
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = cnl.next();
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation taorig = new edu.illinois.cs.cogcomp.nlp.corpusreaders.CoNLLNerReader((origfolder + "/") + ta.getId()).next();
				taorig.addView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL, ner);
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.View nerorig = taorig.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.View sents = taorig.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.SENTENCE);
				for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent sent : sents.getConstituents()) {
					java.lang.String sentid = io.github.mayhewsw.controllers.SentenceController.getSentId(sent);
					if (nerorig.getConstituentsCovering(sent).size() == 0) {
						continue;
					}
					io.github.mayhewsw.utils.FinalSaver.SentToConll(sent, outfolder);
				}
			} 
		} else {
			java.lang.System.out.println(outfolder + " does not exist. Not doing anything.");
		}
	}

	public static void SentToConll(edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent sent, java.lang.String outpath) throws java.io.IOException {
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = sent.getTextAnnotation();
		java.util.ArrayList talines = new java.util.ArrayList();
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.View nerview = ta.getView("NER_CONLL");
		for (int i = sent.getStartSpan(); i < sent.getEndSpan(); ++i) {
			java.lang.String label = "O";
			java.util.List constituents = nerview.getConstituentsCoveringToken(i);
			if (constituents.size() > 0) {
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent sents = ((edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent) (constituents.get(0)));
				if (sents.getStartSpan() == i) {
					label = "B-" + sents.getLabel();
				} else {
					label = "I-" + sents.getLabel();
				}
			}
			talines.add(edu.illinois.cs.cogcomp.nlp.corpusreaders.CoNLLNerReader.conllline(label, i, ta.getToken(i)));
		}
		org.apache.commons.io.FileUtils.writeLines(java.nio.file.Paths.get(outpath, new java.lang.String[]{ io.github.mayhewsw.controllers.SentenceController.getSentId(sent) }).toFile(), talines);
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.lang.String username = "steve";
		java.lang.String dir = "/shared/corpora/corporaWeb/lorelei/evaluation-20170804/LDC2017E29_LORELEI_IL6_Incident_Language_Pack_for_Year_2_Eval_V1.1/";
		java.lang.String origfolder = (dir + "conll-set0-sentanno-") + username;
		java.lang.String romanfolder = (dir + "conll-set0-sentanno-") + username;
		java.lang.String outpath = ((dir + "final-") + username) + "/";
		io.github.mayhewsw.utils.FinalSaver.save(origfolder, romanfolder, outpath);
	}
}