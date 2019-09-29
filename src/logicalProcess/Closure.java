package logicalProcess;


public interface Closure {
	
	/**
	 * ��ȡ�Է��հ�
	 * @param set
	 * @param formula
	 * @return
	 */
	public StringBuilder getReflexive(String set,String formula);
	
	/**
	 * ��ȡ�ԳƱհ�
	 * @param set
	 * @param formula
	 * @return
	 */
	public StringBuilder getSymmetry(String set,String formula);
	
	/**
	 * ���ݱհ���ȡ
	 * @param set
	 * @param formula
	 * @return
	 */
	public StringBuilder getTransitivity(String set,String formula);

}
