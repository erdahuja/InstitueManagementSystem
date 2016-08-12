package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bmpl.ims.users.dao.CoursesDAO;
import com.bmpl.ims.users.dto.AddCourseDTO;

public class CourseView extends JFrame {

	static JTextField txtName;
	static JTextField txtRegistration;
	static JTextField txtCourse;
	static JTextField txtCourseTotal;
	static JTextField txtTrainer;
	static JTextArea txtDays;
	static JTextArea txtDescription;
	static JFrame frame = new JFrame();

	public static void main(String[] args) {

		new CourseView();

	}

	public CourseView() {

		frame.setBounds(100, 100, 450, 450);

		frame.getContentPane().setLayout(null);

		frame.setTitle("Add Course");

		txtName = new JTextField();
		txtName.setBounds(214, 45, 114, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblCourse = new JLabel("Course Name ");
		lblCourse.setBounds(55, 47, 141, 17);
		frame.getContentPane().add(lblCourse);

		JLabel lblCourseDur = new JLabel("Course Duration");
		lblCourseDur.setBounds(55, 86, 141, 15);
		frame.getContentPane().add(lblCourseDur);

		txtDays = new JTextArea();
		txtDays.setBounds(224, 81, 32, 24);

		frame.getContentPane().add(txtDays);

		JLabel lblMonths = new JLabel("Days");
		lblMonths.setBounds(261, 81, 70, 15);
		frame.getContentPane().add(lblMonths);

		JLabel lblFees = new JLabel("Course Fees:");
		lblFees.setBounds(55, 119, 106, 15);
		frame.getContentPane().add(lblFees);

		txtRegistration = new JTextField();
		txtRegistration.setBounds(271, 119, 114, 19);
		frame.getContentPane().add(txtRegistration);
		txtRegistration.setColumns(10);

		JLabel lblRegistration = new JLabel("Registration :");
		lblRegistration.setBounds(173, 119, 97, 15);
		frame.getContentPane().add(lblRegistration);

		JLabel lblCourse_1 = new JLabel("Course :");
		lblCourse_1.setBounds(173, 149, 70, 15);
		frame.getContentPane().add(lblCourse_1);

		txtCourse = new JTextField();
		txtCourse.setBounds(271, 149, 114, 19);
		frame.getContentPane().add(txtCourse);
		txtCourse.setColumns(10);

		JButton btnTotal = new JButton("Total");
		btnTotal.setBounds(173, 184, 70, 15);
		frame.getContentPane().add(btnTotal);

		btnTotal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int regFees = Integer.parseInt(txtRegistration.getText());
				int courseFees = Integer.parseInt(txtCourse.getText());
				int sum = regFees + courseFees;
				txtCourseTotal.setText(String.valueOf(sum));
			}

		});

		txtCourseTotal = new JTextField();
		txtCourseTotal.setBounds(271, 184, 114, 19);

		frame.getContentPane().add(txtCourseTotal);
		txtCourseTotal.setColumns(10);

		JLabel lblTrainer = new JLabel("Trainer Name");
		lblTrainer.setBounds(55, 234, 130, 15);
		frame.getContentPane().add(lblTrainer);

		txtTrainer = new JTextField();
		txtTrainer.setBounds(214, 234, 114, 19);
		frame.getContentPane().add(txtTrainer);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(55, 264, 90, 15);
		frame.getContentPane().add(lblDescription);

		txtDescription = new JTextArea();
		txtDescription.setBounds(214, 264, 170, 100);
		frame.getContentPane().add(txtDescription);

		JButton btnAddcourse = new JButton("Add Course");
		btnAddcourse.setBounds(55, 377, 150, 24);
		frame.getContentPane().add(btnAddcourse);

		btnAddcourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Added");
				try {
					CoursesDAO.deleteCourse(txtName.getText());
					addCourse();
					frame.setVisible(false);
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Course Added " + txtName.getText());
					// UpdateCourseView.bringCourses();

				} catch (Exception e1)// TODO Auto-generated catch block
				{
					e1.printStackTrace();
				}

			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(268, 377, 117, 25);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();

			}
		});

		frame.setVisible(true);

	}

	private void addCourse() {

		CoursesDAO coursesDAO = new CoursesDAO();
		AddCourseDTO addCourseDTO = new AddCourseDTO();
		addCourseDTO.setCourse_name(txtName.getText().toUpperCase());
		addCourseDTO.setDuration(Integer.parseInt(txtDays.getText().trim()));
		addCourseDTO.setTrainer_name(txtTrainer.getText().toUpperCase());
		addCourseDTO.setCourse_description(txtDescription.getText());
		addCourseDTO.setFees(Integer.parseInt(txtCourseTotal.getText().trim()));

		try {
			if (coursesDAO.addCourse(addCourseDTO)) {
				System.out.println(addCourseDTO);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	public static String viewCourse(AddCourseDTO addCourseDTO) {

		txtName.setText(addCourseDTO.getCourse_name());
		txtDays.setText(String.valueOf(addCourseDTO.getDuration()));
		txtTrainer.setText(addCourseDTO.getTrainer_name());
		txtDescription.setText(addCourseDTO.getCourse_description());
		txtCourseTotal.setText(String.valueOf(addCourseDTO.getFees()));

		String info = "Course Name :" + addCourseDTO.getCourse_name() + "\nFees :"
				+ String.valueOf(addCourseDTO.getFees()) + "\nDuration :" + String.valueOf(addCourseDTO.getDuration())
				+ "\nTrainer :" + addCourseDTO.getTrainer_name() + "\nDescription :"
				+ addCourseDTO.getCourse_description();

		return info;

	}
}
