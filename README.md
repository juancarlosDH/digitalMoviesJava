### Aplicacion de Peliculas

##Creada con Spring Boot y gestionada con Maven.

#Pasos:
Clonar el proyecto:
$ git clone https://github.com/juancarlosDH/digitalMoviesJava.git

Abrir el proyecto con Eclipse, IntelliJ Idea o similar, así te descarga las dependencias automaticamente.

Al iniciar el proyecto modificar el archivo src/main/resources/application.properties con las credenciales.
No te olvides de crear la BD antes de correr el proyecto.

##Los Beans de Java:
* Los controladores y servicios poseen Inyección de Dependencias (DI) usando el constructor, es por eso que no hacemos @Autowired.
* Aunque es lo mismo, pero si no hacen @Autowired, la mejor forma es hacerlo con el constructor, así garantizas usar el servicio o repositorio donde lo necesites.
* Además en el MovieController al crear o actualizar la Movie tiene validaciones del lado del servidor, usando @Valid, pero para usar esta funcionalidad lo tenemos que configurar en el modelo, por ejemplo:
    * Campo title tiene en el @NotNull el message que es el mensaje del error.
    * También el campo title tiene @Size que es una regla que se usa para un rango de caracteres.
    * Campo awards, validamos que al menos sea el número 0.
    * Para fechas, campo releaseDate tiene el @DataTiemFormat.

#Tiene controladores rest para:
* Movie (aun no terminados).

#Tiene controladores para responder en HTML:
* Movie, recordemos que estamos haciendo DI por el constructor, tiene mappings para listado de Movies, formulario de nueva Movie.
    * En el PostMapping para guardar la Movie usamos el @Valid que basicamente usa las validaciones del modelo Movie, entonces:
        * Si hay errores tenemos que usar el BindingResult, para enviar esos errores a la vista le preguntamos al bindingResult si tiene errores y retornamos la misma vista del formulario de nueva Movie.
        * Si no hay usamos el metodo save del service pasandole la Movie.
    * Para la edición de la Movie agregamos un enlace que va a movies/{id}/edit el cual carga el formulario, recordemos que debemos:
        * Consultar todos los generos y buscar la movie por el id, en ambas ocaciones usamos el servicio, el cual explicaremos mas adelante para que funciona.
        * Luego de obtener esos datos, debemos usar la DI para el Model y hacer uso de model.addAtribute, recordemos que el primer parametro de esa función es el nombre de la variable que vamos a usar en la vista.
    * En ese formulario de Movie el action apunta la misma url que el Get y creamos el PostMapping para esa misma url o endpoint.
    * En el momento de actualizar la Movie que viene del form:
        * Aqui de igual manera usamos el @Valid para validar el formulario. y si hay errores entonces cargamos la vista de la edicion de nuevo.
        * Si no hay errores entonces tambien usamos el metodo save del servicio pasandole la Movie.
        * Luego redirijimos a al Getmapping del listado, por eso usamos redirect.
 
#Los Servicios
Le llamamos Servicio al objeto que se va a encargar de procesar la informacion del controlador, es una capa adicional que prácticamente va a tener la lógica de cada controlador.
Por ejemplo tenemos un servicio para las Movies que es el que tiene conexión con el MovieJPARepository.
Para el caso de las Preguntas, los mappgins del controlador se conectan al service, la diferencia fundamental está en:
    * El Servicio es el que va a tener que resolver si la pregunta que contestó el usuario es correcta a o no, es por ello que la lógica va a estar en el servicio.
    * En este caso el método isCorrectAnswer que recibe la pregunta y la respuesta que contestó el usuario, dentro recorre las respuestas que son correctas de la pregunta y filtra la que sea igual a la del usuario y responde con un booleano.   
Un servicio tiene la anotación @Service y debería de tener las DI de los repositorios que necesite en el constructor o usando el @Autowired.
Los servicios son opcionales pero son una buena práctica, así el controlador no tiene muchas lineas de código y así podemos reutilizar los métodos.

