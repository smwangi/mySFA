'use strict';
angular.module('tl_crm', ['ui.router', 'ngResource', 'ngSanitize', 'ngCookies','http-auth-interceptor', 'ngAnimate', 'ngFlash', 'ngTable', 'ngFileUpload', 'igCharLimit','ui.select'])
    .config(function($stateProvider, $urlRouterProvider, $resourceProvider, $httpProvider, $sceDelegateProvider, USER_ROLES) {
       
        $stateProvider
            .state('app', {
                url: '/',
                views: {
                    'login': {},
                    'sidebar': {
                        templateUrl: _contextpath+'/static/views/sidebar.jsp',
                        controller: "sidebarController"
                    },
                    'header': {
                        templateUrl: _contextpath+'/static/views/header.jsp',
                        controller: "HeaderController"
                    },
                    'main-content': {
                        templateUrl: _contextpath+'/static/views/home.jsp',
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.login', {
                url: 'login',
                views: {
                    'login@': {
                        templateUrl: _contextpath+'/static/views/login.jsp'
                    },
                    'sidebar@': {
                    },
                    'header@': {
                    },
                    'main-content@': {
                    }
                }
            })
            .state('app.clients', {
                url: 'clients',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/clients.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.addressbook', {
                url: 'addressbook',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/addressbook.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.categories', {
                url: 'categories',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/categories.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.contacts', {
                url: 'contacts',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/contacts.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.shortcodes', {
                url: 'shortcodes',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/shortcodes.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.sdpservices', {
                url: 'sdpservices',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/sdpservices.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.inbox', {
                url: 'inbox',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/inbox.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.outbox', {
                url: 'outbox',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/outbox.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.logs', {
                url: 'logs',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/logs.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.uploadedfiles', {
                url: 'uploadedfiles',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/uploadedfiles.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.bulksms', {
                url: 'bulksms',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/bulksms.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.accountstypes', {
                url: 'accountstypes',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/accountstypes.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.transactiontypes', {
                url: 'transactiontypes',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/transactiontypes.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.topups', {
                url: 'topups',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/topups.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.sendsms', {
                url: 'sendsms',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/sendsms.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
             .state('app.users', {
                url: 'users',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/users.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
            .state('app.roles', {
                url: 'roles',
                views: {
                    'main-content@': {
                        templateUrl: _contextpath+'/static/views/roles.jsp'
                    }
                },
                access: {
                    loginRequired: true,
                    authorizedRoles: [USER_ROLES.USER,USER_ROLES.ADMIN,USER_ROLES.SUPERADMIN]
                }
            })
        ;
        $urlRouterProvider.otherwise('/login');
    })
    .constant('USER_ROLES', {
    USER: 'USER',
    ADMIN: 'ADMIN',
    SUPERADMIN: 'SUPERADMIN'
    })
    .run(function ($rootScope, $location, $http, AuthSharedService, Session, USER_ROLES, $q, $timeout) {

    $rootScope.$on('$routeChangeStart', function (event, next) {
        AuthSharedService.getAccount();
        if(next.originalPath === "/login" && $rootScope.authenticated) {
            event.preventDefault();
        } else if (next.access && next.access.loginRequired && !$rootScope.authenticated) {
            event.preventDefault();
            $location.path('/login');
            $rootScope.$broadcast("event:auth-loginRequired", {});
        } else if (next.access && !AuthSharedService.isAuthorized(next.access.authorizedRoles)) {
            event.preventDefault();
            $rootScope.$broadcast("event:auth-forbidden", {});
            $location.path('/login');
        }
    });

    $rootScope.$on('$routeChangeSuccess', function (scope, next, current) {
        $rootScope.$evalAsync(function () {
            $.material.init();
        });
    });

    // Call when the 401 response is returned by the server
    $rootScope.$on('event:auth-loginRequired', function (event, data) {
        if ( data.status == 401) {
            Session.invalidate();
            $rootScope.authenticated = false;
            $rootScope.loadingAccount = false;
            $location.path('/login');
        }
    });

    // Call when the 403 response is returned by the server
    $rootScope.$on('event:auth-forbidden', function (rejection) {
        $rootScope.$evalAsync(function () {
            $location.path('/login').replace();
        });
    });

    // Call when the user logs out
    $rootScope.$on('event:auth-loginCancelled', function () {
        $location.path('/login').replace();
    });

    // Get already authenticated user account
    AuthSharedService.getAccount();
    })
;
