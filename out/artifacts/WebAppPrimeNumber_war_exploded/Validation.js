
var InputValidator = {
    isValidPositiveNumber: function (input) {
        try {
            var number = parseInt(input);
            return !isNaN(number) && number >= 1;
        } catch (e) {
            return false;
        }
    }
};


function validateForm() {
    var upperBound = document.getElementById("upperBound").value;
    var clientErrorMessage = document.getElementById("clientErrorMessage");
    var result = document.getElementById("primeNumbersSection")

    if (upperBound === "" || !InputValidator.isValidPositiveNumber(upperBound)) {
        clientErrorMessage.textContent = "Please enter a valid positive number.(Client-side)";

        result.textContent = "";
        return false;
    }
    clientErrorMessage.textContent = "";
    return true;
}


