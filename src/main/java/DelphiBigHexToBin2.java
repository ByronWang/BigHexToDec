public class DelphiBigHexToBin2 {

	long longBigPower = 0;
	long longBigMulti = 0;
	long longBigAddAry = 0;

	int MAX_ARY_LEN = 100;

	void BigAddAry(int[] value, int len, int[] value1, int len1) {
		int i = 0;
		for (i = 0; i < len; i++) {
			value[len - i - 1] = value[len - i - 1] + value1[len1 - i - 1];
		}

		for (i = 0; i < len; i++) {
			while (value[len - i - 1] >= 10) {
				value[len - i - 2] += 1;
				value[len - i - 1] += -10;
			}
		}
	}

	void BigMulti(int[] left, int len, int right) {
		int i;
		int[] result;

		if (right == 0) {
			for (i = 0; i <= len - 1; i++)
				left[i] = 0;
		} else {
			result = new int[len];
			for (i = 0; i <= len - 1; i++)
				result[i] = left[i];

			for (i = 0; i <= right - 2; i++) {
				BigAddAry(left, len, result, len);// 首位溢出未处理,len足够大可以避免
			}

		}

	}

	void BigPower(int[] value, int len, int base, int Exponent)
	// i,iTemp:integer;
	{
		int i = 0;
		int iTemp = base;
		if (Exponent == 0) {
			value[len - i - 1] = 1;
			return;
		}

		while (true) {
			value[len - i - 1] = iTemp % 10;
			i++;
			iTemp = iTemp / 10;
			if (iTemp == 0)
				break;
		}

		for (i = 0; i < Exponent - 1; i++) {
			BigMulti(value, len, base);
		}
	}

	String BigHexToBin(String sInput) {
		String s;
		String strValue;
		// int i, j, iTemp, iValidPos;

		strValue = "";
		s = sInput;

		char[] sa = s.toUpperCase().toCharArray();
		int[] value = new int[MAX_ARY_LEN];
		int[] value2 = new int[MAX_ARY_LEN];

		long begin, end;

		for (int i = 0; i < sa.length; i++) {
			int iTemp = StrToInt(sa[sa.length - i - 1]);

			for (int j = 0; j <= MAX_ARY_LEN - 1; j++) {
				value2[j] = 0;
			}

			begin = System.currentTimeMillis();
			BigPower(value2, MAX_ARY_LEN, 16, i);
			end = System.currentTimeMillis();
			longBigPower += end - begin;

			begin = System.currentTimeMillis();
			BigMulti(value2, MAX_ARY_LEN, iTemp);
			end = System.currentTimeMillis();
			longBigMulti += end - begin;

			begin = System.currentTimeMillis();
			BigAddAry(value, MAX_ARY_LEN, value2, MAX_ARY_LEN);
			end = System.currentTimeMillis();
			longBigAddAry += end - begin;

		}

		// TO String
		int iValidPos = -1;
		for (int i = 0; i < MAX_ARY_LEN; i++) {
			if (value[i] != 0)
				iValidPos = i;

			if (iValidPos > 0)
				strValue = strValue + IntToStr(value[i]);
		}

		return strValue;
	}

	private String IntToStr(int i) {
		return new String(new char[] { (char) (i + '0') });
	}

	private int StrToInt(char charAt) {
		if ('0' <= charAt && charAt <= '9') {
			return charAt - '0';
		} else if ('A' <= charAt && charAt <= 'F') {
			return charAt - 'A' + 10;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String in = "1000";

		in = "AB3454e34225";
		DelphiBigHexToBin2 to = new DelphiBigHexToBin2();

		String out = to.BigHexToBin(in);

		long begin = System.currentTimeMillis();
		int max = 10 * 1000;
		for (int i = 0; i < max; i++) {
			out = to.BigHexToBin(in);
		}
		long end = System.currentTimeMillis();
		System.out.println(max / ((end - begin)));
		System.out.println(((end - begin) / max));
		System.out.println(out);

		System.out.println(to.longBigPower);
		System.out.println(to.longBigMulti);
		System.out.println(to.longBigAddAry);
	}

}
