class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        double converted = 0;
        if (input != null) {
            try {
                converted = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.err.printf("Can't convert %s to double!\n", input);
            }
        }
        return converted;
    }
}