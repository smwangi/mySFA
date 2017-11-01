<%-- 
    Document   : users
    Created on : Dec 19, 2016, 9:03:48 AM
    Author     : paulodondi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Users</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="UsersController as vm">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Users Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-plus"></i> Add User</button>&nbsp;
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
                            <td title="'Name'" filter="{ otherNames: 'text'}" sortable="'otherNames'">{{item.otherNames}}</td>
                            <td title="'Organization'" filter="{ orgName: 'text'}" sortable="'orgName'">{{item.orgId.orgName}}</td>
                            <td title="'Username'" filter="{ username: 'text'}" sortable="'username'">{{item.username}}</td>
                            <td title="'Email'" filter="{ email: 'text'}" sortable="'email'">{{item.email}}</td>
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
                <h3 class="panel-title">Add User</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="AddForm" ng-submit="doAdd(AddForm, userform)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Names</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="userform.otherNames" autofocus="" required="" class="form-control"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                    <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Organization: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="userform.orgId" required="" ng-options="o.id as o.orgName for o in Organizations">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Email</label>  
                            <div class="col-md-8">
                                <input type="email" ng-model="userform.email" class="form-control" required=""/>
                                <span class="help-block">email</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Username</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="userform.username" class="form-control" required=""/>
                                <span class="help-block">username</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Roles:</label>  
                            <div class="col-md-8">
                                <ui-select multiple ng-model="vm.selected" theme="bootstrap">
                                    <ui-select-match placeholder="Select Roles...">{{$item.roleName}}</ui-select-match>
                                    <ui-select-choices repeat="val in vm.values | filter: $select.search">
                                        <div style="font-weight: bolder;" ng-bind-html="val.roleName | highlight: $select.search"></div>
                                    </ui-select-choices>

                                </ui-select>
                            </div>
                            
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Password</label>  
                            <div class="col-md-8">
                                <input type="password" ng-model="userform.passwordHash" class="form-control" />
                                <span class="help-block">Password</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Confirm Password</label>  
                            <div class="col-md-8">
                                <input type="password" ng-model="userform.confirmpass" class="form-control" />
                                <span class="help-block">Confirm Password</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="userform.status" required="" ng-options="o.status as o.name for o in ActiveStatus">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="AddForm.$invalid">Add User</button>
                        </div>  
                </form> 
            </div>
        </div>
        <div class="panel panel-default" ng-if="showEditView">
            <div class="panel-heading">
                <h3 class="panel-title">Edit User</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-danger" ><i class="fa fa-bars"></i> Add Client</button>&nbsp;                   
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="EditForm" ng-submit="doEdit(EditForm, editUser)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Names</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="editUser.otherNames" autofocus="" required="" class="form-control"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                    <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Organization: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="editUser.orgId" required="" ng-options="o.id as o.orgName for o in Organizations">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Email</label>  
                            <div class="col-md-8">
                                <input type="email" ng-model="editUser.email" class="form-control" required=""/>
                                <span class="help-block">email</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Username</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="editUser.username" class="form-control" required=""/>
                                <span class="help-block">username</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Roles:</label>  
                            <div class="col-md-8">
                                <ui-select multiple ng-model="vm.selected" theme="bootstrap">
                                    <ui-select-match placeholder="Select Roles...">{{$item.roleName}}</ui-select-match>
                                    <ui-select-choices repeat="val in vm.values | filter: $select.search">
                                        <div style="font-weight: bolder;" ng-bind-html="val.roleName | highlight: $select.search"></div>
                                    </ui-select-choices>

                                </ui-select>
                            </div>
                            
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Password</label>  
                            <div class="col-md-8">
                                <input type="password" ng-model="editUser.passwordHash" class="form-control" />
                                <span class="help-block">Password</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Confirm Password</label>  
                            <div class="col-md-8">
                                <input type="password" ng-model="editUser.confirmpass" class="form-control" />
                                <span class="help-block">Confirm Password</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="editUser.status" required="" ng-options="o.status as o.name for o in ActiveStatus">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="EditForm.$invalid">Add User</button>
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