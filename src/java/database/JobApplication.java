package database;

/**
 *
 * @author vince
 */
public class JobApplication {
    private Integer applicationId;
    private Integer descriptionId;
    private Integer freelancerId;
    
    /**
     * Generate a job Application with the given information
     *
     * @param applicationId unique application ID
     * @param descriptionId ID of the job description
     * @param freelancerId ID of the freelancer
     */
    public JobApplication(Integer applicationId, Integer descriptionId, Integer freelancerId) {
        this.applicationId = applicationId;
        this.descriptionId = descriptionId;
        this.freelancerId = freelancerId;
    }
    
    //////////////
    // GETTERS //
    ////////////
    
    public Integer getApplicationId() {
        return applicationId;
    }
    
    public Integer getDescriptionId() {
        return descriptionId;
    }
    
    public Integer getFreelancerId() {
        return freelancerId;
    }
    
    //////////////
    // SETTERS //
    ////////////

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }
    
}
