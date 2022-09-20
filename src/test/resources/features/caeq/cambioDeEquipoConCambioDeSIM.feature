#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: Cambio de equipo con cambio de SIM x Tienda FE DITO WEB

  @CambioEquipoConCambioSIM
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    Y        selecciono tipo de pago Al Contado
    Y        presiono el boton seleccionar
    Y        selecciono boton mantener plan
    Y        Selecciono boton Cambiar Chip
    Y        doy click en iniciar registro
    #Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido


    Ejemplos:
      | tipoUsuario     | userName     | password       | msgHome    | tiendaAsesor  | tipoDocumento | documento | cliente                         |
      | usuario externo | vsiguass     | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA     | CE            | 1042465085  | Jasmin Pinedo       |
