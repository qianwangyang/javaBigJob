package logicalProcess;


public interface Closure {
	
	/**
	 * 获取自反闭包
	 * @param set
	 * @param formula
	 * @return
	 */
	public StringBuilder getReflexive(String set,String formula);
	
	/**
	 * 获取对称闭包
	 * @param set
	 * @param formula
	 * @return
	 */
	public StringBuilder getSymmetry(String set,String formula);
	
	/**
	 * 传递闭包获取
	 * @param set
	 * @param formula
	 * @return
	 */
	public StringBuilder getTransitivity(String set,String formula);

}
