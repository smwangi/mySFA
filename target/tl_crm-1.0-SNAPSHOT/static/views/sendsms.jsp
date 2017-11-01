<%-- 
    Document   : sendsms
    Created on : Dec 7, 2016, 1:11:23 PM
    Author     : paulodondi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Send SMS</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="sendSMSController as vm">
    <div class="col-md-12"> 
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Send SMS</h3>
                <div class="btn-group pull-right">
                    <button ui-sref="app.bulksms" class="btn btn-danger" ><i class="fa fa-plus"></i> Send Bulk SMS file upload</button>
                </div>                                    
            </div>
            <div class="panel-body">
                
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="SendSMSForm" ng-submit="doAddSendSMS(SendSMSForm, sms)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-12">
                            <label class="col-md-3 control-label">To:</label>  
                            <div class="col-md-6">
                                <ui-select multiple ng-model="vm.selected" theme="bootstrap">
                                    <ui-select-match placeholder="Select Address book categories...">{{$item.categoryName}}</ui-select-match>
                                    <ui-select-choices repeat="val in vm.values | filter: $select.search">
                                        <div style="font-weight: bolder;" ng-bind-html="val.categoryName | highlight: $select.search"></div>
                                        <small>
                                            Address book: {{val.addressBookId.name}}
                                            
                                        </small>
                                    </ui-select-choices>

                                </ui-select>
                            </div>
                            <div class="col-md-3">
                                <button ui-sref="app.addressbook" class="btn btn-success"><i class="fa fa-plus"></i> Add address book</button>
                            </div>
                            
                        </div>
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-label">From(Shortcode): </label>
                            <div class="col-md-3">
                                <select class="form-control" ng-model="sms.shortCode" required="" ng-options="o.id as o.shortCode for o in ShortCodes">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-label">Message</label>
                            <div class="col-md-7">
                                <textarea class="form-control" ng-model="txtmessage" char-limit="160" maxlength="160" required="" rows="5"></textarea>
                                 <span class="help-block">{{160-txtmessage.length}} Characters left</span>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-label">Schedular : </label>
                            <div class="col-md-3">
                                <select class="form-control" ng-model="sms.schedular">
                                    <option value="1">Send Now</option>
                                    <option value="2">Send Later</option>
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>  
                         </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="SendSMSForm.$invalid">Send SMS</button>
                        </div>  
                </form> 
            </div>
        </div>
    </div>
</div>
