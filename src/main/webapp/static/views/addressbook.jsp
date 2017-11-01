<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Address Book</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="AddressBookController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Address Books Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-plus"></i> Add Address Book</button>&nbsp;
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
                            <td title="'Name'" filter="{ name: 'text'}" sortable="'name'">{{item.name}}</td>
                            <td title="'Organization'"  filter="{ orgName: 'text'}" sortable="'item.orgId.orgName'">{{item.orgId.orgName}}</td>
                            <td title="'Date Updated'" filter="{ dateUpdated: 'text'}" sortable="'dateUpdated'">{{item.dateUpdated}}</td>
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
                <h3 class="panel-title">Add Address Book</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form  name="AddressBookForm" ng-submit="doAddAddressBook(AddressBookForm, addressbook)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Address Book Name</label>  
                            <div class="col-md-8">
                                <input ng-model="addressbook.name" type="text" autofocus="" required="" class="form-control" name="org_name" id="org_name"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                                <input ng-model="addressbook.createdBy" type="hidden">
                                <input ng-model="addressbook.orgId" type="hidden">
                            </div>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit" ng-disabled="AddressBookForm.$invalid">Add Address Book</button>
                        </div>  
                </form> 
            </div>
        </div>
        <div class="panel panel-default" ng-if="showEditView">
            <div class="panel-heading">
                <h3 class="panel-title">Edit Address Book</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-danger" ><i class="fa fa-bars"></i> Add Address Book</button>&nbsp;                   
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form  name="AddressBookEditForm" ng-submit="doEditAddressBook(AddressBookEditForm, Editaddressbook)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Address Book Name</label>  
                            <div class="col-md-8">
                                <input ng-model="Editaddressbook.name" type="text" autofocus="" required="" class="form-control" name="org_name" id="org_name"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit" ng-disabled="AddressBookEditForm.$invalid">Edit Address Book</button>
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
