package util;

import java.util.HashSet;
import java.util.Set;

public class StringCutting {
	
	/**
	 * 把集合切成一个个字符串  如：{1,2,3} ->1 2 3 
	 * @param formula
	 * @return
	 */
	public static String[] setToNum(String formula) {	
		String strF = formula.substring(1,formula.length()-1);
		String[] str = strF.split(",");
		return str;
	}
	
	/**
	 * 切割关系对 如：1,2->1 2
	 * @param formula
	 * @return
	 */
	public static String[] betweenToNun(String formula) {
		String[] str = formula.split(",");
		return str;
	}
	
	/**
	 * 把关系式分开  如： {(1,2),(2,4)}->1,2 2,4
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
	 * 去重，输入一个字符数组，改变数组内部元素顺序，把重复的排到后面，返回int为不重复字符的长度
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
