#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT096
##GDAP: GDAP-588
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 06/06/2024

@BERSERKERS @AltaMovil
Característica: AT-DT096_Alta Movil Prepago con documento CE por canal Retail

  @AltaMovilPrepagoRetail
  Esquema del escenario: Alta movil prepago combo por retail con nuevo cliente con documento CE
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
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos     | genero    |
      | Jorge   | Blanco Llacza | Masculino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Prepago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<oferta>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/2000 | soltero     | Alemania     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tipoDocumento | documento  | oferta       | nombrePlan |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | CE            | 1042464810 | PLAN PREPAGO | Preplan    |
