import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalSy implements ActionListener {
    JFrame frame;
    JTextField textField;

    JTextField textField1;
    JTextField textField2;
    JTextArea textarea;
    JMenuBar menuBar;
    JMenu menuMenu;
    JMenu menuMenu1;
    JMenuItem mnStandardItem;
    JMenuItem mnScientificItem;
    JMenuItem mnUnitConversionItem;
    JMenuItem mnExitItem;
    JMenuItem mnHistoryItem;
    JComboBox comboBox;
    JComboBox comboBox1;
    JComboBox comboBox2;
    JToggleButton tButton;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[34];
    JButton addButton, subButton, mulButton, divButton, equButton, delButton, decButton, clrButton, percentButton, leftBracketButton, rightBracketButton;
    JButton factButton, sqrtButton, negativeButton, ConvertButton, RestartButton, sinInvButton, cosInvButton, tanInvButton, powButton, octalButton;
    JButton sinButton, cosButton, tanButton, modButton, logButton, lnButton, piButton, expButton, squareButton, degButton, radButton, binButton, hexButton;
    JPanel panel;
    Font myFont = new Font("Windings", Font.ITALIC, 30);

    double num1 = 0, num2 = 0, result = 0, fact = 0, num = 0;
    String Length, Currency, Weight, Area, Temperature, Pressure, Volume;
    char operator;

    CalSy() {
        frame = new JFrame("Standard Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(430, 670);
        frame.setBounds(10, 10, 385, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        frame.add(menuBar);
        frame.setVisible(true);

        menuMenu = new JMenu("File");
        menuBar.add(menuMenu);
        mnStandardItem = new JMenuItem("Standard");
        mnStandardItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setTitle("Standard Calculator");
                frame.setBounds(10, 10, 385, 600);
            }
        });


                     mnScientificItem = new JMenuItem("Scientific");
                     mnScientificItem.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent arg0) {
                             frame.setTitle("Scientific Calculator");
                             frame.setBounds(10, 10, 850, 600);

                             panel = new JPanel();
                             panel.setBounds(355, 160, 470, 300);
                             panel.setLayout(new GridLayout(5, 4, 10, 10));
                             panel.setBackground(Color.BLACK);
                             frame.add(panel);
                             panel.setVisible(true);
                             panel.setEnabled(false);

                             textField = new JTextField();
                             textField.setBounds(50, 30, 775, 60);
                             textField.setFont(myFont);
                             textField.setEditable(false);
                             textField.setBackground(Color.BLACK);
                             frame.add(textField);
                             textField.setForeground(Color.WHITE);

                             factButton = new JButton("!");
                             sqrtButton = new JButton("√");
                             piButton = new JButton("π");
                             squareButton = new JButton("x^2");
                             expButton = new JButton("e^x");
                             logButton = new JButton("log");
                             lnButton = new JButton("ln");
                             modButton = new JButton("|x|");
                             degButton = new JButton("deg");
                             radButton = new JButton("rad");
                             sinButton = new JButton("sin");
                             cosButton = new JButton("cos");
                             tanButton = new JButton("tan");
                             sinInvButton = new JButton("sin-1");
                             cosInvButton = new JButton("cos-1");
                             tanInvButton = new JButton("tan-1");
                             binButton = new JButton("bin");
                             hexButton = new JButton("hex");
                             octalButton = new JButton("oct");
                             powButton = new JButton("^");

                             functionButtons[0] = factButton;
                             functionButtons[1] = sqrtButton;
                             functionButtons[2] = piButton;
                             functionButtons[3] = squareButton;
                             functionButtons[4] = expButton;
                             functionButtons[5] = logButton;
                             functionButtons[6] = lnButton;
                             functionButtons[7] = modButton;
                             functionButtons[8] = degButton;
                             functionButtons[9] = radButton;
                             functionButtons[10] = sinButton;
                             functionButtons[11] = cosButton;
                             functionButtons[12] = tanButton;
                             functionButtons[13] = sinInvButton;
                             functionButtons[14] = cosInvButton;
                             functionButtons[15] = tanInvButton;
                             functionButtons[16] = binButton;
                             functionButtons[17] = hexButton;
                             functionButtons[18] = octalButton;
                             functionButtons[19] = powButton;

                             panel.add(factButton);
                             panel.add(powButton);
                             panel.add(degButton);
                             panel.add(radButton);

                             panel.add(sqrtButton);
                             panel.add(sinButton);
                             panel.add(cosButton);
                             panel.add(tanButton);

                             panel.add(piButton);
                             panel.add(sinInvButton);
                             panel.add(cosInvButton);
                             panel.add(tanInvButton);

                             panel.add(lnButton);
                             panel.add(binButton);
                             panel.add(hexButton);
                             panel.add(octalButton);

                             panel.add(logButton);
                             panel.add(expButton);
                             panel.add(squareButton);
                             panel.add(modButton);

                             for (int i = 0; i < 20; i++) {
                                 functionButtons[i].addActionListener(this);
                                 functionButtons[i].setFont(myFont);
                                 functionButtons[i].setFocusable(false);
                             }
                             for (int i = 0; i < 20; i++) {
                                 functionButtons[i].setBackground(Color.BLACK);
                                 functionButtons[i].setForeground(Color.WHITE);
                             }
                             radButton.setForeground(Color.BLUE);

                             factButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     fact = 1;
                                     while (num != 0) {
                                         fact = fact * num;
                                         num--;
                                     }
                                     textField.setText("");
                                     textField.setText(textField.getText() + fact);
                                 }
                             });
                             sqrtButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.sqrt(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             squareButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = num * num;
                                     textField.setText("");
                                     num = Double.parseDouble(String.valueOf(num));
                                 }
                             });

                             piButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     // num = Double.parseDouble(textField.getText());
                                     num = (3.1415926535893238);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             lnButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.log(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             logButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.log10(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             expButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.exp(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             lnButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.log(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             modButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.abs(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             sinButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.sin(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             cosButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.cos(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             tanButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.tan(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             sinInvButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.asin(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             cosInvButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.acos(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             tanInvButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     num = Double.parseDouble(textField.getText());
                                     num = Math.atan(num);
                                     textField.setText("");
                                     textField.setText(String.valueOf(num));
                                 }
                             });
                             binButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     int num = Integer.parseInt(textField.getText());//BINARY
                                     textField.setText("");
                                     textField.setText(Integer.toString(num, 2));
                                 }
                             });
                             octalButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     int num = Integer.parseInt(textField.getText());//OCTAL
                                     textField.setText("");
                                     textField.setText(Integer.toString(num, 8));
                                 }
                             });
                             hexButton.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     int num = Integer.parseInt(textField.getText());//HEXADECIMAL
                                     textField.setText("");
                                     textField.setText(Integer.toString(num, 16));
                                 }
                             });
                         }
                     });



        mnUnitConversionItem = new JMenuItem("Unit Conversion");
        mnUnitConversionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("Unit Conversion");
                frame.setBounds(10, 10, 1200, 600);
                frame.setBackground(Color.BLACK);

                String units[] = {"Length", "Currency", "Area", "Weight", "Temperature", "Pressure", "Volume"};
                comboBox = new JComboBox(units);

                comboBox.setBounds(840, 160, 330, 60);
                frame.add(comboBox);
                comboBox.setVisible(true);
                comboBox.setFont(myFont);
                comboBox.setBackground(Color.BLACK);
                comboBox.setForeground(Color.WHITE);

                comboBox1 = new JComboBox();
                comboBox1.setBounds(840, 230, 160, 60);
                frame.add(comboBox1);
                comboBox1.setVisible(true);
                comboBox1.setFont(myFont);
                comboBox1.setBackground(Color.BLACK);
                comboBox1.setForeground(Color.WHITE);

                textField1 = new JTextField();
                textField1.setBounds(1010, 230, 160, 60);
                textField1.setFont(myFont);
                textField1.setEditable(false);
                textField1.setBackground(Color.BLACK);
                textField1.setForeground(Color.WHITE);
                frame.add(textField1);

                comboBox2 = new JComboBox();
                comboBox2.setBounds(840, 300, 160, 60);
                frame.add(comboBox2);
                comboBox2.setVisible(true);
                comboBox2.setFont(myFont);
                comboBox2.setBackground(Color.BLACK);
                comboBox2.setForeground(Color.WHITE);

                textField2 = new JTextField();
                textField2.setBounds(1010, 300, 160, 60);
                textField2.setFont(myFont);
                textField2.setEditable(false);
                textField2.setBackground(Color.BLACK);
                textField2.setForeground(Color.WHITE);
                frame.add(textField2);

                RestartButton = new JButton("Restart");
                ConvertButton = new JButton("Convert");

                functionButtons[0] = RestartButton;
                functionButtons[1] = ConvertButton;
                ConvertButton.setBounds(840, 370, 160, 60);
                RestartButton.setBounds(1010, 370, 160, 60);
                frame.add(ConvertButton);
                frame.add(RestartButton);

                for (int i = 0; i < 2; i++) {
                    functionButtons[i].addActionListener(this);
                    functionButtons[i].setFont(myFont);
                    functionButtons[i].setFocusable(false);
                }
                for (int i = 0; i < 2; i++) {
                    functionButtons[i].setBackground(Color.BLACK);
                    functionButtons[i].setForeground(Color.WHITE);
                }
            }
        });

        mnExitItem = new JMenuItem("Exit");
        mnExitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        menuMenu1 = new JMenu("Menu");
        menuBar.add(menuMenu1);
        mnHistoryItem = new JMenuItem("History");
        mnHistoryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("History");
                frame.setBounds(10, 10, 385, 600);


            }
        });

        menuMenu.add(mnStandardItem);
        menuMenu.add(mnScientificItem);
        menuMenu.add(mnUnitConversionItem);
        menuMenu.add(mnExitItem);
        menuMenu1.add(mnHistoryItem);

        mnStandardItem.setFocusable(false);
        mnScientificItem.setFocusable(false);
        mnUnitConversionItem.setFocusable(false);
        mnExitItem.setFocusable(false);


        panel = new JPanel();
        panel.setBounds(50, 160, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        textField = new JTextField();
        textField.setBounds(50, 30, 300, 60);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        frame.add(textField);

        tButton = new JToggleButton("On");
        frame.add(tButton);
        tButton.setBackground(Color.BLACK);
        tButton.setForeground(Color.WHITE);
        tButton.addActionListener(this);
        tButton.setFont(myFont);
        tButton.setFocusable(false);
        tButton.setBounds(50, 97, 100, 50);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        decButton = new JButton(".");
        clrButton = new JButton("Clear");
        percentButton = new JButton("%");
        leftBracketButton = new JButton("(");
        rightBracketButton = new JButton(")");
        negativeButton = new JButton("+-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = delButton;
        functionButtons[6] = decButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = percentButton;
        functionButtons[9] = leftBracketButton;
        functionButtons[10] = rightBracketButton;
        functionButtons[11] = negativeButton;

        for (int i = 0; i < 12; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(50, 475, 145, 50);
        clrButton.setBounds(205, 475, 145, 50);

        panel.add(percentButton);
        panel.add(leftBracketButton);
        panel.add(rightBracketButton);
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
        panel.add(negativeButton);
        panel.add(equButton);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(panel);
        frame.add(tButton);

        for (int i = 0; i < 10; i++) {
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setForeground(Color.WHITE);
        }

        for (int i = 0; i < 12; i++) {
            functionButtons[i].setBackground(Color.BLACK);
            functionButtons[i].setForeground(Color.WHITE);
        }
        equButton.setForeground(Color.BLUE);
    }

        @Override
        public void actionPerformed (ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == decButton) {
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if (e.getSource() == percentButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText("");
            }
            if (e.getSource() == powButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '^';
                textField.setText("");
            }

            if (e.getSource() == equButton) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '%':
                        result = (num1 * num2) / 100;
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }

            if (e.getSource() == clrButton) {
                textField.setText("");
            }
            if (e.getSource() == delButton) {
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textField.setText(textField.getText() + string.charAt(i));
                }

            }
            if (tButton.isSelected()) {
                tButton.setText("OFF");
                //tButton.setBackground(Color.BLACK);
                for (int i = 0; i < 12; i++) {
                    functionButtons[i].setEnabled(false);
                }
                for (int i = 0; i < 10; i++) {
                    numberButtons[i].setEnabled(false);
                }
                tButton.setBackground(Color.BLACK);
                tButton.setForeground(Color.WHITE);
            } else {
                tButton.setText("ON");
                for (int i = 0; i < 12; i++) {
                    functionButtons[i].setEnabled(true);
                }
                for (int i = 0; i < 10; i++) {
                    numberButtons[i].setEnabled(true);
                }
                tButton.setBackground(Color.BLACK);
                tButton.setForeground(Color.WHITE);
            }
        }
}

