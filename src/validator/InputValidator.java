package validator;

public class InputValidator {
    public static boolean isValidPositiveNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number >= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
