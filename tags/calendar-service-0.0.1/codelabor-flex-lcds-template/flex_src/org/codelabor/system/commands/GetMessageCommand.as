package org.codelabor.system.commands
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	import org.codelabor.system.events.GetMessageEvent;
	import org.codelabor.system.business.MessageSourceDelegate;
	import org.codelabor.system.model.ModelLocator;
	
	public class GetMessageCommand implements ICommand, IResponder
	{
		
		private var model:ModelLocator = ModelLocator.getInstance();
		
		public function GetMessageCommand()
		{
		}

		public function execute(event:CairngormEvent):void
		{
			var getMessageEvent:GetMessageEvent = event as GetMessageEvent;
			var messageSourceDelegate:MessageSourceDelegate = new MessageSourceDelegate(this);
			messageSourceDelegate.getMessage(getMessageEvent.getCode(), getMessageEvent.getArgs(), getMessageEvent.getLocale());
		}
		
		public function result(data:Object):void
		{
			model.message = data.result as String;
		}
		
		public function fault(info:Object):void
		{
		}
	}
}