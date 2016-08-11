package com.bmpl.ims.users.views;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bmpl.ims.users.dao.TrainerDao;
import com.bmpl.ims.users.dto.TrainerDTO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class TrainerRegistration extends JFrame {
	private static JTextField txtname;
	private static JTextField txtage;
	private static JTextField txtmobile;
	private static JTextField txtemail;
	
	private static JTextField txtsubject;
	private String path;
	private Choice  choicegender;
	private static int counter = 0;
	private ImageIcon icon = new ImageIcon(TrainerRegistration.this.getClass().getResource("green-check.png"));
	private static JTextArea txtaddress;
	
	private ImageIcon icon1 = new ImageIcon(TrainerRegistration.this.getClass().getResource("red-cross.png"));
	private static JLabel l1;
	private static JLabel l2;
	private static JLabel l3;
	private static JLabel l4;
	private static JLabel l5;
	private static JLabel l6;
	private static JLabel l7;
	private static JLabel l8;
	private static TrainerRegistration frame;
	private static JLabel lblImage;
	private 	JDatePickerImpl datePicker;

	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
					frame = new TrainerRegistration();
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
		 choicegender.setFont(new Font("Dialog", Font.BOLD, 15));
		
		 choicegender.setForeground(Color.BLACK);
		 choicegender.setBackground(Color.WHITE);
		 choicegender.add("--select--");
		 choicegender.add("Male");
		 choicegender.add("Female");
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
		txtaddress.setForeground(Color.BLACK);
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
		
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(435, 95, 70, 15);
		

		getContentPane().add(lblimg);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(30, 144, 255));
		btnSubmit.setBounds(424, 360, 117, 40);
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
		l8.setBounds(458, 251, 34, 27);
		getContentPane().add(l8);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			clear();
				
			}
		});
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setBounds(424, 290, 117, 40);
		getContentPane().add(btnReset);

		
		JButton btnViewTeachers = new JButton("View Teachers");
		
		btnViewTeachers.setBackground(new Color(30, 144, 255));
		btnViewTeachers.setBounds(396, 423, 162, 40);
		getContentPane().add(btnViewTeachers);
		
		JLabel lblHiredate = new JLabel("HireDate");
		lblHiredate.setBounds(35, 436, 70, 15);
		getContentPane().add(lblHiredate);
		
		UtilDateModel model = new UtilDateModel();
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
	datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		 datePicker.setBounds(176, 423, 196, 25);
		getContentPane().add(datePicker);
		
		lblImage = new JLabel("");
		
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					getImage();
				
			}
		});
		lblImage.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		lblImage.setBounds(409, 57, 139, 145);
		getContentPane().add(lblImage);
		
		
		
		
		
	
		
	
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
	public ImageIcon ResizeImage(String path)
    {
	ImageIcon ic = new ImageIcon(path);
     
        Image img = ic.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(),lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
 
	private void getImage() {
		 	JFileChooser fc = new JFileChooser();
		 	fc.setDialogTitle("Choose Your Image");
		    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		    final FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, & PNG Images", "jpg", "gif", "png","jpeg");
		    fc.setFileFilter(filter);
		    int returnval=fc.showOpenDialog(this);
		   
		    if(returnval==JFileChooser.APPROVE_OPTION)
		    {
		        fc.getSelectedFile();
		        path = fc.getSelectedFile().getPath();
		      
		    
		    lblImage.setIcon((ImageIcon) ResizeImage(path));
		    if(lblImage!=null){
		    	JOptionPane.showMessageDialog(this, "image found");
		    }
		           
		      

		        }   else if(returnval == JFileChooser.CANCEL_OPTION){
		        	JOptionPane.showMessageDialog(this, "No selected image"+"error");
		          }
	}
	
	private void getData() throws ClassNotFoundException, SQLException{
		
		TrainerDTO trainer = new TrainerDTO();
		if(txtname.getText().trim().length()!=0){
			trainer.setTrainer_Name(txtname.getText());;
			counter++;
			l1.setIcon(icon);
		}else{
			l1.setIcon(icon1);
		}
		if(txtage.getText().trim().length()<3 && txtage.getText().trim().length() !=0){
			trainer.setTrainer_Age(Integer.parseInt(txtage.getText()));
			l2.setIcon(icon);
			counter++;
			}else{
				l2.setIcon(icon1);
			}
		if(choicegender.getSelectedItem() == "Male" ||choicegender.getSelectedItem() == "Female"){
			trainer.setTrainer_Gender(choicegender.getSelectedItem());
			l3.setIcon(icon);
			counter++;
		}else{
			l3.setIcon(icon1);
			counter++;
		}
		if(txtaddress.getText().trim().length()!=0 && txtaddress.getText().trim().length() >10){
			trainer.setTrainer_Address(txtaddress.getText());
			l4.setIcon(icon);
			counter++;
		}else{
			l4.setIcon(icon1);
			
		}
		if(txtmobile.getText().trim().length()==10){
			trainer.setTrainer_Mobileno(txtmobile.getText());
			l5.setIcon(icon);
			counter++;
		}else{
			l5.setIcon(icon1);
		}
		if(txtemail.getText().trim().length()!=0){
			if(txtemail.getText().trim().endsWith("@gmail.com") || txtemail.getText().trim().endsWith("@yahoo.com")){
				counter++;
				trainer.setTrainer_Email(txtemail.getText());
				l6.setIcon(icon);
			}else{
				l6.setIcon(icon1);
			}
		}else{
			l6.setIcon(icon1);
		}
			if(txtsubject.getText().trim().length()!=0){
				counter++;
				trainer.setTrainer_Subject(txtsubject.getText());
				l7.setIcon(icon);
			}else{
				l7.setIcon(icon1);
			}
		if(lblImage.getIcon()!=null){
			counter++;
			trainer.setTrainer_Image(path);
			l8.setIcon(icon);
		}else{
			l8.setIcon(icon1);
		}
	
		if(counter != 8){
			System.out.println("data not saved");
		
			
			
		}else{
			counter = 0;
			Date selectedDate = (Date) datePicker.getModel().getValue();
			java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		
			trainer.setTrainer_Hire_Date(sqlDate);
			System.out.println(trainer);
		boolean istrue = 	TrainerDao.insertData(trainer);
			if(istrue){
				JOptionPane.showMessageDialog(this, "Data Saved Succesfully");
			}else{
				JOptionPane.showMessageDialog(this, "Data not Saved");
			}
		}
	}
	private static void clear(){
		  l1.setIcon(null); 
  		  l2.setIcon(null);
  		  l3.setIcon(null);
  		  l4.setIcon(null);
  		  l5.setIcon(null);
  		  l6.setIcon(null);
  		  l7.setIcon(null);
  		  l8.setIcon(null);
  		  lblImage.setIcon(null);
  		  txtname.setText("");;
  		  txtage.setText("");
  		  txtmobile.setText("");
  		  txtemail.setText("");
  		  txtsubject.setText("");
  		  txtaddress.setText("");
  		  counter = 0;
  		  
		    
		  
	}
}


