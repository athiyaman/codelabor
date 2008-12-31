package org.codelabor.example.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	import org.codelabor.example.business.EmpManagerDelegate;
	import org.codelabor.example.events.SelectEmpListByDeptNoEvent;
	import org.codelabor.system.model.ModelLocator;

	public class SelectEmpListByDeptNoCommand implements ICommand, IResponder
	{
		
		private var model:ModelLocator = ModelLocator.getInstance();
		
		public function SelectEmpListByDeptNoCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var selectEmpListByDeptNoEvent:SelectEmpListByDeptNoEvent = event as SelectEmpListByDeptNoEvent;
			var selectEmpListDelegate:EmpManagerDelegate = new EmpManagerDelegate(this);
			selectEmpListDelegate.selectEmpListByDeptNo(selectEmpListByDeptNoEvent.getDeptNo());
		}
		
		public function result(data:Object):void
		{
			model.empList = data.result as ArrayCollection;
			Alert.show("조건 검색 건수: "+model.empList.length);
		}
		
		public function fault(info:Object):void
		{
			Alert.show(info.toString());
		}
	}
}