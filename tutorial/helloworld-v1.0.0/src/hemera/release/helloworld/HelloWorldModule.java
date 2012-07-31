package hemera.release.helloworld;

import org.w3c.dom.Document;

import hemera.core.structure.AbstractModule;
import hemera.core.structure.interfaces.IProcessor;
import hemera.release.helloworld.processor.HelloProcessor;

public class HelloWorldModule extends AbstractModule {
	
	private String knownName;

	@Override
	public void customize(final Document config) throws Exception {
		// Retrieve the known name from configuration file.
		this.knownName = config.getElementsByTagName("known-name").item(0).getTextContent();
	}

	@Override
	protected void buildComponents() throws Exception {}

	@Override
	protected IProcessor<?, ?>[] buildProcessors() {
		return new IProcessor<?, ?>[] {
				// We know we only have a single welcome.txt file.
				new HelloProcessor(this.knownName, this.resources.get(0))
		};
	}

	@Override
	public void activate() throws Exception {}

	@Override
	protected void disposeComponents() throws Exception {}

	@Override
	public String getPath() {
		return "hello";
	}
}
