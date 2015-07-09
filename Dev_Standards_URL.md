# 개발 인프라 관련 URL 명명법 #

개발 인프라 관련 시스템의 URL 명명 방법은 아래와 같다.

## SCM URL ##

형상 관리 서버의 URL은 아래와 같이 정의한다.

  * [project-startup/configuration-management-plan/scm-repository-list.xlsx SCM Repository List](https://codelabor.googlecode.com/svn/trunk/documentation/1)

|Repository Name|Base Line 관리 여부|URL|Description|채택 여부|
|:--------------|:--------------|:--|:----------|:----|
|documents      |X              |https://<scm server>/svn/<project code>/documents/public|공용 문서 관리 (인수 대상 Deliverable 산출물 포함)|O    |
|documents      |X              |https://<scm server>/svn/<project code>/documents/private|개인 문서 관리 (작업 중인 Working 산출물 포함)|O    |
|documents      |X              |https://<scm server>/svn/<project code>/documents/|Project Root 경로|O    |
|documents      |O              |https://<scm server>/svn/<project code>/documents/branches|Branche 관리 (병합 후, 삭제 허용)|X    |
|documents      |O              |https://<scm server>/svn/<project code>/documents/tag|Snapshot 관리 (변경 없음, 삭제 금지)|X    |
|documents      |O              |https://<scm server>/svn/<project code>/documents/trunk|최신 작업 파일을 관리 (완성 전까지 지속적으로 변경)|X    |
|source-code    |X              |https://<scm server>/svn/<project code>/source-code|Project Root 경로|X    |
|source-code    |O              |https://<scm server>/svn/<project code>/source-code/branches|Branche 관리 (병합 후, 삭제 허용)|O    |
|source-code    |O              |https://<scm server>/svn/<project code>/source-code/tag|Snapshot 관리 (변경 없음, 삭제 금지)|O    |
|source-code    |O              |https://<scm server>/svn/<project code>/source-code/trunk|최신 작업 파일을 관리 (완성 전까지 지속적으로 변경)|O    |


# 개발 대상 시스템 URL 명명법 #
개발 대상 시스템의 URL 명명 방법은 아래와 같다.

TBD