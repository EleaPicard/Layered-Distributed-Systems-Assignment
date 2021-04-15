package database;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Vincent Sifferlen
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String userName;
    private String type;
    private int id;
    
    /**
     * Default constructor.
     */
    public UserBean() {
        type = "";
    }
    
    /**
     * Retrieves user name
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Set new user name
     *
     * @param newUserName
     */
    public void setUserName(String newUserName) {
        userName = newUserName;
    }
    
    /**
     * Retrieves user type
     *
     * @return
     */
    public String getType() {
        return type;
    }
    
    /**
     * Set a new type for the user
     *
     * @param newType
     */
    public void setType(String newType) {
        type = newType;
    }
    
    /**
     * Retrieves user ID
     *
     * @return
     */
    public int getId() {
        return id;
    }
    
    /**
     * Set a new ID for the user
     *
     * @param newId
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
        AdministratorBean administrators = new AdministratorBean();
        ProviderBean providers = new ProviderBean();
        FreelancerBean freelancers = new FreelancerBean();
        
        ArrayList<Administrator> admins = administrators.getAllAdministrators();
        ArrayList<Provider> pro = providers.getAllProviders();
        ArrayList<Freelancer> free = freelancers.getAllFreelancers();
        
        String adminName;
        for (Administrator a : admins) {
            adminName = a.getName();
            if(userName.equals(adminName)) {
                type = "administrator";
                id = a.getId();
                break;
            }
        }
        
        if (!type.equals("administrator")){
            String providerName;
            for (Provider p : pro) {
                providerName = p.getName();
                if (userName.equals(providerName)) {
                    type = "provider";
                    id = p.getId();
                    break;
                }
            }
        }
            
        if (!type.equals("administrator") && !type.equals("provider")) {
            String freelancerName;
            for (Freelancer f : free) {
                freelancerName = f.getName();
                if (userName.equals(freelancerName)) {
                    type = "freelancer";
                    id = f.getId();
                    break;
                }
            }
            if (!type.equals("freelancer")) {
                type = "error";
                id = 0;
            }
        }
        return type;
    }
    
    /**
     * reset userName and type for log out
     *
     * @return "logout" for HTML navigation
     */
    public String logout() {
        userName="";
        type="";
        id = 0;
        return "logout";
    }
}
