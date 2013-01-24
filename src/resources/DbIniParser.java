/*
 * Henrik J.G. Nielsen
 * 
 */
package resources;

import java.util.Properties;
import javax.swing.JOptionPane;


/*  Pre: <none>   Post: <none>  */
/**
 *
 * @author henrik
 */
public class DbIniParser {

    private String DB_User;
    private String DB_Pass;
    private String database;
    private String host;
    private String port;
    
    public DbIniParser()
    {
        Properties props = new Properties();
        try 
        {
            props.load(DbIniParser.class.getResourceAsStream("Database.ini"));
            DB_User = props.getProperty("DB_User");
            DB_Pass = props.getProperty("DB_Pass");
            database = props.getProperty("Database");
            host = props.getProperty("Host");
            port = props.getProperty("Port");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,
            e.getLocalizedMessage());
        }
        System.out.println(DB_User);
    }

    public String getDB_User() {
        return DB_User;
    }

    public String getDB_Pass() {
        return DB_Pass;
    }

    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
/*
 * 
 * Ini ini = new Ini(new File("/path/to/file"));
 * 
 * */
