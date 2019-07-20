/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function setGroupMonth() {
    // 
    var menu = document.getElementById('menu').getAttribute("data-page"); // get current page name
    if (menu !== null) { // if name not null then set bold for true title page
        document.getElementById(menu).className = "setBold";
    }
    //
    
    var array = document.querySelectorAll('#groupMonth'); // get all element in div id #groupMonth
    var current = array[0].getAttribute("data-date");
    
    console.log(current);

    for (var i = 1; i < array.length; i++) {
        console.log(array[i].getAttribute("data-date"));
        if (array[i].getAttribute("data-date") === current) {// if data-date in #groupMonth is first title
            array[i].style.display = 'none'; // hide
        } else {
            current = array[i].getAttribute("data-date");// if data-date in #groupMonth is second title
            array[i].style.borderTop = "none";
        }
    }
}

