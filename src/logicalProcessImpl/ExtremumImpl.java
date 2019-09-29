package logicalProcessImpl;

import util.JudgeInput;
import util.StringCutting;

public class ExtremumImpl extends JudgeNatureImpl {
	
	public String getExtremum(String set,String formula) {
		
		int i = 0;
		int j = 0;
		boolean max,min; 
		boolean zf = false,fdc = false, cd = false;
		String result = new String();
		
		StringBuilder strMax = new StringBuilder("极大值：");
		StringBuilder strMin = new StringBuilder("极小值：");
		
		if(!JudgeInput.judgeSet(set)) {
			return "非法输入！";
		}
		
		String[] setX = StringCutting.setToNum(set);
		int lengthX = StringCutting.repetition(setX);
		
		if(formula.equals("{}")) {
			for(i=0;i<lengthX;i++) {
				strMax.append(setX[i]+",");
				strMax.append(setX[i]+",");
			}
			int index = strMax.length() - 1;
			strMax.deleteCharAt(index);
			strMax.append('\n');
			index = strMin.length() - 1;
			strMin.deleteCharAt(index);
			result = strMax.toString()+strMin.toString();
			return result;
		}
		
		zf = reflexivity(set,formula);
		fdc = antiSymmetry(set,formula);
		cd = transitivity(set,formula);
		
		if(!zf ||!fdc || !cd) {
			return "偏序关系式的偏序关系不成立！";
		}
		
		String[] pair = StringCutting.cutRelation(formula);

		int lengthF = StringCutting.repetition(pair);
		
		for(i=0;i<lengthX;i++) {
			max = true;
			min = true;
			for(j=0;j<lengthF;j++) {
				String[] strF = StringCutting.betweenToNun(pair[j]);
				if(strF[0].equals(setX[i]) && !strF[0].equals(strF[1])) {
					min = false;
				}
				if(strF[1].equals(setX[i]) && !strF[1].equals(strF[0])) {
					max = false;
				}
			}
			if(min) {
				strMin.append(setX[i]+",");
			}
			if(max) {
				strMax.append(setX[i]+",");
			}	
		}
		
		int index = strMax.length() - 1;
		strMax.deleteCharAt(index);
		strMax.append('\n');
		
		index = strMin.length() - 1;
		strMin.deleteCharAt(index);
		
		result = strMax.toString()+strMin.toString();	
		
		return result;
	}

}
