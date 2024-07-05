package ru.rsreu.tryinkin0518.typesOfLoans;

import java.util.Arrays;

import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.tryinkin0518.TargetLoan;

public final class StudentLoan extends TargetLoan implements Comparable<StudentLoan> {
	private static final int MONTHS_IN_YEAR_COUNT = 12;
	private static final int PERCENT_IN_FULL_PRODUCT_COUNT = 100;
	private int ramainingPercentagePeriods = (int) (this.getReturnPeriod() * MONTHS_IN_YEAR_COUNT) + 1;

	public StudentLoan(String name, double percentageRate, double returnPeriod, String[] documents, String companyName,
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

		double loanPaymentPart = sum / (MONTHS_IN_YEAR_COUNT * this.getReturnPeriod());
		double percentagePaymentPart = (sum - loanPaymentPart * (this.ramainingPercentagePeriods - 1))
				* (this.getPercentageRate() / PERCENT_IN_FULL_PRODUCT_COUNT + 1);

		double monthlyPayment = loanPaymentPart + percentagePaymentPart;

		this.setMonthlyPayment(monthlyPayment);
	}

	public StringBuilder printTotalInfo(int count) {
		StringBuilder output = new StringBuilder(
				Resourcer.getString("message.info.loan.studentLoanInfo") + count + ":");
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
	public int compareTo(StudentLoan arg) {
		return Double.compare(this.getPercentageRate(), arg.getPercentageRate());
	}

	public static int searchByPercentageRate(StudentLoan[] studentLoans, StudentLoan studentLoan) {
		return Arrays.binarySearch(studentLoans, studentLoan);
	}
}
