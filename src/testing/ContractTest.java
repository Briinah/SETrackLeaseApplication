package testing;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContractTest {

    @Test
    public void testIfJunitWorks() {
        String junit = "het werkt";
        assertTrue(junit.equals("het werkt"));

    }

    @Test
    public void testIfJunitWorksNot() {
        String junit = "wut";
        assertFalse(junit.equals("het werkt"));

    }


}
