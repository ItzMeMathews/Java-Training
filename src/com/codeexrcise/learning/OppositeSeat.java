package com.codeexrcise.learning;

import java.util.Scanner;

public class OppositeSeat {

	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner s = new Scanner(System.in);
		// Taking No Of Test Cases
		int testCasesNo = s.nextInt();
		for (int i = 0; i < testCasesNo; i++) {
			// Taking Seat No
			int seatNoIP = s.nextInt();
			String seatTypeValue = null;
			int oppSeat = 0;
			int cubicleFirstNo = 0;
			int cubicleLast = 0;
			String[] seatType = new String[] { "WS", "MS", "AS", "AS", "MS", "WS", "WS", "MS", "AS", "AS", "MS", "WS" };
			int startSeatNo = 1, lastSeatNo = 108;
			int[] startSeatNoOfCubicles = new int[(lastSeatNo / 12)];
			startSeatNoOfCubicles[0] = startSeatNo;

			// Storing starting no of each cubicle in an array
			for (int a = 1; a < startSeatNoOfCubicles.length; a++) {
				startSeatNoOfCubicles[a] = startSeatNo + 12;
				startSeatNo += 12;
			}

			// Deriving the cubicle in which input seat no belongs to
			for (int b = 0; b < startSeatNoOfCubicles.length; b++) {

				if (seatNoIP >= 97) {
					cubicleFirstNo = 97;
					cubicleLast = 108;
				} else if (seatNoIP >= startSeatNoOfCubicles[b] && seatNoIP < startSeatNoOfCubicles[b + 1]) {
					cubicleFirstNo = startSeatNoOfCubicles[b];
					cubicleLast = startSeatNoOfCubicles[b + 1] - 1;
				}
			}
			// Deriving the seat type of input seat
			for (int x = cubicleFirstNo, z = 0; x <= cubicleLast; x++, z++) {
				if (x == seatNoIP) {
					seatTypeValue = seatType[z];
				}
			}
			int maxDiff = 11;
			int dec = 0;

			// Deriving opposite seat no of input seat
			for (int d = cubicleFirstNo, e = 0; e <= 6; d++, e++) {
				int oppSeatTemp = d + (maxDiff - dec);
				if (d == seatNoIP) {
					oppSeat = oppSeatTemp;
				} else if ((d + (maxDiff - dec)) == seatNoIP) {
					oppSeat = d;
				}
				dec += 2;
			}
			System.out.println(oppSeat + " " + seatTypeValue);
		}
		s.close();
	}

}
