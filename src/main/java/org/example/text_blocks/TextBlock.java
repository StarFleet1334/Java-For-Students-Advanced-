package org.example.text_blocks;

public class TextBlock {

    public static void main(String[] args) {
        String sName = "Sean Kennedy";
        String tbName = """
                Sean Kennedy""";

        System.out.println(sName.equals(tbName));
        System.out.println(sName == tbName);


        // String methods can be applied to a Text Blocks
        System.out.println(tbName.substring(5)); // Kennedy

        // 3. Text Blocks start with """ followed by a line terminator
//        String tb1 = """abc""";
//        String tb2 """abc
//                """
        String tb3 = """
                abc
                """;
        System.out.println(tb3);
        String tb4 = """
                abc""";
        System.out.println(tb4);
        System.out.println(tb3);


        // 4. In String literals, embedded quotes must be escaped. This is not case with
        // Text Blocks

        System.out.println("""
                Hamlet: "THere is nothing either good or bad, but thinking makes it so"
                """);

        // 5. Depending on where you place the closing delimiter (the three double quotes),
        // determines whether or not you have a closing "\n"

        String tbBookTitle1 = """
                Java
                Memory
                Management
                """; // same as Java\nMemory\nManagement\n

        String tbBookTitle2 = """
                Java
                Memory
                Management"""; // same as Java\nMemory\nManagement


        // 6. Spacing is determined by the closing delimiter position or the first non-space
        // character, whichever is encountered first.

        // All spaces (know as incidental spaces) leading up to that position, are stripped from all
        // the lines in the text block.

        String jsonText = """
                {
                    name: Ilia,
                    age: 22
                }
                """;
        System.out.println(jsonText);
        // if I put end delimiter more on left
        String jsonText1 = """
                {
                    name: Ilia,
                    age: 22
                }
             """;
        System.out.println(jsonText1);
        // we see more space was allocated from left

    }
}
