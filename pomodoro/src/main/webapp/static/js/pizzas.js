$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nombre').val('');
	$('#precio').val('');
	$('#categoria').val('');
	$('#ingredientes option').attr('selected', false);
};

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'pizzas';
		var dadosIngrediente = $('#form-pizza').serialize();
		$.post(url, dadosIngrediente)
			.done(function(pagina){
				$('#sec-pizzas').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Error al salvar!');
				
			})
			.always(function(){
				$('#modal-pizza').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-pizza').on('hide.bs.modal', limparModal);
	
	$('.btn-borrar').on('click', function(){
		var pizzaId = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : 'pizzas/'+pizzaId,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function() {
		    	$('tr[data-id="'+pizzaId+'"]').remove();
				var pizzas = parseInt( $('#quantidade-pizzas').text() );
		    	$('#quantidade-pizzas').text(pizzas - 1);
		    }
		});
		
	});
	
	$('.btn-modificar').on('click', function(){
		var pizzaId = $(this).parents('tr').data('id');
		var url = 'pizzas/'+pizzaId;
		$.get(url)
			.done(function(pizza){
				$('#id').val(pizza.id);
				$('#nombre').val(pizza.nombre);
				$('#precio').val(pizza.precio);
				$('#categoria').val(pizza.categoria);
				
				pizza.ingredientes.forEach(function(ingrediente){
					var id = ingrediente.id;
					$('#ingredientes option[value='+id+']').attr('selected', true);
				});
				
				$('#modal-pizza').modal('show');
			});;
	});
	
};