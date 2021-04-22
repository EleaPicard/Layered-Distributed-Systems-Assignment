/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author eleap
 */
public class Freelancer implements Comparable<Freelancer>{
    
    private Integer id;
    private String name;
    private String listOfSkills;
    private String message;
    private double paymentAccount;
    private String password;
    private boolean canEdit;

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
     * @param id new value of the id
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
     * Get the value of the list of skills
     *
     * @return the value of the list of skills
     */
    public String getListOfSkills() {
        return listOfSkills;
    }

    /**
     * Set the value of the list of skills
     *
     * @param listOfSkills new value of the list of skills
     */
    public void setListOfSkills(String listOfSkills) {
        this.listOfSkills = listOfSkills;
    }

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the value of paymentAccount
     *
     * @return the value of paymentAccount
     */
    public double getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * Set the value of paymentAccount
     *
     * @param paymentAccount new value of paymentAccount
     */
    public void setPaymentAccount(double paymentAccount) {
        this.paymentAccount = paymentAccount;
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
     * Accessor for isEdit
     * @return value of canEdit
     */
    public boolean isCanEdit() {
        return canEdit;
    }

    /**
     * Mutator for canEdit
     * @param canEdit false indicates this object cannot be edited
     */
    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
    
    /**
     * Method to compare a freelancer
     * Values will be taken from attributes 
     * @param o Freelancer
     */
    public int compareTo(Freelancer o) {
        return id - o.id;
    }

    /**
     * Generates a freelancer with the given information
     * 
     * @param id unique job ID of the freelancer 
     * @param name Name of the freelancer
     * @param listOfSkills list of skills of the freelancer
     * @param message message of the freelancer
     * @param paymentAccount amount in the payment account of the freelancer 
     * @param password Password of the freelancer
     * @param canEdit indicates if this object can be edited
     */
    public Freelancer(Integer id, String name, String listOfSkills, String message, double paymentAccount, String password) {
        this.id = id;
        this.name = name;
        this.listOfSkills = listOfSkills;
        this.message = message;
        this.paymentAccount = paymentAccount;
        this.password = password;
        canEdit = false;
    }
    
    /**
     * Default constructor for Freelancer class.
     */
    public Freelancer() {
        canEdit = false;
    }
    
}
