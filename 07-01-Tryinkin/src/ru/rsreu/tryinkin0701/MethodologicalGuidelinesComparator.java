package ru.rsreu.tryinkin0701;

import java.util.Comparator;

public class MethodologicalGuidelinesComparator implements Comparator<MethodologicalGuidelines> {
	public int compare(MethodologicalGuidelines guide1, MethodologicalGuidelines guide2) {
		int authorCompare = guide1.getAuthor().compareTo(guide2.getAuthor());
		if (authorCompare != 0) {
            return authorCompare;
        }		
        return guide1.getDiscipline().compareTo(guide2.getDiscipline());
    }
}
