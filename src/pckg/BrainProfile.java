package pckg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class BrainProfile extends Brain
{
	String response;
	public BrainProfile() 
	{
		
		
	}
	
	public BrainProfile(String response) {}
	
	public String getResponse() 
	{
		return this.response;
	}
	
	
	
	
	public void brain_profile_init(Brain b, BrainProfile  bp) 
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocation(400, 0);
		frame.setResizable(false);
		
		init_window.add(0, frame);
		
		// JFrame Info for Menu 
		
		
		JPanel exit_panel = new JPanel();
		exit_panel.setBounds(20, 900, 250, 250);
		JButton exit_button = new JButton("Save and Close");
		
		JPanel final_panel  = new JPanel();
		final_panel.setBounds(800, 900, 250, 250);
		JButton final_button = new JButton("Save");
		
		
		exit_panel.add(exit_button);
		frame.add(exit_panel);
		final_panel.add(final_button);
		frame.add(final_panel);
		
		JPanel panel_one = new JPanel();
		frame.add(panel_one);
		
		
		
		JTextArea box_one = new JTextArea(50,70);
		box_one.setLineWrap(true);
		box_one.setPreferredSize(box_one.getPreferredSize());
		
		
		
		panel_one.add(box_one);
		
		final_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				bp.response = box_one.getText();
				b.setProfile(bp);
				brains.add(b);
				frame.dispose();
				
				init();
				
			}
			
		});
		
		exit_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				bp.response = box_one.getText();
				b.setProfile(bp);
				brains.add(b);
				frame.dispose();
				
				main_menu();
				
			}
			
		});
		
		box_one.setVisible(true);
		panel_one.setVisible(true);
		
		
		
		frame.setVisible(true);
		
		
		
		
	}
	

}
