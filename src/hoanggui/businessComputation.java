/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoanggui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;

/* This class is used for executing setter and getter methods, and calculations
for Testing classes.
*/
public class businessComputation 
{
    DbFunction myObj = new DbFunction();
    //declaring variables
    private double fixedAssets;
    private String propertyString = "Property";
    private String machineryString = "Machinery";
    private String equipmentString = "Equipment";
    private String fixedAssetsString;
    private double currentAssets;
    private String cashString = "Cash";
    private String debtorString = "Debtor";
    private String stockString = "Stock";
    private String currentAssetsString;
    private double shortTermLiabilities;
    private String shortTermLoansString = "Short Term Loans";
    private String dividendsString = "Dividends";
    private String taxString = "Tax";
    private String tradeCreditorsString = "Trade Creditors";
    private String shortTermLiabilitiesString;
    private double longTermLiabilities;
    private String mortgageString = "Mortgage";
    private String debenturesString = "Debentures";
    private String bankLoansString = "Bank Loans";
    private String longTermLiabilitiesString;
    /*private ArrayList<Double> fixedAssetsList = new ArrayList<>();
    private ArrayList<Double> currentAssetsList = new ArrayList<>();
    private ArrayList<Double> shortTermLiabilitiesList = new ArrayList<>();
    private ArrayList<Double> longTermLiabilitiesList = new ArrayList<>();
    private ArrayList<Double> stocksList = new ArrayList<>();*/
    public double stocks;
    public double equity;
    public double currentRatio;
    public double acidTestRatio;
    public double totalStocks;
    public double totalFixedAssets;
    public double totalCurrentAssets;
    public double totalShortTermLiabilities;
    public double totalLongTermLiabilities;
    public double ARR;
    //JTable fixedAssetsTable= new JTable();
    //JTable CurrentAssetsTable = new JTable();
    //JTable ShortTermLiabilitiesTable = new JTable();
    //JTable LongTermLiabilities = new JTable();
    private Connection dbConn;
    
    //setters and getter method for Fixed Assets class
    public void setFixedAssets(double fixedAssets)
    {
        this.fixedAssets = fixedAssets;
    }
    
    public String getPropertyString()
    {
        return propertyString;
    }
    
    public String getMachineryString()
    {
        return machineryString;
    }
    
    public String getEquipmentString()
    {
        return equipmentString;
    }
    
    public void setFixedAssetsString(String fixedAssetsString)
    {
        this.fixedAssetsString = fixedAssetsString;
    }
    
    public String getFixedAssetsString()
    {
        return fixedAssetsString;
    }
    
    public double getFixedAssets()
    {
        return fixedAssets;
    }
    
    
    //setters and getter method for Current Assets class
    public void setCurrentAssets(double currentAssets)
    {
        this.currentAssets = currentAssets;
    }
   
    public String getCashString()
    {
        return cashString;
    }
    
    public String getDebtorString()
    {
        return debtorString;
    }
    
    public String getStockString()
    {
        return stockString;
    }
    
    public void setCurrentAssetsString(String currentAssetsString)
    {
        this.currentAssetsString = currentAssetsString;
    }
    
    public String getCurrentAssetsString()
    {
        return currentAssetsString;
    }
    
    public double getCurrentAssets()
    {
        return currentAssets;
    }
    
    //setters and getter method for Short Term Liabilities
     public void setShortTermLiabilities(double shortTermLiabilities)
    {
        this.shortTermLiabilities = shortTermLiabilities;
    }
   
    public String getShortTermLoansString()
    {
        return shortTermLoansString;
    }
    
    public String getTradeCreditorsString()
    {
        return tradeCreditorsString;
    }
    
    public String getTaxString()
    {
        return taxString;
    }
    
    public String getDividendsString()
    {
        return dividendsString;
    }
    public void setShortTermLiabilitiesString(String shortTermLiabilitiesString)
    {
        this.shortTermLiabilitiesString = shortTermLiabilitiesString;
    }
    
