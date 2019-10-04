package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import logicalProcessImpl.ClosureImpl;
import logicalProcessImpl.DivideImpl;
import logicalProcessImpl.ExtremumImpl;
import logicalProcessImpl.JudgeMapImpl;
import logicalProcessImpl.JudgeNatureImpl;
import logicalProcessImpl.JudgeRelationImpl;
import logicalProcessImpl.OperationImpl;
import util.JudgeInput;


public class GUI extends JFrame implements ListSelectionListener,ActionListener {
	
	private OperationImpl operation = new OperationImpl();
	private JudgeMapImpl judgeMap = new JudgeMapImpl();
	private JudgeNatureImpl judgeNature = new JudgeNatureImpl();
	private JudgeRelationImpl judgeRelation = new JudgeRelationImpl();
	private ClosureImpl closure = new ClosureImpl();
	private DivideImpl divideImpl = new DivideImpl();
	private ExtremumImpl extremum = new ExtremumImpl();
	
	private static GUI mainJFrame = new GUI();
	private JList list;
	private JSplitPane splitPane;
	private ArrayList<JPanel> panelList;

	
	private JTextArea operationA,operationB,operationResult;  //��ϵ����
	private JTextArea mapDomainX,mapDomainY,mapFormula,mapResult;                     //ӳ���ж�
	private JTextArea closureSet,closureFormula,closureResult;          //�հ���ȡ
	private JTextArea set,formula,judgeResult;                      //��ϵ�������ж�
	private JTextArea divideSet,divideFormula,divideResult;		//ͨ���ȼۻ��ּ���
	private JTextArea extSet,extFormula,extResult;
	
	private JButton intersection,union,recombination,opposite;     //��ϵ����
	private JButton mapJudge;                //ӳ���ж�                   
	private JButton  zf,fzf,dc,fdc,cd,xr,dj,px;//��ϵ�������ж�
	private JButton reflexive,symmetry,transitivity;                //�հ�
	private JButton divide;											//ͨ���ȼۻ��ּ���
	private JButton ext;

	private JButton empty;
	
	private String[] function = {"����ϵͳ","��ϵ����","ӳ���ж�","��ϵ�������ж�","�հ���ȡ","�ȼ۹�ϵ�Լ��ϻ���","ƫ���ϵ�м�ֵ����"};
	
