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

	
	private JTextArea operationA,operationB,operationResult;  //关系运算
	private JTextArea mapDomainX,mapDomainY,mapFormula,mapResult;                     //映射判断
	private JTextArea closureSet,closureFormula,closureResult;          //闭包求取
	private JTextArea set,formula,judgeResult;                      //关系与性质判断
	private JTextArea divideSet,divideFormula,divideResult;		//通过等价划分集合
	private JTextArea extSet,extFormula,extResult;
	
	private JButton intersection,union,recombination,opposite;     //关系运算
	private JButton mapJudge;                //映射判断                   
	private JButton  zf,fzf,dc,fdc,cd,xr,dj,px;//关系与性质判断
	private JButton reflexive,symmetry,transitivity;                //闭包
	private JButton divide;											//通过等价划分集合
	private JButton ext;

	private JButton empty;
	
	private String[] function = {"关于系统","关系运算","映射判断","关系与性质判断","闭包求取","等价关系对集合划分","偏序关系中极值计算"};
	
	public GUI() {
		
		operationA = new JTextArea(2,40);//关系运算
		operationB = new JTextArea(2,40);
		operationResult = new JTextArea(3,40);
		
		operationA.setFont(new Font("黑体",Font.PLAIN,20));
		operationB.setFont(new Font("黑体",Font.PLAIN,20));
		operationResult.setFont(new Font("黑体",Font.PLAIN,20));
		
		mapDomainX = new JTextArea(2,40); //映射判断
		mapDomainY = new JTextArea(2,40);
		mapFormula = new JTextArea(2,40);
		mapResult = new JTextArea(3,40);
		
		mapDomainX.setFont(new Font("黑体",Font.PLAIN,20));
		mapDomainY.setFont(new Font("黑体",Font.PLAIN,20));
		mapFormula.setFont(new Font("黑体",Font.PLAIN,20));
		mapResult.setFont(new Font("黑体",Font.PLAIN,20));
		
		closureSet = new JTextArea(2,40);   //闭包求取
		closureFormula = new JTextArea(2,40);
		closureResult = new JTextArea(3,40);

		closureSet.setFont(new Font("黑体",Font.PLAIN,20));
		closureFormula.setFont(new Font("黑体",Font.PLAIN,20));
		closureResult.setFont(new Font("黑体",Font.PLAIN,20));
		
		set = new JTextArea(2,40);  //关系与性质判断
		formula = new JTextArea(2,40);
		judgeResult = new JTextArea(3,40);
		
		set.setFont(new Font("黑体",Font.PLAIN,20));
		formula.setFont(new Font("黑体",Font.PLAIN,20));
		judgeResult.setFont(new Font("黑体",Font.PLAIN,20));
		
		divideSet = new JTextArea(2,40);  //等价划分
		divideFormula = new JTextArea(2,40);
		divideResult = new JTextArea(3,40);
		
		divideSet.setFont(new Font("黑体",Font.PLAIN,20));
		divideFormula.setFont(new Font("黑体",Font.PLAIN,20));
		divideResult.setFont(new Font("黑体",Font.PLAIN,20));
		
		extSet = new JTextArea(2,40);  //极值求取
		extFormula = new JTextArea(2,40);
		extResult = new JTextArea(3,40);
		
		extSet.setFont(new Font("黑体",Font.PLAIN,20));
		extFormula.setFont(new Font("黑体",Font.PLAIN,20));
		extResult.setFont(new Font("黑体",Font.PLAIN,20));
		
		 zf = new JButton("自    反"); //映射判断
		fzf = new JButton("反自反");
		 dc = new JButton("对    称");
		fdc = new JButton("反对称");
		 xr = new JButton("相    容");
		 dj = new JButton("等    价");
		 px = new JButton("偏    序");
		 cd = new JButton("传    递");
		 
		divide = new JButton("等价关系对集合划分");  //等价划分
		
		intersection = new JButton("交集运算");  //关系运算
		union = new JButton("并集运算");
		recombination = new JButton("复合运算");
		opposite = new JButton("逆运算");
		empty = new JButton("清空");
	
		mapJudge = new JButton("判断映射类型");  //映射判断
		
		
		reflexive = new JButton("自反闭包");   //闭包求取
		symmetry = new JButton("对称闭包");
		transitivity = new JButton("传递闭包");
		
		ext = new JButton("偏序关系的极值");  //极值求取
		
		
		panelList = new ArrayList<JPanel>();
		
		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setFont(new Font("粗体",Font.BOLD,15));
		
		
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
	 * 关于系统说明
	 * @return JPanel
	 */
	
	public JPanel getPanelAboutSystem() {
		JPanel mainPanel = new JPanel();
		
		JTextPane explain = new JTextPane();
		JLabel headline = new JLabel("关系相关说明");
		headline.setFont(new Font("粗体",Font.PLAIN,20));//设置字体
		
		explain.setText("1、此系统用于关系和相关计算\r\n" + 
				"2、相关的运算式子要规范输入\r\n" + 
				"3、元素尽量不要使用“，“、”{“，“}”、“（”、”）”等特殊字符\r\n" + 
				"4、符号使用为英文符号，使用中文符号将无法得到正确结果\r\n" + 
				"5、映射判断功能可能存在一下漏洞，一些无法判断的式子，还有待系统升级\r\n" + 
				"6、最后感谢您的使用\r\n" );
		StyledDocument doc = explain.getStyledDocument();//------model---把属性集、文本内容结合起来
		SimpleAttributeSet setSize = new SimpleAttributeSet();//---属性集---把要加的属性先放一起---再加入文本内容
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
	 *获取“关系运算”面板
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
		headline = new JLabel("关系运算");
		label1 = new JLabel("关系式一：");
		label2 = new JLabel("关系式二：");
		label3 = new JLabel("结        果：");
		note = new JLabel("提示：进行交、并集运算输入规范—>{1,2,3}；复合、逆运算输入规范—>{(1,2),(3,4)}");
		note1 = new JLabel("复合运算实现：‘关系式一’R‘关系式二’");
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(operationA);
		scrollB = new JScrollPane(operationB);
		scrollResult = new JScrollPane(operationResult);
		
		headline.setFont(new Font("黑体",Font.PLAIN,20));
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
	 * 获取“映射判断”面板
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
		headLabel = new JLabel("映射判断");
		label1 = new JLabel("定义域：");
		label2 = new JLabel("关系式：");
		label3 = new JLabel("结    果：");
		label4 = new JLabel("值    域：");
		note1 = new JLabel("提示：{1,2,3}");
		note2 = new JLabel("提示：{(1,2),(2,3)}");
		note3 = new JLabel("提示：{1,2,3}");
		
		JScrollPane scrollX,scrollY,scrollB,scrollResult;
		scrollX = new JScrollPane(mapDomainX);
		scrollY = new JScrollPane(mapDomainY);
		scrollB = new JScrollPane(mapFormula);
		scrollResult = new JScrollPane(mapResult);
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
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
	 * 获取“关系与性质判断”面板
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
		headLabel = new JLabel("关系与性质的判断");
		label1 = new JLabel("集    合：");
		label2 = new JLabel("关系式：");
		label3 = new JLabel("结    果：");
		note1 = new JLabel("提示：{1,2,3,4}");
		note2 = new JLabel("提示：{(1,2),(2,3),(3,4)}");
		
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(set);
		scrollB = new JScrollPane(formula);
		scrollResult = new JScrollPane(judgeResult);
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
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
	 * 获得通过等价关系划分集合的面板
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
		headLabel = new JLabel("通过等价关系对集合进行划分");
		label1 = new JLabel("集        合：");
		label2 = new JLabel("等价关系：");
		label3 = new JLabel("结        果：");
		note1 = new JLabel("提示：{1,2,3,4}");
		note2 = new JLabel("提示：{(1,2),(2,3),(3,4)}");
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
		
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
	 * 获取“闭包求取”面板
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
		headLabel = new JLabel("闭包求取");
		label1 = new JLabel("集    合：");
		label2 = new JLabel("关系式：");
		label3 = new JLabel("结    果：");
		note1 = new JLabel("提示：{1,2,3,4}");
		note2 = new JLabel("提示：{(1,2),(2,3),(3,4)}");
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(closureSet);
		scrollB = new JScrollPane(closureFormula);
		scrollResult = new JScrollPane(closureResult);
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
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
	 * 获取求偏序中极值的面板
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
		headLabel = new JLabel("偏序关系中极值的计算");
		label1 = new JLabel("集            合：");
		label2 = new JLabel("偏序关系式：");
		label3 = new JLabel("结            果：");
		note1 = new JLabel("提示：{1,2,3,4}");
		note2 = new JLabel("提示：{(1,2),(2,3),(3,4)}");
		
		JScrollPane scrollA,scrollB,scrollResult;
		scrollA = new JScrollPane(extSet);
		scrollB = new JScrollPane(extFormula);
		scrollResult = new JScrollPane(extResult);
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
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
	 *  动作监听器
	 */
	@Override
	public void actionPerformed(ActionEvent envet) {
		StringBuffer strBuf = new StringBuffer();
		StringBuilder strBui = new StringBuilder();
		String result = new String();
		
		boolean judge = false;
		JButton bt = (JButton) envet.getSource();
		
		//关系运算
		if(bt == intersection) {//交集
			try {
				strBuf = operation.intesection(operationA.getText(), operationB.getText());
				operationResult.setText(strBuf.toString());
			}catch(Exception e) {
				operationResult.setText("输入存在空值！");
			}

		}
		
		else if(bt == recombination) {//复合
			try {
				strBuf = operation.recombination(operationA.getText(), operationB.getText());
				operationResult.setText(strBuf.toString());
			}catch(Exception exception) {
				operationResult.setText("输入存在空值！");
			}
		}
		
		else if(bt == union) {//并集
			try {
				strBuf = operation.unionSet(operationA.getText(), operationB.getText());
				operationResult.setText(strBuf.toString());
			}catch(Exception e) {
				operationResult.setText("输入存在空值！");
			}
		}
		else if(bt == opposite) {//逆运算
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
					operationResult.setText("输入存在空值！");
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
		
		//映射判断
		else if(bt == mapJudge ) {
			try {
				result = judgeMap.judge(mapDomainX.getText(), mapDomainY.getText(), mapFormula.getText()); 
				mapResult.setText(result);
			}catch(Exception e){
				mapResult.setText("输入存在空值！");
			}
			
		}
		//关系与性质判断
		else if(bt == zf) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				
				if(!JudgeInput.judgeSet(setText)) {
					judgeResult.setText("非法输入！");
				}else {
					judge = judgeNature.reflexivity(setText, formulaText);
					if(judge) {
						judgeResult.setText("自反性成立！");
					}
					else {
						judgeResult.setText("自反性不成立！");
					}
				}
			}catch(Exception e) {
				judgeResult.setText("输入存在空值！");
			}
		}
		else if(bt == fzf) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				
				if(!JudgeInput.judgeSet(setText))
				{
					judgeResult.setText("非法输入！");
				}
				
				else if(formulaText.equals("{}") || setText.equals("{}")&&formulaText.equals("{}")) 
				{
					judgeResult.setText("反自反性成立！");
				}
				
				else if(!JudgeInput.judgeFormula(formulaText)) 
				{
					judgeResult.setText("非法输入!");
				}else 
				{
					judge = judgeNature.antiReflexivity(setText,formulaText);
					if(judge)
					{
						judgeResult.setText("反自反性成立！");
					}
					else {
						judgeResult.setText("反自反性不成立！");
					}
				}
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
			
		}
		else if(bt == dc) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				judge = judgeNature.symmetry(setText,formulaText);
				if(judge) {
					judgeResult.setText("对称性成立");
				}
				else {
					judgeResult.setText("对称性不成立！");
				}
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
		}
		else if(bt == fdc) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				judge = judgeNature.antiSymmetry(setText,formulaText);
				if(judge) {
					judgeResult.setText("反对称性成立");
				}
				else {
					judgeResult.setText("反对称性不成立！");
				}
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
					
		}
		else if(bt == cd) {
			try {
				String setText = set.getText();
				String formulaText = formula.getText();
				judge = judgeNature.transitivity(setText,formulaText);
				if(judge) {
					judgeResult.setText("传递性成立！");
				}
				else {
					judgeResult.setText("传递性不成立！");
				}
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
		}
		else if(bt == xr) {
			try {
				result = judgeRelation.compatbility(set.getText(), formula.getText());
				judgeResult.setText(result);
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
		}
		else if(bt == dj) {
			try {
				result = judgeRelation.equivalence(set.getText(), formula.getText());
				judgeResult.setText(result);
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
			
		}
		else if(bt == px) {
			try {
				result = judgeRelation.partialOrder(set.getText(), formula.getText());
				judgeResult.setText(result);
			}catch(Exception e) {
				judgeResult.setText("输入项存在空值！");
			}
		}
		//闭包求取
		else if(bt == reflexive ) {//自反闭包
			try {
				strBui = closure.getReflexive(closureSet.getText(), closureFormula.getText());
				closureResult.setText(strBui.toString());
			}catch(Exception e) {
				closureResult.setText("输入项存在空值！");
			}
			
		}
		else if(bt == symmetry) {
			try {
				strBui = closure.getSymmetry(closureSet.getText(), closureFormula.getText());
				closureResult.setText(strBui.toString());
			}catch(Exception e) {
				closureResult.setText("输入项存在空值！");
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
				divideResult.setText("输入项存在空值！");
			}
		}
		
		else if(bt == ext) {
			try {
				result = extremum.getExtremum(extSet.getText(), extFormula.getText());
				extResult.setText(result);
			}catch(Exception e) {
				extResult.setText("输入项存在空值！");
			}
			
		}
		
		
	}
	
	/**
	 * 分割版监听器
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panelList.get(list.getSelectedIndex()));
		
	}
	
	public static void main(String[] arr) {
		
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainJFrame.setTitle("关系相关运算");
		mainJFrame.getContentPane().add(mainJFrame.splitPane);
		
		mainJFrame.opposite.addActionListener(mainJFrame); //关系运算添加监听器
		mainJFrame.intersection.addActionListener(mainJFrame);
		mainJFrame.union.addActionListener(mainJFrame);
		mainJFrame.recombination.addActionListener(mainJFrame);
		mainJFrame.empty.addActionListener(mainJFrame);
		
		mainJFrame.mapJudge.addActionListener(mainJFrame);//映射判断
		
		mainJFrame.zf.addActionListener(mainJFrame);//关系性质判断
		mainJFrame.fzf.addActionListener(mainJFrame);
		mainJFrame.dc.addActionListener(mainJFrame);
		mainJFrame.fdc.addActionListener(mainJFrame);
		mainJFrame.xr.addActionListener(mainJFrame);
		mainJFrame.px.addActionListener(mainJFrame);
		mainJFrame.cd.addActionListener(mainJFrame);
		mainJFrame.dj.addActionListener(mainJFrame);
		
		mainJFrame.reflexive.addActionListener(mainJFrame);//闭包求取
		mainJFrame.symmetry.addActionListener(mainJFrame);
		mainJFrame.transitivity.addActionListener(mainJFrame);
		
		mainJFrame.divide.addActionListener(mainJFrame);    //通过等价划分
		
		mainJFrame.ext.addActionListener(mainJFrame); 		//极值求取
		
		mainJFrame.setResizable(false); 
		mainJFrame.pack();
		mainJFrame.setLocationRelativeTo(null);
		mainJFrame.setVisible(true);
	}

}