    public String getShortTermLiabilitiesString()
    {
        return shortTermLiabilitiesString;
    }
    
    public double getShortTermLiabilities()
    {
        return shortTermLiabilities;
    }
    
    //setters and getter method for long term liabilities
    public void setLongTermLiabilities(double longTermLiabilities)
    {
        this.longTermLiabilities = longTermLiabilities;
    }
   
    public String getBankLoansString()
    {
        return bankLoansString;
    }
    
    public String getDebenturesString()
    {
        return debenturesString;
    }
    
    public String getMortgageString()
    {
        return mortgageString;
    }
    

    public void setLongTermLiabilitiesString(String longTermLiabilitiesString)
    {
        this.longTermLiabilitiesString = longTermLiabilitiesString;
    }
    
    public String getLongTermLiabilitiesString()
    {
        return longTermLiabilitiesString;
    }
    
    public double getLongTermLiabilities()
    {
        return longTermLiabilities;
    }
    
    
    //Setters and getters for stocks 
    public void setTotalStocks(double stocks)
    {
        this.totalStocks= stocks;
    }
    
    public double getTotalStocks()
    {
        return totalStocks;
    }
    
    public void setEquity(double equity)
    {
        this.equity = equity;
    }
            
    public void calculateEquity(double fixedAssets, double currentAssets, double shortTermLiabilities, double longTermLiabilities)
    {
        double result = fixedAssets + currentAssets - ( shortTermLiabilities + longTermLiabilities );
        setEquity(result);
    }
                
    public double getEquity()
    {
        return equity;
    }
    
    public void setARR(double ARR)
    {
        this.ARR = ARR;
    }
    
    public void calculateARR(double totalReturns, double  capitalCost, double yearsOfUse)
    {
        double result = ((totalReturns-capitalCost)/(yearsOfUse*capitalCost))*100;
        setARR(result);
    }
    
    public double getARR()
    {
        return ARR;
    }

    //calculate and return Acid Test Ratio
    public void setCurrentRatio(double currentRatio)
    {
        this.currentRatio = currentRatio;
    }
    
    public void calculateCurrentRatio(double currentAssets, double shortTermLiabilities)
    {
        currentRatio = currentAssets/shortTermLiabilities;
        setCurrentRatio(currentRatio);
    }
    
    public double getCurrentRatio()
    {
        return currentRatio;
    }
    
    public void setAcidTestRatio(double acidTestRatio)
    {
        this.acidTestRatio = acidTestRatio;
    }
    
    public void calculateAcidTestRatio(double currentAssets, double stocks, double shortTermLiabilities)
    {
        acidTestRatio = (currentAssets - stocks)/shortTermLiabilities;
        setAcidTestRatio(acidTestRatio);
    }
    
    public double getAcidTestRatio()
    {
        return acidTestRatio;
    }

    public void setTotalFixedAssets(double totalFixedAssets)
    {
        this.totalFixedAssets = totalFixedAssets;
    }
    
    public void setTotalCurrentAssets(double totalCurrentAssets)
    {
        this.totalCurrentAssets = totalCurrentAssets;
    }
    
    public void setTotalShortTermLiabilities(double totalShortTermLiabilities)
    {
        this.totalShortTermLiabilities = totalShortTermLiabilities;
    }
    
    public void setTotalLongTermLiabilities(double totalLongTermLiabilities)
    {
        this.totalLongTermLiabilities = totalLongTermLiabilities;
    }
    
    
        public double getTotalFixedAssets()
    {
        return totalFixedAssets;
    }
        
        public double getTotalCurrentAssets()
    {
        return totalCurrentAssets;
    }
        
         public double getTotalShortTermLiabilities()
    {
        return totalShortTermLiabilities;
    }
         
        public double getTotalLongTermLiabilities()
    {
        return totalLongTermLiabilities;
    }
        
