package me.chinatsui.research.algorithm.learning.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chinatsui on 07/01/2018.
 */
public class RegexTest {

    public static void main(String[] args) {
        String input = "<li><p> In Perl, <tt>\\1</tt> through <tt>\\9</tt> are always interpreted\n" +
                "as back references; a backslash-escaped number greater than <tt>9</tt> is\n" +
                "treated as a back reference if at least that many subexpressions exist,\n" +
                "otherwise it is interpreted, if possible, as an octal escape.  In this\n" +
                "class octal escapes must always begin with a zero. In this class,\n" +
                "<tt>\\1</tt> through <tt>\\9</tt> are always interpreted as back\n" +
                "references, and a larger number is accepted as a back reference if at\n" +
                "least that many subexpressions exist at that point in the regular\n" +
                "expression, otherwise the parser will drop digits until the number is\n" +
                "smaller or equal to the existing number of groups or it is one digit.\n" +
                "</p></li>\n" +
                "<li><p> Perl uses the <tt>g</tt> flag to request a match that resumes\n" +
                "where the last match left off.  This functionality is provided implicitly\n" +
                "by the {@link Matcher} class: Repeated invocations of the {@link\n" +
                "Matcher#find find} method will resume where the last match left off,\n" +
                "unless the matcher is reset.  </p></li>\n" +
                "<li><p> In Perl, embedded flags at the top level of an expression affect\n" +
                "the whole expression.  In this class, embedded flags always take effect\n" +
                "at the point at which they appear, whether they are at the top level or\n" +
                "within a group; in the latter case, flags are restored at the end of the\n" +
                "group just as in Perl.  </p></li>";

        Pattern p = Pattern.compile("[1-9a-zA-Z]*");
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group());
        }
    }

}
