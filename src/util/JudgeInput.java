package util;

public class JudgeInput {
	
//	public static boolean judgeFormula(String set,String formula) {
//		
//		if(set.charAt(0) != '{' || formula.charAt(0) != '{' 
//				   || set.charAt(set.length()-1) != '}' || formula.charAt(formula.length()-1) != '}' ) {
//					return false;
//				}
//		return false;
//	}
	/**
	 * 判断关系形式是否正确
	 * @param formula
	 * @return
	 */
	public static boolean judgeFormula(String formula) {
		int i = 0;
		int j = 0;
		boolean judge = true;
		int index = 3;
		if(!formula.regionMatches(0,"{(", 0, 2) || !formula.regionMatches(formula.length()-2,")}",0,2)) {
			return false;
		}
		for(i=2;i<formula.length()-1;i++) {
			if(formula.charAt(i)=='(') {
				if(formula.charAt(i-1) != ',' || formula.charAt(i-2) != ')') {
					return false;
				}
				judge = true;
				for(j=index;j<i-2;j++) {
					if(formula.charAt(j) == ',' && judge == false) {
						judge = true;
						break;
					}
					if(formula.charAt(j) == ',' && judge == true) {
						judge = false;
					}
				}
				if(judge) {
					return false;
				}
				index = i+2;
				continue;
			}
			else if(i == formula.length()-2) {//{(1,2),(2,3),(3,4),(45)}
				judge = true;
				for(j=index;j<=i;j++) {
					if(formula.charAt(j) == ',' && judge == false) {
						judge = true;
						break;
					}
					if(formula.charAt(j) == ',' && judge == true) {
						judge = false;
					}
				}
				if(judge) {
					return false;
				}
			}
			else if(formula.charAt(i) == ')' && formula.charAt(i-1) == ')') {// {(1,2),(2,3),(3,4))}
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断集合形式是非正确
	 * @param set
	 * @return
	 */
	public static boolean judgeSet(String set) {
		int i = 0;
		if(set.charAt(0) != '{' || set.charAt(set.length()-1) != '}' 
				||set.charAt(1) == ',' || set.charAt(set.length()-2) == ',' ) {
					return false;
				}
		for(i=2;i<set.length()-2;i++) {
			if(set.charAt(i) == ',' && set.charAt(i-1)==',') {
				return false;
			}
		}
		return true;
		
	}
}
