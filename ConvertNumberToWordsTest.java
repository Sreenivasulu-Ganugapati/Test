import static org.junit.Assert.*;

import org.junit.Test;


public class ConvertNumberToWordsTest {

	@Test
	public void testPositivCase1Convert() {
		assertEquals("one hundred ",ConvertNumberToWords.convert("100") );
	}
	@Test
	public void testPositiveCase2Convert() {
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",ConvertNumberToWords.convert("56945781") );
	}
	@Test
	public void testNegativeConvert() {
		assertEquals("Invalid input",ConvertNumberToWords.convert("str") );
	}
	@Test
	public void testNullConvert() {
		assertEquals("Input is null",ConvertNumberToWords.convert(null) );
	}
}
