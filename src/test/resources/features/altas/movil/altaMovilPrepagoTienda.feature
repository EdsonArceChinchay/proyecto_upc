#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT028
##GDAP: GDAP-587
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G04 @AltaMovil
Característica: AT-DT028_Alta Movil Prepago documento CE por Canal Tienda

  @AltaMovilPrepagoSoloChipTienda_CE
  Esquema del escenario: Alta Movil Prepago con nuevo cliente con documento CE en Canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Prepago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono la oferta de plan movil "<oferta>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        selecciono el boton de iniciar registro
    Y        ingreso un correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/1990 | soltero     | Albania      | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        presiono continuar
#    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor | tipoDocumento | documento  | oferta       | nombrePlan |
      | usuario externo | userNameST | passST   | Bienvenid@ | CAJAMARCA    | CE            | 1942354781 | PLAN PREPAGO | Preplan    |
