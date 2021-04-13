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

/**
 *
 * @author eleap
 */
@Named(value = "administratorBean")
@SessionScoped
public class AdministratorBean implements Serializable {

    private static ArrayList<Administrator> adm = new ArrayList<>();
    private Integer id;
    private String name;

    /**
     * Creates a new instance of AdministratorBean
     */
    public AdministratorBean() {
        // add administrator if list is empty
        if (adm.size() < 1) {
            adm.add(new Administrator(adm.size()+1,"Anna Murphy"));
            adm.add(new Administrator(adm.size()+1,"Tom Holly"));
            adm.add(new Administrator(adm.size()+1,"Peter Smitt"));
            adm.add(new Administrator(adm.size()+1,"Carola Alvez"));
        }
    }
    
       /**
     * Returns all administrators
     *
     * @return all administrators
     */
    public ArrayList<Administrator> getAllAdministrators() {
        return adm;
    }
    
    /**
     * Method to add a new administrator to the collection. values will be taken
     * from attributes
     */
    public void addAdministrator() {
        adm.add(new Administrator(adm.size()+1,name));
    }

    /**
     * Method to removes an administrator from the collection
     * @param a Administrator to be removed
     */
    public void removeAdministrator(Administrator a) {
        adm.remove(a);
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
