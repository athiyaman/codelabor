# Java EE #

### API ###

Java EE 버전별 API 문서는 아래와 같다.

  * [Java EE 7](http://docs.oracle.com/javaee/7/api/)
  * [Java EE 6](http://docs.oracle.com/javaee/6/api/)
  * [Java EE 5](http://docs.oracle.com/javaee/5/api/)
  * [J2EE 1.4](http://docs.oracle.com/javaee/1.4/api/)

### Technologies ###

Java EE 버전별 지원되는 기술을 확인하여 대상 시스템의 WAS에서 구현 가능 여부를 확인한다.

JEE Spec 별로 지원되는 Java Technology에 대한 버전 차이가 존재하므로 실제 적용될 Web Application Server가 어떤 Spec을 지원하는지 확인하여 구현 기술의 범위를 사전 점검해야한다.

특히, Local PC 개발 환경에서의 Web Application Server와
Development / Stage / Production (개발 / 검증 / 운영) 서버 환경에서의 Web Application Server가 상이할 경우, (개발 환경은 Tomcat, 운영 환경은 WebLogic을 사용하는 경우) JEE Spec의 구현 상의 차이와 내장한 3rd Party Library의 버전 차이, Class Loader의 작동 방식 차이로 인해 개발 시에는 발견하지 못했던 트러블이 이행 과정에서 발생할 수 있다.

WAS가 동일 제품, 동일 버전이라 하더라도 OS / Platform / CPU Architecture 별로 Java Runtime 환경에 차이가 있을 수 있으므로 WAS, JEE, JSE 간의 기술 버전 확인은 반드시 필요하다.

가급적, 운영 환경과 동일한 환경을 갖추어 Risk가 조기 발견, 통제되도록 한다.



  * [Java EE 7](http://www.oracle.com/technetwork/java/javaee/tech/index.html)
  * [Java EE 6](http://www.oracle.com/technetwork/java/javaee/tech/javaee6technologies-1955512.html)
  * [Java EE 5](http://www.oracle.com/technetwork/java/javaee/tech/javaee5-jsp-135162.html)