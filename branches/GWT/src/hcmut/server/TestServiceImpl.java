package hcmut.server;

import hcmut.client.TestService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TestServiceImpl extends RemoteServiceServlet implements
		TestService {

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "OK";
	}

}
