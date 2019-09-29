/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.*;
import java.util.ArrayList;

/**
 *
 * @author hnamn
 */
public class Run {
    main Fm;
    AddCourses Fa;
    Search Fs;
    Display Fd;

    public Run(main Fm, AddCourses Fa, Search Fs, Display Fd) {
        this.Fm = Fm;
        this.Fa = Fa;
        this.Fs = Fs;
        this.Fd = Fd;
    }
    
    public boolean checkToAdd(ArrayList<course> cs, course c) {
        boolean flag = true;
        for (course c1 : cs) {
            if (c1.getCode().equals(c.getCode())) {
                flag =!flag;
            }
        }
        if (c.getName().isEmpty() || c.getCode().isEmpty() || c.getCredit().isEmpty()) {
            flag =!flag;
        }
        try {
            Integer.parseInt(c.getCredit());
        } catch (Exception e) {
            flag =!flag;
        }
        return flag;
    }
    
    public void Controller(ArrayList<course> sc){
        
    }
    
    
    public static void main(String[] args) {
        
    }
}
