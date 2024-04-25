//https://www.youtube.com/watch?v=dfhmTyRTCSQ
//از این ویدیو کمک گرفتم


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

public class Calc implements ActionListener {
    JFrame frame = new JFrame("ماشین حساب");
    JButton[] buttons = new JButton[13];  //دکمه های عملیات ها
    JButton[] numbers = new JButton[10];  //دکمه های اعداد
    JTextField Field = new JTextField();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel(); //صفحه ای که دکمه های ماشین حساب روش سوار شده
    JButton dokme = new JButton("Calculator");


    double number1,number2;
    char operator;
    Calc() {
        Dimension framesize = new Dimension(412,620);
        frame.setSize(framesize);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //////////////////////////
        panel.setBackground(Color.pink);
        panel.setBounds(0,0,412,620);
        frame.add(panel);
        panel.setLayout(null);
        ///////////////////////////
        dokme.setBounds(156,250,100,50);
        panel.add(dokme);
        dokme.addActionListener(this);
        ////////////////////////////////

        Field.setBounds(56,30,300,50);
        Field.setEditable(false);
        //////////////////////////////////
        buttons[0] =  new JButton("+");
        buttons[1] = new JButton("-");
        buttons[2] = new JButton("*");
        buttons[3] = new JButton("/");
        buttons[4] =new JButton(".");
        buttons[5] =new JButton("=");
        buttons[6] =new JButton("Delete");
        buttons[7] =new JButton("Clear");
        buttons[8] = new JButton("+/-");
        buttons[9]= new JButton("x!");
        buttons[10]=new JButton("^");
        buttons[11]=new JButton("Rad");
        buttons[12]=new JButton("ln");
        for(int i=0;i<13;i++)
        {
            buttons[i].addActionListener(this);   ///?????????

        }
        for(int i=0;i<10;i++)
        {
            numbers[i]=new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
        }

        for(int i=1;i<4;i++)
        {
            numbers[i].setBounds(56+(i-1)*75,100,75,75);
        }
        for(int i=4;i<7;i++)
        {
            numbers[i].setBounds(56+(i-4)*75,175,75,75);
        }
        for(int i=7;i<10;i++)
        {
            numbers[i].setBounds(56+(i-7)*75,250,75,75);
        }
        buttons[4].setBounds(56,325,75,75);
        numbers[0].setBounds(56+75,325,75,75);
        buttons[5].setBounds(56+150,325,75,75);
        for(int i=0;i<4;i++)
        {
            buttons[i].setBounds(281,100+i*75,75,75);
        }
        for(int i=6;i<9;i++)
        {
            buttons[i].setBounds(56+(i-6)*100,500,100,50);
        }
        for(int i=9;i<13;i++)
        {
            buttons[i].setBounds(56+(i-9)*75,400,75,75);
        }
        //////////////////////////////////////////
        panel2.setBackground(Color.pink);
        panel2.setBounds(0,0,412,620);
        panel2.setLayout(null);
    }

    public static void main(String[] args) {
        Calc main = new Calc();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==dokme)
        {
            frame.remove(panel);
            frame.add(panel2);
            frame.revalidate();
            frame.repaint();
            panel2.add(Field);
            for(int i=0;i<10;i++)
            {
                panel2.add(numbers[i]);
            }
            for(int i=0;i<13;i++)
            {
                panel2.add(buttons[i]);
            }
        }
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numbers[i])
            {
                Field.setText(Field.getText()+String.valueOf(i));
            }
        }
        if(e.getSource()==buttons[4]) //اعشار
        {
            Field.setText(Field.getText()+".");
        }
        if(e.getSource()==buttons[0]) //دکمه جمع
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText("");
            operator='+';
        }
        if(e.getSource()==buttons[1]) //دکمه تفریق
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText("");
            operator='-';
        }
        if(e.getSource()==buttons[2]) //دکمه ضرب
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText("");
            operator='*';
        }
        if(e.getSource()==buttons[3]) //دکمه تقسیم
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText("");
            operator='/';
        }
        if(e.getSource()==buttons[10])   //عدد اول به توان عدد دوم میرسد
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText("");
            operator='^';
        }
        if(e.getSource()==buttons[9])  //دکمه فاکتوریل
        {
            number1=Double.parseDouble(Field.getText());
            int f =1;
            for(int i=1;i<=number1;i++)
            {
                f=f*i;
            }
            Field.setText(String.valueOf(f));
        }
        if(e.getSource()==buttons[11])  //رادیکال عدد اول با فرجه عدد دوم حساب میشود
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText("");
            operator='R';
        }
        if(e.getSource()==buttons[12]) //لگاریتم بر مبنای طبیعی حساب میشود
        {
            number1=Double.parseDouble(Field.getText());
            Field.setText(String.valueOf(Math.log(number1)));
        }
        if(e.getSource()==buttons[5]) //دکمه مساوی
        {
            number2=Double.parseDouble(Field.getText());
            if(operator=='+')
                number1=number1+number2;
            else if(operator=='-')
                number1=number1-number2;
            else if(operator=='*')
                number1=number1*number2;
            else if(operator=='/')
                number1=number1/number2;
            else if(operator=='^')
                number1=Math.pow(number1,number2);
            else if(operator=='R')
                number1=Math.pow(number1,1/number2);


            Field.setText(String.valueOf(number1));
        }
        if(e.getSource()==buttons[7])//دکمه clear
        {
            Field.setText("");
            number1=number2=0;
            operator=' ';
        }
        if(e.getSource()==buttons[6]) //دکمه delete
        {
            String number = Field.getText();

            {number = number.substring(0,number.length()-1);
                Field.setText(number);}

        }
        if(e.getSource()==buttons[8]) //دکمه منفی کردن عدد
        {
            Field.setText(String.valueOf(-1*Double.parseDouble(Field.getText())));
        }

    }

}