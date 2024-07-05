package ru.rsreu.tryinkin0518;

import java.util.Random;

import ru.rsreu.tryinkin0518.typesOfLoans.CarLoan;
import ru.rsreu.tryinkin0518.typesOfLoans.MortgageLoan;
import ru.rsreu.tryinkin0518.typesOfLoans.StudentLoan;

public class LoanInitializer {
	private static final int MORTGAGE_LOAN_TYPE = 0;
	private static final int CARLOAN_TYPE = 1;
	private static final int STUDENT_LOAN_TYPE = 2;

	private static final int PASSPORT = 0;
	private static final int SNILS = 4;
	private static final int STUDYING_SERTIFICATE = 5;

	private LoanInitializer() {

	}

	public static LoanContainer initializeLoanContainer(int loansCount) {
		LoanContainer tempLoanContainer = new LoanContainer();
		Random random = new Random();

		tempLoanContainer.setName(DataContainer.BASES_NAMES[random.nextInt(DataContainer.BASES_NAMES.length)]);

		tempLoanContainer.setMortgageLoans(LoanInitializer.initializeMortgageLoans(loansCount));
		tempLoanContainer.setCarLoans(LoanInitializer.initializeCarLoans(loansCount));
		tempLoanContainer.setStudentLoans(LoanInitializer.initializeStudentLoans(loansCount));

		return tempLoanContainer;
	}

	public static MortgageLoan[] initializeMortgageLoans(int loansCount) {
		MortgageLoan[] mortgageLoans = new MortgageLoan[loansCount];
		for (int i = 0; i < mortgageLoans.length; i++) {
			mortgageLoans[i] = LoanInitializer.initializeMortgageLoan();
		}
		return mortgageLoans;
	}

	public static MortgageLoan initializeMortgageLoan() {
		MortgageLoan result = new MortgageLoan(LoanInitializer.initializeName(LoanInitializer.MORTGAGE_LOAN_TYPE),
				LoanInitializer.initializePercentageRate(LoanInitializer.MORTGAGE_LOAN_TYPE),
				LoanInitializer.initializeReturnPeriod(LoanInitializer.MORTGAGE_LOAN_TYPE),
				LoanInitializer.generateDocumentsNeeded(LoanInitializer.MORTGAGE_LOAN_TYPE),
				LoanInitializer.initializeCompanyName(), LoanInitializer.initializePossibilityOfEarlyRepayment(),
				LoanInitializer.initializePossibilityOfIncreasingTheCreditLine());
		return result;
	}

	public static CarLoan[] initializeCarLoans(int loansCount) {
		CarLoan[] carLoans = new CarLoan[loansCount];
		for (int i = 0; i < carLoans.length; i++) {
			carLoans[i] = LoanInitializer.initializeCarLoan();
		}
		return carLoans;
	}

	public static CarLoan initializeCarLoan() {
		CarLoan result = new CarLoan(LoanInitializer.initializeName(LoanInitializer.CARLOAN_TYPE),
				LoanInitializer.initializePercentageRate(LoanInitializer.CARLOAN_TYPE),
				LoanInitializer.initializeReturnPeriod(LoanInitializer.CARLOAN_TYPE),
				LoanInitializer.generateDocumentsNeeded(LoanInitializer.CARLOAN_TYPE),
				LoanInitializer.initializeCompanyName(), LoanInitializer.initializePossibilityOfEarlyRepayment(),
				LoanInitializer.initializePossibilityOfIncreasingTheCreditLine());
		return result;
	}

	public static StudentLoan[] initializeStudentLoans(int loansCount) {
		StudentLoan[] studentLoans = new StudentLoan[loansCount];
		for (int i = 0; i < studentLoans.length; i++) {
			studentLoans[i] = LoanInitializer.initializeStudentLoan();
		}
		return studentLoans;
	}

	public static StudentLoan initializeStudentLoan() {
		StudentLoan result = new StudentLoan(LoanInitializer.initializeName(LoanInitializer.STUDENT_LOAN_TYPE),
				LoanInitializer.initializePercentageRate(LoanInitializer.STUDENT_LOAN_TYPE),
				LoanInitializer.initializeReturnPeriod(LoanInitializer.STUDENT_LOAN_TYPE),
				LoanInitializer.generateDocumentsNeeded(LoanInitializer.STUDENT_LOAN_TYPE),
				LoanInitializer.initializeCompanyName(), LoanInitializer.initializePossibilityOfEarlyRepayment(),
				LoanInitializer.initializePossibilityOfIncreasingTheCreditLine());
		return result;
	}

	public static String initializeName(int loanType) {
		Random random = new Random();
		return DataContainer.LOAN_NAMES[loanType][random.nextInt(DataContainer.LOAN_NAMES[loanType].length)];
	}

	public static String initializeCompanyName() {
		Random random = new Random();
		return DataContainer.COMPANIES_NAMES[random.nextInt(DataContainer.COMPANIES_NAMES.length)];
	}

	public static double initializePercentageRate(int loanType) {
		Random random = new Random();
		return random.nextInt(
				DataContainer.PERCENTAGE_RATE_BORDERS[loanType][1] - DataContainer.PERCENTAGE_RATE_BORDERS[loanType][0])
				+ DataContainer.PERCENTAGE_RATE_BORDERS[loanType][0];
	}

	public static double initializeReturnPeriod(int loanType) {
		Random random = new Random();
		return random.nextInt(
				DataContainer.RETURN_PERIOD_BORDERS[loanType][1] - DataContainer.RETURN_PERIOD_BORDERS[loanType][0])
				+ DataContainer.RETURN_PERIOD_BORDERS[loanType][0];
	}

	public static String[] generateDocumentsNeeded(int loanType) {
		if (loanType == 0) {
			String[] documents = { DataContainer.DOCUMENTS[PASSPORT], DataContainer.DOCUMENTS[SNILS] };
			return documents;
		} else if (loanType == 1) {
			String[] documents = { DataContainer.DOCUMENTS[PASSPORT], DataContainer.DOCUMENTS[SNILS] };
			return documents;
		} else {
			String[] documents = { DataContainer.DOCUMENTS[PASSPORT], DataContainer.DOCUMENTS[STUDYING_SERTIFICATE] };
			return documents;
		}
	}

	private static boolean initializePossibilityOfEarlyRepayment() {
		Random random = new Random();
		return random.nextBoolean();
	};

	private static boolean initializePossibilityOfIncreasingTheCreditLine() {
		Random random = new Random();
		return random.nextBoolean();
	};
}
