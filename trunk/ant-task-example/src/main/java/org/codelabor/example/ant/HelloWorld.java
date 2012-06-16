package org.codelabor.example.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

public class HelloWorld extends Task {

	@Override
	public void execute() throws BuildException {
		super.execute();
		log("Hello, World!", Project.MSG_INFO);
	}

}
