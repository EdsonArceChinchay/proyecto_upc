#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT046
##GDAP: GDAP-712
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: AT-DT046_Caeq Mas Capl Mas Casi por call center

  @CaeqCaplCasi
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    #Y        cierro popup de error
    #Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    #Y        selecciono el boton Mostrar ofertas
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    Y        selecciono tipo de pago Al Contado
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName |
      | 12 meses    | Al Contado | SAMSUNG    |
    Y valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        Selecciono boton Cambiar Chip
    Y        doy click en iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "conjunto b"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Lopez  | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "956756143"
    Y        ingreso las instrucciones a considerar de la entrega "abc"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
#    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento  | tipoPlan | nombrePlan                     |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1042464721 | Postpago | Plan Movil Movistar Total ilim |