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
                            <h:panelGrid columns="1" id="panelProdutos" width="550">
                                <webuijsf:table augmentTitle="false" id="tablePratos" paginateButton="true" paginationControls="true"
                                    title="Pratos" width="550">
                                    <webuijsf:tableRowGroup emptyDataMsg="Carrinho vazio" id="tableRowGroup1" rows="10"
                                                            sourceData="#{SessionBean1.carrinhoCompras.produtosProvider}" sourceVar="currentRow">
                                        <webuijsf:tableColumn headerText="Prato" id="ColPrato" width="300">
                                            <h:panelGrid columns="1" id="panelPratoImg" style="align:center;">
                                                <webuijsf:imageHyperlink id="imgPrato" width="120" height="80" imageURL="/ImagemPrato?id=#{currentRow.value['codigoPrato']}" actionExpression="#{portal$Pedido.hlkPrato_action}"/>
                                                <webuijsf:hyperlink id="hlkPrato" text="#{currentRow.value['nomePrato']}" actionExpression="#{portal$Pedido.hlkPrato_action}"/>
                                            </h:panelGrid>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Quantidade" id="ColQuant" width="100">
                                            <h:panelGrid columns="1" id="pnAcoes">
                                                <h:panelGrid columns="3" id="panelPratoQuant">
                                                    <webuijsf:staticText id="txtQuantidade" text="#{currentRow.value['quantidade']}"/>
                                                    <webuijsf:button actionExpression="#{portal$Pedido.hlkAltQuantMais_action}" id="hlkAltQuantMais" text="+"/>
                                                    <webuijsf:button actionExpression="#{portal$Pedido.hlkAltQuantMenos_action}" id="hlkAltQuantMenos" text="-"/>
                                                </h:panelGrid>
                                                <webuijsf:hyperlink actionExpression="#{portal$Pedido.hlkRemover_action}" id="hlkRemover" text="Remover"/>
                                            </h:panelGrid>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </h:panelGrid>
                            <img src="../resources/Portal/images/middle.jpg" alt="" width="620" height="4" class="pad" />
                            <div class="bot">
                                <h:panelGrid columns="1">
                                    <h:panelGrid columns="2" id="panelFim" width="550">
                                        <h:panelGrid columns="2" id="panelCampos">
                                            <webuijsf:label for="panelTotalValor" id="lblTotal" text="Total:"/>
                                            <h:panelGrid columns="2" id="panelTotalValor">
                                                <webuijsf:label for="sttTotal" id="lblRS" text="R$ "/>
                                                <webuijsf:staticText id="sttTotal" text="#{SessionBean1.carrinhoCompras.total}"  style="font-size: 18px; font-weight: bold"  />
                                            </h:panelGrid>
                                            <webuijsf:label for="cmbFormaPagamento" id="lblFormaPagamento" text="Forma Pagamento"/>
                                            <webuijsf:dropDown id="cmbFormaPagamento" items="#{SessionBean1.carrinhoCompras.formaPagamentoOptionsList.options}"
                                                           selected="#{SessionBean1.carrinhoCompras.formaPagamentoOptionsList.selectedValue}"/>
                                        </h:panelGrid>
                                      <webuijsf:button actionExpression="#{portal$Pedido.btnFinaliza_action}" id="btnFinaliza" text="Finalizar Pedido"/>
                                    </h:panelGrid>
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
