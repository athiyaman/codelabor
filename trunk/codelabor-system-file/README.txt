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