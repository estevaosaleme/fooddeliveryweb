<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Cadastro
    Created on : 16/05/2010, 11:09:01
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
                                                   Já Tenho Cadastro
                                                    <h:panelGrid columns="2" id="panelLogin">
                                                        <webuijsf:label for="txtCPF" id="lblCPF" text="CPF"/>
                                                        <webuijsf:textField id="txtCPF" text="#{RequestBean1.cpfLogin}"/>
                                                        <webuijsf:label for="txtSenha" id="lblSenha" text="Senha"/>
                                                        <webuijsf:passwordField  password="#{RequestBean1.senhaLogin}" columns="8" id="txtSenha" maxLength="8" />
                                                    </h:panelGrid>
                                                    <webuijsf:button actionExpression="#{portal$Cadastro.btnLogin_action}" id="btnLogin" text="Login"/>
                                                </div>
                                        </div>
                                        <div class="right">
                                               Não Tenho Cadastro
                                               <h:panelGrid columns="2" id="panelCadastro">
                                                        <webuijsf:label for="txtCPFlCad" id="lblCPFCad" text="CPF"/>
                                                        <webuijsf:textField id="txtCPFCad" text="#{RequestBean1.cliente.numeroCpf}"/>
                                                        <webuijsf:label for="txtCliente" id="lblCliente" text="Nome"/>
                                                        <webuijsf:textField columns="35" id="txtCliente" maxLength="100" text="#{RequestBean1.cliente.nomeCliente}"/>
                                                        <webuijsf:label for="txtSexo" id="lblSexo" text="Sexo"/>
                                                        <webuijsf:dropDown id="cmbSexo" items="#{SessionBean1.sexoOptionsList.options}" required="true"
                                                            selected="#{SessionBean1.sexoOptionsList.selectedValue}"/>
                                                        <webuijsf:label for="txtCep" id="lblCep" text="CEP"/>
                                                        <webuijsf:textField columns="9" id="txtCep" maxLength="9" text="#{RequestBean1.cepTemporario}"/>
                                                        <webuijsf:label for="txtDataNascimento" id="lblDataNasximento" text="Data Nascimento"/>
                                                        <webuijsf:calendar id="txtDataNascimento"
                                                            onChange="webui.suntheme4_2.common.timeoutSubmitForm(this.form, 'panelCampos:txtDataNascimento');" selectedDate="#{RequestBean1.cliente.dataNascimento}"/>
                                                        <webuijsf:label for="txtCelular" id="lblCelular" text="Celular"/>
                                                        <webuijsf:textField columns="15" id="txtCelular" maxLength="15" text="#{RequestBean1.cliente.numeroCelular}"/>
                                                        <webuijsf:label for="txtTelFixo" id="lblTelFixo" text="Tel. Fixo"/>
                                                        <webuijsf:textField columns="14" id="txtTelFixo" maxLength="14" text="#{RequestBean1.cliente.numeroTelefoneFixo}"/>
                                                        <webuijsf:label for="txtEmail" id="lblEmail" text="Email"/>
                                                        <webuijsf:textField columns="35" id="txtEmail" maxLength="100" text="#{RequestBean1.cliente.email}"/>
                                                        <webuijsf:label for="txtEndereco" id="lblEndereco" text="Endereço"/>
                                                        <webuijsf:textField columns="35" id="txtEndereco" maxLength="100" text="#{RequestBean1.cliente.endereco}"/>
                                                        <webuijsf:label for="txtPontoReferencia" id="lblPontoReferencia" text="Ponto Ref."/>
                                                        <webuijsf:textField columns="35" id="txtPontoReferencia" maxLength="100" text="#{RequestBean1.cliente.pontoReferencia}"/>

                                                        <webuijsf:label for="txtSenhaCad" id="lblSenhaCad" text="Senha"/>
                                                        <webuijsf:passwordField  password="#{RequestBean1.cliente.senha}" columns="8" id="txtSenhaCad" maxLength="8" />
                                                        <webuijsf:label for="txtRSenhaCad" id="lblConfSenhaCad" text="Repita a senha"/>
                                                        <webuijsf:passwordField  password="#{RequestBean1.senhaConfirma}" columns="8" id="txtRSenhaCad" maxLength="8" />
                                                    </h:panelGrid>
                                                    <webuijsf:button actionExpression="#{portal$Cadastro.btnCadastro_action}" id="btnCadastro" text="Cadastro"/>
                                        </div>
                                        <img src="../resources/Portal/images/middle.jpg" alt="" width="620" height="4" class="pad" />
                                        <div class="bot">
                                                 <webuijsf:messageGroup id="grpMsg"/>
                                        </div>
                                </div>
                            <jsp:directive.include file="bottom.jspf"/>
                        </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
