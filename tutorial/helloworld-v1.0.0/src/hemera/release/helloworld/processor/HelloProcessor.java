package hemera.release.helloworld.processor;

import java.io.File;
import java.io.IOException;

import hemera.core.structure.AbstractProcessor;
import hemera.core.utility.FileUtils;
import hemera.release.helloworld.message.HelloRequest;
import hemera.release.helloworld.message.HelloResponse;

public class HelloProcessor extends AbstractProcessor<HelloRequest, HelloResponse> {
	/**
	 * The name we recognize.
	 */
	private final String knownName;
	/**
	 * The welcome message.
	 */
	private final String welcomeMessage;
	
	public HelloProcessor(final String knownName, final File welcomeFile) {
		this.knownName = knownName;
		// Read in the contents of the welcome file.
		try {
			this.welcomeMessage = FileUtils.instance.readAsString(welcomeFile);
		} catch (IOException e) {
			throw new IllegalArgumentException("We need our welcome.txt resource file.");
		}
	}

	@Override
	protected HelloResponse processRequest(final HelloRequest request) throws Exception {
		// If we know the name, we will say hi back.
		if (request.getName().equalsIgnoreCase(this.knownName)) {
			return new HelloResponse(this.welcomeMessage);
		}
		// Otherwise we shouldn't tell him who we are.
		else {
			return new HelloResponse("I don't know the name " + request.getName() + ". Sorry, bye!");
		}
	}

	@Override
	protected HelloResponse exceptionResponse(final HelloRequest request, final Exception e) {
		return new HelloResponse("Fudge! An exception occurred: " + e);
	}

	@Override
	public String getPath() {
		return "hi";
	}

	@Override
	public Class<HelloRequest> getRequestType() {
		return HelloRequest.class;
	}
}
