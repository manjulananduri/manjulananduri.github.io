$(document).ready(function () {
  // const apiUrlFetchUser = `http://127.0.0.1:12345/users?userId=`;
  // const apiUrlGenerateKey = `http://127.0.0.1:12345/keys/generate`;

  const apiUrlFetchUser = `https://composer.manigopalmurthy.workers.dev/users?userId=`;
  const apiUrlGenerateKey = `https://composer.manigopalmurthy.workers.dev/keys/generate`;

  // Function to fetch user data and populate apiKey on page load
  function fetchUserDataAndPopulateApiKey(userId) {
    $.ajax({
      url: `${apiUrlFetchUser}${userId}`,
      type: "GET",
      success: function (response) {
        $("#apiKey").val(response.api_key);
        $("#credits").text(response.credits);
        $("#loading").hide();
      },
      error: function (error) {
        console.error("Error fetching user data:", error);
        $("#loading").hide();
      },
    });
  }

  // Function to handle form submission
  function handleFormSubmission(idToken) {
    const payload = {
      userToken: idToken,
      // Add other parameters as needed
    };

    $.ajax({
      url: apiUrlGenerateKey,
      type: "POST",
      dataType: "json",
      data: JSON.stringify(payload),
      success: function (data) {
        $("#apiKey").val(data);
        $("#loading").hide();
        $("#error").hide();
      },
      error: function (error) {
        console.error("Error generating key:", error);
      },
    });
  }

  // Function to fetch user data and populate apiKey on page load
  function fetchUserDataAndHandleFormSubmission(user) {
    const userId = user.uid;
    fetchUserDataAndPopulateApiKey(userId);

    $("#apiKeyForm").submit(function (event) {
      event.preventDefault();
      $("#loading").show();
      $("#error").hide();

      // Ask for confirmation before regenerating API key
      if (confirm("Are you sure you want to regenerate the key?")) {
        user
          .getIdToken()
          .then((idToken) => {
            handleFormSubmission(idToken);
          })
          .catch((error) => {
            console.error("Error getting ID token:", error.message);
          });
      } else {
        // If the user cancels, hide the loading indicator
        $("#loading").hide();
      }
    });
  }

  // On profile page
  checkAuthAndExecute((user) => {
    fetchUserDataAndHandleFormSubmission(user);
  });

  // Function to copy text to clipboard
  function copyToClipboard(text) {
    const tempInput = $("<input>");
    $("body").append(tempInput);
    tempInput.val(text).select();
    document.execCommand("copy");
    tempInput.remove();
    // alert("Prompt copied to clipboard!");
  }

  // Event listener for copy button
  $("#copyBtn").click(function () {
    const apiKeyValue = $("#apiKey").val();
    copyToClipboard(apiKeyValue);
    $("#copyBtn").html("Copied <i class='fa fa-check'></i>");
    setTimeout(function () {
      $("#copyBtn").html("Copy <i class='fa fa-copy'></i>");
    }, 3000); // Revert back to "Copy" after 5 seconds
  });
});
