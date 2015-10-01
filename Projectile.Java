import java.awt.event.*;
import java.awt.*;
import java.awt.color.*;
import java.applet.*;
import java.lang.*;

public class Physics extends Applet implements Runnable,MouseMotionListener,MouseListener,ActionListener {

	Thread t;
	int x,y,x3,y3,v,a,b,r,w,h,o,ox,k=9;
	double x1,y1,x2,y2,q,s,vx,vy,m,z,time=0;
	Label l,l1,l2,l3,l4,l5,l6,l7;
	TextField tf,tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	Button b1;
	public void init()
	{
		
		t=new Thread(this);
		b1= new Button("Draw");
		l= new Label("Radius");
		l1= new Label("Velocity");
		l2= new Label("X-coordinate of ball");
		l3= new Label("y-coordinate of ball");
		l4= new Label("X-coordinate of Rectangle");
		l5= new Label("Y-coordinate of Rectangle");
		l6= new Label("Width");
		l7= new Label("Height");
		tf=new TextField(5);
		tf1=new TextField(5);
		tf2=new TextField(5);
		tf3=new TextField(5);
		tf4=new TextField(5);
		tf5=new TextField(5);
		tf6=new TextField(5);
		tf7=new TextField(5);
		add(b1);
		add(l);
		add(tf);
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(l3);
		add(tf3);
		add(l4);
		add(tf4);
		add(l5);
		add(tf5);
		add(l6);
		add(tf6);
		add(l7);
		add(tf7);
		
		b1.addActionListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
	
		
		
	}
	public void paint(Graphics g)
	{
		if(k==0)
		{
			
	if((x+a+r/2)>(x3)&&(x+a+r/2)<(x3+w)&&(y+b+r/2)>(y3-h)&&(y+b+r/2)<(y3))
	{
		k=1;
		ox=x;
       o=ox+a;
		
	}
	else
	{
	g.setColor(Color.black);
		g.fillRect(x3,650-y3,w,h);
		g.fillOval(x+a,650-(y+b),r,r);
	}
		}
	if(k==1)
	{
		g.setColor(Color.red);
		g.fillRect(x3,650-y3,w,h);
		g.fillOval(o-(x-ox),650-(y+b),r,r);

		
	}
		
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

	public void mousePressed(MouseEvent e) {
		System.out.println("i cam here when pressed ");
		x1=e.getX();
		y1=650-e.getY();
		
	}

	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		time=0;
		System.out.println("i cam here when released ");
		x2=me.getX();
		y2=650-me.getY();
		m=(y2-y1)/(x2-x1);
		if((y2-y1)>0 &&(x2-x1)>0)
		{
			q=1/(Math.sqrt(1+(m*m)));
			s=m/(Math.sqrt(1+(m*m)));
		}
		if((y2-y1)<0 &&(x2-x1)>0)
		{
			q=1/(Math.sqrt(1+(m*m)));
			s=m/(Math.sqrt(1+(m*m)));
		}
		if((y2-y1)<0&&(x2-x1)<0)
		{
			q=-1/(Math.sqrt(1+(m*m)));
			s=-m/(Math.sqrt(1+(m*m)));
		}
		if((y2-y1)>0&&(x2-x1)<0)
		{
			q=-1/(Math.sqrt(1+(m*m)));
			s=-m/(Math.sqrt(1+(m*m)));
		}
		vx=v*q;
		vy=v*s-(9.8)*time;
		a=x+a;
		b=y+b;
		z=Math.sqrt((2/9.8)*(b+((vy*vy)/(2*9.8))))+ (vy/9.8);
			t= new Thread(this);
		t.start();
		
		
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("i cam here when run ");
		while(time<z)
		{
			x=(int) (vx*time);
			y=(int) (((vx*time)*m)-((0.5)*(9.8)*(((vx*time)*(vx*time))/(vx*vx))));
			time=time+0.1;
			vy=v*s-9.8*time;	
			try {
				t.sleep(30);
			} catch (Exception e) {
			}
			repaint();
			
		}
		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		System.out.println("i cam here when Drawn ");
		// TODO Auto-generated method stub
		x=Integer.parseInt(tf2.getText());
		y=Integer.parseInt(tf3.getText());
		x3=Integer.parseInt(tf4.getText());
		y3=Integer.parseInt(tf5.getText());
		v=Integer.parseInt(tf1.getText());
		r=Integer.parseInt(tf.getText());
		w=Integer.parseInt(tf6.getText());
	    h=Integer.parseInt(tf7.getText());
		a=0;
		b=0;
		k=0;
		time=z;
		repaint();
	}

}
