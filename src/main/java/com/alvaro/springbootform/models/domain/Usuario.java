package com.alvaro.springbootform.models.domain;

import java.util.Date;
import java.util.List;

import com.alvaro.springbootform.validation.IdRegex;
import com.alvaro.springbootform.validation.Obligatorio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Usuario {

	@IdRegex
	@Obligatorio
	private String id;
		
	// Validacion automática
	private String nombre;
	
	@Obligatorio
	private String apellido;
	
	@Past
	@NotNull
	private Date fechaNacimiento;
	
	@NotNull
	private Pais pais;
	
	@NotNull
	@Min(10)
	@Max(10000)
	private Integer cuenta;
	
	@NotEmpty
	@Size(min = 3, max = 6)
	private String username;
	
	@NotEmpty
	@Size(min = 6, max = 12)
	private String password;
	
	@Obligatorio
	@Email
	private String email;
	
	@NotEmpty
	private List<Role> roles;
	
	// No se valida
	private boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	private String valorSecreto;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isHabilitar() {
		return habilitar;
	}

	public void setHabilitar(boolean habilitar) {
		this.habilitar = habilitar;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getValorSecreto() {
		return valorSecreto;
	}

	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}
}
