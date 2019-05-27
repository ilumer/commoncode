package code.snippets.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilumer
 * Date : 2019-05-27
 * Time : 11:30
 */
public class InterfaceThreadSafe {

    //interface 中的变量不是线程安全的 interface中的变量是存储在static context中的
    public static void main(String[] args) throws InterruptedException {
        TestInterfaceSafe a = new A();
        TestInterfaceSafe b = new B();
        TestThread testThread = new TestThread(a);
        TestThread testThread1 = new TestThread(b);
        testThread.run();
        testThread1.run();
        testThread.join();
        testThread1.join();
        System.out.println(a.addString("").size());
        System.out.println(b.addString("").size());
        System.out.println(a.getResult());
        System.out.println(b.getResult());

    }


    static class TestThread extends Thread{

        private TestInterfaceSafe a;

        public TestThread(TestInterfaceSafe a) {
            this.a = a;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100 ; i++) {
                a.addString(String.valueOf(i));
            }
        }
    }


    static class A implements TestInterfaceSafe {
        @Override
        public List<String> addString(String s) {
            result.add(s);
            return result;
        }
    }

    static class B implements TestInterfaceSafe {
        @Override
        public List<String> addString(String s) {
            result.add(s);
            return result;
        }
    }


    interface TestInterfaceSafe {
        List<String> result = new ArrayList<>();

        List<String> addString(String s);

        default List<String> getResult(){
            return result;
        }
    }
}
