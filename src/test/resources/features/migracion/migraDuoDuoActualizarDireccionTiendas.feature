#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI14SP3

Característica: Migracion de Duo a Duo - Actualizar Dirección, por el canal Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionDuoTrioActualizarDireccionTiendas
  Esquema del escenario: Migracion de Duo a Trio con CE  sin productos asociados sin biometria
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
#    Y        cierro popup de aviso
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "JR,JULIO CESAR TELLO,469,LINCE,LIMA ,LIMA,PE" actual del servicio
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la direccion donde sera la instalacion "JOSE LEAL 500"
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        valido que se presente el siguiente mensaje "Se actualizo la dirección del servicio correctamente"
    Y        doy click en el boton "Entendido"
    #Y        Doy click en el boton "Entendido"
    Y        seleccion plan nuevo para ver las ofertas
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<planTrio>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                  |

      | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1042465127 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | DÚO INTERNET ESTÁNDAR HD RA D22 200 MBPS |
