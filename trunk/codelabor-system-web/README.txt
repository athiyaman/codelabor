2.0.1
	web 리소스 refectoring
	pom.xml 정제

2.0.2
	SelectiveSessionIdValidationFilter 버그 픽스 (잘못된 상속 관계)

2.0.3
	Session Id Validation Filter를 codelabor-system-security로 이동

2.0.4
	RequestConstants 키 명 refectoring (system.servlets > system.web.servlets)
	BaseFilterImpl 로거 설정 변경 (this.getClass())
	Selective Filter에 toLowerCase() 제거

2.0.5
	spring-binding 버전 수정 (2.0.9.RELEASE)

2.0.6
	JSON Servlet 추가

3.0.0
	Spring 3.x 기반으로 리팩토링

3.0.1
	json 패키지 리팩토링
	maven 패키지 타입 수정 (war > jar)

3.0.3
	dependency 정리
	resources 정리
	FileUtils > FilenameUtils로 교체

3.0.4
	codelabor-system-core 업데이트

4.0.0
	Anyframe 의존 관계 제거
	Naming Conventions 수정 (CODELABOR 4.0)
	Spring Framework version 업그레이드 (4.x)
	pom.xml 정리 (미사용 plugin 제거)
	Eclipse Source > format, sort members 실행
	Logger 교체 (log4j -> logback)

4.0.1
	tld 파일 추가