package com.Model;

import com.Controller.AbstractController;
import Utils.KeyValuePair;

import java.util.ArrayList;

public class StockModel implements IModelSubject{

    private String StockName;
    private int Amount;
    private float Price;
    private int Barcode;

    private final ArrayList<AbstractController> observers = new ArrayList<>();

    //Getters & Setters

    public String getStockName(){
        return StockName;
    }

    public void setStockName(String StockName){
        this.StockName = StockName;
        onPropertyChanged(new KeyValuePair(AbstractController.STOCK_NAME, this.StockName));
    }

    public int getAmount(){
        return Amount;
    }

    public void setAmount(int Amount){
        this.Amount = Amount;
        onPropertyChanged(new KeyValuePair(AbstractController.AMOUNT, this.Amount));
    }

    public float getPrice(){
        return Price;
    }

    public void setPrice(float Price){
        this.Price = Price;
        onPropertyChanged(new KeyValuePair(AbstractController.PRICE, this.Price));
    }

    public int getBarcode(){
        return Barcode;
    }

    public void setBarcode(int Barcode){
        this.Barcode = Barcode;
        onPropertyChanged(new KeyValuePair(AbstractController.BARCODE, this.Barcode));
    }

    @Override
    public void add(AbstractController observer) {
        observers.add(observer);
    }

    @Override
    public void remove(AbstractController observer) {
        observers.remove(observer);
    }

    @Override
    public void onPropertyChanged(KeyValuePair data) {
        for(AbstractController observer : observers){
            observer.updateView(data);
        }
    }
}
