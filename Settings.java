package a3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField xTextField;
	private JTextField yTextField;
	private JLabel lblX;
	private JLabel lblY;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem_2;

	/**
	 * Create the frame.
	 */
	
	private String x;
	private String y;
	private Integer xInt;
	private Integer yInt;
	
	public Settings() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = xTextField.getText();
				y = yTextField.getText();
				if(Viewer.isInteger(x) && Viewer.isInteger(y)){
					xInt = Integer.parseInt(x);
					yInt = Integer.parseInt(y);
					setBounds(100,100, xInt, yInt);
				}else{
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid number.");
				}
			}
		});
		btnNewButton.setBounds(164, 93, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblSetWindowSize = new JLabel("Set Window size");
		lblSetWindowSize.setBounds(148, 24, 143, 15);
		contentPane.add(lblSetWindowSize);
		
		xTextField = new JTextField();
		xTextField.setBounds(58, 51, 114, 19);
		contentPane.add(xTextField);
		xTextField.setColumns(10);
		
		yTextField = new JTextField();
		yTextField.setBounds(269, 51, 114, 19);
		contentPane.add(yTextField);
		yTextField.setColumns(10);
		
		lblX = new JLabel("x");
		lblX.setBounds(181, 53, 70, 15);
		contentPane.add(lblX);
		
		lblY = new JLabel("y");
		lblY.setBounds(399, 53, 70, 15);
		contentPane.add(lblY);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 436, 15);
		contentPane.add(menuBar);
		
		menu = new JMenu("File");
		menuBar.add(menu);
		
		menuItem_2 = new JMenuItem("Exit");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		menu.add(menuItem_2);
	}
}
