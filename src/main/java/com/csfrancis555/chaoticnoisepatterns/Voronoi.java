
package com.csfrancis555.chaoticnoisepatterns;

import java.util.Random;


public class Voronoi extends Noise {
    private double[][] seed;
    private int grid;

    public Voronoi(int width, int height, int grid, double[][] noise) {
        super(width, height);
        this.seed = new double[this.width][this.height];
        this.pattern = new double[this.width][this.height];
        this.grid = grid;
        setSeed(noise);
        setPatterns();
    }
    
    private void setSeed(double[][] noise){
        for(int i=0; i<seed.length; i++){
            for(int j=0; j<seed[i].length; j++){
                seed[i][j] = 0;
            }
        }
        Random rand = new Random();
        int[] cellSize = {width/grid, height/grid};
//        for(int i=0; i<grid-1; i++){
//            for(int j=0; j<grid-1; j++){
//                int x = rand.nextInt(cellSize[0]);
//                int y = rand.nextInt(cellSize[1]);
//                int point = (int)Math.sqrt(x*x + y*y);
//                seed[i*cellSize[0]+point][j*cellSize[1]+point] = 1;
//            }
//        }
        

        for(int i=0; i<grid-1; i++){
            for(int j=0; j<grid-1; j++){
                int x = rand.nextInt(cellSize[0]);
                int y = rand.nextInt(cellSize[1]);
                double percent = noise[x][y];
                seed[i*cellSize[0]+(int)(percent*cellSize[0])][j*cellSize[1]+(int)(percent*cellSize[0])] = 1;
            }
        }
    }
    
    
    private void setPatterns(){
        double[][] cells = new double[(grid)*(grid)][2];
        int u=0;
        for(int i=0; i<seed.length; i++){
            for(int j=0; j<seed[i].length; j++){
                if(seed[i][j] != 0){
                    cells[u] = new double[] {i, j};
                    u++;
                }
            }
        }

        
        for(int i=0; i<seed.length; i++){
            for(int j=0; j<seed[i].length; j++){
                double min = Double.MAX_VALUE;
                for(int c=0; c<cells.length; c++){
                    double distance = Math.sqrt((i-cells[c][0])*(i-cells[c][0]) + (j-cells[c][1])*(j-cells[c][1]));
                    if(distance < min){
                        min = distance;
                        if(distance/(grid*grid*2) > 0.08){
                            pattern[i][j] = distance/(grid*grid*2);
                        }
                        else{
                            pattern[i][j] = 0.08;
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<pattern.length; i++){
            for(int j=0; j<pattern[i].length; j++){
                if(pattern[i][j] > 1){
                    pattern[i][j] -= 1;
                }
            }
        }
    }
}
