package backgammon;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class draw {
	//  JLabel label ;
	//  JPanel panel;
	  JFrame frame = new JFrame ("Just beat the computer!");
	  checkerBoard cb = new checkerBoard();
	//  JButton lattice = new JButton ();
	  MyButton [] dcb = new MyButton [15*15];
	  static int now = 0;
	  static int lastsite = 0;
       class Again implements ActionListener
       {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//frame.removeAll();
			cb.clean();
			now = 0;
			go();
			//frame.repaint();
			JButton p = (JButton) arg0.getSource();
			JPanel pa = (JPanel) p.getParent();
			JLayeredPane jl = (JLayeredPane) pa.getParent();
			JRootPane rp = (JRootPane) jl.getParent();
			JFrame jf = (JFrame) rp.getParent();
			jf.dispose();
			
			
		}
    	   
       }
	  class MyButton extends JButton implements ActionListener
	  {
		  int sign;
		  MyButton (int i)
		  {
			  sign = i;
			  super.setBackground(Color.WHITE);
			  this.addActionListener(this);
		  }  
		  MyButton(Icon A,int i)
		  {
			  super(A);
			  sign = i;
		  }
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int site = this.sign;
			
			
			//this.
			//this.set
			int aNext = 0;
			int anScore = 0;
			int high = 0,csite = 0;
			int x = site/15,y =  site%15;
			int [][]hw = new int [15][15];
			if(cb.cB[x][y] == 0)
			{
				this.setIcon(new ImageIcon(".\\black.png"));
			cb.bturn(x,y);

			   if(now == 0)
			   {
				   ++now;
			  //  csite = (int)Math.random()*15*15;
			     csite = 15*15/2;
			     if(csite == site)
			    	  csite++;
			      cb.wturn(csite/15, csite%15);
			      // System.out.println(csite);
			       dcb[csite].setIcon(new ImageIcon(".\\white.png"));
			   }
			   else
			   {
				   //	int theScore = 0;
					//if(cb.next != -1)
					  
					/*else
					{
						for(int i = 0;i!=15;++i)
							for(int j = 0;j!=15;++j)
								  if(cb.cB[i][j] == 2)
									    theScore = Math.max(theScore, cb.getScore2(i, j));
					}*/
			
			//System.out.println(anScore);
			if(cb.isWin(x, y))
			{
                 JFrame win = new JFrame("You Win!");
                 JButton label = new JButton("<html>Congratulations!  You beat the computer!<br>One more time!</html>");
                 label.addActionListener(new Again());
                 JButton close = new JButton("I don't want to play this boring game.");
                 close.addActionListener(new ActionListener()
       		  {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JButton p = (JButton) arg0.getSource();
						JPanel pa = (JPanel) p.getParent();
						JLayeredPane jl = (JLayeredPane) pa.getParent();
						JRootPane rp = (JRootPane) jl.getParent();
						JFrame jf = (JFrame) rp.getParent();
						jf.dispose();
						frame.dispose();
					}
       	   
       		  });
                 win.setLayout(new FlowLayout());
                 win.setSize(300, 200);
                 
                 win.add(label);
                 win.add(close);
                  win.setVisible(true);
                  //System.exit(0);
				//after black win
			}
			else
			{

		for(int i = 0;i!=15;++i)
			for(int j = 0;j!=15;++j)
			  if(cb.cB[i][j]==0)
			  {
				  hw[i][j] = cb.getScore1(i, j);
				 // System.out.println(the+" "+i+" "+j);
				  if(hw[i][j]>high)
				  {
					  high = hw[i][j];
				csite = i*15+j;
				  }
				  else if(hw[i][j] == high)
				  {
					  if(csite/15 == 0||csite/15 == 14||csite%15 == 0||csite%15 == 14)
						  csite = i*15+j;  
				  }
			  }
		 int nowh = 0;
		for(int i = 0;i!=15;++i)
			  for(int j = 0;j!=15;++j)
				 if(cb.cB[i][j] == 0)
				 {
					 int temp = cb.getScore3(i, j);
					
					// System.out.println(temp);
					 if(anScore<temp)
					 {
						 anScore = temp ;
					 aNext = i*15+j;
					 nowh = hw[i][j];
					 }
					 else if(anScore == temp)
					 {
						 if(hw[i][j]>nowh)
						 {
							 nowh = hw[i][j];
							   aNext = i*15+j;
						 }
						 else if(hw[i][j] == nowh&&(aNext/15 == 0||aNext/15 == 14||aNext%15 == 0||aNext%15 == 14))
						 {
							 nowh = hw[i][j];
							 aNext = i*15+j;
						 }
					 }
				 }
		//System.out.println(anScore+" "+high);
		
		    if(high<anScore&&anScore>=40)
		    {
		    	csite = aNext;
		    }
	         /*if(high>theScore&&anScore<=high||anScore == 0&&theScore<50)
	                      ;
	         else if(anScore>theScore)
	        	  csite = aNext;
			else if(theScore >= 50)
            {
              csite = cb.next;
              cb.next = -1;
              cb.score = 0;
             // System.out.println(cb.next+" "+cb.cB[cb.next/15][cb.next%15]);
            }*/
			
      cb.wturn(csite/15, csite%15);
     // System.out.println(csite);
      dcb[csite].setIcon(new ImageIcon(".\\white.png"));
      if(high == 100)
      {
          JFrame win = new JFrame("You Lose!");
          JButton label = new JButton("<html>You Are A Loser!<br>Stop the challenge and do more practice!</html>");
          JButton again = new JButton ("One more time");
          label.addActionListener(new ActionListener()
        		  {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JButton p = (JButton) arg0.getSource();
						JPanel pa = (JPanel) p.getParent();
						JLayeredPane jl = (JLayeredPane) pa.getParent();
						JRootPane rp = (JRootPane) jl.getParent();
						JFrame jf = (JFrame) rp.getParent();
						jf.dispose();
						frame.dispose();
					}
        	   
        		  });
          again.addActionListener(new Again());
          again.setSize(60,40);
          label.setSize(60,40);
          win.setSize(300, 150);
         // win.setLayout(new BoxLayout(win,BoxLayout.Y_AXIS));
        win.setLayout(new FlowLayout());
         win.add(again);
         win.add(label);
           win.setVisible(true);  	  
      }
			   }
			 
		}
		}
		  
	  }
		
		}
	
	  public void go()
	  {
		// panel = new JPanel ();
		  frame.getContentPane().removeAll();
		  frame.setLayout(new GridLayout(15,15));
		  
		
		  for(int i = 0;i!=15*15;++i)
		  {
			    dcb[i] = new MyButton(i);
			   //dcb[i].addActionListener(new push());
			    
			    frame.getContentPane().add(dcb[i]);
		  }
		  frame.setVisible(true);
		  frame.setSize(800, 800);
		  
		   
	  }
	 
	  
     public static void main(String []args)
     {
    	 draw d = new draw();
    	 d.go();
     }
}
/*
 * �������˴����Ĵ���ȥ���㵱ǰ���µ��ӵĵ÷֣��������
 * С�ڻ����ģ���ѡ�����ģ����������ʵ�ǲ�����ġ���ʱ�����Ϊ�˵õ�����÷�����
 * �������˶��˵��ӵ����أ������һ���� ˫��3��90�֣���������4����ʱ��������
 * ѡ����˫��3.����Ӧ�ñȽϵ�������һ����·���������˵�ǰ�ĵ÷֡�
 * ֻҪ�����õ��ĺ��˵���һ����·����һ���Ļ���ѡ���������������˫��3 ���ˣ� ��4������
 * һ������������Ӧ���������ض�������˫��3��Ҳ��Ӧ�����·����µ÷֣���˫��3�ķ���С�ڻ�4��
 */
