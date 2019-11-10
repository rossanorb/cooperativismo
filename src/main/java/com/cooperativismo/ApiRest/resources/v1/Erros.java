package com.cooperativismo.ApiRest.resources.v1;

public class Erros {
	
	public String message;
	
	public Erros(String message)
	{
		this.message = message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
	public String getMessage(String message)
	{
		return this.message;
	}

}
