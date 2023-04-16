package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test implements ActionListener{
    
    Font f= new Font("Baskerville Old Face",Font.BOLD,24);
    Font f2= new Font("Baskerville Old Face",Font.PLAIN,20);
    Font f3= new Font("Baskerville Old Face",Font.ITALIC,18);

    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    JLabel text=new JLabel("Fitness-Tracker App");
    JLabel userLabel = new JLabel("User ID:");
    JTextField userText = new JTextField(20);
    JLabel ageLabel = new JLabel("Age:");
    JTextField ageText = new JTextField(20);
    JButton signupButton = new JButton("Sign Up");
    JButton cancelButton = new JButton("Cancel");
    JLabel message = new JLabel();
    JFrame startupFrame = new JFrame("Fitness App");
    JButton stepTrackerButton = new JButton("Step Tracker");
    JButton caloriesCalculatorButton = new JButton("Calories Calculator");
    JButton waterIntakeCheckerButton = new JButton("Water Intake Checker");
    JButton ExitButton = new JButton("Exit App");
    JButton submitButton=new JButton("Check");


    public Test(){  //for the login page
        
        //frame for the app
        frame.setSize(500,700);
        //title for app
        frame.setTitle("FitTrack 101");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //prevetns frame from being resized
        panel.setBackground(Color.cyan);
        frame.setVisible(true);
        panel.setLayout(null);

        text.setBounds(127,100,250,30);
        text.setFont(f);
        panel.add(text);
        
        userLabel.setBounds(80, 200, 80, 25);
        userLabel.setFont(f2);
        panel.add(userLabel);
        
        userText.setBounds(170, 200, 160, 25);
        panel.add(userText);
    
        ageLabel.setBounds(80, 300, 80, 25);
        ageLabel.setFont(f2);
        panel.add(ageLabel); 
        
        ageText.setBounds(170, 300, 160, 25);
        panel.add(ageText);
        
        signupButton.setBounds(180, 450, 110, 25);
        signupButton.setFont(f2);
        signupButton.addActionListener(this);
        panel.add(signupButton);
        
        cancelButton.setBounds(180, 500, 110, 25);
        cancelButton.setFont(f2);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);
        
        panel.add(message);
        frame.add(panel);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==signupButton){
            try{
                String user=userText.getText();
                int age=0;  //takes in the name and age of the user

                try{
                    age=Integer.parseInt(ageText.getText());
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //to show the menu page
                if (age<=15){
                    JOptionPane.showMessageDialog(frame, "Too young for a workout! Closing app now :)","Age too small!", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    return;
                }
                else if(age>15 && age<50){
                    JOptionPane.showMessageDialog(frame, "You fall in the adult zone!","Right age!", JOptionPane.INFORMATION_MESSAGE);
                    //return;
                }
                else if(age>50 &&age<80){
                    JOptionPane.showMessageDialog(frame, "You fall in the elder zone!","Right age!", JOptionPane.INFORMATION_MESSAGE);
                    //return;
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Too old for a workout! Closing app now :)","Age too high!", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    return;
                }
        
                panel.removeAll();

                JLabel welcome=new JLabel("Welcome, "+ user+"!");
                JLabel welcome2=new JLabel("What would you like to choose today?");
                welcome.setBounds(50,70,300,50);
                welcome.setFont(f3);
                panel.add(welcome);
                welcome2.setBounds(50,100,500,100);
                welcome2.setFont(f3);
                panel.add(welcome2);

                panel.setLayout(null);
                
                stepTrackerButton.setBounds(100, 200, 300, 40);
                stepTrackerButton.addActionListener(this);
                stepTrackerButton.setFont(f2);
                panel.add(stepTrackerButton);
                
                caloriesCalculatorButton.setBounds(100, 300, 300, 40);
                caloriesCalculatorButton.addActionListener(this);
                caloriesCalculatorButton.setFont(f2);
                panel.add(caloriesCalculatorButton);
                
                waterIntakeCheckerButton.setBounds(100, 400, 300, 40);
                waterIntakeCheckerButton.addActionListener(this);
                waterIntakeCheckerButton.setFont(f2);
                panel.add(waterIntakeCheckerButton);

                ExitButton.setBounds(100, 500, 300, 40);
                ExitButton.addActionListener(this);
                ExitButton.setFont(f2);
                panel.add(ExitButton);
                
                startupFrame.setSize(500, 700);
                startupFrame.setLayout(null);
                startupFrame.setVisible(true);
                startupFrame.add(panel);

            }
            catch (Exception ex){
                message.setText("An error occured.");
            } 

        }else if (e.getSource()==stepTrackerButton){
            //JOptionPane.showMessageDialog(frame, "Step Tracker!", "TrackSteps", JOptionPane.INFORMATION_MESSAGE);
            panel.removeAll();
            panel.setLayout(null);
            int goal, current;
            JFrame stepsFrame=new JFrame();

            JTextField goalTextField=new JTextField();
            JTextField currentTextField=new JTextField();
            
            JLabel goalSteps=new JLabel("Set your goal:");
            JLabel currentSteps=new JLabel("Covered steps:");

            goalSteps.setBounds(50,130,100,50);
            goalTextField.setBounds(200,130,100,50);
            panel.add(goalSteps);
            panel.add(goalTextField);

            currentSteps.setBounds(50,200,100,50);
            currentTextField.setBounds(200,200,100,50);
            panel.add(currentSteps);
            panel.add(currentTextField);
            
            JLabel welcomeSteps=new JLabel("Here's your Step Tracker!");
            welcomeSteps.setBounds(50,50,300,50);
            welcomeSteps.setFont(f3);
            panel.add(welcomeSteps);


            
            submitButton.setBounds(180,300,100,50);
            panel.add(submitButton);

            stepsFrame.setSize(500, 700);
            stepsFrame.setLayout(null);
            stepsFrame.setVisible(true);
            stepsFrame.add(panel);

            
            if (e.getSource()==submitButton){
                try {
                    goal = Integer.parseInt(goalTextField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid goal value.","Result",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                try {
                    current = Integer.parseInt(currentTextField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid current value.","Result",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
    
                // Check if the current value has reached the goal value
                if (current >= goal) {
                    JOptionPane.showMessageDialog(frame, "Goal reached!","Result",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Walk a little more!","Result",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        else if(e.getSource()==caloriesCalculatorButton){
            JOptionPane.showMessageDialog(frame, "Calories Calculator!", "CalculateCal", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource()==waterIntakeCheckerButton){
            JOptionPane.showMessageDialog(frame, "Water Intake Checker!!", "WaterIntake", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource()==ExitButton){
            JOptionPane.showMessageDialog(frame, "Done for today?", "Leaving?", JOptionPane.YES_OPTION);
            //exit somehow
        }
        else{
            frame.dispose();
        }
    }

    public static void main(String[] args){
        new Test();
    }
}