package org.codelabor.example.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	import org.codelabor.example.model.ModelLocator;
	import org.codelabor.example.business.MessageSourceDelegate;

	public class MessageSourceCommand implements ICommand, IResponder
	{
		
		private var model:ModelLocator = ModelLocator.getInstance();
		
		public function MessageSourceCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var selectEmpListByDeptNoEvent:SelectEmpListByDeptNoEvent = event as SelectEmpListByDeptNoEvent;
			var messageSourceDelegate:MessageSourceDelegate = new MessageSourceDelegate(this);
			event.
			messageSourceDelegate.getMessage(code, args, locale);
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