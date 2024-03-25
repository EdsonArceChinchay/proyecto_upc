#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1164
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023
@BERSERKERS @DoneDevOps
Característica: Migracion de Mono internet a Mono internet con Actualizar Direccion por el canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigracionMonoInternetAMonoInternetActualizarDireccion_CallCenter
  Esquema del escenario: Migracion de Mono internet a Mono interner con Actualizar Direccion en canal Call Center
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "JR, Julio Cesar tello, 469, LINCE, LIMA , LIMA, PE" actual del servicio
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la direccion donde sera la instalacion "Jose Leal 500"
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        valido que se presente el siguiente mensaje "Se actualizo la dirección del servicio correctamente"
    Y        doy click en el boton "Entendido"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    Cuando   doy clic a iniciar registro
    #Y        valido que me encuentre en la pantalla agendamiento
    #Y        ingreso los datos de agendamiento
    Y        ingreso un correo electronico "prueba@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba@gmail.com"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido


    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tipoDocumento | documento  | tipoPlanHogar | plan
      | usuario externo | userNameCC | passCC | Bienvenid@ | CE            | 1042464839 | Mono          | INTERNET MOVISTAR RA D22 600