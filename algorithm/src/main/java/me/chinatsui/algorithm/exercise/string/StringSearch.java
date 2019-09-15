package me.chinatsui.algorithm.exercise.string;

public abstract class StringSearch {

    protected void validate(char[] text, char[] pattern) {
        assert text != null && pattern != null;
        assert text.length > pattern.length;
        checkUnsupportedChar(text);
        checkUnsupportedChar(pattern);
    }

    abstract void checkUnsupportedChar(char[] seq);
}
