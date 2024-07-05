package ru.rsreu.tryinkin0701;

import com.prutzkow.resourcer.Resourcer;

public final class MethodologicalGuidelines implements Comparable<MethodologicalGuidelines> {

	private String number = "";
	private String author = "";
	private String discipline = "";

	MethodologicalGuidelines(String number, String author, String discipline) {
		this.number = number;
		this.author = author;
		this.discipline = discipline;
	}

	public MethodologicalGuidelines() {
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		String temp;
		temp = String.format("%-20s", Resourcer.getString("message.part.number"));
		output.append(temp);
		temp = String.format("%-20s", this.number);
		output.append(temp);
		output.append("\n");

		temp = String.format("%-20s", Resourcer.getString("message.part.author"));
		output.append(temp);
		temp = String.format("%-20s", this.author);
		output.append(temp);
		output.append("\n");

		temp = String.format("%-20s", Resourcer.getString("message.part.discipline"));
		output.append(temp);
		temp = String.format("%-20s", this.discipline);
		output.append(temp);
		output.append("\n");

		return output.toString();
	}

	public int compareTo(MethodologicalGuidelines o) {
		return this.number.compareTo(o.number);
	}

	public int compareTo(MethodologicalGuidelines guide1, MethodologicalGuidelines guide2) {
		int descriptionCompare = guide1.getAuthor().compareTo(guide2.getAuthor());
		if (descriptionCompare != 0) {
			return descriptionCompare;
		}
		return guide1.getDiscipline().compareTo(guide2.getDiscipline());
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
}
