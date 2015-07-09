# 패키지 커스텀 명명법 #
기 정의된 기본 패키지 구조에서 상황에 따라 아래와 같은 확장, 변형이 가능하다.

## 3rd Party S/W 제품을 확장하는 경우 ##
동일 인터페이스를 구현하는 복수 구현체가 존재하되, 특정 S/W 제품에 의존적인 경우, 해당 S/W 제품명으로 패키지를 구성한다. (벤더나 회사명이 아닌 S/W 제품명을 사용)

```
org.codelabor.system.util.xplatform XPLATFORM 확장 유틸리티
org.codelabor.system.web.filter.xplatform XPLATFORM 확장 서블릿 필터
org.codelabor.system.web.controller.xplatform XPLATFORM 확장 컨트롤러
```

## 패키지 복수형 표현을 사용하는 경우 ##
동일 패턴에 해당하는 복수 구현 클래스가 탑재될 경우, 패키지 이름을 복수형으로 사용할 수 있다.
```
org.codelabor.system.services 동일 레벨에 여러 개의 서비스들이 탑재되는 경우
org.codelabor.system.filters 동일 레벨에 여러 개의 필터들이 탑재되는 경우
```

## 구현 패키지, 인터페이스 패키지는 사용 금지 ##
인터페이스와 구현 클래스의 구분은 클래스명으로 구분하므로 패키지로 구분할 필요는 없다. (예: FileManager는 인터페이스, FileManagerImpl는 구현 클래스)
```
org.codelabor.system.file.manager.impl 사용하지 않음
```

같은 이유로 인터페이스를 표현하기 위한 패키지 역시 사용하지 않는다.
```
org.codelabor.system.file.manager.inf 사용하지 않음
```
기능적으로 인터페이스가 필요한 모듈일 경우, interface라는 패키지를 사용하지 않고 remoting.http, remoting.tcp 와 같은 형태로 명명한다.
```
org.codelabor.system.remoting.http HTTP 프로토콜 관련
org.codelabor.system.remoting.tcp TCP 프로토콜 관련
```