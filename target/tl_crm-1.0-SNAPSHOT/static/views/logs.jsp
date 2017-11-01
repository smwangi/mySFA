<%-- 
    Document   : logs
    Created on : Dec 7, 2016, 10:22:50 AM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Transactions Logs</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="logsController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Transactions Logs Listing</h3>
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
                            <td title="'SMS Count'" filter="{ smsSentCount: 'text'}" sortable="'smsSentCount'">{{item.smsSentCount}}</td>
                            <td title="'Balance'" filter="{ balance: 'text'}" sortable="'balance'">{{item.balance}}</td>
                            <td title="'Debit'" filter="{ debit: 'text'}" sortable="'debit'">{{item.debit}}</td>
                            <td title="'Credit'" filter="{ credit: 'text'}" sortable="'credit'">{{item.credit}}</td>
                            <td title="'Holding AC'" filter="{ holdingAccount: 'text'}" sortable="'holdingAccount'">{{item.holdingAccount}}</td>
                            <td title="'Date Created'" filter="{ dateCreated: 'text'}" sortable="'dateCreated'">{{item.dateCreated}}</td>
                        </tr>
                    </tbody>
                </table>                                    
            </div>
        </div>
    </div>
</div>
