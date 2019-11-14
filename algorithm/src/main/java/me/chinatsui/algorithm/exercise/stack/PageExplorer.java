package me.chinatsui.algorithm.exercise.stack;

import java.util.Stack;

public class PageExplorer {

    private Page current;
    private Stack<Page> forwards = new Stack<>();
    private Stack<Page> backwards = new Stack<>();

    public void navigate(Page page) {
        backwards.push(current);
        current = page;
        forwards.clear();
    }

    public boolean forward() {
        if (!forwards.isEmpty()) {
            backwards.push(current);
            current = forwards.pop();
            return true;
        }

        return false;
    }

    public boolean backward() {
        if (!backwards.isEmpty()) {
            forwards.push(current);
            current = backwards.pop();
            return true;
        }

        return false;
    }

    public Page current() {
        return current;
    }

    static class Page {
        String name;

        public Page(String name) {
            this.name = name;
        }
    }
}
