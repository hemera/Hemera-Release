package hemera.release.helloworld.message;

import org.json.JSONObject;

import hemera.core.structure.interfaces.IResponse;

public class HelloResponse implements IResponse {

	private final String response;

	public HelloResponse(final String response) {
		this.response = response;
	}

	@Override
	public JSONObject toJSON() throws Exception {
		final JSONObject json = new JSONObject();
		json.put("response", this.response);
		return json;
	}
}
