angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/store/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                part_title: $scope.filter ? $scope.filter.part_title : null,
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data.content;
            $scope.filter.min_cost = null;
            $scope.filter.max_cost = null;
            $scope.filter.part_title = null;
        });
    };

    $scope.deleteProduct = function (productId) {
        $http({
            url: contextPath + '/products',
            method: 'DELETE',
            params: {
                id: productId,
            }
        }).then(function (response) {
            $scope.loadProducts();
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
        $http.post(contextPath + '/products', product).then(function (response) {
            $scope.product = null;
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});