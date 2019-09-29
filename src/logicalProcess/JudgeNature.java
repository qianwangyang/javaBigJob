package logicalProcess;


public interface JudgeNature {
	
	/**
	 * 判断自反性，是返回true，不是返回false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean reflexivity(String set,String formula);
	
	/**
	 * 判断反自反性，是返回true，不是返回false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean antiReflexivity(String set,String formula);
	
	/**
	 * 判断对称性，是返回true，不是返回false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean symmetry(String set,String formula);
	
	/**
	 * 判断返对称性，是返回true，不是返回false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean antiSymmetry(String set,String formula) ;
	
	/**
	 * 判断传递性，是返回true，不是返回false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean transitivity(String set,String formula);
	
	/**
	 * 获得关系二维表；
	 * @param lengthX
	 * @param lengthF
	 * @param pair
	 * @param setX
	 * @return
	 */
//	public int[][] getBivariateTable(int lengthX,int lengthF,String[] pair,String[] setX);
}












