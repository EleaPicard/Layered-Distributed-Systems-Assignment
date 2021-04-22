/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntrepriseBeans;

import database.AdministratorBean;
import database.FreelancerBean;
import database.ProviderBean;
import database.Administrator;
import database.BCrypt;
import database.Freelancer;
import database.Provider;
import java.util.ArrayList;

import javax.ejb.Stateless;

/**
 *
 * @author vince
 */
@Stateless
public class UserLogIn implements UserLogInRemote{
    
    @Override
    public String lookForType(String userName, String password) {
        String type="";
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
                String adminPassword = a.getPassword();
                boolean matched = BCrypt.checkpw(password, adminPassword);
                if (matched) {
                    type = "Administrator";
                    break;   
                }
            }
        }
        
        if (!type.equals("Administrator")){
            String providerName;
            for (Provider p : pro) {
                providerName = p.getName();
                if (userName.equals(providerName)) {
                    String providerPassword = p.getPassword();
                    boolean matched = BCrypt.checkpw(password, providerPassword);
                    if (matched) {
                        type = "Provider";
                        break;
                    }
                }
            }
        }
            
        if (!type.equals("Administrator") && !type.equals("Provider")) {
            String freelancerName;
            for (Freelancer f : free) {
                freelancerName = f.getName();
                if (userName.equals(freelancerName)) {
                    String freelancerPassword = f.getPassword();
                    boolean matched = BCrypt.checkpw(password, freelancerPassword);
                    if (matched) {
                        type = "Freelancer";
                        break;
                    }
                }
            }
            if (!type.equals("Freelancer")) {
                type = "error";
            }
        }
        
        return type;
    }
    
    @Override
    public Integer lookForId(String userName, String type) {
        Integer id = 0;
        
        AdministratorBean administrators = new AdministratorBean();
        ProviderBean providers = new ProviderBean();
        FreelancerBean freelancers = new FreelancerBean();
        
        if ("Administrator".equals(type)) {
            ArrayList<Administrator> admins = administrators.getAllAdministrators();
            for (Administrator a : admins) {
                String amdinName = a.getName();
                if (userName.equals(amdinName)) {
                    id = a.getId();
                }
            }
        } else if("Provider".equals(type)) {
            ArrayList<Provider> pro = providers.getAllProviders();
            for (Provider p : pro) {
                String providerName = p.getName();
                if (userName.equals(providerName)) {
                    id = p.getId();
                }
            }
        } else {
            ArrayList<Freelancer> free = freelancers.getAllFreelancers();
            for (Freelancer f : free) {
                String freelancerName = f.getName();
                if (userName.equals(freelancerName)) {
                    id = f.getId();
                }
            }
        }
        return id;
    }
}
