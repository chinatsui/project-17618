package me.chinatsui.algorithm.exercise.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode-71
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /,
 * and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from root directory is a no-op, as the root level is the highest level you can go.
 * <p>
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * <p>
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * <p>
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * <p>
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String input = "/a//b////c/d//././/..";
        String[] parts = input.split("/+");
        System.out.println(Arrays.toString(parts));
    }

    public String canonicalPath(String path) {
        if (path == null || path.length() < 1) {
            return path;
        }

        int n = path.length(), i = 0, j = 0;
        ArrayList<String> parts = new ArrayList<>();
        char[] ch = path.toCharArray();

        for (; j < n; j++) {
            if (ch[i] == '/' && ch[j] != '/') {
                i = j;
            } else if (ch[i] != '/' && ch[j] == '/') {
                parts.add(path.substring(i, j));
                i = j;
            }
        }

        if (ch[i] != '/') {
            parts.add(path.substring(i));
        }


        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if ("..".equals(part) && !stack.isEmpty()) {
                stack.pop();
            } else if (".".equals(part)) {
                continue;
            } else if (!"..".equals(part)) {
                stack.push(part);
            }
        }

        StringBuilder builder = new StringBuilder();
        stack.forEach(p -> builder.append("/").append(p));

        String res = builder.toString();
        return res.length() < 1 ? "/" : res;
    }
}
