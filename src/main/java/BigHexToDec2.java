import java.util.ArrayList;
import java.util.List;

public class BigHexToDec2 {

	// String[] h1 = new String[] { "16", "256", "4096", "65536", "1048576",
	// "16777216", "268435456", "4294967296",
	// "68719476736", "1099511627776", "17592186044416", "281474976710656",
	// "4503599627370496" };

	String hex2dec(String sInput) {
		char[] s = sInput.toUpperCase().toCharArray();

		int[] v = new int[500];

		v[v.length - 1] += StrToInt(s[s.length - 1]);

		for (int i = 1; i < s.length; i++) {
			int cv = StrToInt(s[s.length - i - 1]);
			int[] hv = SimpleBigPower(16, i);
			for (int k = 0; k < hv.length; k++) {
				int hvc = hv[hv.length - k - 1];
				v[v.length - k - 1] += hvc * cv;
			}
		}

		{
			int m = 0;
			int i = 0;
			int max = 0;
			for (; max < v.length; max++) {
				if (v[max] > 0)
					break;
			}
			for (i = v.length - 1; i >= max; i--) {
				int d = v[i] + m;
				m = d / 10;
				v[i] = d % 10;
			}
		}

		String resu = "";
		int i = 0;
		for (; i < v.length; i++) {
			if (v[i] > 0)
				break;
		}

		for (; i < v.length; i++) {
			resu += (char) (v[i] + '0');
		}

		return resu;
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

	List<int[]> power = new ArrayList<>();
	int maxPower = 0;

	int[] SimpleBigPower(int base, int Exponent) {

		if (power.size() > Exponent + 1) {
			return power.get(Exponent);
		}

		if (power.size() == 0) {
			int[] last = new int[1];

			if (Exponent >= 0) {
				last[last.length - 1] = 1;
			}
			power.add(last);
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

	public static void main(String[] args) {
		if (args.length > 0) {
			String in = args[0];
			in = "AB3454e34225";
			BigHexToDec b = new BigHexToDec();
			String out = b.hex2dec(in);

			long begin = System.currentTimeMillis();
			int max = 10 * 1000 * 1000;
			for (int i = 0; i < max; i++) {
				out = b.hex2dec(in);
			}
			long end = System.currentTimeMillis();
			System.out.println(max / ((end - begin)));
			System.out.println(((end - begin) / max));

			System.out.println(out);
		}
	}
}
