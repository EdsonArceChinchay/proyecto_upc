#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO:
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT031
##GDAP: GDAP-959
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Angel Medina
##FECMOD: 09/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP-G05 @AltaMovil
Característica: AT-DT031_Alta Movil Postpago con documento CE por Canal Retail

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MVP_Alta_movil_SoloSim_CanalRetail @MVP01 @Global
  Esquema del escenario: Realizar alta móvil solo línea postpago en canal retail, en web FE, con CEX, flujo no biométrico
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres  | apellidos      | genero   |
      | Teresita | Collasos Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono el boton de eleccion de planes
    Y        seleccion oferta Postpago
    Y        selecciono un plan movil "<nombrePlan>"
    Y        selecciono el boton de iniciar registro
    Y        ingreso un correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/1980 | Casado      | Albania      | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        presiono continuar
  #  Y        presiono el boton descargar contrato
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tipoDocumento | documento   | nombrePlan                              |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | CE            | 12094544006 | RV Plan Ilimitado Mi Movistar S/ 74.9 V |