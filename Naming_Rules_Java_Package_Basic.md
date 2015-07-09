# 패키지 기본 명명법 #
도메인 역순으로 기본 패키지를 구성한다. 반드시 등록된 도메인이 아니라도 상관없으나, 소스 코드에 대한 오너십이 있는 조직 이름이 포함되도록 한다.
```
org.codelabor 기본 패키지
```
기본적으로 공식 도메인을 참고하여 기본 패키지명을 정의하되, 필요에 따라 일부를 생략하거나 보완할 수 있다.
단, 수정한 기본 패키지를 도메인으로 접속한 경우 해당 조직과 무관한 사이트로 접속될 경우, 해당 패키지는 사용하지 않는다.


# 상위 패키지 #
기본 패키지에 이어 상위 공통 패키지를 구성한다.

## 상위 공통 패키지 ##
업무 독립적으로 시스템 공통, 업무 공통, 예제 패키지를 둔다.
```
org.codelabor.system 시스템 공통 패키지
org.codelabor.common 업무 공통 패키지
org.codelabor.example 예제 패키지
```
예제 패키지는 개발자가 참고할 수 있는 예제 소스를 탑재하되, CI(Continuous Integration) 서버에서 빌드 후, 배포 시에는 예외처리하여 배포되지 않도록 한다.
테스트 코드 역시 운영 서버 배포시에는 예외 처리되는데 이 경우, 패키지로 구분하지 않고 패키지로 구분하지 않고 Source Directory 자체를 구분하도록 한다. (Maven 스타일의 소스 디렉토리 레이아웃 권장)
```
src/main/java 소스 코드 디렉토리 (배포됨)
src/test/java 테스트 코드 디렉토리 (배포되지 않음)
```

## 상위 업종(Industry) 패키지 ##
업종별 패키지를 구분해서 구성해야하는 경우 상위 패키지에 업무명을 넣기 전에 업종명을 넣는다.
```
org.codelabor.finance 금융업 관련 패키지
org.codelabor.insurance 보험업 관련 패키지
org.codelabor.construction 건설업 관련 패키지
org.codelabor.manufacturing 제조업 관련 패키지
org.codelabor.education 교육서비스업 관련 패키지
```
처음부터 업종별 패키지를 만들 필요는 없고, 개발 소스가 여러 업종에 대해 개발되고 업종별 자산 성숙도가 높아져 독립시켜야할 필요성이 생겼을 때 refactoring 하는 것을 권장한다.
업종별 자산 성숙도가 낮거나 굳이 업종을 구분할 필요가 없을 경우, 생략 가능하다.

## 상위 업무 패키지 ##
기본 패키지(혹은 상위 업종 패키지)에 이어 상위 업무 패키지를 구성한다.
업무 의존적인 패키지를 프로젝트에 맞게 구성한다.
업무명은 가급적 읽었을 때 의미가 파악되는 단어를 사용하도록 한다.
```
org.codelabor.banking 뱅킹 업무 패키지
org.codelabor.labor 노무 업무 패키지
org.codelabor.estimate 견적 업무 패키지
```
업무명에 대한 코드가 존재하고 충돌없이 의미 파악이 가능하다는 전제 하에 코드를 패키지로 사용하는 것도 가능하다.
```
org.codelabor.bnk 뱅킹 업무 패키지
org.codelabor.lbr 노무 업무 패키지
org.codelabor.est 견적 업무 패키지
```

# 하위 패키지 #
상위 패키지 아래에 주제별 패키지를 구성할 수 있다.
하위 패키지는 실제 인터페이스나 클래스가 탑재되기에 적절한 수준이 나올 때까지 하위 단계를 더 만들 수 있다.
처음부터 하위 패키지를 깊게 만들기 보다는 필요에 의해서 구분이 필요해질 때 하위 패키지를 추가하는 방식으로 refactoring 할 것을 권장한다. (개발 표준 작성 시에도 refactoring으로 인한 변경이 있을 수 있음을 명시할 것)

## 하위 공통 패키지 ##
```
org.codelabor.system.file 파일 관리 관련 패키지
org.codelabor.system.remoting 원격 호출 관련 패키지
org.codelabor.system.security 보안 관련 패키지
org.codelabor.common.calendar 캘린더 관련 패키지
org.codelabor.common.zip 우편번호 관련 패키지
org.codelabor.example.file 파일 관리 관련 예제 패키지
org.codelabor.example.remoting 원격 호출 관련 예제 패키지
org.codelabor.example.security 보안 관련 예제 패키지
org.codelabor.example.calendar 캘린더 관련 예제 패키지
org.codelabor.example.zip 우편번호 관련 예제 패키지
```

## 하위 업무 패키지 ##
하위 업무가 있을 경우, 패키지를 추가할 수 있다.

# 패턴/역할 패키지 #
특정 패턴 혹은 역할 클래스를 만들 정도로 패키지가 충분히 정의되었다면 탑재될 패턴/역할명으로 패키지를 구성한다.
패턴/역할명은 읽었을 때 다른 것으로 오인하지 않는 이름을 사용한다.
패턴/역할명은 반드시 GoF, Core J2EE Patterns의 용어와 일치하지 않아도 무방하고 특정 S/W 제품에서 사용하는 패턴/역할명을 사용해도 무방하다.
패턴/역할명은 가급적 직접 정의, 작명한 이름보다는 불특정 다수의 개발자가 그 내용을 짐작할 수 있는 개발자 커뮤니티에서 관례상 통용되는 이름을 사용한다.

```
org.codelabor.system.file.advice 파일 관리 AOP 관련 패키지
org.codelabor.system.file.dao 파일 관리 DAO 관련 패키지
org.codelabor.system.file.dto 파일 관리 DTO 관련 패키지
org.codelabor.system.file.exception 파일 관리 Exception 관련 패키지
org.codelabor.system.file.listener 파일 관리 Listener 관련 패키지
org.codelabor.system.file.manager 파일 관리 Manager 관련 패키지
org.codelabor.system.file.service 파일 관리 Service 관련 패키지
org.codelabor.system.file.util 파일 관리 Utility 관련 패키지
org.codelabor.system.file.web 파일 관리 Web 관련 패키지
```