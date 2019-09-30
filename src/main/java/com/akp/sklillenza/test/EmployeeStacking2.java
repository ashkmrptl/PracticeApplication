package com.akp.sklillenza.test;

import java.util.Scanner;

public class EmployeeStacking2 {
	private static final String SPACE_CHAR = " ";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer t = scanner.nextInt();
		// System.out.println("t : " + t);
		for (Integer i = 0; i < t; i++) {
			String tempData = scanner.nextLine();
			if (tempData.isEmpty()) {
				tempData = scanner.nextLine();
			}
			String[] dataArray = tempData.split(SPACE_CHAR);
			Integer e = Integer.parseInt(dataArray[0]);// no of employees
			Integer d = Integer.parseInt(dataArray[2]);// threshold distance

			String sampleEmpData = scanner.nextLine();

			Integer totalNoOfEmpToFire = 0;
			for (Integer j = 0; j < e; j++) {
				String empVector = scanner.nextLine();
				Integer empDistance = calculateDistance(sampleEmpData, empVector);
				if (empDistance <= d) {
					totalNoOfEmpToFire++;
				}
			}

			System.out.println(totalNoOfEmpToFire);

		}

		// Closing the scanner
		scanner.close();
	}

	private static Integer calculateDistance(String sample, String data) {
		int distance = 0;
		String[] sampleArr = sample.split(SPACE_CHAR);
		String[] dataArr = data.split(SPACE_CHAR);
		for (int i = 0; i < sampleArr.length; i++) {
			if (!sampleArr[i].equals(dataArr[i])) {
				distance++;
			}
		}
		return distance;
	}
}
