"# proyectoRosa" 
Bases datos:sqlite3.
Tabla tienda.db contiene tres tablas productos, ventas y clientes; las demás tablas son creadas por los triggers, como la tabla devoluciones  al borrar una venta, perdidas al comprobar que  la venta devuelta tiene el producto defectuoso, a venta que vuelve el producto al comprobar estado correcto y al sumarle 1 a la cantidad.
Sólo se puede comprar un producto por día y cliente la clave primaria es el cliente, producto y la fecha; ésto es la lógica del evento en cuestión: Compra a ciegas en donde el participante tendrá que interactuar con sus compañeros de evento.
En la venta es un método el que resta 1 a la cantidad de producto.
No controla pagos ya que el cliente no paga el producto en el momento de la compra sino que es parte de un paquete previo al evento.
Los datos para cargar la base datos se han cargado en Mokaroo.
Usa la clase Filechoose para seleccionar el archivo .json para cargar datos en la tabla usuarios, éste devuelve la ruta que recibe un método gson que devuelve una List<UsuarioLoginDTO> que el método de la clase UsuarioLoginDAO lee y carga en la base de datos.
Crea la tabla usuarios por primera vez y luego cada vez que arranca la aplicación borra todos los datos antes de cargar los nuevos.
Utilidad de la aplicación: Realizar compras y devoluciones y llevar un seguimiento de los productos, mediante opción administración 
muestra los productos vendidos devueltos que no son aptos para vender, mediante la tabla devoluciones vemos los productos(Estado CORRECTO) que han sido devueltos y que al estar en buenas condiciones se han ido de nuevo a ventas.
Tiene una interfaz amigable en dos partes, una de acceso público con información y otra mediante login para efectuar operaciones de venta y referentes.
