/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 * Entity Class for the Administrators
 *
 * @author eleap
 */
public class Administrator {
    
    private Integer id;
    private String name;
    private String password;

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
     * @param id new value of the ID
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

    /**
     * Generates an administrator with the given information
     * 
     * @param id unique job ID of the administrator 
     * @param name Name of the administrator
     * @param password Password of the administrator
     */
    public Administrator(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    
}
