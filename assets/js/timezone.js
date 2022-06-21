function getCurrentLocalDateTime() {
    return moment().format('YYYY-MM-DD hh:mm:ss A');
}

// convert local time to another timezone
function convertLocalToTimezone(localDt, localDtFormat, timezone, toFormat) {
    return moment(localDt, localDtFormat).tz(timezone).format(toFormat);
}

// Local date "2020-05-20 10:12:44 PM" to "America/Los_Angeles" timezone date:
convertLocalToTimezone('2020-05-20 10:12:44 PM', null, 'America/Los_Angeles'); // Output: 2020-05-20 09:42:44 AM

function getCurrentTimeInAllZones() {
    var format = 'YYYY-MM-DD hh:mm:ss A';
    var currentTime = getCurrentLocalDateTime();
    var timezones = moment.tz.names();
    $("#output").append("Current time: " + currentTime + "<br>");
    for (var i = 0; i < timezones.length; i++) {
        var zone = timezones[i];
        var abbr = moment.tz(timezones[i]).format('z');
        var convertedTime = convertLocalToTimezone(currentTime, format, zone, format);
        $("#output").append(zone + " : " + abbr + " : " + convertedTime + "<br>");
    }

}

function getTimeZonesWithAbbreviations() {
    var timezones = moment.tz.names();
    var dict = {};
    for (var i = 0; i < timezones.length; i++) {
        dict[timezones[i]] = moment.tz(timezones[i]).format('z');
    }
    return JSON.stringify(dict);
}

// Current local date:
getCurrentLocalDateTime();


