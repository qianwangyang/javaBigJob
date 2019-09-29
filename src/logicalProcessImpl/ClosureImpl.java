package logicalProcessImpl;

import logicalProcess.Closure;
import util.JudgeInput;
import util.StringCutting;

public class ClosureImpl implements Closure {
	
	public StringBuilder getReflexive(String set,String formula) {
		
		StringBuilder result = new StringBuilder();
		
		if(!JudgeInput.judgeSet(set)) {
			result.append("非法输入");
			return result;
		}
		
		//当空集空关系返回空集
		if(set.equals("{}") && formula.equals("{}")) {
			result.append("{}");
			return result;
		}
		
		//当非空集的空关系
		if(!set.equals("{}") && formula.equals("{}")) {
			String[] setX = StringCutting.setToNum(set);
			int lengthX = StringCutting.repetition(setX);
			result.append("{");
			for(int i=0;i<lengthX;i++) {
				result.append("("+setX[i]+","+setX[i]+"),");
			}
			int index = result.length() - 1;
			result.deleteCharAt(index);
			result.append("}");
			return result;
		}
		
		if(!JudgeInput.judgeFormula(formula)) {
			result.append("非法输入");
			return result;
		}
		
		String[] setX = StringCutting.setToNum(set);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int[][] array = new int[lengthX][lengthX];
		
		int i = 0;
		int j = 0;
		int row = 0;
		int list = 0;
		result.append("{");
		
		//把关系转化成数组
		for(i=0;i<lengthF;i++) {
			String[] strF = StringCutting.betweenToNun(pair[i]);
			for(j=0;j<lengthX;j++) {
				if(strF[0].equals(setX[j])) {
					row = j;
				}
				if(strF[1].equals(setX[j])) {
					list = j;
				}
			}
			array[row][list] = 1;
		}
		
		//把对角线元素全设为一
		for(i=0;i<lengthX;i++) {
			array[i][i] = 1;
		}
		
		for(i=0;i<lengthX;i++) {
			for(j=0;j<lengthX;j++) {
				if(array[i][j] == 1) {
					result.append("("+setX[i]+","+setX[j]+"),");
				}
			}
		}
		int index = result.length() - 1;
		result.deleteCharAt(index);
		result.append("}");
		return result;
	}
	
	public StringBuilder getSymmetry(String set,String formula) {
		
		StringBuilder result = new StringBuilder();
		
		if(!JudgeInput.judgeSet(set)) {
			result.append("非法输入！");
			return result;
		}
		
		//当空关系返回空集
		if(formula.equals("{}")) {
			result.append("{}");
			return result;
		}
		
		if(!JudgeInput.judgeFormula(formula)) {
			result.append("非法输入！");
			return result;
		}
		
		String[] setX = StringCutting.setToNum(set);
		//System.out.println("formula="+formula);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int[][] array = new int[lengthX][lengthX];
		
		int i = 0;
		int j = 0;
		int row = 0;
		int list = 0;
		result.append("{");
		
		//把关系转化成数组
		for(i=0;i<lengthF;i++) {
			String[] strF = StringCutting.betweenToNun(pair[i]);
			for(j=0;j<lengthX;j++) {
				if(strF[0].equals(setX[j])) {
					row = j;
				}
				if(strF[1].equals(setX[j])) {
					list = j;
				}
			}
			array[row][list] = 1;
		}
		
		for(i=0;i<lengthX;i++) {
			for(j=0;j<i;j++) {
				if(array[i][j] ==1) {
					array[j][i] = 1;
				}
			}
		}
		
		for(i=0;i<lengthX;i++) {
			for(j=0;j<lengthX;j++) {
				if(array[i][j] == 1) {
					result.append("("+setX[i]+","+setX[j]+"),");
				}
			}
		}
		int index = result.length() - 1;
		result.deleteCharAt(index);
		 result.append("}");
		 return result;	
	}
	public StringBuilder getTransitivity(String set,String formula) {
		
		StringBuilder result = new StringBuilder();
		
		if(!JudgeInput.judgeSet(set)) {
			result.append("非法输入！");
			return result;
		}
		
		//当空关系返回空集
		if(formula.equals("{}")) {
			result.append("{}");
			return result;
		}
		
		if(!JudgeInput.judgeFormula(formula)) {
			result.append("非法输入！");
			return result;
		}
		
		String[] setX = StringCutting.setToNum(set);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int[][] array = new int[lengthX][lengthX];
		
		int i = 0;
		int j = 0;
		int k = 0;
		int row = 0;
		int list = 0;
		result.append("{");
		
		//把关系转化成数组
		for(i=0;i<lengthF;i++) {
			String[] strF = StringCutting.betweenToNun(pair[i]);
			for(j=0;j<lengthX;j++) {
				if(strF[0].equals(setX[j])) {
					row = j;
				}
				if(strF[1].equals(setX[j])) {
					list = j;
				}
			}
			array[row][list] = 1;
		}
		
		for(j=0;j<lengthX;j++) {
			for(i=0;i<lengthX;i++) {
				if(array[i][j] !=0 ) {
					for(k=0;k<lengthX;k++) {
						array[i][k] = array[i][k] +array[j][k];
					}
				}
			}
		}
		
		for(i=0;i<lengthX;i++) {
			for(j=0;j<lengthX;j++) {
				if(array[i][j] != 0) {
					result.append("("+setX[i]+","+setX[j]+"),");
				}
			}
		}
		int index = result.length() - 1;
		result.deleteCharAt(index);
		 result.append("}");
		 return result;	
		
	}

}
