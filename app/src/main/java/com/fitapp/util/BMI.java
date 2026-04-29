// Autor: Selina Weber | Letzte Änderung: 29.04.2026
package com.fitapp.util;
import static java.lang.Math.round;

import java.io.Serializable;

public class BMI implements Serializable{
    public double kilo;
    public double groesse;
    public BMI  (double kilo, double groesse){
        this.kilo = kilo;
        this.groesse = groesse;

    }
    public double berechnen (double kilo, double groesse){
        double groesseM = groesse/100.0;
        double bmiresult = Math.round((kilo / Math.pow(groesseM, 2)) * 100.0) / 100.0;

        return bmiresult;
    }


}
