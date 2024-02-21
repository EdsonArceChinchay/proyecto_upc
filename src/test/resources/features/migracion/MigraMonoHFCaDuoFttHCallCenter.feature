#language:es

##CREADOR: Edson Arce
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT074
##GDAP: GDAP-726
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Edson Arce
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @RegresionPangea @Sanity28
Característica: AT-DT074_Migracion de Mono HFC a Duo FTTH Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionMonoHFCDuoFtthCallCenter @MVP18 @Global @General
  Esquema del escenario: Migración upsell de internet movistar 50Mb HFC a dúo internet TV Estándar HD 200Mb Hacia FTTH , con CEX, en canal call center, web front end, flujo no biométrico
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
  #  Y         presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento | correo            | tipoPlanHogar | plan            |
      | usuario externo | userNameCC | passCC | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 123456744 | tester@tester.com | Duo           | RA D22 200 MBPS |
