#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT003
##GDAP: GDAP-592
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: MARIA SANCHEZ
##FECMOD: 21/09/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP-G02 @AltaTrio
Característica: AT-DT003_Alta Trio con documento CE por Canal Retail

  @AltaTrioRetail
  Esquema del escenario: Alta Trio con documento CE por Canal Retail
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
      | PEDRO   | GARCIA ZAPATA | MASCULINO |
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
    # | mz  | tipoVivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
    # | A  | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy click en el boton Iniciar registro
    Entonces valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 03/10/1990 | Casado      | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                  |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 1042464816 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | casa crema | Trío     | TRIO MOV. VOZ INT. ESTANDAR |

