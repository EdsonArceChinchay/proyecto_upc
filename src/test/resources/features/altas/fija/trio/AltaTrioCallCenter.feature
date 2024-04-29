#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT001
##GDAP: GDAP-570
##SPRINT CREADO: PI11_SP
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 09/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP-G01 @AltaTrio
Característica: AT-DT001_Alta Trio con documento CE por Canal Call Center
  Quiero realizar una alta fija por call center

  @AltaTrioPorCallCenter
  Esquema del escenario: Alta Trio con documento CE por Canal Call Center
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
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | ELOY    | OLIVERA CANO | MASCULINO |
    Y        valido que muestre el nombre completo del cliente "ELOY OLIVERA CANO"
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150136"
    Y        ingreso la direccion donde sera la instalacion "Calle Condesa de Chinchon 107"
    Y        ingreso la referencia de la direccion "casa naranja"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO     | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
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
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento | tipoPlan | nombrePlan                  |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 100014564 | Trío     | TRIO MOV. VOZ INT. ESTANDAR |
