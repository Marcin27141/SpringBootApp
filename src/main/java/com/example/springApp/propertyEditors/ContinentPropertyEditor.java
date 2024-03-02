package com.example.springApp.propertyEditors;

import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;

import java.beans.PropertyEditorSupport;

public class ContinentPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(Continent.values()[Integer.parseInt(text)]);
    }
}