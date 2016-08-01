package com.bmpl.ims.users.views;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bmpl.ims.users.dao.TrainerDao;
import com.bmpl.ims.users.dto.TrainerDTO;

public class TrainerRegistration extends JFrame {
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtmobile;
	private JTextField txtemail;
	private JTextField txtsubject;
	private JLabel lblImg;
	private String path;
	private Choice  choicegender;
	private static int counter = 0;
	private ImageIcon icon = new ImageIcon(TrainerRegistration.this.getClass().getResource("green-check.png"));
	private JTextArea txtaddress;
	
	private ImageIcon icon1 = new ImageIcon(TrainerRegistration.this.getClass().getResource("red-cross.png"));
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;
	

	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
					TrainerRegistration frame = new TrainerRegistration();
					frame.setVisible(true);
					
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public TrainerRegistration() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	
	
		setFont(new Font("Apple Garamond", Font.BOLD | Font.ITALIC, 20));
		setTitle("Trainer Registration");
		getContentPane().setBackground(new Color(135, 206, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 100, 586, 500);
		this.getContentPane().setLayout(null);
		
		JLabel lblTrainerName = new JLabel("Trainer Name");
		lblTrainerName.setBounds(35, 68, 95, 15);
		getContentPane().add(lblTrainerName);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(35, 119, 70, 15);
		getContentPane().add(lblAge);
		
		 choicegender = new Choice();
		 choicegender.setFont(null);
		 choicegender.setForeground(Color.BLACK);
		 choicegender.setBackground(Color.WHITE);
		 choicegender.add("--select--");
		 choicegender.add("Male");
		 choicegender.add("Female");
		choicegender.setIgnoreRepaint(true);
		choicegender.setBounds(178, 158, 194, 21);
		getContentPane().add(choicegender);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(35, 158, 70, 15);
		getContentPane().add(lblGender);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(35, 279, 95, 15);
		getContentPane().add(lblMobileNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(35, 185, 70, 15);
		getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(35, 336, 82, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(35, 389, 70, 15);
		getContentPane().add(lblSubject);
		
		txtname = new JTextField();
		txtname.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtname.setBounds(178, 57, 194, 38);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtage = new JTextField();
		txtage.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtage.setColumns(10);
		txtage.setBounds(178, 108, 194, 38);
		getContentPane().add(txtage);
		
		txtmobile = new JTextField();
		txtmobile.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtmobile.setBounds(178, 267, 194, 38);
		getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		txtaddress = new JTextArea();
		txtaddress.setForeground(Color.WHITE);
		txtaddress.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtaddress.setBounds(178, 185, 194, 70);
		getContentPane().add(txtaddress);
		
		txtemail = new JTextField();
		txtemail.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtemail.setBounds(178, 325, 194, 38);
		getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtsubject = new JTextField();
		txtsubject.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtsubject.setBounds(178, 378, 194, 38);
		getContentPane().add(txtsubject);
		txtsubject.setColumns(10);
		
		lblImg = new JLabel("");
		lblImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getImage();
			}
		});
		lblImg.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		lblImg.setToolTipText("Trainer Image");
		lblImg.setBounds(409, 57, 149, 160);
		getContentPane().add(lblImg);
		
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(435, 95, 70, 15);
		

