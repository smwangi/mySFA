<%-- 
    Document   : topups
    Created on : Dec 8, 2016, 11:48:05 AM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> SMS Topups</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="topupsController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">SMS Topups Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-plus"></i> Add SMS Topup</button>&nbsp;
                    <button class="btn btn-danger dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> Export Data</button>
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
                            <td title="'Client'" filter="{ orgName: 'text'}" sortable="'orgName'">{{item.orgId.orgName}}</td>
                            <td title="'Type'" filter="{ transactionTypeName: 'text'}" sortable="'transactionTypeName'">{{item.transactionTypeId.transactionTypeName}}</td>
                            <td title="'Units'" filter="{ amountOfUnits: 'text'}" sortable="'amountOfUnits'">{{item.amountOfUnits}}</td>
                            <td title="'Created By'" filter="{ createdBy: 'text'}" sortable="'createdBy'">{{item.createdBy}}</td>
                            <td title="'Approved By'" filter="{ approvedBy: 'text'}" sortable="'approvedBy'">{{item.approvedBy}}</td>
                            <td title="'Date Created'" filter="{ dateCreated: 'text'}" sortable="'dateCreated'">{{item.dateCreated}}</td>
                            <td title="'Date Updated'" filter="{ dateUpdated: 'text'}" sortable="'dateUpdated'">{{item.dateUpdated}}</td>
                            <td title="'Status'" ><span ng-if="item.status===0" class="label label-danger">NOT APPROVED </span><span class="label label-success" ng-if="item.status===1">APPROVED </span></td>
                            <td title="'Ations'" >
                                <button class="btn btn-default btn-rounded btn-sm" ng-click="Edit(item)"><span class="fa fa-pencil"></span></button>
                            </td>
                            
                        </tr>
                    </tbody>
                </table>                                    
            </div>
        </div>
        <div class="panel panel-default" ng-if="showAddView">
            <div class="panel-heading">
                <h3 class="panel-title">Add SMS Topup</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="TopupForm" ng-submit="doAddTopup(TopupForm, topup)" novalidate role="form" class="form-horizontal">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Organization Name</label>  
                            <div class="col-md-8">
                                <select class="form-control" ng-model="topup.orgId" required="" ng-options="o.id as o.orgName for o in Orgs">
                                   
                                </select> 
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Current SMS Balance</label>  
                            <div class="col-md-8">
                                <input type="text" ng-readonly="true" ng-model="Balance" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Cost / SMS</label>  
                            <div class="col-md-8">
                                <input type="text" ng-readonly="true" ng-model="CostSMS" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Amount Kshs</label>  
                            <div class="col-md-8">
                                <input type="number"  ng-model="AmountPaid" class="form-control" ng-change="CalculateUnits(AmountPaid)" />
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Amount of UNITS</label>  
                            <div class="col-md-8">
                                <input ng-readonly="true" type="text"  ng-model="topup.amountOfUnits"  class="form-control"/>
                                
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Transaction Type</label>  
                            <div class="col-md-8">
                                <select class="form-control" ng-model="topup.transactionTypeId" required="" ng-options="o.id as o.transactionTypeName for o in TransType">
                                   
                                </select>
                            </div>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="ClientForm.$invalid">Add SMS Topup</button>
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
                        <p>Are you sure you want to Disable the Organization?</p>                    
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