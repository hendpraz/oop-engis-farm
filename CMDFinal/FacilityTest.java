import junit.framework.TestCase;
import facilities.*;

public class FacilityTest extends TestCase {
    public void FacilityClass() {
        Facility f = new Facility();
        assertEquals("f", f.render());
    }
}