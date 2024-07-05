package ru.rsreu.tryinkin0518.typesOfLoans;

import java.util.Arrays;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.tryinkin0518.TargetLoan;

public final class CarLoan extends TargetLoan implements Comparable<CarLoan> {
	private static final int MONTHS_IN_YEAR_COUNT = 12;

	public CarLoan(String name, double percentageRate, double returnPeriod, String[] documents, String companyName,
			boolean possibilityOfEarlyRepayment, boolean possibilityOfIncreasingTheCreditLine) {
		this.setName(name);
		this.setPercentageRate(percentageRate);
		this.setReturnPeriod(returnPeriod);
		this.setDocumentsNeeded(documents);
		this.setCompanyName(companyName);
		this.setPossibilityOfEarlyRepayment(possibilityOfEarlyRepayment);
		this.setPossibilityOfIncreasingTheCreditLine(possibilityOfIncreasingTheCreditLine);
	}

	@Override
	public void calculateMonthlyPayment() {
		double sum = this.getLoanAmount();
		double monthlyPayment = sum * (this.getPercentageRate() + (this.getPercentageRate()
				/ (Math.pow(1 + this.getPercentageRate(), this.getReturnPeriod() * MONTHS_IN_YEAR_COUNT) - 1)));
		this.setMonthlyPayment(monthlyPayment);
	}

	public StringBuilder printTotalInfo(int count) {
		StringBuilder output = new StringBuilder(Resourcer.getString("message.info.loan.carLoanInfo") + count + ":");
		String additionalInfo;

		output.append(Resourcer.getString("message.info.loan.name") + this.getName());
		output.append(Resourcer.getString("message.info.loan.percentageRate") + this.getPercentageRate() + "%");
		output.append(Resourcer.getString("message.info.loan.repaymentPeriod") + this.getReturnPeriod());

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
	public int compareTo(CarLoan arg) {
		return Double.compare(this.getPercentageRate(), arg.getPercentageRate());
	}

	public static int searchByPercentageRate(CarLoan[] carLoans, CarLoan carLoan) {
		return Arrays.binarySearch(carLoans, carLoan);
	}
}
