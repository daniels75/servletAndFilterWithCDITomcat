package org.daniels.examples.cdi.bean;

public class SimpleServiceImpl implements SimpleService {
	
	@Override
	public String createMessage(final String message) {
		return ">>>> SimpleService: " + message;
	}

}
