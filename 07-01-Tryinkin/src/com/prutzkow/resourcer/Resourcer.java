package com.prutzkow.resourcer;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resourcer {
	private static final String DEFAULT_PROPERTY_NAME = "resources.text";
	private static String baseneme = null;
	private static ResourceBundle resources = null;

	private Resourcer() {
	}

	private static void createResourcer() {
		Resourcer.createResourcer(null);
	}

	private static void setBasename(String basename) {
		if (basename == null) {
			if(Resourcer.baseneme ==  null) {
				Resourcer.baseneme = Resourcer.DEFAULT_PROPERTY_NAME;
			}
		}else {
			Resourcer.baseneme = basename;
		}
	}
	
	private static void createResourcer(String basename) {
		if(Resourcer.resources == null) {
			Resourcer.setBasename(basename);
			Resourcer.resources = ResourceBundle.getBundle(Resourcer.baseneme, Locale.getDefault());
		}else {
			Locale systemLocale = Locale.getDefault();
			Locale resourcerLocale = Resourcer.resources.getLocale();
			if(!(resourcerLocale.equals(systemLocale))) {
				Resourcer.resources = ResourceBundle.getBundle(Resourcer.baseneme, systemLocale);
			}
		}
	}
	
	public static String getString(String parametr) {
		Resourcer.createResourcer();
		return Resourcer.resources.getString(parametr);
	}
}
