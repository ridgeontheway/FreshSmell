$(document).ready(function () {
    let div = $(".file-upload");

    $("body").on("click",
        ".add-upload",
        function() {
            div.append(`<input type="file" name="file"><br />`)
        });
});