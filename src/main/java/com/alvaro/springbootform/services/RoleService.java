package com.alvaro.springbootform.services;

import java.util.List;

import com.alvaro.springbootform.models.domain.Role;

public interface RoleService {

	public List<Role> listar ();
	
	public Role obtenerPorId(Integer id);
	
}
