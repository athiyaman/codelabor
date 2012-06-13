
=============================
XML2BIN Task Getting started
=============================
The xml2bin task compile XPLATFORM .xfdl files.
This task will work on Windows using the external xml2bin executable (provided by TOBESOFT).

To get up and running with the xml2bin ant task quickly, follow these steps:
1. Install XPLATFORM xml2bin executable
2. Install dependency library to ANT_HOME/lib
3. Configure ant build.xml
4. Configure ant properties file
5. Run ant and enjoy

Note: XPLATFORM's xml2bin executable works Windows Platform only.

For detailed information, continue reading.




[XPLATFORM xml2bin executable]
To avoid license problem, XPLATFORM xml2bin executable is not included.
Contact XPLATFORM engineer and get files like this:

------------------------------------------------------------------------
xml2bin files:
	vcredist_x86.exe
	XBasicLib91.dll
	XMemPoolLib91.dll
	Xml2Bin.exe
	...
------------------------------------------------------------------------
Two type of xml2bin application available, GUI and CLI version.
xml2bin task use CLI version only.


[Library Dependencies]
The following libraries are needed in Ant's classpath.
You need to install libraries to ANT_HOME/lib directory that has been used to load Ant's jars from.
------------------------------------------------------------------------
	Libraries:
			commons-io-2.3.jar

	ANT_HOME/lib example:
		stand alone ant
			C:\Program Files\Apache Software Foundation\apache-ant-1.8.4\lib

		eclipse
			C:\eclipse\plugins\org.apache.ant_1.8.2.v20120109-1030\lib
------------------------------------------------------------------------
Note: If you put libraries on eclipse ant plugins lib directory, eclipse restart required.


[Ant build.xml]
Configure your Ant build file like this:
------------------------------------------------------------------------
	<taskdef name="xml2bin"
		classname="org.codelabor.system.xplatform.ant.Xml2bin" />

	<property file="xml2bin.properties" />

	<target name="xml2bin">
		<xml2bin executable="${xml2bin.execuable}"
			iniFile="${ini.file}" logFile="${log.file}"
			destDir="${target.dir}" verbose="${verbose.flag}">
			<fileset dir="${source.dir}">
				<include name="**/*.xfdl" />
				<exclude name="**/XPLATFORM_Client_License.xml" />
			</fileset>
		</xml2bin>
	</target>
------------------------------------------------------------------------


[Ant Properties]
You can change properties in xml2bin.properties file.
Source directory is where raw XPLATFORM .xfdl files contained.
Target directory is where compiled XPLATFORM .xfdl files will be created.
In case source and target directory is identical, it also works.
------------------------------------------------------------------------
	xml2bin.execuable = D:/xplatform/xml2bin.exe
	source.dir = D:/temp/source
	target.dir = D:/temp/target
	ini.file = D:/temp/xml2bin.ini
	log.file = D:/temp/xml2bin.log
	verbose.flag = true
------------------------------------------------------------------------


[Running]
If you are ready, run xml2bin task then you can see log like this:
------------------------------------------------------------------------
	Buildfile: C:\Users\bomber\workspace\codelabor-system-xplatform-ant\build.xml
	xml2bin:
	  [xml2bin] baseDir: D:\temp\source
	  [xml2bin] destDir: D:\temp\target
	  [xml2bin] 	file count:3247
	  [xml2bin] 	included file name: xxx\xxx1\XXXX0001.xfdl
	  [xml2bin] 	make dir: D:\temp\target\xxx\xxx1
	  [xml2bin] 	included file name: xxx\xxx2\XXXX0002.xfdl
	  [xml2bin] 	make dir: D:\temp\target\xxx\xxx2
	  ...
	  [xml2bin] 	included file name: xxx\xxx3247\XXXX3247.xfdl
	  [xml2bin] 	make dir: D:\temp\target\xxx\xxx3247
	  [xml2bin] INPUT filename [D:\temp\xml2bin.ini]
	  [xml2bin] LOG   filename [D:/temp/xml2bin.log]
	  [xml2bin] [001] 1,D:\temp\source\xxx\xxx1\XXXX0001.xfdl,D:\temp\target\xxx\xxx1\XXXX0001.xfdl
	  [xml2bin] [001] D:\temp\target\xxx\xxx1\XXXX0001.xfdl converted [Success]
	  [xml2bin] [002] 1,D:\temp\source\xxx\xxx2\XXXX0002.xfdl,D:\temp\target\xxx\xxx2\XXXX0002.xfdl
	  [xml2bin] [002] D:\temp\target\xxx\xxx2\XXXX0002.xfdl converted [Success]
	  ...
	  [xml2bin] [3247] 1,D:\temp\source\xxx\xxx3247\XXXX3247.xfdl,D:\temp\target\xxx\xxx3247\XXXX3247.xfdl
	  [xml2bin] [3247] D:\temp\target\xxx\xxx3247\XXXX3247.xfdl converted [Success]
	BUILD SUCCESSFUL
	Total time: 2 minutes 18 seconds
------------------------------------------------------------------------



