/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ajaxPost(url, data, callback) {
    var xmlDoc = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");

    xmlDoc.open('POST', url, true); // open post
    xmlDoc.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // set content post

    xmlDoc.onreadystatechange = function () {
        if (xmlDoc.readyState === 4 && xmlDoc.status === 200) //
            callback(xmlDoc);
    };

    xmlDoc.send(data); // send data with post
}

function disableInput(status) { // disable element input in form send message
    var form = document.getElementById("sendMessage"); // get form
    var elements = form.elements; // get array of form
    if (status === 'true') { // this case for disable all input
        for (var i = 0, len = elements.length; i < len; ++i) { // count element in array
            elements[i].disabled = true;
            elements[i].classList.add("disableInput"); // add class
        }
        document.getElementById("submit").classList.add("disableButton");
    } else { // this case for emable all input
        for (var i = 0, len = elements.length; i < len; ++i) {// count element in array
            elements[i].disabled = false;
            elements[i].classList.remove("disableInput"); // remove class
        }
        document.getElementById("submit").classList.remove("disableButton");
    }
}

function closeDialog() { // close error message
    var err = document.getElementById("error-message").className;
    document.getElementById("error-message").className = err.replace(" show", " closeDialog");
    disableInput("false");
}

var form = document.getElementById("sendMessage");

function handleForm(event) { // when submit form

    // get value in form
    var name = document.getElementsByName("name")[0].value;
    var email = document.getElementsByName("email")[0].value;
    var message = document.getElementsByName("message")[0].value;

    var data = "name=" + name + "&email=" + email + "&message=" + message; // 

    ajaxPost("SendMessage", data, function (xmlDoc) { // do send data to server
        
        var err = document.getElementById("error-message").className; // get error dialog

        if (xmlDoc.responseText === "true") { // if server return true
            var x = document.getElementById("success-message").className;
            document.getElementById("success-message").className = x.replace(" closeDialog", " show");// show success dialog
            document.getElementById("submit").value = "Sent"; // change text button send to sent
        } else if(xmlDoc.responseText === "email"){ // if server return error email
            document.getElementById("error-message").className = err.replace(" closeDialog", " show");// show error dialog
        } else if(xmlDoc.responseText === "name"){ // if server return error name
            document.getElementById("content-message").innerHTML = "Name can not be empty"; // set content error
            document.getElementById("error-message").className = err.replace(" closeDialog", " show");// show error dialog
        } else if(xmlDoc.responseText === "message"){ // if server return error message
            document.getElementById("content-message").innerHTML = "Message can not be empty";// set content error
            document.getElementById("error-message").className = err.replace(" closeDialog", " show");// show error dialog
        } 
        disableInput("true");// disable input
    });

    event.preventDefault(); // set form do not reload when submit
}
form.addEventListener('submit', handleForm);