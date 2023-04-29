/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu002045.framework;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kodar
 */
public class DateEditor extends PropertyEditorSupport{
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(dateFormat.parse(text));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Format de date invalide");
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? dateFormat.format(value) : "");
    }
}
