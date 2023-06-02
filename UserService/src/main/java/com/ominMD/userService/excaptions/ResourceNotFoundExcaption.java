package com.ominMD.userService.excaptions;

public class ResourceNotFoundExcaption extends RuntimeException {

	public ResourceNotFoundExcaption() {
		super("user not found !!");
	}

	public ResourceNotFoundExcaption(String msg) {
		super(msg);
	}

}
