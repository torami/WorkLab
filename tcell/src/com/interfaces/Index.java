package com.interfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import beansAfrica.AntecedMed;
import beansAfrica.MedeDesc;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;
import beansAfrica.Visite;
import dao.Patient.TcellDAOToken;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;

public class Index extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTable table;
	private JTextField txtEnterYourGid;
	private JTextField txtName;
	private JTextField txtFistname;
	private JPasswordField passwordField;
	private JTextField txtYourDegree;
	private JTextField txtYourMission;
	private JPanel panvisite;
	private JLabel lblAjouterVisite;
	private JTextField textField;
	private JTextField txtIdpraticien;
	private JTextField txtDateVisite;
	private JTextField txtTaille;
	private JTextField txtImc;
	private JButton button;
	private JTextField txtPoid;
	private JTextField txtGlyc;
	private JTextField txtTa;
	private JTextField txtInsuline;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		final JButton visite = new JButton("Visite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 527);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		contentPane2 = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		final JPanel panpraticien = new JPanel();
		panpraticien.setBackground(SystemColor.textHighlightText);
		panpraticien.setBounds(15, 111, 162, 360);
		contentPane.add(panpraticien);
		panpraticien.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AJOUTER PRATICIEN");
		lblNewLabel.setBounds(12, 5, 135, 15);
		panpraticien.add(lblNewLabel);
	
		txtEnterYourGid = new JTextField();
		txtEnterYourGid.setBounds(12, 80, 114, 19);
		txtEnterYourGid.setText("Identifiant");
		txtEnterYourGid.setColumns(10);
		panpraticien.add(txtEnterYourGid);
	
		
		txtName = new JTextField();
		txtName.setBounds(12, 121, 114, 19);
		txtName.setText("NOM");
		txtName.setColumns(10);
		panpraticien.add(txtName);
			
		txtFistname = new JTextField();
		txtFistname.setBounds(12, 152, 114, 19);
		txtFistname.setText("PRENOM");
		txtFistname.setColumns(10);
		panpraticien.add(txtFistname);

		passwordField = new JPasswordField();
		passwordField.setBounds(12, 183, 114, 19);
		panpraticien.add(passwordField);
		
		txtYourDegree = new JTextField();
		txtYourDegree.setBounds(12, 214, 114, 19);
		txtYourDegree.setText("GRADE");
		txtYourDegree.setColumns(10);
		panpraticien.add(txtYourDegree);
		
		txtYourMission = new JTextField();
		txtYourMission.setBounds(12, 245, 114, 19);
		txtYourMission.setText("MISSION");
		txtYourMission.setColumns(10);
		panpraticien.add(txtYourMission);
		panvisite = new JPanel();
		panvisite.setLayout(null);
		panvisite.setBackground(SystemColor.windowBorder);
		panvisite.setBounds(15, 111, 162, 360);
		contentPane.add(panvisite);
		
		lblAjouterVisite = new JLabel("AJOUTER VISITE");
		lblAjouterVisite.setBounds(12, 5, 135, 15);
		panvisite.add(lblAjouterVisite);
		
		textField = new JTextField();
		textField.setText("Identifiant");
		textField.setColumns(10);
		textField.setBounds(12, 32, 114, 19);
		panvisite.add(textField);
		
		txtIdpraticien = new JTextField();
		txtIdpraticien.setText("ID_PRATICIEN");
		txtIdpraticien.setColumns(10);
		txtIdpraticien.setBounds(12, 63, 114, 19);
		panvisite.add(txtIdpraticien);
		
		txtDateVisite = new JTextField();
		txtDateVisite.setText("DATE VISITE");
		txtDateVisite.setColumns(10);
		txtDateVisite.setBounds(12, 94, 114, 19);
		panvisite.add(txtDateVisite);
		
		txtPoid = new JTextField();
		txtPoid.setText("POID");
		txtPoid.setBounds(12, 121, 114, 19);
		panvisite.add(txtPoid);
		txtPoid.setColumns(10);
		
		txtTaille = new JTextField();
		txtTaille.setText("TAILLE");
		txtTaille.setColumns(10);
		txtTaille.setBounds(12, 152, 114, 19);
		panvisite.add(txtTaille);
		
		txtImc = new JTextField();
		txtImc.setText("IMC");
		txtImc.setColumns(10);
		txtImc.setBounds(12, 183, 114, 19);
		panvisite.add(txtImc);
		
		txtGlyc = new JTextField();
		txtGlyc.setText("GLYC");
		txtGlyc.setBounds(12, 214, 114, 19);
		panvisite.add(txtGlyc);
		txtGlyc.setColumns(10);
		
		txtTa = new JTextField();
		txtTa.setText("TA");
		txtTa.setBounds(12, 245, 114, 19);
		panvisite.add(txtTa);
		txtTa.setColumns(10);
		
		txtInsuline = new JTextField();
		txtInsuline.setText("Insuline");
		txtInsuline.setBounds(12, 276, 114, 19);
		panvisite.add(txtInsuline);
		txtInsuline.setColumns(10);
		
		button = new JButton("AJOUTER");
		ImageIcon img5 = new ImageIcon(this.getClass().getResource("/insertvisite.png"));
		button.setIcon(img5);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date utilDate;
				try {
					utilDate = new SimpleDateFormat("dd MMM yyyy").parse(txtDateVisite.getText());
					java.sql.Date date = new java.sql.Date(utilDate.getTime());
					TcellDAOToken.getInstance(false).InsertVisite(Integer.parseInt(textField.getText()), Integer.parseInt(txtIdpraticien .getText()),date,txtPoid.getText(),txtTaille.getText(),txtImc.getText(),txtGlyc.getText(),txtTa.getText(),txtInsuline.getText());
					TcellDAOToken.getInstance(false).Save_DBMS_on_disk();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
				visite.doClick();
			}
		});
		button.setToolTipText("");
		button.setBounds(12, 314, 128, 34);
		panvisite.add(button);
		final JButton btnNewButton_2 = new JButton("AJOUTER");
		btnNewButton_2.setToolTipText("");
		btnNewButton_2.setBounds(18, 292, 128, 34);
		ImageIcon img4 = new ImageIcon(this.getClass().getResource("/user-add-icon.png"));
		btnNewButton_2.setIcon(img4);
		panpraticien.add(btnNewButton_2);
		final JButton praticien = new JButton("Praticien ");
		ImageIcon img3 = new ImageIcon(this.getClass().getResource("/personnel.png"));
		praticien.setIcon(img3);
		panpraticien.setVisible(false);
		panvisite.setVisible(false);
		praticien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panpraticien.setVisible(true);
				panvisite.setVisible(false);
				ArrayList<MedeDesc> result = TcellDAOToken.getInstance(false).getAllPraticien();
				try{ 
					MyParameter user = TcellDAOToken.getInstance(false).getUserById(11);
					System.out.println(user.getMyGid());
					  String[] columns = {"GID","NOM","Prenom","Grade","POSTE"};
					  DefaultTableModel model = new DefaultTableModel(columns, 0);

				      Object[] rowData = new Object[5];
				        
				      for(int i = 0; i < (result.size()); i++){

				    	  rowData[0] = result.get(i).getGID();
				    	  rowData[1] = result.get(i).getNom();
				    	  rowData[2] = result.get(i).getPrenom();
				    	  rowData[3] = result.get(i).getGrade();
				    	  rowData[4] = result.get(i).getPoste();
				    	  model.addRow(rowData);
				      }

				

				      table.setModel(model);
				      
  }
				catch(Exception ea){
					ea.printStackTrace();
				}
				
			}
		});
		praticien.setBounds(633, 36, 145, 42);
		contentPane.add(praticien);
		
		JButton historique = new JButton("Historique");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/historique.png"));
		historique.setIcon(img);
		historique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panpraticien.setVisible(false);
				panvisite.setVisible(false);
				AntecedMed result = TcellDAOToken.getInstance(false).getANTECEDENT();
				try{ 
					
					  String[] columns = {"GID","fistcon","dateinsuline","ConsoAlc","ConsoTab","AccidentVS"};
					  DefaultTableModel model = new DefaultTableModel(columns, 0);

				      Object[] rowData = new Object[6];
				        
				     
				    	  rowData[0] = result.getGID();
				    	  rowData[1] = result.getDateFirstCon();
				    	  rowData[2] = result.getDateInsuline();
				    	  rowData[3] = result.getConsoAlc();
				    	  rowData[4] = result.getConsoTab();
				    	  rowData[5] = result.getAccidentVS();
				    	  model.addRow(rowData);
					      table.setModel(model);
				      
}
				catch(Exception ea){
					ea.printStackTrace();
				}
			}
		});
		historique.setBounds(418, 36, 165, 42);
		contentPane.add(historique);
		
		JButton Info = new JButton(" Patient");
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/info.png"));
		Info.setIcon(img1);
		Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panpraticien.setVisible(false);
				panvisite.setVisible(false);
				PatDesc result = TcellDAOToken.getInstance(false).getPatient();
		
				try{ 
				
					  String[] columns = {"GID","Nom","Prenom","Date Naissance","Sexe","NiveauIntel","Profession"};
					  DefaultTableModel model = new DefaultTableModel(columns, 0);

				      Object[] rowData = new Object[7];
				        
				     
				    	  rowData[0] = result.getGID();
				    	  rowData[1] = result.getNom();
				    	  rowData[2] = result.getPrenom();
				    	  rowData[3] = result.getNaissance();
				    	  rowData[4] = result.getSexe();
				    	  rowData[5] = result.getNiveauIntel();
				    	  rowData[6] = result.getProfession();
				    	  model.addRow(rowData);
				    

				

				      table.setModel(model);
				      
}
				catch(Exception ea){
					ea.printStackTrace();
				}
			}
		});
		Info.setBounds(206, 36, 155, 42);
		contentPane.add(Info);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 111, 579, 360);
		contentPane.add(scrollPane);
		scrollPane.setBorder(null);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		visite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panpraticien.setVisible(false);
				panvisite.setVisible(true);
				ArrayList<Visite> result = TcellDAOToken.getInstance(false).getAllVisite();
				try{ 
					
					  String[] columns = {"GID","Identifiant Medecin","Date de visite ","Taux IMC","Taux Glyc","Tension C","Isuline"};
					  DefaultTableModel model = new DefaultTableModel(columns, 0);
					 
			
						
										
				      Object[] rowData = new Object[7];
				        
				      for(int i = 0; i < (result.size()); i++){
				    	  Visite maValeur = result.get(i);
				    	  rowData[0] = maValeur.getGID();
				    	  rowData[1] = maValeur.getIdPraticien();
				    	  rowData[2] = maValeur.getDatevi();
				    	  rowData[3] = maValeur.getIMC();
				    	  rowData[4] = maValeur.getGlyc();
				    	  rowData[5] = maValeur.getTA();
				    	  rowData[6] = maValeur.getInsuline();
				    	  model.addRow(rowData);
				      }
				  
				

				      table.setModel(model);
				      
}
				catch(Exception ea){
					ea.printStackTrace();
				}
			}
		});
		
		visite.setBounds(29, 36, 142, 42);
		contentPane.add(visite);
		ImageIcon img0 = new ImageIcon(this.getClass().getResource("/visite.png"));
		visite.setIcon(img0);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TcellDAOToken.getInstance(false).InsertPraticien(Integer.parseInt(txtEnterYourGid.getText()),txtName.getText(),txtFistname.getText(),passwordField.getText(),txtYourDegree.getText(),txtYourMission.getText());
				praticien.doClick();
				try {
					TcellDAOToken.getInstance(false).Save_DBMS_on_disk();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
