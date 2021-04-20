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
    private String password;

    /**
     * Creates a new instance of AdministratorBean
     */
    public AdministratorBean() {
        // add administrator if list is empty
        if (adm.size() < 1) {
            adm.add(new Administrator(adm.size()+1,"Anna Murphy", "$2a$12$8mkMLKSlW48jTtpVGejUvuAu3DOl80c6eDeCsuTd6ANZy5nhW7rdO"));
            adm.add(new Administrator(adm.size()+1,"Tom Holly", "$2a$12$QqvXBis2Nc6GkLnMHqBDveT3X4EBv8xaXX7llQVZ38K1GRgCoBazG"));
            adm.add(new Administrator(adm.size()+1,"Peter Smitt", "$2a$12$SIz3Xavkg24vekNeUuArheEK5HZTxTvOjl9Wcb3opUb99Y0wtSltO"));
            adm.add(new Administrator(adm.size()+1,"Carola Alvez", "$2a$12$u3MQ.r6TMZtyXQK2ydItduDEReQz8WL.e5RDxmIzvaTI7RlJbc10i"));
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
     * Method to add a new administrator to the collection. 
     * values will be taken from attributes
     */
    public void addAdministrator() {
        adm.add(new Administrator(adm.size()+1,name, password));
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
