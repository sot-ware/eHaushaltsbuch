package Gui;

import java.io.File;
import java.util.Arrays;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Oberflaeche extends JFrame  {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JFrame frame;
	private double bilanz = 0.0;
	public Datenstrukturen.kalender kalender;

	
	public Oberflaeche(){
		
		//JFrame test = new mainWindow();
	

		setTitle("eHaushaltsbuch");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 25, 538, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
				"Text", "Betrag", "Datum", "Art"
			}
		));
		scrollPane.setViewportView(table);
		
		final JTextArea textArea = new JTextArea();
		textArea.setToolTipText("Betrag");
		textArea.setBounds(173, 264, 116, 22);
		contentPane.add(textArea);
		
		final JTextArea txtrText = new JTextArea();
		txtrText.setToolTipText("Text");
		txtrText.setBounds(22, 264, 116, 22);
		contentPane.add(txtrText);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Privat", "Schule", "Lebensmittel", "Kino"}));
		comboBox.setBounds(429, 264, 137, 27);
		contentPane.add(comboBox);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("27.06.2015");
		textArea_1.setToolTipText("Datum");
		textArea_1.setBounds(301, 264, 116, 22);
		contentPane.add(textArea_1);
		
		final JLabel lblText = new JLabel("Text");
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
		

		JButton btnTest = new JButton("Eintragen");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("BTn pressed: " + txtrText.getText()); //Text
				System.out.println(textArea.getText()); //Betrag
				System.out.println(textArea_1.getText()); //Datum
				System.out.println( comboBox.getSelectedItem().toString() ); //Art
				if(textArea.getText()!= null){
				addColumn(txtrText.getText(),Double.parseDouble(textArea.getText()),textArea_1.getText(),comboBox.getSelectedItem().toString());
				Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(Double.parseDouble(textArea.getText()),textArea_1.getText(),comboBox.getSelectedItem().toString(),txtrText.getText());
				kalender.addEinnahme(e);
				}
				else{
					addColumn(txtrText.getText(),0.0,textArea_1.getText(),comboBox.getSelectedItem().toString());
					Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(0.0,textArea_1.getText(),comboBox.getSelectedItem().toString(),txtrText.getText());
					kalender.addEinnahme(e);
				}
				
				File f = new File("Test.kal");
				Datenstrukturen.Filereadwrite.serializeKalender(f, kalender);
				
				calcBilanz();

				
			}
		});
		btnTest.setBounds(439, 303, 117, 29);
		contentPane.add(btnTest);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(this.bilanz+" Euro");
		textField.setBounds(225, 323, 80, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		

		
	}
	
	public void calcBilanz(){
		double z = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			z += Double.parseDouble(model.getValueAt(i, 1).toString());
			
		}
		
		this.bilanz = Math.round(z);
		textField.setText(this.bilanz+" Euro");
	}
	
	public void addColumn(String referenz,double betrag,String Datum,String art) {
	
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{referenz, betrag, Datum, art});
		
	}
	
	

	

	
	
	
}
