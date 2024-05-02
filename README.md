# Guía de Integración con API CRUD CRUD

## Descripción del API
El API CRUD CRUD es un servicio que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos en la nube de forma sencilla y sin necesidad de configuraciones complejas.

## Ejemplo de Implementación
Para utilizar el API CRUD CRUD en tu proyecto, sigue estos pasos:

1. Obtención de API Key:
    Para obtener tu clave de API de CRUD CRUD, sigue estos pasos:
   - Ve al sitio web de CRUD CRUD (https://crudcrud.com/).
   - (OPCIONAL)Regístrate o inicia sesión en tu cuenta.
   - En el panel de administración, copia tu API Key.

2. Realiza solicitudes al API para interactuar con tu base de datos:
   - Utiliza cualquier cliente HTTP para realizar solicitudes GET, POST, PUT, y DELETE según tus necesidades.
   - Ejemplo de solicitud GET para LISTAR todos los elementos de la base de datos:
     ```http
     GET https://crudcrud.com/api/9b0d020aa6b54b188937cd9a04e0ca44/products
     ```
   - Ejemplo de solicitud POST para AGREGAR un elemento de la base de datos:
     ```http
     POST https://crudcrud.com/api/9b0d020aa6b54b188937cd9a04e0ca44/products
     ```
   - Ejemplo de solicitud PUT para ACTUALIZAR un elemento de la base de datos:
     ```http
     PUT https://crudcrud.com/api/9b0d020aa6b54b188937cd9a04e0ca44/products/663302f512b33803e8016e73
     ```
   - Ejemplo de solicitud DELETE para ELIMINAR un elemento de la base de datos:
     ```http
     DELETE https://crudcrud.com/api/9b0d020aa6b54b188937cd9a04e0ca44/products/663302f512b33803e8016e73
     ```
     

3. Procesa las respuestas del API según tus necesidades:
   - El API devuelve datos en formato JSON que puedes procesar en tu aplicación.

## Integración Completa
Para una integración más completa, consulta la documentación oficial de CRUD CRUD [aquí](https://crudcrud.com/docs).

## Consideraciones de Seguridad
- Utiliza HTTPS para todas las solicitudes al API CRUD CRUD.
- No compartas tu API Key en código público o en repositorios compartidos.

## Integracion del API KEY con Retrofit en Android Studio 
- Dentro de la carpeta home en el archivo ProductService agregamos la ruta del API KEY usando Retrofit
     ```ruta
    companion object {
        val instance =
            Retrofit.Builder().baseUrl("https://crudcrud.com/api/9b0d020aa6b54b188937cd9a04e0ca44/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build().create(ProductService::class.java)
    }
     ```
- Tambien las demas rutas para el GET, POST, PUT y DELETE con Retrofit
     ```ruta
    @GET("products")
    suspend fun getProducts(): List<Product>

    @POST("products")
    suspend fun insertProduct(@Body product: ProductDto): Product

    @PUT("products/{id}")
    suspend fun updateProduct(@Body product: ProductDto, @Path("id") id: String)

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id: String)
     ```