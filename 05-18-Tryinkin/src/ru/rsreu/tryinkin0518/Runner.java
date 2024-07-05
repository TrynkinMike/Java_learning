package ru.rsreu.tryinkin0518;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.tryinkin0518.typesOfLoans.MortgageLoan;

public class Runner {
	private static final int LOANS_COUNT = 3;

	private Runner() {

	}

	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();

		LoanContainer loanBase = LoanInitializer.initializeLoanContainer(LOANS_COUNT);

		output.append(loanBase.printTotalInfo(0));

		// searching the Mortgage loan. Using the first one's percentage rate.
		int loanType = 1;
		MortgageLoan temp = LoanInitializer.initializeMortgageLoan();
		double percentage = loanBase.getMortgageLoans()[0].getPercentageRate();
		temp.setPercentageRate(percentage);

		int offerByPercentage = MortgageLoan.searchByPercentageRate(loanBase.getMortgageLoans(), temp);

		if (offerByPercentage >= 0) {
			output.append(Resourcer.getString("message.loanFound"));
			output.append(loanBase.printInfoAboutNeededLoan(loanType, offerByPercentage));
		} else {
			output.append(Resourcer.getString("message.loanNotFound"));
		}

		System.out.println(output.toString());
	}
}
