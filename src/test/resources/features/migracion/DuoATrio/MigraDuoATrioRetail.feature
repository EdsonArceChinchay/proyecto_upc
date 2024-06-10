#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT102
##GDAP: GDAP-963
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity @Sanity28
Característica: AT-DT102_Migracion de Duo a Trio por el canal Retail

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionDuoATrioRetail
  Esquema del escenario: Migracion de Duo a Trio con CE Retail
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
#    Y        cierro popup de aviso
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
#    Y        verifico la direccion "JR,JULIO CESAR TELLO,169,LINCE,LIMA ,LIMA,PE" actual del servicio
#    Y        doy click en el boton "Confirmar direccion"
    Y        doy click en el boton "Confirmar direccion"
    Y        seleccion plan nuevo para ver las ofertas
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<planTrio>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor      | tipoDocumento | documento | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar | planTrio                                           |
      | usuario externo | userNameST | passST | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 253462454 | correo@gmail.com | discapacitado  | MARIBEL     | JOSE        | SULLANA     | Trío          | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA M23 600 MBPS |

