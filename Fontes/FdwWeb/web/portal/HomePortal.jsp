<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : HomePortal
    Created on : 15/05/2010, 19:06:50
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
                <webuijsf:body id="body1" style="-rave-layout: grid; width: 600px; height: 200px;">
                        <webuijsf:form id="form1">
                            <jsp:directive.include file="top.jspf"/>
                                <div id="content">
                                        <div class="float">
                                                <div class="left">
                                                        <img src="../resources/Portal/images/pic1.jpg" alt="" width="86" height="98" class="float" /><div style="position:absolute;top:1px;left:1px;height:0px;width:0px;overflow:hidden"><h1><a href="http://www.webdesign.org">web design</a></h1><h1><a href="http://www.freetemplatesonline.com/">free web templates</a></h1><h1><a href="http://www.websitetemplates.org/">website templates</a></h1></div>
                                                        <img src="../resources/Portal/images/welcome.gif" alt="" width="139" height="15" class="float" /><br /><br />
                                                        <p><strong>Bem vindo</strong><br />
                                                        Olá seja bem vindo a página principal do Food Delivery Web<a href="#"><img src="../resources/Portal/images/arrow.gif" alt="" width="8" height="7" /></a></p>
                                                </div>
                                                <div class="line"><img src="../resources/Portal/images/spacer.gif" alt="" height="1" width="239" /></div>
                                                <div class="left">
                                                        <img src="../resources/Portal/images/pic2.jpg" alt="" width="85" height="110" class="float" />
                                                        <img src="../resources/Portal/images/title1.gif" alt="" width="97" height="17" class="float" /><br /><br />
                                                        <p><strong>Últimas novidaddes</strong><br />
                                                    Veja aqui as últimas novidades </p>
                                                         <ul>
                                                                <li><a href="#">Estamos quase acabando !</a></li>
                                                                <li><a href="#">Notícia bombástica 2</a></li>
                                                                <li><a href="#">Alguem tem alguma notícia ?</a></li>
                                                                <li><a href="#">Nasceu o filho da Thaiz !</a></li>
                                                                <li><a href="#">Alguem arranja uma noticia de verdade ai...</a></li>
                                                         </ul>
                                                </div>
                                        </div>
                                        <div class="right">
                                                <img src="../resources/Portal/images/title2.gif" alt="" width="104" height="20" class="title" />
                                                    <h:panelGrid columns="2">
                                                        <h:panelGrid columns="1">
                                                            <webuijsf:imageHyperlink actionExpression="#{portal$HomePortal.imgPrato1_action}" height="80" imageURL="/ImagemPrato?id=#{SessionBean1.prato1.codigoPrato}" width="120" alt="#{SessionBean1.prato1.nomePrato}"/>
                                                            <br></br><br></br>
                                                        </h:panelGrid>
                                                        <h:panelGrid columns="1">
                                                            <webuijsf:staticText text="#{SessionBean1.prato1.nomePrato}" style="font-size: 14px; font-weight: bold"/>
                                                            <br></br>
                                                            <webuijsf:staticText text="#{SessionBean1.prato1.descricaoPrato}"/> <br />
                                                            <webuijsf:staticText text="Por R$  #{SessionBean1.prato1.valorUnitario}"/>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                <div class="line2"><img src="../resources/Portal/images/spacer.gif" alt="" height="1" width="239" /></div>
                                                <h:panelGrid columns="2">
                                                    <h:panelGrid columns="1">
                                                        <webuijsf:staticText text="#{SessionBean1.prato2.nomePrato}" style="font-size: 14px; font-weight: bold"/>
                                                        <br></br>
                                                        <webuijsf:staticText text="#{SessionBean1.prato2.descricaoPrato}"/> <br />
                                                        <webuijsf:staticText text="Por R$  #{SessionBean1.prato2.valorUnitario}"/>
                                                    </h:panelGrid>
                                                    <h:panelGrid columns="1">
                                                        <br></br><br></br>
                                                        <webuijsf:imageHyperlink actionExpression="#{portal$HomePortal.imgPrato2_action}" height="80" imageURL="/ImagemPrato?id=#{SessionBean1.prato2.codigoPrato}" width="120" alt="#{SessionBean1.prato2.nomePrato}"/>
                                                        <br></br><br></br>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                                                            </div>
                                        <img src="../resources/Portal/images/middle.jpg" alt="" width="620" height="4" class="pad" />
                                        <div class="bot">
                                                <img src="../resources/Portal/images/title3.gif" alt="" width="84" height="18" class="float" />
                                                <ul><li><a href="#">Outros pratos</a></li></ul>
                                          <div class="a">
                                              <webuijsf:imageHyperlink actionExpression="#{portal$HomePortal.imgPrato3_action}" height="65" imageURL="/ImagemPrato?id=#{SessionBean1.prato3.codigoPrato}" alt="#{SessionBean1.prato3.nomePrato}" width="127"/>
                                              <webuijsf:imageHyperlink actionExpression="#{portal$HomePortal.imgPrato4_action}" height="65" imageURL="/ImagemPrato?id=#{SessionBean1.prato4.codigoPrato}" alt="#{SessionBean1.prato4.nomePrato}" width="127"/>
                                              <webuijsf:imageHyperlink actionExpression="#{portal$HomePortal.imgPrato5_action}" height="65" imageURL="/ImagemPrato?id=#{SessionBean1.prato5.codigoPrato}" alt="#{SessionBean1.prato5.nomePrato}" width="127"/>
                                              <webuijsf:imageHyperlink actionExpression="#{portal$HomePortal.imgPrato6_action}" height="65" imageURL="/ImagemPrato?id=#{SessionBean1.prato6.codigoPrato}" alt="#{SessionBean1.prato6.nomePrato}" width="127"/>
                                          </div>
                                        </div>
                                </div>
                            <jsp:directive.include file="bottom.jspf"/>
                        </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
