#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT049
##GDAP: GDAP-590
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: AT-DT049_Cambio de equipo con cambio de SIM por Canal Tienda

  @CambioEquipoConCambioSIM
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo del mismo plan
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName                               |
      | 12 meses    | Al Contado | SAMSUNG GXY A34 NEGRO A346M 128GB C/CAMP |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono boton mantener plan
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy clic en continuar
    #Y        presiono el boton descargar contrato
    #Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tiendaAsesor | tipoDocumento | documento  | cliente       |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | CAJAMARCA    | CE            | 1042465085 | Jasmin Pinedo |
