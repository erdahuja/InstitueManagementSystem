package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.bmpl.ims.common.utils.CommonUtility;
import com.bmpl.ims.users.dto.RightDTO;
import com.bmpl.ims.users.dto.UserDTO;

public class WelcomeView extends JFrame {
	
	private UserDTO userDTO;

	public void setUserObject(UserDTO userDTO){
		this.userDTO = userDTO;
		this.renderMenu();
	}
	
	public static void main(String[] args) {
		
					WelcomeView frame = new WelcomeView();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public WelcomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
	}
	
	private void callScreen(String screenName){
		
		String className = CommonUtility.getClassName(screenName);
		try {
			JFrame frameObject = (JFrame)Class.forName(className).newInstance();
			frameObject.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JMenuBar menuBar = new JMenuBar();
	private void renderMenu(){
		JMenu menu = new JMenu(userDTO.getRole());
		for(RightDTO rightDTO: userDTO.getRightList()){
			JMenuItem jMenuItem = new JMenuItem(rightDTO.getRightName());
			jMenuItem.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					callScreen(rightDTO.getScreenName());
					
				}
			});
			menu.add(jMenuItem);
		}
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
}
