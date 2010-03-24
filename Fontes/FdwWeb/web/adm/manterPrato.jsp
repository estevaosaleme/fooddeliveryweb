<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterPrato
    Created on : 21/03/2010, 15:02:16
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
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter Prato </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter Prato</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tablePrato" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="Prato" width="623">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                sourceData="#{SessionBean1.pratoProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Código Prato" id="tableColumn3" sort="codigoPrato">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterPrato.hlkPrato_action}" id="hlkPrato" text="#{currentRow.value['codigoPrato']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Nome Prato" id="tableColumn4" sort="nomePrato" width="147">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['nomePrato']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Descrição Prato" id="tableColumn5" sort="descricaoPrato" width="219">
                                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['descricaoPrato']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cardápio" id="tableColumn6" sort="cardapio">
                                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['cardapio'].codigoCardapio}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoPrato" id="lblcodigoPrato" text="Código Prato"/>
                                        <webuijsf:staticText id="sttcodigoPrato" text="#{RequestBean1.prato.codigoPrato}"/>
                                        <webuijsf:label for="txtnomePrato" id="lblnomePrato" text="Prato"/>
                                        <webuijsf:textField columns="50" id="txtnomePrato" maxLength="50" text="#{RequestBean1.prato.nomePrato}"/>
                                        <webuijsf:label for="txtdescricaoPrato" id="lbldescricaoPrato" text="Descrição"/>
                                        <webuijsf:textArea columns="50" id="txtdescricaoPrato" maxLength="100" rows="2" text="#{RequestBean1.prato.descricaoPrato}"/>
                                        <webuijsf:label for="txttamanho" id="lbltamanho" text="Tamanho"/>
                                        <webuijsf:textField columns="20" id="txttamanho" maxLength="20" text="#{RequestBean1.prato.tamanho}"/>
                                        <webuijsf:label for="txtvalorUnitario" id="lblvalorUnitario" text="Valor Unitário"/>
                                        <webuijsf:textField columns="10" id="txtvalorUnitario" maxLength="10" text="#{RequestBean1.prato.valorUnitario}"/>
                                        <webuijsf:label for="txtcardapio" id="lblcardapio" text="Cardápio"/>
                                        <webuijsf:textField columns="10" id="txtcardapio" maxLength="10"
                                            onChange="webui.suntheme4_2.common.timeoutSubmitForm(this.form, 'panelCampos:txtcardapio');"
                                            text="#{RequestBean1.cardapioTemporario}" valueChangeListenerExpression="#{adm$manterPrato.txtcardapio_processValueChange}"/>
                                        <webuijsf:label for="txtfoto" id="lblfoto" text="Foto"/>
                                        <webuijsf:image alt="#{RequestBean1.prato.nomePrato}" height="150" id="imgFoto" url="/ImagemTempSession" width="210"/>
                                        <webuijsf:label for="uplFoto" id="lbluplfoto" text="Upload"/>
                                        <webuijsf:upload columns="50" id="uplFoto"
                                            onChange="webui.suntheme4_2.common.timeoutSubmitForm(this.form, 'panelCampos:uplFoto');" valueChangeListenerExpression="#{adm$manterPrato.uplFoto_processValueChange}"/>
                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoPrato" text="#{RequestBean1.prato.codigoPrato}"/>
                                    <h:inputHidden value="#{RequestBean1.prato.foto}">  
                                        <f:converter converterId="objectConverter" />  
                                    </h:inputHidden>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterPrato.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterPrato.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterPrato.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterPrato.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
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
