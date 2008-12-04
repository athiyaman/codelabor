package org.codelabor.example.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	import org.codelabor.example.model.ModelLocator;
	import org.codelabor.example.business.SessionDelegate;

	public class LoadLoginUserInfoCommand implements ICommand, IResponder
	{
		
		private var model:ModelLocator = ModelLocator.getInstance();
		
		public function LoadLoginUserInfoCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var sessionDelegate:SessionDelegate = new SessionDelegate(this);
			sessionDelegate.getLoginUserId();
		}
		
		public function result(data:Object):void
		{
			model.loginUserId = data.result as String;
		}
		
		public function fault(info:Object):void
		{
			Alert.show(info.toString());
		}
	}
}