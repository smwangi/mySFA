<%-- 
    Document   : inbox
    Created on : Dec 6, 2016, 3:23:53 PM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Inbox Messages</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="InboxController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Inbox Messages Listing</h3>
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
                            <td title="'MSISDN'" filter="{ msisdn: 'text'}" sortable="'msisdn'">{{item.msisdn}}</td>
                            <td title="'Message'" filter="{ message: 'text'}" sortable="'message'">{{item.message}}</td>
                            <td title="'Date Sent'" filter="{ dateSent: 'text'}" sortable="'dateSent'">{{item.dateSent}}</td>
                            <td title="'Received Time'" filter="{ receivedTime: 'text'}" sortable="'receivedTime'">{{item.receivedTime}}</td>
                            <td title="'Date Created'" filter="{ dateCreated: 'text'}" sortable="'dateCreated'">{{item.dateCreated}}</td>
                            <td title="'Correlator'" filter="{ correlator: 'text'}" sortable="'correlator'">{{item.correlator}}</td>
                            
                        </tr>
                    </tbody>
                </table>                                    
            </div>
        </div>
    </div>
</div>