import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SamJUnitTest {

    @BeforeEach
    void beforeEach() {

    }

    @Test
    void firstTest() {
        System.out.println("###  firstTest");
        Assertions.assertTrue(3 > 2);
    }
    @Test
    void secondTest() {
        System.out.println("###  secondTest");
        Assertions.assertTrue(5 > 2);
    }
    @Test
    void treeTest() {
        System.out.println("###  treeTest");
        Assertions.assertTrue(4 < 5);
    }

}
