import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class rotate extends Applet implements MouseListener,Runnable{
 int height=20,width=20,k,t=0,x1,x2,f,p,o,m=0,u=30;
 Thread c;
 Color r=Color.red;
 Color b=Color.black;
		public void init()
	{
			addMouseListener(this);

		
	}
	public void paint(Graphics g)
	{
		if(t==1)
		{	

			g.setColor(r);
	        g.drawOval(400+(20-width)/2,400-(height-20)/2, width, height);
	        g.setColor(b);
	        g.drawArc(400+(20-width)/2, 400-(height-20)/2, width, height,90,180);
	        
		f= 400+(20-width)/2;
		p=400-(height-20)/2;
		o=height;
	}
		if(t==2)
		{
			g.setColor(b);
		
			g.drawOval(f-(width)/2,p+(o-height)/2, width, height);
			  g.setColor(r);
		        g.drawArc(f-(width)/2, p+(o-height)/2, width, height,90,180);
		}
	}
	public void run()
	{
	while(u<235)
	{
		m++;
		if(m%2==0)
		{
			r=Color.red;
			b=Color.black;
		}
		if(m%2!=0)
		{
			r=Color.black;
			b=Color.red;
		}
		while(t==1)
		{
			height=height+k;
			width=width-2*k;
			u=u+1;
			try {
				c.sleep(u);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			if(height==0 ||width==0)
			{
				t=2;
			
			}
		}
		while(t==2)
		{
			height=height-k;
			width=width+2*k;
			u=u+1;
			try {
				c.sleep(u);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			if(height==20 || width==20)
			{
				t=1;
			}
			}
	
width=20;
height=20;
	}
	
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		x1=arg0.getX();
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x2=arg0.getX();
		u= 10/(x2-x1);
		if((x2-x1)>0)
		{
			k=1;
		}
		else
		{
			k= -1;
		}
		t=1;
		width=20;
		height=20;
		m=0;
	c= new Thread(this);
	c.start();



	
}
}
