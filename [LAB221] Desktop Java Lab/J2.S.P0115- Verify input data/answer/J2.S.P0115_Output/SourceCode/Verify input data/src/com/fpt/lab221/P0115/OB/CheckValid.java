/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.lab221.P0115.OB;

import java.util.Date;

/**
 *
 * @author lab026
 */
public class CheckValid {

    public boolean ckCharCode(String test) {
        if (test.contains("@")) {
            return false;
        }
        if (test.contains("#")) {
            return false;
        }
        if (test.contains("$")) {
            return false;
        }
        if (test.contains(" ")) {
            return false;
        }
        return true;
    }

    public boolean ckValidBirthDate(String test) {
        if (test.length() != 10) {
            return false;
        }
        if (!Character.isDigit(test.charAt(0))) {
            return false;
        }
        if (!Character.isDigit(test.charAt(1))) {
            return false;
        }
        if (test.charAt(2) != '/') {
            return false;
        }
        if (!Character.isDigit(test.charAt(3))) {
            return false;
        }
        if (!Character.isDigit(test.charAt(4))) {
            return false;
        }
        if (test.charAt(2) != '/') {
            return false;
        }
        if (!Character.isDigit(test.charAt(6))) {
            return false;
        }
        if (!Character.isDigit(test.charAt(7))) {
            return false;
        }
        if (!Character.isDigit(test.charAt(8))) {
            return false;
        }
        if (!Character.isDigit(test.charAt(9))) {
            return false;
        }
        return true;
    }

    public boolean ckDateIsExist(String test) {
        String sub1 = test.substring(0, 2);
        String sub2 = test.substring(3, 5);
        if (Integer.parseInt(sub1) > 12) {
            return false;
        }
        if (Integer.parseInt(sub2) > 31) {
            return false;
        }
        if (Integer.parseInt(sub1) == 1) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        if (Integer.parseInt(test.substring(6, 10)) % 4 == 0) {
            if (Integer.parseInt(sub1) == 2) {
                if (Integer.parseInt(sub2) >= 29) {
                    return false;
                }
            }
        } else if (Integer.parseInt(sub1) == 2) {
            if (Integer.parseInt(sub2) >= 28) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 3) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 4) {
            if (Integer.parseInt(sub2) >= 31) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 5) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 6) {
            if (Integer.parseInt(sub2) >= 31) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 7) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 8) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 9) {
            if (Integer.parseInt(sub2) >= 31) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 10) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 11) {
            if (Integer.parseInt(sub2) >= 31) {
                return false;
            }
        }
        if (Integer.parseInt(sub1) == 12) {
            if (Integer.parseInt(sub2) >= 32) {
                return false;
            }
        }
        return true;
    }

    public boolean ckValidPhone(String test) {
        for (int i = 0; i < test.length(); i++) {
            if (!Character.isDigit(test.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean ckCharEmail(String test) {
        if (test.contains("!")) {
            return false;
        }
        if (test.contains("#")) {
            return false;
        }
        if (test.contains("$")) {
            return false;
        }
        return true;
    }

    public boolean ckValidEmail(String test) {
        int cnt = 0;
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == '@') {
                cnt++;
            }
            if (test.charAt(0) == '@') {
                return false;
            }
        }
        if (cnt != 1) {
            return false;
        }
        return true;
    }

    public boolean ckValidName(String test) {
        if (!test.matches("[A-Za-z ]*")) {
            return false;
        }
        return true;
    }

    public boolean ckBirthDate(String test) {
        String sub1 = test.substring(0, 2);
        String sub2 = test.substring(3, 5);
        Date date = new Date();
        int day = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        String date1 = test.substring(6, 10);
        if (Integer.parseInt(date1) > year) {
            return false;
        }
        if (Integer.parseInt(date1) == year) {
            if (Integer.parseInt(sub1) > month) {
                return false;
            }
        }
        if (Integer.parseInt(date1) == year) {
            if (Integer.parseInt(sub1) == month) {
                if (Integer.parseInt(sub2) > day) {
                    return false;
                }
            }
        }
        return true;
    }
}
