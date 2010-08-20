package org.codelabor.system.model
{
	import com.adobe.cairngorm.CairngormError;
	import com.adobe.cairngorm.CairngormMessageCodes;
	import com.adobe.cairngorm.model.IModelLocator;
	
	import mx.collections.ArrayCollection;
	
    [Bindable]
	public final class ModelLocator implements IModelLocator
	{
		// model 
		public var empList:ArrayCollection = new ArrayCollection();
		public var loginUserId:String = new String("tester");
		public var message:String = new String();
		
		private static var instance:ModelLocator;

		public function ModelLocator()
		{
			if (instance != null)
			{
			    throw new CairngormError(CairngormMessageCodes.SINGLETON_EXCEPTION, "ModelLocator");
			}
			instance = this;
		}
		 
		public static function getInstance() : ModelLocator
		{
			if (instance == null)
			{
				instance = new ModelLocator();
			}
			return instance;
		}
	}
}

