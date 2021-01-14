package com.View;

import Utils.AdminDataManager;
import Utils.KeyValuePair;
import com.Controller.AbstractController;
import com.Model.AdminModel;

import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends AbstractView{

    private JPanel mainPanel;
    private JPanel LoginPanel;
    private JLabel AdminNameLBL;
    private JLabel PasswordLBL;
    private JButton loginButton;
    private JTextField UsernameField;
    private JTextField passwordField;

    private Boolean Authenticated = false;

    public LoginView(){
        setContentPane(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,400);

        this.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  controller.setModelProperty(new KeyValuePair(AbstractController.AUTHENTICATE, true));
                  if(Authenticated){
                      dispose();
                      new StockView();
                  }
            }

        });
        UsernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                controller.setModelProperty(new KeyValuePair(AbstractController.ADMIN_NAME, UsernameField.getText()));
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                controller.setModelProperty(new KeyValuePair(AbstractController.PASSWORD, passwordField.getText()));
            }
        });
    }

    @Override
    public void update(KeyValuePair data) {
        switch (data.Key){
            case AbstractController.ADMIN_NAME: {
                UsernameField.setText(data.Value.toString());
                break;
            }
            case AbstractController.PASSWORD: {
                passwordField.setText(data.Value.toString());
                break;
            }
            case AbstractController.AUTHENTICATE: {
                Authenticated = (Boolean) data.Value;
                break;
            }
        }

    }
}
