package code.snippets.java;

/**
 * https://twitter.com/EclipseJavaIDE/status/1115965653247254528
 */
public class SwitchChange {
    public static void main(String[] args) {
        int x = 16;
        switch (x) {
            case 16: System.out.println("A");
            case 23: System.out.println("B");
            default: System.out.println("C");
            break;
        }
    }
}
