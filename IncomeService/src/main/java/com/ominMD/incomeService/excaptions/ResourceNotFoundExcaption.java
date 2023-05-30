package com.ominMD.incomeService.excaptions;

public class ResourceNotFoundExcaption extends RuntimeException {
	
	public ResourceNotFoundExcaption() {
		super("income is not found !!");
	}
	
	public ResourceNotFoundExcaption(String msg) {
		super(msg);
	}

}
