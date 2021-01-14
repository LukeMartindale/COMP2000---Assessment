package com.Model;

import com.Controller.AbstractController;
import Utils.KeyValuePair;
import java.util.ArrayList;

public class AdminModel implements IModelSubject{

    private String AdminName;
    private String Password;
    private Boolean Authenticate;

    private final ArrayList<AbstractController> observers = new ArrayList<>();

    //Getters & Setters

    public String getAdminName(){
        return  AdminName;
    }

    public void setAdminName(String AdminName){
        this.AdminName = AdminName;
        onPropertyChanged(new KeyValuePair(AbstractController.ADMIN_NAME, this.AdminName));
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
        onPropertyChanged(new KeyValuePair(AbstractController.PASSWORD, this.Password));
    }

    public Boolean getAuthenticate() {
        return Authenticate;
    }

    public void setAuthenticate(Boolean authenticate) {
        this.Authenticate = authenticate;
        onPropertyChanged(new KeyValuePair(AbstractController.AUTHENTICATE, this.Authenticate));
    }

    //Override Functions

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
