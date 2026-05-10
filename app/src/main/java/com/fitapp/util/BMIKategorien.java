// Autor: Selina Weber | Letzte Änderung: 10.05.2026
package com.fitapp.util;

public class BMIKategorien {
    public String allgemein;
    public String spezifisch;
    public double min;
    public double max;

    public BMIKategorien(String allgemein, String spezifisch, double min, double max) {
        this.allgemein = allgemein;
        this.spezifisch = spezifisch;
        this.min = min;
        this.max = max;
    }
}
