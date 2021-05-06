package database;

import EntrepriseBeans.UserLogInRemote;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;

/**
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
     * Retrieves user type (administrator/provider/freelancer)
     *
     * @return type of the user 
     */
    public String getType() {
        return type;
    }
    
    /**
     * Set a new type for the user (administrator/provider/freelancer)
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
     * Find the matching user in the data tables and retrieve its ID and type
     * either administrator, job provider or freelancer
     *
     * @return user type
     */
    public String login() {
        type = userLogIn.lookForType(userName, password);
        
        if (!"error".equals(type)) {
            id = userLogIn.lookForId(userName, type);
        } else {
            id = 0;
        }
        
        return type;
    }
    
    /**
     * reset userName and type for log out
     *
     * @return "logout" for HTML navigation
     */
    public String logout() {
        userName = "";
        password = "";
        type = "";
        id = 0;
        return "logout";
    }
}
