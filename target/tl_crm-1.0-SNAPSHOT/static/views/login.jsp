<%-- 
    Document   : login
    Created on : Dec 15, 2016, 4:23:51 PM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="login-container" ng-controller="AuthController">
        
            <div class="login-box animated fadeInDown">
                <div class="login-logo">
                    <img src="${pageContext.request.contextPath}/static/img/prsp_logo.png" alt="" width="100%" height="auto"/>                     
                </div>
                <flash-message duration="5000" show-close="true"> </flash-message>
                <div class="login-body" style="margin-bottom: 20px;">
                    <div class="login-title"><strong>Welcome</strong>, Please login</div>
                    <form name="LoginForm" ng-submit="doLogin(LoginForm, user)" novalidate role="form" class="form-horizontal">
                    <!--<form name="LoginForm"  novalidate role="form" class="form-horizontal">-->
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" class="form-control" ng-model="user.username" required="" placeholder="Username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" class="form-control" ng-model="user.password" placeholder="Password"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" class="form-control" ng-model="user.organization" required="" placeholder="Organization"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-link btn-block">Forgot your password?</a>
                        </div>
                        <div class="col-md-6">
                            <button class="btn btn-info btn-block" type="submit"  ng-disabled="LoginForm.$invalid">Log In</button>
                           <!-- <button class="btn btn-info btn-block" ui-sref="app"  ng-disabled="LoginForm.$invalid">Log In</button>-->
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <div style="width: 100%; border-top: 5px solid #9367A5; float: left; padding: 30px; ">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <ul class="icon-list" style="list-style: none; font-size: 16px;">
                                <li style="margin-bottom: 5px"><span class="glyphicon glyphicon-copyright-mark"></span> TangazoLetu Ltd. 2016 </li>
                                <li><i class="fa fa-envelope"></i>  info@tangazoletu.com  </li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <ul class="icon-list" style="list-style: none; font-size: 16px;">
                                <li style="margin-bottom: 5px">1st Floor, Mayfair Business Center</li>
                                <li style="margin-bottom: 5px">Parklands Rd </li>
                                <li style="margin-bottom: 5px">Nairobi, Kenya.</li>
                                <li style="margin-bottom: 5px">P.O. BOX 62835 - 00200, GPO </li>
                                <li style="margin-bottom: 5px">Nairobi, Kenya.</li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <ul class="icon-list" style="list-style: none; font-size: 16px;">
                                <li style="margin-bottom: 5px">(+254) 704 420 000</li>
                                <li style="margin-bottom: 5px">(+254) 736 700 844</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
