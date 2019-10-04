package logicalProcessImpl;

import java.util.HashSet;
import java.util.Set;

import logicalProcess.Operation;
import util.JudgeInput;
import util.StringCutting;

public class OperationImpl implements Operation{
	
	
	@Override
	public StringBuffer intesection (String formula1,String formula2) {
		
		StringBuffer result = new StringBuffer();
		
		if(!JudgeInput.judgeSet(formula1)) {
			result.append("非法输入！");
			return result;
		}
		if(!JudgeInput.judgeSet(formula2)) {
			result.append("非法输入！");
			return result;
		}
		//当集合都为空时，返回{}
		if(formula1.equals("{}")&&formula2.equals("{}")) {
			result.append("{}");
			return result;
		}
		String[] str1 = StringCutting.setToNum(formula1);
		String[] str2 = StringCutting.setToNum(formula2);
		
		int length1 = StringCutting.repetition(str1);
		int length2 = StringCutting.repetition(str2);
		
		Set<String> setR = new HashSet<String>();
		int i = 0;
		
		result.append("{");
		
		for(i=0;i<length1;i++) {
			setR.add(str1[i]);
		}
		for(i=0;i<length2;i++) {
			if(!setR.add(str2[i])) {
				result.append(str2[i]+",");
			}
		}
		i = result.length() - 1;
		if(i>1) {
			result.deleteCharAt(i);
		}
		result.append("}");
		return result;
	}
	
	public StringBuffer unionSet (String formula1,String formula2) {
		
		StringBuffer result = new StringBuffer();
		
		if(!JudgeInput.judgeSet(formula1)) {
			result.append("非法输入！");
			return result;
		}
		if(!JudgeInput.judgeSet(formula2)) {
			result.append("非法输入！");
			return result;
		}
		
		//把两个集合合并，去重
		result.append("{");
		String[] str1 = StringCutting.setToNum(formula1);
		String[] str2 = StringCutting.setToNum(formula2);
		
		int i = 0;
		Set<String> setR = new HashSet<String>();
		
		for(i=0;i<str1.length;i++) {
			if(setR.add(str1[i])) {
				result.append(str1[i]+",");
			}
		}
		for(i=0;i<str2.length;i++) {
			if(setR.add(str2[i])) {
				result.append(str2[i]+",");
			}
		}
		
		i = result.length() - 1;
		if(i>1){
			result.deleteCharAt(i);
		}
		result.append("}");
		return  result;
	}
	
	@Override
	public StringBuffer opposite (String formula1,String formula2) {
		
		StringBuffer result = new StringBuffer();
		
		if(formula1 != null && !formula1.equals("")) {
			
			if(!JudgeInput.judgeFormula(formula1)) {
				result.append("非法输入！");
				return result;
			}
			
			result.append("{");
			String[] str1 = StringCutting.cutRelation(formula1);
			String[] strNum = new String[2];
			for(int i = 0;i<str1.length;i++) {
				strNum = StringCutting.betweenToNun(str1[i]);
				result.append("("+strNum[1]+","+strNum[0]+"),");	
			}
			result = result.deleteCharAt(result.length()-1);
			result.append("}");
			result.append('\n');
		}
		
		if(formula2 != null && !formula2.equals("")) {
			
			if(!JudgeInput.judgeFormula(formula2)) {
				result.append("非法输入！");
				return result;
			}
			
			result.append("{");
			String[] str2 = StringCutting.cutRelation(formula2);
			String[] strNum = new String[2];
			for(int i = 0;i<str2.length;i++) {
				strNum = StringCutting.betweenToNun(str2[i]); //1,2分成1 2；
				result.append("("+strNum[1]+","+strNum[0]+"),");	
			}
			result = result.deleteCharAt(result.length()-1);
			result.append("}");
		}
		return result;
		
	}
	
	@Override
	public StringBuffer recombination (String formula1,String formula2) {
		
		StringBuffer result = new StringBuffer();
		
		if(!JudgeInput.judgeFormula(formula1) && !JudgeInput.judgeFormula(formula2)) {
			result.append("非法输入！");
			return result;
		}
		
		String[] str1 = StringCutting.cutRelation(formula1);
		String[] str2 = StringCutting.cutRelation(formula2);
		
		Set<String> setResult = new HashSet<String>();
		result.append("{");
		for(int i=0;i<str1.length;i++) {
			String[] strNumA = StringCutting.betweenToNun(str1[i]);
			for(int j=0;j<str2.length;j++) {
				String[] strNumB = StringCutting.betweenToNun(str2[j]);
				if(strNumA[1].equals(strNumB[0])) {
					
					if(setResult.add("("+ strNumA[0] + "," + strNumB[1] + "),")) {
						result.append( "("+ strNumA[0] + "," + strNumB[1] + "),");
					}
				}
			}
		}
		result = result.deleteCharAt(result.length()-1);
		result.append("}");
		
		return result;
	}
	

}
