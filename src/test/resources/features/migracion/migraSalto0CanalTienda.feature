#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT078
##GDAP: GDAP-717
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: VICTOR CARPIO
##FECMOD: 10/01/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI13 @DROP

Característica: AT-DT078_Migracion salto 0 canal Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migraSalto0CanalTienda
  Esquema del escenario: Migracion salto 0 con CE  por canal tienda
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Confirmar direccion"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono la opcion Migrar a fibra
    Cuando   doy clic en iniciar registro
    Y        valido que muestre la pantalla de Agendamiento
    #Y        ingreso datos de agendamiento "987654321" y doy clic en continuar
    #Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tipoDocumento | documento | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
     # | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CE            | 123456778 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
      | usuario interno |  | | Bienvenid@ | CE            | 1100000200 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |