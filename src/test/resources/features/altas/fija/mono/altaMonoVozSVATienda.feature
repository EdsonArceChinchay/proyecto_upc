#language:es
##CREADOR:  CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-
##SPRINT CREADO: PI18_SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 13/02/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI18SP1 @RegresionDitoC @AltaFija
Característica: AT-DT0_Alta Mono Linea Voz + SVA con documento CE con Canal Tienda

  @AltaMonoVozSVATienda
  Escenario: Yo como asesor de Tiendas realizare un alta Mono Linea Voz a un cliente nuevo con CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameST"
    Y        ingreso el password "passST"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1023560867"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero    |
      | Carlos  | Suarez    | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        completo los datos para consultar la cobertura
      | departamento | provincia | distrito | direccion                   | referencia |
      | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | parque     |
    Y        presiono el boton Consultar Ubicacion
    Y        presiono el boton Consultar Cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "Mono"
    Y        selecciono el plan "LÍNEA MOVISTAR VOZ VOIP"
    Y        doy click en agregar SVA Linea "Plan Multidestino 25"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso telefono de contacto
    Y        presiono el boton Confirmar agendamiento
    Y        ingreso email "test@mail.com" y lo repito
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 24/04/1990 | Casado      | Aruba      |
    Y        doy click en el boton confirmar
    Y        presiono la opcion validar contrato
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
