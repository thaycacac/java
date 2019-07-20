this.timeRemaining = 60;
this.timeDisplay = document.getElementById("timeDisplay");
this.questionPos = document.getElementById("qustionPos");
this.currentQuiz = 0;
this.currentDiv = null;
this.testing = 0;
this.numOfQuiz = 0;

var nextQuestion = function () {
    currentQuiz = (currentQuiz + 1) % numOfQuiz;
    if (this.currentDiv !== null)
        this.currentDiv.classList.add("hidden");
    currentDiv = document.getElementById("q" + currentQuiz);
    currentDiv.classList.remove("hidden");
    questionPos.textContent = "Question: " + (currentQuiz + 1) + "/" + numOfQuiz;
}

var quizStart = function () {
    testing = 1;
    nextQuestion();
    setInterval(function () {
        timeRemaining--;
        updateTime();
        if (timeRemaining < 0) {
            testing = 0;
            document.getElementById("quizForm").submit();
        }
    }, 1000);
}

var updateTime = function () {
    var time = Math.floor(timeRemaining / 60);
    var sec = timeRemaining % 60;
    timeDisplay.textContent = time + ":" + sec;
}

window.onbeforeunload = function () {
    if (testing !== 0)
        return "Are you sure?";
}

var setNumOfQuiz = function (n) {
    numOfQuiz = n;
    this.timeRemaining = 60;
    this.timeDisplay = document.getElementById("timeDisplay");
    this.questionPos = document.getElementById("qustionPos");
    this.currentQuiz = 0;
    this.currentDiv = null;
    this.testing = 0;
    this.timeRemaining = 60;
}