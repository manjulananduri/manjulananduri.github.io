$(document).ready(function () {
  // Function to handle form submission
  $("#promptForm").submit(function (event) {
    event.preventDefault();
    $("#loading").show();
    $("#error").hide();
    const promptCount = $("#promptCount").val();
    const concept = $("#concept").val();
    // Call your backend API with the promptCount and concept as parameters
    // Replace "YOUR_API_ENDPOINT" with the actual API endpoint
    // const apiUrl = `YOUR_API_ENDPOINT?promptCount=${promptCount}&concept=${concept}`;
    // const apiUrl = `https://aiart.manigopalmurthy.workers.dev/prompts?count=${promptCount}&concept=${concept}`;
    const apiUrl = `http://127.0.0.1:8787/prompts?count=${promptCount}&concept=${concept}`;

    $.ajax({
      url: apiUrl,
      type: "GET",
      dataType: "json",
      success: function (data) {
        // Process the API response here and display the prompts
        displayPrompts(data);
      },
      error: function (error) {
        console.error("Error fetching prompts:", error);
      },
    });
  });

  function getRandomBadgeColorClass() {
    const colors = [
      "primary",
      "secondary",
      "success",
      "danger",
      "warning",
      "info",
    ];
    return "badge badge-" + colors[Math.floor(Math.random() * colors.length)];
  }

  function cleanOutput_deprecate(output) {
    result = output.replace(/\n/g, "");
    return result;
  }

  function cleanOutput(output) {
    // Replace ``` or ```json with empty string
    result = output.replace(/```json|```/g, "");

    // Remove any remaining newline characters
    result = result.replace(/\n/g, "");

    return result;
  }

  function displayPrompts(data) {
    const outputContainer = $("#outputContainer");
    outputContainer.empty();

    if (data && data.candidates && data.candidates.length > 0) {
      try {
        const candidatesJsonString = cleanOutput(data.candidates[0].output);
        const candidates = JSON.parse(candidatesJsonString.trim());
        const templateCard = $(".template-card")
          .clone()
          .removeClass("template-card d-none");
        candidates.forEach(function (candidate) {
          const promptText = candidate.prompt;
          const keywords = candidate.keywords;

          const promptCard = templateCard.clone();
          const cardBody = promptCard.find(".card-body");

          // Update prompt text
          cardBody.find(".prompt-text").text(promptText);

          // Add keyword tags
          const tagsContainer = cardBody.find(".keyword-tags");
          tagsContainer.empty();
          keywords.forEach(function (keyword) {
            const tag = $("<span>")
              .addClass(getRandomBadgeColorClass() + " m-1")
              .text(keyword);
            tagsContainer.append(tag);
          });

          // Copy to Clipboard button click event
          const copyButton = cardBody.find(".copy-button");
          copyButton.click(function () {
            copyToClipboard(promptText);
          });

          outputContainer.append(promptCard);
        });
      } catch (error) {
        console.error(error);
        $("#loading").hide();
        $("#error").show();
      }
    } else {
      outputContainer.text("No prompts found.");
    }

    $("#loading").hide();
  }

  function copyToClipboard(text) {
    const tempInput = $("<input>");
    $("body").append(tempInput);
    tempInput.val(text).select();
    document.execCommand("copy");
    tempInput.remove();
    alert("Prompt copied to clipboard!");
  }

  // Function to display the prompts and keywords
  function displayPrompts1(data) {
    const outputContainer = $("#outputContainer");
    outputContainer.empty();

    if (data && data.candidates && data.candidates.length > 0) {
      const candidates = JSON.parse(data.candidates[0].output);
      const promptList = $("<ul>");

      candidates.forEach(function (candidate) {
        const prompt = candidate.prompt;
        const keywords = candidate.keywords;

        const listItem = $("<li>").text(
          `Prompt: ${prompt}, Keywords: ${keywords}`
        );
        promptList.append(listItem);
      });

      outputContainer.append(promptList);
    } else {
      outputContainer.text("No prompts found.");
    }
  }
});
