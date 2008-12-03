package org.codelabor.example.control
{
	import mx.controls.Alert;
	import com.adobe.cairngorm.control.FrontController;
	import org.codelabor.example.events.SelectEmpListEvent;
	import org.codelabor.example.events.SelectEmpListByDeptNoEvent;
	import org.codelabor.example.commands.SelectEmpListCommand;
	import org.codelabor.example.commands.SelectEmpListByDeptNoCommand;

 
	public class Controller extends FrontController
	{
		public function Controller()
		{
			super();
			addCommand(SelectEmpListEvent.EVENT_ID, SelectEmpListCommand);
			addCommand(SelectEmpListByDeptNoEvent.EVENT_ID, SelectEmpListByDeptNoCommand);
		}
	}
}