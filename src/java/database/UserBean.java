package database;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author vince
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String userName;
    private String type;
    
    public UserBean() {
        type = "";
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String newUserName) {
        userName = newUserName;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String newType) {
        type = newType;
    }
    
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
                break;
            }
        }
        
        if (!type.equals("administrator")){
            String providerName;
            for (Provider p : pro) {
                providerName = p.getName();
                if (userName.equals(providerName)) {
                    type = "provider";
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
                    break;
                }
            }
            if (!type.equals("freelancer")) {
                type = "error";
            }
        }
        return type;
    }
}
