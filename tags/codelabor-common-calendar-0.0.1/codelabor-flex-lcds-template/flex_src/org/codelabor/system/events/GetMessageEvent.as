package org.codelabor.system.events
{
	import com.adobe.cairngorm.control.CairngormEvent;
	
	import mx.collections.ArrayCollection;
	import mx.resources.Locale;

	public class GetMessageEvent extends CairngormEvent
	{
		public static const EVENT_ID:String = "org.codelabor.system.events.GetMessageEvent";
		private var _code:String;
		private var _args:ArrayCollection;
		private var _locale:Locale;
		
		public function GetMessageEvent(code:String, args:ArrayCollection, locale:Locale)
		{
			super(EVENT_ID);
			this._code = code;
			this._args = args;
			this._locale = locale;
		}
		
		public function getCode():String
		{
			return this._code;
		}
		
		public function setCode(code:String):void
		{
			this._code = code;
		}
		
		public function getArgs():ArrayCollection
		{
			return this._args;
		}
		
		public function setArgs(args:ArrayCollection):void
		{
			this._args = args;
		}			
			
		public function getLocale():Locale
		{
			return this._locale;
		}
		
		public function setLocale(locale:Locale):void
		{
			this._locale = locale;
		}		
				
	}
}