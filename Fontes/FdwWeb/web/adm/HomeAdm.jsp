<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : HomeAdm
    Created on : 18/03/2010, 21:15:08
    Author     : pedro
-->

<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="../resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div id="pagina" class="container">
                            <jsp:directive.include file="top.jspf"/>
                            <div id="principal" class="blocoPagina">
                                <jsp:directive.include file="menu.jspf"/>
                                <div id="conteudoPagina" class="blocoPagina">
                                    <div id="localizacao">» <a class="linkMapaSite" href="adm/HomeAdm.jsp">Página Inicial</a></div>
                                    <h1 class="tituloPrincipal">Home</h1>
                                    Olá administrador, seja bem vindo !
                                </div>
                            </div>
                            <jsp:directive.include file="bottom.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
