<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterCardapio
    Created on : 21/03/2010, 15:00:57
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
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter Cardápio </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter Cardápio</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tableCardapio" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="Cardápio" width="418">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                sourceData="#{SessionBean1.cardapioProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Código Cardápio" id="tableColumn1" sort="codigoCardapio">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterCardapio.hyperlink1_action}" id="hyperlink1" text="#{currentRow.value['codigoCardapio']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cardápio" id="tableColumn2" sort="nomeCardapio">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['nomeCardapio']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Estabelecimento" id="tableColumn3" sort="estabelecimento" width="84">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['estabelecimento'].codigoEstabelecimento}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoCardapio" id="lblcodigoCardapio" text="Código Cardápio"/>
                                        <webuijsf:staticText id="sttcodigoCardapio" text="#{RequestBean1.cardapio.codigoCardapio}"/>
                                        <webuijsf:label for="txtCardapio" id="lblCardapio" text="Cardápio"/>
                                        <webuijsf:textField columns="50" id="txtCardapio" text="#{RequestBean1.cardapio.nomeCardapio}"/>
                                        <webuijsf:label for="cmbEstabelecimentos" id="lblEstebelecimento" text="Estabelecimento"/>
                                        <webuijsf:dropDown id="cmbEstabelecimentos" items="#{SessionBean1.estabelecimentoOptionsList.options}"
                                            selected="#{SessionBean1.estabelecimentoOptionsList.selectedValue}"/>
                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoCardapio" text="#{RequestBean1.cardapio.codigoCardapio}"/>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterCardapio.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterCardapio.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterCardapio.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterCardapio.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
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
