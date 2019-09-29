package logicalProcessImpl;

import logicalProcess.JudgeRelation;
import util.JudgeInput;

public class JudgeRelationImpl extends JudgeNatureImpl implements JudgeRelation  {
	boolean zf = false,fzf = false,dc = false,fdc = false,xr = false,dj = false,px = false,cd = false;
	
	public String compatbility(String set,String formula) {
		
		
		zf = reflexivity(set,formula);
		dc = symmetry(set,formula);
		
		if(zf && dc) {
			return "���ݹ�ϵ������";
		}
		return "���ݹ�ϵ��������";
	}
	
	public String equivalence(String set,String formula) {
		
		zf = reflexivity(set,formula);
		dc = symmetry(set,formula);
		cd = transitivity(set,formula);
		if(zf && dc) {
			return "�ȼ۹�ϵ������";
		}
		return "�ȼ۹�ϵ��������";
	}
	
	public String partialOrder (String set,String formula) {
		
		zf = reflexivity(set,formula);
		fzf = antiSymmetry(set,formula);
		cd = transitivity(set,formula);
		if(zf && fzf && cd) {
			return "ƫ���ϵ������";
		}
		return "ƫ���ϵ��������";
	}

}
