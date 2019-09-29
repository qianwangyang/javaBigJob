package logicalProcess;

public interface JudgeRelation {
	
	/**
	 * 相容关系
	 * @param set
	 * @param formula
	 * @return
	 */
	public String compatbility(String set,String formula);
	
	/**
	 * 等价关系
	 * @param set
	 * @param formula
	 * @return
	 */
	public String equivalence(String set,String formula);
	
	/**
	 * 偏序关系
	 * @param set
	 * @param formula
	 * @return
	 */
	public String partialOrder(String set,String formula);
	

}














