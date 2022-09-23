#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Migracion de Duo a Trio por el canal Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionDuoATrioTienda
  Esquema del escenario: Migracion de Duo a Trio con CE  sin productos asociados sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "JULIO CESAR TELLO,469,LINCE,LIMA" actual del servicio
    Y        doy click en en el boton "Confirmar direccion"
    Y        seleccion plan nuevo para ver las ofertas
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<planTrio>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
<<<<<<< HEAD
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1234543225  | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
=======
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1042464995 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
>>>>>>> e0734e8708670a2936373cd6384b2f19005dd13e
