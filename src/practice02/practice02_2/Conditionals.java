package practice02.practice02_2;

public class Conditionals {
    public static void main(String[] args) {
        /*
            1)
            Run the following commands in Jshell:
            Note:
            - The "System.out.println" is performed by Shell after some command execution.
        */


        // 1)

        // A)
        // Create a file named script1.txt and save.

        // B) Paste the following if/else statement on the file.
        // Remove all System.out.println.
        char someChar = 'q';
        System.out.println("someChar: " + someChar);

        if (someChar >= 'a' && someChar <= 'z') {
            someChar -= 32;
        } else {
            someChar += 32;
        }
        System.out.println("someChar: " + someChar);

        // C) Save the file.

        // D)
        // Run /open script1.txt
        // It will run the code on JShell.

        // E)
        // echo someChar variable simply typing its name.

        // F) Add a check to else statement to be sure if the char is a uppercase char.
        if (someChar >= 'a' && someChar <= 'z') {
            someChar -= 32;
        } else if (someChar >= 'A' && someChar <= 'Z') {
            someChar += 32;
        }
        System.out.println("someChar: " + someChar);

        // G) Save the file.

        // H)
        // Run again /open script1.txt
        // It will run the code on JShell.

        // E)
        // echo someChar variable simply typing its name.


        // 2)

        // A) Ternary
        someChar = (someChar >= 'a' && someChar <= 'z')
                ? (char) (someChar - 32)
                : (someChar >= 'A' && someChar <= 'Z')
                ? (char) (someChar + 32)
                : someChar;
        System.out.println("someChar: " + someChar);


        // 3)

        // A)
        // Create a file named script2.txt and save.

        // B) On this file initialize the following variables:
        int period = 1;
        float amount = 10;
        float rate = 0.05F;

        System.out.println("period: " + period);
        System.out.println("amount: " + amount);
        System.out.println("rate: " + rate);

        // C)

        // Add this switch to the bottom:

        switch (period) {
            case 3:
            case 2:
            case 1:
        }

        // D)

        switch (period) {
            case 3:
                amount += amount * rate;
                System.out.println("amount: " + amount);
            case 2:
                amount += amount * rate;
                System.out.println("amount: " + amount);
            case 1:
                amount += amount * rate;
                System.out.println("amount: " + amount);
        }

        // E) Save the file.

        // F) Run using /open script2.txt

        // G) echo amount.

        // H) Go to file again.

        // I) Modify period to 3;
        period = 3;

        // J) Save and Run again.

        // K) Output the amount again.

        // I reset the amount value here to 10 to be able to test it.
        amount = 10;

        switch (period) {
            case 3:
                amount += amount * rate;
                System.out.println("amount: " + amount);
            case 2:
                amount += amount * rate;
                System.out.println("amount: " + amount);
            case 1:
                amount += amount * rate;
                System.out.println("amount: " + amount);
        }


        // 4)

        // A) Change the file and add an extra case:

        /*
        case 4:
                amount += amount * 0.2F;
                System.out.println("amount: " + amount);
                break;
         */

        // B) Modify period to 4.
        period = 4;

        // I reset the amount value here to 10 to be able to test it.
        amount = 10;

        // C) Save and run the file with /open script2.txt

        // D) echo amount value.

        switch (period) {
            case 4:
                amount += amount * 0.2F;
                System.out.println("amount: " + amount);
                break;
            case 3:
                amount += amount * rate;
                System.out.println("amount: " + amount);
            case 2:
                amount += amount * rate;
                System.out.println("amount: " + amount);
            case 1:
                amount += amount * rate;
                System.out.println("amount: " + amount);
        }
    }
}
