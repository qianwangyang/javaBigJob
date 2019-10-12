package logicalProcessImpl;

import java.util.HashSet;
import java.util.Set;

import logicalProcess.JudgeMap;
import util.JudgeInput;
import util.StringCutting;

public class JudgeMapImpl implements JudgeMap{
	
	@Override
	public String judge(String mapDomainX,String mapDomainY,String mapFormula) {
		
		if(!JudgeInput.judgeSet(mapDomainX) || !JudgeInput.judgeSet(mapDomainY) || !JudgeInput.judgeFormula(mapFormula)) {
			return "非法输入";
		}
		
		String[] domainX = StringCutting.setToNum(mapDomainX);
		String[] domainY = StringCutting.setToNum(mapDomainY);
		String[] formula = StringCutting.cutRelation(mapFormula);
		
		int i;
		
		int lengthX = StringCutting.repetition(domainX);
		int lengthY = StringCutting.repetition(domainY);
		int lengthF = StringCutting.repetition(formula);
		
		if(lengthX > lengthF) {
			return "映射关系不成立，存在X无对应值";
		}
		
		Set<String> setX = new HashSet<String>();
		for(i=0;i<lengthF;i++) {
			String[] strX = StringCutting.betweenToNun(formula[i]);
			if(!setX.add(strX[0])) {
				return "映射关系不成立，存在X有多个Y";//X被多次使用，映射关系成立
			}
		}
		
		if(lengthX <lengthF) {
		return "映射关系不成立，存在X值不在定义域";
	}
		
		//验证X是否在定义域；
		for(i=0;i<lengthX;i++) {
			if(setX.add(domainX[i])) {
				return "映射不成立，存在X值没有Y值";
			}
		}
		Set<String> setY1 = new HashSet<String>();
		for(i=0;i<lengthY;i++) {
			setY1.add(domainY[i]);
		}
		
		//检验Y是否全都在Y域中
		Set<String> setY = new HashSet<String>();	
		for(i=0;i<lengthF;i++) {
			String[] strY = StringCutting.betweenToNun(formula[i]);
			//System.out.println("strY[1]="+strY[1]);
			if(!setY1.contains(strY[1])) {
				return "关系式中存在Y值不在值域中";
			}
			setY.add(strY[1]);
		}
		
		if(setY.size() < lengthY ) {
			return "单射";
		}
		else if(setY.size() == lengthY && lengthY == lengthX) {
			return "双射";
		}
		else if(setY.size() == lengthY && lengthY < lengthX) {
			return "满射";
		}
		else {
			return "因技术有限，暂无法判断此式！";
		}
	}
		
}
