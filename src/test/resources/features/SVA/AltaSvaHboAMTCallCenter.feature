#language: es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-1435
##SPRINT CREADO: PI18_SP2
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 30/01/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI18 @AltaSVA @RegresionLegacy
Característica: AT-DT _ Alta SVA a un MT con documento CE en canal Call Center

  @SvaMTCE_CC
  Esquema del escenario: Alta SVA a un MT con documento CE en canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono la linea con numero "14353126"
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "ACTUALIZAR DIRECCION"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Y        me muestra la pantalla de ofertas sugeridos
    Y        selecciono boton mantener plan
    Y        doy click en el boton Agregar SVA
    Y        agrego SVA bloque "HBO"
    Y        doy click en el boton Guardar cambios
    Cuando   doy clic a iniciar registro
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
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento  | correo           |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1042464591 | test@hotmail.com |