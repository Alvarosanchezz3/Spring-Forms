package com.alvaro.springbootform.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alvaro.springbootform.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private List<Role> listaRoles;
	
	public RoleServiceImpl () {
		
		this.listaRoles = Arrays.asList(
		new Role(1, "Administrador", "ROLE_ADMIN"),
		new Role(2, "Usuario", "ROLE_USER"),
		new Role(3, "Moderador", "ROLE_MODERATOR")
		);
	}
	
	@Override
	public List<Role> listar() {
		return listaRoles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		Role resultado = null; 
		for (Role role : this.listaRoles) {
	            if (id == role.getId()) {
	                resultado = role; // Si se encuentra un rol con el mismo id, se asigna a resultado
	                break; // Se sale del bucle for, ya que se encontró el rol buscado
	            }
	        }
		return resultado;
	}
}
