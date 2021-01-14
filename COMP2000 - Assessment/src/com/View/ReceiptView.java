package com.View;

import Utils.KeyValuePair;
import com.Model.BasketModel;

import javax.swing.*;

public class ReceiptView extends AbstractView{

    private JPanel mainPanel;
    private JTextArea StockNameArea;
    private JTextArea StockPriceArea;
    private JTextField TotalCostField;
    private JTextField ChangeGivenField;
    private JLabel TotalCostLabel;
    private JLabel PaymentMethodLabel;
    private JTextField PaymentMethodField;

    public ReceiptView(){
        setContentPane(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,800);

        this.setVisible(true);

        TotalCostField.setText(String.format("$%.2f", BasketModel.getBasketSingleton().getCostTotal()));
        ChangeGivenField.setText(String.format("$%.2f", BasketModel.getBasketSingleton().getChange()));
        PaymentMethodField.setText(BasketModel.getBasketSingleton().getPaymentMethod());

        StockNameArea.setText(BasketModel.getBasketSingleton().getReceiptNames());
        StockPriceArea.setText(BasketModel.getBasketSingleton().getReceiptPrices());
    }

    @Override
    public void update(KeyValuePair data) {

    }
}
