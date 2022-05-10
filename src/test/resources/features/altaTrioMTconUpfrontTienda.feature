#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

 Característica: Alta Trio MT - Upfront Tienda

   @AltaTriomt
   Esquema del escenario: Alta trio Mt
      Dado     que abro la pagina de movistar
      Cuando   presiono el boton Iniciar Sesion
      Y        selecciono el tipo de usuario "<tipoUsuario>"
      Y        ingreso el usuario "<userName>"
      Y        ingreso el password "<password>"
      Y        presiono el boton Continuar hacia el home
      Entonces valido el login exitoso mediante el mensaje "<msgHome>"
      Y        valido que se presente la tienda "<tiendaAsesor>"
      Y        selecciono el tipo de documento "<tipoDocumento>"
      Y        ingreso el documento "<documento>"
      Y        doy click en el boton consultar
      Y        doy click en el boton linea nueva
      Y        selecciono el boton Mostrar ofertas
      Y        selecciono el departamento donde sera la instalacion "<departamento>"
      Y        selecciono la provincia donde sera la instalacion "<provincia>"
      Y        selecciono el distrito donde sera la instalacion "<distrito>"
      Y        ingreso la direccion donde sera la instalacion "<direccion>"
      Y        ingreso la referencia de la direccion "<referencia>"
      Y        presiono el boton Consultar ubicacion
      Y        ingresamos la Manzana o bloque "<mz>"
      Y        ingresamos el Lote "<lote>"
      Y        ingresamos el Piso "<piso>"
      Y        ingresamos el interior "<int>"
      Y        ingresamos el Tipo de conjunto habitacional "<conjunto>"
      Y        ingresamos el Nombre del conjunto habitacional "<conjHabit>"
      Y        doy click en el boton consultar cobertura
      Y        doy click en el boton Ir a movistar total
      Y        presiono el boton iniciar registro
     # Y        selecciono la fecha de instalacion
      Y        ingreso telefono del contacto "<numContacto>"
      Y        doy click en el boton confirmar
      Y        valido detalles de instalacion
      Y        confirmo el registro de instalacion
      Y        ingreso el correo electronico "<correoElectronico>"
               |correoElectronico|
               |eloy.m@gmail.com |
      Y        vuelvo ingresar el correo electronico "<vuelveIngresarCorreo>"
      Y        doy click en el boton validar identidad del titular
      Y        doy click en discapacitado o huella desgastado
      Y        selecciono tipo de documento del supervisor "<tipoDoc>"
      Y        ingreso el numero de documento del supervisor "<documentoSuperv>"
      Y        presiono el boton confirmar
      Y        ingreso usuario citrix de supervisor "<user>"
      Y        ingreso contraseña de supervisor "<passw>"
      Y        presiono el boton confirmar

    Ejemplos:
      |tipoUsuario    |userName    |password      |msgHome   |tiendaAsesor      |tipoDocumento |documento |departamento|provincia|distrito|direccion                    |referencia |mz|lote|piso|int|conjunto|conjHabit|numContacto|correoElectronico|vuelveIngresarCorreo|
      |usuario externo|lterrazosce |Telefonica2021|Bienvenid@|TIENDA SAN MIGUEL |DNI           |74414332  | 15         |1501     |150101  |Calle Condesa de Chinchon 107| real plaza|a |2   |2   |1  |UR      |casa     |942434295  |eloy.m@gmail.com |eloy.m@gmail.com    |