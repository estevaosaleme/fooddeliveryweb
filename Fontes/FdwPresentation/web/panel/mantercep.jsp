
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">


<f:view>
    <html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      >
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Painel ADM - Manter CEP</title>
        </head>
        <body>

            <h:dataTable value="#{cepBean.listarCeps}" var="item" >
                <f:facet name="header" >
                    <h:panelGroup>
                        <div id="groupHeaderTableTexto">
                    <h:outputText value="Ceps já cadastrados" />
                        </div>
                        <div id="groupHeaderTableBotoes">
                            
                        </div>
                    </h:panelGroup>
                </f:facet>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Codigo" />
                    </f:facet>
                    <h:outputText value="#{item.codigoCep}"></h:outputText>
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Bairro"/>
                    </f:facet>
                    <h:outputText value="#{item.nomeBairro}"></h:outputText>
                </h:column>

            </h:dataTable>
        </body>
    </html>
</f:view>
