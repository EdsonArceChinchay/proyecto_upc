#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DTO32
##GDAP: GDAP-575
##SPRINT CREADO: PI12_SP5
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @AltaMovilEquipo
Característica: AT-DT032_Alta movil control + equipo a cliente con CE por canal Tienda

  @AltaMovilcontrolConEquipo
  Esquema del escenario: Alta movil control + equipo a cliente con CE por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos | genero    |
      | Luis    | Lozano    | masculino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "Control"
    Y        selecciono la opcion "RV Plan Mi Movistar"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName               |
      | 12 meses    | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro pop up de CU
    Y        valido que este en la pagina de ofertas sugeridas
    Y        doy click en el boton Linea Nueva
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/08/1994 | soltero     | Angola       | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1024261234     |
