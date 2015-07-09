# STS Encoding #

여러 개발자와 공동 개발을 하다보면 파일의 Encoding이 서로 맞지 않아 트러블이 발생하는 경우가 있다.
아래와 같이 파일 확장자별로 Encoding을 정해 두도록 한다.
Default는 OS의 Default Encoding을 따르도록 되어 있으니 이를 UTF-8로 모두 수정하도록 한다.

단, 이 설정을 파일 확장자 별로하지 않고 Project 단위로 전체 적용도 가능하나
Project 단위로 전체 적용을 할 경우, 의도치 않은 파일까지 Encoding에 되어 버리니
명시적으로 꼭 Encoding을 바꿔야하는 경우에만 지정하여 쓰도록 한다.
(예: .properties 파일은 ISO-8859-1 로 encoding 하는 것이 spec)

CSS 파일에 대한 Encoding을 변경한다.

!encoding-web-css-files.png!

HTML 파일에 대한 Encoding을 변경한다.

!encoding-web-html-files.png!

JSP 파일에 대한 Encoding을 변경한다.

!encoding-web-jsp-files.png!