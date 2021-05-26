package com.aeroplane.main;

import java.util.ArrayList;
import java.util.List;

public class AeroplaneSeatingAlgorithm {

	private int totalAliseSeats;

	private int totalMiddleSeats;

	private int totalWindowSeats;

	private int maxColumn;

	/**
	 * This method is used to do seating arrangement
	 * 
	 * @param inputArray
	 * @param noOfPassagers
	 * @return
	 */
	public List<int[][]> doSeatingAlgorithm(int inputArray[][], int noOfPassagers) {
		AeroplaneSeatingAlgorithm aeroplaneObj = new AeroplaneSeatingAlgorithm();
		List<int[][]> allSeats = aeroplaneObj.calculateSeatsCount(inputArray);
		return aeroplaneObj.fillAllSeats(inputArray, allSeats, noOfPassagers);
	}

	/**
	 * This method is used to calculate all the seats counts
	 * 
	 * @param seats
	 */
	List<int[][]> calculateSeatsCount(int seats[][]) {
		List<int[][]> allSeats = new ArrayList<int[][]>();
		for (int i = 0; i < seats.length; i++) {
			if ((i == 0 || i == seats.length - 1)) {
				if (seats[i][0] > 1) {
					totalAliseSeats += seats[i][1];
				}
				totalWindowSeats += seats[i][1];
			} else {
				totalAliseSeats += seats[i][0] > 1 ? seats[i][1] * 2 : seats[i][1];
			}
			if (seats[i][0] > 2) {
				int middleColumnsCount = seats[i][0] - 2;
				if (middleColumnsCount != 0) {
					totalMiddleSeats += middleColumnsCount > 1 ? seats[i][1] * middleColumnsCount : seats[i][1];
				}
			}
			if (maxColumn < seats[i][1]) {
				maxColumn = seats[i][1];
			}
			allSeats.add(new int[seats[i][1]][seats[i][0]]);
		}
		return allSeats;
	}

	/**
	 * This method is used to fill the seats for reserved passengers
	 * 
	 * @param seats
	 * @param allSeats
	 * @param noOfPassengers
	 */
	List<int[][]> fillAllSeats(int seats[][], List<int[][]> allSeats, int noOfPassengers) {
		int mainLoopCount = maxColumn * seats.length;
		int lastFilledAlise = 0;
		int lastFilledWindow = totalAliseSeats;
		int lastFilledMiddle = totalAliseSeats + totalWindowSeats;
		int index = 0;
		int columnIncrement = 0;
		for (int count = 0; count < mainLoopCount; count++) {
			if (columnIncrement < seats[index][1]) {
				int arr[][] = allSeats.get(index);
				for (int j = 0; j < seats[index][0]; j++) {
					if ((j == 0 || j == seats[index][0] - 1)) {
						if (((j == seats[index][0] - 1 && seats.length - 1 == index) || (j == 0 && index == 0))
								&& lastFilledWindow < noOfPassengers) {
							arr[columnIncrement][j] = lastFilledWindow + 1;
							lastFilledWindow += 1;
						} else if ((seats[index][0] > 0 && (j == seats[index][0] - 1 || j == 0)) && ((j != 0 || index > 0) && 
								(seats.length - 1 != index || j != seats[index][0] - 1 )) && lastFilledAlise < noOfPassengers) {
							arr[columnIncrement][j] = lastFilledAlise + 1;
							lastFilledAlise += 1;
						}
					} else if (seats[index][0] > 2 && lastFilledMiddle < noOfPassengers) {
						arr[columnIncrement][j] = lastFilledMiddle + 1;
						lastFilledMiddle += 1;
					}
				}
				allSeats.set(index, arr);
			}
			if (index == seats.length - 1) {
				index = 0;
				columnIncrement++;
			} else {
				index++;
			}
		}
		return allSeats;

	}

}
