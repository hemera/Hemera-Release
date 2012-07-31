package hemera.release.helloworld.message;

import java.util.Map;

import hemera.core.structure.interfaces.IRequest;

public class HelloRequest implements IRequest {
	
	private String name;

	@Override
	public void parse(final Map<String, Object> arguments) throws Exception {
		// Retrieve the argument with key "name".
		this.name = (String)arguments.get("name");
		// We don't talk to strangers.
		if (this.name == null) throw new IllegalArgumentException("I dont't talk to strangers.");
	}
	
	public String getName() {
		return this.name;
	}
}
