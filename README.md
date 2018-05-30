"# proyectoRosa" 
Baes datos:sqlite.
Tabla tienda.db. contiene tres tablas productos, ventas y clientes; las demás tablas son creadas por los triggers, como la tabla devoluciones  al borrar una venta, perdidas al comprobar que  la venta devuelta tiene el producto defectuoso, a venta que vuelve el producto a la venta al sumarle 1 a la cantidad.
Los datos para cargar la base datos se han cargado en Mokaroo.
Usa fiechoose para seleccionar el archivo .json para cargar datos en la tabla usuarios, éste devuelve la ruta que recibe un método gson que devuelve una List<UsuarioLoginDTO> que el método de la clase UsuarioLoginDAO lee y carga en la base de datos.
Crea la tabla usuarios por primera vez y luego cada vez que arranca la aplicación borra todos los datos antes de cargar los nuevos.
Utilidad de la aplicación: Ralizar compras y devoluciones y llevar un seguimiento de los productos, mediante opción administración 
muestra los productos vendidos devueltos que no son aptos para vender, mediante la tabla devoluciones vemos los productos(Estado CORRECTO) que han sido devueltos y que al estar en buenas condiciones se han ido de nuevo a ventas.
Tiene una interfaz amigable en dos partes, una de acceso público con información y otra mediante login para efectuar operciones de venta y referentes.
