package logicalProcessImpl;

import logicalProcess.JudgeRelation;
import util.JudgeInput;

public class JudgeRelationImpl extends JudgeNatureImpl implements JudgeRelation  {
	boolean zf = false,fzf = false,dc = false,fdc = false,xr = false,dj = false,px = false,cd = false;
	
	public String compatbility(String set,String formula) {
		
		
		zf = reflexivity(set,formula);
		dc = symmetry(set,formula);
		
		if(zf && dc) {
			return "相容关系成立！";
		}
		return "相容关系不成立！";
	}
	
	public String equivalence(String set,String formula) {
		
		zf = reflexivity(set,formula);
		dc = symmetry(set,formula);
		cd = transitivity(set,formula);
		if(zf && dc) {
			return "等价关系成立！";
		}
		return "等价关系不成立！";
	}
	
	public String partialOrder (String set,String formula) {
		
		zf = reflexivity(set,formula);
		fzf = antiSymmetry(set,formula);
		cd = transitivity(set,formula);
		if(zf && fzf && cd) {
			return "偏序关系成立！";
		}
		return "偏序关系不成立！";
	}

}
