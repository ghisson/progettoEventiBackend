package com.example.progettoEventi.model;

public class UtenteLogin {
	private String email;
	private String password;
	
	public UtenteLogin() {}
	public UtenteLogin(String email, String password) {
		this.email=email;
		this.password=password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UtenteLogin [email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
