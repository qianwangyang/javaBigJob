package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Panel1 extends JPanel{
	
	public Panel1() {
		
	}
	
	public JPanel getPanelAboutSystem() {
		JPanel panel = new JPanel();
		
		JLabel headline = new JLabel("关系相关运算");
		//设置字体
		headline.setFont(new Font("粗体",Font.PLAIN,20));
		
		panel.add(headline);
		return panel;		
	}
	
	public JPanel getOperationPanel() {
		JPanel mainPanel,headPanel,panel1,panel2,panel3,panel4;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();

		JLabel headline,label1,label2,label3;
		headline = new JLabel("关系运算");
		label1 = new JLabel("关系式一：");
		label2 = new JLabel("关系式二：");
		label3 = new JLabel("结        果：");
		
		JScrollPane formula1ScrollPane,formula2ScrollPane,resultScrollPane;
		formula1ScrollPane = new JScrollPane(new JTextArea(3,40));
		formula2ScrollPane = new JScrollPane(new JTextArea(3,40));
		resultScrollPane = new JScrollPane(new JTextArea(3,40));
		
		JButton intersection,union,recombination,opposite;
		intersection = new JButton("交集运算");
		union = new JButton("并集运算");
		recombination = new JButton("复合运算");
		opposite = new JButton("逆运算");
		
		headline.setFont(new Font("黑体",Font.PLAIN,20));
		headPanel.add(headline);
		
		panel1.add(label1);
		panel1.add(formula1ScrollPane);
		
		panel2.add(label2);
		panel2.add(formula2ScrollPane);
		
		panel3.add(intersection);
		panel3.add(union);
		panel3.add(recombination);
		panel3.add(opposite);
		
		panel4.add(label3);
		panel4.add(resultScrollPane);
		
		mainPanel.add(headPanel);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);		
		
		mainPanel.setLayout(null);
		headPanel.setBounds(300, 20, 100, 25);
		panel1.setBounds(10,200,600,70);
		panel2.setBounds(10,300,600,70);
		panel3.setBounds(10,400,600,40);
		panel4.setBounds(10,500,600,70);
				
		return mainPanel;
	}
	
	public JPanel getMapPanel() {
		
		JPanel mainPanel,headPanel,panel1,panel2,panel3,panel4;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("映射判断");
		label1 = new JLabel("定义域：");
		label2 = new JLabel("关系式：");
		label3 = new JLabel("结    果：");
		note1 = new JLabel("提示：{1,2,3}");
		note2 = new JLabel("提示：{(1,2),(2,3)}");
		
		JScrollPane formula1ScrollPane,formula2ScrollPane,resultScrollPane;
		formula1ScrollPane = new JScrollPane(new JTextArea(3,40));
		formula2ScrollPane = new JScrollPane(new JTextArea(3,40));
		resultScrollPane = new JScrollPane(new JTextArea(3,40));
		
		JButton doubleShot,singleShot,fullShot;
		doubleShot = new JButton("双射");
		singleShot = new JButton("单射");
		fullShot = new JButton("满射");
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		panel1.add(label1);
		panel1.add(formula1ScrollPane);
		panel1.add(note1);
		
		panel2.add(label2);
		panel2.add(formula2ScrollPane);
		panel2.add(note2);
		
		panel3.add(singleShot);
		panel3.add(doubleShot);
		panel3.add(fullShot);
		
		panel4.add(label3);
		panel4.add(resultScrollPane);
		
		mainPanel.add(headPanel);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(300, 20, 100, 25);
		panel1.setBounds(10,200,550,110);
		panel2.setBounds(10,310,550,110);
		panel3.setBounds(10,420,600,40);
		panel4.setBounds(10, 500, 550, 70);
	
		return mainPanel;
	}
	
	public JPanel getNaturePanel() {
		JPanel mainPanel,headPanel,panel1,panel2,panel3,panel4;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("性质的判断");
		label1 = new JLabel("集    合：");
		label2 = new JLabel("关系式：");
		label3 = new JLabel("结    果：");
		note1 = new JLabel("提示：{1,2,3,4}");
		note2 = new JLabel("提示：{(1,2),(2,3),(3,4)}");
		
		JScrollPane setScrollPane,formulaScrollPane,resultScrollPane;
		setScrollPane = new JScrollPane(new JTextArea(3,40));
		formulaScrollPane = new JScrollPane(new JTextArea(3,40));
		resultScrollPane = new JScrollPane(new JTextArea(3,40));
		
		JButton judgeRelation,judgeNature;
		judgeRelation = new JButton("关系判断");
		judgeNature = new JButton("性质判断");
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		panel1.add(label1);
		panel1.add(setScrollPane);
		panel1.add(note1);
		
		panel2.add(label2);
		panel2.add(formulaScrollPane);
		panel2.add(note2);
		
		panel3.add(judgeRelation);
		panel3.add(judgeNature);
		
		panel4.add(label3);
		panel4.add(resultScrollPane);
		
		mainPanel.add(headPanel);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(300, 20, 100, 25);
		panel1.setBounds(10,200,550,110);
		panel2.setBounds(10,310,550,110);
		panel3.setBounds(10,420,600,40);
		panel4.setBounds(10, 500, 550, 70);
		
		return mainPanel;
	}
	
	public JPanel getClosure() {
		JPanel mainPanel,headPanel,panel1,panel2,panel3,panel4;
		mainPanel = new JPanel();
		headPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		JLabel headLabel,label1,label2,label3,note1,note2;
		headLabel = new JLabel("性质的判断");
		label1 = new JLabel("集    合：");
		label2 = new JLabel("关系式：");
		label3 = new JLabel("结    果：");
		note1 = new JLabel("提示：{1,2,3,4}");
		note2 = new JLabel("提示：{(1,2),(2,3),(3,4)}");
		
		JScrollPane setScrollPane,formulaScrollPane,resultScrollPane;
		setScrollPane = new JScrollPane(new JTextArea(3,40));
		formulaScrollPane = new JScrollPane(new JTextArea(3,40));
		resultScrollPane = new JScrollPane(new JTextArea(3,40));
		
		JButton reflexive,symmetry,transitivity;
		reflexive = new JButton("自反闭包");
		symmetry = new JButton("对称闭包");
		transitivity = new JButton("传递闭包");
		
		headLabel.setFont(new Font("黑体",Font.PLAIN,20));
		headPanel.add(headLabel);
		
		panel1.add(label1);
		panel1.add(setScrollPane);
		panel1.add(note1);
		
		panel2.add(label2);
		panel2.add(formulaScrollPane);
		panel2.add(note2);
		
		panel3.add(reflexive);
		panel3.add(symmetry);
		panel3.add(transitivity);
		
		panel4.add(label3);
		panel4.add(resultScrollPane);
		
		mainPanel.add(headPanel);
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(300, 20, 100, 25);
		panel1.setBounds(10,200,550,110);
		panel2.setBounds(10,310,550,110);
		panel3.setBounds(10,420,600,40);
		panel4.setBounds(10, 500, 550, 70);
		
		return mainPanel;
	}
	
	
	
	
	
	
	
}























