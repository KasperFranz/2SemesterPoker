/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Allan
 */
public class DBhandler
{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSet resultSetFornavn;
    private ResultSet resultSetEfternavn;
    
    public DBhandler()
    {
        connection = null;
        statement = null;
        resultSet = null;
        resultSetFornavn = null;
        resultSetEfternavn = null;
    }
    
    public void connectToDB() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException
    {
        Class.forName("org.mysql.JDBC");  
        connection = DriverManager.getConnection("jdbc:mysql:src/resources/rpg.db");
    }
    
    public void closeDB() throws SQLException
    {
        connection.close();
    }
    
    public String[] getPlayer(String columnName, String tableName, int amount)
    {
        String[] returnArray;
        String sql;
        int counter;
        int nums;
        
        returnArray = new String[amount];
        sql = "";
        counter = 0;
        nums = 0;
        
        try 
        {  
            statement = connection.createStatement(); 
            sql = "SELECT " + columnName + " FROM " + tableName + " ORDER BY RANDOM() LIMIT " + amount;
            //System.out.ntln("SQL: " + sql);
            resultSet = statement.executeQuery(sql);   
            
            while(resultSet.next())
            {
                returnArray[counter] = resultSet.getString(columnName);
                counter++;
                
                //System.out.println(resultSet.getString(columnName));
            }
        } 
        catch (Exception e) 
        {  
            System.out.println("Der opstod en fejl under hentning af data fra DB. " + e);  
        }
        finally 
        {  
            try 
            {  
                resultSet.close();  
                statement.close();  
                connection.close();  
            } 
            catch (Exception e) 
            {  
                System.out.println("Der opstod en fejl i forsøget på at lukke forbindelserne. " + e);  
            }  
        }
        return returnArray;
    }
}
