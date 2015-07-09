# Maven Directory Layout #

## Maven 디렉토리 구조 ##

  * [Maven Directory Layout 엑셀 파일](https://codelabor.googlecode.com/svn/trunk/documentation/0%20architecture/develop/standards/directory-layout/maven-directory-layout.xlsx)

|목적|구분|Level 1|Level 2|Level 3|Level 4|비고|
|:-|:-|:------|:------|:------|:------|:-|
|Assembly descriptor 디렉토리|Directory|/src   |/main  |/assembly|       |  |
|Configuration 디렉토리|Directory|/src   |/main  |/config|       |미사용|
|Resource filter 디렉토리|Directory|/src   |/main  |/filters|       |  |
|Application/Library Source 디렉토리 |Directory|/src   |/main  |/java  |       |  |
|Application/Library resource 디렉토리|Directory|/src   |/main  |/resources|       |  |
|Web Application source 디렉토리|Directory|/src   |/main  |/webapp|       |  |
|Main 디렉토리|Directory|/src   |/main  |       |       |  |
|Project Site 구축용 page 디렉토리|Directory|/src   |/site  |       |       |  |
|Test Resource filter 디렉토리|Directory|/src   |/test  |/filters|       |  |
|Test source 디렉토리 |Directory|/src   |/test  |/java  |       |  |
|Test resource 디렉토리|Directory|/src   |/test  |/resources|       |  |
|Test 디렉토리|Directory|/src   |/test  |       |       |  |
|source 디렉토리|Directory|/src   |       |       |       |  |
|binary 디렉토리|Directory|/target|       |       |       |  |
|Project Object Model 파일|File|/pom.xml|       |       |       |  |
|License 파일|File|LICENSE.txt|       |       |       |  |
|Readme 파일|File|README.txt|       |       |       |  |
|Maven WTP 연계를 위한 파일 디렉토리|Directory|/target|/m2e-wtp|       |       |자동 생성|
|배포용 Archived 파일을 만들기 위한 properties 디렉토리|Directory|/target|/maven-archiver|       |       |자동 생성|
|Test 결과 디렉토리|Directory|/target|/surefire|       |       |자동 생성|
|Test 결과 디렉토리|Directory|/target|/surefire-reports|       |       |자동 생성|
|Exploded Web Application 디렉토리|Directory|/target|/{웹어플리케이션이름}|       |       |자동 생성|
|Web Application Archive 파일|File|/target|/{웹어플리케이션이름}.war|       |       |자동 생성|