package logicalProcess;

public interface Operation {
	/**
	 * ��������
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer intesection (String formula1,String formula2);

	/**
	 * ������
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer opposite (String formula1,String formula2);

	/**
	 * ������
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer unionSet (String formula1,String formula2);
	
	/**
	 * ��������
	 * @param formula1
	 * @param formula2
	 * @return
	 */
	public StringBuffer recombination (String formula1,String formula2);
	
//	/**
//	 * ȥ���������ظ���Ԫ��
//	 * @param formula
//	 * @return
//	 */
//	public int repetition(String[] formula);
}

















