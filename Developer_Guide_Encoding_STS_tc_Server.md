# STS tc Server server.xml #

기본 설정으로는 ISO-8859-1로 처리되므로 UTF-8을 처리하기 위해서는
tc Server의 server.xml 파일에 아래와 같은 내용이 추가되어야 한다.

설정 파일은 Project Explorer 의
Servers > VMware vFabric tc Server Developer Edition > server.xml 파일을 수정하면 된다.

Connector 설정에 아래 내용을 추가한다.

  * useBodyEncodingForURI="true"
  * URIEncoding="UTF-8"

STS 기준으로 server.xml 에 등록되는 형태는 아래와 같다.

### server.xml ###
```
<Connector 
    acceptCount="100" connectionTimeout="20000" 
    executor="tomcatThreadPool" maxKeepAliveRequests="15"
    port="${bio.http.port}" 
    protocol="org.apache.coyote.http11.Http11Protocol" 
    redirectPort="${bio.https.port}"
    useBodyEncodingForURI="true" URIEncoding="UTF-8"/>
```