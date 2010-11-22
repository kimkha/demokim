package hcmut.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class DuplicateTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		final HTMLPanel w = new HTMLPanel("<div id='testHTML'></div>");
		final HTML h = new HTML();
		TestServiceAsync t = GWT.create(TestService.class);
		t.getData(new AsyncCallback<String>(){
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error when calling RPC");
			}
			@Override
			public void onSuccess(String result) {
				h.setHTML(result);
			}
		});
		w.add(new HTML("Result:<br><br>"), "testHTML");
		w.add(h, "testHTML");

		RootPanel.get().add(w);
	}

}
