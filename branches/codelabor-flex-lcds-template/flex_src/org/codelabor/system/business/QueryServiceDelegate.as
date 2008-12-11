package org.codelabor.example.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class QueryServiceDelegate
	{
		private var responder:IResponder;
		private var remoteObject:RemoteObject;
		private var serviceLocator:ServiceLocator = ServiceLocator.getInstance();
		
		public function QueryServiceDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.remoteObject = serviceLocator.getRemoteObject("queryServiceRO");
		}
		
		public function find(queryId:String, param:ArrayCollection):void 
		{
			var param:ArrayCollection = new ArrayCollection();
			var token:AsyncToken = remoteObject.find(queryId, param);
			token.addResponder(this.responder);
		}		
	}
}