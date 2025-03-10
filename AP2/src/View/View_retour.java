package View;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.MainMVC;
import model.adherent;
import model.livre;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_retour {

	private JFrame frame;
	private JTextField textField_ISBN;
	private JLabel lblNewLabel_info;
	private JButton btnNewButton_1;


	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_retour() throws ClassNotFoundException, SQLException {
		MainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ISBN du livre :");
		lblNewLabel.setBounds(54, 80, 106, 14);
		frame.getContentPane().add(lblNewLabel);

		textField_ISBN = new JTextField();
		textField_ISBN.setBounds(188, 77, 137, 20);
		frame.getContentPane().add(textField_ISBN);
		textField_ISBN.setColumns(10);

		JButton btnNewButton = new JButton("Retourner le livre");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN;
				ISBN = textField_ISBN.getText();

				livre livre=MainMVC.getM().findlivre(ISBN);

				if (livre==null)
				{
					lblNewLabel_info.setText("ERREUR ISBN inconnu");
				}
				else
				{
					if (livre.getEmprunteur()==null)
					{
						lblNewLabel_info.setText("ERREUR livre pas en cours d'emprunt");
					}
					else
					{
						try {
							MainMVC.getM().retourLivre(ISBN);
							lblNewLabel_info.setText("Livre bien rendu");
						
							MainMVC.getM().getAll();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(152, 135, 173, 23);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel_info = new JLabel("");
		lblNewLabel_info.setBounds(98, 192, 247, 14);
		frame.getContentPane().add(lblNewLabel_info);
		
		btnNewButton_1 = new JButton("Retour ACCUEIL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(236, 11, 119, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("WallP");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/akashroubert/Downloads/biblio.png"));
		lblNewLabel_2.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
