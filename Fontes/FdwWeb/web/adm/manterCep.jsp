<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterCep
    Created on : 18/03/2010, 22:11:17
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
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter CEP </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter CEP</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tableCEP" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="CEP" width="623">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                sourceData="#{SessionBean1.cepProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Codigo CEP" id="tableColumn3" sort="codigoCep">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterCep.hlkCep_action}" id="hlkCep" text="#{currentRow.value['codigoCep']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="CEP" id="tableColumn4" sort="numeroCep" width="147">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['numeroCep']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cidade" id="tableColumn5" sort="nomeCidade" width="219">
                                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['nomeCidade']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Estado" id="tableColumn6" sort="siglaEstado">
                                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['siglaEstado']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoCep" id="lblcodigoCep" text="Código Cep"/>
                                        <webuijsf:staticText id="sttcodigoCep" text="#{RequestBean1.cep.codigoCep}"/>
                                        <webuijsf:label for="txtNumeroCep" id="lblNumeroCep" text="CEP"/>
                                        <webuijsf:textField columns="9" id="txtNumeroCep" maxLength="9" text="#{RequestBean1.cep.numeroCep}"/>
                                        <webuijsf:label for="txtnomeLogradouro" id="lblnomeLogradouro" text="Logradouro"/>
                                        <webuijsf:textField columns="100" id="txtnomeLogradouro" maxLength="100" text="#{RequestBean1.cep.nomeLogradouro}"/>
                                        <webuijsf:label for="txtnomeBairro" id="lblnomeBairro" text="Bairro"/>
                                        <webuijsf:textField columns="50" id="txtnomeBairro" maxLength="50" text="#{RequestBean1.cep.nomeBairro}"/>
                                        <webuijsf:label for="txtnomeCidade" id="lblnomeCidade" text="Cidade"/>
                                        <webuijsf:textField columns="50" id="txtnomeCidade" maxLength="50" text="#{RequestBean1.cep.nomeCidade}"/>
                                        <webuijsf:label for="txtsiglaEstado" id="lblsiglaEstado" text="Estado"/>
                                        <webuijsf:textField columns="2" id="txtsiglaEstado" maxLength="2" text="#{RequestBean1.cep.siglaEstado}"/>
                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoCep" text="#{RequestBean1.cep.codigoCep}"/>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterCep.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterCep.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterCep.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterCep.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
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
