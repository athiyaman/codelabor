package org.codelabor.system.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class SessionDelegate
	{
		private var responder:IResponder;
		private var remoteObject:RemoteObject;
		private var serviceLocator:ServiceLocator = ServiceLocator.getInstance();
		
		public function SessionDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.remoteObject = serviceLocator.getRemoteObject("sessionRO");
		}
		
		public function getLoginUserInfo():void 
		{
			var token:AsyncToken = remoteObject.getLoginUserInfo();
			token.addResponder(this.responder);
		}
		
		public function getLoginUserId():void 
		{
			var token:AsyncToken = remoteObject.getLoginUserId();
			token.addResponder(this.responder);
		}				
	}
}