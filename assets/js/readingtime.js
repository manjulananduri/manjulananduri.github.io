$(document).ready(function(){

    $("#calculate").click(function(){
        calculate();
    });


    $("#inputWpm").mousemove(function(){
        inputWpmVal = $("#inputWpm").val();
        $("#inputWpmLabel").html(inputWpmVal + " wpm");
    });

});

function calculate() {


    var inputContent = $("#inputContent").val().trim();
    var inputWordCount = parseInt($("#inputWordCount").val()) || 0;
    var inputImageCount = parseInt($("#inputImageCount").val()) || 0;

    var wpm = parseInt($("#inputWpm").val());
    var wordCount = 0;
    var spaceCount = 0;

    if(inputContent.length === 0 && inputWordCount === 0) {
        $("#helperMessage").html("<i class='text-warning material-icons'>lightbulb</i> <span class='text-danger'>Either content or word count needs to be entered </span>");
        return;
    } else {
        $("#helperMessage").html("<i class='text-success material-icons'>check</i> <span class='text-success'>Success! Check results below </span>");
    }

    if(inputContent.length === 0) {
        wordCount = inputWordCount;
    } else {
        wordCount = inputContent.split(" ").length;
        spaceCount = wordCount - 1;
    }

    var charCount = inputContent.length;

    var estimatedContentTime = parseFloat((wordCount / wpm).toFixed(2))
    var estimatedImageTime = parseFloat(((inputImageCount * 10) / 60).toFixed(2));
    var estimatedTimeTotal = parseFloat(estimatedContentTime + estimatedImageTime).toFixed(2);

    $("#estimatedTimeTotal").html(getMinutes(estimatedTimeTotal));
    $("#estimatedTimeContent").html(getMinutes(estimatedContentTime));
    $("#estimatedTimeImages").html(getMinutes(estimatedImageTime));
    $("#wordCount").html(wordCount);
    $("#charCount").html(charCount);
    $("#spaceCount").html(spaceCount);

    $("#results").slideDown();

}

function getMinutes(time) {
    var prefix = time <= 1 ? ' minute' : ' minutes';
    return time + prefix;
}
