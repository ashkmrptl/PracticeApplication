package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * Program has wrong output
 */
public class MagicalSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int d = Integer.parseInt(br.readLine());
			String s = br.readLine();

			String[] array = s.split("");
			for (int i = array.length - 1; i >= 0; i -= 2) {
				// sum += Integer.parseInt(String.valueOf(array[i]));
				array[i] = (Integer.parseInt(array[i]) * 2) + "";
				System.out.println("array[i] : " + array[i]);
				if (Integer.parseInt(array[i]) > 9) {
					int a = Integer.parseInt(array[i]) % 10;
					int b = (Integer.parseInt(array[i]) - a) / 10;

					System.out.println("a : " + a + " b : " + b);

					array[i] = (a + b) + "";
					System.out.println("array[i] : " + array[i]);
				}
			}

		}

		br.close();
		bw.close();
	}
}
