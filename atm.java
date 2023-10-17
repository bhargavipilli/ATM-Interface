import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class atm extends JFrame implements ActionListener{
    static double balance=20000.01;
    public static void main(String args[]) throws NumberFormatException
    {
        String pin="123";
        
        double dup=balance;
        final String d=null;
        Map<Double,String> mini=new HashMap<>();
        JFrame f1=new JFrame("Atm interface");
        JLabel l11=new JLabel("Enter Pin");
        l11.setBounds(300,150,70,30); 
        JTextField t11=new JTextField();
        t11.setBounds(360, 150, 100, 30);
        JButton b11=new JButton("1.View Available Balance");
        b11.setBounds(50,50,200,30);   
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==b11 && t11.getText().equals(pin))
                   {
                        JFrame f2=new JFrame("Available Balance ");

                        JLabel l21=new JLabel("Your Account Balance : "+balance);
                        l21.setBounds(100,75,300,30);
                        f2.add(l21);
                        f2.setLayout(null);
                        f2.setSize(500,500);
                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f2.setVisible(true);
                   }
                
                else if(t11.getText().length()==0)
                   {
                    JOptionPane.showMessageDialog(f1,"Enter Password");
                   }
                else
                    {
                    JOptionPane.showMessageDialog(f1,"Incorrect Password");
                    }   
            }
        });
        JButton b12=new JButton("2.Withdraw Amount");
        b12.setBounds(50,100,200,30);   
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==b12 && t11.getText().equals(pin))
                {
                    JFrame f3=new JFrame("Withdraw Amount");
                    JLabel l31=new JLabel("Enter Amount");
                    l31.setBounds(75,70,150,30); 
                    JTextField t31=new JTextField();
                    t31.setBounds(170,70,100,30);
                   // double db=Double.parseDouble(t31.getText());
                    //d=t31.getText();
                    JLabel l32=new JLabel();
                    l32.setBounds(120,200,300,60);
                    JButton b31=new JButton("confirm");
                    b31.setBounds(120,120,100,30);
                    b31.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        double q=0;
                        try{
                        double qq=Double.parseDouble(t31.getText());
                        mini.put(qq," Amount Withdrawn");
                        //dup-=qq;
                         q=qq;
                    }
                    catch(NumberFormatException w){}
                    if( e.getSource()==b31 && q<balance)
                    {
                        
                       l32.setText("<html>Transaction Successful <br>Your Total Balance :"+(balance-q)); 
                       balance=balance-q;
                       //sbalance=d;
                        //System.out.println(" success");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(f3,"Insufficient Balance");
                    }
                    }
                    }); 
                     
                    f3.add(l32);
                    f3.add(b31);
                    f3.add(l31);
                    f3.add(t31);
                    f3.setLayout(null);
                    f3.setSize(500,500);
                    f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f3.setVisible(true);
                }
                else if(t11.getText().length()==0)
                   {
                    JOptionPane.showMessageDialog(f1,"Enter Password");
                   }
                else
                    {
                    JOptionPane.showMessageDialog(f1,"Incorrect Password");
                    }   
            }
        });
        JButton b13=new JButton("3.Deposit Amount");
        b13.setBounds(50,150,200,30);
        b13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==b13 && t11.getText().equals(pin))
                {
                JFrame f4=new JFrame("Deposit Amount");
                    JLabel l41=new JLabel("Enter Amount");
                    l41.setBounds(75,70,150,30); 
                    JTextField t41=new JTextField();
                    t41.setBounds(170,70,100,30);
                    JLabel l42=new JLabel();
                    l42.setBounds(120,150,300,60);
                    JButton b41=new JButton("confirm");
                    b41.setBounds(120,120,100,30);
                    b41.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        double q=0;
                        try{
                         double qq=Double.parseDouble(t41.getText());
                         mini.put(qq," Amount Deposited");

                         q=qq;
                    }
                    catch(NumberFormatException w){}
                    if( e.getSource()==b41 )
                    {
                       
                       l42.setText("<html>Deposited Successfully  <br> Your current balance: "+ (q+balance)+"</html>");
                      // l42.setText(" : "+(q+balance) ); 
                       balance=q+balance;
                       System.out.println(balance);
                        System.out.println(" success");
                    }
                }
            });
                    
                    f4.add(l41);
                    f4.add(t41);
                    f4.add(b41);
                    f4.add(l42);
                    f4.setLayout(null);
                    f4.setSize(500,500);
                    f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f4.setVisible(true);
                }
                else if(t11.getText().length()==0)
                   {
                    JOptionPane.showMessageDialog(f1,"Enter Password");
                   }
                else
                    {
                    JOptionPane.showMessageDialog(f1,"Incorrect Password");
                    }   
            }
        });   
        JButton b14=new JButton("4.View Ministatement");
        b14.setBounds(50,200,200,30);  
        b14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==b14 && t11.getText().equals(pin))
                {
                JFrame f5=new JFrame("Deposit Amount");
                    JLabel l51=new JLabel();
                    int x=75,y=30;
                    JTextField t51=new JTextField();
                    t51.setBounds(170,70,100,30);
                    JLabel l52=new JLabel();
                    l52.setBounds(120,150,200,30);
                    JTextArea ta=new JTextArea();
                    ta.setBounds(30,50,300,300);
                    l51:
               for(Map.Entry<Double,String> h:mini.entrySet())
                {
                    
                    y=y+20;
                    l51.setBounds(50,30,300,30); 
                    String s1="<html>"+h.getKey()+" "+h.getValue()+"<br></html>";   
                    System.out.println(h.getKey()+" "+h.getValue());
                    ta.append(h.getKey()+" "+h.getValue()+"\n");
                   // continue l51;
                    //break; 
                }
                ta.append("Total account balance "+balance);
                f5.add(l51);f5.add(ta);
                //f5.setLayout(null);
                    f5.setSize(500,500);
                    f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f5.setVisible(true);
            }}
        }); 
        JButton b15=new JButton("5.Exit");
        b15.setBounds(50,250,200,30); 
        b15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f1.setVisible(false);
            }
        }); 
        
        f1.add(t11);
        f1.add(b11);f1.add(b13);
        f1.add(b12);f1.add(b14);
        f1.add(b15);f1.add(l11);
        f1.setLayout(null);
        f1.setSize(500,500);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
}
