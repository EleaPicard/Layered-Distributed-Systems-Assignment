/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Managed Bean Database for Providers
 *
 * @author eleap
 */
@Named(value = "providerBean")
@SessionScoped
public class ProviderBean implements Serializable {
    
    private static ArrayList<Provider> pro = new ArrayList<>();
    private Integer id;
    private String name;
    private String password;

    /**
     * Creates a new instance of ProviderBean
     */
    public ProviderBean() {
        // add provider if list is empty
        if (pro.size() < 1) {
            pro.add(new Provider(pro.size()+1, "Tom Murphy",
                    "$2a$12$hE091a365vK5TbM4NTmkEO07biIU8Oml4f1jiD1A3JMhIMwsK/31i"));
            pro.add(new Provider(pro.size()+1, "Tom Gallagher",
                    "$2a$12$w4zmq2aR7MbEwaGyzW62/umuwF.g8.5lQg7cPAAGLRiR02w0zjZ1K"));
            pro.add(new Provider(pro.size()+1, "Peter Cummins",
                    "$2a$12$uMUItKSTapc/gYzvxSxRbO9UdSAiSMu.YFdmB4Ej6j1I9vg14URZK"));
            pro.add(new Provider(pro.size()+1, "Carola Smitt",
                    "$2a$12$91JyiIPMlMB9DGeji3Vr5u6Pze7Gwl/KWhLsfU90ACmnVGIdvg3jq"));
            pro.add(new Provider(pro.size()+1, "Cathriona Murhpy", 
                    "$2a$12$TBazB.vw0Mx7iUOIVoCRcO3fD1PB5dykarxUEWKiibppv6b.0/Phy"));
            pro.add(new Provider(pro.size()+1, "Maria O'Neil",
                    "$2a$12$/nMVaZKHu4.PPIGyoL9FYunYPs49MtplX8sO9bZ28V/CtiUab5v1y"));
            pro.add(new Provider(pro.size()+1, "Andrea O'Shea",
                    "$2a$12$6JXXByCovovfC5aUrPpm6.4zuDUsJ5QvdqhQuTUCO36pqs0eYmMx2"));
            pro.add(new Provider(pro.size()+1, "Martina O'Sullivan",
                    "$2a$12$B9WJwGZnUGWNcC2sVjuu7eUbtmUDwqwSWRZh3qjPHCA4w3GFGKv2K"));
            pro.add(new Provider(pro.size()+1, "Sean Conway",
                    "$2a$12$RACeMOccANlqEuZAJoUwMu6O4M1VrKWJ8lGEjSWm4HOr3vT3j8zZW"));
            pro.add(new Provider(pro.size()+1, "Eoin Dunphy",
                    "$2a$12$ELioSKZUx/CgQGgasNV6l.VAzj9aqtQJFVH2I6evZfACjLFB3XtNi"));
        }
    }
    

    /**
     * Returns all providers
     *
     * @return all providers
     */
    public ArrayList<Provider> getAllProviders() {
        return pro;
    }
    
    /**
     * Method to add a new provider to the collection. 
     * Values will be taken from attributes
     */
    public void addProvider() {
        pro.add(new Provider(pro.size()+1, name, 
                BCrypt.hashpw(password, BCrypt.gensalt(12))));
    }

    /**
     * Method to removes a provider from the collection
     * 
     * @param p Provider to be removed
     */
    public void removeProvider(Provider p) {
        pro.remove(p);
    }

    /**
     * Get the value of the ID
     *
     * @return the value of the ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of the ID
     *
     * @param id new value of ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
