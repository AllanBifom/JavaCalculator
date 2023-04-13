import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class Main extends JFrame implements ActionListener {
    private int operator = 0;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
    private final String[] calculatorSymbols = {
            "AC", "+/-", "%", "/","7","8","9","*","4","5","6","-","1","2","3","+","0",".","Adv","="
    };
    private final JPanel calculatorPanel = new JPanel(new BorderLayout(5, 5));
    private final JPanel buttonPanel = new JPanel(new GridLayout(5, 3,2,2));
    private final JButton[] buttons = new JButton[calculatorSymbols.length];
    private final JTextArea screen = new JTextArea(5,40);
    private double firstNumber = 0;
    private final JTextField calculatorTextField = new JTextField(40);

    public Main(){
        init();
    }
    private void init(){
        setTitle("Basic Calculator");
        screen.setFont(new Font("Arial",Font.BOLD, 20));
        screen.setBackground(Color.darkGray);
        calculatorPanel.setBackground(Color.darkGray);
        buttonPanel.setBackground(Color.darkGray);
        screen.setForeground(Color.WHITE);

        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(calculatorSymbols[i]);
            buttons[i].setOpaque(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        calculatorTextField.setBackground(Color.darkGray);
        calculatorTextField.setForeground(Color.WHITE);
        calculatorPanel.add(calculatorTextField, BorderLayout.SOUTH);
        calculatorPanel.add(buttonPanel,BorderLayout.CENTER);
        calculatorPanel.add(screen,BorderLayout.NORTH);
        add(calculatorPanel);
        setSize(new Dimension(340,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }




    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case ".":
                if(!screen.getText().contains("."))
                    screen.setText(screen.getText() + ".");
                break;
            case "0":
                screen.setText(screen.getText() + "0");
                break;
            case "1":
                screen.setText(screen.getText() + "1");
                break;
            case "2":
                screen.setText(screen.getText() + "2");
                break;
            case "3":
                screen.setText(screen.getText() + "3");
                break;
            case "4":
                screen.setText(screen.getText() + "4");
                break;
            case "5":
                screen.setText(screen.getText() + "5");
                break;
            case "6":
                screen.setText(screen.getText() + "6");
                break;
            case "7":
                screen.setText(screen.getText() + "7");
                break;
            case "8":
                screen.setText(screen.getText() + "8");
                break;
            case "9":
                screen.setText(screen.getText() + "9");
                break;
            case "+":
                if (!screen.getText().isEmpty()){
                    firstNumber = Double.parseDouble(screen.getText());
                    operator = 1;
                    screen.setText("");
                }
                break;
            case "-":
                if (!screen.getText().isEmpty()){
                    firstNumber = Double.parseDouble(screen.getText());
                    operator = 2;
                    screen.setText("");

                }
                break;
            case "*":
                if (!screen.getText().isEmpty()){
                    firstNumber = Double.parseDouble(screen.getText());
                    operator = 3;
                    screen.setText("");
                }
                break;
            case "/":
                if (!screen.getText().isEmpty()){
                    firstNumber = Double.parseDouble(screen.getText());
                    operator = 4;
                    screen.setText("");
                }
                break;
            case "+/-":
                double negativeNumber = Double.parseDouble(screen.getText());
                negativeNumber *= -1;
                screen.setText(String.valueOf(negativeNumber));
                break;
            case "AC":
                screen.setText("");
                break;
            case "%":
                double number = Double.parseDouble(screen.getText());
                screen.setText(String.valueOf(number/100));
                break;
            case "Adv":


            default:

        }
        if (command.equalsIgnoreCase("=")){
            if (!screen.getText().isEmpty()){
                double secondNumber = Double.parseDouble(screen.getText());

                switch (operator) {
                    case 1 -> { // +
                        screen.setText(String.valueOf(firstNumber + secondNumber));
                        calculatorTextField.setText(firstNumber + " + " + secondNumber + " = " + (decimalFormat.format(firstNumber + secondNumber)));
                    }
                    case 2 -> { // -
                        screen.setText(String.valueOf(firstNumber - secondNumber));
                        calculatorTextField.setText(firstNumber + " - " + secondNumber + " = " + (decimalFormat.format(firstNumber - secondNumber)));
                    }
                    case 3 -> { // *
                        screen.setText(String.valueOf(firstNumber * secondNumber));
                        calculatorTextField.setText(firstNumber + " * " + secondNumber + " = " + (decimalFormat.format(firstNumber * secondNumber)));
                    }
                    case 4 -> { // division
                        screen.setText(String.valueOf(firstNumber / secondNumber));
                        calculatorTextField.setText(firstNumber + " / " + secondNumber + " = " + (decimalFormat.format(firstNumber / secondNumber)));
                    }
                    default -> {
                    }
                }
            }
        }
    }
}