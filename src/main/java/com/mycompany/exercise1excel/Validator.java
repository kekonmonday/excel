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
public class Validator {
    
    private static Validator validator;
    
    private Validator() {}
    
    public static Validator getInstance() {
        if (validator == null) {
            validator = new Validator();
        }
        return validator;
    }
    
    public boolean validate(String sql) {
        return true;
    }
    
}
