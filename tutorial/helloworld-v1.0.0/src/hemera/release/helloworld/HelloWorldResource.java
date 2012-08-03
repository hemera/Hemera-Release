package hemera.release.helloworld;

import org.w3c.dom.Document;

import hemera.core.structure.AbstractResource;
import hemera.core.structure.enumn.EHttpMethod;
import hemera.core.structure.interfaces.IProcessor;
import hemera.release.helloworld.processor.HelloProcessor;

public class HelloWorldResource extends AbstractResource {
	
	private String knownName;

	@Override
	public void customize(final Document config) throws Exception {
		// Retrieve the known name from configuration file.
		this.knownName = config.getElementsByTagName("known-name").item(0).getTextContent();
	}

	@Override
	public void initialize() throws Exception {}

	@Override
	public void activate() throws Exception {}

	@Override
	public String getPath() {
		return "hello";
	}

	@Override
	public void dispose() throws Exception {}

	@Override
	public IProcessor<?, ?> getProcessor(final EHttpMethod method) {
		if (method == EHttpMethod.Get) {
			// We know we only have a single welcome.txt file.
			return new HelloProcessor(this.knownName, this.resources.get(0));
		}
		return null;
	}
}
