$(document).ready(function () {
  let exchangeRate;

  // Function to fetch exchange rate from ExchangeRate-API
  function fetchExchangeRate() {
    const apiEndpoint = "https://open.er-api.com/v6/latest/USD";

    return fetch(apiEndpoint)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error fetching exchange rate");
        }
        return response.json();
      })
      .then((data) => {
        exchangeRate = data.rates.INR || 83.15; // Default value if not available
      })
      .catch((error) => {
        console.error(error);
        // Use a default exchange rate
        exchangeRate = 83.15;
      });
  }

  // Function to convert Indian Crore to USD
  function convertCroreToUSD(croreAmount) {
    // Ensure exchangeRate is available
    if (exchangeRate === undefined) {
      console.error("Exchange rate not available. Conversion not possible.");
      return { errorMessage: "Error: Exchange rate not available." };
    }

    // Calculate USD amount using the original formula
    const usdAmount = (croreAmount * 1e7) / exchangeRate;

    // Format USD amount with commas
    const formattedUSDAmount = usdAmount.toLocaleString();

    // Calculate USD amount in millions
    const usdAmountMillions = usdAmount / 1e6;

    // Format USD amount in millions with commas
    const formattedUSDAmountMillions = usdAmountMillions.toLocaleString();

    return { formattedUSDAmount, formattedUSDAmountMillions };
  }

  // Set default input value to 1
  $("#croreInput").val(1);

  // Fetch exchange rate on page load
  fetchExchangeRate().then(() => {
    // Function to handle conversion and update output
    function handleConversion() {
      // Get the entered crore amount
      const croreInput = parseFloat($("#croreInput").val()) || 0;

      // Call the conversion function
      const { formattedUSDAmount, formattedUSDAmountMillions, errorMessage } =
        convertCroreToUSD(croreInput);

      // Update the output dynamically
      $("#usdAmount").text(`USD Amount: $${formattedUSDAmount}`);
      $("#usdAmountMillions").text(
        `USD Amount in Millions: $${formattedUSDAmountMillions} Million`
      );

      // Display error message if available
      if (errorMessage) {
        $("#conversion").text(
          `Note: Currency conversion not availble. Defaulting to 1USD = 83.15 INR`
        );
      } else {
        $("#conversion").text(`Note: 1 USD = $${exchangeRate} Rupees`);
      }
    }

    // Trigger conversion on page load
    handleConversion();

    // Event handler for input changes
    $("#croreInput").on("input", handleConversion);
  });
});
