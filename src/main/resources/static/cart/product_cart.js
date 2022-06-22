angular.module('market-front').controller('productCartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/api/v1';



    $scope.loadCartProducts = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET'
        }).then(function (response) {
            console.log(response);
            $scope.cartProductsList = response.data;
        });
    }

    $scope.deleteFromCart = function (productId){
        $http.get(contextPath + '/cart/del/' + productId)
            .then(function successCallback(response) {
                    console.log(response);
                    $scope.loadCartProducts();
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
    }

    $scope.clearCart = function (){
        $http.get(contextPath + '/cart/clear')
            .then(function successCallback(response) {
                    $scope.loadCartProducts();
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
    }





    $scope.showInfo = function (product) {
        alert(product.title);
    }


    $scope.loadCartProducts();

});