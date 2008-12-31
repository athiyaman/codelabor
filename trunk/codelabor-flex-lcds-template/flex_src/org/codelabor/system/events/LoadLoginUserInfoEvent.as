package org.codelabor.system.events
{
	import com.adobe.cairngorm.control.CairngormEvent;

	public class LoadLoginUserInfoEvent extends CairngormEvent
	{
		public static const EVENT_ID:String = "org.codelabor.system.events.LoadLoginUserInfoEvent";
		public function LoadLoginUserInfoEvent()
		{
			super(EVENT_ID);
		}
	}
}