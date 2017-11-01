<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Clients</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="ClientsController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Client Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-plus"></i> Add Client</button>&nbsp;
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
                            <td title="'Name'" filter="{ orgName: 'text'}" sortable="'orgName'">{{item.orgName}}</td>
                            <td title="'Contact Name'" filter="{ contactName: 'text'}" sortable="'contactName'">{{item.contactName}}</td>
                            <td title="'Contact Phone'" filter="{ contactPhone: 'text'}" sortable="'contactPhone'">{{item.contactPhone}}</td>
                            <td title="'Contact Address'" filter="{ contactAddress: 'text'}" sortable="'contactAddress'">{{item.contactAddress}}</td>
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
        <div class="panel panel-default" ng-if="showAddView">
            <div class="panel-heading">
                <h3 class="panel-title">Add Client</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="ClientForm" ng-submit="doAddOrganization(ClientForm, client)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Organization Name</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="client.orgName" autofocus="" required="" class="form-control" name="orgName" id="org_name"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Contact Name</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="client.contactName" class="form-control" name="contactName" id="contactName" required=""/>
                                <span class="help-block">min size = 2, max size = 45</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Contact Phone</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="client.contactPhone" class="form-control" name="contactPhone" id="contactPhone" required=""/>
                                <span class="help-block">25470000000</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Contact Address</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="client.contactAddress" class="form-control" name="contactAddress" id="contactAddress"/>
                                <span class="help-block">Enter Address</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="client.status" required="" ng-options="o.status as o.name for o in ActiveStatus">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="ClientForm.$invalid">Add Organization</button>
                        </div>  
                </form> 
            </div>
        </div>
        <div class="panel panel-default" ng-if="showEditView">
            <div class="panel-heading">
                <h3 class="panel-title">Edit Client</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-danger" ><i class="fa fa-bars"></i> Add Client</button>&nbsp;                   
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="ClientEditForm" ng-submit="doEditOrganization(ClientEditForm, EditClient)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Organization Name</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="EditClient.orgName" autofocus="" required="" class="form-control" name="orgName" id="org_name"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Contact Name</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="EditClient.contactName" class="form-control" name="contactName" id="contactName" required=""/>
                                <span class="help-block">min size = 2, max size = 45</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Contact Phone</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="EditClient.contactPhone" class="form-control" name="contactPhone" id="contactPhone" required=""/>
                                <span class="help-block">25470000000</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Contact Address</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="EditClient.contactAddress" class="form-control" name="contactAddress" id="contactAddress"/>
                                <span class="help-block">Enter Address</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                <select class="form-control" ng-model="EditClient.statusId" required="" ng-options="o.status as o.name for o in ActiveStatus track by o.id">
                                   
                                </select>                           
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="ClientEditForm.$invalid">Edit Organization</button>
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