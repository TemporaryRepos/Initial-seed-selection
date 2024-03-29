import subSetAnalysis.coverage.ILPSet;
import subSetAnalysis.coverage.MinSet;
import subSetAnalysis.coverage.PeachSet;
import subSetAnalysis.programFeature.FPSSet;
import subSetAnalysis.uniqueBug.HotSet;
import utils.BitMap;
import utils.DTPlatform;
import utils.DiffLogAnalyzer;
import ilog.concert.IloException;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 生成 SubSet 使用的类
 */
public class Main {
    public static String covRootPath;
    public static String bugRootPath;
    public static String featureRootPath;

    public static void main(String[] args) throws IOException, ClassNotFoundException, IloException {
        String rootPath = System.getProperty("user.dir")+DTPlatform.FILE_SEPARATOR+".."+DTPlatform.FILE_SEPARATOR+"..";

        List<String> projectList = new ArrayList<>();
        projectList.add("HotspotTests-Java");
        projectList.add("Openj9Test-Test");
        projectList.add("CollectProject");
        for (String project : projectList) {

            String outPath = rootPath+DTPlatform.FILE_SEPARATOR+"Results"+DTPlatform.FILE_SEPARATOR+"subset"+DTPlatform.FILE_SEPARATOR+project;
            new File(outPath).mkdirs();
            List<Integer> budgets = new ArrayList<>();

            budgets.add(5);
            budgets.add(20);
            budgets.add(35);
            budgets.add(50);
            budgets.add(65);
            budgets.add(80);
            budgets.add(95);

            int originSize = 0;
            File inputFile = new File(rootPath+DTPlatform.FILE_SEPARATOR+"Data"+DTPlatform.FILE_SEPARATOR+"benchmarks"+DTPlatform.FILE_SEPARATOR+project+DTPlatform.FILE_SEPARATOR+"testcases.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line = bufferedReader.readLine();
            while(line!=null){
                originSize++;
                line=bufferedReader.readLine();
            }
            int maxBudget = 0;
            for (Integer budget : budgets) {
                if(budget>maxBudget){
                    maxBudget = budget;
                }
            }

            long startTime = 0;
            long endTime = 0;

            bugRootPath = rootPath+DTPlatform.FILE_SEPARATOR+"Data"+DTPlatform.FILE_SEPARATOR+"bugInfo"+DTPlatform.FILE_SEPARATOR+project;
            startTime = System.currentTimeMillis();
            writeFile(PISS(originSize,maxBudget),originSize,budgets,outPath,"HotSet");
            endTime = System.currentTimeMillis();
            System.out.println("HotSet Time:"+(endTime-startTime)/1000);

            featureRootPath = rootPath+DTPlatform.FILE_SEPARATOR+"Data"+DTPlatform.FILE_SEPARATOR+"featureInfo"+DTPlatform.FILE_SEPARATOR+project;
            startTime = System.currentTimeMillis();
            writeFile(FISS("TF_IDF", originSize,maxBudget),originSize,budgets,outPath,"TF_IDF_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("TF_IDF Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(FISS("3gramCFG", originSize,maxBudget),originSize,budgets,outPath,"3gramCFG_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("3gramCFG Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(FISS("3gramAST", originSize,maxBudget),originSize,budgets,outPath,"3gramAST_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("3gramAST Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(FISS("CodeBERT", originSize,maxBudget),originSize,budgets,outPath,"CodeBERT_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("CodeBERT Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(FISS("CodeT5", originSize,maxBudget),originSize,budgets,outPath,"CodeT5_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("CodeT5 Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(FISS("PLBART", originSize,maxBudget),originSize,budgets,outPath,"PLBART_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("PLBART Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(FISS("InferCode", originSize,maxBudget),originSize,budgets,outPath,"InferCode_ARTSet");
            endTime = System.currentTimeMillis();
            System.out.println("InferCode Time:"+(endTime-startTime)/1000);

            covRootPath = rootPath+DTPlatform.FILE_SEPARATOR+"Data"+DTPlatform.FILE_SEPARATOR+"covInfo"+DTPlatform.FILE_SEPARATOR+project+DTPlatform.FILE_SEPARATOR+"lineBitMap";
            startTime = System.currentTimeMillis();
            writeFile(CISS_m(originSize,maxBudget),originSize,budgets,outPath,"line_MinSet");
            endTime = System.currentTimeMillis();
            System.out.println("line_MinSet Time:"+(endTime-startTime)/1000);

            startTime = System.currentTimeMillis();
            writeFile(CISS_p(originSize,maxBudget),originSize,budgets,outPath,"line_PeachSet");
            endTime = System.currentTimeMillis();
            System.out.println("line_PeachSet Time:"+(endTime-startTime)/1000);

//            covRootPath = rootPath+DTPlatform.FILE_SEPARATOR+"Data"+DTPlatform.FILE_SEPARATOR+"covInfo"+DTPlatform.FILE_SEPARATOR+project+DTPlatform.FILE_SEPARATOR+"branchBitMap";
//            startTime = System.currentTimeMillis();
//            writeFile(CISS_m(originSize,maxBudget),originSize,budgets,outPath,"branch_MinSet");
//            endTime = System.currentTimeMillis();
//            System.out.println("branch_MinSet Time:"+(endTime-startTime)/1000);
//
//            startTime = System.currentTimeMillis();
//            writeFile(CISS_p(originSize,maxBudget),originSize,budgets,outPath,"branch_PeachSet");
//            endTime = System.currentTimeMillis();
//            System.out.println("branch_PeachSet Time:"+(endTime-startTime)/1000);


        }
    }
    public static List<String> PISS(double originSize, double maxBudget) throws IOException, ClassNotFoundException, IloException {
        BitMap allBitMap = null;
        List<BitMap> bitMapList = new ArrayList<>();
        File file = new File(bugRootPath + DTPlatform.FILE_SEPARATOR + "bitmap");
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            String fileName = listFile.getName().split("@")[0];
            if (skipClass(fileName)) {
                continue;
            }
            double exeTime = Long.parseLong(listFile.getName().split("@")[1].split("\\.")[0]);
            BitMap bitMap = new BitMap(listFile.getAbsolutePath(),fileName,exeTime);
            bitMapList.add(bitMap);
            if(allBitMap == null){
                allBitMap = new BitMap(bitMap.getBits().size(),"allBitMap",0);
            }
            allBitMap = BitMap.add(allBitMap,bitMap,"allBitMap",0);
        }

        HotSet subset = new HotSet(bitMapList,maxBudget,originSize);
        subset.reduce();

        assert allBitMap != null;
        System.out.println(allBitMap.hitCount());
        System.out.println(subset.getAllBitMap().hitCount());
        System.out.println(subset.getSumTime());

        return subset.getFileNameList();
    }
    public static List<String> CISS_m(double originSize, double maxBudget) throws IOException, ClassNotFoundException {
        BitMap allBitMap = null;
        List<BitMap> bitMapList = new ArrayList<>();
        File file = new File(covRootPath);
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            String fileName = listFile.getName().split("@")[0];
            if (skipClass(fileName)) {
                continue;
            }
            double exeTime = Long.parseLong(listFile.getName().split("@")[1].split("\\.")[0]);
            BitMap bitMap = new BitMap(listFile.getAbsolutePath(),fileName,exeTime);
            bitMapList.add(bitMap);
            if(allBitMap == null){
                allBitMap = new BitMap(bitMap.getBits().size(),"allBitMap",0);
            }
            allBitMap = BitMap.add(allBitMap,bitMap,"allBitMap",0);
        }
        MinSet subset = new MinSet(bitMapList,maxBudget,originSize);
        subset.reduce();
        assert allBitMap != null;
        System.out.println(allBitMap.hitCount());
        System.out.println(subset.getAllBitMap().hitCount());
        System.out.println(subset.getSumTime());

        return subset.getFileNameList();
    }
    public static List<String> CISS_p(double originSize, double maxBudget) throws IOException, ClassNotFoundException {
        BitMap allBitMap = null;
        List<BitMap> bitMapList = new ArrayList<>();
        File file = new File(covRootPath);
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            String fileName = listFile.getName().split("@")[0];
            if (skipClass(fileName)) {
                continue;
            }
            double exeTime = Long.parseLong(listFile.getName().split("@")[1].split("\\.")[0]);
            BitMap bitMap = new BitMap(listFile.getAbsolutePath(),fileName,exeTime);
            bitMapList.add(bitMap);
            if(allBitMap == null){
                allBitMap = new BitMap(bitMap.getBits().size(),"allBitMap",0);
            }
            allBitMap = BitMap.add(allBitMap,bitMap,"allBitMap",0);
        }
        PeachSet subset = new PeachSet(bitMapList, maxBudget, originSize);
        subset.reduce();

        assert allBitMap != null;
        System.out.println(allBitMap.hitCount());
        System.out.println(subset.getAllBitMap().hitCount());
        System.out.println(subset.getSumTime());

        return subset.getFileNameList();
    }
    public static List<String> genILPSet(double originSize, double maxBudget) throws IOException, ClassNotFoundException, IloException {
        BitMap allBitMap = null;
        List<BitMap> bitMapList = new ArrayList<>();
        File file = new File(covRootPath);
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            String fileName = listFile.getName().split("@")[0];
            if (skipClass(fileName)) {
                continue;
            }
            double exeTime = Long.parseLong(listFile.getName().split("@")[1].split("\\.")[0]);
            BitMap bitMap = new BitMap(listFile.getAbsolutePath(),fileName,exeTime);
            bitMapList.add(bitMap);
            if(allBitMap == null){
                allBitMap = new BitMap(bitMap.getBits().size(),"allBitMap",0);
            }
            allBitMap = BitMap.add(allBitMap,bitMap,"allBitMap",0);
        }
        ILPSet subset = new ILPSet(bitMapList, maxBudget, originSize);
        subset.reduce();
        assert allBitMap != null;
        System.out.println(allBitMap.hitCount());
        System.out.println(subset.getAllBitMap().hitCount());
        System.out.println(subset.getSumTime());
        return subset.getFileNameList();
    }
    public static List<String> FISS(String modelName, double originSize, double maxBudget) throws IOException, ClassNotFoundException, IloException {
        FPSSet subset = new FPSSet("",featureRootPath+DTPlatform.FILE_SEPARATOR+modelName+"Vectors.csv", maxBudget, originSize );
        subset.reduce();
        return subset.getFileNameList();
    }
    private static void writeFile(List<String> fileNameList,double originSize, List<Integer> budgets, String outPath, String method) throws IOException {
        for (Integer budget : budgets) {
            int targetSize = (int) (originSize * budget / 100);
            if (targetSize > fileNameList.size()) {
                targetSize = fileNameList.size();
            }
            List<String> subList = fileNameList.subList(0, targetSize);
            File file= new File(outPath+DTPlatform.FILE_SEPARATOR+method+"_"+budget+".txt");
            FileWriter fileWriter = new FileWriter(file);
            for (String line : subList) {
                fileWriter.write(line.replace(".bitmap", "") + "\n");
            }
            fileWriter.close();
        }
    }

    private static boolean skipClass(String className){
        List<String> skipList = new ArrayList<>();

        // skipClass for CollectProject
        skipList.add("edu.ntnu.texasai.PrintOpponentsModel");
        skipList.add("edu.ntnu.texasai.PrintPreFlop");
        skipList.add("cn.ponfee.commons.boolm.GuavaBloomFilterTest");
        skipList.add("com.pancm.utils.QrCodeCreateUtil");
        skipList.add("org.jetlang.examples.nio.MulticastSend");
        skipList.add("com.thealgorithms.sorts.BucketSort");
        skipList.add("com.github.davidmoten.rx.AdHoc");
        skipList.add("cn.ponfee.commons.jce.PBECryptorTest");
        skipList.add("com.vgrazi.javaconcurrentanimated.study.ReactorStudy");
        skipList.add("com.doinb.jdbc.JDBCDemo");
        skipList.add("com.doinb.executor.MyThreadPoolExecutorDemo");
        skipList.add("jsr166tests.loops.FinalLongTest");
        skipList.add("cn.ponfee.commons.json.JacksonIgnore");
        skipList.add("com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting");
        skipList.add("jsr166tests.jtreg.util.IdentityHashMap.ToArray");
        skipList.add("cn.ponfee.commons.event.EventBusTest");
        skipList.add("ch3.s1.TimeLock");
        skipList.add("cn.ponfee.commons.json.BooleanPojoTest");
        skipList.add("cn.ponfee.commons.jce.security.DSASignerTest");

        return skipList.contains(className);
    }

}
