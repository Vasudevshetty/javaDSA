package dsa.stack.Test;

import dsa.stack.NotationConvertor;
import dsa.stack.NotationConvertor.NotationType;

public class Main {
    public static void main(String[] args) {
        String infix = "8+(8/4)*5";
        System.out.println(NotationConvertor.evaulate(NotationConvertor.postfix(infix, NotationType.infix), NotationType.postfix)+ " "
                + NotationConvertor.prefix(NotationConvertor.postfix(infix, NotationType.infix), NotationType.postfix));
    }
}
