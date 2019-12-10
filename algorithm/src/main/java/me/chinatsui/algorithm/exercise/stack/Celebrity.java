package me.chinatsui.algorithm.exercise.stack;

import java.util.Stack;

/**
 * In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes,
 * (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
 * Find the stranger (celebrity) in minimum number of questions.
 * <p>
 * We can describe the problem input as an array of numbers/characters representing persons in the party.
 * We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise.
 * How can we solve the problem.
 */
public class Celebrity {

    public int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        int c;

        // Step 1 :Push everybody
        // onto stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            // Step 2 :Pop off top
            // two persons from the
            // stack, discard one
            // person based on return
            // status of knows(A, B).
            int a = st.pop();
            int b = st.pop();

            // Step 3 : Push the
            // remained person onto stack.
            if (knows(a, b)) {
                st.push(b);
            } else
                st.push(a);
        }

        c = st.pop();

        // Step 5 : Check if the last
        // person is celebrity or not
        for (int i = 0; i < n; i++) {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;
        }
        return c;
    }

    private static boolean knows(int a, int b) {
        return true;
    }
}
