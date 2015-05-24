package a3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;

public class Manual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Manual() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTheBasicsTo = new JTextArea();
		txtrTheBasicsTo.setEditable(false);
		txtrTheBasicsTo.setBackground(UIManager.getColor("Button.background"));
		txtrTheBasicsTo.setForeground(Color.BLACK);
		txtrTheBasicsTo
				.setText("\n\n\nThe Basics\n\nTo start out, tabs are written in lines, each line representing a string on the guitar. The thickest string \nbeing the bottom most line and the thinnest string being the topmost.\n\ne--------------------------------\nB--------------------------------\nG--------------------------------\nD--------------------------------\nA--------------------------------\nE--------------------------------\n\nNumbers are then placed on these lines to represent finger positions on the guitar fret board. If you read\nthe diagram below you would play this on a guitar by putting your finger just behind the 2nd fret on the \n5th string (or the second thickest string). As musical notes this would read as follows B B B C# B A. The\n‘zero’ represents playing an open string. \nSo in this case you would play the A open with no finger position on the fretboard.\n\ne-------------------------------\nB-------------------------------\nG-------------------------------\nD-------------------------------\nA--2--2--2--4--2--0-------\nE-------------------------------");
		txtrTheBasicsTo.setBounds(12, 0, 774, 559);
		contentPane.add(txtrTheBasicsTo);
	}
}
