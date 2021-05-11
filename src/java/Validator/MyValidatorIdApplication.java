package Validator;

import database.JobApplication;
import database.JobApplicationBean;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

/**
 * Validator for job application ID research 
 *
 * @author eleap
 */
@FacesValidator("myvalidatorapplyid")
public class MyValidatorIdApplication implements Validator {

    JobApplicationBean appli = new JobApplicationBean();
    ArrayList<JobApplication> jobsAppliList = appli.getAllJobApplications();

    private String searchId;

    /**
     * Default Constructor
     */
    public MyValidatorIdApplication() {
    }

    /*
     * Method to validate if the id is in the list of job application 
     */
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object obj)
            throws ValidatorException {
        Integer applicationId = (Integer) obj;
        boolean valid = false;

        // Check if the ID is in the job applications
        for (JobApplication j : jobsAppliList) {
            if (j.getApplicationId().compareTo(applicationId) == 0) {
                if ("Pending".equals(j.getState()))
                    valid = true;
            }
        }
        // If the ID is not in the job applications
        if (valid == false) {
            // Create an error message
            FacesMessage msg = new FacesMessage(
                    " This job application Id is not in the list. "
                    + "Please enter an other Id.");
            // Set the severity of the message
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            // Throw a validator exception with the message
            throw new ValidatorException(msg);
        }

    }

    /**
     * Get the value of search ID
     *
     * @return the value search ID
     */
    public String getSearchId() {
        return searchId;
    }

    /**
     * Set the value of search ID
     *
     * @param searchId new value of the search ID
     */
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }
}
