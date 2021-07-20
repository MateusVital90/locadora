var filmeModulo = angular.module('filmeModulo',[]);

filmeModulo.controller("filmesController", function($scope, $http) {
	
	urlfilme = 'http://localhost:8080/Projeto4Final/rest/filmes';
	
	$scope.listarfilmes = function() {
		$http.get(urlfilme).success(function (filmes) {
			$scope.filmes = filmes;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionafilme = function(filmeSelecionado) {
		$scope.filme = filmeSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.filme = "";
	}
	
	$scope.salvar = function() {
		//alert($scope.filme.codigo);
		console.log($scope.filme.codigo);
		if ($scope.filme.codigo == undefined) {
			//alert("POST - codigo vazio = novo registro");
			//console.log("POST - codigo vazio = novo registro");
		   $http.post(urlfilme,$scope.filme).success(function(filme) {
		        $scope.filmes.push($scope.filme);
		        $scope.limparCampos();
		        $scope.listarfilmes();
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			//alert("PUT - codigo nao vazio = altera registro");
			//console.log("PUT - codigo nao vazio = altera registro");
			  $http.put(urlfilme,$scope.filme).success(function(filme) {
				  $scope.listarfilmes();
			      $scope.limparCampos();
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	
	$scope.excluir = function() {
		if ($scope.filme.codigo == undefined) {
			alert("Favor selecionar um registro para poder excluir");
			console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlfilme+'/'+$scope.filme.codigo).success(function () {
				 $scope.listarfilmes();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarfilmes();
	
	
});





