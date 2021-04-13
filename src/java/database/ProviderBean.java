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
 *
 * @author eleap
 */
@Named(value = "providerBean")
@SessionScoped
public class ProviderBean implements Serializable {
    
    private static ArrayList<Provider> pro = new ArrayList<>();
    private Integer id;
    private String name;

    /**
     * Creates a new instance of ProviderBean
     */
    public ProviderBean() {
        // add provider if list is empty
        if (pro.size() < 1) {
            pro.add(new Provider(pro.size()+1,"Tom Murphy"));
            pro.add(new Provider(pro.size()+1,"Tom Gallagher"));
            pro.add(new Provider(pro.size()+1,"Peter Cummins"));
            pro.add(new Provider(pro.size()+1,"Carola Smitt"));
            pro.add(new Provider(pro.size()+1,"Cathriona Murhpy"));
            pro.add(new Provider(pro.size()+1,"Maria O'Neil"));
            pro.add(new Provider(pro.size()+1,"Andrea O'Shea"));
            pro.add(new Provider(pro.size()+1,"Martina O'Sullivan"));
            pro.add(new Provider(pro.size()+1,"Sean Conway"));
            pro.add(new Provider(pro.size()+1,"Eoin Dunphy"));
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
     * Method to add a new provider to the collection. values will be taken
     * from attributes
     */
    public void addProvider() {
        pro.add(new Provider(pro.size()+1,name));
    }

    /**
     * Method to removes a provider from the collection
     * @param p Provider to be removed
     */
    public void removeProvider(Provider p) {
        pro.remove(p);
    }

    /**
     * Get the value of the id
     *
     * @return the value of the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of the id
     *
     * @param id new value of id
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
    
    
    
}
