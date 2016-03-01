var shape = document.getElementById("shape");
var popUpTime = Date.now();
var clickedTime;
var timeTaken;
var waitTime;

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function startOver() {
    shape.style.display = "block";
    shape.style.width = Math.random() * 200;
    shape.style.height = Math.random() * 200;
    shape.style.borderRadius = (Math.random() * 100) + "%"; 
    shape.style.backgroundColor = getRandomColor();
    shape.style.marginLeft = Math.random() * 400;
    shape.style.marginTop = Math.random() * 300;
    popUpTime = Date.now();
}

document.getElementById("startButton").onclick = function() {
    startOver();
}

shape.onclick = function() {
    
    clickedTime = Date.now();
    
    timeTaken = (clickedTime - popUpTime) / 1000;
    
    document.getElementById("text").innerHTML = "Your time " + timeTaken + "s";
    
    waitTime = Math.random() * 3000;
    
    setTimeout(function() {startOver()}, waitTime);
    
    shape.style.display = "none";
    
    
}