	public GUI() {
		
		operationA = new JTextArea(2,40);//��ϵ����
		operationB = new JTextArea(2,40);
		operationResult = new JTextArea(3,40);
		
		operationA.setFont(new Font("����",Font.PLAIN,20));
		operationB.setFont(new Font("����",Font.PLAIN,20));
		operationResult.setFont(new Font("����",Font.PLAIN,20));
		
		mapDomainX = new JTextArea(2,40); //ӳ���ж�
		mapDomainY = new JTextArea(2,40);
		mapFormula = new JTextArea(2,40);
		mapResult = new JTextArea(3,40);
		
		mapDomainX.setFont(new Font("����",Font.PLAIN,20));
		mapDomainY.setFont(new Font("����",Font.PLAIN,20));
		mapFormula.setFont(new Font("����",Font.PLAIN,20));
		mapResult.setFont(new Font("����",Font.PLAIN,20));
		
		closureSet = new JTextArea(2,40);   //�հ���ȡ
		closureFormula = new JTextArea(2,40);
		closureResult = new JTextArea(3,40);

		closureSet.setFont(new Font("����",Font.PLAIN,20));
		closureFormula.setFont(new Font("����",Font.PLAIN,20));
		closureResult.setFont(new Font("����",Font.PLAIN,20));
		
		set = new JTextArea(2,40);  //��ϵ�������ж�
		formula = new JTextArea(2,40);
		judgeResult = new JTextArea(3,40);
		
		set.setFont(new Font("����",Font.PLAIN,20));
		formula.setFont(new Font("����",Font.PLAIN,20));
		judgeResult.setFont(new Font("����",Font.PLAIN,20));
		
		divideSet = new JTextArea(2,40);  //�ȼۻ���
		divideFormula = new JTextArea(2,40);
		divideResult = new JTextArea(3,40);
		
		divideSet.setFont(new Font("����",Font.PLAIN,20));
		divideFormula.setFont(new Font("����",Font.PLAIN,20));
		divideResult.setFont(new Font("����",Font.PLAIN,20));
		
		extSet = new JTextArea(2,40);  //��ֵ��ȡ
		extFormula = new JTextArea(2,40);
		extResult = new JTextArea(3,40);
		
		extSet.setFont(new Font("����",Font.PLAIN,20));
		extFormula.setFont(new Font("����",Font.PLAIN,20));
		extResult.setFont(new Font("����",Font.PLAIN,20));
		
		 zf = new JButton("��    ��"); //ӳ���ж�
		fzf = new JButton("���Է�");
		 dc = new JButton("��    ��");
		fdc = new JButton("���Գ�");
		 xr = new JButton("��    ��");
		 dj = new JButton("��    ��");
		 px = new JButton("ƫ    ��");
		 cd = new JButton("��    ��");
		 
		divide = new JButton("�ȼ۹�ϵ�Լ��ϻ���");  //�ȼۻ���
		
		intersection = new JButton("��������");  //��ϵ����
		union = new JButton("��������");
		recombination = new JButton("��������");
		opposite = new JButton("������");
		empty = new JButton("���");
	
		mapJudge = new JButton("�ж�ӳ������");  //ӳ���ж�
		
		
		reflexive = new JButton("�Է��հ�");   //�հ���ȡ
		symmetry = new JButton("�ԳƱհ�");
		transitivity = new JButton("���ݱհ�");
		
		ext = new JButton("ƫ���ϵ�ļ�ֵ");  //��ֵ��ȡ
		
		
		panelList = new ArrayList<JPanel>();
		
		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setFont(new Font("����",Font.BOLD,15));
		
		
		panelList.add(getPanelAboutSystem());
		panelList.add(getOperationPanel());
		panelList.add(getMapPanel());
		panelList.add(getNatureAndRelationPanel());	
		panelList.add(getClosure());
		panelList.add(getDividePanel());
		panelList.add(getExtPanel());
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,list,panelList.get(0));
		splitPane.setLeftComponent(list);	
		splitPane.setPreferredSize(new Dimension(800,700));
			
	}
	/**
	 * ����ϵͳ˵��
	 * @return JPanel
	 */
	
	public JPanel getPanelAboutSystem() {
		JPanel mainPanel = new JPanel();
		
		JTextPane explain = new JTextPane();
		JLabel headline = new JLabel("��ϵ���˵��");
		headline.setFont(new Font("����",Font.PLAIN,20));//��������
		
		explain.setText("1����ϵͳ���ڹ�ϵ����ؼ���\r\n" + 
				"2����ص�����ʽ��Ҫ�淶����\r\n" + 
				"3��Ԫ�ؾ�����Ҫʹ�á���������{������}�������������������������ַ�\r\n" + 
				"4������ʹ��ΪӢ�ķ��ţ�ʹ�����ķ��Ž��޷��õ���ȷ���\r\n" + 
				"5��ӳ���жϹ��ܿ��ܴ���һ��©����һЩ�޷��жϵ�ʽ�ӣ����д�ϵͳ����\r\n" + 
				"6������л����ʹ��\r\n" );
		StyledDocument doc = explain.getStyledDocument();//------model---�����Լ����ı����ݽ������
		SimpleAttributeSet setSize = new SimpleAttributeSet();//---���Լ�---��Ҫ�ӵ������ȷ�һ��---�ټ����ı�����
		StyleConstants.setFontSize(setSize,15);
		doc.setCharacterAttributes(0,144,setSize,true);
		explain.setBackground(null);
		explain.setEditable(false);
		
		
		mainPanel.add(headline);
		mainPanel.add(explain);
		mainPanel.setLayout(null);
		headline.setBounds(250,20,200,20);
		explain.setBounds(70, 50, 600, 500);
		return mainPanel;		
	}
	
	/**
	 *��ȡ����ϵ���㡱���
	 * @return JPanel
	 */
	
	public JPanel getOperationPanel() {
		
		JPanel mainPanel,headPanel,setPanel,relationPanel,buttonPanel,resultPanel;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		setPanel = new JPanel();
		relationPanel = new JPanel();
		buttonPanel = new JPanel();
		resultPanel = new JPanel();

		JLabel headline,label1,label2,label3,note,note1;
		headline = new JLabel("��ϵ����");
		label1 = new JLabel("��ϵʽһ��");
		label2 = new JLabel("��ϵʽ����");
		label3 = new JLabel("��        ����");
		note = new JLabel("��ʾ�����н���������������淶��>{1,2,3}�����ϡ�����������淶��>{(1,2),(3,4)}");
		note1 = new JLabel("��������ʵ�֣�����ϵʽһ��R����ϵʽ����");
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(operationA);
		scrollB = new JScrollPane(operationB);
		scrollResult = new JScrollPane(operationResult);
		
		headline.setFont(new Font("����",Font.PLAIN,20));
		headPanel.add(headline);
		
		setPanel.add(label1);
		setPanel.add(scrollA);
		
		relationPanel.add(label2);
		relationPanel.add(scrollB);
		relationPanel.add(note);
		relationPanel.add(note1);
		
		buttonPanel.add(intersection);
		buttonPanel.add(union);
		buttonPanel.add(recombination);
		buttonPanel.add(opposite);
		buttonPanel.add(empty);
		
		
		resultPanel.add(label3);
		resultPanel.add(scrollResult);
		
		mainPanel.add(headPanel);
		mainPanel.add(setPanel);
		mainPanel.add(relationPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(resultPanel);		
		
		mainPanel.setLayout(null);
		headPanel.setBounds(250, 20, 100, 25);
		setPanel.setBounds(10,160,600,100);
		relationPanel.setBounds(10,290,600,100);
		buttonPanel.setBounds(10,430,600,40);
		resultPanel.setBounds(10,500,600,100);
				
		return mainPanel;
	}
	
	/**
	 * ��ȡ��ӳ���жϡ����
	 * @return JPanel
	 */
	public JPanel getMapPanel() {
		
		JPanel mainPanel,headPanel,setXPanel,resultPanel,buttonPanel,panel4,setYPanel;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		setXPanel = new JPanel();
		setYPanel = new JPanel();
		resultPanel = new JPanel();
		buttonPanel = new JPanel();
		panel4 = new JPanel();
		
		JLabel headLabel,label1,label2,label3,label4,note1,note2,note3;
		headLabel = new JLabel("ӳ���ж�");
		label1 = new JLabel("������");
		label2 = new JLabel("��ϵʽ��");
		label3 = new JLabel("��    ����");
		label4 = new JLabel("ֵ    ��");
		note1 = new JLabel("��ʾ��{1,2,3}");
		note2 = new JLabel("��ʾ��{(1,2),(2,3)}");
		note3 = new JLabel("��ʾ��{1,2,3}");
		
		JScrollPane scrollX,scrollY,scrollB,scrollResult;
		scrollX = new JScrollPane(mapDomainX);
		scrollY = new JScrollPane(mapDomainY);
		scrollB = new JScrollPane(mapFormula);
		scrollResult = new JScrollPane(mapResult);
		
		headLabel.setFont(new Font("����",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		setXPanel.add(label1);
		setXPanel.add(scrollX);
		setXPanel.add(note1);
		
		setYPanel.add(label4);
		setYPanel.add(scrollY);
		setYPanel.add(note3);
		
		resultPanel.add(label2);
		resultPanel.add(scrollB);
		resultPanel.add(note2);
		
		buttonPanel.add(mapJudge);
		
		panel4.add(label3);
		panel4.add(scrollResult);
		
		mainPanel.add(headPanel);
		mainPanel.add(setXPanel);
		mainPanel.add(setYPanel);
		mainPanel.add(resultPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(panel4);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(250, 20, 100, 25);
		setXPanel.setBounds(10,140,500,100);
		setYPanel.setBounds(10,250,500,100);
		resultPanel.setBounds(10,370,500,100);
		buttonPanel.setBounds(10,480,600,40);
		panel4.setBounds(10,540,500,100);
	
		return mainPanel;
	}
	/**
	 * ��ȡ����ϵ�������жϡ����
	 * @return JPanel
	 */
	
	public JPanel getNatureAndRelationPanel() {
		JPanel mainPanel,headPanel,panel1,panel2,panel3,panel4;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("��ϵ�����ʵ��ж�");
		label1 = new JLabel("��    �ϣ�");
		label2 = new JLabel("��ϵʽ��");
		label3 = new JLabel("��    ����");
		note1 = new JLabel("��ʾ��{1,2,3,4}");
		note2 = new JLabel("��ʾ��{(1,2),(2,3),(3,4)}");
		
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(set);
		scrollB = new JScrollPane(formula);
		scrollResult = new JScrollPane(judgeResult);
		
		headLabel.setFont(new Font("����",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		panel1.add(label1);
		panel1.add(scrollA);
		panel1.add(note1);
		
		panel2.add(label2);
		panel2.add(scrollB);
		panel2.add(note2);
		
		panel3.add(zf);
		panel3.add(fzf);
		panel3.add(dc);
		panel3.add(fdc);
		panel3.add(cd);
		panel3.add(xr);
		panel3.add(dj);
		panel3.add(px);
		
		panel4.add(label3);
		panel4.add(scrollResult);
		
		mainPanel.add(headPanel);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(10, 20, 550, 25);
		panel1.setBounds(10,200,550,110);
		panel2.setBounds(10,310,550,110);
		panel3.setBounds(110,420,400,80);
		panel4.setBounds(10, 500, 550, 100);
		
		return mainPanel;
	}
	/**
	 * ���ͨ���ȼ۹�ϵ���ּ��ϵ����
	 * @return JPanel
	 */
	
	public JPanel getDividePanel() {
		JPanel mainPanel,panel1,panel2,panel3,panel4;
		mainPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("ͨ���ȼ۹�ϵ�Լ��Ͻ��л���");
		label1 = new JLabel("��        �ϣ�");
		label2 = new JLabel("�ȼ۹�ϵ��");
		label3 = new JLabel("��        ����");
		note1 = new JLabel("��ʾ��{1,2,3,4}");
		note2 = new JLabel("��ʾ��{(1,2),(2,3),(3,4)}");
		
		headLabel.setFont(new Font("����",Font.PLAIN,20));
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(divideSet);
		scrollB = new JScrollPane(divideFormula);
		scrollResult = new JScrollPane(divideResult);
		
		panel1.add(label1);
		panel1.add(scrollA);
		panel1.add(note1);
		
		panel2.add(label2);
		panel2.add(scrollB);
		panel2.add(note2);
		
		panel3.add(divide);
		
		panel4.add(label3);
		panel4.add(scrollResult);
		
		mainPanel.add(headLabel);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		mainPanel.setLayout(null);
		headLabel.setBounds(200, 20, 300, 25);
		panel1.setBounds(10,200,550,110);
		panel2.setBounds(10,310,550,110);
		panel3.setBounds(110,420,400,80);
		panel4.setBounds(10, 500, 550, 100);
		return mainPanel;
		
		
	}
	
	/**
	 * ��ȡ���հ���ȡ�����
	 * @return JPanel
	 */
	public JPanel getClosure() {
		JPanel mainPanel,headPanel,setPanel,relationPanel,buttonPanel,resultPanel;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		setPanel = new JPanel();
		relationPanel = new JPanel();
		buttonPanel = new JPanel();
		resultPanel = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("�հ���ȡ");
		label1 = new JLabel("��    �ϣ�");
		label2 = new JLabel("��ϵʽ��");
		label3 = new JLabel("��    ����");
		note1 = new JLabel("��ʾ��{1,2,3,4}");
		note2 = new JLabel("��ʾ��{(1,2),(2,3),(3,4)}");
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(closureSet);
		scrollB = new JScrollPane(closureFormula);
		scrollResult = new JScrollPane(closureResult);
		
		headLabel.setFont(new Font("����",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		setPanel.add(label1);
		setPanel.add(scrollA);
		setPanel.add(note1);
		
		relationPanel.add(label2);
		relationPanel.add(scrollB);
		relationPanel.add(note2);
		
		buttonPanel.add(reflexive);
		buttonPanel.add(symmetry);
		buttonPanel.add(transitivity);
		
		resultPanel.add(label3);
		resultPanel.add(scrollResult);
		
		mainPanel.add(headPanel);
		mainPanel.add(setPanel);
		mainPanel.add(relationPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(resultPanel);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(250, 20, 100, 25);
		setPanel.setBounds(10,200,550,100);
		relationPanel.setBounds(10,310,550,100);
		buttonPanel.setBounds(10,420,600,40);
		resultPanel.setBounds(10, 500, 550, 100);
		
		return mainPanel;
	}
	
	/**
	 * ��ȡ��ƫ���м�ֵ�����
	 * @return
	 */
	
	public JPanel getExtPanel() {
		
		JPanel mainPanel,headPanel,setPanel,relationPanel,buttonPanel,resultPanel;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		setPanel = new JPanel();
		relationPanel = new JPanel();
		buttonPanel = new JPanel();
		resultPanel = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("ƫ���ϵ�м�ֵ�ļ���");
		label1 = new JLabel("��            �ϣ�");
		label2 = new JLabel("ƫ���ϵʽ��");
		label3 = new JLabel("��            ����");
		note1 = new JLabel("��ʾ��{1,2,3,4}");
		note2 = new JLabel("��ʾ��{(1,2),(2,3),(3,4)}");
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(extSet);
		scrollB = new JScrollPane(extFormula);
		scrollResult = new JScrollPane(extResult);
		
		headLabel.setFont(new Font("����",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		setPanel.add(label1);
		setPanel.add(scrollA);
		setPanel.add(note1);
		
		relationPanel.add(label2);
		relationPanel.add(scrollB);
		relationPanel.add(note2);
		
		buttonPanel.add(ext);
		
		resultPanel.add(label3);
		resultPanel.add(scrollResult);
		
		mainPanel.add(headLabel);
		mainPanel.add(setPanel);
		mainPanel.add(relationPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(resultPanel);
		
		mainPanel.setLayout(null);
		headLabel.setBounds(200, 20, 300, 25);
		setPanel.setBounds(10,200,550,110);
		relationPanel.setBounds(10,310,550,110);
		buttonPanel.setBounds(110,420,400,80);
		resultPanel.setBounds(10, 500, 550, 100);
		
		return mainPanel;
		
	}
	
	//public JPanel getClosure() 
	
	/**
	 *  ����������
	 */
	@Override
	public void actionPerformed(ActionEvent envet) {
		StringBuffer strBuf = new StringBuffer();
		StringBuilder strBui = new StringBuilder();
		String result = new String();
		
		boolean judge = false;
		JButton bt = (JButton) envet.getSource();
		
		//��ϵ����
		if(bt == intersection) {//����
			try {
				strBuf = operation.intesection(operationA.getText(), operationB.getText());
				operationResult.setText(strBuf.toString());
			}catch(Exception e) {
				operationResult.setText("������ڿ�ֵ��");
			}

		}
		
		else if(bt == recombination) {//����
			try {
				strBuf = operation.recombination(operationA.getText(), operationB.getText());
				operationResult.setText(strBuf.toString());
			}catch(Exception exception) {
				operationResult.setText("������ڿ�ֵ��");
			}
		}
		
		else if(bt == union) {//����
			try {
				strBuf = operation.unionSet(operationA.getText(), operationB.getText());
				operationResult.setText(strBuf.toString());
			}catch(Exception e) {
				operationResult.setText("������ڿ�ֵ��");
			}
		}
		else if(bt == opposite) {//������
			String formualA = new String("");
			String formualB = new String("");
			try {
				formualA=operationA.getText();
			}catch(Exception e) {}
			try {
				formualB=operationB.getText();
			}catch(Exception e) {}
			finally {
				if(formualA.equals("") && formualB.equals("")) {
					operationResult.setText("������ڿ�ֵ��");
				}
				else {
					strBuf = operation.opposite(formualA, formualB);
					operationResult.setText(strBuf.toString());
				}
			}
		}
		
		else if(bt == empty) {
			
			operationA.setText(null);
			operationB.setText(null);
			operationResult.setText(null);
			
		}
		
		//ӳ���ж�
		else if(bt == mapJudge ) {
			try {
				result = judgeMap.judge(mapDomainX.getText(), mapDomainY.getText(), mapFormula.getText()); 
				mapResult.setText(result);
			}catch(Exception e){
				mapResult.setText("������ڿ�ֵ��");
			}
			
		}
		//��ϵ�������ж�
		else if(bt == zf) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				
				if(!JudgeInput.judgeSet(setText)) {
					judgeResult.setText("�Ƿ����룡");
				}else {
					judge = judgeNature.reflexivity(setText, formulaText);
					if(judge) {
						judgeResult.setText("�Է��Գ�����");
					}
					else {
						judgeResult.setText("�Է��Բ�������");
					}
				}
			}catch(Exception e) {
				judgeResult.setText("������ڿ�ֵ��");
			}
		}
		else if(bt == fzf) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				
				if(!JudgeInput.judgeSet(setText))
				{
					judgeResult.setText("�Ƿ����룡");
				}
				
				else if(formulaText.equals("{}") || setText.equals("{}")&&formulaText.equals("{}")) 
				{
					judgeResult.setText("���Է��Գ�����");
				}
				
				else if(!JudgeInput.judgeFormula(formulaText)) 
				{
					judgeResult.setText("�Ƿ�����!");
				}else 
				{
					judge = judgeNature.antiReflexivity(setText,formulaText);
					if(judge)
					{
						judgeResult.setText("���Է��Գ�����");
					}
					else {
						judgeResult.setText("���Է��Բ�������");
					}
				}
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
			
		}
		else if(bt == dc) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				judge = judgeNature.symmetry(setText,formulaText);
				if(judge) {
					judgeResult.setText("�Գ��Գ���");
				}
				else {
					judgeResult.setText("�Գ��Բ�������");
				}
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
		}
		else if(bt == fdc) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				judge = judgeNature.antiSymmetry(setText,formulaText);
				if(judge) {
					judgeResult.setText("���Գ��Գ���");
				}
				else {
					judgeResult.setText("���Գ��Բ�������");
				}
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
					
		}
		else if(bt == cd) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				judge = judgeNature.transitivity(setText,formulaText);
				if(judge) {
					judgeResult.setText("�����Գ�����");
				}
				else {
					judgeResult.setText("�����Բ�������");
				}
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
		}
		else if(bt == xr) {
			try {
				result = judgeRelation.compatbility(set.getText(), formula.getText());
				judgeResult.setText(result);
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
		}
		else if(bt == dj) {
			try {
				result = judgeRelation.equivalence(set.getText(), formula.getText());
				judgeResult.setText(result);
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
			
		}
		else if(bt == px) {
			try {
				result = judgeRelation.partialOrder(set.getText(), formula.getText());
				judgeResult.setText(result);
			}catch(Exception e) {
				judgeResult.setText("��������ڿ�ֵ��");
			}
		}
		//�հ���ȡ
		else if(bt == reflexive ) {//�Է��հ�
			try {
				strBui = closure.getReflexive(closureSet.getText(), closureFormula.getText());
				closureResult.setText(strBui.toString());
			}catch(Exception e) {
				closureResult.setText("��������ڿ�ֵ��");
			}
			
		}
		else if(bt == symmetry) {
			try {
				strBui = closure.getSymmetry(closureSet.getText(), closureFormula.getText());
				closureResult.setText(strBui.toString());
			}catch(Exception e) {
				closureResult.setText("��������ڿ�ֵ��");
			}
		}
		else if(bt == transitivity) {
			strBui = closure.getTransitivity(closureSet.getText(), closureFormula.getText());
			closureResult.setText(strBui.toString());
		}
		else if(bt == divide) {
			try {
				strBui = divideImpl.divide(divideSet.getText(), divideFormula.getText());
				divideResult.setText(strBui.toString());
			}catch(Exception e) {
				divideResult.setText("��������ڿ�ֵ��");
			}
		}
		
		else if(bt == ext) {
			try {
				result = extremum.getExtremum(extSet.getText(), extFormula.getText());
				extResult.setText(result);
			}catch(Exception e) {
				extResult.setText("��������ڿ�ֵ��");
			}
			
		}
		
		
	}
	
	/**
	 * �ָ�������
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panelList.get(list.getSelectedIndex()));
		
	}
	
	public static void main(String[] arr) {
		
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainJFrame.setTitle("��ϵ�������");
		mainJFrame.getContentPane().add(mainJFrame.splitPane);
		
		mainJFrame.opposite.addActionListener(mainJFrame); //��ϵ������Ӽ�����
		mainJFrame.intersection.addActionListener(mainJFrame);
		mainJFrame.union.addActionListener(mainJFrame);
		mainJFrame.recombination.addActionListener(mainJFrame);
		mainJFrame.empty.addActionListener(mainJFrame);
		
		mainJFrame.mapJudge.addActionListener(mainJFrame);//ӳ���ж�
		
		mainJFrame.zf.addActionListener(mainJFrame);//��ϵ�����ж�
		mainJFrame.fzf.addActionListener(mainJFrame);
		mainJFrame.dc.addActionListener(mainJFrame);
		mainJFrame.fdc.addActionListener(mainJFrame);
		mainJFrame.xr.addActionListener(mainJFrame);
		mainJFrame.px.addActionListener(mainJFrame);
		mainJFrame.cd.addActionListener(mainJFrame);
		mainJFrame.dj.addActionListener(mainJFrame);
		
		mainJFrame.reflexive.addActionListener(mainJFrame);//�հ���ȡ
		mainJFrame.symmetry.addActionListener(mainJFrame);
		mainJFrame.transitivity.addActionListener(mainJFrame);
		
		mainJFrame.divide.addActionListener(mainJFrame);    //ͨ���ȼۻ���
		
		mainJFrame.ext.addActionListener(mainJFrame); 		//��ֵ��ȡ
		
		mainJFrame.setResizable(false); 
		mainJFrame.pack();
		mainJFrame.setLocationRelativeTo(null);
		mainJFrame.setVisible(true);
	}

}
