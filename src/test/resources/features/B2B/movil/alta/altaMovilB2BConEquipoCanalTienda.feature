#language:es
##CREADOR: Eloy Milla
##APP: DITO
##MODULO: Alta Movil B2B
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:AT-DT
##GDAP: GDAP-1662
##SPRINT CREADO: PI19_SP1
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:REUSABLE
##ENCARGADO: Eloy Milla
##FECMOD: 08/04/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT Alta Movil B2B con permanencia 18 meses + equipo con Representante Legal Extranjero en Canal Tienda
  Quiero realizar un alta movil + equipo a un cliente B2B con Representante Legal Extranjero en Canal Tienda

  @altaMovilB2BCETienda
  Esquema del escenario: Alta movil B2B con permanencia 18 meses + Equipo con Representante Legal Extranjero en Canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName               |
      | 18 meses    | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        doy click en el boton seleccionar
    Y        selecciono la cartilla Linea Nueva
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento   | nro | tipoDocRepLegal | numDocRepLegal | correo            |
      | usuario externo | userNameST | passST   | Bienvenid@ | RUC           | 20000000003 | 1   | C               | 143625134      | prueba@prueba.com |
