package util;

import java.util.Random;

public class Helper {
	public static long RandomLong() {
		Random rand = new Random();
		return Math.abs(rand.nextLong());
	}
}
