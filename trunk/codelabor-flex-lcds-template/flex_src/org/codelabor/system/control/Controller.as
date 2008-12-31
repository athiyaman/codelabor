package org.codelabor.example.control
{
	import mx.controls.Alert;
	import com.adobe.cairngorm.control.FrontController;
	import org.codelabor.system.events.LoadLoginUserInfoEvent;
	import org.codelabor.system.commands.LoadLoginUserInfoCommand;

	public class Controller extends FrontController
	{
		public function Controller()
		{
			super();
			addCommand(LoadLoginUserInfoEvent.EVENT_ID, LoadLoginUserInfoCommand);
		}
	}
}