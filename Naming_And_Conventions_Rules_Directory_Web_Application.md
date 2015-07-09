# Web Application Directory Layout #

## Web Application의 디렉토리 구조 ##

  * [Web Directory Layout 엑셀 파일](https://codelabor.googlecode.com/svn/trunk/documentation/0%20architecture/develop/standards/directory-layout/web-directory-layout.xlsx)


|구분|구분|Level 1|Level 2|Level 3|Level 4|비고|
|:-|:-|:------|:------|:------|:------|:-|
|Web Doc Root 디렉토리|Directory|/      |       |       |       |  |
|Index 페이지 파일|File|/index.html|       |       |       |  |
|Theme와 무관한 CSS 디렉토리|Directory|/css   |/      |       |       |  |
|Theme와 무관한 CSS 파일|File|/css   |/스타일시트명.css|       |       |Theme 무관 공통 CSS|
|공개 문서 디렉토리|Directory|/documentation|       |       |       |  |
|공개 문서 디렉토리 (매뉴얼)|Directory|/documentation|/manual|       |       |  |
|공개 문서 디렉토리 (약도)|Directory|/documentation|/roughmap|       |       |  |
|공개 문서 디렉토리 (배치도)|Directory|/documentation|/seatplan|       |       |  |
|공개 문서 디렉토리 (문서 양식)|Directory|/documentation|/template|       |       |  |
|폰트|Directory|/font  |       |       |       |  |
|Theme와 무관한 Image 디렉토리|Directory|/images|/      |       |       |  |
|Theme와 무관한 Image 파일|File|/images|/banner.png|       |       |Theme 무관 공통 Image|
|Theme와 무관한 Java Script 디렉토리|Directory|/js    |/      |       |       |  |
|Theme와 무관한 Java Script 파일|File|/js    |/jquery-xxx.js|       |       |Theme 무관 공통 Java Script|
|업무별 페이지 파일|File|/업무명   |/      |       |       |하위 업무 구분 추가 가능|
|업무별 html 파일|File|/업무명   |/페이지명.html|       |       |  |
|기본 Theme 디렉토리|Directory|/themes|/default|/      |       |  |
|기본 Theme CSS 디렉토리|Directory|/themes|/default|/css   |/      |  |
|기본 Theme Print 출력용 CSS 파일|File|/themes|/default|/css   |/print.css|  |
|기본 Theme PC 화면 출력용 CSS 파일|File|/themes|/default|/css   |/screen.css|  |
|기본 Theme 휴대용 단말기 화면 출력용 CSS 파일|File|/themes|/default|/css   |/mobile.css|  |
|기본 Theme Image 디렉토리|Directory|/themes|/default|/images|/      |  |
|기본 Theme Image 파일|File|/themes|/default|/images|/이미지명.png|  |
|기본 Theme Java Script 디렉토리|Directory|/themes|/default|/js    |/      |  |
|기본 Theme Java Script 파일|File|/themes|/default|/js    |/스크립트명.js|  |
|선택 Theme 디렉토리|Directory|/themes|/테마명   |/      |       |  |
|선택 Theme CSS 디렉토리|Directory|/themes|/테마명   |/css   |/      |  |
|선택 Theme Print 출력용 CSS 파일|File|/themes|/테마명   |/css   |/print.css|  |
|선택 Theme PC 화면 출력용 CSS 파일|File|/themes|/테마명   |/css   |/screen.css|  |
|선택 Theme 휴대용 단말기 화면 출력용 CSS 파일|File|/themes|/테마명   |/css   |/mobile.css|  |
|선택 Theme Image 디렉토리|Directory|/themes|/테마명   |/images|/      |  |
|선택 Theme Image 파일|File|/themes|/테마명   |/images|/이미지명.png|  |
|선택 Theme Java Script 디렉토리|Directory|/themes|/테마명   |/js    |/      |  |
|선택 Theme Java Script 파일|File|/themes|/테마명   |/js    |/스크립트명.js|  |
|JSP Tag 디렉토리|Directory|/WEB-INF|/tags  |       |       |  |
|JSP Tag 파일|File|/WEB-INF|/tags  |/태그파일명.tag|       |  |
|include 될 jspf 디렉토리|Directory|/WEB-INF|/jspf  |       |       |  |
|include 될 jspf 파일|File|/WEB-INF|/jspf  |/파일명.jspf|       |  |