package a3;


import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import javax.swing.JFileChooser;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Mostafa Alsari/Toofy
 *
 */
public class A3 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	static A3 mainMenu = new A3();
	static Settings setting = new Settings();
	static  Viewer viewTab;
	static Manual manual = new Manual();
	static About about = new About();
	
	public static void importFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "txt files (.txt)", "txt");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION){
		    	File f = chooser.getSelectedFile();
		    	try {
					Scanner s = new Scanner(f);
					viewTab = new Viewer(s);
					mainMenu.setVisible(false);
					viewTab.setVisible(true);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    }
		    if(returnVal == JFileChooser.CANCEL_OPTION){
		    	mainMenu.setVisible(true);
		    }
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			System.exit(JFrame.EXIT_ON_CLOSE);
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			System.exit(JFrame.EXIT_ON_CLOSE);
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			System.exit(JFrame.EXIT_ON_CLOSE);
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			System.exit(JFrame.EXIT_ON_CLOSE);
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					mainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public A3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JButton btnImportTab = new JButton("Import Tab");
		btnImportTab.addActionListener(new ActionListener() {       //code for opening filechooser and importing txt
			public void actionPerformed(ActionEvent e) {
				importFile();
			}

		});
		btnImportTab.setBounds(340, 90, 117, 25);
		getContentPane().add(btnImportTab);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting.setVisible(true);
				
			}
		});
		btnSettings.setBounds(340, 143, 117, 25);
		getContentPane().add(btnSettings);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(340, 197, 117, 25);
		getContentPane().add(btnExit);
		
		JLabel lblThisProgramIs = new JLabel("This program is a simple guitar tab viewer.");
		lblThisProgramIs.setBounds(223, 31, 351, 15);
		getContentPane().add(lblThisProgramIs);
		
		JLabel lblPleaseEnsureThat = new JLabel("Please ensure that imported files are of .txt format.");
		lblPleaseEnsureThat.setBounds(209, 50, 379, 15);
		getContentPane().add(lblPleaseEnsureThat);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		
		
		mntmImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importFile();
			}
		});
		
		
		
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		
		mntmSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting.setVisible(true);
				
			}
		});
		mnFile.add(mntmSettings);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu menu = new JMenu("Help");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Manual");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manual.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("About");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about.setVisible(true);
			}
		});
		menu.add(menuItem_1);
	}
}
