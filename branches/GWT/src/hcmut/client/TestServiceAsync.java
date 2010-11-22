package hcmut.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TestServiceAsync {
	void getData(AsyncCallback<String> callback);
}
