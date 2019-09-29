package logicalProcessImpl;

import logicalProcess.JudgeNature;
import util.JudgeInput;
import util.StringCutting;

public class JudgeNatureImpl implements JudgeNature{
	 

	public boolean reflexivity(String set,String formula) {
		
		//���ǿռ��Ŀչ�ϵ
		if( formula.equals("{}") && !set.equals("{}")) {
			return false;
		}
		//���ռ��Ŀչ�ϵ
		if(formula.equals("{}") && set.equals("{}")) {
			return true;
		}
		
		if(!JudgeInput.judgeSet(set)) {
			return false;
		}
		if(!JudgeInput.judgeFormula(formula)) {
			return false;
		}
		
		String[] setX = StringCutting.setToNum(set);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int i = 0;
		int j = 0;
		boolean judge = false;
		
//		System.out.println("judge="+judge);
		
		//ѭ��setX�鿴�Ƿ�ÿ��X��pair�϶���x,x
		for(i=0;i<lengthX;i++) {
			judge = false;
			for(j=0;j<lengthF;j++) {
				String[] strF = StringCutting.betweenToNun(pair[j]);
				System.out.println("strF[0]=" + strF[0]);
				System.out.println("strF[1]=" + strF[1]);
				System.out.println("setX=" + setX[i]);
				if(setX[i].equals(strF[0]) && setX[i].equals(strF[1])){
					judge = true;
					System.out.println("judge="+judge);
					break;
				}
			}
			if(!judge) {
				return false;
			}
		}
			
		return true;
	}
	
	public boolean antiReflexivity(String set,String formula) {
		
		if(formula.equals("{}") || set.equals("{}")&&formula.equals("{}")) {
			return true;
		}
		
		if(!JudgeInput.judgeSet(set)) {
			return false;
		}
		if(!JudgeInput.judgeFormula(formula)) {
			return false;
		}
		
		String[] setX = StringCutting.setToNum(set);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int i = 0;
		int j = 0;
		//ѭ��setX�鿴�Ƿ�ÿ��X��pair�϶�û����x,x
		for(i=0;i<lengthX;i++) {
			for(j=0;j<lengthF;j++) {
				String[] strF = StringCutting.betweenToNun(pair[j]);
				if(setX[i].equals(strF[0])&&setX[i].equals(strF[1])){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean symmetry(String set,String formula) {
		
		if(formula.equals("{}") || set.equals("{}")&&formula.equals("{}")) {
			return true;
		}
		
		if(!JudgeInput.judgeSet(set)) {
			return false;
		}
		if(!JudgeInput.judgeFormula(formula)) {
			return false;
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
		//��ù�ϵ��ά��
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
			for(j=0;j<lengthX;j++) {
				if(array[i][j] == 1) {
					if(array[j][i] != 1) {
						return false;
					}
				}
			}
		}
		return true;	
	}
	
	public boolean antiSymmetry(String set,String formula) {
		
		if(formula.equals("{}") || set.equals("{}")&&formula.equals("{}")) {
			return true;
		}   
		
		if(!JudgeInput.judgeSet(set)) {
			return false;
		}
		if(!JudgeInput.judgeFormula(formula)) {
			return false;
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
		
		//��ù�ϵ��ά��
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
			for(j=0;j<lengthX;j++) {
				if(array[i][j] ==1) {
					if(array[j][i] == 1) {
						return false;
					}
				}
			}
		}
		return true;
		
	}
	public boolean transitivity(String set,String formula) {
		
		//����ϵΪ�ջ򼯺�Ϊ���ҹ�ϵΪ��ʱ����
		if(formula.equals("{}") || set.equals("{}")&&formula.equals("{}")) {
			return true;
		}
		
		if(!JudgeInput.judgeSet(set)) {
			return false;
		}
		if(!JudgeInput.judgeFormula(formula)) {
			return false;
		}
		
		String[] setX = StringCutting.setToNum(set);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int[][] array = new int[lengthX][lengthX];
		int[][] array1 = new int[lengthX][lengthX];
		
		int i = 0;
		int j = 0;
		int k = 0;
		int row = 0;
		int list = 0;
		
		//�ѹ�ϵת��������
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
			array1[row][list] =1;
		}
		
		//Warshall�㷨����հ���
		for(j=0;j<lengthX;j++) {
			for(i=0;i<lengthX;i++) {
				if(array[i][j] !=0) {
					for(k=0;k<lengthX;k++) {
						array[i][k] = array[i][k] + array[j][k];
					}
				}
			}
		}
		
		//ѭ���ж�����array1��һ��λ�ã��ڴ��ݱհ����Ƿ��У���û�з���false
		for(i=0;i<lengthX;i++) {
			for(j=0;j<lengthX;j++) {
				if(array1[i][j] != 0) {
					if(array[i][j] == 0) {
						return false;
					}
				}
			}
		}
		return true;			
	}
	
//	public int[][] getBivariateTable(int lengthX,int lengthF,String[] pair,String[] setX) {
//		
//		int i = 0;
//		int j = 0;
//		int row = 0;
//		int list = 0;
//		int[][] array = new int[lengthX][lengthX];
//		for(i=0;i<lengthF;i++) {
//			String[] strF = StringCutting.betweenToNun(pair[i]);
//			for(j=0;j<lengthX;j++) {
//				if(strF[0].equals(setX[j])) {
//					row = j;
//				}
//				if(strF[1].equals(setX[j])) {
//					list = j;
//				}
//			}
//			array[row][list] = 1;
//		}
//		return array;
//		
//	}
}






















