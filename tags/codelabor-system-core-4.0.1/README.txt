2.0.0
	codelabor-system-core에서 web 관련 리소스 분리하여 codelabor-system-web으로 refectoring
	anyframe 의존 모듈을 org.codelabor.system.anyframe 패키지 아래로 refectoring

2.0.1
	InvalidParameterException 추가
	pom.xml 정제

2.0.3
	DateUtils 추가
	FileUtils 보완

2.0.4
	StringUtils 추가

3.0.0
	Spring 3.x 기반으로 리팩토링

3.0.1
	DAOConstants.java 위치 리팩토링

3.0.2
	DataSourceResolver 추가
	FileUtils deprecate 처리
	fileName > filename 명명으로 수정

3.0.3
	javadoc @link 개선
	@SuppressWarnings("deprecation")
	dependency 개선

3.0.4
	dependency 개선
	findbug 지적 사항 개선

3.0.5
	ListUtils 메소드 추가

3.0.6
	오타 수정

3.0.7
	ExceptionUtils 제거
	org.apache.commons.lang.exception.ExceptionUtils 대체

3.0.7
	ExceptionUtils 추가

4.0.0
	Anyframe 의존 관계 제거
	Naming Conventions 수정 (CODELABOR 4.0)
	Spring Framework version 업그레이드 (4.x)
	pom.xml 정리 (미사용 plugin 제거)
	Eclipse Source > format, sort members 실행
	Messages 정리
	PMD 위반 시정 조치

4.0.1
	org.codelabor.system.security 이관 (codelabor-system-security)
	org.codelabor.system.sniffer 이관 (codelabor-system-sniffer)