
package com.csfrancis555.chaoticnoisepatterns;


public class Chaos {
    private double[][] pattern;
    private int width;
    private int height;

    public Chaos(int width, int height) {
        this.width = width;
        this.height = height;
        this.pattern = new double[this.width][this.height];
    }

    
    
    
    private double logistic(double a, double x){
        return a * x * (1 - x);
    }
    
    public double[][] getLogisticModel(double a, double x){
        double value = x;
        for(int i=0; i<pattern.length; i++){
            for(int j=0; j<pattern[i].length; j++){
                value = logistic(a, value);
                pattern[i][j] = value;
            }
        }
        return this.pattern;
    }
    
    
    
    private double waveOrbit(double x, double t){
        return Math.abs(Math.cos(t*x));
    }
    
    public double[][] getWaveOrbit(double x, double t){
        double value = x;
        for(int i=0; i<pattern.length; i++){
            for(int j=0; j<pattern[i].length; j++){
                value = waveOrbit(value, i*t);
                pattern[i][j] = value;
            }
        }
        return this.pattern;
    }
    
    
    
    private double[] lorenzOrbit(double s, double r, double b, double x, double y, double z){
        double[] lorenz = {x, y, z};
        double time = 0.01;
        lorenz[0] += (s * (y - x)) * time;
        lorenz[1] += (r * x - y - x * z) * time;
        lorenz[2] += (x * y - b * z) * time;
        return lorenz;
    }
    public double[][] getLorenzMap(double s, double r, double b, double x, double y, double z){
        double[] values = {x, y, z};
        for(int i=0; i<pattern.length; i++){
            for(int j=0; j<pattern.length; j++){
                values = lorenzOrbit(s, r, b, values[0], values[1], values[2]);
                double average = (values[0] + values[1] + values[2]) / 3.0;
                while(average < 0.01){
                    average *= 100;
                }
                pattern[i][j] = average;
            }
        }
        return this.pattern;
    }
}
