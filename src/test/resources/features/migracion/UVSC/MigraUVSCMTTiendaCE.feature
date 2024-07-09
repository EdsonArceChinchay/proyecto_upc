#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP:GDAP-
##SPRINT CREADO: PI20_SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 02/07/2024
@BERSERKERS  @DoneDevOps @PI20_SP1 @MigraUVSC
Característica: Migracion UVSC MT con documento CE canal Tienda

  @MigraUVSCTiendaCE
  Esquema del escenario: Migracion UVSC MT con documento CE canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
	#Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        Selecciono la cartilla del plan Motvistar Total
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "" actual del servicio
    Y        doy click en el boton "ACTUALIZAR DIRECCION"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        valido que se muestre la etiqueta "Fibra+Velocidad, COSTO 0"
    Y        valido que los precio de plan hogar y plan mensual sean los mismos
    Y        luego doy click en la cartilla ir a Movistar Total
    Y        valido que este en el resumen de venta
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo           |
      | usuario externo | userNameST | passST   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 9876188171 | correo@gmail.com |
