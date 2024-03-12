import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TellerTest {

    @Test
    public void testTellerDefaultConstructor() {
        Teller teller = new Teller();
        assertNull(teller.getTellerId());
        assertNull(teller.getName());
        assertNull(teller.getBranchId());
    }

    @Test
    public void testTellerParameterizedConstructor() {
        Teller teller = new Teller("TID1", "TellerName", "Branch1");
        assertEquals("TID1", teller.getTellerId());
        assertEquals("TellerName", teller.getName());
        assertEquals("Branch1", teller.getBranchId());
    }

    @Test
    public void testSettersAndGetters() {
        Teller teller = new Teller();
        teller.setTellerId("TID2");
        teller.setName("AnotherTellerName");
        teller.setBranchId("Branch2");

        assertEquals("TID2", teller.getTellerId());
        assertEquals("AnotherTellerName", teller.getName());
        assertEquals("Branch2", teller.getBranchId());
    }

    public static void main(String[] args){

        org.junit.runner.JUnitCore.main("TellerTest");

    }
}