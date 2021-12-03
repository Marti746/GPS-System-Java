/**
 * GUI display for the GPS functions
 * @author David Martin
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Point;
//import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class Display extends JFrame implements ActionListener {
	final int WIDTH = 600;
	final int HEIGHT = 550;
	int counter = 0;
	private JLabel fromPoint, toPoint;
	private JButton buttonFT, buttonLD, buttonSC, buttonFR;
	private JComboBox addressFrom, addressTo;
	//JTextArea finalRoute = new JTextArea(20, 50);
	Graph g = new Graph("MapInformation.txt");
	Image imgMap = java.awt.Toolkit.getDefaultToolkit().getImage("FinalProjectGraph_Basic_400x400.png");
	
	ArrayList<Point> pntD = new ArrayList<Point>();

	public Display() {
		createComponents();
		setSize(WIDTH, HEIGHT);
	}

	private void createComponents() {
		// Add a Button
		buttonFT = new JButton("Fastest Time");
		buttonLD = new JButton("Lowest Distance");
		buttonSC = new JButton("Scenic Route");
		buttonFR = new JButton("Fewest Roads");
		// Add an actionListener
		buttonFT.addActionListener(this);
		buttonLD.addActionListener(this);
		buttonSC.addActionListener(this);
		buttonFR.addActionListener(this);
		// Add a JLabel
		fromPoint = new JLabel("Start Location:    ");
		toPoint = new JLabel("Final Destination:");
		//finalRoute.setEditable(false);

		// Creates DropDown menu of the addresses
		addressFrom = new JComboBox<String>(g.getAddress());
		addressFrom.addActionListener(this);
		//JComboBox<String> addressTo = new JComboBox(g.getAddress());
		addressTo = new JComboBox<String>(g.getAddress());
		addressTo.addActionListener(this);

		// Creates a Panel to add the button and label 
		JPanel panelContacts = new JPanel(new GridLayout(2,2));
		panelContacts.setBorder(new TitledBorder("Enter A Starting Loaction and an Ending Location"));
		// adds the Name label and JComboBox
		panelContacts.add(fromPoint);
		panelContacts.add(addressFrom);
		// adds the Address label and JComboBox
		panelContacts.add(toPoint);
		panelContacts.add(addressTo);

		// Creates panel for the buttons using a flow layout
		JPanel panelButton = new JPanel(new FlowLayout());
		panelButton.setBorder(new TitledBorder("Which Type of Route"));
		// adds the buttons to the panel
		panelButton.add(buttonFT);
		panelButton.add(buttonLD);
		panelButton.add(buttonSC);
		panelButton.add(buttonFR);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Final Calculated Route"));
		//panel.add(ImgMap);
		

		// Add panel to the frame
		this.add(panelContacts, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}

	/**
	 * Main method that creates the Address Book Object
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new Display();
		frame.setTitle("GPS System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String value= addressFrom.getSelectedItem().toString();
		if(e.getActionCommand().equals("Fastest Time")) {
			Graph.useDistCost = false;
			//Dijkstra.shortestPath(g, g.getVertex(addressFrom.getSelectedItem().toString()), g.getVertex(addressTo.getSelectedItem().toString()));
			//finalRoute.setText(+"");
			Dijkstra.shortestPath(g, addressFrom.getSelectedItem().toString(), addressTo.getSelectedItem().toString());
		}
		else if(e.getActionCommand().equals("Scenic Route")) {
			Graph.useDistCost = false;
			Graph.longestDist = true;
			Dijkstra.shortestPath(g, addressFrom.getSelectedItem().toString(), addressTo.getSelectedItem().toString());
		}
		else if(e.getActionCommand().equals("Fewest Routes")) {
			//Dijkstra.shortestPath(g, g.getVertex(addressFrom.getSelectedItem().toString()), g.getVertex(addressTo.getSelectedItem().toString()));
		}
		else {
			Dijkstra.shortestPath(g, addressFrom.getSelectedItem().toString(), addressTo.getSelectedItem().toString());
		}
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		// Green line
//		Graphics2D g3 = (Graphics2D)g;
//		g3.setStroke(linePath);
//
//		g3.setColor(Color.GREEN);
//		g3.drawImage(imgMap, 0, 300);
//		if(pntD.size() > 0) g3.fillOval(pntD.get(0).x + 2, pntD.get(0).y + 2, 10, 10);
//		for(int i = 1; i <pntD.size(); i++) {
//			g3.drawLine(pntD.get(i - 1).x + 2, pntD.get(i - 1).y + 2, pntD.get(i).x + 2, pntD.get(i).y + 2);
//			g3.fillOval(pntD.get(i).x + 2, pntD.get(i).y + 2, 10, 10);
//		}
//
//
//
//		Graphics2D g2 = (Graphics2D)g;
//		g2.setStroke(linePath);
//
//		g2.setColor(Color.RED);
//		//	        g2.drawImage(impMap, 0, 300, window);
//		if(pts.size() > 0) g2.fillOval(pts.get(0).x - 5, pts.get(0).y - 5, 10, 10);
//		for(int i = 1; i <pts.size(); i++) {
//			g2.drawLine(pts.get(i - 1).x, pts.get(i - 1).y, pts.get(i).x, pts.get(i).y);
//			g2.fillOval(pts.get(i).x - 5, pts.get(i).y - 5, 10, 10);
//		}
//	}
}