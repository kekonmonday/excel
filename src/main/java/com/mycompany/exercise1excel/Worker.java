/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercise1excel;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

/**
 *
 * @author Влад
 */
public class Worker {
    
    private static Worker worker;
    
    private Worker() {}
    
    public static Worker getInstance() {
        if (worker == null) {
            worker = new Worker();
        }
        return worker;
    }
    
    public void createTable(FilloConnection fc, String name, String columns) {
        try {
            fc.getConnection().createTable(name, columns.split(", "));
        } catch (FilloException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fc.close();
        }
    }
    
    public void deleteTable(FilloConnection fc, String name) {
        try {
            fc.getConnection().deleteTable(name);
        } catch (FilloException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fc.close();
        }
    }
    
    public String execute(FilloConnection fc, String sql) {
        if (!Validator.getInstance().validate(sql)) {
            return null;
        }
        char firstChar = sql.charAt(0);
        if (firstChar == 's' || firstChar == 'S') {
            return select(fc, sql);
        }
        try {
            fc.getConnection().executeUpdate(sql);
        } catch (FilloException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fc.close();
        }
        return null;
    }

    private String select(FilloConnection fc, String sql) {
        StringBuilder builder = new StringBuilder();
        Recordset rs = null;
        try {
            rs = fc.getConnection().executeQuery(sql);
            ArrayList<String> fields = rs.getFieldNames();
            while (rs.next()) {
                for (String field : fields) {
                    builder.append(rs.getField(field) + " ");
                }
                builder.append("\n");
            }
        } catch (FilloException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            fc.close();
        }
        return builder.toString();
    }
     
}
