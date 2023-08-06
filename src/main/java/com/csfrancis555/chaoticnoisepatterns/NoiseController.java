
package com.csfrancis555.chaoticnoisepatterns;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoiseController {
    
    
    @RequestMapping("/get-chaos")
    public List<ChaoticJSON> getNoisePatterns(
            @RequestParam String type,
            @RequestParam String limits, 
            @RequestParam String pattern, 
            @RequestParam String logStart, 
            @RequestParam String cosStart,
            @RequestParam String cosTime,
            @RequestParam String lorS,
            @RequestParam String lorR,
            @RequestParam String lorB,
            @RequestParam String lorX,
            @RequestParam String lorY,
            @RequestParam String lorZ
    ){
        List<ChaoticJSON> chaos = new ArrayList<>();
        double logisticStart = Double.parseDouble(logStart);
        double waveStart = Double.parseDouble(cosStart);
        double waveTime = Double.parseDouble(cosTime);
        double lorenzS = Double.parseDouble(lorS);
        double lorenzR = Double.parseDouble(lorR);
        double lorenzB = Double.parseDouble(lorB);
        double lorenzX = Double.parseDouble(lorX);
        double lorenzY = Double.parseDouble(lorY);
        double lorenzZ = Double.parseDouble(lorZ);
        int limit = Integer.parseInt(limits) + 1;
        int width = (int)Math.pow(2, Integer.parseInt(limits));
        int height = (int)Math.pow(2, Integer.parseInt(limits));
        double[][] noise = new double[width][height];
        if(pattern.equals("logistic")){
            noise = new Chaos(width, height).getLogisticModel(4.0, logisticStart);
        }
        else if(pattern.equals("waveOrbit")){
            noise = new Chaos(width, height).getWaveOrbit(waveStart, waveTime);
        }
        else if(pattern.equals("lorenzMap")){
            noise = new Chaos(width, height).getLorenzMap(lorenzS, lorenzR, lorenzB, lorenzX, lorenzY, lorenzZ);
        }
        if(type.equals("noise")){
            chaos.add(new ChaoticJSON("noise", noise));
        }
        else if(type.equals("perlin")){
            chaos.add(new ChaoticJSON("perlin", new Perlin(width, height, limit, 2.0, noise).getPattern()));
        }
        else if(type.equals("voronoi")){
            chaos.add(new ChaoticJSON("voronoi", new Voronoi(width, width, 8, noise).getPattern()));
        }
        else if(type.equals("perlinStripes")){
            double[][] perlin = new Perlin(width, height, limit, 2.0, noise).getPattern();
            double[][] perlinStripes = new double[width][height];
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    perlinStripes[i][j] = perlin[i][height/2];
                }
            }
            chaos.add(new ChaoticJSON("perlinStripes", perlinStripes));
        }
        else if(type.equals("voronoiStripes")){
            double[][] voronoi = new Voronoi(width, width, 8, noise).getPattern();
            double[][] voronoiStripes = new double[width][height];
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    voronoiStripes[i][j] = voronoi[i][height/2];
                }
            }
            chaos.add(new ChaoticJSON("voronoiStripes", voronoiStripes));
        }
        return chaos;
    }//end getNoisePattern()
    
    
      
    
}//end NoiseController class
