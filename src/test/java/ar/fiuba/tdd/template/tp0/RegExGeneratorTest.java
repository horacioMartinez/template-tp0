package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private static final int MAX_LENGTH = 100;

    private boolean validate(String regEx, int numberOfResults) {
        RegExGenerator generator = new RegExGenerator(MAX_LENGTH);
        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                        (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                        (item1, item2) -> item1 && item2);
    }

    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", 1));
    }

    @Test
    public void testMultipleCharacters() {
        assertTrue(validate("...", 1));
    }

    @Test
    public void testLiteral() {
        assertTrue(validate("\\@", 1));
    }

    @Test
    public void testLiteralDotCharacter() {
        assertTrue(validate("\\@..", 1));
    }

    @Test
    public void testZeroOrOneCharacter() {
        assertTrue(validate("\\@.h?", 1));
    }

    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", 1));
    }

    @Test
    public void testCharacterSetWithQuantifiers() {
        assertTrue(validate("[abc]+", 1));
    }

    @Test
    public void testZeroOrManyAnyCharacter() {
        assertTrue(validate(".*", 1));
    }

    @Test
    public void testEscapeManyTimes() {
        assertTrue(validate("asd\\?\\??", 100));
    }

    @Test
    public void testCharacterSetWithOperatorsManyResults() {
        assertTrue(validate("[asd]*?", 250));
    }

    @Test
    public void testMultipleZeroOrMany() {
        assertTrue(validate(".*s*f*h*c*", 250));
    }

    @Test
    public void testEscapeAll() {
        assertTrue(validate("\\.\\*\\[\\]\\+",1));
    }

    @Test
    public void testConcatenatedSetSelectors() {
        assertTrue(validate("[[[aso]d?cs]sd]", 100));
    }

    @Test
    public void testEscapedSetSelectors() {
        assertTrue(validate("[a\\]ssd]", 1));
    }

    @Test(expected = RuntimeException.class)
    public void testMissingSetSelector() {
        validate("zxc[cv]]", 1);
    }

    @Test(expected = RuntimeException.class)
    public void testMissingCharacterBeforeZeroOrMany() {
        validate("*sda", 1);
    }

    @Test(expected = RuntimeException.class)
    public void testMissingCharacterBeforeOneOrMany() {
        validate("+dsa", 1);
    }

    @Test(expected = RuntimeException.class)
    public void testMissingCharacterBeforeZeroOrOne() {
        validate("?asd", 1);
    }

    @Test(expected = RuntimeException.class)
    public void testEmptySetSelectors() {
        validate("[]", 1);
    }

    @Test(expected = RuntimeException.class)
    public void testCharactersWithEmptySetSelectors() {
        validate("aaa[]bbb", 1);
    }

}
