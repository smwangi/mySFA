<%-- 
    Document   : roles
    Created on : Dec 19, 2016, 9:17:20 AM
    Author     : paulodondi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Roles</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="RolesController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Roles Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-plus"></i> Add Role</button>&nbsp;
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
                <table id="customers2" ng-table="tableParams" class="table table-bordered" show-filter="true" >
                        <tr ng-repeat="item in $data"  id="{{ item.id }}">
                            <td title="'Name'" filter="{ name: 'text'}" sortable="'name'">{{item.roleName}}</td>
                            <td title="'Ations'" >
                                <button class="btn btn-default btn-rounded btn-sm col-md-6" ng-click="Edit(item)"><span class="fa fa-pencil"></span></button>
                                <button class="btn btn-danger btn-rounded btn-sm col-md-6" ng-click="Delete(item)"><span class="fa fa-times"></span></button>
                            </td>
                        </tr>
                </table>                                    

            </div>
        </div>
        <div class="panel panel-default" ng-if="showAddView">
            <div class="panel-heading">
                <h3 class="panel-title">Add Role</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form  name="RoleForm" ng-submit="doAdd(RoleForm, role)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Role Name</label>  
                            <div class="col-md-8">
                                <input ng-model="role.roleName" type="text" autofocus="" required="" class="form-control"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit" ng-disabled="RoleForm.$invalid">Add Role</button>
                        </div>  
                </form> 
            </div>
        </div>
        <div class="panel panel-default" ng-if="showEditView">
            <div class="panel-heading">
                <h3 class="panel-title">Edit Role</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-danger" ><i class="fa fa-bars"></i> Add Role</button>&nbsp;                   
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form  name="EditForm" ng-submit="doEdit(EditForm, EditRole)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Role Name</label>  
                            <div class="col-md-8">
                                <input ng-model="EditRole.roleName" type="text" autofocus="" required="" class="form-control" />
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit" ng-disabled="EditForm.$invalid">Edit Role</button>
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
                        <p>Are you sure you want to Delete the Address Book?</p>                    
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


