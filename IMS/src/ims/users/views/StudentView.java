package com.bmpl.ims.users.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> listModel;
	private JList<String> list;
static 	JFrame frame = new JFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	
		
				new StudentView();
	}

	
	public StudentView() {
		
		frame.setTitle("STUDENT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 848, 493);
		frame.getContentPane().setLayout(null);
		
		

		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setValueIsAdjusting(true);
		list.setBounds(36, 41, 257, 339);
		frame.getContentPane().add(list);

		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bringCourses();
			}
		});
		btnView.setBounds(145, 15, 89, 23);
		frame.getContentPane().add(btnView);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateCourse();
			}
		});
		btnUpdate.setBounds(46, 391, 89, 23);
		frame.getContentPane().add(btnUpdate);

		JLabel lblTeacher = new JLabel("Students :");
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTeacher.setBounds(26, 16, 89, 14);
		frame.getContentPane().add(lblTeacher);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCourse();
				listModel.clear();
			}

		});
		btnDelete.setBounds(204, 391, 89, 23);
		frame.getContentPane().add(btnDelete);
		

		frame.setVisible(true);
	}

	private void bringCourses() {

		com.bmpl.ims.users.dao.StudentDAO studentDAO = new com.bmpl.ims.users.dao.StudentDAO();
		try {
			ArrayList<String> list = studentDAO.getCourse();
			if (!list.isEmpty()) {
				for (String name : list) {
					listModel.addElement(name);
					System.out.println("Selected " + name);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateCourse() {

		String item = list.getSelectedValue();
		if (item != null) {
			System.out.println("Selected item " + item);
			update(item);
		} else {
			JOptionPane.showMessageDialog(null, "no student selected");
		}
	}

	private void deleteCourse() {
		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (response == JOptionPane.NO_OPTION) {
			System.out.println("No button clicked");

		} else if (response == JOptionPane.YES_OPTION) {
			System.out.println("Yes button clicked");

			String item = list.getSelectedValue();
			deleteItem(item);

		} else if (response == JOptionPane.CLOSED_OPTION) {
			System.out.println("JOptionPane closed");
		}

	}

	protected void deleteItem(String item) {
		com.bmpl.ims.users.dao.StudentDAO studentDAO = new com.bmpl.ims.users.dao.StudentDAO();
		System.out.println(item);
		try {
			if (item != null) {

				if (studentDAO.deleteCourse(item)) {
					JOptionPane.showMessageDialog(this, "Course Deleted " + item);
					System.out.println("course deleted :" + item);
				}
			} else {
				JOptionPane.showMessageDialog(this, "No student to delete");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void update(String item) {

		com.bmpl.ims.users.dao.StudentDAO studentDAO = new com.bmpl.ims.users.dao.StudentDAO();

		try {

			studentDAO.updateCourse(item);

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Cant update..");
		}

	}

}
