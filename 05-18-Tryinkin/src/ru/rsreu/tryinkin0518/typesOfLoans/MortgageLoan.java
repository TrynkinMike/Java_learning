package ru.rsreu.tryinkin0518.typesOfLoans;

import java.util.Arrays;
import java.util.Random;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.tryinkin0518.TargetLoan;

public final class MortgageLoan extends TargetLoan implements Comparable<MortgageLoan> {
	private static final int MONTHS_IN_YEAR_COUNT = 12;
	private static final int MAXIMAL_INITIALIZE_PAYMENT_PERCENTAGE = 16;
	private static final int MINIMAL_INITIALIZE_PAYMENT_PERCENTAGE = 5;
	private double initialPayment = 0;
	private double initialPaymentPercentage = 0;

	public MortgageLoan(String name, double percentageRate, double returnPeriod, String[] documents, String companyName,
			boolean possibilityOfEarlyRepayment, boolean possibilityOfIncreasingTheCreditLine) {
		this.setName(name);
		this.setPercentageRate(percentageRate);
		this.setInitialPaymentPercentage();
		this.setReturnPeriod(returnPeriod);
		this.setDocumentsNeeded(documents);
		this.setCompanyName(companyName);
		this.setPossibilityOfEarlyRepayment(possibilityOfEarlyRepayment);
		this.setPossibilityOfIncreasingTheCreditLine(possibilityOfIncreasingTheCreditLine);
	}

	public MortgageLoan() {

	}

	public StringBuilder printTotalInfo(int count) {
		StringBuilder output = new StringBuilder(
				Resourcer.getString("message.info.loan.mortgageLoanInfo") + count + ":");
		String additionalInfo;

		output.append(Resourcer.getString("message.info.loan.name") + this.getName());
		output.append(Resourcer.getString("message.info.loan.percentageRate") + this.getPercentageRate() + "%");
		output.append(Resourcer.getString("message.info.loan.repaymentPeriod") + this.getReturnPeriod());
		output.append(
				Resourcer.getString("message.info.loan.initialPayment") + this.getInitialPaymentPercentage() + "%");

		output.append(Resourcer.getString("message.info.loan.documentsNeeded"));
		for (int i = 0; i < this.getDocumentsNeeded().length; i++) {
			output.append(" " + this.getDocumentsNeeded()[i] + ",");
		}
		output.deleteCharAt(output.length() - 1);

		output.append(Resourcer.getString("message.info.loan.lender") + this.getCompanyName());

		if (this.getPossibilityOfEarlyRepayment()) {
			additionalInfo = Resourcer.getString("message.word.yes");
		} else {
			additionalInfo = Resourcer.getString("message.word.no");
		}
		output.append(Resourcer.getString("message.info.loan.possibilityOfEarlyRepayment") + additionalInfo);

		if (this.getPossibilityOfIncreasingTheCreditLine()) {
			additionalInfo = Resourcer.getString("message.word.yes");
		} else {
			additionalInfo = Resourcer.getString("message.word.no");
		}
		output.append(Resourcer.getString("message.info.loan.possibilityOfIncreasingTheCreditLine") + additionalInfo);

		output.append("\n\n");

		return output;
	}

	@Override
	public void calculateMonthlyPayment() {
		double sum = this.getLoanAmount() - this.getInitialPayment();
		double monthlyPayment = sum * (this.getPercentageRate() + (this.getPercentageRate()
				/ (Math.pow(1 + this.getPercentageRate(), this.getReturnPeriod() * MONTHS_IN_YEAR_COUNT) - 1)));
		this.setMonthlyPayment(monthlyPayment);
	}

	public void setInitialPaymentPercentage() {
		Random random = new Random();
		this.initialPaymentPercentage = random.nextInt(
				MortgageLoan.MAXIMAL_INITIALIZE_PAYMENT_PERCENTAGE - MortgageLoan.MINIMAL_INITIALIZE_PAYMENT_PERCENTAGE)
				+ MortgageLoan.MINIMAL_INITIALIZE_PAYMENT_PERCENTAGE;
	}

	public void setInitialPayment() {
		this.initialPayment = this.getLoanAmount() / this.initialPaymentPercentage;
	}

	public double getInitialPayment() {
		return this.initialPayment;
	}

	public double getInitialPaymentPercentage() {
		return this.initialPaymentPercentage;
	}

	@Override
	public int compareTo(MortgageLoan arg) {
		return Double.compare(this.getPercentageRate(), arg.getPercentageRate());
	}

	public static int searchByPercentageRate(MortgageLoan[] mortgageLoans, MortgageLoan mortgageLoan) {
		return Arrays.binarySearch(mortgageLoans, mortgageLoan);
	}
}
