package studio2;

import java.util.Scanner;

public class GamblersRuin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//starting parameters		
Scanner scan = new Scanner(System.in);
System.out.println("what is the starting amount?");
double startAmount = scan.nextDouble();
System.out.println("what is the win chance (0-1)?");
double winChance = scan.nextDouble();
System.out.println("what is the win limit");
double winLimit = scan.nextDouble();
System.out.println("how many simulations?");
double numSims = scan.nextInt();

//gambling simulation
double safeStartAmount = startAmount;
int flips = 0;
int wins = 0;
int losses = 0;
for (int i = 0; i < numSims; i++) {
	while (0 < startAmount && startAmount < winLimit)
		{
		double ranChance = (double)Math.random();
		boolean winOrLoss = winChance > ranChance;
		if (winOrLoss)
			{
			startAmount++;
			flips++;
			wins++;
			}
		else
			{
			startAmount--;
			flips++;
			losses++;
			}
		}
	
	if (startAmount == winLimit)
		{
		System.out.println("you won");
		System.out.println("you gambled " + flips + " times");
		}
	else
		{
		System.out.println("you lost");
		System.out.println("you gambled " + flips + " times");
		}
	 startAmount = safeStartAmount;
	 flips = 0;
	}

System.out.println("you won " + wins + " times");
System.out.println("you lost " + losses + " times");

double ruinRate = losses / (losses + wins);
System.out.println("your ruin rate was " + ruinRate);

if (winChance == 0.5) {
	double expRuinRate = (1 - startAmount) / winLimit; }
else {
	double alpha = (1 - winChance) / winChance;
	double expRuinRate  = (Math.pow(alpha,startAmount)  - Math.pow(alpha,winLimit)) / (1 - Math.pow(alpha, winLimit));   
}
}
}
