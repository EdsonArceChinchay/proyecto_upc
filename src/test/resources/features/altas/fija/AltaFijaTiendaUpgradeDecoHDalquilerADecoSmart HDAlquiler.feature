#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT002
##GDAP: GDAP-579
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP
Característica: AT-DT002_Alta Fija migracion deco HD a Smart HD

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaTiendaMigra_DECOHD_A_DECO_SMART
  Esquema del escenario: alta Fija migracion deco HD a Smart HD
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
	Y        cierro popup de error
    Y        selecciono agregar sva fija
    Y         seleccionamos agregar decodificador Smart HD
    Y        seleccionamos guardar cambios
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
#	Y        ingreso un correo electronico "hola@gmail.com"
#	Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#	Y doy click en validar identidad del titular
#	Y elijo el tipo de validacion a realizar "discapacitado"
#	Y ingreso los datos del supervisor
#	  |numdoc  |user       |password    |
#	  |42770472|rdelatorreg|$t3l3f0n1c4$|
#	Y ingreso los datos solicitados para la validacion del cliente
#	  |nombreMadre|nombrePadre|distritoNac         |
#	  |EMMA    |EDILBERTO    |GUADALUPE|
#	Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           | decoficador |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 102040478 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps | SMART HD    |
