package logicalProcess;

public interface JudgeRelation {
	
	/**
	 * ���ݹ�ϵ
	 * @param set
	 * @param formula
	 * @return
	 */
	public String compatbility(String set,String formula);
	
	/**
	 * �ȼ۹�ϵ
	 * @param set
	 * @param formula
	 * @return
	 */
	public String equivalence(String set,String formula);
	
	/**
	 * ƫ���ϵ
	 * @param set
	 * @param formula
	 * @return
	 */
	public String partialOrder(String set,String formula);
	

}














