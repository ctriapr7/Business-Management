/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

/* this class is used for inserting data that is related to Fixed Assets, 
storing it into a separate database in order to collect data for Balance Sheet calculation.
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class FixedAssetsInput extends JFrame implements ActionListener
{
    businessComputation newObject = new businessComputation();
    DbFunction myObj = new DbFunction();
     
       
    //formulating the Frame
    public final Color BACKGROUND_COLOR = new Color(254,254,193);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business image.png");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    
    //declaring variables
    private JRadioButton propertyButton;
    private JRadioButton machineryButton;
    private JRadioButton equipmentButton;
    ButtonGroup fixedAssetsButtonGroup;
    private JLabel valueLabel;
    private JTextField valueTextField;
    private JButton storeButton;
    private JButton showBalanceSheetButton;
    private JButton backButton;
    private JButton fixedAssetsButton;
    private JButton exitButton;
    private JPanel insertPanel;
    private JPanel buttonPanel;
    private JPanel storePanel;
    private JLabel imageLabel;
    private JScrollPane myScrollPanel = new JScrollPane();
    JTable FixedAssetsTable = new JTable();
    
    public FixedAssetsInput()
    {
        super("Fixed Assets input");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //create radio button that only allows the Client to choose one
        propertyButton = new JRadioButton("Property");
        machineryButton = new JRadioButton("Machinery");
        equipmentButton = new JRadioButton("Equipment");
        
        //create Store button 
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        
        //add radio buttons together
        fixedAssetsButtonGroup = new ButtonGroup();
        fixedAssetsButtonGroup.add(propertyButton);
        fixedAssetsButtonGroup.add(machineryButton);
        fixedAssetsButtonGroup.add(equipmentButton);
        
        //add buttons 
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(propertyButton);
        buttonPanel.add(machineryButton);
        buttonPanel.add(equipmentButton);
        buttonPanel.setBackground(new Color(235,208,208));
        
        //add image 
        imageLabel = new JLabel(MY_IMAGE);
        
        valueLabel = new JLabel("Value");
        valueTextField = new JTextField(20);
        
        //additional buttons
        insertPanel = new JPanel(new FlowLayout());
        insertPanel.add(valueLabel);
        insertPanel.add(valueTextField);
        insertPanel.add(imageLabel);
        insertPanel.setBackground(new Color(235,208,208));
        
        //initialize additional buttons
        showBalanceSheetButton = new JButton("Show balance sheet");
        showBalanceSheetButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        storeButton = new JButton("Store");
        storeButton.addActionListener(this);
        fixedAssetsButton = new JButton("Show Fixed Assets");
        fixedAssetsButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        //initialize Panel that contains additional buttons
        storePanel = new JPanel(new FlowLayout());
        storePanel.add(backButton);
        storePanel.add(storeButton);
        storePanel.add(showBalanceSheetButton);
        storePanel.add(fixedAssetsButton);
        storePanel.add(exitButton);

        
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(insertPanel, BorderLayout.CENTER);
        this.add(storePanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
         String[] columnNames={"fixedAssetsValue","typeOfFixedAssets"};
          String command = e.getActionCommand();
      if (command.equals("Store"))
      {
        try
            {
                double fixedAssetsValue = Double.parseDouble(valueTextField.getText());
                newObject.setFixedAssets(fixedAssetsValue);
  
                
                if (propertyButton.isSelected())
                {
                    newObject.setFixedAssetsString(newObject.getPropertyString());
                    myObj.insertFixedAssets(newObject.getFixedAssets(), newObject.getFixedAssetsString());
                 newObject.calculateTotalFixedAssets();
                FixedAssetsOutput fixedAssetsOutputObject = new FixedAssetsOutput(newObject);
                }
                else if (machineryButton.isSelected())
                {
                    newObject.setFixedAssetsString(newObject.getMachineryString());
                    myObj.insertFixedAssets(newObject.getFixedAssets(), newObject.getFixedAssetsString());
                 newObject.calculateTotalFixedAssets();
                FixedAssetsOutput fixedAssetsOutputObject = new FixedAssetsOutput(newObject);
                }
                else if (equipmentButton.isSelected())
                {
                    newObject.setFixedAssetsString(newObject.getEquipmentString());
                    myObj.insertFixedAssets(newObject.getFixedAssets(), newObject.getFixedAssetsString());
                 newObject.calculateTotalFixedAssets();
                FixedAssetsOutput fixedAssetsOutputObject = new FixedAssetsOutput(newObject);
                }
                else
                {
                    errorFrame error = new errorFrame("Please select a type of Fixed Assets!");
                }
            }   
            catch (NumberFormatException nfe)
            {
                errorFrame err= new errorFrame("Please enter a number!");
            }
            catch (Exception exceptionObj)
            {
                errorFrame err= new errorFrame("You did something wrong");
            }
        }
        //if the Client presses Back button
        else if (command.equals("Back"))
        {
            this.dispose();
        }
        //if the Client presses Show balance sheet button
        else if (command.equals("Show balance sheet"))
        {
           Double equity;
            newObject.calculateTotalFixedAssets();
            newObject.calculateTotalCurrentAssets();
            newObject.calculateTotalShortTermLiabilities();
            newObject.calculateTotalLongTermLiabilities();
            
            Double totalFixedAssets;
            totalFixedAssets = newObject.getTotalFixedAssets();
            Double totalCurrentAssets;
            totalCurrentAssets = newObject.getTotalCurrentAssets();
            Double totalShortTermLiabilities;
            totalShortTermLiabilities = newObject.getShortTermLiabilities();
            Double totalLongTermLiabilities;
            totalLongTermLiabilities = newObject.getTotalLongTermLiabilities();
            
            
            newObject.calculateEquity(totalFixedAssets, totalCurrentAssets, newObject.getTotalShortTermLiabilities(), totalLongTermLiabilities);
            equity = newObject.getEquity();
            
            myObj.insertBalanceSheet(totalFixedAssets, totalCurrentAssets, newObject.getTotalShortTermLiabilities(), totalLongTermLiabilities, equity);
            balanceSheetTableFrame tableObject = new balanceSheetTableFrame();
        }
        else if(command.equals("Show Fixed Assets"))
        {
            DbFunction obj1 = new DbFunction();
            fixedAssetsTableFrame newTable = new fixedAssetsTableFrame();
        }
        else if (command.equals("Exit"))
        {
            System.exit(0);
        }
      
      
    }
    
    //main method
    public static void main(String[] args)
    {
        FixedAssetsInput fixedAssetsObject = new FixedAssetsInput();
    }    
}
