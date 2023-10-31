package com.alvaro.springbootform.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.alvaro.springbootform.editors.NombreMayusculaEditor;
import com.alvaro.springbootform.editors.PaisPropertyEditor;
import com.alvaro.springbootform.editors.RolesEditor;
import com.alvaro.springbootform.models.domain.Pais;
import com.alvaro.springbootform.models.domain.Role;
import com.alvaro.springbootform.models.domain.Usuario;
import com.alvaro.springbootform.services.PaisService;
import com.alvaro.springbootform.services.RoleService;
import com.alvaro.springbootform.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario") // Se usa para persistir la información de este atributo
public class FormController {

	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RolesEditor roleEditor;
	
	@InitBinder // @InitBinder automatiza las validaciones sin usar validate()
	public void initBinder (WebDataBinder binder) {
		
		binder.addValidators(validador);/* Con addValidators() permites añadir otro validador, así funciona el automático y las anotaciones,
		 								 * usando setValidator() solo funciona el que pones */
		
		// Validación de el formato de la fecha para el formato de java.util.Date
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // setLenient(false) --> El dateFormat es estricto con el formato
									  // setLenient(true) --> El dateformat interpreta entradas con formato incorrecto (puede haber errores)
				
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
		// Usando registerCustomEditor(tipo de dato, "atributo", ClaseEditor());
		
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
		
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		
		binder.registerCustomEditor(Role.class, "roles", roleEditor);
	}																			
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
	    return paisService.listar();
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles() {
	    return roleService.listar();
	}
	
	@ModelAttribute("genero")
	public List<String> genero () {
		return Arrays.asList("Hombre", "Mujer");
	}
	
	@GetMapping("/form")
	public String form (Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setId("12.345.678-K");
		usuario.setNombre("Álvaro");
		usuario.setApellido("Sánchez");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algún valor secreto *****");
		usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
		
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario (@Valid Usuario usuario, BindingResult br, Model model) {
		
		if (br.hasErrors()) { // Si hay errores en el formulario
			
			model.addAttribute("titulo", "Formulario usuarios");
			
			/* En mi caso uso los errores generados de Spring, pero se pueden personalizar de este modo:
			
			Map<String, String> errores = new HashMap<>(); 
			br.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), "El campo " + "'" + err.getField() + "'" + " " + err.getDefaultMessage());
			});
			model.addAttribute("error", errores);	*/				
																
			return "form";
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("ver")
	public String ver (@SessionAttribute(name ="usuario", required = false) Usuario usuario, Model model,  SessionStatus status) {
		
		if (usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Resultado formulario:");
		
		// Contamos el tamaño de la contraseña para poner "*" según el tamaño de ella para mostrarla oculta en la vista por privacidad y seguridad
		int passwordSize = usuario.getPassword().length();
		String hiddenPassword = "*".repeat(passwordSize);
				
		model.addAttribute("hiddenPassword", hiddenPassword);
		
		status.setComplete(); // Completa el proceso y lo elimina de la sesión
		return "resultado";
	}
}