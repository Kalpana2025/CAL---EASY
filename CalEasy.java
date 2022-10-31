import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalEasy implements ActionListener {
    JFrame frame;
     JTextField textfield;
     JToggleButton tButton;
     JButton[] numberButtons = new JButton[10];
     JButton[] functionButtons = new JButton[12];
     JButton addButton,subButton,mulButton,divButton,equButton,delButton,decButton,clrButton,moduloButton,leftbrktButton,rightbrktButton,powButton;
     JPanel panel;
     Font myFont = new Font("Ink Free",Font.BOLD,30);

     double num1=0,num2=0,result=0;
     char operator;


    CalEasy(){
        frame=new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,670);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setForeground(Color.BLACK);

        textfield = new JTextField();
        textfield.setBounds(50,10,300,60);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        frame.add(textfield);

        tButton = new JToggleButton("On");
        frame.add(tButton);
        tButton.setBackground(Color.BLACK);
        tButton.setForeground(Color.WHITE);
        tButton.addActionListener(this);
        tButton.setFont(myFont);
        tButton.setFocusable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        decButton = new JButton(".");
        clrButton = new JButton("Clear");
        moduloButton = new JButton("%");
        leftbrktButton = new JButton("(");
        rightbrktButton = new JButton(")");
        powButton = new JButton("^");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = delButton;
        functionButtons[6] = decButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = moduloButton;
        functionButtons[9] = leftbrktButton;
        functionButtons[10] = rightbrktButton;
        functionButtons[11] = powButton;

        for(int i=0; i<12;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0; i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,490,145,50);
        clrButton.setBounds(205,490,145,50);
        tButton.setBounds(250,80,100,50);

        panel = new JPanel();
        panel.setBounds(50,160,300,300);
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(Color.BLACK);

        panel.add(moduloButton);
        panel.add(leftbrktButton);
        panel.add(rightbrktButton);
        panel.add(divButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);


        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(powButton);
        panel.add(equButton);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.add(panel);
        frame.add(tButton);

        for(int i=0; i<10;i++) {
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setForeground(Color.WHITE);
        }

        for(int i=0; i<12;i++) {
            functionButtons[i].setBackground(Color.BLACK);
            functionButtons[i].setForeground(Color.WHITE);
        }
    }
public static void main(String[] args){

        CalEasy cal = new CalEasy();
}

 @Override
 public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10; i++){
           if(e.getSource()== numberButtons[i]){
               textfield.setText(textfield.getText().concat(String.valueOf(i)));
           }
       }
       if(e.getSource() == decButton){
           textfield.setText(textfield.getText().concat("."));
       }
       if(e.getSource()==addButton){
         num1 = Double.parseDouble(textfield.getText());
         operator = '+';
         textfield.setText("");
       }
     if(e.getSource()==subButton) {
         num1 = Double.parseDouble(textfield.getText());
         operator = '-';
         textfield.setText("");
     }
     if(e.getSource()==mulButton) {
         num1 = Double.parseDouble(textfield.getText());
         operator = '*';
         textfield.setText("");
     }
     if(e.getSource()==divButton) {
         num1 = Double.parseDouble(textfield.getText());
         operator = '/';
         textfield.setText("");
     }
     if(e.getSource()==moduloButton) {
         num1 = Double.parseDouble(textfield.getText());
         operator = '%';
         textfield.setText("");
     }
     if(e.getSource()==powButton) {
         num1 = Double.parseDouble(textfield.getText());
         operator = '^';
         textfield.setText("");
     }

     if(e.getSource()==equButton) {
         num2 = Double.parseDouble(textfield.getText());
         switch(operator){
             case'+':
                 result = num1+num2;
                 break;
             case'-':
                 result = num1-num2;
                 break;
             case'*':
                 result = num1*num2;
                 break;
             case'/':
                 result = num1/num2;
                 break;
             case'%':
                 result =(num1*num2 )/100;
                 break;
             case'^':
                 result =Math.pow(num1,num2);
                 break;
         }
         textfield.setText(String.valueOf(result));
         num1=result;
     }
     if(e.getSource() == clrButton) {
         textfield.setText("");
     }
     if(e.getSource() == delButton) {
         String string = textfield.getText();
         textfield.setText("");
         for(int i=0; i<string.length()-1;i++){
             textfield.setText(textfield.getText()+string.charAt(i));
         }
     }
     if(tButton.isSelected()){
     tButton.setText("OFF");
     //tButton.setBackground(Color.BLACK);
     for(int i=0; i<12;i++){
         functionButtons[i].setEnabled(false);
     }
     for(int i=0; i<10; i++){
         numberButtons[i].setEnabled(false);
     }
         tButton.setBackground(Color.BLACK);
         tButton.setForeground(Color.WHITE);
     }
     else{
         tButton.setText("ON");
         for(int i=0; i<12;i++){
             functionButtons[i].setEnabled(true);
         }
         for(int i=0; i<10; i++){
             numberButtons[i].setEnabled(true);
         }
         tButton.setBackground(Color.BLACK);
         tButton.setForeground(Color.WHITE);
     }

 }
}