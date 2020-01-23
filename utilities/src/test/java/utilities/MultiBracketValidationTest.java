package utilities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultiBracketValidationTest {
    @Test public void mbv_returnsTrueWithBalancedString() {
        assertTrue(MultiBracketValidation.multiBracketValidation("(){}[]"));
    }
    @Test public void mbv_returnsTrueWithComplexBalancedString() {
        assertTrue(MultiBracketValidation.multiBracketValidation("(({})[]()[{}])"));
    }
    @Test public void mbv_returnsFalseWithUnbalancedString() {
        assertFalse(MultiBracketValidation.multiBracketValidation("((}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("]"));
        assertFalse(MultiBracketValidation.multiBracketValidation("({]{)}"));
    }
    @Test public void mbv_ignoresNonBrackets() {
        assertTrue(MultiBracketValidation.multiBracketValidation("(({3})[gsd](s)[{as}]gg)"));
        assertFalse(MultiBracketValidation.multiBracketValidation("(banana{]{po)ta}to"));
    }
    @Test public void mbv_returnsFalseAtPrematureClosingBracket() {
        assertFalse(MultiBracketValidation.multiBracketValidation(")("));
    }
}
