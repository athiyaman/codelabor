package org.codelabor.system.control
{
	import mx.controls.Alert;
	import com.adobe.cairngorm.control.FrontController;
	import org.codelabor.system.events.LoadLoginUserInfoEvent;
	import org.codelabor.system.commands.LoadLoginUserInfoCommand;
	import org.codelabor.system.events.GetMessageEvent;
	import org.codelabor.system.commands.GetMessageCommand;
	import org.codelabor.example.events.SelectEmpListEvent;
	import org.codelabor.example.events.SelectEmpListByDeptNoEvent;
	import org.codelabor.example.commands.SelectEmpListCommand;
	import org.codelabor.example.commands.SelectEmpListByDeptNoCommand;	

	public class Controller extends FrontController
	{
		public function Controller()
		{
			super();
			// system
			addCommand(LoadLoginUserInfoEvent.EVENT_ID, LoadLoginUserInfoCommand);
			addCommand(GetMessageEvent.EVENT_ID, GetMessageCommand);
			
			// example
			addCommand(SelectEmpListEvent.EVENT_ID, SelectEmpListCommand);
			addCommand(SelectEmpListByDeptNoEvent.EVENT_ID, SelectEmpListByDeptNoCommand);			
		}
	}
}