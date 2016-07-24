package change;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter the amount the item cost: ");
		float price = keyboard.nextFloat();
		System.out.print("How much do you have to pay for it? ");
		float tendered = keyboard.nextFloat();

		keyboard.close();
		float totalChange = tendered - price;
		int dollarsOwed = (int) (totalChange);
		float centsOwed1 = totalChange - dollarsOwed;
		float centsOwed2 = centsOwed1 * 100;
		int centsOwed = (int) (centsOwed2);

		int[] dollarBills = { 25, 10, 5, 1, };
		int[] cents = { 25, 10, 5, 1, };

		int[] count1 = dollarChange(dollarBills, dollarsOwed);

		// dollars determined here
		for (int i = 0; i < dollarBills.length; i++) {

			if (totalChange < 0) {
				System.out.println("You have not given me enough money.");
				System.out.println("Come back when you have enough $$ to pay for the item.");
				break;
			}

			else if (count1[i] > 0) {
				System.out.print("Your change is: ");
				System.out.println(count1[i] + " x " + dollarBills[i] + " dollar bill");
			}

		}
		int[] count2 = centsChange(cents, centsOwed);

		// cents determined here
		for (int j = 0; j < cents.length; j++) {
			if (count2[j] > 0) {
				System.out.println(count2[j] + " x " + cents[j] + " cents");
			}
		}

	}

	private static int[] dollarChange(int[] dollarBills, int dollarsOwed) {
		int[] count1 = new int[dollarBills.length];

		// Looping through each denomination (starting at largest)
		for (int i = 0; i < dollarBills.length; i++) {

			// Use denomination until the need for smaller denomination
			while (dollarsOwed >= dollarBills[i]) {
				count1[i]++;
				dollarsOwed = dollarsOwed - dollarBills[i];
			}
		}

		return count1;
	}

	private static int[] centsChange(int[] cents, int centsOwed) {
		int[] count2 = new int[cents.length];

		// Loop through each denomination (starting at largest)
		for (int j = 0; j < cents.length; j++) {

			// Use denomination until the need for smaller denomination
			while (centsOwed >= cents[j]) {
				count2[j]++;
				centsOwed = centsOwed - cents[j];
			}
		}

		return count2;
	}
}