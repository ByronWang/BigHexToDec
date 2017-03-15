import static org.junit.Assert.*;

import org.junit.Test;

public class DelphiBigHexToBinTest {

	@Test
	public void testBigAddAry() {
		DelphiBigHexToBin d = new DelphiBigHexToBin();

		{
			int[] value1 = new int[d.MAX_ARY_LEN];
			int[] value2 = new int[d.MAX_ARY_LEN];
			value1[d.MAX_ARY_LEN - 1] = 8;

			value2[d.MAX_ARY_LEN - 1 - 1] = 1;
			value2[d.MAX_ARY_LEN - 1] = 9;

			d.BigAddAry(value1, d.MAX_ARY_LEN, value2, d.MAX_ARY_LEN);

			assertEquals("BigMulti", " 2 7", toString(value1));
		}
		{
			int[] value1 = new int[d.MAX_ARY_LEN];
			int[] value2 = new int[d.MAX_ARY_LEN];

			int j = 1;
			value1[d.MAX_ARY_LEN - j++] = 1;
			// value1[d.MAX_ARY_LEN - j++] = 2;
			// value1[d.MAX_ARY_LEN - j++] = 3;
			// value1[d.MAX_ARY_LEN - j++] = 4;
			// value1[d.MAX_ARY_LEN - j++] = 5;

			j = 1;
			value2[d.MAX_ARY_LEN - j++] = 1;
			// value2[d.MAX_ARY_LEN - j++] = 2;
			// value2[d.MAX_ARY_LEN - j++] = 3;
			// value2[d.MAX_ARY_LEN - j++] = 4;
			// value2[d.MAX_ARY_LEN - j++] = 5;

			d.BigAddAry(value1, d.MAX_ARY_LEN, value2, d.MAX_ARY_LEN);

			assertEquals("BigMulti", " 2", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];
			int[] value2 = new int[d.MAX_ARY_LEN];

			int j = 1;
			value1[d.MAX_ARY_LEN - j++] = 1;
			value1[d.MAX_ARY_LEN - j++] = 2;
			// value1[d.MAX_ARY_LEN - j++] = 3;
			// value1[d.MAX_ARY_LEN - j++] = 4;
			// value1[d.MAX_ARY_LEN - j++] = 5;

			j = 1;
			value2[d.MAX_ARY_LEN - j++] = 1;
			// value2[d.MAX_ARY_LEN - j++] = 2;
			// value2[d.MAX_ARY_LEN - j++] = 3;
			// value2[d.MAX_ARY_LEN - j++] = 4;
			// value2[d.MAX_ARY_LEN - j++] = 5;

			d.BigAddAry(value1, d.MAX_ARY_LEN, value2, d.MAX_ARY_LEN);

			assertEquals("BigMulti", " 2 2", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];
			int[] value2 = new int[d.MAX_ARY_LEN];

			int j = 1;
			value1[d.MAX_ARY_LEN - j++] = 1;
			value1[d.MAX_ARY_LEN - j++] = 2;
			// value1[d.MAX_ARY_LEN - j++] = 3;
			// value1[d.MAX_ARY_LEN - j++] = 4;
			// value1[d.MAX_ARY_LEN - j++] = 5;

			j = 1;
			value2[d.MAX_ARY_LEN - j++] = 1;
			value2[d.MAX_ARY_LEN - j++] = 2;
			// value2[d.MAX_ARY_LEN - j++] = 3;
			// value2[d.MAX_ARY_LEN - j++] = 4;
			// value2[d.MAX_ARY_LEN - j++] = 5;

			d.BigAddAry(value1, d.MAX_ARY_LEN, value2, d.MAX_ARY_LEN);

			assertEquals("BigMulti", " 4 2", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];
			int[] value2 = new int[d.MAX_ARY_LEN];

			int j = 1;
			value1[d.MAX_ARY_LEN - j++] = 1;
			value1[d.MAX_ARY_LEN - j++] = 2;
			value1[d.MAX_ARY_LEN - j++] = 3;
			value1[d.MAX_ARY_LEN - j++] = 4;
			// value1[d.MAX_ARY_LEN - j++] = 5;

			j = 1;
			value2[d.MAX_ARY_LEN - j++] = 1;
			value2[d.MAX_ARY_LEN - j++] = 2;
			value2[d.MAX_ARY_LEN - j++] = 3;
			value2[d.MAX_ARY_LEN - j++] = 4;
			// value2[d.MAX_ARY_LEN - j++] = 5;

			d.BigAddAry(value1, d.MAX_ARY_LEN, value2, d.MAX_ARY_LEN);

			assertEquals("BigMulti", " 8 6 4 2", toString(value1));
		}
	}

	@Test
	public void testBigMulti() {
		DelphiBigHexToBin d = new DelphiBigHexToBin();

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			value1[d.MAX_ARY_LEN - 1] = 8;
			value1[d.MAX_ARY_LEN - 1 - 1] = 1;

			d.BigMulti(value1, d.MAX_ARY_LEN, 8);
			assertEquals("BigMulti", " 1 4 4", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			value1[d.MAX_ARY_LEN - 1] = 1;

			d.BigMulti(value1, d.MAX_ARY_LEN, 8);
			assertEquals("BigMulti", " 8", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			value1[d.MAX_ARY_LEN - 1 - 1] = 1;

			d.BigMulti(value1, d.MAX_ARY_LEN, 8);
			assertEquals("BigMulti", " 8 0", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			value1[d.MAX_ARY_LEN - 1] = 8;
			value1[d.MAX_ARY_LEN - 1 - 1] = 8;

			d.BigMulti(value1, d.MAX_ARY_LEN, 1);
			assertEquals("BigMulti", " 8 8", toString(value1));
		}
	}

	private String toString(int[] va) {
		int i = 0;
		for (i = 0; i < va.length; i++) {
			if (va[i] > 0)
				break;
		}

		String s = "";
		for (; i < va.length; i++) {
			s += " " + va[i];
		}
		return s;
	}

	@Test
	public void testBigPower() {
		DelphiBigHexToBin d = new DelphiBigHexToBin();

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			d.BigPower(value1, d.MAX_ARY_LEN, 16, 1);

			assertEquals("BigMulti", " 1 6", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			d.BigPower(value1, d.MAX_ARY_LEN, 16, 2);

			assertEquals("BigMulti", " 2 5 6", toString(value1));
		}

		{
			int[] value1 = new int[d.MAX_ARY_LEN];

			d.BigPower(value1, d.MAX_ARY_LEN, 16, 3);

			assertEquals("BigMulti", " 4 0 9 6", toString(value1));
		}

	}

	@Test
	public void testBigHexToBin() {

		DelphiBigHexToBin d = new DelphiBigHexToBin();
		{
			String sInput = "A1";

			String actual = d.BigHexToBin(sInput);

			assertEquals("BigMulti", "161", actual);
		}
		{
			String sInput = "10";

			String actual = d.BigHexToBin(sInput);

			assertEquals("BigMulti", "16", actual);
		}
		{
			String sInput = "1";

			String actual = d.BigHexToBin(sInput);

			assertEquals("BigMulti", "1", actual);
		}
		{
			String sInput = "A135576573";

			String actual = d.BigHexToBin(sInput);

			assertEquals("BigMulti", "692384654707", actual);
		}
		{
			String sInput = "2000";

			String actual = d.BigHexToBin(sInput);

			assertEquals("BigMulti", "8192", actual);
		}
	}

}
