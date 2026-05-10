// Autor: Selina Weber | Letzte Änderung: 10.05.2026
package com.fitapp.util;

import java.io.Serializable;

public class BMI implements Serializable {
    public double kilo;
    public double groesse;

    public BMI(double kilo, double groesse) {
        this.kilo = kilo;
        this.groesse = groesse;
    }

    public static final BMIKategorien[] kategorien = {
        new BMIKategorien("untergewichtig", "sehr stark",           -1,   15.0),
        new BMIKategorien("untergewichtig", "stark",                15.0, 16.0),
        new BMIKategorien("untergewichtig", "mässig",               16.0, 17.0),
        new BMIKategorien("untergewichtig", "leicht",               17.0, 18.5),
        new BMIKategorien("normalgewichtig", "",                    18.5, 25.0),
        new BMIKategorien("übergewichtig",  "",                     25.0, 30.0),
        new BMIKategorien("fettleibig", "mässig (Grad I)",          30.0, 35.0),
        new BMIKategorien("fettleibig", "stark (Grad II)",          35.0, 40.0),
        new BMIKategorien("fettleibig", "sehr stark (Grad III)",    40.0, -1)
    };


    public double berechnen(double kilo, double groesse) {
        double groesseM = groesse / 100.0;
        return Math.round((kilo / Math.pow(groesseM, 2)) * 100.0) / 100.0;
    }
}