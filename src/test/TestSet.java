package test;

import java.util.HashSet;
import java.util.Set;

import util.StringCutting;

public class TestSet {
	public static void main(String[] arr) {
	}
	public static boolean XIncludeSet(String[] set,String[] formula) {
		Set<String> setX = new HashSet<String>();
		for(int i=0;i<set.length;i++) {
			setX.add(set[i]);
		}
		for(int i=0;i<formula.length;i++) {
			String[] strY = StringCutting.betweenToNun(formula[i]);
			if(setX.add(strY[1])) {
				setX = null;
				return false;
			}
		}
		return true;
	}
	

}
