package logicalProcessImpl;

import java.util.ArrayList;

import util.JudgeInput;
import util.StringCutting;

public class DivideImpl extends JudgeNatureImpl {
	
	public StringBuilder divide(String set,String formula) {
		
		StringBuilder result = new StringBuilder();
	
		if(!JudgeInput.judgeSet(set)) {
			result.append("�Ƿ����룡");
			return result;
		}
		//����ϵΪ��ʱ������Ϊ���ϱ���
		if(formula.equals("{}")) {
			result.append(set);
			return result;
		}
		if(!JudgeInput.judgeFormula(formula)) {
			result.append("�Ƿ����룡");
			return result;
		}
		
		boolean zf = false, dc = false, cd = false;
		zf = reflexivity(set,formula);
		dc = symmetry(set,formula);
		cd = transitivity(set,formula);
		if(!zf || !dc || !cd) {
			result.append("�ȼ۹�ϵ��������");
			return result;
		}
		
		String[] setX = StringCutting.setToNum(set);
		String[] pair = StringCutting.cutRelation(formula);
		
		int lengthX = StringCutting.repetition(setX);
		int lengthF = StringCutting.repetition(pair);
		
		int i = 0;
		int j = 0;
		int index = 0;
		
		ArrayList<String> listX = new ArrayList<String>();
		ArrayList<StringBuilder> listR = new ArrayList<StringBuilder>();
		
		for(i=0;i<lengthX;i++) {
			listX.add(setX[i]);
		}
//		����
//		{1,2,3,4}->{1,2,3}��{4} ->{1,2,3}X{1,2,3}U{4}X{4}
//		{(1,1),(1,2),(1,3)(1,4),(2,1),(2,2),(2,3),(2,4),(4,1)~~~}	
//		���ѿ����ˣ�ÿ���Ӽ���Ԫ�ض���ͬһ�Ӽ���Ԫ���й�ϵ���Ե�һ��Ԫ����ΪXΪ������ϵʽ����Ϊ��X��Y����YԪ��Ϊͬһ�Ӽ���
//		һ�����ּ��ϵ���һ��Ԫ�ؾ���ͬ�����ּ����ܵ�Ԫ���й�ϵ����listRΪ�ο�ѭ������X��serF�г��֣���Y��¼����������listR��ɾ��Y��
		for(i=0;i<listX.size();i++) {
			StringBuilder strBui = new StringBuilder(listX.get(i)+",");
			for(j=0;j<lengthF;j++) {
				String[] strF = StringCutting.betweenToNun(pair[j]);
				if(listX.get(i).equals(strF[0]) && !listX.get(i).equals(strF[1])) {
					strBui.append(strF[1]+",");
					listX.remove(strF[1]); 
				}
			}
			listR.add(strBui);
		}
		
		for(i=0;i<listR.size();i++) {
			result.append("{");
			result.append(listR.get(i));
			index = result.length() - 1;
			result.deleteCharAt(index);
			result.append("}");
			result.append('\n');
		}
		return result;
	}

}
