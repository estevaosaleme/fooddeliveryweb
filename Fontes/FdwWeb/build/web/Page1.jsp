<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : 18/03/2010, 21:09:25
    Author     : pedro
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:button id="btnPortal" style="left: 71px; top: 24px; position: absolute" text="Portal"/>
                        <webuijsf:button actionExpression="#{Page1.btnAdministracao_action}" id="btnAdministracao"
                            style="left: 71px; top: 72px; position: absolute" text="Administração"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
