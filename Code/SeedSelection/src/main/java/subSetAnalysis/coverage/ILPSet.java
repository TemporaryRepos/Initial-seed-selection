package subSetAnalysis.coverage;

import utils.BitMap;
import utils.ILPSolver;
import ilog.concert.IloException;

import java.util.List;

public class ILPSet extends CoverageSubSet {

    public ILPSet(List<BitMap> bitMapList, double budget, double originSize) {
        super(budget, originSize);
        this.bitMapList = bitMapList;
        allBitMap = new BitMap(bitMapList.get(0).getBits().size(),"allBitMap",0);
    }



    @Override
    public void reduce() throws IloException{
        if(ILPSolver.initAndConstruct(bitMapList,ILPSolver.SIZE_TARGET)){
            for(int i =0;i<ILPSolver.getVars().size();i++){
                if(ILPSolver.getCplex().getValue(ILPSolver.getVars().get(i)) == 1.0){
                    allBitMap = BitMap.add(allBitMap,bitMapList.get(i),"allBitMap",0);
                    sumTime += bitMapList.get(i).getExeTime();
                    fileNameList.add(bitMapList.get(i).getFileName());
                }
            }
        }
    }
}
