# Spring Framework Encoding #

## CharacterEncodingFilter ##

Spring Framework의 Encoding은 기본적으로 ISO-8859-1로 되어 있으므로
아래와 같이 CharacterEncodingFilter를 사용하여 UTF-8로 인코딩이 가능하도록 설정한다.

간혹, filter는 설정하였으나 filter-mapping을 누락하여 필터가 동작하지 않는 경우가 있으니
filter-name이 일치하는지 반드시 확인하도록 한다.

web.xml에서 아래와 같이 filter 설정을 추가한다.

### web.xml ###

```
<!-- encoding filter -->
<filter>
	<filter-name>encodingFilter</filter-name>  
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
</filter>
...
<filter-mapping>
	<filter-name>encodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```