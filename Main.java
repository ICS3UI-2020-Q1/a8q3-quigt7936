/* 
 * This program converts celcius to fahrenheit and vice versa
 * @Author Thomas Quigley
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel faLabel;
  JLabel ceLabel;

  JTextField faInputOutput;
  JTextField ceInputOutput;

  JButton faConvertButton;
  JButton ceConvertButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Temperature Converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(600,200);
    // shows the window
    frame.setVisible(true);

    // make the main panel and add it to the frame
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    // make the two labels and add them to the main panel
    faLabel = new JLabel("Degrees Fahrenheit");
    ceLabel = new JLabel("Degrees Celsuis");

    faLabel.setBounds(70, 40, 200, 30);
    ceLabel.setBounds(70, 100, 200, 30);

    mainPanel.add(faLabel);
    mainPanel.add(ceLabel);

    // make the two text fields and add them to the main panel
    faInputOutput = new JTextField();
    ceInputOutput = new JTextField();

    faInputOutput.setBounds(290, 40, 100, 30);
    ceInputOutput.setBounds(290, 100,100, 30);

    mainPanel.add(faInputOutput);
    mainPanel.add(ceInputOutput);

    // make the two buttons and add them to the main panel
    faConvertButton = new JButton("F -> C");
    ceConvertButton = new JButton("C -> F");

    faConvertButton.setBounds(440, 40, 100, 30);
    ceConvertButton.setBounds(440, 100, 100, 30);

    faConvertButton.addActionListener(this);
    ceConvertButton.addActionListener(this);

    faConvertButton.setActionCommand("fa");
    ceConvertButton.setActionCommand("ce");

    mainPanel.add(faConvertButton);
    mainPanel.add(ceConvertButton);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    // find out what button was pressed
    if (command.equals("fa")) {
      // we are converting f to c
      // take the degrees in f and convert it into C
      String input = faInputOutput.getText();
      int numberConverting = Integer.parseInt(input);
      int conversion = (numberConverting - 32) * 5/9;
      // output the degrees in C
      ceInputOutput.setText("" + conversion);
   
    } else if(command.equals("ce")) {
      // we are converting c to f
      // take the degrees in c and convert it into f
      String input = ceInputOutput.getText();
      int numberConverting = Integer.parseInt(input);
      int conversion = numberConverting * 9/5 + 32;
      // output the degrees in f
      faInputOutput.setText("" + conversion);
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
