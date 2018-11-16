//Adding event handler directly to property of
//  window object
window.onload = loadDocument;

//global properties to remember where things were drawn.
window.textX= 0;
window.textY= 0;
window.sunX = 0;
window.sunY = 0;

function loadDocument(evt) {
    var canvas = document.getElementById("myCanvas");
    begin(evt);
    canvas.addEventListener("mousedown",onMousePress);
    canvas.addEventListener("click",onMousePress);
    canvas.addEventListener("mouseleave",onMouseExit);
}


/**
*  begin Function runs when page is loaded.
*     it creates instructions and first sun.
*/
function begin(evt) {
    let canvas = document.getElementById("myCanvas");
    let pen = canvas.getContext("2d");

    //draw instructions
    pen.font = "30px Arial";
    pen.fillText("Click to make the sun rise",0,30,150);
    //draw yellow circle at bottom of canvas
    // use canvas.width and canvas.height to place circle
    //center should start as middle bottom of canvas;
    let cx = canvas.width/2;
    let cy = canvas.height;
    let radius = 50;
    let color = "yellow";
    pen.fillStyle = color;
    pen.beginPath();
    pen.arc(cx,cy,radius,0, 2*Math.PI);
    pen.fill();
//don't forget to change pen back after using it!!!
    pen.fillStyle = "black";
    window.sunY = cy;
    window.sunX = cx;

}

/**
*  onMousePress function runs every time canvas is clicked on
*     it should move sun up and hide instructions
*/
function onMousePress(evt) {

    let mouseX = evt.offsetX;
    let mouseY = evt.offsetY;
    let canvas = evt.currentTarget;
    let pen = canvas.getContext("2d");
    //erase instructions using canvas.clearRect
    pen.clearRect(0,0,150,30);
    //erase old sun
    let cx = canvas.width/2;
    let cy = window.sunY;
    let radius = 50;
    let color = "yellow";
    pen.clearRect(cx-radius,window.sunY-radius,100,100);
    //update new sun Y coordinate by moving it upward 10 pixels
    window.sunY = window.sunY-10;
    //draw new sun

    pen.beginPath();
    pen.fillStyle = color;
    pen.arc(cx,window.sunY,radius,0, 2*Math.PI);
    pen.fill();

    pen.fillStyle = "black";

}

function onMouseExit(evt) {
    //clear the entire canvas using clearRect
    let canvas = evt.currentTarget;
    let pen = canvas.getContext("2d");
    pen.clearRect(0,0,400,300);
    //run begin(evt) to redraw canvas.
    begin(evt);
}
