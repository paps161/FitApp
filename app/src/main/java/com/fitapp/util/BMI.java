package com.fitapp.util;
import java.io.Serializable;

public class BMI implements Serializable{
    public int kilo;
    public int groesse;
    public BMI  (int kilo, int groesse){


    }
    public double berechnen (int kilo, int groesse){
        double groesseM = groesse/100;
        double bmiresult = kilo/Math.pow(groesseM, 2);

        return bmiresult;
    }


}
