package com.View;

import Utils.BasketDataManager;
import Utils.KeyValuePair;
import Utils.StockDataManager;
import com.Model.BasketModel;
import com.Model.StockModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KioskView extends AbstractView {
    private JTextArea StockNameArea;
    private JTextArea CheckOutArea;
    private JTextArea StockBarcodeArea;
    private JButton AddCheckoutButton;
    private JTextField AddToCheckoutField;
    private JLabel CheckoutLabel;
    private JPanel mainPanel;
    private JButton CardPayButton;
    private JButton CashPayButton;
    private JLabel TotalCostLabel;
    private JTextField TotalCostDisplay;
    private JTextArea ItemPriceArea;
    private JButton CheckoutButton;

    public KioskView(){
        setContentPane(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);

        this.setVisible(true);

        int x = StockDataManager.stocks.size();

        AddCheckoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < StockDataManager.stocks.size(); i++) {
                    if(StockDataManager.stocks.get(i).getBarcode() == Integer.parseInt(AddToCheckoutField.getText())){
                        StockModel stock = new StockModel();

                        stock.setStockName(StockDataManager.stocks.get(i).getStockName());

                        stock.setAmount(StockDataManager.stocks.get(i).getAmount());

                        stock.setPrice(StockDataManager.stocks.get(i).getPrice());

                        stock.setBarcode(StockDataManager.stocks.get(i).getBarcode());

                        BasketModel.getBasketSingleton().getBasket().add(stock);
                        BasketModel.getBasketSingleton().setCostTotal(BasketModel.getBasketSingleton().getCostTotal() +stock.getPrice());

                        CheckOutArea.append(stock.getStockName() + "\n");
                        ItemPriceArea.append(Float.toString(stock.getPrice()) + "\n");
                        TotalCostDisplay.setText(String.format("$%.2f",BasketModel.getBasketSingleton().getCostTotal()));
                        BasketModel.getBasketSingleton().setReceiptNames(CheckOutArea.getText());
                        BasketModel.getBasketSingleton().setReceiptPrices(ItemPriceArea.getText());
                    }

                    }
            }
        });
        CashPayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CashCheckoutView();
            }
        });
        CardPayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CardCheckoutView();
            }
        });
    }

    @Override
    public void update(KeyValuePair data) {

    }
}
