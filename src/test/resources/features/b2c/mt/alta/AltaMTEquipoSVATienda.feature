#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA
##ESTADO:
##CODIGO: AT-DT
##GDAP: GDAP-1427
##SPRINT CREADO: PI17-SPI
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 05/07/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI17  @AltaMTSVA
Característica: AT-DT0 _Alta MT (Alta fija + alta movil) + Equipo Movil + SVA a cliente con CE por canal Tienda

  @AltaMTEquipoSVA
  Esquema del escenario: Alta MT (Alta fija + alta movil) + Equipo Movil + SVA a cliente con CE por canal Tienda
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
      | nombres     | apellidos    | genero   |
      | Maria Luisa | Perez Zapata | Femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<planType>"
    Y        selecciono un plan Movistar Total "<planName>"
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"Permanencia de 12 meses"
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
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 11/02/1990 | Casado      | Albania      |
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
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | planType | planName | correo           |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 991000232      | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | INKAFARMA  | Trío MT  | Trio HD  | correo@gmail.com |