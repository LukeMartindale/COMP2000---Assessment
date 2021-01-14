package com.Model;

import Utils.KeyValuePair;
import com.Controller.AbstractController;

import java.util.ArrayList;

public class BasketModel extends StockModel implements IModelSubject{

    public BasketModel() {
    }

    public void setCostTotal(float costTotal) {
        CostTotal = costTotal;
    }

    private float CostTotal;
    private float Change = 0;
    private String PaymentMethod;
    private String ReceiptNames;
    private String ReceiptPrices;

    public String getReceiptNames() {
        return ReceiptNames;
    }

    public void setReceiptNames(String receiptNames) {
        this.ReceiptNames = receiptNames;
    }


    public String getReceiptPrices() {
        return ReceiptPrices;
    }

    public void setReceiptPrices(String receiptPrices) {
        this.ReceiptPrices = receiptPrices;
    }



    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.PaymentMethod = paymentMethod;
    }

    public float getChange() {
        return Change;
    }

    public void setChange(float change) {
        this.Change = change;
    }

    private static BasketModel basketSingleton;
    private ArrayList<StockModel> basket = new ArrayList<>();
    private final ArrayList<AbstractController> observers = new ArrayList<>();

    public static BasketModel getBasketSingleton(){
        if(basketSingleton == null){
            basketSingleton = new BasketModel();
        }
        return basketSingleton;
    }

    public  float getCostTotal(){
        return CostTotal;
    }

    public void setCostTotal(int CostTotal){
        this.CostTotal = CostTotal;
        onPropertyChanged(new KeyValuePair(AbstractController.COST_TOTAL, this.CostTotal));
    }

    public ArrayList<StockModel> getBasket(){
        return basket;
    }

    public void setBasket(ArrayList<StockModel> Basket){
        this.basket = Basket;
    }

    @Override
    public void add(AbstractController observer) {

    }

    @Override
    public void remove(AbstractController observer) {

    }

    @Override
    public void onPropertyChanged(KeyValuePair data) {
        for(AbstractController observer : observers){
            observer.updateView(data);
        }
    }
}
