package com.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j {

	public static Logger log = LogManager.getLogger(log4j.class);

	public static void main(String[] args) {
		

		System.out.println("\n***Welcome to Log4J ****\n");

		log.info("This is info log");
		log.warn("This is warn log");
		log.error("This is error log");
		log.fatal("this is fatal log");

		System.out.println("\n***Logging is completed***");
	}
}
