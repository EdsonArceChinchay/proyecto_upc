#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT042
##GDAP: GDAP-595
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G04 @prueba
Característica: AT-DT042_Alta MT (Alta Fija + Alta Movil) con documento CE por canal Tienda

  @AltatrioMT_SVA
  Esquema del escenario: Alta MT (Alta Fija + Alta Movil) con documento CE por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y     valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos   | genero    |
      | Juan    | Ortiz Lopez | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar de instalacion
     # | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      #| A  | EDIFICIO | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | parque   |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
#    Y        selecciono el nombre de plan movistar total
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA internet "PACK ANTIVIRUS MCAFEE"
    Y        doy click en el boton Guardar cambios
    Y       doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | nacionalidad | estadoCivil |
      | 12/12/1980 | Aruba        | Casado       |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    #Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:

      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion             | referencia | tipoPlan | nombrePlan |
      | usuario externo | userNameST | passST   | Bienvenid@ | CAJAMARCA    | CE            | 1042464714 | 15           | 1501      | 150116   | JULIO CESAR TELLO 469 | INKAFARMA  | Trío     | Trio       |


