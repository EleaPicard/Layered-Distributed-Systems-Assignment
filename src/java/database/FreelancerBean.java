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
    private String password;
    
    /**
     * Creates a new instance of FreelancerBean
     */
    public FreelancerBean() {
        // add freelancer if list is empty
        if (fre.size() < 1) {
            fre.add(new Freelancer(fre.size()+1,"Juan Martinez","Curious","hello world",20156,"$2a$12$h/ZmoMoWQMpPkRO820ul5efQwHKsJUHUix3wbAlziJ9I1MojZy3DS"));
            fre.add(new Freelancer(fre.size()+1,"Lucas Gallagher","Ambitious","hello world",35201,"$2a$12$zxd5EJSv1dSvmFYWPNkisuzuhN3R9.3f/2R/zJGljDnd.tuJVHXvC"));
            fre.add(new Freelancer(fre.size()+1,"Mike O'Shea","Rigorous","hello world",18568,"$2a$12$UEBi5Ao3Nf201sBcQaxZ4uXefvIWwYzl7r1F6fkiJ0sS0SI0m4//G"));
            fre.add(new Freelancer(fre.size()+1,"Eoin O'Connel","Leadership","hello world",12560,"$2a$12$.yyFvssY0cGTnSqnkg9y2.cxJXSExncMNoPEsRzPeF.IXwTmqZnta"));
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
     * Return the Freelancer object with the corresponding ID
     *
     * @param id ID of freelancer to look for
     * @return List containing the freelancer
     */
    public Freelancer getFreelancerById(Integer id) {
        Freelancer result = new Freelancer();
        // find all job description with a given provider and add to result
        for (Freelancer f : fre) {
            if (f.getId().compareTo(id) == 0) {
                result = f;
            }
        }
        return result;
    }
    
    /**
     * Method to add a new freelancer to the collection. values will be taken
     * from attributes
     */
    public void addFreelancer() {
        fre.add(new Freelancer(fre.size()+1,name,listOfSkills,message,paymentAccount,BCrypt.hashpw(password, BCrypt.gensalt(12))));
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
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of name
     *
     * @param password new value of name
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
