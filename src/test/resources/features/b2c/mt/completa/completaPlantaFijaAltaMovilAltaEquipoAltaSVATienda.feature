#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: COMPLETA MOVIL
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-1425
##SPRINT CREADO: PI18_SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##ENCARGADO: CARLOS RUIZ
##FECMOD: 19/01/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT0 _Completa Movil MT (Planta Fija Trio + Alta Movil) + equipo movil + SVA a cliente con CE por canal Tienda

  @CompletaMovilEquipoSVAT
  Esquema del escenario: Completa Movil MT (Planta Fija Trio + Alta Movil) + equipo movil + SVA a cliente con CE por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono el boton de la Linea Hogar Existente "14353026"
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para verificar la direccion
    Y        presiono el boton Confirmar direccion
    Y        selecciono tipo de oferta
    Y        selecciono el plan "<nombrePlan>" Movistar Total
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"Sin permanencia"
    Y        ingreso el tipo de pago "Al Contado"
    Y        busco el equipo "SAMSUNG GXY A34 NEGRO A346M 128GB"
    Y        doy click en el boton seleccionar
    Y        doy click en el boton Ir a movistar total
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA internet "PACK ANTIVIRUS MCAFEE"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nombrePlan | correo           |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 153426984      | Trío       | correo@gmail.com |