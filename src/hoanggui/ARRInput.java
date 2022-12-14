/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;


/* This class is used for inserting data for calculating Average Rate of Return, 
displaying the result with matching colors and navigating the Client to the databases 
that associated with Average Rate of Return
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ARRInput extends JFrame implements ActionListener
{
    businessComputation newObject = new businessComputation();
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("Business image 2.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JLabel totalReturnsLabel;
    private JTextField totalReturnsTextField;
    private JLabel capitalCostLabel;
    private JTextField capitalCostTextField;
    private JLabel yearsOfUseLabel;
    private JTextField yearsOfUseTextField;
    private JButton calculateButton;
    private JButton showBalanceSheetButton;
    private JButton backButton;
    private JPanel insertPanel;
    private JPanel buttonPanel;
    private JPanel storePanel;
    private JLabel imageLabel;
    
    public ARRInput()
    {
        super("Short Term Liabilities input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //add Labels and Text Fields for data inserting
        totalReturnsLabel = new JLabel("Total Returns");
        totalReturnsTextField = new JTextField(12);
        capitalCostLabel = new JLabel("Capital Cost");
        capitalCostTextField = new JTextField(12);
        yearsOfUseLabel = new JLabel("Years Of Use");
        yearsOfUseTextField = new JTextField(12);
        
        //add image
        imageLabel = new JLabel(MY_IMAGE);
        
        //add Labels and Text Fields to Panel
        insertPanel = new JPanel(new FlowLayout());
        insertPanel.add(totalReturnsLabel);
        insertPanel.add(totalReturnsTextField);
        insertPanel.add(capitalCostLabel);
        insertPanel.add(capitalCostTextField);
        insertPanel.add(yearsOfUseLabel);
        insertPanel.add(yearsOfUseTextField);
        insertPanel.add(imageLabel);
        insertPanel.setBackground(new Color(253,170,179));
        
        //define Buttons
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        showBalanceSheetButton = new JButton("Show balance sheet");
        showBalanceSheetButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        
        
        storePanel = new JPanel(new FlowLayout());
        storePanel.add(backButton);
        storePanel.add(calculateButton);
        storePanel.add(showBalanceSheetButton);
        
        
        this.add(insertPanel, BorderLayout.CENTER);
        this.add(storePanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //implements Action Listener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        double totalReturns;
        double capitalCosts;
        double yearsOfUse;
        
        String command = e.getActionCommand();
        //the scenario in which the Client presses the Back button
        if (command.equals("Calculate"))
        {
            totalReturns = Double.parseDouble(totalReturnsTextField.getText());
            capitalCosts = Double.parseDouble(capitalCostTextField.getText());
            yearsOfUse = Double.parseDouble(yearsOfUseTextField.getText());
            if (totalReturns < capitalCosts)
            {
                errorFrame error = new errorFrame("Total Return should be bigger than Capital Costs");
            }
            else if (totalReturns == capitalCosts)
            {
                errorFrame error = new errorFrame("Total Return should be bigger than Capital Costs");
            }
            else if (totalReturns > capitalCosts)
            {
                newObject.calculateARR(totalReturns, capitalCosts, yearsOfUse);
                newObject.getARR();
                ARROutput ARRObject = new ARROutput(newObject);
            }
        }
        //the scenario in which the Client presses the Back button
        else if (command.equals("Back"))
        {
            this.dispose();
        }
        //the scenario in which the Client presses the Back button
        else if (command.equals("Show balance sheet"))
        {
            System.out.println("Button to show balance sheet");
        }
      
    }
    
    //main method
    public static void main(String[] args)
    {
        ARRInput ARRObject = new ARRInput();
    }    
}
