package com.Controller;

import Utils.AdminDataManager;
import Utils.KeyValuePair;
import com.Model.AdminModel;
import com.View.AbstractView;

import java.lang.reflect.Method;

public class LoginController extends AbstractController{

    AdminModel model;
    AbstractView view;

    private final Method[] modelMethods;

    public LoginController(AdminModel newModel, AbstractView newView){
        model = newModel;
        view = newView;

        model.add(this);
        view.setController(this);

        modelMethods = model.getClass().getDeclaredMethods();
    }

    public boolean Login(){

        String Name = model.getAdminName();
        String Password = model.getPassword();

        for(AdminModel admin : AdminDataManager.admins){
            if(admin.getAdminName().equals(Name) && admin.getPassword().equals(Password)){
                System.out.println("True");
                return true;
            }

        }
        System.out.println("False");
        return false;
    }

    @Override
    public void setModelProperty(KeyValuePair data) {
        try{
            String methodName = "set" + data.Key;
            for(Method method : modelMethods){
                if(method.getName().equals(methodName)){
                    if(data.Key.equals(AUTHENTICATE)){
                        data.Value = Login();
                    }
                    method.invoke(model, data.Value);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    @Override
    public void updateView(KeyValuePair data) {
        view.update(data);

    }

}
