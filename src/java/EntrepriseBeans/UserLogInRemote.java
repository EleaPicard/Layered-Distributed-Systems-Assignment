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
import database.Provider;
import database.Freelancer;
import javax.ejb.Remote;

/**
 *
 * @author vince
 */
@Remote
public interface UserLogInRemote {
    public String lookForType(String userName, String password);
    public Integer lookForId(String userName, String type);
}
