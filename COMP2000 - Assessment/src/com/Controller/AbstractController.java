package com.Controller;

import Utils.KeyValuePair;

public abstract class AbstractController {

    public static final String ADMIN_NAME = "AdminName";
    public static final String PASSWORD = "Password";
    public static final String AUTHENTICATE ="Authenticate";
    public static final String STOCK_NAME = "StockName";
    public static final String AMOUNT = "Amount";
    public static final String PRICE = "Price";
    public static final String BARCODE ="Barcode";
    public static final String COST_TOTAL = "CostTotal";

    public abstract void setModelProperty(KeyValuePair data);
    public abstract void updateView(KeyValuePair data);
    public void swapModel(int index){}
}
