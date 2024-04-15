#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-1434
##SPRINT CREADO: PI18_SP2
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 12/03/2024

@BERSERKERS @DoneDevOps @RegresionLegacy

Característica: AT-DT0 _Completa Planta Movil  + Alta Fija con documento CE en Canal Call Center

  @CompletaMovilCC
  Esquema del escenario: Completa Planta Movil + Alta Fija con documento CE en Canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono el boton de la Linea Movil Existente
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JR JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "INKAFARMA"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el plan "<nombrePlan>" Movistar Total
    Y        doy click en el boton Ir a movistar total
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento  | nombrePlan                                | correo         |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1632547925 | Trío HD 600 Mbps RV + Ilimitado 135 Gb RV | test@gmail.com |
#      | usuario interno || | Bienvenid@ | PRUEBAS SIST CALL IN VENTA | CE            | 1100000307 | Trío HD 600 Mbps RV + Ilimitado 95 Gb RV | test@gmail.com |
#      | usuario interno || | Bienvenid@ | PRUEBAS SIST CALL IN VENTA | CE            | 1100000312 | Trío HD 600 Mbps RV + Ilimitado 95 Gb RV | test@gmail.com |