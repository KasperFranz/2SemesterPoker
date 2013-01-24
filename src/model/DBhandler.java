/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import resources.DbIniParser;

/**
 *
 * @author Allan
 */
public class DBhandler
{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private DbIniParser db_values;
    
    /**
     * Connection to database is established as soon as object is created.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public DBhandler() throws ClassNotFoundException, SQLException
    {
        db_values = new DbIniParser();
        connectToDB();
    }
    
    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void connectToDB() throws ClassNotFoundException, SQLException
    {
        //Driveren loades - kræver at MySQL JDBC Driver er tilføjet under Libraries
        Class.forName("com.mysql.jdbc.Driver");
        //Der oprettes et Connection-objekt med port, databasenavn, brugernavn og password
        conn = DriverManager.getConnection("jdbc:mysql://"+db_values.getHost()+":"+db_values.getPort()+"/"+db_values.getDatabase()+"", db_values.getDB_User(), db_values.getDB_Pass());
    }
    
    /**
     * Use this to close database connection opened by object
     */
    public void closeDB() throws SQLException
    {
        conn.close();
    }
    
    /**
     * 
     * @param table
     * @param where
     * @param order
     * @param limit
     * @param list for example "first_column", "second_column", "third_column" etc.
     * @return String[][]
     * @throws SQLException 
     */
    public String[][] getFromDB(String table, String where, String order, String limit, String ... list) throws SQLException
    {        
        String toGet = "";
        int i = 1;
        for (String value : list)
        {
            toGet += value;
            if (i < list.length) toGet += ", ";
            i++;
        }
        String sql = String.format("SELECT %s FROM %s %s %s %s", toGet, table, where, order, limit);
        String[][] returnArray = null;
        
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        // Go to the last row
        rs.last();
        int numRows = rs.getRow();

        // Reset row before iterating to get data
        rs.beforeFirst();

        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
        
        returnArray = new String[numRows][numberOfColumns];
        int j = 0;
        while (rs.next())
        {
            int k = 0;
            for (String value : list)
            {
                returnArray[j][k] = rs.getString(value);
                k++;
            }
            j++;
        }
        
        return returnArray;
    }
    
    /**
     * 
     * @param queryString for example (INSERT INTO table (column_one, column2, column3) VALUES ("1", "2", "3")
     * @return
     * @throws SQLException 
     */
    public int manipulateDB(String queryString) throws SQLException
    {        
        String sql = String.format("%s", queryString);
        int affectedRows = 0;

        stmt = conn.createStatement();
        affectedRows = stmt.executeUpdate(sql);
        return affectedRows;
    }
}
