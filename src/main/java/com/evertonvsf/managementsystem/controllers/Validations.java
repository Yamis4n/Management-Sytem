package com.evertonvsf.managementsystem.controllers;

public class Validations {
    public static Integer tryParse(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
