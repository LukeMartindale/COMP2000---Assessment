package com.View;

import Utils.KeyValuePair;
import Utils.StockDataManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockView extends AbstractView{
    private JTextField StockBox;
    private JPanel mainPanel;
    private JLabel StockTitle;
    private JTextArea StockBarcodeArea;
    private JButton LoadStockButton;
    private JTextArea StockNameArea;
    private JTextArea StockAmountArea;
    private JTextArea StockPriceArea;
    private JLabel StockLabel;
    private JLabel AmountLabel;
    private JLabel PriceLabel;
    private JLabel BarcodeLabel;
    private JButton EditStockButton;

    public StockView(){
        setContentPane(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);

        this.setVisible(true);

        LoadStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = StockDataManager.stocks.size();



                StockNameArea.setText("");
                StockAmountArea.setText("");
                StockPriceArea.setText("");
                StockBarcodeArea.setText("");

                for(int i = 0; i < x ; i++){
                    String TempStockName = StockDataManager.stocks.get(i).getStockName() + "\n";
                    StockNameArea.append(TempStockName);

                    String TempStockAmount = StockDataManager.stocks.get(i).getAmount() + "\n";
                    StockAmountArea.append(TempStockAmount);

                    String TempStockPrice = StockDataManager.stocks.get(i).getPrice() + "\n";
                    StockPriceArea.append(TempStockPrice);

                    String TempStockBarcode = StockDataManager.stocks.get(i).getBarcode() +"\n";
                    StockBarcodeArea.append(TempStockBarcode);
                }
            }
        });

        EditStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditStockView();
            }
        });
    }

    @Override
    public void update(KeyValuePair data) {

    }

}
