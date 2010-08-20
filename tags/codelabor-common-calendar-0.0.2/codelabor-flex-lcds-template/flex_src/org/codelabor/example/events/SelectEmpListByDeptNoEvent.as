package org.codelabor.example.events
{
	import com.adobe.cairngorm.control.CairngormEvent;

	public class SelectEmpListByDeptNoEvent extends CairngormEvent
	{
		public static const EVENT_ID:String = "org.codelabor.example.events.SelectEmpListByDeptNoEvent";
		private var _deptNo:int;
		public function SelectEmpListByDeptNoEvent(deptNo:int)
		{
			super(EVENT_ID);
			this._deptNo = deptNo;
		}
		
		public function getDeptNo():int
		{
			return this._deptNo;
		}
		
		public function setDeptNo(deptNo:int):void
		{
			this._deptNo = deptNo;
		}		
	}
}