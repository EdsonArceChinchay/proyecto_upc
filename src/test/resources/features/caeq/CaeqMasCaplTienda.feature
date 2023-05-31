#language:es

##CREADOR: Edson Arce
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT047
##GDAP: GDAP-892
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: UNICA VEZ
##ENCARGADO: Edson Arce
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT047_CAEQ + capl permanencia 12 meses con CEX Canal Tienda


  @CaeqMasCaplTienda @MVP20 @Global
  Esquema del escenario:CAEQ + capl upsell postpago, financiamiento y permanencia 12 meses con CEX , en canal tienda,web front end, flujo no biométrico
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
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Postpago"
    Y        selecciono la opcion "RV Plan Ilimitado Mi Movistar S/75.90 II"
    Y        doy click en el boton seleccionar oferta
    Y        presiona el boton anadir equipo
    #Y        selecciono tipo de pago Al Contado
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName |
      | 12 meses    | Al Contado | HUAWEI P30 |
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        doy click en iniciar registro
    Y        ingreso un correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tipoDocumento | documento   | tipoPlan | nombrePlan                           |
      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CE            | 12312312222 | Postpago | Plan Movil Movistar Total ilim 26 GB |