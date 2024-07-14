package src.test.java.mypackage;
import org.junit.*;

import src.main.java.hello.Greeter;
public class GreeterTest {
    @Test
    public void test() {
        Greeter gre = new Greeter();
        Assert.assertEquals("Hello world!",gre.sayHello());
    }
}
