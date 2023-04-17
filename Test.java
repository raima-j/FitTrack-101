package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FitnessApp implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenuItem stepTrackerItem, waterIntakeItem;
    private JButton backButton, checkButton, wcheckButton;
    private JLabel textStep,textWater;
    private JLabel welcomeLabel, goalLabel, currentLabel, resultLabel,textLabel1,textLabel2;
    private JTextField goalTextField, currentTextField;
    private JLabel watergoalLabel, watercurrentLabel, wresultLabel;
    private JTextField watergoalTextField, watercurrentTextField;
    JButton ExitButton = new JButton("Exit App");

    Font f= new Font("Baskerville Old Face",Font.BOLD,24);
    Font f2= new Font("Baskerville Old Face",Font.PLAIN,20);
    Font f3= new Font("Baskerville Old Face",Font.ITALIC,18);


    public FitnessApp() {
        frame = new JFrame("FitTrack 101");
        panel = new JPanel();
        Color color = new Color(88, 134, 209);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //prevents frame from being resized
        panel.setBackground(color);
        
        menuBar = new JMenuBar();
        stepTrackerItem = new JMenuItem("Step Tracker");
        waterIntakeItem = new JMenuItem("Water Intake");
        textStep=new JLabel("Check your steps!");
        textWater=new JLabel("Check your H2O!");

        textStep.setBounds(145,30,300,30);
        textWater.setBounds(145,30,300,30);
        textWater.setFont(f);
        textStep.setFont(f);

        backButton = new JButton("Back");
        checkButton = new JButton("Check");
        wcheckButton = new JButton("Check");
        ExitButton.setBounds(145, 500, 200, 30);
        ExitButton.addActionListener(this);
        ExitButton.setFont(f2);
        panel.add(ExitButton);


        welcomeLabel = new JLabel("Welcome!");
        textLabel1=new JLabel("To check your fitness for today,");
        textLabel2=new JLabel("choose an option from the Menu Bar ^_^");

        goalLabel = new JLabel("Enter your goal steps:");
        currentLabel = new JLabel("Enter your current steps:");
        resultLabel = new JLabel();
        resultLabel = new JLabel();


        goalTextField = new JTextField();
        currentTextField = new JTextField();

        watergoalLabel = new JLabel("Goal number of glasses:");
        watercurrentLabel = new JLabel("Consumed amount of glasses:");
        wresultLabel = new JLabel();

        watergoalTextField = new JTextField();
        watercurrentTextField = new JTextField();

        //adding to the bar
        menuBar.add(stepTrackerItem);
        menuBar.add(waterIntakeItem);

        backButton.addActionListener(this);
        stepTrackerItem.addActionListener(this);
        waterIntakeItem.addActionListener(this);
        checkButton.addActionListener(this);
        wcheckButton.addActionListener(this);

        panel.add(textLabel1);
        panel.add(textLabel2);
        textLabel1.setFont(f3);
        textLabel2.setFont(f3);

        panel.setLayout(null);
        welcomeLabel.setBounds(180, 100, 200, 50);
        textLabel1.setBounds(115,180,300,60);
        textLabel2.setBounds(90,250,330,60);
        welcomeLabel.setFont(f);
        goalLabel.setFont(f3);
        currentLabel.setFont(f3);
        resultLabel.setFont(f2);
        watergoalLabel.setFont(f3);
        watercurrentLabel.setFont(f3);
        wresultLabel.setFont(f2);

        backButton.setBounds(185, 500, 100, 40);
        backButton.setFont(f3);
            
        //adding items to panel
        panel.add(welcomeLabel);

        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try{ //handling exceptions
        if (e.getSource() == backButton) {

            panel.removeAll();
            panel.repaint();
            welcomeLabel.setText("Welcome.");
            panel.add(welcomeLabel);
            welcomeLabel.setFont(f);
            panel.add(textLabel1);
            panel.add(ExitButton);
            panel.add(textLabel2);
            textLabel1.setFont(f3);
            textLabel2.setFont(f3);

            panel.setLayout(null);
            welcomeLabel.setBounds(180, 100, 200, 50);
            textLabel1.setBounds(115,180,300,60);
            textLabel2.setBounds(90,250,330,60);
                
            frame.setContentPane(panel);
            frame.revalidate();
            frame.repaint();
        } else if (e.getSource() == stepTrackerItem) {

            panel.removeAll();
            panel.repaint();
            panel.add(textStep);
            goalTextField.setText("");
            currentTextField.setText("");

            goalLabel.setBounds(50, 150, 200, 50);
            panel.add(goalLabel);

            goalTextField.setBounds(300, 150, 100, 50);
            panel.add(goalTextField);

            currentLabel.setBounds(50, 250, 200, 50);
            panel.add(currentLabel);

            currentTextField.setBounds(300, 250, 100, 50);
            panel.add(currentTextField);

            checkButton.setBounds(185, 365, 100, 50);
            panel.add(checkButton);
            panel.add(backButton);

            frame.setContentPane(panel);
            frame.revalidate();
            frame.repaint();

        } else if (e.getSource() == checkButton) {
            int goal,current;
            try{
                goal = Integer.parseInt(goalTextField.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                current = Integer.parseInt(currentTextField.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            String result;

            if (current >= goal) {
                result = "Goal reached!";
            } else {
                result = "Walk a little more!";
            }

            resultLabel.setText(result);
            resultLabel.setBounds(170, 420, 150, 50);
            panel.add(resultLabel);
            panel.add(backButton);

            frame.setContentPane(panel);
            frame.revalidate();
            frame.repaint();

        } else if(e.getSource() == waterIntakeItem) {
            
            panel.removeAll();
            panel.repaint();
            panel.add(textWater);

            watergoalTextField.setText("");
            watercurrentTextField.setText("");

            watergoalLabel.setBounds(50, 150, 300, 50);
            panel.add(watergoalLabel);

            watergoalTextField.setBounds(300, 150, 100, 50);
            panel.add(watergoalTextField);

            watercurrentLabel.setBounds(50, 250, 300, 50);
            panel.add(watercurrentLabel);

            watercurrentTextField.setBounds(300, 250, 100, 50);
            panel.add(watercurrentTextField);

            wcheckButton.setBounds(185, 365, 100, 50);
            panel.add(wcheckButton);
            panel.add(backButton);

        }else if (e.getSource() == wcheckButton) {
            int wgoal,wcurrent;
            try{
            wgoal = Integer.parseInt(watergoalTextField.getText());
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
            wcurrent = Integer.parseInt(watercurrentTextField.getText());
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String result;

            if (wcurrent >= wgoal) {
                result = "Goal reached!";
            } else {
                result = "Drink a little more!";
            }

            wresultLabel.setText(result);
            wresultLabel.setBounds(170, 420, 150, 50);
            panel.add(wresultLabel);
            panel.add(backButton);

            frame.setContentPane(panel);
            frame.revalidate();
            frame.repaint();

        } else if(e.getSource()==ExitButton){
            int confirmed = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
            frame.dispose();
            }
        }
        else{
            frame.dispose();
        }
    }catch (Exception ex){
            JOptionPane.showMessageDialog(frame,"An error occured.","Error",JOptionPane.INFORMATION_MESSAGE);
        }
}

    public static void main(String[] args) {
        new FitnessApp();
   
    }
}

