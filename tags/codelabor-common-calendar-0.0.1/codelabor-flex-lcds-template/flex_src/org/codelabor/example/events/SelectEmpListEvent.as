package org.codelabor.example.events
{
	import com.adobe.cairngorm.control.CairngormEvent;

	public class SelectEmpListEvent extends CairngormEvent
	{
		public static const EVENT_ID:String = "org.codelabor.example.events.SelectEmpListEvent";
		public function SelectEmpListEvent()
		{
			super(EVENT_ID);
		}
	}
}