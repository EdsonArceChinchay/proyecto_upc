#language:es
##CREADOR:  HENRY 
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA TRIO
##ESTADO: ACTIVO
##CODIGO: AT-DT017
##GDAP: GDAP-979
##SPRINT CREADO: PI
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 13/02/2024

@BERSERKERS @DoneDevOps @AltaSVABloqueHBO @Sanity28 @DROP @AltaFija @AltaTrio
Característica: AT-DT017_Alta Fija Trio con SVA Bloque HBO a cliente con CE por Canal Tienda

  @AltaTrioSVABloqueHBO
  Esquema del escenario: Alta Tienda Fija Trio con SVA Bloque HBO sin productos asociados sin biometria
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos      | genero    |
      | MOISES  | MENDOZA ZAPATA | MASCULINO |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit |
      |    |              |                |      |     | URBANIZACION RESIDENCIAL | RISSO     |
    Y        presiono el boton Consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que este en el resumen de venta
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA bloque "<bloque>"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1993 | Casado      | Angola       |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | nombrePlan                  | bloque | correo           |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1022102007     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | PISO 1     | TRIO MOV. VOZ INT. ESTANDAR | HBO    | correo@gmail.com |


