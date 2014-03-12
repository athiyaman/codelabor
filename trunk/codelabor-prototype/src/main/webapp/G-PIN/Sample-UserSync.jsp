<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="gov.mogaha.gpin.sp.proxy.GPinProxy"%>

<%
    /**
     * 이 서비스는 공공I-PIN에서 사용자에 대한 정보가 변경되었을경우 해당 사항을 공지하기 위한 페이지입니다.
     * 공공I-PIN 공무원창구를 통해서 이 페이지에 대한 주소(URL)이 등록되어야 서비스를 사용할 수 있습니다.
     */

    GPinProxy proxy = GPinProxy.getInstance(this.getServletConfig().getServletContext());
    response.setContentType("text/plain");

	out.clear();

 	String gPinSyncData = request.getParameter("gPinSyncData");

 	// 수신한 사용자 변경정보를 복호화합니다.
    String[] syncData = null;
    try
    {
        syncData = proxy.decryptGpinSync(gPinSyncData);
    }
    catch(Exception e)
    {
        // 에러에 대한 처리는 이용기관에 맞게 처리할 수 있습니다.
        e.printStackTrace();
        out.println(e.getMessage());
    }
    // 수신받은 데이터는 { 개인식별번호(virtualNo), ( 변경된항목명(), 변경된항목값() ) } 으로 구성됩니다.
    if(syncData != null)
    {
        String vid = syncData[0];
        for(int i = 0; i < (syncData.length/2) ; i++)
        {
            String attrName = syncData[i*2 + 1];
            String attrValue = syncData[i*2 + 2];
            // TODO 변경된 사용자정보를 반영합니다.
        }
    }

    // 사용자변경정보를 정상적으로 처리하였을 경우 succ, 못 받았을 경우 fail 값을 공공I-PIN으로 전달합니다.
    try
    {
        String responseMsg = proxy.makeResponseSyncResponse(syncData[0], "succ");
//        String responseMsg = proxy.makeResponseSyncResponse(syncData[0], "fail");
        out.println(responseMsg);
    }
    catch(Exception e)
    {
        // 에러에 대한 처리는 이용기관에 맞게 처리할 수 있습니다.
        e.printStackTrace();
        out.println(e.getMessage());
    }
  %>
