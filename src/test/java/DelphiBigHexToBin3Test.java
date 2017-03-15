import static org.junit.Assert.*;

import org.junit.Test;

public class DelphiBigHexToBin3Test {

	@Test
	public void testBigAddAry() {
		fail("Not yet implemented");
	}

	@Test
	public void testBigSimpleAddAry() {
		fail("Not yet implemented");
	}

	@Test
	public void testRefineBigAry() {
		fail("Not yet implemented");
	}

	@Test
	public void testBigMulti() {
		fail("Not yet implemented");
	}

	@Test
	public void testBigPower() {
		fail("Not yet implemented");
	}

	@Test
	public void testSimpleBigPower() {

		DelphiBigHexToBin3 d = new DelphiBigHexToBin3();

		{
			int[] v = d.SimpleBigPower(16, 0);

			assertEquals("BigMulti", " 1", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 1);

			assertEquals("BigMulti", " 1 6", toString(v));
		}
		{

			int[] v = d.SimpleBigPower(16, 2);

			assertEquals("BigMulti", " 2 5 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 3);

			assertEquals("BigMulti", " 4 0 9 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 4);

			assertEquals("BigMulti", " 6 5 5 3 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 5);

			assertEquals("BigMulti", " 1 0 4 8 5 7 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 6);

			assertEquals("BigMulti", " 1 6 7 7 7 2 1 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 7);

			assertEquals("BigMulti", " 2 6 8 4 3 5 4 5 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 8);

			assertEquals("BigMulti", " 4 2 9 4 9 6 7 2 9 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 9);

			assertEquals("BigMulti", " 6 8 7 1 9 4 7 6 7 3 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 10);

			assertEquals("BigMulti", " 1 0 9 9 5 1 1 6 2 7 7 7 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 11);

			assertEquals("BigMulti", " 1 7 5 9 2 1 8 6 0 4 4 4 1 6", toString(v));
		}
		{
			int[] v = d.SimpleBigPower(16, 12);

			assertEquals("BigMulti", " 2 8 1 4 7 4 9 7 6 7 1 0 6 5 6", toString(v));
		}
	}

	@Test
	public void testBigHexToBin() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
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
}
