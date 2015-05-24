package a3;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Viewer extends JFrame implements ActionListener, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private JTextArea textArea = new JTextArea();
	private Integer scrollSpeed = 500;
	private JScrollPane scrollBar;
	private int counter = 0;
	private Timer time = new Timer(0, null);
	private JTextField textField;
	private String fontName = "Courier";
	private Integer index = 14;
	


	public Viewer(Scanner s) {
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem mntmMainMenu = new JMenuItem("Main Menu");
		mntmMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A3.viewTab.setVisible(false);
				A3.mainMenu.setVisible(true);
			}
		});
		menu.add(mntmMainMenu);
		
		JMenuItem menuItem = new JMenuItem("Import");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int answer = JOptionPane.showConfirmDialog(contentPane, "Would you like to keep the current window?");
				if(answer == JOptionPane.YES_OPTION){
					A3.importFile();
				}
				if(answer == JOptionPane.NO_OPTION){
					A3.viewTab.setVisible(false);
					A3.importFile();
				}
				if(answer == JOptionPane.CANCEL_OPTION){
					
				}
				
				
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Settings");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A3.setting.setVisible(true);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Exit");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		menu.add(menuItem_2);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A3.manual.setVisible(true);
			}
		});
		mnHelp.add(mntmManual);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A3.about.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[137.00,grow][78.00][135.00][89.00,grow][256.00][137.00,grow][grow][]", "[33][33][33.00px][21.00px][12.00px][33.00px][33.00px][33.00px][33.00px][33.00px][33.00px]"));
		contentPane.add(textArea, "cell 1 0 7 11,grow");
		
		
		scrollBar = new JScrollPane(textArea);
		contentPane.add(scrollBar, "cell 1 0 7 11,grow");
		
		
		final JCheckBox checkBox = new JCheckBox("Automatic Scrolling");
		

		contentPane.add(checkBox, "cell 0 0");
		
		
		
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,growx");
		textField.setColumns(10);
		textField.setText("500");
		
		
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()){
					time.setDelay(scrollSpeed);
					time.start();
				}
				JScrollBar s1 = scrollBar.getVerticalScrollBar();
					s1.setValue((s1.getValue() + 1));
					counter += 1;
					
					if(counter >= s1.getMaximum()){
						time.stop();
					}
					
					if(checkBox.isSelected() == false){
						System.out.println("STOPPED");
						time.stop();
					}
			}
		};
		
		time.addActionListener(taskPerformer);
		checkBox.addActionListener(taskPerformer);	


		
		

		
		JButton btnNewButton = new JButton("Set Speed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getSpeedInput;
				getSpeedInput = textField.getText();
				if(isInteger(getSpeedInput)){
					scrollSpeed = Integer.parseInt(getSpeedInput);
				}else{
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid number.");
				}
			}
		});
		contentPane.add(btnNewButton, "cell 0 2,alignx center");
		

		

		
		final Integer[] fontSizeArray = new Integer[20];
		for(int i = 0; (i < 20); i++){
			fontSizeArray[i] = i+1;
		}
		
		JLabel lblHigherValuesWill = new JLabel("Higher values will cause");
		lblHigherValuesWill.setHorizontalAlignment(SwingConstants.CENTER);
		lblHigherValuesWill.setFont(new Font("Dialog", Font.BOLD, 8));
		contentPane.add(lblHigherValuesWill, "cell 0 3,alignx center");
		
		JLabel lblTheScrollTo = new JLabel(" the scroll to be slower.");
		lblTheScrollTo.setFont(new Font("Dialog", Font.BOLD, 8));
		contentPane.add(lblTheScrollTo, "cell 0 4,alignx center");
		
		final JComboBox fontSizeEditor = new JComboBox(fontSizeArray);

		
		
		fontSizeEditor.setSelectedIndex(13);
		contentPane.add(fontSizeEditor, "cell 0 7,growx");
		
		
		Font font1 = new Font(fontName,0, fontSizeArray[index-1]);
		
		
		while(s.hasNextLine()){
			textArea.setFont(font1);
			textArea.append(s.nextLine() + "\n");
		}
		textArea.setCaretPosition(0);

		
		/*
		 * 
		 * 
		 * model separation done below
		 * 
		 * 
		 */
		
		DefaultComboBoxModel box1 = new DefaultComboBoxModel();
		box1.addElement(font1.getName());
		
		box1.addElement("Arial");
		box1.addElement("Times New Roman");
		box1.addElement("Comic Sans MS");
		box1.addElement("Verdana");
		box1.addElement("Impact");
		box1.addElement("Rockwell");
		box1.addElement("Serif");
		
	
		final JComboBox fontEditor = new JComboBox(box1);
	

		fontEditor.setToolTipText("Font editor");
		contentPane.add(fontEditor, "cell 0 6,growx");
		
		
		
		
		
		fontSizeEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = fontSizeEditor.getSelectedIndex();
				Font newFont = new Font(fontName, 0, fontSizeArray[index]);
				textArea.setFont(newFont);
			}
		});
		
		fontEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontName = (String) fontEditor.getSelectedItem();
				Font newFont = new Font(fontName, 0, fontSizeArray[index]);
				textArea.setFont(newFont);
			}
		});

	}

	
	 public static boolean isInteger(String s) {
	     try { 
	         Integer.parseInt(s); 
	     } catch(NumberFormatException e) { 
	         return false; 
	     }
	     return true;
	 }
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
