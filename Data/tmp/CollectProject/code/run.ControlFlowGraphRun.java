public class ControlFlowGraphRun {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.utils.FileUtils.readBytes(filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes);
		org.objectweb.asm.tree.ClassNode cn = new org.objectweb.asm.tree.ClassNode();
		int parsingOptions = org.objectweb.asm.ClassReader.SKIP_DEBUG | org.objectweb.asm.ClassReader.SKIP_FRAMES;
		cr.accept(cn, parsingOptions);
		java.lang.String methodName = "test";
		org.objectweb.asm.tree.MethodNode targetNode = null;
		for (org.objectweb.asm.tree.MethodNode mn : cn.methods) {
			if (mn.name.equals(methodName)) {
				targetNode = mn;
				break;
			}
		}
		if (targetNode == null) {
			java.lang.System.out.println("Can not find method: " + methodName);
			return;
		}
		java.lang.System.out.println("Origin:");
		run.ControlFlowGraphRun.display(cn.name, targetNode, run.ControlFlowGraphType.NONE);
		java.lang.System.out.println("Control Flow Graph:");
		run.ControlFlowGraphRun.display(cn.name, targetNode, run.ControlFlowGraphType.STANDARD);
		int complexity = lsieun.asm.analysis.cc.CyclomaticComplexity.getCyclomaticComplexity(cn.name, targetNode);
		java.lang.String line = java.lang.String.format("%s:%s complexity: %d", targetNode.name, targetNode.desc, complexity);
		java.lang.System.out.println(line);
	}

	private static void display(java.lang.String owner, org.objectweb.asm.tree.MethodNode mn, run.ControlFlowGraphType option) throws org.objectweb.asm.tree.analysis.AnalyzerException {
		lsieun.asm.analysis.graph.InsnBlock[] blocks;
		switch (option) {
			case NONE :
				{
					lsieun.asm.analysis.InsnText insnText = new lsieun.asm.analysis.InsnText();
					java.util.List<java.lang.String> lines = insnText.toLines(mn.instructions.toArray());
					lsieun.asm.analysis.graph.InsnBlock block = new lsieun.asm.analysis.graph.InsnBlock();
					block.addLines(lines);
					blocks = new lsieun.asm.analysis.graph.InsnBlock[1];
					blocks[0] = block;
					break;
				}
			case ONE_INSN_ONE_BOX :
				{
					lsieun.asm.analysis.ControlFlowEdgeAnalyzer<org.objectweb.asm.tree.analysis.BasicValue> analyzer = new lsieun.asm.analysis.ControlFlowEdgeAnalyzer<>(new org.objectweb.asm.tree.analysis.BasicInterpreter());
					analyzer.analyze(owner, mn);
					blocks = analyzer.getBlocks();
					break;
				}
			case MULTI_INSN_ONE_BOX :
			case STANDARD :
				{
					lsieun.asm.analysis.ControlFlowEdgeAnalyzer<org.objectweb.asm.tree.analysis.BasicValue> analyzer = new lsieun.asm.analysis.ControlFlowEdgeAnalyzer2<>(new org.objectweb.asm.tree.analysis.BasicInterpreter());
					analyzer.analyze(owner, mn);
					blocks = analyzer.getBlocks();
					break;
				}
			case EXPERIMENT_ONE_INSN_ONE_BOX :
				{
					lsieun.asm.analysis.ControlFlowAnalyzer2 analyzer = new lsieun.asm.analysis.ControlFlowAnalyzer2();
					analyzer.analyze(owner, mn);
					blocks = analyzer.getBlocks();
					break;
				}
			case EXPERIMENT_MULTI_INSN_ONE_BOX :
				{
					lsieun.asm.analysis.ControlFlowGraphAnalyzer analyzer = new lsieun.asm.analysis.ControlFlowGraphAnalyzer();
					analyzer.analyze(mn);
					blocks = analyzer.getBlocks();
					break;
				}
			default :
				{
					throw new java.lang.RuntimeException("unknown type: " + option);
				}
		}
		lsieun.asm.analysis.graph.TextGraph textGraph = new lsieun.asm.analysis.graph.TextGraph(blocks);
		textGraph.draw(0, 0);
	}
}