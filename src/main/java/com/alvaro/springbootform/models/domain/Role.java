package com.alvaro.springbootform.models.domain;

public class Role {

	private Integer id;
	
	private String nombre;
	
	private String role;
	
	public Role () {
		
	}
	
	public Role(Integer id, String nombre, String role) {
		this.id = id;
		this.nombre = nombre;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object obj) { // Si el objeto pasado como argumento es un objeto Role y sus ids son
		Role role = (Role) obj;			// iguales, el método devuelve true; de lo contrario, devuelve false.
		return this.id != null && this.id.equals(role.getId());
	}	
}
