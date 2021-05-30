package com.insurance.util;


import org.apache.log4j.Logger;

public class DateUtils {

	private static final Logger LOG = Logger.getLogger(DateUtils.class);


	public enum DateFormat {

		ISO_DATETIME_FORMAT("yyyy-MM-dd'T'HH:mm:ss");

		private final String formatStr;

		DateFormat(String formatStr){
			this.formatStr = formatStr;
		}

		public String formatStr(){
			return this.formatStr;
		}
	};

}
