package ttt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener, MouseListener
{
    	private Graphics g2;
		public final static int rectSize = 130;
		public final static int rows = 3;
		public final static int columns = 3;
	   
		public Board() {
			// TODO Auto-generated constructor stub
			addMouseListener(this);
			//g2d = (Graphics)
		}
		
	    public static int Pos(int x)
	    {
	    	return (x * rectSize % ( rectSize*3 ) );
	    }
	    
	    public void Initialize (Graphics g)
	    {
	    	for (int c = 0; c < columns; c++)
	    	{
	        	for (int r = 0; r < rows; r++)
	        	{
	        		g.drawRect(Pos(c), Pos(r), rectSize, rectSize);
	        	}
	    	}	    	
	    }
	    
	    public int findLoc(MouseEvent e)
		{
			int rectSize = 130;
			final int xAcc = 8;
			final int yAcc = 30;
			
			int y = e.getY() - yAcc;
			int x = e.getX() - xAcc;
			
			int xLoc = 0;
			int yLoc = 0;
			
			int size = 3;
			
			for (int i = 0; i < size; i++)
			{
				
				//System.out.println("i*rect: " + k + " rect*i+1:  " + o + " i: " + i);
				
				if (x > (i * rectSize) &&  x <= (rectSize * (i+1) ))
				{
					System.out.println("Col: " + i);
					xLoc = i;
				}
				
				if (y > (i * rectSize) &&  y <= (rectSize * (i+1) ))
				{
					System.out.println("Row: " + i);
					yLoc = i;
				}
			}
			
			//Print(xLoc,yLoc,true,g);
			return rowColToPos(xLoc,yLoc);

		}
	    
	    //player x == true
	    public static void Print (int xPos, int yPos, boolean player, Graphics g)
	    {
	    	int x1 = xPos * rectSize;
	    	int y1 = yPos * rectSize;
	    	int x2 = (xPos + 1) * rectSize;
	    	int y2 = (yPos + 1 ) * rectSize;
	    	
	    	if (player)
	    	{
	        	g.drawLine(x1, y1, x2, y2);
	        	g.drawLine(x1, y2, x2, y1);
	    	}
	    	else
	    	{
	    		g.drawOval(x1, y1, rectSize, rectSize);
	    	}
	    }
	    

		public int rowColToPos(int x, int y)
		{
			return (x*3 + y);
		}
	    
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			System.out.println("CLIKCED");
//			int y = e.getY() - 30;
//			int x = e.getX() - 8;
			findLoc(e);
//			System.out.println(x + " .. " + (y) );		
			
		}
	    
	    @Override
	    public void paintComponent(Graphics g) 
	    {
	        super.paintComponent(g);
	        Initialize(g);
	        Print(0,1,false,g);
	        g2 = g;
	    }

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
