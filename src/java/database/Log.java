/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author eleap
 */
public class Log {
    
    private String dateTime;
    private String actioner;
    private String actionerName;
    private String action;


    /**
     * Get the value of the dateTime
     *
     * @return the value of the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Set the value of the dateTime
     *
     * @param dateTime new value of the dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }   

    /**
     * Get the value of the actioner
     *
     * @return the value of the actioner
     */
    public String getActioner() {
        return actioner;
    }

    /**
     * Set the value of the actioner
     *
     * @param actioner new value of the actioner
     */
    public void setActioner(String actioner) {
        this.actioner = actioner;
    }

    /**
     * Get the value of the actionerName
     *
     * @return the value of the actioner name
     */
    public String getActionerName() {
        return actionerName;
    }

    /**
     * Set the value of the actionerName
     *
     * @param actionerName new value of the actioner name
     */
    public void setActionerName(String actionerName) {
        this.actionerName = actionerName;
    }
    
    

    /**
     * Get the value of the action
     *
     * @return the value of the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Set the value of the action
     *
     * @param action new value of the action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Generates a log with the given information
     * 
     * @param actioner actioner of the log
     * @param actionerName name of the log actioner
     * @param action action of the log
     */
    public Log(String actioner,String actionerName, String action) {
        LocalDateTime datetime1 = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.dateTime = datetime1.format(format);
        this.actioner = actioner;
        this.actionerName = actionerName;
        this.action = action;
    }
    
    
}
