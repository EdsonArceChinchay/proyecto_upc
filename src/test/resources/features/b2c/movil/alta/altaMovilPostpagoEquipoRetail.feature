#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT021
##GDAP: GDAP-715
##SPRINT CREADO: PI13_SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI13S4 @AltaMovilEquipo
Característica: AT-DT021_Alta movil postpago + equipo a cliente con CE por canal Retail
  Yo como asesor de Retail
  Quiero hacer un alta combo postpago a un usuario con CE sin parque en movistar

  @altaComboPostpagoRetail
  Esquema del escenario: Alta movil postpago combo por retail a cliente con CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "Retail"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos     | genero    |
      | Jorge   | Blanco Llacza | Masculino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago   | equipoName |
      | sin permanencia | Al Contado | <device>   |
    Y        doy click en el boton seleccionar
    Y        valido que este en la pagina de ofertas sugeridas
    Y        doy click en el boton Linea Nueva
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/2000 | soltero     | Angola       | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito del ticket generado
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Cuando   regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la orden
    Y        doy click en el boton continuar
    E        ingreso el codigo de SIMCARD
    E        ingreso el codigo de IMEI de "<device>"
    Y        doy click Validar Stock
    E        ingreso el numero de caja "123456"
    E        ingreso el numero de ticket "654321"
    Y        doy click en el boton confirmar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | documentType | documentNumber | device                         |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | CE           | 2210464811     | HONOR X8A VERDE CRT-LX3 C/PACK |
