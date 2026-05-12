package Utilities;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println();
            }
        }

        return input;
    }

    /** Reads an integer from the console. */
    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_INTEGER);
            }
        }
    }

    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            int val = getIntInput(prompt);
            if( HelperUtils.isValidNumber(val,min,max))return val;
            System.out.printf(Constants.NOT_IN_RANGE, min+ "-"+max);
        }
    }




}
