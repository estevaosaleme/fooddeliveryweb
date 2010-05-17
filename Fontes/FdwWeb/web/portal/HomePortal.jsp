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
                                                        <p><strong>Lorem ipsum quaeque</strong><br />
                                                        eripuit probatus id usu, nec ea dos epicuri verterem, quando tempr et mei. Eam equidem erroribus an, id nam illum persecuti <a href="#"><img src="../resources/Portal/images/arrow.gif" alt="" width="8" height="7" /></a></p>
                                                </div>
                                                <div class="line"><img src="../resources/Portal/images/spacer.gif" alt="" height="1" width="239" /></div>
                                                <div class="left">
                                                        <img src="../resources/Portal/images/pic2.jpg" alt="" width="85" height="110" class="float" />
                                                        <img src="../resources/Portal/images/title1.gif" alt="" width="97" height="17" class="float" /><br /><br />
                                                        <p><strong>Probatus id usu, nec</strong><br />
                                                    ea dos epicuri verterem, quando </p>
                                                         <ul>
                                                                <li><a href="#">Eam equidem erroribus an,</a></li>
                                                                <li><a href="#">Id nam illum persecuti</a></li>
                                                                <li><a href="#">Suas facilis vim ne. Id per lorem</a></li>
                                                                <li><a href="#">Aperiam suavitate, nec legimus</a></li>
                                                                <li><a href="#">Debitis te. Has meis omittam</a></li>
                                                         </ul>
                                                </div>
                                        </div>
                                        <div class="right">
                                                <img src="../resources/Portal/images/title2.gif" alt="" width="104" height="20" class="title" />
                                                <div class="item">
                                                        <img src="../resources/Portal/images/pic3.jpg" alt="" width="125" height="86" />
                                                        <strong>Ipsum quaeque</strong> eripuit probatus id usu, nec ea dos epicuri erte rem, quando tempr et mei. <br />
                                                        <span>Only <strong>$6.99</strong></span>
                                                </div>
                                                <div class="line2"><img src="../resources/Portal/images/spacer.gif" alt="" height="1" width="239" /></div>
                                                <div class="item">
                                                        <img src="../resources/Portal/images/pic4.jpg" alt="" width="125" height="86" />
                                                        <strong>Eripuit probatus </strong> id usu, nec ea dos epi curi erterem, quando tempr et mei. Eam equ idem erroribus <br />
                                                        <span>Only <strong>$22.99</strong></span>
                                                </div>
                                        </div>
                                        <img src="../resources/Portal/images/middle.jpg" alt="" width="620" height="4" class="pad" />
                                        <div class="bot">
                                                <img src="../resources/Portal/images/title3.gif" alt="" width="84" height="18" class="float" />
                                                <ul><li><a href="#">all recipes</a></li></ul>
                                          <div class="a">
                                                  <img src="../resources/Portal/images/a1.jpg" alt="" width="127" height="65" border="0" usemap="#Map" />
                                                        <img src="../resources/Portal/images/a2.jpg" alt="" width="127" height="65" border="0" usemap="#Map2" />
                                                        <img src="../resources/Portal/images/a3.jpg" alt="" width="127" height="65" border="0" usemap="#Map3" />
                                                        <img src="../resources/Portal/images/a4.jpg" alt="" width="127" height="65" border="0" usemap="#Map4" />
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
