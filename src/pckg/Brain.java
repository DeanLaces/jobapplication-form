package pckg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Brain extends Main
{
	int numMet;
	int age;
	String role;
	boolean hasProfile;
	String name;
	float desiredPay;
	float compPay;
	final float BP_CUT = 0.05f;
	float accept_rate;
	BrainProfile profile;
	
	public Brain() {}
	
	public Brain(String name, int age,int numMet) 
	{
		this.name = name;
		this.age = age;
		this.numMet = numMet;
	}
	
	
	public void setInfo(String role, float desiredPay, boolean hasProfile) 
	{
		this.role = role;
		this.desiredPay = desiredPay;
		this.hasProfile = hasProfile;
		
	}
	public void brain_init(Brain b) 
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
		box_one.setText("Profile?(y\n)");
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
			    		box_one.setText("Profile?(y\n)");  
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
				
				try{
					b.role = box_three.getText();
					b.desiredPay = Float.parseFloat(box_two.getText());
					b.hasProfile = hasProfile;
					b.setInfo(box_three.getText(),Float.parseFloat(box_two.getText()),hasProfile);
					}
				catch(Exception x) 
				{
					System.out.println("Error with input please submit again!");
					box_one.setText("");
					box_two.setText("");
					box_one.setText("");
					b.brain_init(b);
					hasProfile = true;

					
				}
				
				
				if(hasProfile) 
				{
					BrainProfile b_o = new BrainProfile();
				}
				
				else 
				{
					b.createProfile(b);
				}
				frame.dispose();
				
			}
			
		});
		
		
		frame.setVisible(true);
		;
		
		
		
		
	}
	
	
	
	public Brain(int age, String role, float desiredPay, float compPay, BrainProfile profile,float acceptRate) 
	{
		this.age = age;
		this.role = role;
		this.desiredPay = desiredPay;
		this.compPay = compPay;
		this.profile = profile;
		this.accept_rate = acceptRate;
		
	}
	
	public float getAcceptRate() 
	{
		return this.accept_rate;
	}
	

	public void computeMatchScore() {}
	
	public void createProfile(Brain b) 
	{
		BrainProfile bp = new BrainProfile();
		bp.brain_profile_init(b,bp);
		
		
		
	}
	
	public void setProfile(BrainProfile bp) 
	{
		this.profile = bp;
	}
	
	public String toString(Brain b) 
	{
		String ans = "";
		ans += ( b.name + "\n" + Integer.toString(b.age) + "\n" +  b.role + "\n" + b.desiredPay + "\n" 
				+ b.hasProfile + "\n" + b.profile);
		return ans;
	}
	
	
	
	

}
