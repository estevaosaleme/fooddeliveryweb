<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DetalhePrato
    Created on : 18/05/2010, 16:33:13
    Author     : pedro
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1" title="FoodDeliveryWeb">
                    <webuijsf:link id="link1" url="../resources/Portal/style.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid; width: 600px; height: 300px;">
                    <webuijsf:form id="form1">
                        <jsp:directive.include file="top.jspf"/>
                        <div id="content">
                            <div class="float">
                                <div class="left">
                                    <h:panelGrid columns="1" id="panelPratoDesc" style="align:center;">
                                        <webuijsf:imageHyperlink height="120" id="imgPrato" imageURL="/ImagemPrato?id=#{portal$DetalhePrato.prato.codigoPrato}" width="160"/>
                                    </h:panelGrid>
                                </div>
                            </div>
                            <div class="right">
                                <h:panelGrid columns="1" id="panelPratoCompra">
                                    <webuijsf:staticText id="sttValorUnitario" text="Valor Unitário"/>
                                    <h:panelGrid columns="2" id="panelValor" width="100">
                                        <webuijsf:label for="sttValor" id="lblReais" style="text-align: right" text="R$ "/>
                                        <webuijsf:staticText id="sttValor" style="font-size: 18px; font-weight: bold" text="#{portal$DetalhePrato.prato.valorUnitario}"/>
                                        <br/>
                                        <br/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelQuant">
                                        <webuijsf:label for="sttTamanho" id="lblTamanho" text="Tamanho"/>
                                        <webuijsf:staticText id="sttTamanho" text="#{portal$DetalhePrato.prato.tamanho}"/>
                                        <webuijsf:label for="txtQuant" id="lblQuant" text="Quantidade"/>
                                        <webuijsf:textField columns="3" id="txtQuant" text="#{portal$DetalhePrato.quantidade}"/>
                                        <br/>
                                    </h:panelGrid>
                                    <webuijsf:button actionExpression="#{portal$DetalhePrato.hlkCompra_action}" id="hlkCompra"
                                        style="text-align: center; width: 119px" text="Comprar"/>
                                </h:panelGrid>
                            </div>
                            <img alt="" class="pad" height="4" src="../resources/Portal/images/middle.jpg" width="620"/>
                            <div class="bot">
                                <h:panelGrid columns="1" id="panelDescricao">
                                    <webuijsf:staticText id="sttNome" style="font-size: 18px; font-style: oblique" text="#{portal$DetalhePrato.prato.nomePrato}"/>
                                    <br/>
                                    <webuijsf:staticText id="staticText2" text="#{portal$DetalhePrato.prato.descricaoPrato}"/>
                                </h:panelGrid>
                            </div>
                        </div>
                        <jsp:directive.include file="bottom.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
