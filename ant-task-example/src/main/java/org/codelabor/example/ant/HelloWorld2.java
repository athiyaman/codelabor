package org.codelabor.example.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

public class HelloWorld2 extends Task {

	protected String name = null;

	@Override
	public void execute() throws BuildException {
		super.execute();
		if (name != null && name.length() > 0) {
			log("Hello, " + name + "!", Project.MSG_INFO);
		} else {
			throw new BuildException("Name attribute requried.");
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
