package com.sj.bd_3_exp_prog.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Map<String, Object> errorAttributesMap = errorAttributes.getErrorAttributes(
                new ServletWebRequest(request), ErrorAttributeOptions.defaults());

        request.setAttribute("timestamp", errorAttributesMap.get("timestamp"));
        request.setAttribute("path", errorAttributesMap.get("path"));
        request.setAttribute("error", errorAttributesMap.get("error"));
        request.setAttribute("status", errorAttributesMap.get("status"));
        request.setAttribute("message", errorAttributesMap.get("message"));
        request.setAttribute("exception", errorAttributesMap.get("exception"));

        Throwable error = errorAttributes.getError(new ServletWebRequest(request));
        if (error != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            error.printStackTrace(pw);
            request.setAttribute("trace", sw.toString());
        }

        return "errors/errorPage";
    }

}
