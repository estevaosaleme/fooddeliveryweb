<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterCliente
    Created on : 21/03/2010, 15:01:16
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
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter Cliente </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter Cliente</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tableCliente" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="Cliente" width="418">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                sourceData="#{SessionBean1.clienteProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Código Cliente" id="tableColumn1" sort="codigoCliente">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterCliente.hyperlink1_action}" id="hyperlink1" text="#{currentRow.value['codigoCliente']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cliente" id="tableColumn2" sort="nomeCliente">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['nomeCliente']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoCliente" id="lblcodigoCliente" text="Código Cliente"/>
                                        <webuijsf:staticText id="sttcodigoCliente" text="#{RequestBean1.cliente.codigoCliente}"/>
                                        <webuijsf:label for="txtCliente" id="lblCliente" text="Cliente"/>
                                        <webuijsf:textField columns="100" id="txtCliente" maxLength="100" text="#{RequestBean1.cliente.nomeCliente}"/>
                                        <webuijsf:label for="txtCPF" id="lblCPF" text="CPF"/>
                                        <webuijsf:textField columns="14" id="txtCPF" maxLength="14" text="#{RequestBean1.cliente.numeroCpf}"/>
                                        <webuijsf:label for="txtSexo" id="lblSexo" text="Sexo"/>
                                        <webuijsf:dropDown id="cmbSexo" items="#{SessionBean1.sexoOptionsList.options}" required="true"
                                            selected="#{SessionBean1.sexoOptionsList.selectedValue}" valueChangeListenerExpression="#{adm$manterCliente.cmbSexo_processValueChange}"/>
                                        <webuijsf:label for="txtCep" id="lblCep" text="CEP"/>
                                        <webuijsf:textField columns="9" id="txtCep" maxLength="9"
                                            onChange="webui.suntheme4_2.common.timeoutSubmitForm(this.form, 'panelCampos:txtCep');"
                                            text="#{RequestBean1.cepTemporario}" valueChangeListenerExpression="#{adm$manterCliente.txtCep_processValueChange}"/>
                                        <webuijsf:label for="txtDataNascimento" id="lblDataNasximento" text="Data Nascimento"/>
                                        <webuijsf:calendar id="txtDataNascimento"
                                            onChange="webui.suntheme4_2.common.timeoutSubmitForm(this.form, 'panelCampos:txtDataNascimento');" selectedDate="#{RequestBean1.cliente.dataNascimento}"/>
                                        <webuijsf:label for="txtCelular" id="lblCelular" text="Celular"/>
                                        <webuijsf:textField columns="15" id="txtCelular" maxLength="15" text="#{RequestBean1.cliente.numeroCelular}"/>
                                        <webuijsf:label for="txtTelFixo" id="lblTelFixo" text="Tel. Fixo"/>
                                        <webuijsf:textField columns="14" id="txtTelFixo" maxLength="14" text="#{RequestBean1.cliente.numeroTelefoneFixo}"/>
                                        <webuijsf:label for="txtEmail" id="lblEmail" text="Email"/>
                                        <webuijsf:textField columns="100" id="txtEmail" maxLength="100" text="#{RequestBean1.cliente.email}"/>
                                        <webuijsf:label for="txtEndereco" id="lblEndereco" text="Endereço"/>
                                        <webuijsf:textField columns="100" id="txtEndereco" maxLength="100" text="#{RequestBean1.cliente.endereco}"/>
                                        <webuijsf:label for="txtPontoReferencia" id="lblPontoReferencia" text="Ponto Ref."/>
                                        <webuijsf:textField columns="100" id="txtPontoReferencia" maxLength="100" text="#{RequestBean1.cliente.pontoReferencia}"/>
                                        <webuijsf:label for="txtStatus" id="lblStatus" text="Status"/>
                                        <webuijsf:textField columns="2" id="txtStatus" maxLength="1" text="#{RequestBean1.cliente.status}"/>
                                        <webuijsf:label for="txtSenha" id="lblSenha" text="Senha"/>
                                        <webuijsf:textField columns="100" id="txtSenha" maxLength="255" text="#{RequestBean1.cliente.senha}"/>
                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoCliente" text="#{RequestBean1.cliente.codigoCliente}"/>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterCliente.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterCliente.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterCliente.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterCliente.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
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
