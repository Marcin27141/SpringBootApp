package com.example.springApp.propertyEditors;

import com.example.springApp.model.Diet;

import java.beans.PropertyEditorSupport;

public class DietPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(Diet.values()[Integer.parseInt(text)]);
    }
}