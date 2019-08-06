package com.onecode.rule_engine.Exceptions;


@SuppressWarnings("serial")
public class NegativeValueException extends Exception{
	   
	String str1;
	   public NegativeValueException(String str2) {
		str1=str2;
	   }
	   public String toString(){ 
		return ("Error: "+str1) ;
	   }
	}