'use strict';
angular.module('tl_crm')
        .factory('User', function ($http, $q, $localstorage, Data, $filter, $rootScope, $httpParamSerializer) {
            var o = {
                ActiveStatus: []
            };
            o.GetActiveStatus = function () {
                o.ActiveStatus = [{"status": 0, "name": "INACTIVE"}, {"status": "1", "name": "ACTIVE"}];
            };
            return o;
        })
        .factory("Data", function ($http) { // This service connects to our REST API

            //service url
            var serviceBase = ''+_contextpath+'/';
            //var serviceBase = 'http://192.168.0.190:8080/prsp_v3/';

            var obj = {};
            obj.get = function (q) {
                return $http.get(serviceBase + q).then(function (results) {
                    return results.data;
                });
            };
            obj.post = function (q, object) {
                return $http.post(serviceBase + q, object).then(function (results) {
                    return results.data;
                });
            };
            obj.put = function (q, object) {
                return $http.put(serviceBase + q, object).then(function (results) {
                    return results.data;
                });
            };
            obj.delete = function (q) {
                return $http.delete(serviceBase + q).then(function (results) {
                    return results.data;
                });
            };

            return obj;
        })
        .service('Session', function () {
            this.create = function (data) {
                this.id = data.id;
                this.login = data.username;
                this.userRoles = [];
                angular.forEach(data.userRoleMapId.roleMap, function (value, key) {
                    this.push(value.roleName);
                }, this.userRoles);
            };
            this.invalidate = function () {
                this.id = null;
                this.login = null;
                this.userRoles = null;
            };
            return this;
        })
        .service('AuthSharedService', function ($rootScope, $http, $resource, authService, Session, Data) {
                return {

                    getAccount: function () {
                        $rootScope.loadingAccount = true;
                        $http.get(''+_contextpath+'/security/account')
                            .then(function (response) {
                                authService.loginConfirmed(response.data);
                            });
                    },
                    isAuthorized: function (authorizedRoles) {
                        if (!angular.isArray(authorizedRoles)) {
                            if (authorizedRoles == '*') {
                                return true;
                            }
                            authorizedRoles = [authorizedRoles];
                        }
                        var isAuthorized = false;
                        angular.forEach(authorizedRoles, function (authorizedRole) {
                            var authorized = (!!Session.login &&
                            Session.userRoles.indexOf(authorizedRole) !== -1);
                            if (authorized || authorizedRole == '*') {
                                isAuthorized = true;
                            }
                        });
                        return isAuthorized;
                    },
                    logout: function () {
                        $rootScope.authenticationError = false;
                        $rootScope.authenticated = false;
                        $rootScope.account = null;
                        $http.get('logout');
                        Session.invalidate();
                        authService.loginCancelled();
                    }
                };
            })

;
