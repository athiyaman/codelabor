# Message 표준 #

Message 표준은  업무 특화, 업무 공통, 시스템 공통 메시지로 분류합니다.
업무 특화 메시지는 고객 관점에서의 용어를 사용하여 정의하고
업무 공통 메시지는 여러 업무 간 공통적으로 사용가능한 일반화된 메시지를 별도 분류합니다.
시스템 공통 메시지는 개발자, 유지보수자 관점의 용어를 사용합니다.

## 업무 특화 Message 표준 ##

TBD: 화면 정의서 작성 완료 후, 정제될 예정

## 업무 공통 Message 표준 ##

TBD: 화면 정의서 작성 완료 후, 정제될 예정

## 시스템 공통 Message 표준 ##

**Security 관련 Message 표준**

Spring Security 내장 Message를 기본적으로 사용합니다.
화면 출력된 메시지가 부자연스러운 경우, 커스텀 가능합니다.

  * [관련 글](http://www.mkyong.com/spring-security/display-custom-error-message-in-spring-security/)

### 영문 메시지 ###
```
TBD
```

### 한글 메시지 ###
```
TBD
```

**Validation 관련 Message 표준**

Spring Framework, Hibernate Validator 내장 Message를 기본적으로 사용합니다.

**그 외 Message 표준**

Spring Framework 내장 Message를 기본적으로 사용합니다.
화면 출력된 메시지가 부자연스러운 경우, 커스텀 가능합니다.

## Messages 파일명 표준 ##

화면에 출력되는 문자열(User friendly)은 아래와 같은 구분으로 .properties 파일에 등록된다.
화면에 출력되지 않는 문자열(System message)는 특별히 에러 코드로 관리되는 것을 >제외하고
소스 코드 상에서 개발자 정의로 직접 입력해서 사용할 수 있다.

|Filename|Locale|Extention|Descritption|Note|
|:-------|:-----|:--------|:-----------|:---|
|title   |`_`en |.properties|윈도우 타이틀 제목  |화면 정의서의 대표 화면명 (화면 ID) 참고|
|menu    |`_`en |.properties|메뉴명         |메뉴는 별도의 DBMS 상에 구현 가능|
|heading |`_`en |.properties|페이지 제목      |화면 정의서의 페이지 제목 참고|
|label   |`_`en |.properties|입력 폼의 레이블명  |화면 정의서의 폼 참고|
|button  |`_`en |.properties|버튼 표시명      |버튼 표준 문서 참고|
|messages|`_`en |.properties|확인, 경고, 에러 메시지, 윈도우 상태바 표시 메시지|메시지 표준 문서 참고|
|caption |`_`en |.properties|이미지, 표의 캡션명 |일반적인 웹 화면인 경우는 생략됨|
|title   |`_`ko |.properties|윈도우 제목      |화면 정의서의 대표 화면명 (화면 ID) 참고|
|menu    |`_`ko |.properties|메뉴명         |메뉴는 별도의 DBMS 상에 구현 가능|
|heading |`_`ko |.properties|페이지 제목      |화면 정의서의 페이지 제목 참고|
|label   |`_`ko |.properties|입력 폼의 레이블명  |화면 정의서의 폼 참고|
|button  |`_`ko |.properties|버튼 표시명      |버튼 표준 문서 참고|
|messages|`_`ko |.properties|확인, 경고, 에러 메시지, 윈도우 상태바 표시 메시지|메시지 표준 문서 참고|
|caption |`_`en |.properties|이미지, 표의 캡션명 |일반적인 웹 화면인 경우는 생략됨|