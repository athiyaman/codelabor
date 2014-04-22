[JVM Options]
-Dservlet.container.id=tomcat1: servlet container 를 식별하기 위한 정보
-Djava.net.preferIPv4Stack=true: 접속자 IP 정보를 IP v4 형식으로 표현

[3rd Party Artifact]

<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-taglib</artifactId>
	<version>0.1RC</version>
</dependency>

<dependency>
	<groupId>ojdbc</groupId>
	<artifactId>ojdbc</artifactId>
	<version>6</version>
	<scope>provided</scope>
</dependency>