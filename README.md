# 📝 Formularios con Spring

En este proyecto, hemos implementado una robusta validación de formularios utilizando Spring Framework. Hemos creado anotaciones personalizadas en el paquete "validation" y hemos aprovechado las anotaciones proporcionadas por Spring para garantizar la integridad de los datos ingresados en formularios. Además, hemos utilizado Thymeleaf para generar contenido web dinámico y manipular formularios en el lado del servidor.

## 📌 Anotaciones Personalizadas

En el paquete "validation", hemos creado las siguientes anotaciones personalizadas:

- **IdRegex**: Anotación personalizada que permite realizar una validación personalizada del formato del identificador.

- **Obligatorio**: Anotación personalizada que valida que un campo no esté vacío o solo contenga espacios en blanco.

## 🌼 Anotaciones de Spring Utilizadas

Hemos utilizado las siguientes anotaciones de Spring para validar los datos de los formularios:

- **@NotEmpty**: Validación de Spring que impide que el valor sea vacío.

- **@NotBlank**: Validación de Spring que impide que el valor consista únicamente en caracteres de espacio en blanco.

- **@NotNull**: Validación de Spring que impide que el valor sea nulo.

- **@Size(min = 3, max = 6)**: Validación de Spring para el tamaño de caracteres del campo, donde se pueden especificar valores mínimos, máximos o ambos.

- **@Email**: Validación de Spring que garantiza que un campo tenga el formato de una dirección de correo electrónico, comprobando si contiene el carácter "@".

## 🚀 Validación Automática

Hemos implementado la validación automática utilizando la clase `UsuarioValidador`, que implementa la interfaz "Validator" de Spring. Hemos aplicado la anotación `@NotEmpty` para validar el campo "nombre".

## 💡 Características de Thymeleaf

Hemos utilizado Thymeleaf para generar contenido web dinámicamente y manipular formularios en el lado del servidor. Aquí te mostramos algunas de las características clave de Thymeleaf utilizadas en este proyecto:

1. **xmlns:th="http://www.thymeLeaf.org"**: Hemos declarado el espacio de nombres "th" para Thymeleaf, lo que permite que Thymeleaf reconozca las expresiones y atributos personalizados.

2. **th:text="${titulo}"**: Hemos establecido el contenido de elementos HTML utilizando el valor de la variable "titulo" con la ayuda de `model.addAttribute("titulo", "texto que quieres mostrar")`.

3. **th:href="@{/css/style.css}"**: Hemos definido la URL del atributo "href" de la etiqueta `<link>` utilizando una expresión de Thymeleaf, lo que permite enlazar a una hoja de estilos CSS.

4. **th:action="@{/form}" y th:object="${usuario}"**: Hemos establecido la URL del formulario y el objeto "usuario" asociado al formulario, respectivamente.

5. **th:field="*{atributo}"**: Hemos conectado un campo de entrada de texto con el atributo del objeto "usuario" utilizando la expresión "*{atributo}".

6. **th:if="${#fields.hasErrors('atributo')}" y th:errors="*{atributo}"**: Hemos mostrado un mensaje de error si existen errores de validación para el campo "atributo" del formulario.

7. **th:text="${#dates.format(usuario.fechaNacimiento, 'dd-MM-yyyy')}"**: Hemos utilizado la expresión `#dates.format` de Thymeleaf para formatear la fecha "usuario.fechaNacimiento" en el formato deseado.

8. **Inclusión de Fragmentos con `th:replace`**: Con Thymeleaf, podemos dividir nuestras páginas web en fragmentos reutilizables. Utilizamos la expresión `th:replace` para incluir fragmentos en nuestras vistas. Por ejemplo, `<section th:replace="~{controles/tiempo :: interceptor}">` incluye el fragmento "interceptor" definido en el archivo "controles/tiempo.html". Esto nos permite modularizar la presentación y reutilizar componentes visuales de manera eficiente.

9. **Definición de Fragmentos con `th:fragment`**: Para crear fragmentos reutilizables, utilizamos la expresión `th:fragment`. Por ejemplo, `<section th:fragment="interceptor">` define un fragmento llamado "interceptor". Luego, este fragmento se puede incluir en otras partes de nuestras vistas con `th:replace` de esta manera: `th:replace="~{controles/tiempo :: interceptor}"`, esto mejora la organización de nuestro código y la reutilización de componentes visuales.

## 🛠 Implementación del Atributo "Roles"

Hemos incluido la implementación del atributo "Roles" en el proyecto, que sigue una estructura similar a la de "Paises". Aquí se detalla la implementación:

1. **Clase Role**: La clase "Role" representa el rol de usuario. Cada instancia de "Role" incluye los siguientes atributos principales:
   - id: Un identificador único para el rol.
   - nombre: El nombre descriptivo del rol.
   - role: Un nombre específico del rol, a menudo utilizado en seguridad y autorización.

   La clase "Role" proporciona un constructor vacío y un constructor que permite inicializar los atributos id, nombre y role.

   Además, se ha implementado el método "equals" para comparar roles por su identificador.

2. **Interfaz RoleService**: La interfaz "RoleService" define un conjunto de métodos que deben implementarse para acceder y gestionar roles en la aplicación. Los métodos incluyen:
   - listar(): Devuelve una lista de todos los roles disponibles en la aplicación.
   - obtenerPorId(Integer id): Devuelve un rol específico por su identificador o null si no se encuentra.

3. **Clase RoleServiceImpl (Implementación de RoleService)**: En su constructor, se crea una lista de roles predefinidos. Se implementan los métodos listar y obtenerPorId para proporcionar funcionalidad real de acceso a los datos de roles. La anotación `@Service` indica que esta clase es un componente administrado por Spring.

4. **Clase RolesEditor**: La clase "RolesEditor" es un editor personalizado que se utiliza para convertir una representación de texto de un rol en un objeto "Role". Utiliza `@Autowired` para inyectar el servicio "RoleService". El método "setAsText" busca el rol correspondiente utilizando el servicio "RoleService" y lo establece como el valor convertido. La clase está anotada con `@Component`, registrándola como un componente de Spring.

## 🕐 Interceptor de Tiempo Transcurrido

Hemos incorporado un interceptor en este proyecto que mide el tiempo transcurrido en la ejecución de solicitudes a rutas específicas. El interceptor registra el tiempo al inicio de una solicitud y lo compara al final, lo que proporciona información valiosa sobre el rendimiento de nuestras rutas, que en este caso se muestra en la vista para enseñar la forma de hacerlo simplemente.

### Configuración del Interceptor

El interceptor se configura en la clase `MvcConfig`, que actúa como la configuración central para la aplicación. En esta configuración, vinculamos el interceptor a las rutas específicas que deseamos medir. Por ejemplo, el interceptor se aplica a las rutas que comienzan con "/form/". Esto nos permite medir el tiempo de procesamiento de solicitudes en esas rutas y obtener información para optimizar el rendimiento de la aplicación.

El uso de este interceptor en combinación con Thymeleaf y fragmentos mejora la experiencia de desarrollo y monitoreo de nuestra aplicación web.

Con estas implementaciones, hemos logrado una validación sólida de formularios y una gestión eficiente de los roles en la aplicación, garantizando la integridad y la seguridad de los datos. 🚀👨‍💻🌟
