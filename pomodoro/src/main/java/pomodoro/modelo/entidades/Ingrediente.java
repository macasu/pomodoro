package pomodoro.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


import pomodoro.modelo.enumeraciones.IngredienteCategoria;

@Entity
public class Ingrediente {
	
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@NotEmpty
		private String nombre;
		
		@NotNull
		@Enumerated(EnumType.STRING)
		private IngredienteCategoria categoria;
		
		public Pizzeria getDono() {
			return dono;
		}

		public void setDono(Pizzeria dono) {
			this.dono = dono;
		}

		@ManyToOne
		@JoinColumn(name="DONO")
		@JsonIgnore
		private Pizzeria dono;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public IngredienteCategoria getCategoria() {
			return categoria;
		}

		public void setCategoria(IngredienteCategoria categoria) {
			this.categoria = categoria;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ingrediente other = (Ingrediente) obj;
			if (categoria != other.categoria)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}

	
}


