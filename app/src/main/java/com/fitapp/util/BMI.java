package com.fitapp.util;
import java.io.Serializable;

public class BMI implements Serializable{
    public double kilo;
    public double groesse;
    public BMI  (double kilo, double groesse){


    }
    public double berechnen (double kilo, double groesse){
        double groesseM = groesse/100;
        double bmiresult = kilo/Math.pow(groesseM, 2);

        return bmiresult;
    }


}
