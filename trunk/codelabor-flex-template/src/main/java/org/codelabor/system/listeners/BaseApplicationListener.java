package org.codelabor.system.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class BaseApplicationListener extends BaseListener implements ApplicationListener {

	public BaseApplicationListener() {
		super();
	}

	public void onApplicationEvent(ApplicationEvent event) {
	}

}
