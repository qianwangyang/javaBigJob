package util;

import java.util.HashSet;
import java.util.Set;

public class StringCutting {
	
	/**
	 * �Ѽ����г�һ�����ַ���  �磺{1,2,3} ->1 2 3 
	 * @param formula
	 * @return
	 */
	public static String[] setToNum(String formula) {	
		String strF = formula.substring(1,formula.length()-1);
		String[] str = strF.split(",");
		return str;
	}
	
	/**
	 * �и��ϵ�� �磺1,2->1 2
	 * @param formula
	 * @return
	 */
	public static String[] betweenToNun(String formula) {
		String[] str = formula.split(",");
		return str;
	}
	
	/**
	 * �ѹ�ϵʽ�ֿ�  �磺 {(1,2),(2,4)}->1,2 2,4
	 * @param formula
	 * @return
	 */
	public static String[] cutRelation(String formula) {
//		System.out.println("1111");
		String strF = formula.substring(2,formula.length()-2);
//		System.out.println("2222");
		String[] str = strF.split("\\),\\(");
//		System.out.println("3333");
		return str;	
	}
	
	/**
	 * ȥ�أ�����һ���ַ����飬�ı������ڲ�Ԫ��˳�򣬰��ظ����ŵ����棬����intΪ���ظ��ַ��ĳ���
	 * @param formula
	 * @return
	 */
	
	public static int repetition(String[] formula) {
		
		int length = formula.length;
		
		Set<String> set = new HashSet<String>();
		int index = 0;
		for(int i = 0;i<length;i++) {
			if(set.add(formula[i])) {
				formula[index] = formula[i];
				index++;
			}
		}
		
//		for(int i = 0;i<length;i++) {
//		for(int j = i+1;j<length;j++) {
//			if(formula[i].equals(formula[j])) {
//				for(int k = j;k<length-1;k++) {
//					formula[k] = formula[k+1];
//				}
//				length--;
//			}
//		}
//	}
//	String[] str = new String[length];
//	for(int i = 0;i<length;i++) {
//		str[i] = formula[i];
//	}
		
		return index;
	}

}
