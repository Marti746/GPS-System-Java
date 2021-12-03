/**
 * Second attempt of GUI
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class DrawUI extends JPanel implements ActionListener{
	JFrame window = new JFrame("Game Template");
	Timer tmr = null;
	Random rnd = new Random();
	private JLabel fromPoint, toPoint;
	private JButton buttonFT, buttonLD, buttonSC, buttonFR;
	private JComboBox addressFrom, addressTo;
	Image imgMap = java.awt.Toolkit.getDefaultToolkit().getImage("FinalProjectGraph_Basic_400x400.png");
	Graph g = new Graph("MapInformation.txt");

//	public DrawUI(Graph g) {
	public DrawUI() {
		window.setBounds(50, 50, 500, 500);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);

		JPanel userInfo = new JPanel();
		userInfo.setLayout(new GridLayout(2, 2));
		userInfo.setBorder(new TitledBorder("Enter A Starting Loaction and an Ending Location"));


		//============================================================ Events
		//		tmr = new Timer(50, new ActionListener() {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//
		//			}
		//		});

		//============================================================ Mouse Pressed
		addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		//============================================================ Mouse Moved, Dragged
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				mouseMoved(e);
			}
		});

		//============================================================ Key pressed
		window.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});

		tmr.start();
	}

	//============================================================ Drawing
	@Override
	protected void paintComponent(Graphics g) {
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
	}

	//======================================================
	public static void main(String[] args) {
		//Graph g = new Graph("MapInformation.txt");
		//new DrawUI(g);
		new DrawUI();
	}
	//======================================================

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
			//Dijkstra.shortestPath(g, g.getVertex(addressFrom.getSelectedItem().toString()), g.getVertex(addressTo.getSelectedItem().toString()));
		}
		else if(e.getActionCommand().equals("Fewest Routes")) {
			//Dijkstra.shortestPath(g, g.getVertex(addressFrom.getSelectedItem().toString()), g.getVertex(addressTo.getSelectedItem().toString()));
		}
		else {
			Dijkstra.shortestPath(g, addressFrom.getSelectedItem().toString(), addressTo.getSelectedItem().toString());
		}
	}
}

