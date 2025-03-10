package View;

import javax.swing.JFrame;
import controller.MainMVC;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class View_Accueil {

	private JFrame frame;

	/**
	 * @throws ClassNotFoundException 
	 * @wbp.parser.entryPoint
	 */
	public View_Accueil() throws SQLException, ClassNotFoundException {
		MainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame("MainMVC");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_catalogue = new JButton("Catalogue");
		btnNewButton_catalogue.setBackground(new Color(166, 255, 243));
		btnNewButton_catalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					View_Catalogue vc = new View_Catalogue();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_catalogue.setBounds(38, 41, 161, 29);
		frame.getContentPane().add(btnNewButton_catalogue);
		
		JButton Bouton_Retour1 = new JButton("Retour");
		Bouton_Retour1.setBackground(new Color(124, 252, 102));
		Bouton_Retour1.setBounds(260, 115, 117, 29);
		frame.getContentPane().add(Bouton_Retour1);
		
		JLabel lblNewLabel = new JLabel("Selectionner une option");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(148, 13, 161, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton Bouton_InfoPerso = new JButton("Infos personnelles");
		Bouton_InfoPerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					View_Utilisateur vu = new View_Utilisateur();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		

		JButton btnEmprunt = new JButton("Emprunter un livre");
		btnEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					View_Emprunt ve = new View_Emprunt();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmprunt.setBounds(38, 89, 189, 29);
		frame.getContentPane().add(btnEmprunt);
		
		
		JButton Btn_Retour = new JButton("Retour article");
		Btn_Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					View_retour vr = new View_retour();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Btn_Retour.setBounds(64, 130, 117, 29);
		frame.getContentPane().add(Btn_Retour);
		// TODO Auto-generated method stub
		
		Bouton_InfoPerso.setBounds(50, 171, 161, 29);
		frame.getContentPane().add(Bouton_InfoPerso);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("BiblioCergy");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1.setBounds(6, 0, 81, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("WallP");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/akashroubert/Downloads/biblio.png"));
		lblNewLabel_2.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblNewLabel_2);
		
	
		
		
	}
}
