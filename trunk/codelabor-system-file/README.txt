2.0.0
	org.codelabor.file.strategies > org.codelabor.file.anyframe.idgen.strateties로 refectoring
	javadoc 보완

2.0.1
	다운로드하지 않고 브라우저에서 직접 렌더링하기 위해 view 추가
	버튼, 레이블 추가

2.0.2
	UploadUtils 파일 경로 자르기 기능 보완 (Unix, Windwos Client 대응)

2.0.3
	deleteAll(), selectFile() 추가
	deleteFile(), selectFile() deprecated
	deleteFileByFileId(), deleteFileByMapId() 추가

2.0.4
	TestCase 추가
	javadoc 보완
	UploadUtils에서 저장 경로 없을 경우, 디렉토리 생성

2.0.5
	order by file_id 추가
	tika util로 mime type 보완

2.0.6
	filesystem 저장 시 tika 사용 보완

3.0.0
	Spring 3 flavor로 구조 개선
	Spring 2 기반 기능에 대한 @SuppressWarnings("deprecation") 추가
	fileName > filename 으로 명명법 수정
	ojdbc dependency scope을 system으로 수정

3.0.1
	Spring 2 기반 Controller 제거
	log4jdbc 추가
	findbug 지적 사항 조치

3.0.2
	base class 의존 관계 끊기
	derby 테스트 완료
	
3.1.0
	Anyframe 5.0 지원	
	
	
	
[derby 사용 시 준비 사항]
derby를 별도로 실행하는 방법
---------------------------------------------------------------------------
C:\Users\bomber>java -jar %DERBY_HOME%\lib\derbyrun.jar ij
Unable to access jarfile C:\Program

C:\Users\bomber>java -jar "%DERBY_HOME%\lib\derbyrun.jar" ij
ij 버전 10.6
ij> connect 'jdbc:derby:testdb;create=true';
ij> exit;

C:\Users\bomber>java -jar "%DERBY_HOME%\lib\derbynet.jar" start
2011-06-29 01:32:07.758 GMT : 기본 서버 보안 정책을 사용하여 보안 관리자가 설치됩니다.
2011-06-29 01:32:08.027 GMT : Apache Derby 네트워크 서버 - 10.6.2.1 - (999685)이(가) 시작되어 포트 1527에서 연결을 승인
할 준비가 되었습니다.
---------------------------------------------------------------------------	