


var currentPattern;

function init(){
    showParameterChoices();
    setPreviewSize();
    
    let canvas = document.getElementById('preview');
    let sketch = canvas.getContext('2d');
    sketch.beginPath();
    sketch.fillStyle="#8F8F8F";
    sketch.fillRect(0, 0, canvas.width, canvas.height);
    sketch.closePath();
}//end init()

function setPreviewSize(){
    let limits = document.getElementById('limits').value;
    let previewCell = document.getElementById('previewCell');
    let preview = document.getElementById('preview');
    previewCell.style.width = (2**limits) + "px";
    previewCell.style.height = (2**limits) + "px";
    preview.width = (2**limits);
    preview.height = (2**limits);
}//end setIframeSize()


function showParameterChoices(){
    let logistic = document.getElementById('logisticParameters');
    let wave = document.getElementById('waveParameters');
    let lorenz = document.getElementById('lorenzParameters');
    
    if(document.getElementById('logistic').checked){
        logistic.style.display = "inline-block";
        wave.style.display = "none";
        lorenz.style.display = "none";
    }
    else if(document.getElementById('waveOrbit').checked){
        logistic.style.display = "none";
        wave.style.display = "inline-block";
        lorenz.style.display = "none";
    }
    else if(document.getElementById('lorenzMap').checked){
        logistic.style.display = "none";
        wave.style.display = "none";
        lorenz.style.display = "inline-block";
    }
}//end showParameterChoices()



async function getPattern(){
    let url = "http://localhost:8080/get-chaos?";
    
    let limits = document.getElementById('limits').value;
    url += "limits=" + limits + "&";
    
    let pattern = document.getElementsByName('pattern');
    for(i=0;i<pattern.length;i++){
        if(pattern[i].checked){
            url += "pattern=" + pattern[i].value + "&";
        }
    }

    let logStart = document.getElementById('logStart').value;
    url += "logStart=" + logStart + "&";
    
    let cosStart = document.getElementById('cosStart').value;
    url += "cosStart=" + cosStart + "&";
    
    let cosTime = document.getElementById('cosTime').value;
    url += "cosTime=" + cosTime + "&";
    
    let lorS = document.getElementById('lorS').value;
    url += "lorS=" + lorS + "&";
    
    let lorR = document.getElementById('lorR').value;
    url += "lorR=" + lorR + "&";
    
    let lorB = document.getElementById('lorB').value;
    url += "lorB=" + lorB + "&";
    
    let lorX = document.getElementById('lorX').value;
    url += "lorX=" + lorX + "&";
    
    let lorY = document.getElementById('lorY').value;
    url += "lorY=" + lorY + "&";
    
    let lorZ = document.getElementById('lorZ').value;
    url += "lorZ=" + lorZ + "&";
    
    let type = document.getElementsByName('type');
    for(i=0;i<type.length;i++){
        if(type[i].checked){
            url += "type=" + type[i].value;
        }
    }

    console.log(url);
    
    let response = await fetch(url);
    let noise = await response.json();
    currentPattern = JSON.stringify(noise[0]);
    updatePreview(noise[0]);
}//end getPattern()



function updatePreview(noise){
    let label = document.getElementById('label');
    label.innerHTML = noise.name;
    
    let preview = document.getElementById('preview');
    let sketch = preview.getContext('2d');
    
    for(i=0;i<noise.pattern.length;i++){
        for(j=0;j<noise.pattern[i].length;j++){
            sketch.beginPath();
            let grayscale = Math.floor(noise.pattern[i][j] * 256);
            sketch.strokeStyle = "rgba(" + grayscale + "," + grayscale + "," + grayscale + ",1.0";
            sketch.arc(i, j, 1, 0, 2*Math.PI);
            sketch.stroke();
            sketch.closePath();
        }
    }
    showJSON();
}//end updatePreview()



function showJSON(){
    let textDisplay = document.getElementById('textDisplay');
    textDisplay.innerHTML = currentPattern;
}//end saveJSON()
