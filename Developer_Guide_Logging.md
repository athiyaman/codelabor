# Logging #

Java 소스 코드 상에서는 slf4j API를 사용하는 것을 원칙으로 합니다.
slf4j의 구현 라이브러리는 logback을 사용하게 됩니다.

## Library 참조 ##

maven의 pom.xml 설정 파일에서 아래와 같이 참조합니다.
Spring Framework이 내부적으로 JCL Logging을 사용하는 코드가 남아 있어
jcl-over-slf4j 라이브러리를 필요로 합니다. (현재는 Spring Framework도 slf4j로 갈아탐)

```
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-api</artifactId>
	<version>1.7.5</version>
</dependency>
<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-classic</artifactId>
	<version>1.0.13</version>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>jcl-over-slf4j</artifactId>
	<version>1.7.5</version>
	<scope>runtime</scope>
</dependency>
```

## Import 구분 ##

아래와 같이 import 합니다.
```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
```

## Logger 생성 및 실행 ##

아래와 같이 생성합니다.
```
private static final Logger logger = LoggerFactory.getLogger(LifecycleServlet.class);
```

아래와 같은 형태로 출력이 가능하다.
```
logger.debug("로깅할 내용");
logger.debug("로깅할 내용: {}", 파라미터);
logger.debug("로깅할 내용: {}, {}", 파라미터1, 파라미터2);
```

**주의**
아래와 같은 용도로는 Logging을 금지합니다.

  * 단순한 method 호출
  * method 호출 소요 시간 표시
  * method에 전달된 parameter 내용
  * method가 return할 값

위 출력용도로는 개별적으로 Logging 하지 마십시오.
공통에서 일괄적으로 AOP로 적용 시켜 필요에 따라 on/off 할 예정입니다.

## Logback 설정 ##

  * [관련 문서](http://logback.qos.ch/manual/layouts.html)