package database;

import EntrepriseBeans.UserLogInRemote;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 * Managed Bean for User Connection to the website
 *
 * @author Vincent Sifferlen
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    @EJB
    private UserLogInRemote userLogIn;
    
    private String userName;
    private String password;
    private String type;
    private int id;
    
    LogBean logs = new LogBean();
    ArrayList<Log> logsList = logs.getAllLogs();
    
    /**
     * Default constructor.
     */
    public UserBean() {
        type = "";
        id = 0;
    }
    
    /**
     * Retrieves user name
     *
     * @return name of the user
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Set new user name
     *
     * @param newUserName new name for the user
     */
    public void setUserName(String newUserName) {
        userName = newUserName;
    }
    
    /**
     * Retrieves password
     *
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Set new user password
     *
     * @param newPassword new user password
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    
    /**
     * Retrieves user type (Administrator/Provider/Freelancer).
     *
     * @return type of the user 
     */
    public String getType() {
        return type;
    }
    
    /**
     * Set a new type for the user (Administrator/Provider/Freelancer).
     *
     * @param newType new type for the user
     */
    public void setType(String newType) {
        type = newType;
    }
    
    /**
     * Retrieves user ID
     *
     * @return ID of the user
     */
    public int getId() {
        return id;
    }
    
    /**
     * Set a new ID for the user
     *
     * @param newId new user ID
     */
    public void setId(int newId) {
        id = newId;
    }
    
    /**
     * Find the matching user in the data tables and retrieve its ID and type.
     * Either administrator, job provider or freelancer
     *
     * @return user type
     */
    public String login() {
        // Call EJB for log in method
        type = userLogIn.lookForType(userName, password);
        
        // If both the user name and the password are correct
        if (!"error".equals(type)) {
            // Call the EJB method to retrieve user ID
            id = userLogIn.lookForId(userName, type);
            // Add a log entry for the connection
            logs.addLogConnection(type, userName);
        } else {  // If either user name or password are wrong
            // Dummy value for user ID
            id = 0;
            // Add a log entry for the failed connection
            logs.addLogConnectionError(userName);
        }
        
        // Return user type for HTML navigation to appropriated web page
        return type;
    }
    
    /**
     * Reset userName and type for log out
     *
     * @return "logout" for HTML navigation
     */
    public String logout() {
        // Add a new log entry for the deconnection
        logs.addLogDeconnection(type, userName);
        
        // Remove user's data from the bean
        userName = "";
        password = "";
        type = "";
        id = 0;
        
        // return value used for navigation
        return "logout";
    }
}
