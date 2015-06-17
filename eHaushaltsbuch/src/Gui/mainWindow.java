package Gui;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//Menü zum test noch Textbasierend.
		System.out.println("Willkommen, drücken sie 1 für laden 2 für neuer Kalender");
		//...
		//...
		JFrame test = new mainWindow();
		
	
		
		
		//Erstelle neuen TestKalender
		Datenstrukturen.kalender kalender = new Datenstrukturen.kalender();
		
		//Erstelle eine neue Einnahmme
		//Erstelle ein Datum
		java.util.Date datum = new java.util.Date(System.currentTimeMillis());

		Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(500.0,datum,0,"");
		
		//Einnahme in Kalender einfügen
		kalender.addEinnahme(e);

		//Speichern des Kalenders
		File f = new File("Test.kal");
		Datenstrukturen.Filereadwrite.serializeKalender(f, kalender);
		
		//Laden des Kalenders in eine neue variable
		f = new File("Test.kal");
		Datenstrukturen.kalender k = new Datenstrukturen.kalender() ;
		Datenstrukturen.Filereadwrite.deserializeKalender(f, k);
		
		//Ausgabe des neuen Kalenders
		System.out.print(k);
		
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public mainWindow() {
		setTitle("eHaushaltsbuch");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTest = new JButton("Eintragen");
		btnTest.setBounds(439, 303, 117, 29);
		contentPane.add(btnTest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 25, 538, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"test", null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Text", "Betrag", "Datum", "Art"
			}
		));
		scrollPane.setViewportView(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("Betrag");
		textArea.setBounds(173, 264, 116, 22);
		contentPane.add(textArea);
		
		JTextArea txtrText = new JTextArea();
		txtrText.setToolTipText("Text");
		txtrText.setBounds(22, 264, 116, 22);
		contentPane.add(txtrText);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Privat", "Schule", "Lebensmittel", "Kino"}));
		comboBox.setBounds(429, 264, 137, 27);
		contentPane.add(comboBox);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("27.06.2015");
		textArea_1.setToolTipText("Datum");
		textArea_1.setBounds(301, 264, 116, 22);
		contentPane.add(textArea_1);
		
		JLabel lblText = new JLabel("Text");
		lblText.setBounds(22, 247, 61, 16);
		contentPane.add(lblText);
		
		JLabel lblBetrag = new JLabel("Betrag");
		lblBetrag.setBounds(173, 247, 61, 16);
		contentPane.add(lblBetrag);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(301, 247, 61, 16);
		contentPane.add(lblDatum);
		
		JLabel lblArt = new JLabel("Art");
		lblArt.setBounds(435, 244, 61, 16);
		contentPane.add(lblArt);
		
		JLabel lblBilanz = new JLabel("Bilanz");
		lblBilanz.setBounds(173, 329, 61, 16);
		contentPane.add(lblBilanz);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(225, 323, 80, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		

		
	}
}
