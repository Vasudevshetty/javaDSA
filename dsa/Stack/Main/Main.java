package dsa.Stack.Main;

import dsa.Stack.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>(100);
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st.peek());
        System.out.println(st);
        System.out.println(st.lenght());
        st.pop();
        st.pop();
        System.out.println(st);
    }  
}
