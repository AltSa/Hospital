(function() {

	var app = angular.module('app', []);

	app.controller('controladorBody', function($scope, $http) {
		$scope.holaMundo="Hola mundo";

		$scope.buscarPaciente = function(v) {
			var id=v.idPaciente;
						
		
			$http.get("http://localhost:8080/getPaciente/"+id).then(function(resp) {
						console.log(resp.data);
						if (resp.data.value !== undefined) {
							$scope.nombrePaciente=resp.data.value.nombre;
							$scope.apellidoPaciente=resp.data.value.apellido;
							$scope.edadPaciente=resp.data.value.edad;
							$scope.causaPaciente=resp.data.value.causa;
						} else
							alert("No se encontro el paciente");
					}, function(err) {
						alert("Error de api de paciente");
					});

		}

		

		$scope.registrarPaciente= function(){

			$http({
				method:"POST",
				url:"http://localhost:8080/guardar",
				data: angular.toJson($scope.paciente),
				headers:{
					'Content-Type':'application/json'
				}
						
			}).then(function(sucess){
				alert('se registro el paciente');
				},function(err){
					console.log(err);
				})	
			
		}
		

	});
	
	

})();

