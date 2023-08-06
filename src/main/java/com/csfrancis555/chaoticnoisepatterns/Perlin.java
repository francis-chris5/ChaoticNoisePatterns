
package com.csfrancis555.chaoticnoisepatterns;

public class Perlin extends Noise{
    private double[] dropD;
    private double[] seed;
    private int octaves;
    private double bias;


    public Perlin(int width, int height, int octaves, double bias, double[][] seed) {
        super(width, height);
        this.pattern = new double[width][height];
        this.dropD = new double[width*height];
        this.seed = new double[width*height];
        this.octaves = octaves;
        this.bias = bias;
        for(int i=0; i< width; i++){
            for(int j=0; j<height; j++){
                this.seed[j*width+i] = seed[i][j];
            }
        }
//        Random rand = new Random();
//        for(int i=0; i<this.seed.length; i++){
//            this.seed[i] = rand.nextDouble();
//        }
        this.makePerlin();
    }
    
    
    private final void makePerlin(){
        for(int i=0; i<this.width; i++){
            for(int j=0; j<this.height; j++){
                double noise = 0.0;
                double scale = 1.0;
                double scaleAccumulator = 0.0;
                for(int o=0; o<this.octaves; o++){
                    int pitch = width >>> o;
                    int iSample1 = (i / pitch)*pitch;
                    int jSample1 = (j / pitch)*pitch;
                    int iSample2 = (iSample1 + pitch) % this.width;
                    int jSample2 = (jSample1 + pitch) % this.height;
                    double iBlend = (double)(i - iSample1)/(double)pitch;
                    double jBlend = (double)(j - jSample1)/(double)pitch;
                    double iMixture = (1.0-iBlend) * this.seed[jSample1*width+iSample1] + iBlend * this.seed[jSample1*width+iSample2];
                    double jMixture = (1.0-iBlend) * this.seed[jSample2*width+iSample1] + iBlend * this.seed[jSample2*width+iSample2];
                    noise += (jBlend * (jMixture - iMixture) + iMixture) * scale;
                    scaleAccumulator += scale;
                    scale = scale / this.bias;
                }
                this.dropD[j*width+i] = noise/scaleAccumulator;
            }
        }
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                pattern[i][j] = dropD[j*width+i];
            }
        }
    } 
}
