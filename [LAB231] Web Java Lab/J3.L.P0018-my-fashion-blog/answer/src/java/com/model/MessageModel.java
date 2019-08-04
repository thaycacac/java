/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.connect.DBContext;
import com.entity.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author thuongnnse05095
 */
public class MessageModel {

    private final DBContext db;
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z0-9]{2,})$", Pattern.CASE_INSENSITIVE);

    public MessageModel() throws Exception {
        db = new DBContext();
    }

    public void insertDB(Message data) throws Exception {
        String query = "INSERT INTO Message(name,email,message) values(?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, data.getName());
            ps.setString(2, data.getEmail());
            ps.setString(3, data.getMessage());

            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            new CloseConnection().close(conn, ps, null);
        }
    }

    public boolean checkEmail(String input) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(input);

        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean checkNull(String input){
        if(input.trim().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
