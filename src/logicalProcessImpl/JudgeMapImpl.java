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
			return "�Ƿ�����";
		}
		
		String[] domainX = StringCutting.setToNum(mapDomainX);
		String[] domainY = StringCutting.setToNum(mapDomainY);
		String[] formula = StringCutting.cutRelation(mapFormula);
		
		int i;
		
		int lengthX = StringCutting.repetition(domainX);
		int lengthY = StringCutting.repetition(domainY);
		int lengthF = StringCutting.repetition(formula);
		
		if(lengthX!=lengthF) {
			return "ӳ���ϵ�����������ڶ������޶�Ӧֵ";
		}
		
		Set<String> setX = new HashSet<String>();
		for(i=0;i<lengthF;i++) {
			
			String[] strX = StringCutting.betweenToNun(formula[i]);
			
			if(!setX.add(strX[0])) {
				return "ӳ���ϵ������������X�ж��Y";//X�����ʹ�ã�ӳ���ϵ����
			}
		}
		
		//��֤X�Ƿ��ڶ�����
		for(i=0;i<lengthX;i++) {
			if(setX.add(domainX[i])) {
				return "��ϵʽ�д���X���ڶ�������";
			}
		}
		
		Set<String> setY1 = new HashSet<String>();
		for(i=0;i<lengthY;i++) {
			//System.out.println("strY["+i+"]="+domainY[i]);
			setY1.add(domainY[i]);
		}
		
		//����Y�Ƿ�ȫ����Y����
		Set<String> setY = new HashSet<String>();	
		for(i=0;i<lengthF;i++) {
			String[] strY = StringCutting.betweenToNun(formula[i]);
			//System.out.println("strY[1]="+strY[1]);
			if(!setY1.contains(strY[1])) {
				return "��ϵʽ�д���Yֵ����ֵ����";
			}
			setY.add(strY[1]);
		}
		
		if(setY.size() < lengthY ) {
			return "����";
		}
		else if(setY.size() == lengthY && lengthY == lengthX) {
			return "˫��";
		}
		else if(setY.size() == lengthY && lengthY < lengthX) {
			return "����";
		}
		else {
			return "�������ޣ����޷��жϴ�ʽ��";
		}
	}
		
}





//Set<String> setX = new HashSet<String>();
//for(int i = 0;i<lengthX;i++) {
//	for(int j = 0;j<lengthF;j++) {
//		String[] strF = StringCutting.cutRelation(formula[j]);
//		if(domainX[i].equals(strF[0])) {
//			if(!setX.add(domainX[i])) {
//				return "ӳ���ϵ������������Y�ж��Y";//X�����ʹ�ã�ӳ���ϵ������
//			}
//		}
//	}
//}



//for(int i=0;i<lengthY;i++) {
//	Set<String> set = new HashSet<String>();
//	for(int j=0;j<lengthF;j++) {
//		String[] strF = StringCutting.cutRelation(formula[j]);
//		if(domainY[i].equals(strF[1])) {
//			if(!set.add(domainY[i])) {
//				judgeY = false;//Y�����ʹ��
//			}
//		}
//	}
//}