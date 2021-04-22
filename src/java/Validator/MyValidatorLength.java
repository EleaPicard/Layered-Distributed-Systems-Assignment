package Validator;

import database.JobDescriptionBean;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
 
@FacesValidator("myvalidatorlength")
public class MyValidatorLength implements Validator
{
        private String inp;
	int maximumlength = 25;

	public MyValidatorLength() {
	}

	/*
         * Methode to validate if the keywords is not too long 
         *
         */
        @Override
	public void validate(FacesContext fc, UIComponent uic, Object obj)
			throws ValidatorException {
		String model = (String) obj;
                //Check the length of my model
		if (model.length() > maximumlength) {
			FacesMessage msg = new FacesMessage(
					" Maximum Length of 25 is exceeded. Please enter values within range.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
        
        /**
         * Get the value of inp
         *
         * @return the value inp
         */
        public String getInp() {
		return inp;
	}

        /**
         * Set the value of inp
         *
         * @param inp new value of the inp
         */
	public void setInp(String inp) {
		this.inp = inp;
	}
}