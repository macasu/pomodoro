package pomodoro.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	@NotNull @NotEmpty
	@Column(unique=true)
	private String login;

	@NotNull @NotEmpty
	private String pas;
	
	@Transient
	@NotNull @NotEmpty
	private String confirmacionPas;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPas() {
		return pas;
	}

	public void setPAs(String pas) {
		this.pas = pas;
	}

	public String getConfirmacionPas() {
		return confirmacionPas;
	}

	public void setConfirmacionPas(String confirmacaoPas) {
		this.confirmacionPas = confirmacaoPas;
	}
	
}
