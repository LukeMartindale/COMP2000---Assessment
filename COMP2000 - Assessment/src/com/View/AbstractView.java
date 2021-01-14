package com.View;

import com.Controller.AbstractController;
import Utils.KeyValuePair;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractView extends JFrame {

    protected AbstractController controller;

    protected void initialise(int rows, int cols){
        this.setLayout(new GridLayout(rows,cols));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(700,700));

        this.setVisible(true);
    }

    public void setController(AbstractController controller){
        this.controller = controller;
    }

    public abstract void update(KeyValuePair data);

}
