package Validator;

import database.JobDescription;
import database.JobDescriptionBean;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

/**
 * Validator for job description ID
 *
 * @author eleap
 */
@FacesValidator("myvalidatorid")
public class MyValidatorId implements Validator {

    JobDescriptionBean jobs = new JobDescriptionBean();
    ArrayList<JobDescription> jobsList = jobs.getAllJobDescriptions();

    private String searchId;

    /**
     * Default Constructor
     */
    public MyValidatorId() {
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object obj)
            throws ValidatorException {
        Integer jobId = (Integer) obj;
        boolean valid = false;

        // Check if the ID is in the job decriptions
        for (JobDescription j : jobsList) {
            if (j.getId().compareTo(jobId) == 0) {
                if (j.getState().compareTo("Open") == 0) {
                    valid = true;
                }
            }
        }
        // If the ID is not in the job descriptions
        if (valid == false) {
            // Create an error message
            FacesMessage msg = new FacesMessage(
                    " This job Id is not in the list of open jobs. "
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
