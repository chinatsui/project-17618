package me.chinatsui.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class PatternTest {

    @Test
    public void test_greedy_match() {
        String str = "abbbc";
        Pattern p = Pattern.compile("ab{1,3}bc");
        Matcher m = p.matcher(str);

        // 贪婪模式下 b{1,3} 匹配完 bbb 后，会尝试继续匹配 c，发现匹配失败，则 b{1,3} 的匹配结束；
        // 接下来指针会回溯到字符串里的最后一个b，开始再次用 b{1,3} 后面的 b 继续去匹配，发现成功；
        // 最后用 c 去匹配 c 成功，返回 true。
        System.out.println(m.find());
    }

    @Test
    public void test_reluctant_match() {
        String str = "abc";
        Pattern p = Pattern.compile("ab{1,3}?c");
        Matcher m = p.matcher(str);

        // 懒惰模式下，会用尽可能少的 b 去匹配字符串里的 b；
        // 在没有达到最大数量的情况下匹配成功后，会直接用 c 去匹配 c，不会有回溯，最后返回 true；
        // 效率比贪婪模式高。
        System.out.println(m.find());
    }

    @Test
    public void test_possessive_match() {
        String str = "abbc";
        Pattern p = Pattern.compile("ab{1,3}+bc");
        Matcher m = p.matcher(str);

        // 独占模式下，不会发生回溯，所以b{1,3}+ 后面的 b 在 匹配 c 的时候就发生了错误，返回 false。
        System.out.println(m.find());
    }

    @Test
    public void test_caught_groups() {
        String text = "<input high=\"20\" weight=\"70\">test</input>";
        String reg = "(<input.*?>)(.*?)(</input>)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        if (m.find()) {
            System.out.println(m.group(0));// 整个匹配到的内容
            System.out.println(m.group(1));//(<input.*?>)
            System.out.println(m.group(2));//(.*?)
            System.out.println(m.group(3));//(</input>)
        }
    }

    @Test
    public void test_uncaught_groups() {
        String text = "<input high=\"20\" weight=\"70\">test</input>";
        // 如果不需要获取某一个分组内的文本，那么就使用非捕获分组。...
        String reg = "(?:<input.*?>)(.*?)(?:</input>)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        if (m.find()) {
            System.out.println(m.group(0));// 整个匹配到的内容
            System.out.println(m.group(1));//(.*?)
        }
    }
}
