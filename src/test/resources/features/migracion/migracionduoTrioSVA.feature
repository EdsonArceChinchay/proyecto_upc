#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT065
##GDAP: GDAP-605
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 12/03/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @RegresionPangea @Sanity28 @DROP-G05 @RegresionLegacy
Característica: AT-DT065_Migracion de Duo (TV + Internet) a Trio + SVA con documento CE por canal Call Center

  @MigracionduoTrioSVACC @MVP07 @Global @General
  Esquema del escenario:Migracion de Duo a Trio + SVA por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
	#Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro pop up de CU
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
	#Y       verifico la direccion "SAN MIGUEL,LIMA ,LIMA" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
	#Y        doy click en agregar "<sva>"
    Y        doy click en Agregar Sva
    Y        seleccionamos agregar Bloque HBO
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo           | sva                   | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | plan                              |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1042464612 | correo@gmail.com | PACK ANTIVIRUS MCAFEE | MARIBEL     | JOSE        | SULLANA     | Trío          | TRIO MOV. VOZ INT. ESTANDAR HD RA |
