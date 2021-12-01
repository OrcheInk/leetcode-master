import java.util.Objects;

import pers.ricardolp.leetcode.easy.TwoSum1;

/**
 * Test.
 *
 * @author RicardoLP
 * @since 2021/11/30
 */
public class Test {

    private int A;
    private int B;
    private int C;
    private String name;

    public static void main(String[] args) {

        String a = "a";
        String b = "a";

        // String c = new String("a");
        // String d = "b";
        // String e = null;
        //
        // System.out.println("a.hashcode: " + a.hashCode());
        // System.out.println("b.hashcode: " + b.hashCode());
        // System.out.println("c.hashcode: " + c.hashCode());
        // System.out.println("d.hashcode: " + d.hashCode());
        // System.out.println("d.hashcode: " + new Character('b').hashCode());
        //
        //
        // System.out.println("----------------------------------");
        // boolean x = a == b;
        // boolean b1 = a == c;
        // boolean equals = Objects.equals(a, b);
        // boolean equals1 = a.equals(b);
        //
        // System.out.println("a==b: " + x);
        // System.out.println("a==c: " + b1);
        // System.out.println("Objects.equals(a, b): " + equals);
        // System.out.println("a.equals(b) " + equals1);

        Test t = new Test();
        Class<? extends Test> aClass = t.getClass();
        System.out.println(aClass);

        TwoSum1 twoSum1 = new TwoSum1();
        Class<? extends TwoSum1> sum1Class = twoSum1.getClass();
        System.out.println(sum1Class);

    }

    @Override
    public String toString() {
        return "Test{" + "name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Test)) {
            return false;
        }
        Test test = (Test)o;
        return A == test.A && B == test.B && C == test.C;
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C);
    }
}
