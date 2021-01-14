package com.View;

import Utils.AdminDataManager;
import Utils.KeyValuePair;
import Utils.StockDataManager;
import com.Model.AdminModel;
import com.Model.StockModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditStockView extends AbstractView{
    private JLabel EditStockTitle;
    private JTextField AmountField;
    private JTextField NameField;
    private JTextField PriceField;
    private JTextField BarcodeField;
    private JButton AddStockButton;
    private JButton EditStockButton;
    private JPanel mainPanel;
    private JLabel NameLabel;
    private JLabel AmountLabel;
    private JLabel PriceLabel;
    private JLabel BarcodeLabel;
    private JTextArea StockDisplayArea;
    private JTextArea BarcodeDisplayArea;
    private JTextField BarcodeSelector;

    public EditStockView(){
        setContentPane(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,400);

        this.setVisible(true);

        int x = StockDataManager.stocks.size();

        StockDisplayArea.setText("");

        for(int i = 0; i < x ; i++){
            String TempStockName = StockDataManager.stocks.get(i).getStockName() + "\n";
            StockDisplayArea.append(TempStockName);

            String TempStockBarcode = StockDataManager.stocks.get(i).getBarcode() + "\n";
            BarcodeDisplayArea.append(TempStockBarcode);
        }

        AddStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                StockModel stock = new StockModel();
                stock.setStockName(NameField.getText());

                int AmountToInt = Integer.parseInt(AmountField.getText());
                stock.setAmount(AmountToInt);

                float PriceToFloat = Float.parseFloat(PriceField.getText());
                stock.setPrice(PriceToFloat);

                int BarcodeToInt = Integer.parseInt((BarcodeField.getText()));
                stock.setBarcode(BarcodeToInt);

                StockDataManager.stocks.add(stock);

                StockDataManager.Update(StockDataManager.stocks);

                StockDisplayArea.append(stock.getStockName() + "\n");
                BarcodeDisplayArea.append(stock.getBarcode() + "\n");

            }

        });
        EditStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < StockDataManager.stocks.size(); i++) {
                    if(StockDataManager.stocks.get(i).getBarcode() == Integer.parseInt(BarcodeSelector.getText())){
                        StockModel stock = new StockModel();

                        stock.setStockName(NameField.getText());

                        int AmountToInt = Integer.parseInt(AmountField.getText());
                        stock.setAmount(AmountToInt);

                        float PriceToFloat = Float.parseFloat(PriceField.getText());
                        stock.setPrice(PriceToFloat);

                        int BarcodeToInt = Integer.parseInt((BarcodeField.getText()));
                        stock.setBarcode(BarcodeToInt);

                        StockDataManager.stocks.set(i, stock);
                        StockDataManager.Update(StockDataManager.stocks);

                        StockDisplayArea.append(stock.getStockName() + "\n");
                        BarcodeDisplayArea.append(stock.getBarcode() + "\n");

                        i = StockDataManager.stocks.size();
                    }

                }

            }
        });
    }

    @Override
    public void update(KeyValuePair data) {

    }
}
