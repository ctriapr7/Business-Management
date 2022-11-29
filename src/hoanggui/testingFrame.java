/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/* this Class is used for navigating the Client to the classes where she wants to test her decision 
in the future based on the data she inserts
*/
public class testingFrame extends JFrame implements ActionListener
{
    businessComputation computationObject = new businessComputation();
    DbFunction dbObject = new DbFunction();
    //formulating the Frame
    public final Color BACKGROUND_COLOR = new Color(254,253,90);
    public final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 30);
    private final java.net.URL CONG_IMAGE = getClass().getResource("business testing.jpg");
    private final ImageIcon MY_IMAGE = new ImageIcon(new ImageIcon(CONG_IMAGE).getImage().getScaledInstance(
        690,335,Image.SCALE_DEFAULT));
    
    //declaring variables
    private JPanel firstButtonPanel;
    private JButton currentRatioButton;
    private JButton arrButton;
    private JButton exitButton;
    private JPanel secondButtonPanel;
    private JButton backButton;
    private JButton showBalanceSheetButton;
    private JMenu mainMenu;
    private JMenuBar mainBar;
    private JMenuItem helpItem1;
    private JMenuItem helpItem2;
    private JLabel imageLabel;
    
    public testingFrame()
    {
        super("Testing");
        this.setBounds(100,50,900,750);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //adding buttons
        currentRatioButton = new JButton("Current Ratio");
        currentRatioButton.addActionListener(this);
        arrButton = new JButton("Average Rate of Return");
        arrButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
       
        //add image to the Frame 
        JLabel imageLabel = new JLabel(MY_IMAGE);
        
        firstButtonPanel = new JPanel(new FlowLayout());
        firstButtonPanel.add(currentRatioButton);
        firstButtonPanel.add(arrButton);
        firstButtonPanel.add(imageLabel);
        firstButtonPanel.setBackground(new Color(73,179,156));
        
        //additional buttons
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        showBalanceSheetButton = new JButton("Show Balance Sheet");
        showBalanceSheetButton.addActionListener(this);
        
        secondButtonPanel = new JPanel(new FlowLayout());
        secondButtonPanel.add(backButton);
        secondButtonPanel.add(showBalanceSheetButton);

         //JMenu
        mainBar = new JMenuBar();
        mainMenu = new JMenu("Help");
        helpItem1 = new JMenuItem("Questions and Answers");
        helpItem1.addActionListener(this);
        helpItem2 = new JMenuItem("About this program");
        helpItem2.addActionListener(this);
        mainMenu.add(helpItem1);
        mainMenu.add(helpItem2);
        mainBar.add(mainMenu);
        this.setJMenuBar(mainBar);
        
        this.add(firstButtonPanel, BorderLayout.CENTER);
        this.add(secondButtonPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //if the Client presses Back button
        if (command.equals("Back"))
        {
            this.dispose();
        }
        //if the Client presses Average Rate of Return button
        else if (command.equals("Average Rate of Return"))
        {
            ARRInput ARRObject = new ARRInput();
        }
        //if the Client presses Current Ratio button
        else if (command.equals("Current Ratio"))
        {
            CurrentRatioInput CurrentRatioObject = new CurrentRatioInput();
        }
        else if (command.equals("Show Balance Sheet"))
        {
            Double equity;
            computationObject.calculateTotalFixedAssets();
            computationObject.calculateTotalCurrentAssets();
            computationObject.calculateTotalShortTermLiabilities();
            computationObject.calculateTotalLongTermLiabilities();
            
            Double totalFixedAssets;
            totalFixedAssets = computationObject.getTotalFixedAssets();
            Double totalCurrentAssets;
            totalCurrentAssets = computationObject.getTotalCurrentAssets();
            Double totalShortTermLiabilities;
            totalShortTermLiabilities = computationObject.getShortTermLiabilities();
            Double totalLongTermLiabilities;
            totalLongTermLiabilities = computationObject.getTotalLongTermLiabilities();
            
            
            computationObject.calculateEquity(totalFixedAssets, totalCurrentAssets, computationObject.getTotalShortTermLiabilities(), totalLongTermLiabilities);
            equity = computationObject.getEquity();
            
            dbObject.insertBalanceSheet(totalFixedAssets, totalCurrentAssets, computationObject.getTotalShortTermLiabilities(), totalLongTermLiabilities, equity);
            balanceSheetTableFrame tableObject = new balanceSheetTableFrame();
        }
        else if (command.equals("Exit"))
        {
            System.exit(0);
        }
        
      
    }
    
    //main method
    public static void main(String[] args)
    {
        testingFrame testingFrameObject = new testingFrame();
    }    
}
