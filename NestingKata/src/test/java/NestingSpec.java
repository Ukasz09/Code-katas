import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class NestingSpec {
    @Test
    void givenSignsContainingSpaceThenException(){
        String signs="()(((( )) )((())( )";
        assertThrows(InvalidParameterException.class,()->Nesting.isNested(signs));
    }

    @Test
    void givenSignsContainingLettersThenException(){
        String signs="()((U))";
        assertThrows(InvalidParameterException.class,()->Nesting.isNested(signs));
    }

    @Test
    void given2SignsWhenProperNestedThenTrue() {
        String signs = "()";
        assertTrue(Nesting.isNested(signs));
    }

    @Test
    void given4SignsWhenProperNestedThenTrue() {
        String signs = "()()";
        assertTrue(Nesting.isNested(signs));
    }

    @Test
    void givenCompoundsSignsWhenProperNestedThenTrue() {
        String signs = "(()(())())";
        String signs2 = "(())((())(()))";
        assertTrue(Nesting.isNested(signs));
        assertTrue(Nesting.isNested(signs2));
    }

    @Test
    void given3signsSignsThenFalse() {
        String signs = "()(";
        assertFalse(Nesting.isNested(signs));
    }

    @Test
    void givenCompoundSignsWhenNotNestedThenFalse() {
        String signs = "(())((())";
        assertFalse(Nesting.isNested(signs));
    }

}
