/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 * Entity Class for Job Descriptions
 *
 * @author eleap
 */
public class JobDescription {
    
    private Integer id;
    private String title;
    private String keywords;
    private String description;
    private double paymentOffer;
    private String state;
    private Integer providerId;

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
     * Get the value of the title
     *
     * @return the value of the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of the title
     *
     * @param title new value of the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of the keywords
     *
     * @return the value of the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Set the value of the keywords
     *
     * @param keywords new value of the keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Get the value of the description
     *
     * @return the value of the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of the description
     *
     * @param description new value of the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of the payment offer
     *
     * @return the value of the payment offer
     */
    public double getPaymentOffer() {
        return paymentOffer;
    }

    /**
     * Set the value of the paymentOffer
     *
     * @param paymentOffer new value of the paymentOffer
     */
    public void setPaymentOffer(double paymentOffer) {
        this.paymentOffer = paymentOffer;
    }

    /**
     * Get the value of the state
     *
     * @return the value of the state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of the state
     *
     * @param state new value of the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the value of the provider id
     *
     * @return the value of the provider id
     */
    public Integer getProviderId() {
        return providerId;
    }

    /**
     * Set the value of the provider id
     *
     * @param providerId new value of the provider id
     */
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    /**
     * Generates a job description with the given information
     * 
     * @param id unique job ID 
     * @param title title of the job
     * @param keywords keywords of the job
     * @param description description of the job
     * @param paymentOffer payment offer of the job
     * @param state state of the job
     * @param providerId job provider ID 
     */
    public JobDescription(Integer id, String title, String keywords, 
            String description, double paymentOffer, 
            String state, Integer providerId) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
        this.paymentOffer = paymentOffer;
        this.state = state;
        this.providerId = providerId;
    }
    
    /**
     * Default constructor.
     */
    public JobDescription() {
    }
    
}
