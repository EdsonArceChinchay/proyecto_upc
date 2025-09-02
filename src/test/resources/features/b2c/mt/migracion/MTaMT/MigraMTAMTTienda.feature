#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: MIGRACION
##ESTADO:
##CODIGO:
##GDAP:GDAP-1421
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##ENCARGADO:
##FECMOD: 31/11/2023

@BERSERKERS @DoneDevOps
Característica: Migracion de MT a MT por canal Tienda

  @MigracionMTaMT
  Esquema del escenario: Migracion de MT a MT  en el canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciona el boton del numero del plan MT existente "<numeroMt>"
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "Entendido"
    Y        selecciono el primer tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | correo           | nombrePlan                                     |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1042464680     | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV |
