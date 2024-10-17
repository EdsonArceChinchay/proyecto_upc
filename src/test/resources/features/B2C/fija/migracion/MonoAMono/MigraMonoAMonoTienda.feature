#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT103
##GDAP: GDAP-968
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @AT-DT103
Característica: AT-DT103_Migracion de Mono a Mono por el canal Tienda

  @MigracionMonoAMono_CallCenter
  Esquema del escenario: Migracion de Mono a Mono en canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA PE" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y         doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | channelType | tipoDocumento | documento | correo            | tipoPlanHogar | plan                              |
      | usuario externo | userNameST | passST   | Bienvenid@ | Tienda      | CE            | 77654579  | prueba@prueba.com | Mono          | INTERNET MOVISTAR RA M23 600 MBPS |