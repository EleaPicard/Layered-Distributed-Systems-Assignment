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
@Named(value = "freelancerBean")
@SessionScoped
public class FreelancerBean implements Serializable {
    
    private static ArrayList<Freelancer> fre = new ArrayList<>();
    private Integer id;
    private String name;
    private String listOfSkills;
    private String message;
    private double paymentAccount;
    
    /**
     * Creates a new instance of FreelancerBean
     */
    public FreelancerBean() {
        // add freelancer if list is empty
        if (fre.size() < 1) {
            fre.add(new Freelancer(fre.size()+1,"Juan Martinez","Curious","hello world",20156));
            fre.add(new Freelancer(fre.size()+1,"Lucas Gallagher","Ambitious","hello world",35201));
            fre.add(new Freelancer(fre.size()+1,"Mike O'Shea","Rigorous","hello world",18568));
            fre.add(new Freelancer(fre.size()+1,"Eoin O'Connel","Leadership","hello world",12560));
        }
    }

    /**
     * Returns all freelancers
     *
     * @return all freelancers
     */
    public ArrayList<Freelancer> getAllFreelancers() {
        return fre;
    }
    
    /**
     * Method to add a new freelancer to the collection. values will be taken
     * from attributes
     */
    public void addFreelancer() {
        fre.add(new Freelancer(fre.size()+1,name,listOfSkills,message,paymentAccount));
    }

    /**
     * Method to removes a freelancer from the collection
     * @param f Freelancer to be removed
     */
    public void removeFreelancer(Freelancer f) {
        fre.remove(f);
    }
    
    /**
     * Enables editing of freelancer entries
     * @param f freelancer for which to enable editing
     */
    public void editFreelancer(Freelancer f) {
        f.setCanEdit(true);
    }

    /**
     * Disable editing for all freelancer entries.
     */
    public void saveFreelancer() {
        for (Freelancer f : fre) {
            f.setCanEdit(false);
        }
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
    
}
