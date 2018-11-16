window.onload = loadDocument;
function loadDocument(){
  //Line
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.moveTo(0,0);
ctx.lineTo(300,150);
ctx.stroke();
//Circle
ctx.beginPath();
ctx.arc(145,75,75,0,2*Math.PI);
ctx.stroke();
//Filled Text
ctx.font = "30px Arial";
ctx.fillText("Raviolli",97,50);
//Stoke text
ctx.strokeText("Raviolli",97,120);
}
