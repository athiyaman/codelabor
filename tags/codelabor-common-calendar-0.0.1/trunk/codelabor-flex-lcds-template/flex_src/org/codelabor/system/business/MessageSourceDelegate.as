package org.codelabor.system.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.collections.ArrayCollection;
	import mx.resources.Locale;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class MessageSourceDelegate
	{
		private var responder:IResponder;
		private var remoteObject:RemoteObject;
		private var serviceLocator:ServiceLocator = ServiceLocator.getInstance();
		
		public function MessageSourceDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.remoteObject = serviceLocator.getRemoteObject("messageResourceRO");
		}
		
		public function getMessage(code:String, args:ArrayCollection, locale:Locale):void 
		{
			var token:AsyncToken = remoteObject.getMessage(code, args, locale);
			token.addResponder(this.responder);
		}		
	}
}