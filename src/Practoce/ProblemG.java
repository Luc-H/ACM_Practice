package Practoce;

import java.util.Scanner;

public class ProblemG
{
	public static void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String parts[] = scanner.nextLine().split(" ");

			int d = Integer.parseInt(parts[0]);
			int p = Integer.parseInt(parts[1]);

			int[] speeds = new int[d + 1];

			if (Integer.parseInt(parts[2]) > p) {
				System.out.println("The spider is going to fall!");
				continue;
			}

			for (int i = 2; i < parts.length; i++) {
				speeds[i - 2] = Integer.parseInt(parts[i]);
			}

			int a;
			int b;

			if (parts.length != d + 3) {
				if (speeds[2] * speeds[0] - speeds[1] * speeds[1] == 0) {
					a = 0;
				} else {
					a = (speeds[0] * speeds[3] - speeds[1] * speeds[2])/(speeds[2] * speeds[0] - speeds[1] * speeds[1]);
				}
				if (speeds[2] * speeds[0] - speeds[1] * speeds[1] == 0) {
					b = 0;
				} else {
					b = (speeds[2] * speeds[2] - speeds[1] * speeds[3])/(speeds[2] * speeds[0] - speeds[1] * speeds[1]);
				}

				for (int i = 4; i < speeds.length; i++) {
					speeds[i] = a * speeds[i - 1] + b * speeds[i - 2];
				}
			}

			int m = -1;

			for (int i = 0; i < speeds.length; i++) {
				if (speeds[i] > p) {
					m = i;
					break;
				}
			}

			if (m == -1) {
				System.out.println("The spider may fall!");
			} else {
				System.out.println(d + 1 - m);
			}
		}
	}
}
