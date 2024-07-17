#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD: PORTABILIDAD
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-890
##SPRINT CREADO: PI19_SP2
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 22/04/2024
@BERSERKERS @DoneDevOps
Característica: AT-DT_Portabilidad Directa solo chip postpago en canal Tienda

  @PortaDirectaPostST
  Esquema del escenario: Portabilidad solo chip postpago en canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#  Y        valido que se presente la tienda "<tiendaAsesor>"
    Y        valido que este activo el flag de Porta Directa
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        doy click en el boton portabilidad
    Y        cierro el popup de contraseña Única
    Y        selecciono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<numero>"
    Y        escojo tipo de linea "<tipoLinea>"
    Y        escojo tipo de operador "<operador>"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido que este en la seccion Postpago o Prepago
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        selecciono añadir equipos
    Y        selecciono tipo de pago Al Contado
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName               |
      | 12 meses    | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro pop up de CU
    Y        valido que este en el resumen de venta
    Y        doy click en iniciar registro
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso un correo electronico "jlopez@mail.com"
    Y        ingreso nuevamente el correo electronico "jlopez@mail.com"
    Y        doy click en el boton Validar Codigo de Portabilidad
    Y        doy click en "Activa" y doy click en el boton Confirmar
    Y        obtengo el token
      | typeDocument    | numberDocument | numberPhone |
      | <tipoDocumento> | <documento>    | <numero>    |
    Cuando    ingreso el token y doy click en el boton Confirmar
    Entonces  valido el mensaje "Código valido" y doy click en el boton Continuar
    Y        doy click en validar identidad del titular
    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    Y        ingreso los datos del supervisor
      | numdoc   | user     | password     |
      | 73261531 | vsiguass | $t3l3f0n1c4$ |
#    Y        doy click en el boton continuar
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    #Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento | numero    | tipoLinea | operador           | tipoPlanMovil | nombrePlan                    | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
      | usuario externo | userNameST | passST   | Bienvenid@ | DNI           | 42565073  | 920956351 | Postpago  | OPERADOR DE PRUEBA | Postpago      | RV Plan Ilimitado Mi Movistar | discapacitado  | ERMINIA     | APOLONIO    | LURIN       |