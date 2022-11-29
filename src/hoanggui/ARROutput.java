/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/* This class is used for displaying the results that are inserted by the Client 
at the ARR Input frame, and navigates the users to the database of it. Because 
it involves calculation, therefore, this class and its database will be updated 
later.
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


public class ARROutput extends JFrame implements ActionListener
{
    
    //formulating the Frame
    public final Color BACKGROUND_COLOR = new Color(252,236,190);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business introduction.jpg");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    
    //declaring variables
    private JLabel introductionLabel;
    private JButton backButton;
    
    
    public ARROutput(businessComputation newObject)
    {
        super("Average Rate of Return output");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
     
        introductionLabel = new JLabel ("Average Rate of Return is "+newObject.getARR() +"%");
        
        //define image label
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        //initialize introduction Panel to add introduction Labels together
        JPanel introductionPanel = new JPanel(new FlowLayout());
        introductionPanel.add(introductionLabel);
        introductionPanel.setBackground(new Color(252,236,190));
        
        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(imageLabel);
        
        //add Back buttons
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        
        this.add(backButton, BorderLayout.SOUTH);
        this.add(introductionPanel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        //the scenario in which the Client presses the Back button
        String command = e.getActionCommand();
        if (command.equals("Back"))
        {
            this.dispose();
        }
    }
}
