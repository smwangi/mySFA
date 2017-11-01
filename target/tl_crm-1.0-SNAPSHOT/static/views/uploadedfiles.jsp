<%-- 
    Document   : uploadedfiles
    Created on : Dec 7, 2016, 10:34:26 AM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Uploaded Files</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="uploadedfilesController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Uploaded Files Listing</h3>
                <div class="btn-group pull-right">
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
                            <td title="'Organization'" filter="{ orgName: 'text'}" sortable="'orgName'">{{item.orgId.orgName}}</td>
                            <td title="'File Path'" filter="{ filePath: 'text'}" sortable="'filePath'">{{item.filePath}}</td>
                            <td title="'SDP Service'" filter="{ sdpServiceId: 'text'}" sortable="'sdpServiceId'">{{item.sdpServiceId.serviceName}}</td>
                            <td title="'Send Time'" filter="{ sendTime: 'text'}" sortable="'sendTime'">{{item.sendTime}}</td>
                            <td title="'Status'" filter="{ status: 'text'}" sortable="'status'">{{item.status}}</td>
                            <td title="'Uploaded By'" filter="{ uploadedBy: 'text'}" sortable="'uploadedBy'">{{item.uploadedBy}}</td>
                            <td title="'Date Uploaded'" filter="{ dateCreated: 'text'}" sortable="'dateCreated'">{{item.dateCreated}}</td>
                        </tr>
                    </tbody>
                </table>                                    
            </div>
        </div>
    </div>
</div>
