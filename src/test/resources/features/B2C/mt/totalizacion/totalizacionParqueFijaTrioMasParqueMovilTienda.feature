#language:es
##CREADOR:CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT0
##GDAP:  GDAP-1429
##SPRINT CREADO: PI18_SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:CARLOS RUIZ
##FECMOD: 19/01/2024

@BERSERKERS @DoneDevOps @TEST1
Característica: AT-DT0 _ Totalizacion Parque Fija Trio + Parque Movil con documento CE en Tienda

  # Se debe de validar que no tenga ordenes en vuelo antes de ejecutar el feature
  @TotalizacionCEST
  Esquema del escenario: Totalizacion Parque Fija Trio + Parque Movil con documento CE en Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    #Y        valido que muestre el nombre completo del cliente "<nombreCliente>"
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton de la Linea Movil Existente
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para verificar la direccion
    #Y        presiono el boton Confirmar direccion
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "casa"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "entendido"
    Y        selecciono tipo de oferta
    Y        selecciono el plan "<nombrePlan>" Movistar Total
    Y        doy click en el boton Ir a movistar total
    Y        valido que este en el resumen de venta
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento  | nombrePlan | correo         |
      | usuario externo | userNameST | passST   | Bienvenid@ | Tiendas Franquicia Prueba | CE            | 1042464696 | Trío       | test@gmail.com |

