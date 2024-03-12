import org.junit.Test;
import static org.junit.Assert.*;

public class SecurityTest {

    @Test
    public void testSecurityDefaultConstructor() {
        Security security = new Security();
        assertNull(security.getSecurityId());
        assertNull(security.getName());
        assertNull(security.getLevel());
    }

    @Test
    public void testSecurityParameterizedConstructor() {
        Security security = new Security("ID1", "SecurityName", "High");
        assertEquals("ID1", security.getSecurityId());
        assertEquals("SecurityName", security.getName());
        assertEquals("High", security.getLevel());
    }

    @Test
    public void testSettersAndGetters() {
        Security security = new Security();
        security.setSecurityId("ID2");
        security.setName("AnotherName");
        security.setLevel("Medium");

        assertEquals("ID2", security.getSecurityId());
        assertEquals("AnotherName", security.getName());
        assertEquals("Medium", security.getLevel());
    }
}

