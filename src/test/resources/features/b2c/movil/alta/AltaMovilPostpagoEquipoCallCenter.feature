#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT026
##GDAP: GDAP-586
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28 @DROP-G03 @AltaMovilEquipo
Característica: AT-DT026_Alta movil Postpago + Equipo con Delivery por Canal Call Center

  @AltaMovilPostPagoDeliveryCallCenter
  Esquema del escenario: Alta movil Postpago por Call Center con CE sin productos asociados sin biometria
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Entonces ingreso los datos del nuevo cliente
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "<planMovil>"
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    Y        busco el equipo "<nombreEquipo>"
    Y        ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y        ingreso el tipo de pago "<tipoPago>"
    Y        doy click en el boton seleccionar
    Y        doy click en el boton Linea Nueva
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Entonces me muestra la pantalla de Delivery de linea nueva
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso telefono de contacto "658745259"
    Y        ingreso instrucciones de delivery "En la cuadra 8 a la derecha"
    Y        doy click en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Entonces doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documentNumber>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito   | direccion                     | referencia | tipoPlanes                    | planMovil | timpoPermanencia | nombreEquipo             | tipoPago   |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1022420045     | LIMA         | LIMA      | SAN MIGUEL | Calle Condesa de Chinchon 107 | Casa       | RV Plan Ilimitado Mi Movistar | Postpago  | Sin permanencia  | VIVO V21 NEGRO 5G C/PACK | Al Contado |