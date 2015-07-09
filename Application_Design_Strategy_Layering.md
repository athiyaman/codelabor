# Layering vs. Delayering #

아키텍처 전체를 평가할 때 +, -, 0 가 되는 아키텍처 상의 상쇄가 존재한다면 불필요한 레이어, 패턴을 제거할 수 있다.

**Delayering을 고려해야하는 경우**

Anyframe 일부 에디션에서 사용되는 DAO Manager는 DB Table에 대해 1:1로 DAO, VO를 생성하고 Table 변경 시마다 새로 생성한다.
이 경우, DAO는 Spring Container에서 Bean으로 관리되지 않고 POJO를 new 로 생성한다.

Service는 DAO와 1:1 관례로 종속적으로 매핑되는 단순 구조라
실제로는 패턴 상의 로직과 SQL의 분리, 재사용을 위한 DAO의 존재 목적은 상실하게 된다.

DAO를 new로 생성하여 Spring Bean으로 관리되지 않기 때문에 AOP 적용도 불가하여 선언적인 SQL Injection 탐지, Authorization 적용이 불가하고 이를 위해 상위 Layer의 Service에 AOP를 걸어야하는 상황이 발생한다.

실제 내용면에서는 패턴 상의 장점도 없고, 리소스 측면에서도 유리하지 못한 구조를 사용하기 위해
DAO Manager를 운용하기 위한 별도의 Servlet Container를 관리하고 불필요한 사용자 계정 관리를 해야하는 부담이 발생한다.

이와 같은 상황인 경우, DAO의 존재는 또 다른 클래스가 생길 뿐, 코드 분리 역할 밖에 하지 않기 때문에 Service 내에 SQL 호출을 위한 별도의 method로 분리하는 것보다 더 나을 것이 없다.