package org.codelabor.example.events
{
	import com.adobe.cairngorm.control.CairngormEvent;

	public class LoadLoginUserInfoEvent extends CairngormEvent
	{
		public static const EVENT_ID:String = "org.codelabor.example.events.LoadLoginUserInfoEvent";
		public function LoadLoginUserInfoEvent()
		{
			super(EVENT_ID);
		}
	}
}