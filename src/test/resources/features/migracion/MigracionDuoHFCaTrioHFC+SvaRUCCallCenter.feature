#language:es

Característica: Migracion de Duo HFC a Trio HFC + Sva Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionDuoTrioRUCCallCenter
  Esquema del escenario: Migración Upsell Dúo voz + internet 30mbps con tecnología HFC a Trío 50 Mbps con tecnología HFC + SVA pla multidestino, con ruc, en call center, con flujo biometrico
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    #Y        valido que me traiga los servicios contratados por el cliente
    #Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA" actual del servicio
    Y        doy click en en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    Y        doy click en agregar "<sva>"
    #Y         doy clic en agregar sva "<Bloque>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento para RUC
    #Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic en el boton validar identidad representante legal
   # Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
   # Y        ingreso los datos del supervisor
    #  | numdoc   | user        | password     |
    #  | 42770472 | rdelatorreg | $t3l3f0n1c4$ |
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombreMadre   | nombrePadre   | distritoNac   |
      | DEYSI | JOSE | SULLANA |
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y       doy click en Finalizar registro
   # Y        doy click en el boton de continuar
  #  Y         presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName    | password     | msgHome      | tipoDocumento | documento|nro |tipoDocRepLegal|numDocRepLegal | correo            | tipoPlanHogar | plan        | sva                   |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@  | RUC            | 20513763663  |1   |DNI            |75448228 | tester@tester.com | TRIO           | RA 70 MBPS | Seguridad Total Residencial |
