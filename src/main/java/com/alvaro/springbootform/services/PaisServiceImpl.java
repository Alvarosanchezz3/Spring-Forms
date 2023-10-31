package com.alvaro.springbootform.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alvaro.springbootform.models.domain.Pais;

@Service // Se anota con service para decir que es un componente de Spring
public class PaisServiceImpl implements PaisService {

    private List<Pais> listaPaises; // Lista que almacena objetos de tipo Pais

    public PaisServiceImpl() { // Constructor: inicializa la lista con objetos Pais que representan países

        this.listaPaises = Arrays.asList(
            new Pais(1, "US", "Estados Unidos"),
            new Pais(2, "CN", "China"),
            new Pais(3, "IN", "India"),
            new Pais(4, "BR", "Brasil"),
            new Pais(5, "RU", "Rusia"),
            new Pais(6, "JP", "Japón"),
            new Pais(7, "DE", "Alemania"),
            new Pais(8, "GB", "Reino Unido"),
            new Pais(9, "FR", "Francia"),
            new Pais(10, "IT", "Italia"),
            new Pais(11, "CA", "Canadá"),
            new Pais(12, "AU", "Australia"),
            new Pais(13, "KR", "Corea del Sur"),
            new Pais(14, "ES", "España"),
            new Pais(15, "MX", "México"),
            new Pais(16, "AR", "Argentina")
        );
    }

    @Override
    public List<Pais> listar() {
        // Método que devuelve la lista de países
        return listaPaises;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;

        // Bucle for para recorrer la lista de países
        for (Pais pais : this.listaPaises) {
            if (id == pais.getId()) {
                resultado = pais; // Si se encuentra un país con el mismo id, se asigna a resultado
                break; // Se sale del bucle for, ya que se encontró el país buscado
            }
        }
        return resultado; // Se devuelve el país encontrado o null si no se encontró ninguno
    }
}
