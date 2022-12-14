/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;
/* this class is used for displaying Current Ratio result based on data retrieved from
Current Assets database and Short Term Liabilities database.
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;



public class CurrentRatioInput extends JFrame implements ActionListener
{
    businessComputation newObject = new businessComputation();
    DbFunction myObj = new DbFunction();
  //formulate the frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("Business image 2.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JLabel introductionLabel;
    private JLabel introductionLabel1;
    private JButton backButton;
    private JPanel introductionPanel;
    private JPanel imagePanel;
    private double currentAssets;
    private double shortTermLiabilities;
    private double currentRatio;
    private JButton exitButton;
    private JPanel buttonPanel;
    
    public CurrentRatioInput()
    {
        super("Current Ratio input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        try{
        newObject.calculateTotalCurrentAssets();
        newObject.calculateTotalShortTermLiabilities();
        currentAssets = newObject.getTotalCurrentAssets();
        shortTermLiabilities = newObject.getTotalShortTermLiabilities();
        newObject.calculateCurrentRatio(currentAssets,shortTermLiabilities);
        currentRatio = newObject.getCurrentRatio();
        }
        catch (ArithmeticException ae)
        {
            errorFrame error = new errorFrame("Short Term Liabilities can't be 0");
        }
        
        //initialize introduction text
       
            introductionLabel = new JLabel("Your current ratio is "+currentRatio + ".");
            if (currentRatio>1)
            {
                introductionLabel.setForeground(Color.GREEN);
                introductionLabel1 = new JLabel(" Your business is doing good! Congratulations");
                introductionLabel1.setForeground(Color.GREEN);
            }
            else if (currentRatio<1)
            {
                introductionLabel.setForeground(Color.RED);
                introductionLabel1 = new JLabel(" You should try to pay back your loans ASAP!");
                introductionLabel1.setForeground(Color.RED);
            }
        
        //add image 
        JLabel imageLabel = new JLabel(MY_IMAGE);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
      
       //initialize introduction panel to add image and label to it
       introductionPanel = new JPanel(new FlowLayout());
       introductionPanel.add(introductionLabel);
       introductionPanel.add(introductionLabel1);
       //introductionPanel.add(imageLabel);
       introductionPanel.setBackground(new Color(253,170,179));
       
       exitButton = new JButton("Exit");
       exitButton.addActionListener(this);
       
       buttonPanel = new JPanel(new FlowLayout());
       buttonPanel.add(backButton);
       buttonPanel.add(exitButton);
       
       imagePanel = new JPanel(new FlowLayout());
       imagePanel.add(imageLabel);
       //introductionPanel.add(imageLabel);
       imagePanel.setBackground(new Color(253,170,179));
        
        //add button and its function
       
        this.add(introductionPanel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    
    //implements actionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        //if the Client presses Back button
        String command = e.getActionCommand();
        if (command.equals("Back"))
        {
            this.dispose();
        }
        else if (command.equals("Exit"))
        {
            System.exit(0);
        }
      
    }
    
    //main method
    public static void main(String[] args)
    {
        CurrentRatioInput CurrentRatioObject = new CurrentRatioInput();
    }    
}

