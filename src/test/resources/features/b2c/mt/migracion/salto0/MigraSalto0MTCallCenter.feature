#language:es
##CREADOR: Eloy Milla
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: MIGRACION
##ESTADO: ACTIVO
##CODIGO:
##GDAP:GDAP-1437
##SPRINT CREADO: PI18_SP2
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##ENCARGADO:
##FECMOD: 19/01/2024

@BERSERKERS @DoneDevOps
Característica: Migracion salto 0 MT (Cambio de tecnologia HFC a FTTH) a cliente con CE por canal Call Center

  @migraSalto0MTCallCenter @RegreDito
  Esquema del escenario: Migracion salto 0 MT a cliente con CE por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan MT
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "casa"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "entendido"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        doy click en el boton Migrar a fibra
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "automation@gmail.com"
    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 42721738009    |
