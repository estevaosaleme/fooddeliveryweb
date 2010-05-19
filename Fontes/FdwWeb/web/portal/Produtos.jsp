<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Estabelecimentos
    Created on : 16/05/2010, 13:56:14
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
                            <h:panelGrid columns="2" id="panelEstabelecimentos" width="580">
                                <webuijsf:table augmentTitle="false" id="tableEstab" paginateButton="true" paginationControls="true" title="Estabelecimentos" width="350">
                                    <webuijsf:tableRowGroup emptyDataMsg="Não há estabelecimentos cadastrados" id="tableRowGroup1" rows="10"
                                        sourceData="#{SessionBean1.estabelecimentoProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn headerText="Estabelecimento" id="ColEstabelecimento" width="100">
                                            <webuijsf:hyperlink actionExpression="#{portal$Produtos.hlkEstabelecimento_action}" id="hlkEstabelecimento" text="#{currentRow.value['nomeFantasia']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Slogan" id="tableColumn4" width="250">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['slogan']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <webuijsf:table augmentTitle="false" id="tableCardapio" paginateButton="true" paginationControls="true" title="Cardápios" width="200">
                                    <webuijsf:tableRowGroup emptyDataMsg="Não há cardapios cadastrados deste estabelecimento" id="tableRowGroup1" rows="5"
                                        sourceData="#{SessionBean1.cardapioProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn headerText="Cardapio" id="ColCardapio">
                                            <webuijsf:hyperlink actionExpression="#{portal$Produtos.hlkCardapio_action}" id="hlkCardapio" text="#{currentRow.value['nomeCardapio']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <h:panelGrid columns="1" id="panelProdutos" width="550">
                                <webuijsf:table augmentTitle="false" id="tablePratos" paginateButton="true" paginationControls="true"
                                    sortPanelToggleButton="true" title="Pratos" width="550">
                                    <webuijsf:tableRowGroup emptyDataMsg="Não há pratos cadastrados" id="tableRowGroup1" rows="10"
                                        sourceData="#{SessionBean1.pratoProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn headerText="Prato" id="ColPrato" sort="Prato" width="100">
                                            <h:panelGrid columns="1" id="panelPratoImg" style="align:center;">
                                                <webuijsf:imageHyperlink actionExpression="#{portal$Produtos.hlkPrato_action}" height="80" id="imgPrato"
                                                    imageURL="/ImagemPrato?id=#{currentRow.value['codigoPrato']}" width="120"/>
                                                <webuijsf:hyperlink actionExpression="#{portal$Produtos.hlkPrato_action}" id="hlkPrato" text="Detalhe"/>
                                            </h:panelGrid>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Descrição" id="ColDesc" width="430">
                                            <h:panelGrid columns="1" id="panelPratoDesc">
                                                <webuijsf:staticText id="sttNome" text="#{currentRow.value['nomePrato']}"/>
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['descricaoPrato']}"/>
                                            </h:panelGrid>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <webuijsf:messageGroup id="grpMsg"/>
                        </div>
                        <jsp:directive.include file="bottom.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
