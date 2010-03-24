<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterEstabelecimento
    Created on : 21/03/2010, 15:01:55
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
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter Eestabelecimento </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter Eestabelecimento</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tableEestabelecimento" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="Eestabelecimento" width="623">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                                    sourceData="#{SessionBean1.estabelecimentoProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Codigo Eestabelecimento" id="tableColumn3" sort="codigoEstabelecimento">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterEstabelecimento.hlkEstabelecimento_action}" id="hlkEstabelecimento" text="#{currentRow.value['codigoEstabelecimento']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Nome Fantasia" id="tableColumn4" sort="nomeFantasia" width="147">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['nomeFantasia']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Razão Social" id="tableColumn5" sort="nomeRazaoSocial" width="219">
                                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['nomeRazaoSocial']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="CNPJ" id="tableColumn6" sort="numeroCnpj">
                                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['numeroCnpj']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoEstabelecimento" id="lblcodigoEstabelecimento" text="Código Estabelecimento"/>
                                        <webuijsf:staticText id="sttcodigoEstabelecimento" text="#{RequestBean1.estabelecimento.codigoEstabelecimento}"/>
                                        <webuijsf:label for="txtnomeFantasia" id="lblnomeFantasia" text="Nome Fantasia"/>
                                        <webuijsf:textField columns="50" id="txtnomeFantasia" maxLength="50" text="#{RequestBean1.estabelecimento.nomeFantasia}"/>
                                        <webuijsf:label for="txtnomeRazaoSocial" id="lblnomeRazaoSocial" text="Razão Social"/>
                                        <webuijsf:textField columns="50" id="txtnomeRazaoSocial" maxLength="50" text="#{RequestBean1.estabelecimento.nomeRazaoSocial}"/>
                                        <webuijsf:label for="txtcnpj" id="lblcnpj" text="CNPJ"/>
                                        <webuijsf:textField columns="20" id="txtcnpj" maxLength="20" text="#{RequestBean1.estabelecimento.numeroCnpj}"/>
                                        <webuijsf:label for="txtnslogan" id="lblslogan" text="Slogan"/>
                                        <webuijsf:textField columns="100" id="txtslogan" maxLength="100" text="#{RequestBean1.estabelecimento.slogan}"/>
                                        <webuijsf:label for="txtendereco" id="lblendereco" text="Endereço"/>
                                        <webuijsf:textField columns="100" id="txtendereco" maxLength="100" text="#{RequestBean1.estabelecimento.endereco}"/>
                                        <webuijsf:label for="txtEmail" id="lblEmail" text="Email"/>
                                        <webuijsf:textField columns="50" id="txtEmail" maxLength="50" text="#{RequestBean1.estabelecimento.email}"/>
                                        <webuijsf:label for="txtnumeroTelefoneFixo" id="lblnumeroTelefoneFixo" text="Tel. Fixo"/>
                                        <webuijsf:textField columns="14" id="txtnumeroTelefoneFixo" maxLength="14" text="#{RequestBean1.estabelecimento.numeroTelefoneFixo}"/>
                                        <webuijsf:label for="txtnomeResponsavel" id="lblnomeResponsavel" text="Responsável"/>
                                        <webuijsf:textField columns="50" id="txtnomeResponsavel" maxLength="50" text="#{RequestBean1.estabelecimento.nomeResponsavel}"/>
                                        <webuijsf:label for="txtnumeroCelularResponsavel" id="lblnumeroCelularResponsavel" text="Celular Responsável"/>
                                        <webuijsf:textField columns="15" id="txtnumeroCelularResponsavel" maxLength="15" text="#{RequestBean1.estabelecimento.numeroCelularResponsavel}"/>
                                        <webuijsf:label for="txtstatus" id="lblstatus" text="Status"/>
                                        <webuijsf:textField columns="2" id="txtstatus" maxLength="1" text="#{RequestBean1.estabelecimento.status}"/>
                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoEstabelecimento" text="#{RequestBean1.estabelecimento.codigoEstabelecimento}"/>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterEstabelecimento.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterEstabelecimento.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterEstabelecimento.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterEstabelecimento.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
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