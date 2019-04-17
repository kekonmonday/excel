/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercise1excel;

/**
 *
 * @author Влад
 */
public class Table {
    
    private String path;
    
    private Worker worker;
    
    public Table(String path) {
        this.path = path;
    }
    
    public String execute(String[] sql, int typeOperation) {
        switch (typeOperation) {
            case TypeOperation.DELETE : {
                Worker.getInstance().deleteTable(FilloConnection.createConnection(path), sql[0]);
                break;
            }
            case TypeOperation.CREATE : {
                Worker.getInstance().createTable(FilloConnection.createConnection(path), sql[0], sql[1]);
                break;
            }
            case TypeOperation.EXECUTE : {
                return Worker.getInstance().execute(FilloConnection.createConnection(path), sql[0]);
            }
        }
        return null;
    }
    
}
