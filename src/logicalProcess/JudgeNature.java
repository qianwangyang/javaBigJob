package logicalProcess;


public interface JudgeNature {
	
	/**
	 * �ж��Է��ԣ��Ƿ���true�����Ƿ���false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean reflexivity(String set,String formula);
	
	/**
	 * �жϷ��Է��ԣ��Ƿ���true�����Ƿ���false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean antiReflexivity(String set,String formula);
	
	/**
	 * �ж϶Գ��ԣ��Ƿ���true�����Ƿ���false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean symmetry(String set,String formula);
	
	/**
	 * �жϷ��Գ��ԣ��Ƿ���true�����Ƿ���false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean antiSymmetry(String set,String formula) ;
	
	/**
	 * �жϴ����ԣ��Ƿ���true�����Ƿ���false
	 * @param set
	 * @param formula
	 * @return
	 */
	public boolean transitivity(String set,String formula);
	
	/**
	 * ��ù�ϵ��ά��
	 * @param lengthX
	 * @param lengthF
	 * @param pair
	 * @param setX
	 * @return
	 */
//	public int[][] getBivariateTable(int lengthX,int lengthF,String[] pair,String[] setX);
}












