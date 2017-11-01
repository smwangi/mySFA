<%-- 
    Document   : bulksms
    Created on : Dec 7, 2016, 1:13:22 PM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Bulk SMS</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="bulksmsController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Uploaded Bulk SMS Files Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('uploadform')" class="btn btn-danger" ><i class="fa fa-plus"></i> Send Bulk SMS</button>&nbsp;
                    <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> Export Data</button>
                    <ul class="dropdown-menu">
                        <li><a href="#" onClick ="$('#customers2').tableExport({type:'excel',escape:'false'});"><img src='/prsp/static/img/icons/xls.png' width="24"/> XLS</a></li>
                        <li><a href="#" onClick ="$('#customers2').tableExport({type:'doc',escape:'false'});"><img src='/prsp/static/img/icons/word.png' width="24"/> Word</a></li>
                        <li><a href="#" onClick ="$('#customers2').tableExport({type:'png',escape:'false'});"><img src='/prsp/static/img/icons/png.png' width="24"/> PNG</a></li>
                        <li><a href="#" onClick ="$('#customers2').tableExport({type:'pdf',escape:'false'});"><img src='/prsp/static/img/icons/pdf.png' width="24"/> PDF</a></li>
                    </ul>
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <table id="customers2" ng-table="tableParams" class="table table-bordered" show-filter="true">
                    <tbody>
                        <tr ng-repeat="item in $data" id="{{ item.id }}">
                            <td title="'MSISDN'" filter="{ msisdn: 'text'}" sortable="'msisdn'">{{item.msisdn}}</td>
                            <td title="'Name'" filter="{ name: 'text'}" sortable="'name'">{{item.name}}</td>
                            <td title="'Category'" filter="{ categoryName: 'text'}" sortable="'categoryName'">{{item.categoryId.categoryName}}</td>
                            <td title="'SDP Service'" filter="{ serviceName: 'text'}" sortable="'serviceName'">{{item.sdpServiceId.serviceName}}</td>
                            <td title="'Date Created'" filter="{ dateCreated: 'text'}" sortable="'dateCreated'">{{item.dateCreated}}</td>
                            <td title="'Status'" ><span ng-if="item.status===0" class="label label-danger">INACTIVE </span><span class="label label-success" ng-if="item.status===1">ACTIVE </span></td>
                            <td title="'Ations'" >
                                <button class="btn btn-default btn-rounded btn-sm col-md-6" ng-click="Edit(item)"><span class="fa fa-pencil"></span></button>
                                <button class="btn btn-danger btn-rounded btn-sm col-md-6" ng-click="Delete(item)"><span class="fa fa-times"></span></button>
                            </td>
                            
                        </tr>
                    </tbody>
                </table>                                    
            </div>
        </div>
        <div class="panel panel-default" ng-if="showUploadView">
            <div class="panel-heading">
                <h3 class="panel-title">Upload Contacts</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <div class="row">
                    <div class="progress" ng-show="picFile.progress >= 0">
                           <div class="progress-bar" role="progressbar" 
                           aria-valuemin="0" aria-valuemax="100" style="width:{{picFile.progress}}%">
                                 {{picFile.progress}}%
                           </div>
                         </div>
                   <div ng-show="picFile.result" class="alert alert-success">
                           <strong>Bulk SMS File Upload Successful!</strong> We Shall notify you when your order is ready.
                   </div>
                   <div class="alert alert-danger"  ng-show="errorMsg" >
                           <strong>Error!</strong> {{errorMsg}}
                   </div>
                </div>
                <form name="ContactUploadForm"  novalidate role="form" class="form-horizontal">                                                                      
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Upload File</label>
                            <div class="col-md-8">
                                <input type="file"  ngf-select ng-model="picFile" name="file" accept=".xlsx" ngf-max-size="5MB" required ngf-model-invalid="errorFile" />                         
                                <span class="help-block">Required </span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Short Code</label>
                            <div class="col-md-8">
                                <select  class="form-control" ng-model="sendbulksms.shortCodeId" required="" ng-options="o.id as o.shortCode for o in ShortCodes">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">SDP ServiceID </label>
                            <div class="col-md-8">
                                <select  class="form-control" ng-model="sendbulksms.sdpServiceId" required="" ng-options="o.sdpServiceId as o.sdpServiceId for o in sdpservice">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <input type="hidden" ng-model="sendbulksms.orgId"  />
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" ng-disabled="!ContactUploadForm.$valid" ng-click="uploadPic(picFile, sendbulksms)"  >Upload File</button>
                        </div> 
                </form> 
            </div>
          
        </div>  
          <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-remove-row">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-times"></span> Remove <strong>Data</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to Disable the Contact?</p>                    
                        <p>Press Yes if you are sure.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <button class="btn btn-success btn-lg mb-control-yes" ng-click="Disable(ItemRemove)">Yes</button>
                            <button class="btn btn-default btn-lg mb-control-close" ng-click="Close()">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
