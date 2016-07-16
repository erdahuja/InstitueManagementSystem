package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.bmpl.ims.users.dao.CoursesDAO;

public class UpdateCourseView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;

	DefaultListModel<String> listModel;

	public static void main(String[] args) {

		UpdateCourseView frame = new UpdateCourseView();
		frame.setVisible(true);

	}

	public UpdateCourseView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();

		contentPane.setLayout(null);
		setContentPane(contentPane);

		listModel = new DefaultListModel<String>();
		JList<String> courseList = new JList<String>(listModel);
		courseList.setValueIsAdjusting(true);
		courseList.setBounds(22, 57, 138, 177);

		JButton btnCourses = new JButton("View Courses");
		btnCourses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bringCourses();

			}
		});
		btnCourses.setBounds(31, 23, 140, 15);
		contentPane.add(btnCourses);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 50, 150, 250);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(courseList);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton.setBounds(229, 275, 117, 25);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
					System.out.println("No button clicked");
				} else if (response == JOptionPane.YES_OPTION) {
					System.out.println("Yes button clicked");
					String item = courseList.getSelectedValue();
					deleteItem(item);
				} else if (response == JOptionPane.CLOSED_OPTION) {
					System.out.println("JOptionPane closed");
				}

			}
		});
		btnDelete.setBounds(397, 275, 117, 25);
		contentPane.add(btnDelete);

	}

	protected void deleteItem(String item) {
		CoursesDAO coursesDAO = new CoursesDAO();
		System.out.println(item);
		try {
			if (item != null) {

				if (coursesDAO.deleteCourse(item)) {
					JOptionPane.showMessageDialog(this, "Course Deleted " + item);
					System.out.println("course deleted :" + item);
				}
			} else {
				JOptionPane.showMessageDialog(this, "No course to delete");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void bringCourses() {

		CoursesDAO coursesDAO = new CoursesDAO();
		try {
			ArrayList<String> list = coursesDAO.getCourse();
			if (!list.isEmpty()) {
				for (String name : list) {
					listModel.addElement(name);
					System.out.println(name);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}
}
