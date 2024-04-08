#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: EN REVISION
##CODIGO: AT-DT048
##GDAP: GDAP-580
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CRISTIAN HUNGARO
##FECMOD: 05/02/2024
##COMENTARIO: FALTA COMPLETAR EL PEDIDO

@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: AT-DT048_Caeq Por Tienda FE DITO WEB

  @CaeqCEPorTienda
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    Y        selecciono tipo de pago Al Contado
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName |
      | 12 meses    | Al Contado | VIVO   |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro pop up de CU
    Y        doy click en el boton "Mantener Plan"
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
   # Y        doy click en ver detalle del pedido
   # Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento  |
      | usuario externo | userNameST | passST   | Bienvenid@ | CE            | 1042465085 |


    #1042465085
