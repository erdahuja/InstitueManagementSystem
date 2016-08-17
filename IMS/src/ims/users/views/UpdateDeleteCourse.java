package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.CoursesDAO;

public class UpdateDeleteCourse extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;

	DefaultListModel<String> listModel;

	public static void main(String[] args) {

		UpdateDeleteCourse frame = new UpdateDeleteCourse();
		frame.setVisible(true);

	}

	public UpdateDeleteCourse() {
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

	}

	private void bringCourses() {

		CoursesDAO coursesDAO = new CoursesDAO();
		try {
			ArrayList<String> list = CommonMethods.getCourse();
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
