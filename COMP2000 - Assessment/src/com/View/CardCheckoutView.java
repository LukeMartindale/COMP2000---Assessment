package com.View;

import Utils.KeyValuePair;
import com.Model.BasketModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardCheckoutView extends AbstractView{

    private JLabel CheckoutTitle;
    private JTextArea CostDisplayArea;
    private JLabel AmountopayLabel;
    private JLabel Tooltip;
    private JTextField PinNumberField;
    private JButton payButton;
    private JPanel mainPanel;

    public CardCheckoutView(){

        setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,450);

        this.setVisible(true);

        CostDisplayArea.setText(String.format("$%.2f", BasketModel.getBasketSingleton().getCostTotal()));

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasketModel.getBasketSingleton().setPaymentMethod("Card");
                dispose();
                new ReceiptView();

            }
        });
        
    }

    @Override
    public void update(KeyValuePair data) {

    }
}
