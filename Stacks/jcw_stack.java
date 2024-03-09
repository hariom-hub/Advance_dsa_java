import java.util.*;

public class jcw_stack {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.add(1);
        st.add(2);
        st.add(3);
        st.add(8);

        st.push(5);
        st.pop();
        st.pop();
        System.out.println(st);
        System.out.println(st.isEmpty());
    }
}
