package View;



import javax.swing.JFrame;
import controller.MainMVC;

import java.awt.List;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class View_Catalogue {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Catalogue() throws ClassNotFoundException, SQLException {
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
		
		List list_livre = new List();
		list_livre.setBounds(10, 39, 292, 194);
		frame.getContentPane().add(list_livre);
		
		JButton BtnRetourC = new JButton("Retour");
		BtnRetourC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		BtnRetourC.setBounds(318, 97, 117, 29);
		frame.getContentPane().add(BtnRetourC);
		

		JLabel lblNewLabel = new JLabel("BiblioCergy");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 6, 103, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/akashroubert/Downloads/biblio.png"));
		lblNewLabel_1.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblNewLabel_1);
		for(int i=0 ; i!=MainMVC.getM().getListLivre().size();i++) 
		{
			list_livre.add(MainMVC.getM().getListLivre().get(i).LigneInfo());
		}
	}
}
