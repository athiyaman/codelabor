package org.codelabor.example.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class EmpManagerDelegate
	{
		private var responder:IResponder;
		private var remoteObject:RemoteObject;
		private var serviceLocator:ServiceLocator = ServiceLocator.getInstance();
		
		public function EmpManagerDelegate(responder:IResponder)
		{
			this.responder = responder;
			//this.remoteObject = serviceLocator.getRemoteObject("empManagerMockRO");
			this.remoteObject = serviceLocator.getRemoteObject("empManagerRO");
		}
		
		public function selectEmpList():void 
		{
			var token:AsyncToken = remoteObject.selectEmpList();
			token.addResponder(this.responder);
		}		
		
		public function selectEmpListByDeptNo(deptNo:int):void 
		{
			var token:AsyncToken = remoteObject.selectEmpListByDeptNo(deptNo);
			token.addResponder(this.responder);
		}
	}
}