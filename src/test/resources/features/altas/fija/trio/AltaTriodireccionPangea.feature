#language: es

@BERSERKERS @DoneDevOps @DoneDevOpsPI14

Característica: Alta trio con direccion pangea

  Antecedentes:
    Dado     que abro la pagina de movistar

  @Altatriopangea

  Escenario: Alta trio Por Call Center con direccion pangea
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "jpachaot"
    Y        ingreso el password "$t3l3f0n1c4$"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        valido que se presente la tienda "CANAL ONLINE-CALL CENTER GSS"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "102226624"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | Juan    | Lopez Anibal | masculino |
    Y        valido que muestre el nombre completo del cliente "Juan Lopez Anibal"
    Y        selecciono el boton Linea Nueva Hogar
    Y        presiono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150132"
    Y        ingreso la direccion donde sera la instalacion "jr las calendulas 1756"
    Y        ingreso la referencia de la direccion "casa naranja"
    Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar de instalacion
      #| mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      #| A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono en linea Nueva
    #Y        selecciono tipo de oferta
    #Y        selecciono el tipo de plan fija "Trío"
    #Y        selecciono el plan "TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22"
    Y        valido que este en la seccion de registro
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Casado      | Alemania     |
    Y       doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

