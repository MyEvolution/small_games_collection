package TwoZeroFourEight;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Draw implements Serializable {
     JFrame frame  ;
     JPanel panel;
     JLabel hh;
     TheArray array;
    // JPanel panel ;
     JButton []buttons;
     JLabel text;
   //  int next;
  //   int nextV;
     int last;
     File f = new File("F:\\High.ser");
     
     int Highest_Sc,old;
     int score = 0;
     class UpAct implements ActionListener
     {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int sc = 0;
		        if((sc = array.UpMove())!=-1)
		        {
		        	for(int i = 0;i!=16;++i)
		        		  if(array.array[i/4][i%4]!=0)
		        		  {
		        			  buttons[i].setText(array.array[i/4][i%4]+"");
		        			buttons[i].setBackground(new Color(222,184,135));
		        		  }
		        		  else
		        		  {
		        			buttons[i].setText("");
		        			buttons[i].setBackground(new Color(250,235,215));
		        		  }
		        	if(sc%2 != 0)
		        		sc+=1;
		        	score+=sc;
		        	text.setText("     "+score); 
		        	
		        	  try {
						nextstep();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        else if(!array.can_not_Move())buttons[last].setBackground(new Color(222,184,135));
		        else 
		        {
		        	  try {
						nextstep();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}       	
		        }
		      
		}
    	 
     }
     class DownAct implements ActionListener
     {
 		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
 			int sc = 0;
		        if((sc = array.DownMove())!=-1)
		        {
		        	for(int i = 0;i!=16;++i)
		        		  if(array.array[i/4][i%4]!=0)
		        		  {
		        			  buttons[i].setText(array.array[i/4][i%4]+"");
		        			buttons[i].setBackground(new Color(222,184,135));
		        		  }
		        		  else
		        		  {
		        			buttons[i].setText("");
		        			buttons[i].setBackground(new Color(250,235,215));
		        		  } 
		        	if(sc%2 != 0)
		        		sc+=1;
		        	score+=sc;
		        	 text.setText("     "+score);
			        	
		        	  try {
						nextstep();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      
		        }
		        else if(!array.can_not_Move())buttons[last].setBackground(new Color(222,184,135));
		        else 
		        {
		        	  try {
						nextstep();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}       	
		        }
		       
		      
     }
     }
 	     class LeftAct implements ActionListener
 	     {
 	 		public void actionPerformed(ActionEvent arg0) {
 				// TODO Auto-generated method stub
 	 			int sc = 0;
 	 			
 			        if((sc = array.LeftMove())!=-1)
 			        {
 			        	for(int i = 0;i!=16;++i)
			        		  if(array.array[i/4][i%4]!=0)
			        		  {
			        			  buttons[i].setText(array.array[i/4][i%4]+"");
			        			buttons[i].setBackground(new Color(222,184,135));
			        		  }
			        		  else
			        		  {
			        			buttons[i].setText("");
			        			buttons[i].setBackground(new Color(250,235,215));
			        		  }   
 			        	if(sc%2 != 0)
 			        		sc+=1;
 			        	score+=sc;
 			        	 text.setText("     "+score);
 			        	
 			        	  try {
 							nextstep();
 						} catch (FileNotFoundException e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						} catch (IOException e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						}
 			       
 			        }
 			        else if(!array.can_not_Move())buttons[last].setBackground(new Color(222,184,135));
 			        else 
 			        {
 			        	  try {
 							nextstep();
 						} catch (FileNotFoundException e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						} catch (IOException e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						}       	
 			        }

 			      
 	     }
 	     }
 	 	     class RightAct implements ActionListener
 	 	     {
 	 	 		public void actionPerformed(ActionEvent arg0) {
 	 				// TODO Auto-generated method stub
 	 	 			int sc = 0;
 	 			        if((sc = array.RightMove())!=-1)
 	 			        {
 	 			        	for(int i = 0;i!=16;++i)
 	 			        		  if(array.array[i/4][i%4]!=0)
 	 			        		  {
 	 			        			  buttons[i].setText(array.array[i/4][i%4]+"");
 	 			        			buttons[i].setBackground(new Color(222,184,135));
 	 			        		  }
 	 			        		  else
 	 			        		  {
 	 			        			buttons[i].setText("");
 	 			        			buttons[i].setBackground(new Color(250,235,215));
 	 			        		  }
 	 			        	if(sc%2 != 0)
 	 			        		sc+=1;
 	 			        	score+=sc;
 	 			        	 text.setText("     "+score);
 	 			        	
 	 			        	  try {
 	 							nextstep();
 	 						} catch (FileNotFoundException e) {
 	 							// TODO Auto-generated catch block
 	 							e.printStackTrace();
 	 						} catch (IOException e) {
 	 							// TODO Auto-generated catch block
 	 							e.printStackTrace();
 	 						}

 	 			        }
 	 			        else if(!array.can_not_Move())buttons[last].setBackground(new Color(222,184,135));
 	 			        else 
 	 			        {
 	 			        	  try {
 	 							nextstep();
 	 						} catch (FileNotFoundException e) {
 	 							// TODO Auto-generated catch block
 	 							e.printStackTrace();
 	 						} catch (IOException e) {
 	 							// TODO Auto-generated catch block
 	 							e.printStackTrace();
 	 						}       	
 	 			        }

 	 		        
 	 		      
 	 	     }
 	 	     }
 	 	     void save() throws IOException
 	 	     {

  	 		    if(Highest_Sc>=old)
  	 		    {
  	 		    	ObjectOutputStream oo;
			
						oo = new ObjectOutputStream(new FileOutputStream(f));
				
  	 		    	
						oo.writeObject(Highest_Sc);
					
  	 		    }
  	 		    
 	 	     }
 	 	 void nextstep() throws FileNotFoundException, IOException
 	 	 {
 	 	//	 array.show();
 	 		 if(score>Highest_Sc)
 	 		 {
 	 			Highest_Sc = score;
 	 			hh.setText("     "+score);
 	 		 }
 	 		 int next = array.random2or4();
 	 		 last = next;
 	 		 if( next == -1)
 	 		 {
                  save();
 	 		    JFrame over = new JFrame("Game Over!");
 	 		    JButton again = new JButton("One More Time");
 	 		    JButton close = new JButton("Close");
 	 		    again.addActionListener(new Again());
 	 		    close.addActionListener(new ActionListener()
 	 		    		{

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
				 				JButton p = (JButton) e.getSource();
				 				JPanel pa = (JPanel) p.getParent();
				 				JLayeredPane jl = (JLayeredPane) pa.getParent();
				 				JRootPane rp = (JRootPane) jl.getParent();
				 				JFrame jf = (JFrame) rp.getParent();
				 				jf.dispose();
								frame.dispose();
							}
 	 		    	
 	 		    		});
 	 		    over.setLayout(new FlowLayout());
 	 		     over.setSize(250, 180);
 	 		     over.add(again);
 	 		     over.add(close);
 	 		     over.setVisible(true);
 	 		     
 	 			 //game over
 	 		 }
 	 		 else
 	 		 {
 	 			//array.array[next/4][next%4] = nextV;
 	 			buttons[next].setText(array.array[next/4][next%4]+"");
 	 			buttons[next].setBackground(new Color(210,105,30));
 	 		
 	 		      
 	 		 }
 	 		// array.show();
 	 	 }
 	       class Again implements ActionListener
 	       {

 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				// TODO Auto-generated method stub
 				//frame.removeAll();
 				array.clean();
 				//now = 0;
 				try {
					go();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				//frame.repaint();
 				JButton p = (JButton) arg0.getSource();
 				JPanel pa = (JPanel) p.getParent();
 				JLayeredPane jl = (JLayeredPane) pa.getParent();
 				JRootPane rp = (JRootPane) jl.getParent();
 				JFrame jf = (JFrame) rp.getParent();
 				jf.dispose();
 				
 				
 			}
 	    	   
 	       }
     public void go() throws FileNotFoundException, IOException, ClassNotFoundException
     {
    	 
    	 if(!f.exists())
    	 {
    		 f.createNewFile();
    		 Highest_Sc = 0; 
    	 }
    	 else
    	 {
    		 try{
    		 
    		 ObjectInputStream oi = new ObjectInputStream (new FileInputStream(f));
    		 Highest_Sc = (int)(oi.readObject());
    		 }
    		 catch (Exception e)
    		 {
    			 Highest_Sc = 0;
    		 }
    	 }
    	 old = Highest_Sc;
    	 frame = new JFrame("GAME-2048");
    	 array = new TheArray();
    //	 next = array.random2or4();
    //	 nextV = array.array[next/4][next%4];
    	// array.array[next/4][next%4] = 0;
         JLabel h= new JLabel("Highest Score:");
         hh = new JLabel("     "+Highest_Sc);
    	 panel = new JPanel();
    	 JPanel apanel = new JPanel();
    	 JPanel spanel = new JPanel();
    	 JPanel upanel = new JPanel();
    	 spanel.setLayout(new FlowLayout());
    	 upanel.setLayout(new BoxLayout(upanel,BoxLayout.Y_AXIS));
    	 panel.setSize(250,250);
    	 panel.setLayout(new GridLayout(4,4));
    	 buttons = new JButton[16];
    	  frame.setSize(450, 250);
    	  frame.setLayout(new GridLayout(1,2));
    	  frame.getContentPane().add(panel);
    	 // apanel.setSize(100,300);
    	 apanel.setLayout(new GridLayout(2,1));//(new BoxLayout(apanel,BoxLayout.Y_AXIS));
    //	 panel.setBounds(0, 0, 250, 250);
    //	 apanel.setBounds(280, 0, 400, 300);
    	  JButton right = new JButton("➡"),left = new JButton("⬅"),up = new JButton("⬆"),down = new JButton("⬇");
    	 for(int i = 0;i!=16;++i)
    	 {
    		 buttons[i] = new JButton();
    		 buttons[i].setBackground(new Color(250,235,215));
    		// buttons[i].setFont();
    		// buttons[i].setSize(50,50);
    		 panel.add(buttons[i]);
    	 }
    	 up.addActionListener(new UpAct());
    	 down.addActionListener(new DownAct());
    	 left.addActionListener(new LeftAct());
    	 right.addActionListener(new RightAct());
    	 JLabel label  = new JLabel (" Your Score:");
    	  text = new JLabel("     "+score);
    	 text.setSize(30,10);
    	 frame.getContentPane().add(panel);
    	// panel.setVisible(true);
    	 upanel.add(h);
    	 upanel.add(hh);
    	 upanel.add(label);
    	 upanel.add(text);
    	spanel.add(new JLabel ("_________"));
    	 spanel.add(up,BorderLayout.NORTH);
    	 spanel.add(new JLabel ("_________"));
    	 spanel.add(left,BorderLayout.WEST);
    	 spanel.add(down,BorderLayout.SOUTH);
    	 spanel.add(right,BorderLayout.EAST);
    	 JButton save = new JButton("Save The Score And Quit");
    	 save.addActionListener(new ActionListener()
    			 {
    			 @Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
		 				try {
							save();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.dispose();
					}});
    	 spanel.add(save);
    	 apanel.add(upanel);
    	 apanel.add(spanel);
    	 frame.getContentPane().add(apanel);
    	 frame.setVisible(true);
    	 
    	 int a = array.random2or4();
    	 int b = array.random2or4();
    	 buttons[a].setText(array.array[a/4][a%4]+"");
    	 buttons[a].setBackground(new Color(222,184,135));
    	 buttons[b].setText(array.array[b/4][b%4]+"");
    	 buttons[b].setBackground(new Color(222,184,135));
    	// array.show();
     }
     public static void main(String []args)
     {
    	 Draw d = new Draw();
    	 try {
			d.go();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
