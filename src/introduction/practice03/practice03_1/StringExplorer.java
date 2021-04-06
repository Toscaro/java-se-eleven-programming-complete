package introduction.practice03.practice03_1;

public class StringExplorer {

    public static void main(String[] args) {
        /*
            1)
            Run the following commands in Jshell:
            Note:
            - The "System.out.println" is performed by JShell after some command execution.
        */

        // 2) Explore String internment.


        //  A)
        String teaText = "Tea";

        //  B)
        String b = "Tea";

        //  C)
        System.out.println(teaText == b);

        //  D)
        String c = new String("Tea");

        //  E)
        System.out.println(teaText == c);

        //  F)
        c.intern();
        System.out.println(teaText == c);

        //  G)
        String d = c.intern();
        System.out.println(teaText == d);


        // 3)

        // A)
        c = teaText + ' ' + b;
        System.out.println(c);

        // B)
        System.out.println(c.indexOf('T', 1));
        System.out.println(c.lastIndexOf('T'));

        // C) @Fixme? missing in course file.

        // D)
        System.out.println(c.charAt(c.length() - 1));

        // E)
        c = c.toUpperCase();
        System.out.println(c);

        // F)
        int lastOfT = c.lastIndexOf('T');
        System.out.println(c.substring(lastOfT, lastOfT + 2));


        // 4) Explore StringBuilder

        // A)
        StringBuilder txt = new StringBuilder(c);

        // B)
        System.out.println("Length: " + txt.length());
        System.out.println("Capacity: " + txt.capacity());

        // C)
        txt.replace(0, 3, "What is the price of");
        System.out.println(txt.toString());

        // D)
        // B)
        System.out.println("Length: " + txt.length());
        System.out.println("Capacity: " + txt.capacity());
    }
}
