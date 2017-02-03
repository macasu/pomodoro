<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-pizza" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-pizza" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informacion da Pizza</h4>
				</div>
				<div class="modal-body">
					<label for="nombre">Nombre: </label>
					<input id="nombre" name="nombre" class="form-control">
					
					<label for="precio">Precio: </label>
					<input id="precio" name="precio" class="form-control">
					
					<label for="categoria">Categoria: </label>
					<select id="categoria" name="categoria" class="form-control">
						<c:forEach items="${categorias}" var="categoria">
							<option value="${categoria}">${categoria}</option>
						</c:forEach>
					</select>
					
					<label for="ingredientes">Ingredientes: </label>
					<select id="ingredientes" name="ingredientes" class="form-control" multiple="multiple">
						<c:forEach items="${ingredientes}" var="ingrediente">
							<option value="${ingrediente.id}">${ingrediente.nombre}</option>
						</c:forEach>
					</select>
					
					<input id="id" name="id" type="hidden">
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-primary">Guardar</button>
				</div>
			</form>
		</div>
	</div>
</div>