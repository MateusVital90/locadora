var generoModulo = angular.module('generoModulo',[]);

generoModulo.controller("generoController", function($scope, $http) {
	
	urlFilme = 'http://localhost:8080/Projeto4Final/rest/filmes';
	urlgenero = 'http://localhost:8080/Projeto4Final/rest/generos';
	
	$scope.listargeneros = function() {
		$http.get(urlgenero).success(function (generos) {
			$scope.generos = generos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.listarFilmes = function() {
		$http.get(urlFilme).success(function (filmes) {
			$scope.filmes = filmes;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionagenero = function(generoselecionado) {
		$scope.genero = generoselecionado;
	}

	$scope.limparCampos = function() {
		$scope.genero = "";
	}
	
	$scope.salvar = function() {
		//alert($scope.genero.codigo);
		console.log($scope.genero.codigo);
		if ($scope.genero.codigo == undefined) {
			//alert("POST - codigo vazio = novo registro");
			console.log("POST - codigo vazio = novo registro");
		   $http.post(urlgenero,$scope.genero).success(function(genero) {
		        //$scope.generos.push($scope.genero);
		        $scope.limparCampos();
		        $scope.listargeneros();
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			//alert("PUT - codigo nao vazio = altera registro");
			console.log("PUT - codigo nao vazio = altera registro");
			  $http.put(urlgenero,$scope.genero).success(function(genero) {
				  $scope.listargeneros();
			      $scope.limparCampos();
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	
	$scope.excluir = function() {
		if ($scope.genero.codigo == undefined) {
			alert("Favor selecionar um registro para poder excluir");
			console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlgenero+'/'+$scope.genero.codigo).success(function () {
				 $scope.listargeneros();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listargeneros();
	$scope.listarFilmes();
	
	
});





