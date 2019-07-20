/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function setBold() {
    var menu = document.getElementById('menu').getAttribute("data-page"); // get current page name
    if (menu !== null) {
        document.getElementById(menu).className = "setBold";
    }
}
