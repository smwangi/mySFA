angular.module('tl_crm')
.directive('compareTo', function() {
    return {
      require: "ngModel",
      scope: {
        otherModelValue: "=compareTo"
      },
      link: function(scope, element, attributes, ngModel) {

        ngModel.$validators.compareTo = function(modelValue) {
          return modelValue == scope.otherModelValue;
        };

        scope.$watch("otherModelValue", function() {
          ngModel.$validate();
        });
      }
    };
})
.directive('awLimitLength', function () {
  return {
    restrict: "A",
    require: 'ngModel',
    link: function (scope, element, attrs, ngModel) {
      attrs.$set("ngTrim", "false");
      var limitLength = parseInt(attrs.awLimitLength, 10);// console.log(attrs);
      scope.$watch(attrs.ngModel, function(newValue) {
        if(ngModel.$viewValue.length>limitLength){
          ngModel.$setViewValue( ngModel.$viewValue.substring(0, limitLength ) );
          ngModel.$render();
        }
      });
    }
  };
})
.filter('propsFilter', function() {
  return function(items, props) {
    var out = [];

    if (angular.isArray(items)) {
      var keys = Object.keys(props);

      items.forEach(function(item) {
        var itemMatches = false;

        for (var i = 0; i < keys.length; i++) {
          var prop = keys[i];
          var text = props[prop].toLowerCase();
          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
            itemMatches = true;
            break;
          }
        }

        if (itemMatches) {
          out.push(item);
        }
      });
    } else {
      // Let the output be the input untouched
      out = items;
    }

    return out;
  };
});
