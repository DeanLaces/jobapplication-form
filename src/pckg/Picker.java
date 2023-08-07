package pckg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Picker extends Main

{
	float desiredPrice;
	boolean hasProfile;
	String name;
	String role;
	int age;
	int numMet;
	PickerProfile profile;
	
	public Picker() 
	{
		// Keep Creating new Stacks for info collected
	
		
	}
	
	
	public Picker(String name, String role, int age, PickerProfile profile, boolean hasProfile, int numMet) 
	{
		this.name = name;
		this.role = role;
		this.age = age;
		this.profile = profile;
		this.hasProfile = hasProfile;
		this.numMet = numMet;
	}
	
	public void setInfo(String role, float desiredPrice, boolean hasProfile) 
	{
		this.role = role;
		this.desiredPrice = desiredPrice;
		
		this.hasProfile = hasProfile;
	}
	
	public void picker_init(Picker p) 
	{
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocation(400, 0);
		frame.setResizable(false);
		
		init_window.add(1, frame);
		JPanel panel_one = new JPanel();
		frame.add(panel_one);
		
		// BUTTON
		
		JPanel final_panel = new JPanel();
		
		JButton button_one = new JButton("Submit");
		
		
		final_panel.setBounds(900, 900, 100, 50);
		button_one.setVisible(true);
		final_panel.add(button_one);
		final_panel.setVisible(true);
		frame.add(final_panel);
		
		
		// Role Box
		
		JTextField box_one = new JTextField(8);
		box_one.setFont(box_one.getFont().deriveFont(50f));
		panel_one.add(box_one);
		panel_one.setBounds(100, 400, 500, 500);
		box_one.setVisible(true);
		
		box_one.setText("Profile?(y/n)");
		
		box_one.addFocusListener(new FocusListener() 
		{
			 @Override  
			    public void focusGained(FocusEvent e) {  
					

				 box_one.setText("");  
				 	
			    }  

			    @Override  
			    public void focusLost(FocusEvent e) 
			    { 
			    	if(box_one.getText().equals(""))
			    		box_one.setText("Profile?(y/n)");  
			    }
		});
		
		
		panel_one.setVisible(true);
		
			
		
		// Desired Pay Box
		
		JPanel panel_two = new JPanel();
		frame.add(panel_two);
		
		JTextField box_two = new JTextField(8);
		box_two.setFont(box_two.getFont().deriveFont(50f));
		panel_two.add(box_two);
		panel_two.setBounds(100, 200, 500, 500);
		box_two.setVisible(true);
		
		box_two.setText("Desired Pay");
		
		box_two.addFocusListener(new FocusListener() 
		{
			 @Override  
			    public void focusGained(FocusEvent e) {  
					

				 box_two.setText("");  
				 	
			    }  

			    @Override  
			    public void focusLost(FocusEvent e) 
			    { 
			    	if(box_two.getText().equals(""))
			    		box_two.setText("Desired Pay");  
			    }
		});
		
		
		panel_two.setVisible(true);
		
		
		
	
			
		
		// Has Profile
		
		JPanel panel_three = new JPanel();
		frame.add(panel_three);
		
		JTextField box_three = new JTextField(8);
		box_three.setFont(box_three.getFont().deriveFont(50f));
		panel_three.add(box_three);
		panel_three.setBounds(100, 300, 250, 250);
		box_three.setVisible(true);
		
		box_three.setText("Desired Role");
		
		box_three.addFocusListener(new FocusListener() 
		{
			 @Override  
			    public void focusGained(FocusEvent e) {  
					

				 box_three.setText("");  
				 	
			    }  

			    @Override  
			    public void focusLost(FocusEvent e) 
			    { 
			    	if(box_three.getText().equals(""))
			    		box_three.setText("Desired Role");  
			    }
		});
		
		
		panel_three.setVisible(true);
		
		
		
		
		
		button_one.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				if(box_one.getText().toLowerCase().equals("yes") 
						|| box_one.getText().toLowerCase().equals("true")) 
				{
					hasProfile = true;
				}
				
				
				p.setInfo(box_three.getText(),Float.parseFloat(box_two.getText()),hasProfile);
				
				
				if(hasProfile) 
				{
					PickerProfile p_o = new PickerProfile();
				}
				
				else 
				{
					p.createProfile(p);
				}
				
				frame.dispose();
				
			}
			
		});
		
		
		frame.setVisible(true);
		;
		
	}
	
	public void computeMatchScore() {}
	
	
	
	public void createProfile(Picker p) 
	{
		PickerProfile pp = new PickerProfile();
		pp.picker_profile_init(p,pp);
		

	}
	
	public void setProfile(PickerProfile pp) 
	{
		this.profile = pp;
	}
	
	public String toString(Picker p) 
	{
		String ans = "";
		ans += ( p.name + "\n" + Integer.toString(p.age) + "\n" +  p.role + "\n" + p.desiredPrice + "\n" 
				+ p.hasProfile + "\n" + p.profile);
		return ans;
	}
	
	
	
	
	
	
	
	
}
