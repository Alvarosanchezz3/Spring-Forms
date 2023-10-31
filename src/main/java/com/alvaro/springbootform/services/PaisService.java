package com.alvaro.springbootform.services;

import java.util.List;

import com.alvaro.springbootform.models.domain.Pais;

public interface PaisService {

	public List<Pais> listar();
	
	public Pais obtenerPorId(Integer id);
}
