
package com.csfrancis555.chaoticnoisepatterns;


public class ChaoticJSON {
    private String name;
    private double[][] pattern;

    public ChaoticJSON() {
    }

    public ChaoticJSON(String name, double[][] pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[][] getPattern() {
        return pattern;
    }

    public void setPattern(double[][] pattern) {
        this.pattern = pattern;
    }

}
