package com.Model;

import com.Controller.AbstractController;
import Utils.KeyValuePair;

public interface IModelSubject {
    void add(AbstractController observer);
    void remove(AbstractController observer);
    void onPropertyChanged(KeyValuePair data);
}
