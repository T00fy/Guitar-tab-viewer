package a3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrDevelopedByMostafa = new JTextArea();
		txtrDevelopedByMostafa.setEditable(false);
		txtrDevelopedByMostafa.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		txtrDevelopedByMostafa.setText("Developed by Mostafa Alsari at \nThe University of Auckland\nUPI: mals426\nID: 5571080\n\nCompsci 230 Assignment 3\n\nTabs can be edited but will not be saved.");
		txtrDevelopedByMostafa.setBackground(UIManager.getColor("Button.background"));
		txtrDevelopedByMostafa.setBounds(12, 0, 424, 259);
		contentPane.add(txtrDevelopedByMostafa);
	}

}
