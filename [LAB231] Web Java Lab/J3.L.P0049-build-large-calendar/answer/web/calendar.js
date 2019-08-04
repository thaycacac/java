window.onload = function () {
    const today = new Date();
    const currentMonth = today.getMonth();
    const currentYear = today.getFullYear();
    const dayToday = (new Date()).getDate();
    showCalendar(currentMonth, currentYear, dayToday);
};

function next() {
    const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    let month = months.indexOf(document.getElementById("month").innerHTML);
    let year = document.getElementById("year").innerHTML;
    if (month === 11) {
        month = 0;
        year = parseInt(year) + 1;
    } else {
        month = month + 1;
    }
    showCalendar(month, year, -1);
}

function previos() {
    const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    let month = months.indexOf(document.getElementById("month").innerHTML);
    let year = document.getElementById("year").innerHTML;
    if (month === 0) {
        month = 11;
        year = parseInt(year) - 1;
    } else {
        month = month - 1;
    }
    showCalendar(month, year, -1);
}

function showCalendar(month, year, dayToday) {
    const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    const firstDay = (new Date(year, month)).getDay();
    const daysInMonth = 32 - new Date(year, month, 32).getDate();
    const content = document.getElementById("calendar");
    content.innerHTML = ''
    // show month and year
    document.getElementById("month").innerHTML = months[month];
    document.getElementById("year").innerHTML = year;

    // creating all cells
    let date = 1;
    for (let i = 0; i < 6; i++) {
        // create row
        let row = document.createElement("tr");
        for (let j = 0; j < 7; j++) {
            if (i === 0 && j < firstDay) {
                let cell = document.createElement("td");
                let cellText = document.createTextNode("");
                cell.appendChild(cellText);
                row.appendChild(cell);
            } else if (date > daysInMonth) {
                let cell = document.createElement("td");
                let cellText = document.createTextNode("");
                cell.appendChild(cellText);
                row.appendChild(cell);
            } else {
                let cell = document.createElement("td");
                let cellText = document.createTextNode(date);
                cell.appendChild(cellText);
                if (dayToday === date) {
                    cell.classList.add("today");
                } else if (j === 0) {
                    cell.classList.add("sunday");
                } else {
                    cell.classList.add("normal");
                }
                row.appendChild(cell);
                date++;
            }
        }
        content.appendChild(row);
    }
}