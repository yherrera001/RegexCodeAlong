import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

public class Testing {
    //USING CAPTURE GROUPS
    //Parenthesized patterns that match a character sequence
    //Easily extracted from your text
    //Back References: \1 or \k<name>
    //Replacement: $1 or ${name}
    @Test
    public void testReplaceAllWithReferences() {
        List<String> list = Arrays.stream(new String[]{
                "securities-development-equities-valuation-americas",
                "securities-development-equities-valuation-americas",
                "fixed_income-development-equities-asia",
                "fx-development-emea"}).map(
                label -> label
                        .replaceAll("(?<business>\\w+) (-(\\w+)) +- (?<region>\\w+)",
                                "Region:${region}, Unit:$1"))
                .collect(Collectors.toList());
        for (String line : list) {
            System.out.println(line);
        }
    }

    @Test
    public void test() {
        String text = "The \"rain\" in Spain \"falls\" mainly on \"the plain\"";
        Pattern pattern = Pattern.compile("(\"\\w+\") | (\\w+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Group 1: " + matcher.group(1) + ";");
            System.out.println("Group 2:" + matcher.group(2));
        }
    }
 //-----------------------------------------------------------------------------------------------------------------
    //USING REGEX
    @Test
    public void testDotAll() {
        String text = "\u006e\u0303"; //~n
        String regex = "\u00F1";
        System.out.printf("Text: '%s' Regex: '%s'%n", text, regex);
        Pattern pattern = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println("Match! Group 0:" + matcher.group(0));
            return;
        }
        fail("No match");
    }

    @Test
    public void testDotAllAgain() {
        String regex = "abc.+def";
        String text = "abc\r\ndef";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println("Match!");
            return;
        }
        fail("No match");
    }

//    @Test
//    public void testUniCodeCase() {
//        String regex = "\u00E3"; //`a
//        String text = "\u00C0"; //`A
//
//        System.out.printf("regex: %s, text: %s'%n", regex, text);
//        Pattern pattern = Pattern.compile(regex,
//                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
//        );
//        Matcher matcher = pattern.matcher(text);
//        if (matcher.find()) {
//            System.out.println("Match!");
//            return;
//        }
//        fail("No match");
//    }

    @Test
    public void testMatches(){
        boolean matches = Pattern.matches("[\\w\\s+]", "She sells sea shells"); //RETURNS TRUE IF THE PATTERN MATCHES THE CHARACTER SEQUENCE
        System.out.println(matches);

        Pattern pattern = Pattern.compile(";\\s");
        String[] split = pattern.split("One; Two; Three; Four; Five; ;", 3); //SPLIT ACCEPTS A CHARACTER SEQUENCE AND A LIMIT. ANY EMPTY SPACE WILL BE DISCARDED
        System.out.printf("%s: Length: %d", Arrays.asList(split), split.length); //IF THE LIMIT
    }

    @Test
    public void testSplitAsStream (){
         List<String> list = Arrays.asList("One", "Two", " ", "Buckle", " ", "My_Shoe");
         Pattern pattern = Pattern.compile("(\\w)");
         List<String> cleanList = list.stream()
                 .filter(pattern.asPredicate())
                 .collect(Collectors.toList());
        System.out.println(cleanList);
    }

    //------------------------------------------------------------------------------------------------------------------------------------

    @Test
    public void testMatching(){
        Pattern pattern = Pattern.compile("\\w+");
        String text = "Hello"; //IF I PUT "HELLO WORLD" IT WILL FAIL BECAUSE IT DOES NOT MATCH
        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();
        System.out.println(text+ "Matches:" + matches);
    }

    @Test
    public void testMatcher(){
        String text = "Hello, World";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        boolean found = matcher.find(2); //START SCAN AT TEXT POSITION 2
        while (found) {
            System.out.printf("Found '%s'%n", matcher.group(0));
            found = matcher.find();


            String text1 = "I like her and she likes me";
            Pattern pattern1 = Pattern.compile("(like)"); //WE ARE GOING TO REPLACE THE FIRST "LIKE" WE SEE
            Matcher matcher1 = pattern1.matcher(text1);
            String love = matcher1.replaceFirst("love"); //WITH "LOVE"
            System.out.println(love);
        }
    }
}
