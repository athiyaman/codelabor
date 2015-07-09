# Java Directory Layout #

## Java 디렉토리 구조 ##

  * [Java Directory Layout 엑셀 파일](https://codelabor.googlecode.com/svn/trunk/documentation/0%20architecture/develop/standards/directory-layout/java-directory-layout.xlsx)

|Level 1|Level 2|Level 3|Level 4|Level 5|Description|Accepted|
|:------|:------|:------|:------|:------|:----------|:-------|
|org    |codelabor|system |web    |action |Struts Action|X       |
|org    |codelabor|system |web    |form   |Struts FormBean|X       |
|org    |codelabor|system |web    |controller|SpringMVC Controller|O       |
|org    |codelabor|system |web    |filter |Servlet Filter|O       |
|org    |codelabor|system |web    |servlet|Servlet    |O       |
|org    |codelabor|system |web    |taglib |Taglib     |O       |
|org    |codelabor|system |web    |listener|Listener   |O       |
|org    |codelabor|system |web    |view   |SpringMVC View|O       |
|org    |codelabor|system |web    |interceptor|SpringMVC Interceptor|O       |
|org    |codelabor|system |service|       |Business Logic|O       |
|org    |codelabor|system |manager|       |Data Management|O       |
|org    |codelabor|system |domain |       |Data Model |X       |
|org    |codelabor|system |model  |       |Data Model |X       |
|org    |codelabor|system |dao    |       |Data Access Object|O       |
|org    |codelabor|system |dto    |       |Data Transfer Object|O       |
|org    |codelabor|system |vo     |       |Value Object|X       |