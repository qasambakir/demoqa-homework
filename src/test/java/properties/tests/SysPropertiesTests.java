package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SysPropertiesTests {

    @Test
    void sysPropertiesFirstTest() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void sysPropertiesTwoTest() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
    }

    @Test
    void sysPropertiesThreeTest() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
    }

    @Test
    @Tag("property")
    void sysPropertiesFourTest() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
    }
}
