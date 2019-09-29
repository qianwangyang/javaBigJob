package test;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JPanel implements ListSelectionListener{
	
	private JButton button[] = new JButton[2];
	private  JList list;
	private JSplitPane splitPane;
	private JPanel[] panel;
	private JPanel pa = new JPanel();
	private String[] function = {"集合运算","映射判断"}; 
	
	public  GUI() {
		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置列表的选择模式。此方法是在选择模型上直接设置选择模式的覆盖方法。
		list.setSelectedIndex(0);
		//添加监听
		list.addListSelectionListener(this);
		//带滚动条面板
		
		button[0] = new JButton("傻叉");
		button[1] = new JButton("傻X");
		panel = new JPanel[2];
		panel[0] = new JPanel();
		panel[1] = new JPanel();
		 panel[0].add(button[0]);
		 panel[1].add(button[1]);
		
		 JScrollPane listScrollPane = new JScrollPane(list);
		//JScrollPane panelScrollpane1 = new JScrollPane(panel[1]);
		
		//分割
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,panel[0]);
		splitPane.setLeftComponent(list);//设置分割的左边
		splitPane.setDividerLocation(200);
		
		 Dimension minimumSize = new Dimension(100,500);
		 
		
		// buttonScrollPane.set
		 splitPane.setPreferredSize(new Dimension(400, 200));
//		 panel[0].add(button[0]);
//		 panel[1].add(button[1]);
		// panelScrollPane.add(panel[0]);
		 
		
		
		
		
	}
	//监听器
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panel[list.getSelectedIndex()]);//设置右边
		
	}
	public static void main(String[] arr) {
		GUI gui = new GUI();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(gui.splitPane);
		frame.setResizable(false); 
		frame.pack();
		frame.setVisible(true);
		
	}

}
