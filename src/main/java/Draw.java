package ttt;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import ttt.Pair;

class TableInfo
{
	public final static int rectSize = 160;
	public final static int xAcc = 0;
	public final static int yAcc = 0;
	public final static int size = 3;
	public final static int dimensionSize = rectSize*3;
}

public class Draw
{
    private TTTBoard p;

    public Draw() 
    {
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
            public void mousePressed(MouseEvent e)
            {
        		int y = e.getY() - TableInfo.yAcc;
        		int x = e.getX() - TableInfo.xAcc;
        		
        		System.out.println("x: " + x + " y: " + y);
        		
        		int maxSize = TableInfo.rectSize * 3;
        		
        		if (y <= maxSize && x <= maxSize)
        		{
        			p.list.add(findLoc(x, y));
        		}
        		
                p.repaint();
            }
        });

        p.setBackground(Color.WHITE);
    }

    public static void main(String args[]) 
    {
    	new Draw();
    }
    
    public Pair<Integer, Integer> findLoc(int x, int y)
	{
		int xLoc = 0;
		int yLoc = 0;
		
		for (int i = 0; i < TableInfo.size; i++)
		{
			if (x > (i * TableInfo.rectSize) &&  x <= (TableInfo.rectSize * (i+1) ))
			{
				System.out.println("Col: " + i);
				xLoc = i;
			}
			
			if (y > (i * TableInfo.rectSize) &&  y <= (TableInfo.rectSize * (i+1) ))
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
	
    public ArrayList< Pair<Integer, Integer> > list = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Initialize(g2d);
        boolean switchs = true;
        for (Pair<Integer, Integer> l : list) 
        {
        	if (switchs == true)
        	{
        		switchs = false;
        	}
        	else
        	{
        		switchs = true;
        	}
        	Print(l, switchs, g2d);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(TableInfo.dimensionSize, TableInfo.dimensionSize);
    }

    public static int Pos(int x)
    {
    	return (x * TableInfo.rectSize % ( TableInfo.rectSize*3 ) );
    }
    
    public void Initialize (Graphics g)
    {
    	for (int c = 0; c < TableInfo.size; c++)
    	{
        	for (int r = 0; r < TableInfo.size; r++)
        	{
        		g.drawRect(Pos(c), Pos(r), TableInfo.rectSize, TableInfo.rectSize);
        	}
    	}	    	
    }
    
    public static void Print (Pair<Integer, Integer> k, boolean player, Graphics g)
    {
    	int x1 = k.getX() * TableInfo.rectSize;
    	int y1 = k.getY() * TableInfo.rectSize;
    	int x2 = (k.getX() + 1) * TableInfo.rectSize;
    	int y2 = (k.getY() + 1) * TableInfo.rectSize;
    	
    	if (player)
    	{
        	g.drawLine(x1, y1, x2, y2);
        	g.drawLine(x1, y2, x2, y1);
    	}
    	else
    	{
    		g.drawOval(x1, y1, TableInfo.rectSize, TableInfo.rectSize);
    	}
    }
}