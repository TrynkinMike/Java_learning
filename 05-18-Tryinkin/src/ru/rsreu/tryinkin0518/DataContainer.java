package ru.rsreu.tryinkin0518;

public final class DataContainer {
	public static final String[] BASES_NAMES = { "Base-1", "Base-2", "Base-3" };
	public static final String[] COMPANIES_NAMES = { "��������", "���� ���", "�����������", "�����-����",
			"��������������" };
	public static final String[] DOCUMENTS = { "����������� �������", "������� � ���������� �����", "�������� ������",
			"������� �����", "�����", "������� �� ��������" };
	public static final String[][] LOAN_NAMES = {
			{ "��������� ������������ ������ ������", "������ �� ������� ������������ ����� ���",
					"��������� ���������� ������������ ������ �����", "���� �� ������� ����� ��������� ����",
					"��������� ������� ���������� �����" },
			{ "����-��������������", "����������-��������", "�������������������", "����-�����������",
					"������-����������" },
			{ "������� ��������", "����������� � �������", "�������-������", "�������� ��� ������",
					"���� � ������ � �������" } };
	public static final int[][] LOAN_AMOUNT_BORDERS = { { 500000, 30000000 + 1 }, { 20000, 10000000 + 1 },
			{ 10000, 5000000 + 1 } };
	public static final int[][] PERCENTAGE_RATE_BORDERS = { { 2, 8 + 1 }, { 1, 20 + 1 }, { 3, 16 + 1 } };
	public static final int[][] RETURN_PERIOD_BORDERS = { { 2, 40 + 1 }, { 1, 8 + 1 }, { 3, 8 + 1 } };

	private DataContainer() {

	}
}
