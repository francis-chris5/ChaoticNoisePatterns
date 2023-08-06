
package com.csfrancis555.chaoticnoisepatterns;

import java.util.ArrayList;


public class SVGWriter {
    private String xmlTag = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n";
    private ArrayList<String> shapes = new ArrayList<>();
    private int width;
    private int height;

    public SVGWriter(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String getXmlTag() {
        return xmlTag;
    }
    
    public String startSvgTag(){
        String SVGTag = "<svg\n\txmlns=\"http://www.w3.org/2000/svg\"\n\twidth=\"" + this.width + "\"\n\theight=\"" + this.height + "\">\n\n";
        return SVGTag;
    }
    
    public String endSvgTag(){
        return "</svg>";
    }
    
    
    
    public String addPath(String hashColor, double[][] points){
        String SVGTag = "\t<path style=\"fill: none; stroke: " + hashColor + "; stroke-width: 1.0; stroke-opacity: 0.4\"\n";
        SVGTag += "\t\td=\"m ";
        SVGTag += points[0][0] + "," + points[0][1] + " c ";
        for(int p=1; p<points.length; p++){
            if(p == points.length-1){
                SVGTag += points[p][0] + "," + points[p][1];
            }
            else{
                SVGTag += points[p][0] + "," + points[p][1] + " ";
            }
        }
        SVGTag += "\" />\n\n";
        
        return SVGTag;
    }
    
    
    
    public String addPoint(String hashColor, double[] center, double radius){
        String SVGTag = "\t<circle style=\"fill: " + hashColor + "; fill-opacity: 0.3; stroke: none;\"\n";
        SVGTag += "\t\tcx=\"" + center[0] + "\"\n";
        SVGTag += "\t\tcy=\"" + center[1] + "\"\n";
        SVGTag += "\t\tr=\"" + radius + "\"";
        SVGTag += "/>\n\n";
        return SVGTag;
    }

}
