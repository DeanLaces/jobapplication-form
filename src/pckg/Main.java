package pckg;


import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextField;



class MyPanel extends JPanel
{
	// Auto-Generated serialVersionUID
	
	private static final long serialVersionUID = 6935271373221950880L;
	static Image img;
	int x,y;
	
	public MyPanel(Image image, int x, int y){
        MyPanel.img = image;
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
    }
	@Override
    public void paintComponent(Graphics g) 
	{

        super.paintComponent(g); // Removes previous drawings
        
        
        g.drawImage(img,x,y,null);   

    }
}



public class Main 
{
	
	static Stack<JFrame> init_window = new Stack<JFrame>();
	static ArrayList<Brain> brains = new ArrayList<Brain>();
	static ArrayList<Picker> pickers = new ArrayList<Picker>();
	static Server my_server = new Server(5000);
	static ArrayList<Socket> clientele = new ArrayList<Socket>();
	static HashMap<Brain,Picker> sorted_ages = new HashMap<Brain,Picker>();
	static HashMap<Brain,Picker> sorted_money = new HashMap<Brain,Picker>();
	static HashMap<Brain,Picker> sorted_profiles = new HashMap<Brain,Picker>();

	static int numClients;

	
	

	public static void main(String[] args) 
	{
		
		init();
		
		
		/* Send brains and pickers objects from data and encode it into .dat file
		 * Once indivual client calls match funciton decode the data and use match
		 * function with it. 
		 * 
		 * Iterate through map and determine what brains and pickers are associated together
		 * Once this is done, update client side by client side the match and alter them of its presence
		 * give them option to meet on a video call, are give them option to exchange contact info
		 * 
		 * If contact info is exchanged, picker and brain must provide two pictures(one at beginning
		 * and one at end) to indicate the conversation took place.
		 * 
		 * Once this process ends, numPeopleMet for both accounts iterates and once again on client side,
		 * MATCH FUNCTION IS AWAIITNG TO BE CALLED, BUT INFO IS ALREADY DONE! 
		 * 
		 * 
		 */
		
		
		sorted_ages = match_ages(brains,pickers);
		sorted_money = match_money(brains,pickers);
		sorted_profiles = string_comps(brains,pickers);

		
		
		
	}
	
