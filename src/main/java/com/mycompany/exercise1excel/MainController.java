package com.mycompany.exercise1excel;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Влад
 */
public class MainController implements Initializable {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField columnsTextField;

    @FXML
    private TextArea sqlTextArea;
    
    private Table table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Введите путь к файлу");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        this.table = new Table(path);
    }

    @FXML
    private void createTable() {
        table.execute(new String[] {nameTextField.getText(), columnsTextField.getText()}, TypeOperation.CREATE);
    }

    @FXML
    private void deleteTable() {
        table.execute(new String[] {nameTextField.getText()}, TypeOperation.DELETE);
    }

    @FXML
    private void execute() {
        String result = table.execute(new String[] {sqlTextArea.getText()}, TypeOperation.EXECUTE);
        if (result == null) {
            sqlTextArea.setText(result);
        }
    }
    
}
