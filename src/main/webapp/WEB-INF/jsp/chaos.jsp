
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Chaotic Noise Patterns</title>
        <link rel="stylesheet" type="text/css" href="/css/chaos.css"/>
        <script src="/js/chaos.js"></script>
    </head>
    <body onload="init()">
        <section class="inputs">
            <p>Limits: <input type="number" value="9" name="limits" id="limits"/> <small>This is the power of 2 to indicate noise texture size, for example 9 --> 2^9 = 512 x 512 noise texture</small></p> 
            <ul> <b>Noise Pattern</b>
                <li>
                    <input type="radio" value="logistic" id="logistic" name="pattern" onchange="showParameterChoices()" checked/> Logistics Equation
                    <br>
                    <section class="parameters" id="logisticParameters">
                        &nbsp; &nbsp; &nbsp; Starting Value: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="logStart" id="logStart" value="0.1"/>
                    </section>
                </li>
                <li>
                    <input type="radio" value="waveOrbit" id="waveOrbit" name="pattern" onchange="showParameterChoices()"/> Cosine Wave Orbit with Time
                    <br>
                    <section class="parameters" id="waveParameters">
                        &nbsp; &nbsp; &nbsp; Starting Value: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="cosStart" id="cosStart" value="0.123"/>
                        <br>
                        &nbsp; &nbsp; &nbsp; Starting Time <input type="number" min="0" step="0.00001" name="cosTime" id="cosTime" value="1"/>
                    </section>
                </li>
                <li><input type="radio" value="lorenzMap" id="lorenzMap" name="pattern" onchange="showParameterChoices()"/> Lorenz Mapping (scaled)</li>
                <br>
                    <section class="parameters" id="lorenzParameters">
                        &nbsp; &nbsp; &nbsp; s: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="lorS" id="lorS" value="0.9"/>
                        <br>
                        &nbsp; &nbsp; &nbsp; r: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="lorR" id="lorR" value="0.8"/>
                        <br>
                        &nbsp; &nbsp; &nbsp; b: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="lorB" id="lorB" value="0.7"/>
                        <br>
                        &nbsp; &nbsp; &nbsp; x: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="lorX" id="lorX" value="0.1"/>
                        <br>
                        &nbsp; &nbsp; &nbsp; y: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="lorY" id="lorY" value="0.2"/>
                        <br>
                        &nbsp; &nbsp; &nbsp; z: <input type="number" min="0.00001" max="0.99999" step="0.00001" name="lorZ" id="lorZ" value="0.3"/>
                    </section>
            </ul>
            <br>
            <ul><b>Noise Type</b>
                <li><input type="radio" name="type" id="noise" value="noise" checked/>Noise</li>
                <li><input type="radio" name="type" id="perlin" value="perlin"/>Perlin</li>
                <li><input type="radio" name="type" id="voronoi" value="voronoi"/>Voronoi</li>
                <li><input type="radio" name="type" id="perlinStripes" value="perlinStripes"/>PerlinStripes</li>
                <li><input type="radio" name="type" id="voronoiStripes" value="voronoiStripes"/>VoronoiStripes</li>
            </ul>
            <p><button onclick="getPattern()">Get Noise</button></p>
        </section>
        <br><br>
        <!--<p><button onclick="showJSON()">Show Point Data</button></p>-->
        <section>
            <p id="label"></p>
            <section width="64" height="64" name="previewCell" id="previewCell">
                <canvas width="64" height="64" id="preview">
                </canvas>
            </section>
            <textarea rows="20" cols="40" id="textDisplay" readonly></textarea>
        </section>
    </body>
</html>