	// Create Stack for main menu 
	public static void init() 
	{
		
		try
		{
			Socket tempClient = new Socket("127.0.0.1",5000);
			numClients+=1;
			clientele.add(tempClient);
		
	
		
		
		
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocation(400, 0);
		frame.setResizable(false);
		
		
		init_window.add(0, frame);
		
		// Drawing Images 
		
				Image nameIcon = Toolkit.getDefaultToolkit().getImage("nameIcon.png");
				int nameX = 200;
				int nameY = 200;
				
				Image roleIcon = Toolkit.getDefaultToolkit().getImage("roleIcon.png");
				int roleX = 500; // I don't have one of these yet
				int roleY = 500; 
				
				Image ageIcon = Toolkit.getDefaultToolkit().getImage("ageIcon.png");
				int ageX = 700;
				int ageY = 700;
				
				
				frame.add(new MyPanel(nameIcon,nameX,nameY));
				frame.add(new MyPanel(roleIcon,roleX,roleY));
				frame.add(new MyPanel(ageIcon,ageX,ageY));

		
		// JFrame Info for Menu 
		
		JPanel panel_one = new JPanel();
		frame.add(panel_one);
		
	
		
		
		// Name Box
		
		JTextField box_one = new JTextField(8);
		box_one.setFont(box_one.getFont().deriveFont(50f));
		box_one.setText("Name");
		
		box_one.addFocusListener(new FocusListener() 
		{
			 @Override  
			    public void focusGained(FocusEvent e) {  
				 	box_one.setText("");  
				 	
			    }  

			    @Override  
			    public void focusLost(FocusEvent e) { 

			    	if(box_one.getText().equals(""))
				 		box_one.setText("Name");  
			    }
		});
		panel_one.add(box_one);
		
	
	
		// Role Box
		
		JTextField box_two = new JTextField(8);
		box_two.setFont(box_two.getFont().deriveFont(50f));
		box_two.setText("Job");
		box_two.addFocusListener(new FocusListener() 
		{
			 @Override  
			    public void focusGained(FocusEvent e) {  
				 	box_two.setText("");  
				 	
			    }  

			    @Override  
			    public void focusLost(FocusEvent e) { 

				 	if(box_two.getText().equals(""))
				 		box_two.setText("Job");  
			    }
		});
		
		panel_one.add(box_two);
		
		
		
		
		
		// Age Box
		
		JTextField box_three = new JTextField(2);
		box_three.setFont(box_three.getFont().deriveFont(50f));
		box_three.setText("Age");
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
			    		box_three.setText("Age");  
			    }
		});
		
		
		
		panel_one.add(box_three);
		
		
		
	
		
		// Button and Action Listener
		
		JButton button_one = new JButton("Submit Info!");
		button_one.setBounds(100, 100, 150, 200);
		button_one.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(box_two.getText().toLowerCase().equals("artist") ) 
				{
					Picker p0 = new Picker();
					p0.age = Integer.parseInt(box_three.getText());
					p0.name = box_one.getText();
					frame.dispose();
					p0.picker_init(p0);
					
					
					
				}
				
				else if(box_two.getText().toLowerCase().equals("scientist")) 
				{
					Brain b0 = new Brain();
					b0.age = Integer.parseInt(box_three.getText());
					b0.name = box_one.getText();
					frame.dispose();
					b0.brain_init(b0);
					
					
					
					
				}
				frame.dispose();
				
				
				
			}
			
		});
		
		
		
		panel_one.add(button_one);		
		
		

		
		
		
		
		// ALWAYS KEEP THIS LAST!
	
		tempClient.close();
		
		
		
		
		frame.setVisible(true);
		
	
		
		
		}
		
		catch(IOException e) 
		{
			
		}
		
	}
	
	
	
	public static void mainMenu() 
	{
		// Implement JFrame menu with button indicating match, loading screen will be presented as well.
		
		/*
		 * Loading Screen will be based on the size of objs_one and objs_two ArrayLists size,
		 * after each iteration 
		 * 
		 */
		
	}
	
	
	public static HashMap<Brain,Picker> match_ages(ArrayList<Brain> objs_one, ArrayList<Picker> objs_two)
	{
		
		// Function only works with age, need to with PAY/PRICE!
		
		ArrayList<Integer> diffs = new ArrayList<Integer>();
		ArrayList<Brain> placeholder_one = new ArrayList<Brain>();
		ArrayList<Picker> placeholder_two = new ArrayList<Picker>();


		HashMap<Brain,Picker> map = new HashMap<Brain,Picker>();
		

		
		for(int z=0;z<objs_one.size(); z++) 
		{
				
			
			
			for(int l = 0;l<objs_two.size(); l++) 
			{
				
				
				
				diffs.add(Math.abs(objs_one.get(z).age - objs_two.get(l).age));
				placeholder_one.add(objs_one.get(z));
				placeholder_two.add(objs_two.get(l));
				
			}
			int min = diffs.get(0);
			int minIndex = 0;
			
			for(int iter=0;iter<diffs.size();iter++) 
			{
				
				
				
				if(min> diffs.get(iter)) 
				{
					min = diffs.get(iter);
					minIndex = iter;
				}
				
				System.out.println(placeholder_one.get(minIndex).age);
				System.out.println(placeholder_two.get(minIndex).age);

				map.put(placeholder_one.get(minIndex), placeholder_two.get(minIndex));
				

				
			}
			System.out.println("THE MIN IS " + min);
			placeholder_one.clear();
			placeholder_two.clear();
			diffs.clear();
			
			
			
			
			
		}
		
		
		
		return map;
		
	}
	
	public static HashMap<Brain,Picker> match_money(ArrayList<Brain> objs_one, ArrayList<Picker> objs_two)
	{
		
		// Function only works with age, need to with PAY/PRICE!
		
		ArrayList<Integer> diffs = new ArrayList<Integer>();
		ArrayList<Brain> placeholder_one = new ArrayList<Brain>();
		ArrayList<Picker> placeholder_two = new ArrayList<Picker>();


		HashMap<Brain,Picker> map = new HashMap<Brain,Picker>();
		

		
		for(int z=0;z<objs_one.size(); z++) 
		{
				
			
			
			for(int l = 0;l<objs_two.size(); l++) 
			{
				
				
				
				diffs.add(Math.abs((int)(objs_one.get(z).desiredPay) - (int)(objs_two.get(l).desiredPrice)));
				placeholder_one.add(objs_one.get(z));
				placeholder_two.add(objs_two.get(l));
				
			}
			int min = diffs.get(0);
			int minIndex = 0;
			
			for(int iter=0;iter<diffs.size();iter++) 
			{
				
				
				
				if(min> diffs.get(iter)) 
				{
					min = diffs.get(iter);
					minIndex = iter;
				}
				
				System.out.println(placeholder_one.get(minIndex).age);
				System.out.println(placeholder_two.get(minIndex).age);

				map.put(placeholder_one.get(minIndex), placeholder_two.get(minIndex));
				

				
			}
			System.out.println("THE MIN IS " + min);
			placeholder_one.clear();
			placeholder_two.clear();
			diffs.clear();
			
			
			
			
			
		}
		
		
		
		return map;
		
	}
	
	public static HashMap<Brain,Picker> string_comps(ArrayList<Brain> objs_one, ArrayList<Picker> objs_two)
	
	{
		ArrayList<String> brain_responses = new ArrayList<String>();
		ArrayList<String> picker_responses = new ArrayList<String>();
		ArrayList<Float> temp_percentages = new ArrayList<Float>();
		ArrayList<Float> final_percentages = new ArrayList<Float>();
		HashMap<Brain,Picker> ans = new HashMap<Brain,Picker>();


		
		for(int iter_one =0; iter_one<objs_one.size();iter_one++) 
		{
			brain_responses.add(objs_one.get(iter_one).profile.getResponse());
			
		}
		
		for(int iter_two =0; iter_two<objs_two.size();iter_two++) 
		{
			picker_responses.add(objs_two.get(iter_two).profile.getResponse());
			
		}
		
		
		
		
		for(String temp_str_0 : brain_responses) 
		{
			for(String temp_str_1: picker_responses) 
			{
				float counter = 0;
				String[] temp_one = temp_str_0.split(" ");
				String[] temp_two = temp_str_1.split(" ");
				float tot_str_size = temp_one.length + temp_two.length;
				
				int i =0;
				
				while(i<temp_one.length) 
				{
				
				for(int j=0;j<temp_two.length;j++) 
				{
					if(temp_two[j].equals(temp_one[i])) 
					{
						counter+=1;
					}
				}
				i+=1;
			}
				temp_percentages.add(((counter / tot_str_size)* 100 ));
		}
		
		
		
		}
		
		ans.put(objs_one.get(temp_percentages.indexOf(Collections.max(temp_percentages))),
				objs_two.get(temp_percentages.indexOf(Collections.max(temp_percentages))));
		
		brain_responses.remove(temp_percentages.indexOf(Collections.max(temp_percentages)));
		picker_responses.remove(temp_percentages.indexOf(Collections.max(temp_percentages)));

		
		final_percentages.add(Collections.max(temp_percentages));
		
		while(final_percentages.size() != objs_one.size() || final_percentages.size() != objs_two.size()) 
		{
			Collections.shuffle(objs_one);
			Collections.shuffle(objs_two);
			string_comps(objs_one,objs_two);
		}
		
		return ans;
			
		
		
	}
	
	
	public static void main_menu() 
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocation(400, 0);
		
		frame.setVisible(true);
	}
	
	
	
}





