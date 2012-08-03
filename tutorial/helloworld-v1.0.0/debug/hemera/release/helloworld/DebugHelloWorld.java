package hemera.release.helloworld;

import hemera.core.structure.runtime.util.ModuleNode;
import hemera.core.structure.runtime.util.RuntimeDebugger;

public class DebugHelloWorld {

	public static void main(final String[] args) throws Exception {
		// This is where we installed our Hemera environment.
		final RuntimeDebugger debugger = new RuntimeDebugger("/Workspace/Hemera/Local/");
		// Add a module to debug.
		final String classname = HelloWorldResource.class.getName();
		final String configLocation = "/Workspace/Sourcecode/Project-Hemera/Hemera-Release-HelloWorld/config/hello-world.xml";
		final String resourcesDir = "/Workspace/Sourcecode/Project-Hemera/Hemera-Release-HelloWorld/resources";
		debugger.addModule(new ModuleNode(classname, configLocation, resourcesDir, null));
		// Start the debugger.
		debugger.start();
	}
}
