package com.akp.sklillenza.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeStacking {
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
			Integer c = Integer.parseInt(dataArray[1]);// no of elements in vector
			Integer d = Integer.parseInt(dataArray[2]);// threshold distance

			// System.out.println("e : " + e + " c : " + c + " d : " + d);

			String sampleEmpData = scanner.nextLine();
			Integer sampleEmpDataArray[] = new Integer[c];
			// System.out.println("sampleEmpData : " + sampleEmpData);
			for (Integer j = 0; j < c; j++) {
				sampleEmpDataArray[j] = Integer.parseInt(sampleEmpData.split(SPACE_CHAR)[j]);
			}

			// System.out.println("Sample data : " + Arrays.toString(sampleEmpDataArray));
			// Integer sampleData[] = new Integer[c];

			List<Integer[]> empDataList = new ArrayList<>();
			Integer[] empDataArray = null;
			for (Integer j = 0; j < e; j++) {
				String empVector = scanner.nextLine();
				// System.out.println("empVector : " + empVector);
				empDataArray = new Integer[c];
				for (Integer k = 0; k < c; k++) {
					empDataArray[k] = Integer.parseInt(empVector.split(SPACE_CHAR)[k]);
				}
				empDataList.add(empDataArray);
			}

			Integer totalNoOfEmpToFire = 0;
			// Calculating Distance
			for (Integer[] arr : empDataList) {
				Integer empDistance = calculateDistance(sampleEmpDataArray, arr);
				// System.out.println("empDistance : " + empDistance + " for sample : " +
				// Arrays.toString(sampleEmpDataArray) + " and emp vector : " +
				// Arrays.toString(arr));
				if (empDistance <= d) {
					totalNoOfEmpToFire++;
				}
			}

			System.out.println(totalNoOfEmpToFire);

		}

		// Closing the scanner
		scanner.close();
	}

	private static Integer calculateDistance(Integer[] sample, Integer[] data) {
		Integer distance = 0;
		for (int i = 0; i < data.length; i++) {
			if (sample[i] != data[i]) {
				distance++;
			}
		}
		return distance;
	}
}
