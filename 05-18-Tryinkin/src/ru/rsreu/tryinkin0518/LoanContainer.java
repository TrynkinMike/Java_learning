package ru.rsreu.tryinkin0518;

import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.tryinkin0518.typesOfLoans.CarLoan;
import ru.rsreu.tryinkin0518.typesOfLoans.MortgageLoan;
import ru.rsreu.tryinkin0518.typesOfLoans.StudentLoan;

public final class LoanContainer extends MyObject {

	private MortgageLoan[] mortgageLoans;
	private CarLoan[] carLoans;
	private StudentLoan[] studentLoans;

	public LoanContainer() {

	}

	public StringBuilder printInfoAboutNeededLoan(int loanType, int loanIndex) {
		if (loanType == 1) {
			return mortgageLoans[loanIndex].printTotalInfo(loanIndex + 1);
		} else if (loanType == 2) {
			return carLoans[loanIndex].printTotalInfo(loanIndex + 1);
		} else {
			return studentLoans[loanIndex].printTotalInfo(loanIndex + 1);
		}
	}

	public StringBuilder printTotalInfo(int argument) {
		StringBuilder output = new StringBuilder(Resourcer.getString("message.info.base") + this.getName() + ":");

		for (int i = 0; i < mortgageLoans.length; i++) {
			output.append(mortgageLoans[i].printTotalInfo(i + 1));
		}

		for (int i = 0; i < carLoans.length; i++) {
			output.append(carLoans[i].printTotalInfo(i + 1));
		}

		for (int i = 0; i < studentLoans.length; i++) {
			output.append(studentLoans[i].printTotalInfo(i + 1));
		}

		return output;
	}

	public MortgageLoan[] getMortgageLoans() {
		return mortgageLoans;
	}

	public void setMortgageLoans(MortgageLoan[] mortgageLoans) {
		this.mortgageLoans = mortgageLoans;
	}

	public CarLoan[] getCarLoans() {
		return carLoans;
	}

	public void setCarLoans(CarLoan[] carLoans) {
		this.carLoans = carLoans;
	}

	public StudentLoan[] getStudentLoans() {
		return studentLoans;
	}

	public void setStudentLoans(StudentLoan[] studentLoans) {
		this.studentLoans = studentLoans;
	}
}
