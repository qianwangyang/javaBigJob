package gui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GetPanel {
	
	private JPanel mainPanel,headPanel,setPanel,relationPanel,buttonPanel,resultPanel,rangePanel;
	private JLabel headLine,setLabel,relationLabel,resultLabel,rangeLabel;
	private JLabel rangeNote,setNote,relationNote;
	JScrollPane setScrol,relationScrol,resultScrol,rangescrol;
	
	/**
	 * label:1、headLine,2、setLabel,3、relationLabel,3、resultLabel
	 * text:1、setText,2、relationText,3、resultText
	 * note:1、setNote,2、resultionNote
	 * @param button
	 * @param label
	 * @param text
	 * @param note
	 */
	GetPanel(ArrayList<JButton> button,ArrayList<String> label,ArrayList<JTextArea> text,ArrayList<String> note){	
		
		mainPanel = new JPanel();
		headPanel = new JPanel();
		setPanel = new JPanel();
		relationPanel = new JPanel();
		resultPanel = new JPanel();
		buttonPanel = new JPanel();
		
		headLine = new JLabel(label.get(0));
		setLabel = new JLabel(label.get(1));
		relationLabel = new JLabel(label.get(2));
		resultLabel = new JLabel(label.get(3));
		
		headLine.setFont(new Font("黑体",Font.PLAIN,20));
		
		setNote = new JLabel(note.get(0));
		relationNote = new JLabel(note.get(1));
		
		setScrol = new JScrollPane(text.get(0));
		relationScrol = new JScrollPane(text.get(1));
		resultScrol = new JScrollPane(text.get(2));
		
		headPanel.add(headLine);
		
		setPanel.add(setLabel);
		setPanel.add(setScrol);
		setPanel.add(setNote);
		
		relationPanel.add(relationLabel);
		relationPanel.add(relationScrol);
		relationPanel.add(relationNote);
		
		for(int i=0;i<button.size();i++) {
			buttonPanel.add(button.get(i));
		}
		
		resultPanel.add(resultLabel);
		resultPanel.add(resultScrol);
		
		mainPanel.add(headPanel);
		mainPanel.add(resultPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(resultPanel);
	}
	
	/**
	 * 获取通用面板
	 * @return
	 */
	public JPanel getJPanel() {
		
		mainPanel.setLayout(null);
		headPanel.setBounds(250, 20, 100, 25);
		setPanel.setBounds(10,200,550,120);
		relationPanel.setBounds(10,310,550,120);
		buttonPanel.setBounds(110,420,400,80);
		resultPanel.setBounds(10, 500, 550, 100);
		
		return mainPanel;
	}
	
	/**
	 * 获取映射面板
	 * @param jLabel
	 * @param note
	 * @param rangeText
	 * @return
	 */
	public JPanel getMapPanel(String jLabel,String note,JTextArea rangeText) {
		
		rangePanel = new JPanel();
		
		rangeLabel = new JLabel(jLabel);
		rangeNote = new JLabel(note);
		rangescrol = new JScrollPane(rangeText);
		
		rangePanel.add(rangeLabel);
		rangePanel.add(rangescrol);
		rangePanel.add(rangeNote);
		
		mainPanel.add(rangePanel);
		
		mainPanel.setLayout(null);
		headPanel.setBounds(250, 20, 100, 25);
		setPanel.setBounds(10,140,500,100);
		rangePanel.setBounds(10,250,500,100);
		relationPanel.setBounds(10,370,500,100);
		buttonPanel.setBounds(10,480,600,40);
		resultPanel.setBounds(10,540,500,100);
		
		return mainPanel;
	}
}













