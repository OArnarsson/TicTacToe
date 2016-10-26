package ttt;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import ttt.Pair;

class TableInfo
{
	public final static int rectSize = 120;
	public final static int xAcc = 8;
	public final static int yAcc = 30;
	public final static int size = 3;
}

public class Draw extends TableInfo
{
    private TTTBoard p;

    public Draw() {
        JFrame Board = new JFrame();
        Board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        Board.add(p);

        Board.pack();
        Board.setVisible(true);
   }

    private void initComponents() 
    {
        p = new TTTBoard();
        
        p.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                p.list.add(findLoc(e));
                p.repaint();
            }
        });

        p.setBackground(Color.WHITE);
    }

    public static void main(String args[]) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new Draw();
            }
        });
    }
    
    public Pair<Integer, Integer> findLoc(MouseEvent e)
	{
//		int rectSize = 130; 
//		final int xAcc = 8;
//		final int yAcc = 30;
		
		int y = e.getY() - yAcc;
		int x = e.getX() - xAcc;
		
		int xLoc = 0;
		int yLoc = 0;
		
		//int size = 3;
		
		for (int i = 0; i < size; i++)
		{
							
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
		
		Pair<Integer, Integer> pair = Pair.createPair(xLoc,yLoc);

		return pair;
	}
}

@SuppressWarnings("serial")
class TTTBoard extends JPanel
{
	TableInfo info = new TableInfo();
	public final static int rectSize = TableInfo.rectSize;
	public final static int rows = TableInfo.size;
	public final static int columns = TableInfo.size;
	    
    public ArrayList< Pair<Integer, Integer> > list = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Initialize(g2d);
        for (Pair<Integer, Integer> l : list) 
        {
        	Print(l, true, g2d);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(rectSize*3 + 2, rectSize*3 + 2);
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
    
    public static void Print (Pair<Integer, Integer> k, boolean player, Graphics g)
    {
    	int x1 = k.getX() * rectSize;
    	int y1 = k.getY() * rectSize;
    	int x2 = (k.getX() + 1) * rectSize;
    	int y2 = (k.getY() + 1 ) * rectSize;
    	
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
}