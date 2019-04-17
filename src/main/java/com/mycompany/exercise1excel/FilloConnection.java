/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercise1excel;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Влад
 */
public class FilloConnection {
    
    private String path;
    
    private Connection connection;

    private FilloConnection(String path, Connection connection) {
        this.path = path;
        this.connection = connection;
    }
    
    public static FilloConnection createConnection(String path) {
        Fillo fillo = new Fillo();
        Connection connection = null;
        try {
            connection = fillo.getConnection(path);
        } catch (FilloException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilloConnection fc = new FilloConnection(path, connection);
        return fc;
    }
    
    public void close() {
        connection.close();
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
