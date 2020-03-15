package bsuir.vmsis.kpp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Source {

public void logic_function(JLabel jl3,JLabel jl4,Integer dm,Integer dt)	
{
	jl3.setText("Частное: " + dm / dt);
	jl4.setText("Остаток: " + dm % dt);
}
	
Source()
{
	JFrame jframe= new JFrame("Lab1Var30");
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screensize=kit.getScreenSize();
	jframe.setBounds(screensize.width/2-180,screensize.height/2-70,360,140);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setVisible(true);
	jframe.setLayout(null);
	jframe.setResizable(false);
	
	JLabel jl1=new JLabel("Делимое");
	jl1.setBounds(10,10,60,20);
	jframe.add(jl1);
	
	JLabel jl2= new JLabel("Делитель");
	jl2.setBounds(10,40,60,20);
	jframe.add(jl2);
	
	JTextField jtf1=new JTextField();
	jtf1.setBounds(80,10,150,20);
	jframe.add(jtf1);
	
	JTextField jtf2=new JTextField();
	jtf2.setBounds(80,40,150,20);
	jframe.add(jtf2);
	
	JButton jb1= new JButton("Поделить");
	jb1.setBounds(240,40,100,20);
	jframe.add(jb1);
	
	JLabel jl3=new JLabel("Частное:");
	jl3.setBounds(10,70,110,20);
	jframe.add(jl3);
	
	JLabel jl4=new JLabel("Остаток:");
	jl4.setBounds(130,70,110,20);
	jframe.add(jl4);
	
	jb1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent a) {
		int flag=0;
		if(jtf1.getText().trim().length()==0)
		{
				jtf1.setText("Поле не заполнено!");
				jl3.setText("Частное");
				jl4.setText("Остаток");
				flag++;
	    }
		if(jtf2.getText().trim().length()==0)
		{
			jtf2.setText("Поле не заполнено!");
			jl3.setText("Частное");
			jl4.setText("Остаток");
			flag++;
		}
		if(flag!=0)
			return;
			if(jtf1.getText().trim().length()!=0 && jtf2.getText().trim().length()!=0)
			{
				flag=0;
				Integer dm=0,dt=0;
				try
				{
					dm=Integer.parseInt(jtf1.getText());
					
				}
				catch(NumberFormatException r)
				{
					jtf1.setText("Введено нечисло");
					jl3.setText("Частное");
					jl4.setText("Остаток");
					flag++;
				}
					
				try
				{
					dt=Integer.parseInt(jtf2.getText());
				}
				catch(NumberFormatException r)
				{
					jtf2.setText("Введено нечисло");
					jl3.setText("Частное");
					jl4.setText("Остаток");
					flag++;
				}
				if(flag!=0)
					return ;
				try
				{
					logic_function(jl3,jl4,dm,dt);
				}
				catch(ArithmeticException e)
				{
					jtf2.setText(" Деление на ноль");
					jl3.setText("Частное");
					jl4.setText("Остаток");
					return ;
				}
				
			}
		
		
		}
	});
			
}

public static void main(String[] args)
{
	SwingUtilities.invokeLater(new Runnable()
			{
		public void run()
		{
			new Source();
		}
			});
}
}
