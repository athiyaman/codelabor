# Java 코드 컨벤션 #
## 기본 코드 컨벤션 ##

개발자가 기본적으로 숙지하고 있어야하는 코드 컨벤션이다.
실제 개발 시에는 개발 툴의 자동 Formatting 기능을 사용할 것이므로 개략적으로 통독한 후, 세부적인 내용까지 암기할 필요는 없다.
단, 사용하고 있는 명명법의 근거와 기원은 알아두도록 한다.

#### J2SE 코딩 컨벤션 ####
  * [Code Conventions for the Java Programming Language](http://java.sun.com/docs/codeconv/html/CodeConvTOC.doc.html)

#### J2EE 코딩 컨벤션 ####
  * [Code Conventions for the JavaServer Pages Technology Version 1.x Language](http://www.oracle.com/technetwork/articles/javase/code-convention-138726.html)
  * [Guidelines, Patterns, and code for end-to-end Java applications](http://www.oracle.com/technetwork/java/namingconventions-139351.html)

## 개발 IDE의 코드 컨벤션 지원 ##

Eclipse (혹은 STS)의 내장 Formatter를 사용하여 개발자로 하여금 Formatting을 하기 위한 불필요한 공수를 줄여주도록 한다.
Eclipse 내장 Formatter의 포맷 형식과 Java Conventions 의 포맷 형식에는 아래와 같은 차이가 있다.

#### Eclipse (built-in) ####

```xml

<setting id="org.eclipse.jdt.core.formatter.tabulation.char" value="tab"/>
<setting id="org.eclipse.jdt.core.formatter.tabulation.char" value="mixed"/>
```


#### Java Conventions (built-in) ####

```xml

<setting id="org.eclipse.jdt.core.formatter.tabulation.size" value="4"/>
<setting id="org.eclipse.jdt.core.formatter.tabulation.size" value="8"/>
```