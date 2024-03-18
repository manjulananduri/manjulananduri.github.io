$(document).ready(function(){
  $('#calculate').click(function(){
    calculate();
  });

  // Code for the time format dropdown
  $("#dateFormat").change(function(){
    var selectedOption = $(this).children("option:selected").val();
    if(selectedOption === "Other") {
      $("#customFormat").show();
    } else {
      $("#customFormat").hide();
    }
  });

});



function calculate1() {
    var startTime = $('#inpStartTime').val();
    var endTime = $('#inpEndTime').val();
    var diff = new Date(endTime) - new Date(startTime);
    var timeDiff = new Date(diff);
    var days = 1;
    var hours = timeDiff.getUTCHours();
    var minutes = timeDiff.getUTCMinutes();
    var seconds = timeDiff.getUTCSeconds();
    var output = days + ' days, ' + hours + ' hours, ' + minutes + ' minutes, ' + seconds + ' seconds';
    $('#results').html(output);
    $("#resultHolder").slideDown();
}

function calculate() {
    $("#resultHolder").hide();

    var startTime = $('#inpStartTime').val().trim();
    var endTime = $('#inpEndTime').val().trim();
    var dateFormat = $('#dateFormat').val().trim();
    var customDateFormat = $('#customDateFormat').val().trim();

    if(dateFormat == "Other") {
       dateFormat = customDateFormat;
    }

    var time1 = moment(startTime, dateFormat);
    var time2 = moment(endTime, dateFormat);

    if (time1.isValid() && time2.isValid()) {
        var diff = moment.duration(time2.diff(time1));

        var days = Math.floor(diff.asDays());
        diff.subtract(moment.duration(days, 'days'));

        var hours = Math.floor(diff.asHours());
        diff.subtract(moment.duration(hours, 'hours'));

        var minutes = Math.floor(diff.asMinutes());
        diff.subtract(moment.duration(minutes, 'minutes'));

        var seconds = Math.floor(diff.asSeconds());

        var output = days + ' days, ' + hours + ' hours, ' + minutes + ' minutes, ' + seconds + ' seconds';

        $('#results').html(output);
    } else {
        $("#results").html("Invalid input. Please enter valid date/time values.");
    }
    $("#resultHolder").slideDown();
}

function calculate2() {
    var start = moment($("#inpStartTime").val());
    var end = moment($("#inpEndTime").val());
    var dateFormat = $("#dateFormat").val();

    if (start.isValid() && end.isValid()) {
      var diff = moment.duration(end.diff(start));
      var days = Math.floor(diff.asHours());
      var hours = Math.floor(diff.asHours());
      var minutes = Math.floor(diff.asMinutes()) - (hours * 60);
      var seconds = Math.floor(diff.asSeconds()) - (hours * 60 * 60) - (minutes * 60);

      var outputString = days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds";

//      var outputString = moment.duration(end.diff(start)).humanize();

      $("#results").html(outputString);

      var startFormatted = start.format(dateFormat);
      var endFormatted = end.format(dateFormat);

//      outputString += "<br>Start time (" + timezone + "): " + startFormatted;
//      outputString += "<br>End time (" + timezone + "): " + endFormatted;
      $("#results").html(outputString);
    } else {
      $("#results").html("Invalid input. Please enter valid date/time values.");
    }

    $("#resultHolder").slideDown();
}

function getMinutes(time) {
    var prefix = time <= 1 ? ' minute' : ' minutes';
    return time + prefix;
}


$(document).ready(function() {
  $('#submit').click(function() {
    var start = moment.tz($('#input1').val(), 'YYYY-MM-DD HH:mm:ss z', 'America/Los_Angeles');
    var end = moment.tz($('#input2').val(), 'YYYY-MM-DD HH:mm:ss z', 'America/Los_Angeles');
    var diff = moment.duration(end.diff(start)).humanize();
    $('#output').text(diff);
  });
});


