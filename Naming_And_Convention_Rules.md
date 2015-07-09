# 명명법 및 관례 #

## 개요 ##

시스템 구축에 필요한 각종 명명법 및 관례의 기본 원칙을 정의한다.
본 명명법은 보다 구체화된 명명법이 존재할 경우, 해당 내용으로 재정의될 수 있다.

|우선 순위|명명법|
|:----|:--|
|1    |PJT 정의 명명법 및 관례|
|2    |업종, 업무 용어 의존적 명명법 및 관례|
|3    |3rd Party SW 제품 의존적 명명법 및 관례|
|4    |개발 Framework 의존적 명명법 및 관례|
|5    |개발 IDE 의존적 명명법 및 관례|
|6    |개발 언어 의존적 명명법 및 관례|
|7    |운영체제 의존적 명명법 및 관례|

## 7순위: 운영체제 의존적 명명법 및 관례 ##

대상 시스템이 탑재되는 운영체제에서 널리 통용되는 관용적인 명명 및 관례를 사용한다.

## 6순위: 개발 언어 의존적 명명법 및 관례 ##

개발자가 기본적으로 숙지하고 있어야하는 명명법 및 관례에 해당된다.
코드 컨벤션의 경우, 실제 개발 시에는 개발 툴의 자동 Formatting 기능을 사용할 것이므로 개략적으로 통독한 후, 세부적인 내용까지 암기할 필요는 없다.
단, 사용하고 있는 명명법과 코드 컨벤션의 근거와 기원은 알아두도록 한다.

#### J2SE 코딩 컨벤션 ####
  * [Code Conventions for the Java Programming Language](http://java.sun.com/docs/codeconv/html/CodeConvTOC.doc.html)

#### J2EE 코딩 컨벤션 ####
  * [Code Conventions for the JavaServer Pages Technology Version 1.x Language](http://www.oracle.com/technetwork/articles/javase/code-convention-138726.html)
  * [Guidelines, Patterns, and code for end-to-end Java applications](http://www.oracle.com/technetwork/java/namingconventions-139351.html)

## 5 순위: 개발 IDE 의존적 명명법 및 관례 ##

개발자가 의도치 않더라도 개발 툴 차원에서 적용해두어야하는 명명법 및 관례에 해당된다.
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


## 4 순위: 개발 Framework 의존적 명명법 및 관례 ##

적용하고자하는 개발 Framework 및 Library에서 사용되는 명명법 및 코드 컨벤션이 있다면 이를 준용하여 전체적인 코드 형태가 이질감이 없도록 한다.

## 3 순위: 3rd Party SW 제품 의존적 명명법 및 관례 ##

적용하고자하는 3rd Party SW에서 사용되는 명명법 및 코드 컨벤션이 있다면 이를 준용하여 전체적인 코드 형태가 이질감이 없도록 한다.

## 2 순위: 업종, 업무 용어 의존적 명명법 및 관례 ##

Layered Architecture 상의 Business Layer, Presentation Layer, Domain Object의 경우, 업종, 업무 용어의 명명법이나 관계를 우선 적용한다.

## 1 순위: 프로젝트 정의 명명법 및 관례 ##

프로젝트에서 재정의한 명명법과 관례가 있다면 이것이 가장 우선적으로 적용된다.