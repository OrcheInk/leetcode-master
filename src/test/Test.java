import java.util.HashSet;
import java.util.Set;

/**
 * Test Class.
 *
 * @author RicardoLP
 * @since 2021/12/3
 */
public class Test {
    private int i;

    public static void main(String[] args) {
        Test a = new Test();
        Test b = new Test();
        a.setI(1);
        b.setI(1);
        Set<Test> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int hashCode() {
        return i % 10;
    }

}
