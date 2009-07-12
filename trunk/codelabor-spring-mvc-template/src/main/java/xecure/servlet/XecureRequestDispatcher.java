// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XecureRequestDispatcher.java

package xecure.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

// Referenced classes of package xecure.servlet:
//            XecureHttpServletRequest, XecureHttpServletResponse

public class XecureRequestDispatcher
    implements RequestDispatcher
{

    public XecureRequestDispatcher(String s, HttpServletRequest httpservletrequest)
    {
        rd = null;
        rd = httpservletrequest.getRequestDispatcher(s);
        requestUrl = s;
    }

    public void forward(ServletRequest servletrequest, ServletResponse servletresponse)
        throws ServletException, IOException
    {
		/*
        XecureHttpServletRequest xecurehttpservletrequest = (XecureHttpServletRequest)servletrequest;
        XecureHttpServletResponse xecurehttpservletresponse = (XecureHttpServletResponse)servletresponse;
        rd.forward(xecurehttpservletrequest.req, xecurehttpservletresponse.res);
		*/
		Object obj = null;
        Object obj1 = null;
        if(servletrequest instanceof XecureHttpServletRequest)
            obj = ((XecureHttpServletRequest)servletrequest).req;
        else
            obj = servletrequest;
        if(servletresponse instanceof XecureHttpServletResponse)
            obj1 = ((XecureHttpServletResponse)servletresponse).res;
        else
            obj1 = servletresponse;
        rd.forward((ServletRequest)obj, (ServletResponse)obj1);		
    }

    public void include(ServletRequest servletrequest, ServletResponse servletresponse)
        throws ServletException, IOException
    {
        Object obj = null;
        Object obj1 = null;
        if(servletrequest instanceof XecureHttpServletRequest)
            obj = ((XecureHttpServletRequest)servletrequest).req;
        else
            obj = servletrequest;
        if(servletresponse instanceof XecureHttpServletResponse)
            obj1 = ((XecureHttpServletResponse)servletresponse).res;
        else
            obj1 = servletresponse;
        rd.include((ServletRequest)obj, (ServletResponse)obj1);
    }

    private RequestDispatcher rd;
    private String requestUrl;
}
