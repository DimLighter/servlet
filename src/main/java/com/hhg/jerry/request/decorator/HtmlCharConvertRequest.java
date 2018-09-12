package com.hhg.jerry.request.decorator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by lining on 2018/9/12.
 */
public class HtmlCharConvertRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public HtmlCharConvertRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name){
        String value = this.request.getParameter(name);
        if (value == null) {
                return null;
            }
        char content[] = value.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                default:
                    sb.append(content[i]);
            }
         }
        return sb.toString();
    }
}
