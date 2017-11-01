'use strict';
angular.module('tl_crm')
        .controller('sidebarController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {

        })
        .controller('LogoutController', function (AuthSharedService, authService,Session ,$scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            $scope.LogOutUser = function() {
                AuthSharedService.logout();
                var box = document.getElementById('mb-signout');
                box.classList.remove("open");
                $state.go("app.login");
            };
        })
        .controller('AuthController', function (authService,Session , $scope, $httpParamSerializer, $http, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            document.getElementsByClassName('page-container')[0].style.display = 'none';
            $scope.doLogin = function (LoginForm, user) {
                if (LoginForm.$valid) {              
                    var data = $.param({
                        username: user.username,
                        password: user.password
                    });  
                    var config = {
                        ignoreAuthModule: 'ignoreAuthModule',
                        headers : {
                            'Content-Type': 'application/x-www-form-urlencoded;'
                        }
                    }
                    $http.post(''+_contextpath+'/authenticate', data, config)
                        .success(function (data, status, headers, config) {
                            authService.loginConfirmed(data);
                            $state.go("app");
                        }).error(function (data, status, headers, config) {
                            $rootScope.authenticationError = true;
                            Session.invalidate();
                            var message = '<strong>Error !</strong> Wrong Username, Password or Organization';
                            Flash.create('danger', message, 4000, {}, true);
                        });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
        })
        .controller('HomeController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            document.getElementsByClassName('page-container')[0].style.display = '';

        })
        .controller('HeaderController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {


        })
        .controller('ClientsController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //Add Organizations
            $scope.doAddOrganization = function (ClientForm, client) {
                if (ClientForm.$valid) {
                    Data.post('organization/createOrg', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + client.orgName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Get Active States
            User.GetActiveStatus();
            $scope.ActiveStatus = User.ActiveStatus;
            //Edit Organization click
            $scope.EditClient = {statusId: 0};
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.EditClient = item;
                $scope.EditClient.statusId = item.status;
                //console.log(item);
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditOrganization = function (ClientEditForm, EditClient) {
                if (ClientEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: EditClient.id, orgName: EditClient.orgName, status: EditClient.statusId, contactName: EditClient.contactName, contactPhone: EditClient.contactPhone, contactAddress: EditClient.contactAddress};
                    Data.put('organization/updateOrg/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + EditClient.orgName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //List clients
            $scope.Orgs = {};
            Data.get('organization/listOrgs').then(function (data) {
                $scope.Orgs = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.Orgs});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var client = {id: item.id, orgName: item.orgName, status: item.status, contactName: item.contactName, contactPhone: item.contactPhone, contactAddress: item.contactAddress};
                Data.put('organization/deleteOrg/', client).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully removed the organization.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };

        })
        .controller('AddressBookController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.addressbook = {};
            $scope.addressbook.orgId = 1;
            $scope.addressbook.createdBy = 1;
            //Add AddressBook
            $scope.doAddAddressBook = function (AddressBookForm, addressbook) {
                if (AddressBookForm.$valid) {
                    Data.post('addressbook/createaddbook', addressbook).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + addressbook.name + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);
                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.Editaddressbook = item;
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditAddressBook = function (AddressBookEditForm, Editaddressbook) {
                if (AddressBookEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: Editaddressbook.id, name: Editaddressbook.name, createdBy: Editaddressbook.createdBy, orgId: Editaddressbook.orgId.id};
                    Data.put('addressbook/updateaddbook/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + Editaddressbook.name + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.Addressbook = {};
            Data.get('addressbook/listaddbook/' + $scope.addressbook.orgId).then(function (data) {
                $scope.Addressbook = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.Addressbook});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var client = {id: item.id, orgName: item.orgName, status: item.status, contactName: item.contactName, contactPhone: item.contactPhone, contactAddress: item.contactAddress};
                Data.put('addressbook/deleteaddbook/', client).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully Disabled the organization.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };

        })
        .controller('AddressBookCategoriesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.category = {};
            $scope.category.orgId = 1;
            $scope.category.createdBy = 1;
            //Get Address books
            Data.get('addressbook/listaddbook/' + $scope.category.orgId).then(function (data) {
                $scope.AddressBooks = data;
            });
            //Add AddressBook
            $scope.doAddCategory = function (AddressCategoryForm, category) {
                if (AddressCategoryForm.$valid) {
                    Data.post('categories/createcategory', category).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + category.CategoryName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.editcategory = {BookId: 0};
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.editcategory = item;
                $scope.editcategory.BookId = item.addressBookId.id;
                // console.log(item);
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditCategory = function (AddressCategoryEditForm, editcategory) {
                if (AddressCategoryEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: editcategory.id, categoryName: editcategory.categoryName, addressBookId: editcategory.BookId, createdBy: editcategory.createdBy, orgId: editcategory.addressBookId.orgId.id};
                    Data.put('categories/updateCategory/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + editcategory.categoryName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.CategoriesLisiting = {};
            Data.get('categories/listallcategories/' + $scope.category.orgId).then(function (data) {
                //Data.get('categories/listallcategories').then(function(data) {       
                $scope.CategoriesLisiting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.CategoriesLisiting});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var category = {id: item.id, CategoryName: item.CategoryName, addressBookId: item.addressBookId.id, orgId: item.addressBookId.orgId.id};
                Data.put('categories/deleteCategory/', category).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully Disabled the Category.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };


        })
        .controller('ContactsController', function ($scope, $window, User, $state, $rootScope, Data, Flash, NgTableParams, $timeout, Upload) {

            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.showUploadView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                    $scope.showUploadView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;
                    $scope.showUploadView = false;

                } else if (view === 'uploadform') {
                    $scope.showGridView = false;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                    $scope.showUploadView = true;
                }

            };
            $scope.contact = {};
            $scope.contact.orgId = 1;
            $scope.contact.createdBy = 1;
            // $scope.contact.sdpServiceId=1;
            //$scope.addressBookId='';
            //Get Address books
            Data.get('addressbook/listaddbook/' + $scope.contact.orgId).then(function (data) {
                $scope.AddressBooks = data;
            });
            //Address book on change
            $scope.GetCategories = function () {
                //console.log($scope.contact.addressBookId);
                Data.get('categories/listcategoryByAddressbookId/' + $scope.contact.addressBookId + '').then(function (data) {
                    $scope.Categories = data;
                });
            };

            Data.get('categories/listallcategories/' + $scope.contact.orgId + '').then(function (data) {
                $scope.CategoriesEdit = data;
            });

            //get sdp services
            Data.get('sdpservice/listsdpservice').then(function (data) {
                $scope.SDPServiceLisiting = data;
            });
            //Add Organizations
            $scope.doAddContact = function (ContactForm, contact) {
                if (ContactForm.$valid) {
                    Data.post('contacts/createContact', contact).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + contact.msisdn + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Get Active States
            User.GetActiveStatus();
            $scope.ActiveStatus = User.ActiveStatus;
            //Edit Organization click
            $scope.EditContact = {status: 0, categoryId: '', sdpServiceId: ''};
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.EditContact = item;
                $scope.EditContact.status = item.status;
                $scope.EditContact.categoryId = item.categoryId.id;
                $scope.EditContact.sdpServiceId = item.sdpServiceId.id;
                //console.log(item);
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditContact = function (ContactEditForm, EditContact) {
                if (ContactEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: EditContact.id, orgId: EditContact.orgId.id, createdBy: EditContact.createdBy, sdpServiceId: EditContact.sdpServiceId, status: EditContact.status, categoryId: EditContact.categoryId, msisdn: EditContact.msisdn, name: EditContact.name};
                    Data.put('contacts/updatecontact/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + EditContact.msisdn + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //List clients
            $scope.ContactsListing = {};
            Data.get('contacts/listcontactsorganization/' + $scope.contact.orgId).then(function (data) {
                $scope.ContactsListing = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.ContactsListing});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var client = {id: item.id, orgId: item.orgId.id, createdBy: item.createdBy, sdpServiceId: item.sdpServiceId.id, status: item.status, categoryId: item.categoryId.id, msisdn: item.msisdn, name: item.name};
                Data.put('contacts/deletecontact/', client).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully Disabled the organization.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };
            $scope.UploadContact = {};
            $scope.uploadPic = function (file, UploadContact)
            {
                file.upload = Upload.upload({
                    url: 'http://192.168.0.190:8082/prsp/contacts/uploadContactFile',
                    fields: {status: UploadContact.status, sdpServiceId: UploadContact.sdpServiceId},
                    file: file
                });
                file.upload.then(function (response) {
                    $timeout(function () {
                        file.result = response.data;
                    });
                    $scope.myVar = !$scope.myVar;
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                    // Math.min is to fix IE which reports 200% sometimes
                    file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
                });
            };

        })
        .controller('ShortcodesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.shortcode = {};
            //Add AddressBook
            $scope.doAddShortCode = function (AddShortCodeForm, shortcode) {
                if (AddShortCodeForm.$valid) {
                    Data.post('shortcodes/createshortcode', shortcode).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + shortcode.shortCode + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.Editshortcode = item;
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditShortCode = function (ShortCodeEditForm, Editshortcode) {
                if (ShortCodeEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: Editshortcode.id, shortCode: Editshortcode.shortCode};
                    Data.put('shortcodes/updateshortcode/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + Editshortcode.shortCode + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.shortcodeslisting = {};
            Data.get('shortcodes/listshortcodes').then(function (data) {
                $scope.shortcodeslisting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.shortcodeslisting});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                //var client ={id:item.id, shortCode:item.shortCode};
                Data.delete('shortcodes/deleteshortcode/' + item.id + '').then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully Disabled the Short Code.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };

        })
        .controller('SdpServicesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.sdpservice = {};
            //$scope.sdpservice.orgId=1;
            //$scope.sdpservice.createdBy=1;
            //Get Address books
            Data.get('shortcodes/listshortcodes').then(function (data) {
                $scope.ShortCodes = data;
            });
            //Add AddressBook
            $scope.doAddSDPService = function (SDPServiceForm, sdpservice) {
                if (SDPServiceForm.$valid) {
                    Data.post('sdpservice/createsdpservice', sdpservice).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + sdpservice.serviceName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.editsdpservice = {shortCodeId: ''};
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.editsdpservice = item;
                $scope.editsdpservice.shortCodeId = item.shortCodeId.id;
                //$scope.editcategory.BookId=item.addressBookId.id;
                // console.log(item);
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditSDPService = function (SDPServiceEditForm, editsdpservice) {
                if (SDPServiceEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: editsdpservice.id, spId: editsdpservice.spId, sdpServiceId: editsdpservice.sdpServiceId, serviceName: editsdpservice.serviceName, shortCodeId: editsdpservice.shortCodeId};
                    Data.put('sdpservice/updatesdpservice/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + editsdpservice.serviceName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.SDPServiceLisiting = {};
            Data.get('sdpservice/listsdpservice').then(function (data) {
                //Data.get('categories/listallcategories').then(function(data) {       
                $scope.SDPServiceLisiting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.SDPServiceLisiting});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var category = {id: item.id, CategoryName: item.CategoryName, addressBookId: item.addressBookId.id, orgId: item.addressBookId.orgId.id};
                Data.put('categories/deleteCategory/', category).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully Disabled the Category.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };


        })
        .controller('InboxController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.inboxmessages = {};
            $scope.inboxmessages.orgId = 1;

            //List Adress Books
            $scope.InboxLisiting = {};
            Data.get('smsdata/inboxmessage/' + $scope.inboxmessages.orgId).then(function (data) {
                //Data.get('categories/listallcategories').then(function(data) {       
                $scope.InboxLisiting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.InboxLisiting});
            });

        })
        .controller('outboxController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.outboxmessages = {};
            $scope.outboxmessages.orgId = 1;

            //List Adress Books
            $scope.OutboxLisiting = {};
            Data.get('smsdata/outboxmessage/' + $scope.outboxmessages.orgId).then(function (data) {
                //Data.get('categories/listallcategories').then(function(data) {       
                $scope.OutboxLisiting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.OutboxLisiting});
            });

        })
        .controller('logsController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.logs = {};
            $scope.logs.orgId = 1;

            //List Adress Books
            $scope.LogsLisiting = {};
            Data.get('smsdata/transactionlogs/' + $scope.logs.orgId).then(function (data) {
                $scope.LogsLisiting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.LogsLisiting});
            });

        })
        .controller('uploadedfilesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.uploadedfiles = {};
            $scope.uploadedfiles.orgId = 1;

            //List Adress Books
            $scope.uploadedfilesLisiting = {};
            Data.get('smsdata/transactionlogs/' + $scope.uploadedfiles.orgId).then(function (data) {
                $scope.uploadedfilesLisiting = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.uploadedfilesLisiting});
            });

        })
        .controller('bulksmsController', function ($scope, $window, User, $state, $rootScope, Data, Flash, NgTableParams, $timeout, Upload) {

            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.showUploadView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                    $scope.showUploadView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;
                    $scope.showUploadView = false;

                } else if (view === 'uploadform') {
                    $scope.showGridView = false;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                    $scope.showUploadView = true;
                }

            };
            $scope.bulksms = {};
            $scope.bulksms.orgId = 1;
            // $scope.bulksms.createdBy=1;
            // $scope.contact.sdpServiceId=1;
            //$scope.addressBookId='';
            //Get Address books
            Data.get('shortcodes/listshortcodes').then(function (data) {
                $scope.ShortCodes = data;
            });
            Data.get('sdpservice/listsdpservice').then(function (data) {
                $scope.sdpservice = data;
            });

            //Get Active States
            User.GetActiveStatus();
            $scope.ActiveStatus = User.ActiveStatus;
            //List clients
            $scope.BulkListing = {};
            Data.get('contacts/listcontactsorganization/' + $scope.bulksms.orgId).then(function (data) {
                $scope.BulkListing = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.BulkListing});
            });
            $scope.sendbulksms = {};
            $scope.sendbulksms.orgId = 1;
            $scope.uploadPic = function (file, sendbulksms)
            {
                console.log(sendbulksms);
                // var requestbody={shortCodeId: sendbulksms.shortCode, sdpServiceId:sendbulksms.sdpServiceId, orgId:1};
                // var modelbody= angular.toJson(sendbulksms);
                // console.log(modelbody);
                file.upload = Upload.upload({
                    url: 'http://192.168.0.190:8082/prsp/smsdata/uploadContactFile',
                    // fields: {requestbody: modelbody},
                    fields: {shortCodeId: sendbulksms.shortCodeId, sdpServiceId: sendbulksms.sdpServiceId, orgId: 1},
                    file: file
                });
                file.upload.then(function (response) {
                    $timeout(function () {
                        file.result = response.data;
                    });
                    $scope.myVar = !$scope.myVar;
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                    // Math.min is to fix IE which reports 200% sometimes
                    file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
                });
            };

        })
        .controller('AccountTypesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            //$scope.accounttype ={};
            //Add AddressBook
            $scope.doAddAccountType = function (AccountTypeForm, accounttype) {
                if (AccountTypeForm.$valid) {
                    Data.post('accounts/createaccounttype', accounttype).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + accounttype.accountTypeName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);
                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.Editaccounttype = item;
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditAccountType = function (AccountTypeEditForm, Editaccounttype) {
                if (AccountTypeEditForm.$valid) {
                    console.log(Editaccounttype);
                    var client = {id: Editaccounttype.id, accountTypeName: Editaccounttype.accountTypeName};
                    Data.put('accounts/editaccounttype/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + Editaccounttype.accountTypeName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.AccountTypesListing = {};
            Data.get('accounts/listaccountstype').then(function (data) {
                $scope.AccountTypesListing = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.AccountTypesListing});
            });

        })
        .controller('TransactionTypesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            //$scope.accounttype ={};
            //Add AddressBook
            $scope.doAddTransactionType = function (TransactionTypeForm, Transactiontype) {
                if (TransactionTypeForm.$valid) {
                    Data.post('prstransactions/createtransactiontype', Transactiontype).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + Transactiontype.transactionTypeName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);
                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.EditTransactiontype = item;
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEditTransactionType = function (TransactionTypeEditForm, EditTransactiontype) {
                if (TransactionTypeEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: EditTransactiontype.id, transactionTypeName: EditTransactiontype.transactionTypeName};
                    Data.put('prstransactions/edittransactiontype/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + EditTransactiontype.transactionTypeName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.TransactionTypesListing = {};
            Data.get('prstransactions/listtransactiontype').then(function (data) {
                $scope.TransactionTypesListing = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.TransactionTypesListing});
            });

        })
        .controller('topupsController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };

            //Get Active States
            User.GetActiveStatus();
            $scope.ActiveStatus = User.ActiveStatus;
            //Organization
            Data.get('organization/listOrgs').then(function (data) {
                $scope.Orgs = data;
            });
            //prstransactions
            Data.get('prstransactions/listtransactiontype').then(function (data) {
                $scope.TransType = data;
            });
            //Calculate the number of units
            $scope.topup = {};
            $scope.topup.createdBy = 1;
            $scope.topup.approvedBy = 1;
            $scope.topup.status = 0;
            $scope.CostSMS = 3;
            $scope.Balance = 200;
            $scope.CalculateUnits = function (amount) {
                var cost = $scope.CostSMS;
                var rr = Math.round(amount / cost);
                $scope.topup.amountOfUnits = rr;

            };

            //List clients
            $scope.ListTransactions = {};
            Data.get('topup/listtransactions').then(function (data) {
                $scope.ListTransactions = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.ListTransactions});
            });
            //Add Organizations
            $scope.doAddTopup = function (TopupForm, topup) {
                if (TopupForm.$valid) {
                    Data.post('topup/createtopup', topup).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + topup.amountOfUnits + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

        })
        .controller('sendSMSController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {

            $scope.sms = {};
            $scope.schedular = 1;
            //get shortcodes
            Data.get('shortcodes/listshortcodes').then(function (data) {
                $scope.ShortCodes = data;
            });
            //get categories
            Data.get('categories/listallcategories/1').then(function (data) {
                vm.values = data;
            });
            //select2
            var vm = this;
            vm.isLoaded = false;
            vm.selected;
            //end select


        })
        .controller('RolesController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //setting up 
            $scope.roles = {};
            //Add AddressBook
            $scope.doAdd = function (RoleForm, role) {
                if (RoleForm.$valid) {
                    Data.post('roles/createrole', role).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + role.roleName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);
                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Edit Organization click
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.EditRole = item;
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEdit = function (EditForm, EditRole) {
                if (EditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: EditRole.id, roleName: EditRole.roleName};
                    Data.put('roles/updateuser/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + EditRole.roleName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };

            //List Adress Books
            $scope.rolesListing = {};
            Data.get('roles/listroles').then(function (data) {
                $scope.rolesListing = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.rolesListing});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var client = {id: item.id, orgName: item.orgName, status: item.status, contactName: item.contactName, contactPhone: item.contactPhone, contactAddress: item.contactAddress};
                Data.put('addressbook/deleteaddbook/', client).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully Disabled the organization.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };

        })
        .controller('UsersController', function ($scope, $window, User, $state, $rootScope, Data, Flash, $timeout, NgTableParams) {
            //showing and hiding grids and forms
            $scope.showGridView = true;
            $scope.showAddView = false;
            $scope.showEditView = false;
            $scope.toggleView = function (view) {
                if (view === 'grid') {
                    $scope.showGridView = true;
                    $scope.showAddView = false;
                    $scope.showEditView = false;
                } else if (view === 'addform') {
                    $scope.showGridView = false;
                    $scope.showAddView = true;
                    $scope.showEditView = false;

                }
            };
            //getting roles
            $scope.userform={};
            $scope.userform.passwordResetToken='sdas';
            var vm = this;
            Data.get('roles/listroles').then(function (data) {
                vm.values=[];
                 angular.forEach(data, function(item) {
                      vm.values.push({id:item.id, roleName:item.roleName}); 
                 });
            });
            //select2
            vm.isLoaded = false;
            vm.selected;
            //end select
            //Add Organizations
            $scope.doAdd = function (AddForm, userform) {
                if (AddForm.$valid) {
                    var userdetails = {passwordResetToken:userform.passwordResetToken, otherNames: userform.otherNames, orgId: userform.orgId, email: userform.email, username: userform.username, roleData:vm.selected, passwordHash:userform.passwordHash, status:userform.status};
                    Data.post('user/createuser', userdetails).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully added ' + userform.otherNames + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //Get Active States
            User.GetActiveStatus();
            $scope.ActiveStatus = User.ActiveStatus;
            Data.get('organization/listOrgs').then(function (data) {
                $scope.Organizations = data;
            });
            //Edit Organization click
            $scope.EditClient = {statusId: 0};
            $scope.Edit = function (item) {
                $scope.showGridView = false;
                $scope.showAddView = false;
                $scope.showEditView = true;
                $scope.editUser = item;
                $scope.editUser.status = item.status;
                //console.log(item);
                //$scope.SelectedState=item.status;
            };
            //Edit organization action
            $scope.doEdit = function (ClientEditForm, EditClient) {
                if (ClientEditForm.$valid) {
                    //console.log(EditClient);
                    var client = {id: EditClient.id, orgName: EditClient.orgName, status: EditClient.statusId, contactName: EditClient.contactName, contactPhone: EditClient.contactPhone, contactAddress: EditClient.contactAddress};
                    Data.put('organization/updateOrg/', client).then(function (results) {
                        var message = '<strong>Success !</strong> You have successfully updated ' + EditClient.orgName + '.';
                        Flash.create('success', message, 3000, {}, true);
                        $timeout(function () {
                            $state.reload();
                        }, 3000);


                    }, function (results) {
                        var message = '<strong>Error !</strong> "' + results.data.message + '"';
                        //console.log(results.data.message);
                        Flash.create('danger', message, 3000, {}, true);
                    });
                } else {
                    alert("Ensure you have filled in all the fields");
                }
            };
            //List clients
            $scope.UserListing = {};
            Data.get('user/listusers').then(function (data) {
                $scope.UserListing = data;
                //ng-tables scripts
                $scope.tableParams = new NgTableParams({}, {dataset: $scope.UserListing});
            });
            //Delete Function
            $scope.Delete = function (item) {
                $scope.ItemRemove = item;
                var box = document.getElementById('mb-remove-row');
                box.classList.add("open");
            };
            $scope.Close = function () {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
            };
            $scope.Disable = function (item) {
                var box = document.getElementById('mb-remove-row');
                box.classList.remove("open");
                var client = {id: item.id, orgName: item.orgName, status: item.status, contactName: item.contactName, contactPhone: item.contactPhone, contactAddress: item.contactAddress};
                Data.put('organization/deleteOrg/', client).then(function () {

                });
                var message = '<strong>Success !</strong> You have successfully removed the organization.';
                Flash.create('success', message, 3000, {}, true);
                document.getElementById(item.id).style.display = 'none';
            };

        })


        ;
