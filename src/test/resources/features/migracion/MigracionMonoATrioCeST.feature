#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-1659
##SPRINT CREADO: PI18_SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 12/03/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI18 @RegresionLegacy
Característica: AT-DT0 _Migracion de Mono a Trio con documento CE en canal Tienda

  @migracionMonoATrioCeST
  Esquema del escenario: Migracion de Mono a Trio con documento CE en canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
#    Y        cierro popup de aviso
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
#    Y        verifico la direccion "" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<planTrio>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "test.auto@gmail.com"
    Y        ingreso nuevamente el correo electronico "test.auto@gmail.com"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento | tipoPlanHogar | planTrio                                            |
      | usuario externo | userNameST | passST   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 202300014 | Trío          | TRÍO MOVISTAR VOZ INTERNET ESTANDAR HD RA 1000 MBPS |