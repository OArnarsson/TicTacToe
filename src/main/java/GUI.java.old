package ttt;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GUI extends JFrame
{
	private Board b = new Board();
	    public GUI() 
	    {
	        initUI();
	    }

	    private void initUI() 
	    {
	        add(new Board());

	        setTitle("Lines");
	        setSize(800, 600);
	       // addMouseListener(this);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	    
	    public static void main(String[] args) 
	    {
//	        LinesEx ex = new LinesEx();
//	        ex.setVisible(true);
	    	
	        EventQueue.invokeLater(new Runnable() 
	        {
	            @Override
	            public void run() 
	            {
	                GUI ex = new GUI();
	                ex.setVisible(true);
	            }
	        });
	    }

//		@Override
//		public void mouseClicked(MouseEvent e) 
//		{
//			// TODO Auto-generated method stub
////			System.out.println("CLIKCED");
////			int y = e.getY() - 30;
////			int x = e.getX() - 8;
//			findLoc(e);
////			System.out.println(x + " .. " + (y) );		
//		}
		
//		public int findLoc(MouseEvent e)
//		{
//			int rectSize = 130;
//			final int xAcc = 8;
//			final int yAcc = 30;
//			
//			int y = e.getY() - yAcc;
//			int x = e.getX() - xAcc;
//			
//			int xLoc = 0;
//			int yLoc = 0;
//			
//			int size = 3;
//			
//			for (int i = 0; i < size; i++)
//			{
//				
//				//System.out.println("i*rect: " + k + " rect*i+1:  " + o + " i: " + i);
//				
//				if (x > (i * rectSize) &&  x <= (rectSize * (i+1) ))
//				{
//					System.out.println("Col: " + i);
//					xLoc = i;
//				}
//				
//				if (y > (i * rectSize) &&  y <= (rectSize * (i+1) ))
//				{
//					System.out.println("Row: " + i);
//					yLoc = i;
//				}
//			}
//			
//			return rowColToPos(xLoc,yLoc);
//
//		}
		
		public int rowColToPos(int x, int y)
		{
			return (x*3 + y);
		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) 
//		{
//			// TODO Auto-generated method stub
//			System.out.println("mouseEntered");
//
//			
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			//System.out.println("mouseExited");
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			//System.out.println("mousePressed");
//
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			//System.out.println("mousePressed");
//
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			//System.out.println("actionPerformed");
//
//		}
}
