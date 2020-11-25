import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class playpen {

    public static void main(String[] args) {

        System.out.println("abcdefg".matches("c.e")); //PATTERN  DOES NOT MATCH, SO IT RETURNS FALSE
        System.out.println("abcdefg".matches(".b.d.f.")); //. IS A WILD CHARACTER AND THE PATTERN MATCHES, SO IT RETURNS TRUE
        System.out.println(Arrays.asList("23,42,64,hike".split(",")));
        System.out.println(Arrays.asList("Anne of the 1000 days".split(" "))); //SPLITTING ON THE SPACE CHARACTER
        System.out.println(Arrays.asList("Anne of the 1000 days".split("xxxx"))); //NOTHING IS BEING SPLIT. THE ORIGINAL STRING WILL APPEAR
        System.out.println(Arrays.asList("Anne of the 1000 days".split(""))); //SINCE THERE IS AN EMPTY CHARACTER IN A CHAR, IT RETURNS AN ARRAY OF EVERY EMPTY CHARACTER IN THE STRING
        System.out.println(Arrays.asList("Anne of the 1000 days".split("."))); //EMPTY ARRAY BECAUSE SPLIT REMOVES EACH MATCHED CHARACTER IN THE ARRAY. ALL THE CHARACTERS ARE MATCHED SO IT RETURNS NOTHING

        System.out.println(Arrays.asList("one + one = 2".replace("one", "1"))); //REPLACES BOTH INSTANCES ("ONE") TO THE NUMBER 1
        System.out.println(Arrays.asList("one + one = 2".replaceFirst("one", "1"))); //REPLACES ONLY ONE OF THE INSTANCES ("ONE") TO THE NUMBER 1

        String string = "x and tigers and bears, oh my!";
        String replaced = string.replaceAll("q", "Lions"); //REPLACES ALL OCCURRENCES OF THE SUPPLIED REGEX
        System.out.println(string == replaced); //RETURNS THE ORIGINAL STRING
    }
   /* - Quantifiers - Used to specify a fixed or variable repeat count to match a set of characters (Greedy, Reluctant, and Possessive)
      - ? Quantifier - Zero or One ... ? means question: is it 1(yes) or 0(no)
      - Greedy is default quantifier mode: match as much as possible. \d* - as many digits as possible
      - ? Lazy : Match as little as possible. \s+? -As few spaces as possible
      - +Possessive : Like greedy but no back off - \w* + - as many word characters as possible, but no back-off
      - \w+-\w+-\w+-\w+-  indicates that there are exactly 5 sections
      - Named capture groups:  (?<spaces>\s+)(?<text>\w+)(?<digits>\d+)
      - Insensitive flag: (?i)  or   ((?i)my-pattern)   or   ((?i)my-(?-i)pattern)  or (?i:my-pattern)
      - (?i:hot digity) (?i)Dog   turns off the case sensitivity for all dogs in the sentence.
    */
}
