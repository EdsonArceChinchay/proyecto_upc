#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1233
##SPRINT CREADO: PI14_SP
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 04/04/2024
@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28 @AltaMovil
Característica: Alta Movil postpago con equipo con documento CE por canal Call Center

  @AltaMovilPostpagoEquipoCallCenter
  Esquema del escenario: Alta movil Prepago + Equipo por call center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    #Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "<planMovil>"
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    Y        ingreso el tiempo de permanencia"<timpoPermanencia>"
    Y        ingreso el tipo de pago "<tipoPago>"
    Y        busco el equipo "<nombreEquipo>"
    Y        doy click en el boton seleccionar
    Y        selecciono la cartilla Linea Nueva
    Y        selecciono el boton de iniciar registro
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 01/10/1990 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Entonces doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor | tipoDocumento | documento   | planMovil           | tipoPlanes | departamento | provincia | distrito | direccion                         | referencia | timpoPermanencia | nombreEquipo                      | tipoPago   |
      | usuario externo | userNameST | passST   | Bienvenid@ | CAJAMARCA    | CE            | 10424647821 | RV Plan Mi Movistar | Postpago   | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | INKAFARMA  | Sin permanencia  | SAMSUNG GXY A34 NEGRO A346M 128GB | Al Contado |
