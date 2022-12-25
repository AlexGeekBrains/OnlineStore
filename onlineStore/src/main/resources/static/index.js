angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/store';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http({
            url: contextPath + '/products/delete',
            method: 'DELETE',
            params: {
                id: productId,
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.filterProducts = function () {
        $http({
            url: contextPath + '/products/filter',
            method: 'GET',
            params: {
                minCost: $scope.minCost,
                maxCost: $scope.maxCost
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
            $scope.minCost=null;
            $scope.maxCost=null;
        });
    }

    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.addProduct = function (product) {
        $http.post(contextPath + '/products/add', product).then(function (response) {
            $scope.product = null;
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});