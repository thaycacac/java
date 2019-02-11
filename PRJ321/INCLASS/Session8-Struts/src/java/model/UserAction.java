/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author duongtb
 */
public class UserAction extends ActionSupport {

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String executeXYZ() throws Exception
    {
        fullName = firstName + ", " + lastName;
        return SUCCESS;
    }
    
    private String firstName;
    private String lastName;
    private String fullName;
    
    public String getFullName()
    {
        return fullName;
    }
    
    public void validate()
    {
        if (!firstName.equalsIgnoreCase("Tran"))
        {
            addFieldError("firstName", "You must input 'Tran' as a first name");
        }
        
    }
}
