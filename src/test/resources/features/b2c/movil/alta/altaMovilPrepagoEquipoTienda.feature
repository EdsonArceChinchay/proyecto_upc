#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT030
##GDAP: GDAP-585
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROPG3 @AltaMovilEquipo
Característica: AT-DT030_Alta Movil Prepago + Equipo a cliente con CE por canal Tienda

  @AltaMovil_Equipo_tienda @Sanity28
  Esquema del escenario: Alta Movil Prepago + Equipo a cliente con CE por canal Tienda
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
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Prepago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono el boton de eleccion de planes
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        doy click en el boton Linea Nueva
    Y        selecciono añadir equipos
    Y        busco el equipo "<nombreEquipo>"
    Y        ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y        ingreso el tipo de pago "<tipoPago>"
    Y        doy click en el boton seleccionar
    Y        valido que este en la pagina de ofertas sugeridas
    Y        doy click en el boton Linea Nueva
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                |
      | 20/08/1996 | soltero     | Albania      | LIMA         | LIMA      | LINCE    | JR JULIO CESAR TELLO 469 |
    Y        doy click en el boton confirmar
    Entonces doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | tipoPlanes | timpoPermanencia | nombreEquipo                      | tipoPago             |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1012454448     | Prepago    | Sin permanencia  | SAMSUNG GXY A34 NEGRO A346M 128GB | Financiado 12 cuotas |