		getContentPane().add(lblimg);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(30, 144, 255));
		btnSubmit.setBounds(429, 293, 117, 40);
		btnSubmit.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e){
			  
			  try {
				getData();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		});
		getContentPane().add(btnSubmit);
		
		l1 = new JLabel("");
		l1.setBounds(142, 68, 34, 27);
		getContentPane().add(l1);
		
		l2 = new JLabel("");
		l2.setBounds(142, 108, 34, 27);
		getContentPane().add(l2);
		
		l3 = new JLabel("");
		l3.setBounds(142, 158, 34, 16);
		getContentPane().add(l3);
		
		l4 = new JLabel("");
		l4.setBounds(142, 213, 34, 27);
		getContentPane().add(l4);
		
		l5 = new JLabel("");
		l5.setBounds(142, 267, 34, 27);
		getContentPane().add(l5);
		
		l6 = new JLabel("");
		l6.setBounds(142, 336, 34, 27);
		getContentPane().add(l6);
		
		l7 = new JLabel("");
		l7.setBounds(142, 389, 34, 27);
		getContentPane().add(l7);
		
		l8 = new JLabel("");
		l8.setBounds(471, 251, 34, 27);
		getContentPane().add(l8);
		
		
	
		
	
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
	   public ImageIcon ResizeImage(String ImagePath)
	    {
	        ImageIcon MyImage = new ImageIcon(ImagePath);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
	        return image;
	    }
	 
	private void getImage(){
		 	JFileChooser fc = new JFileChooser();
		 	fc.setDialogTitle("Choose Your Image");
		    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		    final FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, & PNG Images", "jpg", "gif", "png");
		    fc.setFileFilter(filter);
		    int returnval=fc.showOpenDialog(this);
		    if(returnval==JFileChooser.APPROVE_OPTION)
		    {
		        File file = fc.getSelectedFile();
		        path = fc.getSelectedFile().getPath();
		        BufferedImage bi;
		        try
		        {   
		            bi=ImageIO.read(file);
		            lblImg.setIcon(new ImageIcon(bi));
		        }
		        catch(IOException e)
		        {
		        	JOptionPane.showMessageDialog(this, "Error while set image"+e,"error", JOptionPane.ERROR_MESSAGE);
		        }

		        }   else if(returnval == JFileChooser.CANCEL_OPTION){
		        	JOptionPane.showMessageDialog(this, "No selected image"+"error");
		          }
	}
	
	private void getData() throws ClassNotFoundException, SQLException{

		TrainerDTO trainer = new TrainerDTO();
		if(txtname.getText().trim().length()!=0){
			trainer.setTrainer_name(txtname.getText());
			counter++;
			l1.setIcon(icon);
		}else{
			l1.setIcon(icon1);
		}
		if(txtage.getText().trim().length()<3 && txtage.getText().trim().length() !=0){
			trainer.setTrainer_age(Integer.parseInt(txtage.getText()));
			l2.setIcon(icon);
			counter++;
			}else{
				l2.setIcon(icon1);
			}
		if(choicegender.getSelectedItem() == "Male" ||choicegender.getSelectedItem() == "Female"){
			trainer.setTrainer_gender(choicegender.getSelectedItem());
			l3.setIcon(icon);
			counter++;
		}else{
			l3.setIcon(icon1);
			counter++;
		}
		if(txtaddress.getText().trim().length()!=0 && txtaddress.getText().trim().length() >10){
			trainer.setTrainer_address(txtaddress.getText());
			l4.setIcon(icon);
			counter++;
		}else{
			l4.setIcon(icon1);
			
		}
		if(txtmobile.getText().trim().length()==10){
			trainer.setTrainer_mobileno(txtmobile.getText());
			l5.setIcon(icon);
			counter++;
		}else{
			l5.setIcon(icon1);
		}
		if(txtemail.getText().trim().length()!=0){
			if(txtemail.getText().trim().endsWith("@gmail.com") || txtemail.getText().trim().endsWith("@yahoo.com")){
				counter++;
				trainer.setTrainer_email(txtemail.getText());
				l6.setIcon(icon);
			}else{
				l6.setIcon(icon1);
			}
		}else{
			l6.setIcon(icon1);
		}
			if(txtsubject.getText().trim().length()!=0){
				counter++;
				trainer.setTrainer_subject(txtsubject.getText());
				l7.setIcon(icon);
			}else{
				l7.setIcon(icon1);
			}
		if(lblImg.getIcon()!=null){
			counter++;
			trainer.setTrainer_image(path);
			l8.setIcon(icon);
		}else{
			l8.setIcon(icon1);
		}
		if(counter == 8){
			System.out.println(trainer);
			boolean istrue = TrainerDao.insertData(trainer);
			if(istrue){
				JOptionPane.showMessageDialog(this, "Data Saved Succesfully");
			}else{
				JOptionPane.showMessageDialog(this, "Data not Saved");
			}
			
			
		}
	}

}
