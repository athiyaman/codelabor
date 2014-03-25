package org.codelabor.example.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	import org.codelabor.example.business.EmpManagerDelegate;
	import org.codelabor.system.model.ModelLocator;

	public class SelectEmpListCommand implements ICommand, IResponder
	{
		
		private var model:ModelLocator = ModelLocator.getInstance();
		
		public function SelectEmpListCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var selectEmpListDelegate:EmpManagerDelegate = new EmpManagerDelegate(this);
			selectEmpListDelegate.selectEmpList();
		}
		
		public function result(data:Object):void
		{
			model.empList = data.result as ArrayCollection;
			Alert.show("전체 검색 건수: "+ model.empList.length);
		}
		
		public function fault(info:Object):void
		{
			Alert.show(info.toString());
		}
	}
}