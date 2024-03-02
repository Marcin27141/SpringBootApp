package com.example.springApp.propertyEditors;

import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;

import java.beans.PropertyEditorSupport;

public class ConservationPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(ConservationStatus.values()[Integer.parseInt(text)]);
    }
}