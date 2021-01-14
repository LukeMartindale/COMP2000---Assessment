package com.View;

import Utils.KeyValuePair;
import com.Model.BasketModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashCheckoutView extends AbstractView{
    private JLabel CheckoutTitle;
    private JTextArea ItemDisplayArea;
    private JButton payButton;
    private JTextField AmountToPayField;
    private JLabel TipLabel;
    private JPanel mainPanel;

    public CashCheckoutView(){
        setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,450);

        this.setVisible(true);

        ItemDisplayArea.setText(String.format("$%.2f",BasketModel.getBasketSingleton().getCostTotal()));

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float num = BasketModel.getBasketSingleton().getCostTotal();
                float num2 = Float.parseFloat(AmountToPayField.getText());
                BasketModel.getBasketSingleton().setChange(num2-num);

                BasketModel.getBasketSingleton().setPaymentMethod("Cash");


                dispose();
                new ReceiptView();
            }
        });
    }

    @Override
    public void update(KeyValuePair data) {

    }
}
