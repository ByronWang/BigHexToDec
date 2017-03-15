import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class DelphiBigHexToBin3 {

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

	void BigSimpleAddAry(int[] value, int len, int[] value1, int len1) {
		int i = 0;
		for (i = 0; i < len; i++) {
			value[len - i - 1] = value[len - i - 1] + value1[len1 - i - 1];
		}
	}

	void refineBigAry(int[] v, int len) {
		{
			int m = 0;
			int i = 0;
			int max = 0;
			for (; max < len; max++) {
				if (v[max] > 0)
					break;
			}
			for (i = len - 1; i >= max; i--) {
				int d = v[i] + m;
				m = d / 10;
				v[i] = d % 10;
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

	List<int[]> power = new ArrayList<>();
	int maxPower = 0;

	int[] SimpleBigPower(int base, int Exponent) {

		if (power.size() > Exponent + 1) {
			return power.get(Exponent);
		}

		if (power.size() == 0) {
			int[] buffer = new int[1];

			if (Exponent >= 0) {
				buffer[buffer.length - 1] = 1;
			}
			power.add(buffer);
		}

		int[] buffer = new int[Exponent * 3 + 1];

		int[] last = power.get(power.size() - 1);
		maxPower = power.size() - 1;

		System.arraycopy(last, 0, buffer, buffer.length - last.length, last.length);

		int low = buffer.length - last.length;
		{
			for (int i = maxPower + 1; i <= Exponent; i++) {

				for (int j = buffer.length - 1; j >= low; j--) {
					buffer[j] *= base;
				}

				{
					{
						int j, m = 0;
						for (j = buffer.length - 1; j >= low; j--) {
							int d = buffer[j] + m;
							m = d / 10;
							buffer[j] = d % 10;
						}

						while (m > 0) {
							int d = m;
							m = d / 10;
							buffer[j--] = d % 10;
						}
						low = j;
					}
				}

				int[] result = new int[buffer.length - low];

				System.arraycopy(buffer, low, result, 0, result.length);
				power.add(result);

			}
		}

		return power.get(Exponent);
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
			int[] v2 = SimpleBigPower(16, i);
			System.arraycopy(v2, 0, value2, value2.length - v2.length, v2.length);
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

		refineBigAry(value, MAX_ARY_LEN);

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
		DelphiBigHexToBin3 to = new DelphiBigHexToBin3();
		
		to.SimpleBigPower(16, 30);

		String out = to.BigHexToBin(in);

		long begin = System.currentTimeMillis();
		int max = 100 * 1000;
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
