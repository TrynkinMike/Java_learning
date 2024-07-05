package ru.rsreu.tryinkin0518;

public abstract class TargetLoan extends MyObject {
	private double loanAmount = 0;
	private double percentageRate = 0;
	private double returnPeriod = 0;
	private double monthlyPayment = 0;
	private String companyName = "";
	private String[] documentsNeeded;
	private boolean possibilityOfEarlyRepayment = true;
	private boolean possibilityOfIncreasingTheCreditLine = true;

	public abstract StringBuilder printTotalInfo(int count);

	public abstract void calculateMonthlyPayment();

	public void setLoanAmount(int argument) {
		this.loanAmount = argument;
	}

	public void setPercentageRate(double argument) {
		this.percentageRate = argument;
	}

	public void setReturnPeriod(double argument) {
		this.returnPeriod = argument;
	}

	public void setCompanyName(String argument) {
		this.companyName = argument;
	}

	public void setDocumentsNeeded(String[] documents) {
		this.documentsNeeded = new String[documents.length];
		for (int i = 0; i < documents.length; i++) {
			this.documentsNeeded[i] = documents[i];
		}
	}

	public void setPossibilityOfEarlyRepayment(boolean argument) {
		this.possibilityOfEarlyRepayment = argument;
	}

	public void setPossibilityOfIncreasingTheCreditLine(boolean argument) {
		this.possibilityOfIncreasingTheCreditLine = argument;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	};

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public double getLoanAmount() {
		return this.loanAmount;
	}

	public double getPercentageRate() {
		return this.percentageRate;
	}

	public double getReturnPeriod() {
		return this.returnPeriod;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public String[] getDocumentsNeeded() {
		return this.documentsNeeded;
	}

	public boolean getPossibilityOfEarlyRepayment() {
		return this.possibilityOfEarlyRepayment;
	}

	public boolean getPossibilityOfIncreasingTheCreditLine() {
		return this.possibilityOfIncreasingTheCreditLine;
	}
}
