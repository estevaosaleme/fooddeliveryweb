<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : manterFormasPagamento
    Created on : 21/03/2010, 15:03:19
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
                                    <div id="localizacao">» <a class="linkMapaSite" href="HomeAdm.jsp">Página Inicial</a> » <span> Manter FormaPagamento </span>
                                    </div>
                                    <h1 class="tituloPrincipal">Manter FormaPagamento</h1>
                                    <h:panelGrid columns="1" id="panelRegistros" width="552">
                                        <webuijsf:table augmentTitle="false" clearSortButton="true" id="tableFormaPagamento" paginateButton="true"
                                            paginationControls="true" sortPanelToggleButton="true" title="FormaPagamento" width="623">
                                            <webuijsf:tableRowGroup emptyDataMsg="Não há registros a serem exibidos." id="tableRowGroup1" rows="5"
                                                                    sourceData="#{SessionBean1.formasPagamentoProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Codigo FormaPagamento" id="tableColumn3" sort="codigoFormaPagamento">
                                                    <webuijsf:hyperlink actionExpression="#{adm$manterFormaPagamento.hlkFormaPagamento_action}" id="hlkFormaPagamento" text="#{currentRow.value['codigoFormaPagamento']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Tipo" id="tableColumn4" sort="numeroFormaPagamento" width="147">
                                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['nomeTipoPagamento']}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:messageGroup id="grpMsg"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="panelCampos">
                                        <webuijsf:label for="sttcodigoFormaPagamento" id="lblcodigoFormaPagamento" text="Código Forma Pagamento"/>
                                        <webuijsf:staticText id="sttcodigoFormaPagamento" text="#{RequestBean1.formaPagamento.codigoFormaPagamento}"/>
                                        <webuijsf:label for="txtTipoFormaPagamento" id="lblTipoFormaPagamento" text="Tipo"/>
                                        <webuijsf:textField columns="9" id="txtTipoFormaPagamento" maxLength="9" text="#{RequestBean1.formaPagamento.nomeTipoPagamento}"/>
                                    </h:panelGrid>
                                    <webuijsf:hiddenField id="hddcodigoFormaPagamento" text="#{RequestBean1.formaPagamento.codigoFormaPagamento}"/>
                                    <h:panelGrid columns="5" id="panelBotoes">
                                        <webuijsf:button actionExpression="#{adm$manterFormasPagamentoPagamento.btnLimpar_action}" id="btnLimpar" text="Limpar Campos"/>
                                        <webuijsf:button actionExpression="#{adm$manterFormasPagamentoPagamento.btnSalvarNovo_action}" id="btnSalvarNovo" text="Salvar Novo"/>
                                        <webuijsf:button actionExpression="#{adm$manterFormasPagamentoPagamento.btnAtualizar_action}" id="btnAtualizar" text="Atualizar"/>
                                        <webuijsf:button actionExpression="#{adm$manterFormasPagamentoPagamento.btnExcluir_action}" id="btnExcluir" text="Excluir"/>
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