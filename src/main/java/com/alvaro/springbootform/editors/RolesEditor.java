package com.alvaro.springbootform.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alvaro.springbootform.services.RoleService;

@Component
public class RolesEditor extends PropertyEditorSupport {

	@Autowired
	private RoleService service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		
		if (idString != null && idString.length() > 0) {
			
			try {
				
				// Pasamos el String a Integer y obtenemos el id
				Integer id = Integer.parseInt(idString); 
				this.setValue(service.obtenerPorId(id));
				
			} catch (NumberFormatException e) {
				setValue(null);
			}
			
		} else {
			setValue(null);
		}		
	}
}