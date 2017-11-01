<%-- 
    Document   : contacts
    Created on : Dec 1, 2016, 9:43:27 AM
    Author     : paulodondi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- PAGE TITLE -->
<div class="page-title">                    
    <h2><span class="fa fa-arrow-circle-o-left"></span> Contacts</h2>
</div>
<!-- END PAGE TITLE --> 
<div class="row" ng-controller="ContactsController">
    <div class="col-md-12">
        <!-- START DATATABLE EXPORT -->
        <div class="panel panel-default" ng-if="showGridView">
            <div class="panel-heading">
                <h3 class="panel-title">Contacts Listing</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-plus"></i> Add Contact</button>&nbsp;
                    <button ng-click="toggleView('uploadform')" class="btn btn-danger" ><i class="fa fa-plus"></i> Upload Contacts</button>&nbsp;
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
        <div class="panel panel-default" ng-if="showAddView">
            <div class="panel-heading">
                <h3 class="panel-title">Add Contact</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('uploadform')" class="btn btn-danger" ><i class="fa fa-plus"></i> Upload Contacts</button>
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="ContactForm" ng-submit="doAddContact(ContactForm, contact)" novalidate role="form" class="form-horizontal">
                       <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Name</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="contact.name" autofocus="" required="" class="form-control"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">MSISDN</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="contact.msisdn" class="form-control" required=""/>
                                <span class="help-block">254725655142</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Address Book: </label>
                            <div class="col-md-8">
                                <select class="form-control" ng-model="contact.addressBookId" ng-change="GetCategories()" required="" ng-options="o.id as o.name for o in AddressBooks">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Category: </label>
                            <div class="col-md-8">
                                <select class="form-control" ng-model="contact.categoryId" required="" ng-options="o.id as o.categoryName for o in Categories">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                         <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">SDP ServiceID </label>
                            <div class="col-md-8">
                                <select class="form-control" ng-model="contact.sdpServiceId" required="" ng-options="o.id as o.sdpServiceId for o in SDPServiceLisiting">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="contact.status" required="" ng-options="o.status as o.name for o in ActiveStatus">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="ContactForm.$invalid">Add Contact</button>
                        </div>  
                </form> 
            </div>
        </div>
        <div class="panel panel-default" ng-if="showEditView">
            <div class="panel-heading">
                <h3 class="panel-title">Edit Contact</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-primary" ><i class="fa fa-bars"></i> Add Contact</button>&nbsp;                   
                    <button ng-click="toggleView('uploadform')" class="btn btn-danger" ><i class="fa fa-bars"></i> Upload Contacts</button>&nbsp;                   
                    <button ng-click="toggleView('grid')" class="btn btn-primary" ><i class="fa fa-bars"></i> Show Grid</button>&nbsp;                   
                </div>                                    
            </div>
            <div class="panel-body">
                <flash-message duration="5000" show-close="true"> </flash-message>
                <form name="ContactEditForm" ng-submit="doEditContact(ContactEditForm, EditContact)" novalidate role="form" class="form-horizontal">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Name</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="EditContact.name" autofocus="" required="" class="form-control"/>
                                <span class="help-block">min size = 2, max size = 50</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">MSISDN</label>  
                            <div class="col-md-8">
                                <input type="text" ng-model="EditContact.msisdn" class="form-control" required=""/>
                                <span class="help-block">254725655142</span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Category: </label>
                            <div class="col-md-8">
                                <select class="form-control" ng-model="EditContact.categoryId" required="" ng-options="o.id as o.categoryName for o in CategoriesEdit">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                         <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">SDP ServiceID </label>
                            <div class="col-md-8">
                                <select ng-readonly="true" class="form-control" ng-model="EditContact.sdpServiceId" required="" ng-options="o.id as o.sdpServiceId for o in SDPServiceLisiting">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="EditContact.status" required="" ng-options="o.status as o.name for o in ActiveStatus  track by o.id">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" type="submit"  ng-disabled="ContactEditForm.$invalid">Edit Contact</button>
                        </div> 
                </form> 
            </div>
          
        </div>  
        <div class="panel panel-default" ng-if="showUploadView">
            <div class="panel-heading">
                <h3 class="panel-title">Upload Contacts</h3>
                <div class="btn-group pull-right">
                    <button ng-click="toggleView('addform')" class="btn btn-danger" ><i class="fa fa-bars"></i> Add Contact</button>&nbsp;                   
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
                           <strong>Prescription Upload Successful!</strong> We Shall notify you when your order is ready.
                   </div>
                   <div class="alert alert-danger"  ng-show="errorMsg" >
                           <strong>Error!</strong> {{errorMsg}}
                   </div>
                </div>
                <form name="ContactUploadForm"  novalidate role="form" class="form-horizontal">                                                                      
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Upload File</label>
                            <div class="col-md-8">
                                <input type="file"  ngf-select ng-model="picFile" name="file" accept="image/*" ngf-max-size="4MB" required ngf-model-invalid="errorFile" />                         
                                <span class="help-block">Required </span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">SDP ServiceID </label>
                            <div class="col-md-8">
                                <select  class="form-control" ng-model="UploadContact.sdpServiceId" required="" ng-options="o.id as o.sdpServiceId for o in SDPServiceLisiting">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Status: </label>
                            <div class="col-md-8">
                                 <select class="form-control" ng-model="UploadContact.status" required="" ng-options="o.status as o.name for o in ActiveStatus">
                                   
                                </select>                         
                                <span class="help-block">Required</span>
                            </div>                        
                        </div>
                        <div class="btn-group pull-right">
                            <button class="btn btn-primary" ng-click="uploadPic(picFile, UploadContact)"  >Upload Contacts</button>
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