       //calculate the total fixed assets thatt were inserted by the Client 
        public void calculateTotalFixedAssets()
        {
            double total=0;
            ResultSet rs = null;
            Statement s= null;
            String dbQuery="SELECT * FROM FixedAssetsTable";
        
            JavaDb dbObject = new JavaDb("BusinessManagement");
            dbConn=dbObject.getDbConn();
            try {
                s = this.dbConn.createStatement();
                rs = s.executeQuery(dbQuery);
                while(rs.next()) 
                {
                  //System.out.println("In DB: " + rs.getDouble("fixedAssetsValue"));
                   total = total + rs.getDouble("fixedAssetsValue");
                  // System.out.println("In Method: " + total);
                }
                
               //System.out.println("The total is " + total);
                setTotalFixedAssets(total);
                dbObject.closeDbConn();
                }
            catch (Exception e)
            {
                errorFrame error = new errorFrame("You did something wrong!");
            }
        }
        
        public void calculateTotalCurrentAssets()
        {
            double total=0;
            ResultSet rs = null;
            Statement s= null;
            String dbQuery="SELECT * FROM CurrentAssetsTable";
        
            JavaDb dbObject = new JavaDb("BusinessManagement");
            dbConn=dbObject.getDbConn();
            try {
                s = this.dbConn.createStatement();
                rs = s.executeQuery(dbQuery);
                while(rs.next()) 
                {
                   total = total + rs.getDouble("currentAssetsValue");
                }
                
                setTotalCurrentAssets(total);
                dbObject.closeDbConn();
                }
            catch (Exception e)
            {
                errorFrame error = new errorFrame("You did something wrong!");
            }
        }
        
        public void calculateTotalShortTermLiabilities()
        {
            double total=0;
            ResultSet rs = null;
            Statement s= null;
            String dbQuery="SELECT * FROM ShortTermLiabilitiesTable";
        
            JavaDb dbObject = new JavaDb("BusinessManagement");
            dbConn=dbObject.getDbConn();
            try {
                s = this.dbConn.createStatement();
                rs = s.executeQuery(dbQuery);
                while(rs.next()) 
                {
                   total = total + rs.getDouble("shortTermLiabilitiesValue");
                }
                
                setTotalShortTermLiabilities(total);
                dbObject.closeDbConn();
                }
            catch (Exception e)
            {
                errorFrame error = new errorFrame("You did something wrong!");
            }
        }
        
        public void calculateTotalLongTermLiabilities()
        {
            double total=0;
            ResultSet rs = null;
            Statement s= null;
            String dbQuery="SELECT * FROM LongTermLiabilitiesTable";
        
            JavaDb dbObject = new JavaDb("BusinessManagement");
            dbConn=dbObject.getDbConn();
            try {
                s = this.dbConn.createStatement();
                rs = s.executeQuery(dbQuery);
                while(rs.next()) 
                {
                   total = total + rs.getDouble("longTermLiabilitiesValue");
                }
                
                setTotalLongTermLiabilities(total);
                dbObject.closeDbConn();
                }
            catch (Exception e)
            {
                errorFrame error = new errorFrame("You did something wrong!");
            }
        }
        
        
        public static void main(String[] args)
        {
            businessComputation obj = new businessComputation();
            obj.calculateTotalFixedAssets();
            obj.calculateTotalCurrentAssets();
            obj.calculateTotalShortTermLiabilities();
            obj.calculateTotalLongTermLiabilities();
            obj.calculateEquity(obj.getTotalFixedAssets(), obj.getTotalCurrentAssets(),obj.getTotalShortTermLiabilities(),obj.getTotalLongTermLiabilities());
            System.out.println("Current assets are" + obj.getTotalCurrentAssets());
            System.out.println("Short term liab are" + obj.getTotalShortTermLiabilities());
            System.out.println("Long term liabilities are" + obj.getTotalLongTermLiabilities());
            System.out.println("Equity " + obj.getEquity());
            System.out.println("Fixed assets are "+obj.getTotalFixedAssets());
        }
        
}
