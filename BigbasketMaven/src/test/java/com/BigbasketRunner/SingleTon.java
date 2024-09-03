package com.BigbasketRunner;

public class SingleTon {
	
	private static SingleTon s ;
	
	private SingleTon() {
		
	}
	
	public static SingleTon getInstance() {   // ==> getInstance() = Object
		
		if ( s == null) {
			
			s = new SingleTon();
		}
		
		return s;
	}
	
	public void getInstanceforLoginPOM(){
		
		System.out.println("Created Instance for the Login Page - ln");
	}
	
	public static void main(String[] args) {
	
		getInstance().getInstanceforLoginPOM();
	
	}

}
