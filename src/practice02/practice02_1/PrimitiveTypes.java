package practice02.practice02_1;

public class PrimitiveTypes {
    public static void main(String[] args) {
        /*
            1)
            Run the following commands in Jshell:
            Note:
            - The "System.out.println" is performed by Shell after some command execution.
        */

        // 2)

        // A)
        byte x = 2, y = 3, z = 5;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);

        // B)
        z = (byte) (x + y);
        System.out.println("(byte) (x + y): " + z);

        // C)
        float a = (float) x / y;
        System.out.println("(float)x / y: " + a);

        // D)
        double b = (double) x / y;
        System.out.println("(double)x / y: " + b);

        // E)
        b = a;
        System.out.println("b = a: " + b);

        // F)
        float c = Math.round(b * 1000) / 1000F;
        System.out.println("Math.round(b * 1000) / 1000F: " + c);


        // 3)

        // A)
        char a1 = 'a', a2 = '\141', a3 = '\u0061';
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2);
        System.out.println("a3: " + a3);

        // B)
        int i = a1;
        System.out.println("i: " + i);
        System.out.println("octal i: " + Integer.toOctalString(i)); //a1
        System.out.println("hex i: " + Integer.toHexString(i)); //a2

        // C)
        int i1 = 0141, i2 = 0x61;
        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);

        // D)
        char a4 = (char) i1;
        char a5 = (char) i2;
        System.out.println("a4: " + a4);
        System.out.println("a5: " + a5);


        // 4)

        // A)
        char someChar = 'k';
        System.out.println("someChar: " + someChar);

        // B)
        boolean isEven = ((someChar % 2) == 0);
        System.out.println("isEven: " + isEven);

        // 5)

        // A)
        someChar = 'k';
        System.out.println("someChar: " + someChar);

        // B)
        char nextChar = (char) (someChar + 1);
        System.out.println("nextChar: " + nextChar);
        System.out.println("someChar: " + someChar);

        // C)
        nextChar = ++someChar;
        System.out.println("nextChar: " + nextChar);
        System.out.println("someChar: " + someChar);

        // D)
        someChar = 'b';
        System.out.println("someChar: " + someChar);

        // E)
        --someChar;
        System.out.println("someChar: " + someChar);


        // 6)

        // A)
        char upperA = 'A', lowerA = 'a';
        System.out.println("upperA: " + upperA + " " + "lowerA: " + lowerA);

        // B)
        int distance = lowerA - upperA;
        System.out.println("distance: " + distance);

        // C)
        someChar = 'h';
        System.out.println("someChar: " + someChar);

        // D)
        char upperSomeChar = (char) (someChar - 32);
        System.out.println("upperSomeChar: " + upperSomeChar);
    }
}
