package com.chocolate.engSoft.test.unit.server;

import com.chocolate.engSoft.server.HTTPError;

import junit.framework.TestCase;

public class HTTPErrorTest extends TestCase {

	Exception exception;

	protected void setUp() throws Exception {
		super.setUp();
	}

	public final void testHTTPErrorException() {
		Exception exception = new Exception("any message");
		this.exception = new HTTPError(exception);
		assertEquals(exception, this.exception.getCause());
	}

	public final void testHTTPErrorString() {
		String message = "Any Message";
		this.exception = new HTTPError(message);
		assertEquals(message, this.exception.getMessage());
	}

}
