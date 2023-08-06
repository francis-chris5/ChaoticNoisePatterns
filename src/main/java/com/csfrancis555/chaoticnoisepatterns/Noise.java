
package com.csfrancis555.chaoticnoisepatterns;

import java.util.Random;


public abstract class Noise {
    protected double[][] pattern;
    protected int width;
    protected int height;

    public Noise(int width, int height) {
        this.pattern = new double[width][height];
        this.width = width;
        this.height = height;
        Random rand = new Random();
        for(int i=0; i<this.pattern.length; i++){
            for(int j=0; j<this.pattern[i].length; j++){
                double value = rand.nextDouble();
                this.pattern[i][j] = value;
            }
        }
    }

    public double[][] getPattern() {
        return pattern;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
