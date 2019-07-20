var delQuestion = function(page, id) {
    result = confirm("Are you sure to delete this question ?");
    if (result)
        window.location.replace("ManageQuiz?p=" + page + "&del=" + id);
}