//Array of student names
clsOf2020 = ['Alex','Ricardo','Yonathan','Maison','Cole','Dustin','Emily','Ben'];
//parallel list of student ids for above students.
idsOf2020 = [177848, 176236  ,199542    ,178291  ,184944, 176445 ,176483 , 174995];

/////////////////////////////////////////////////////////////
// Here is my initialization in the ready event
// I really need to improve my naming convention
// on my Identifiers between
// selectStudent (button) and studentSelect (student dropdown)
////////////////////////////////////////////////////////////
window.onload = function () {
    //initialize the click event handler of the selectStudent button
    var buttonEL = document.getElementById('selectStudent');
    buttonEL.addEventListener('click',selectStudent);

    //Initialize list of student buttons
    var listEL = document.getElementById('studentList');
    //TODO USE A COUNTING LOOP HERE to add all students to the list
    //loop using length of clsOf2020
    for(I=0; I < clsOf2020.length ; I++) {
        //add that student name as a LI element inside the list.
        listEL.innerHTML += makeLIfromName(clsOf2020[I]);
    }
}

function selectStudent(e) {
    //Get array of List Items
    var listItems = document.getElementsByTagName("li");
    //TODO pick a random number from the list.
    var random = Math.floor(Math.random() * clsOf2020.length);

    //TODO Select that element from listItems array using random and
    // style it differently somehow.
    listItems[random].style.color ="orange"
}


function makeLIfromName(name) {
        return "<li>" + name + "</li>";
}
