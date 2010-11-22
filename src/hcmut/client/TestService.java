package hcmut.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TestService")
public interface TestService extends RemoteService {
	String getData();
}
