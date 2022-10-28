#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Migracion Salto 0 Por Canal Retail

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionsalto0porretail
  Esquema del escenario: Migracion Salto 0 Por Retail
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
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en en el boton "Confirmar direccion"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        Seleccinar boton migrar a fibra
    Cuando   doy clic en iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso email "pruebasqa@gmail.com" y lo confirmo
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
      | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | TALARA       | CE            | 1042465048 | prueba@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | Trío Movistar Voz Internet Estandar HD RA 100 Mbps |
