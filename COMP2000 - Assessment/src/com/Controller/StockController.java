package com.Controller;

import Utils.KeyValuePair;
import Utils.StockDataManager;
import com.Model.StockModel;
import com.View.AbstractView;

import java.lang.reflect.Method;

public class StockController extends AbstractController{
    StockModel model;
    AbstractView view;

    private final Method[] modelMethods;

    public StockController(StockModel newModel, AbstractView newView){
        model = newModel;
        view = newView;

        model.add(this);
        view.setController(this);

        modelMethods = model.getClass().getDeclaredMethods();
    }

    @Override
    public void setModelProperty(KeyValuePair data) {
        try{
            String methodName = "set" + data.Key;
            for(Method method : modelMethods){
                if(method.getName().equals(methodName)){
                    method.invoke(model, data.Value);
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateView(KeyValuePair data) {

    }
}
