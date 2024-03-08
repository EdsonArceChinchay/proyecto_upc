#language:es
##CREADOR: HENRY
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT023
##GDAP: GDAP-584
##SPRINT CREADO: PI12_SP5
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 13/02/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROPG7
Característica: AT-DT023_Alta Movil Control con financiamiento con documento CE por canal Tienda

  @AltaMovilFinaciamientoTienda_CE
  Esquema del escenario: Realizar una alta movil Control con un financiamiento, metodo de entrega por tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero    |
      | Luis    | Lozano    | masculino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "Control"
    Y        selecciono la opcion "RV Plan Mi Movistar S/65.9"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono en linea Nueva
    Y        selecciono el boton de iniciar registro
    Y        ingreso un correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/08/1994 | soltero     | Angola       | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento  |
      | usuario externo | userNameST | passST   | Bienvenid@ | CE            | 1024268237 |

      #    | usuario interno | | | Bienvenid@ | CE            | 1100000255 | Postpago  |
#      | usuario interno | | | Bienvenid@ | CE            | 1100000256 | Postpago  |
   #   | usuario interno | | | Bienvenid@ | CE            | 1100000259 | Postpago  |
#      | usuario interno | | | Bienvenid@ | CE            | 1100000270 | Postpago  |