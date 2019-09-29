package logicalProcess;

public interface Operation {
	/**
	 * 交集运算
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer intesection (String formula1,String formula2);

	/**
	 * 逆运算
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer opposite (String formula1,String formula2);

	/**
	 * 并运算
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer unionSet (String formula1,String formula2);
	
	/**
	 * 复合运算
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer recombination (String formula1,String formula2);
	
//	/**
//	 * 去除集合中重复的元素
//	 * @param formula
//	 * @return
//	 */
//	public int repetition(String[] formula);
}

















