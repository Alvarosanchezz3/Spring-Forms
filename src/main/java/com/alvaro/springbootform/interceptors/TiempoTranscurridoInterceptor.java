package com.alvaro.springbootform.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("tiempoTranscurridoInterceptor") // Le damos nombre para una mejor implementación
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		
		if (handler instanceof HandlerMethod) { 
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("Es un método del controlador: " + metodo.getMethod().getName());
		}
		
		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio); // Guardamos atributo en el request
		
		// Delay aleatorio que simula una carga
		Random random = new Random();
		Integer delay = random.nextInt(200); // Random de 0 a 199
		Thread.sleep(delay);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio"); // Recuperamos el tiempo de inicio del atributo
		long tiempoFin = System.currentTimeMillis();
		
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		if (handler instanceof HandlerMethod && modelAndView != null) { 	  //* Importante validar esto por posibles
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido); //* fallos de los archivos estáticos
		}
		
		logger.info("Tiempo transcurrido: " + tiempoTranscurrido + " milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
	}

	
}
