<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterPedido
    Created on : 21/03/2010, 15:02:57
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
                        <div class="container" id="pagina">
                            <jsp:directive.include file="top.jspf"/>
                            <div class="blocoPagina" id="principal">
                                <jsp:directive.include file="menu.jspf"/>
                                <div class="blocoPagina" id="conteudoPagina">
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter Pedido </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter Pedido</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tablePedido" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="Pedido" width="623">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                                    sourceData="#{SessionBean1.pedidoProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Código Pedido" id="tableColumn3" sort="codigoPedido">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterPedido.hlkPedido_action}" id="hlkPedido" text="#{currentRow.value['codigoPedido']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Data Hora Pedido" id="tableColumn4" sort="dataHoraPedido" width="147">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['dataHoraPedido']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cliente" id="tableColumn5" sort="cliente" width="219">
                                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['cliente']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Estabelecimento" id="tableColumn6" sort="estabelecimento">
                                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['estabelecimento']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoPedido" id="lblcodigoPedido" text="Código Pedido"/>
                                        <webuijsf:staticText id="sttcodigoPedido" text="#{RequestBean1.pedido.codigoPedido}"/>
                                        <webuijsf:staticText id="temporario" text="Não finalizado!!! falta fazer o core antes!!!!" />

                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoPedido" text="#{RequestBean1.pedido.codigoPedido}"/>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterPedido.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterPedido.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterPedido.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterPedido.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
                                    </h:panelGrid>
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