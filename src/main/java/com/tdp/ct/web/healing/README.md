# Auto-Healing System - README

![Status](https://img.shields.io/badge/Status-Production%20Ready-brightgreen)
![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)

## 📌 ¿Qué es Auto-Healing?

Un sistema inteligente que **detecta y se recupera automáticamente** de fallos en la localización de elementos web. Cuando un selector principal falla, el sistema prueba múltiples alternativas sin detener la ejecución.

## 🎯 Datos Técnicos

| Propiedad | Valor |
|-----------|-------|
| **Versión** | 1.0.0 |
| **Fecha** | 2026-07-13 |
| **Estado** | Production Ready |
| **Lenguaje** | Java 11+ |
| **Framework** | Selenium 4.x + Cucumber + Spring Boot |
| **Licencia** | Propietaria |

## 📦 Componentes

### Core Components
```
src/main/java/com/tdp/ct/web/healing/
├── AutoHealingManager.java         # Manager principal del sistema
├── HealablePageObject.java         # Clase base para PageObjects
├── HealingReporter.java            # Generador de reportes
└── HealingAspect.java             # Aspecto AOP (opcional)
```

### Examples & Tests
```
src/test/java/com/tdp/ct/web/
├── page/healing/
│   └── LoginBerserkerPageHealed.java    # Ejemplo de PageObject
├── step/healing/
│   └── LoginStepHealing.java            # Ejemplo de Step Definition
└── healing/test/
    └── AutoHealingDemoTest.java         # Demostración del sistema
```

## 🚀 Quick Start

### 1. Crear un PageObject con Auto-Healing

```java
public class MyPage extends HealablePageObject {
    
    public MyPage(WebDriver driver) {
        super(driver);
    }
    
    @Override
    protected void registerLocators() {
        // Localizador primario
        registerLocator("submitButton", By.id("btn-submit"));
        
        // Alternativas
        registerAlternatives("submitButton", new By[]{
            By.xpath("//button[@type='submit']"),
            By.css("button.submit-btn")
        });
    }
    
    public void submit() {
        findWithHealing("submitButton").click();
    }
}
```

### 2. Usar en Step Definition

```java
@When("presiono submit")
public void pressSubmit() {
    page.submit();  // (con auto-healing automático)
}

@After
public void tearDown() {
    HealingReporter.printStatistics();
}
```

### 3. Generar Reportes

```java
HealingReporter.generateHealingReport("target/healing-report.txt");
HealingReporter.generateHealingReportHTML("target/healing-report.html");
HealingReporter.generateHealingReportPDF("target/reports/healing-report.pdf");
```

El PDF se genera localmente, sin conectarse a un servidor, y contiene el AHSR, los
intentos de reparacion exitosos y fallidos, la estrategia y el localizador original,
ademas del tiempo estimado ahorrado. El AHSR se calcula sobre los intentos de
auto-healing (no sobre las busquedas que encontraron el localizador original). El
contenido del PDF se presenta en español.

Por defecto, cada reparacion exitosa representa 15 minutos ahorrados. Para ajustar
la estimacion y solicitar el reporte al finalizar el runner:

```shell
mvn verify -Dhealing.report.pdf=target/reports/healing-report.pdf -Dhealing.report.minutes-per-repair=20
```

Tambien se puede pasar la estimacion directamente:

```java
HealingReporter.generateHealingReportPDF("target/reports/healing-report.pdf", 20);
```

La generacion es opcional: el runner crea el PDF al finalizar el ciclo solo si
se define `healing.report.pdf`. El archivo queda disponible en la ruta local
indicada. Tambien se puede invocar el metodo directamente cuando no se usa el
runner.

En Jenkins, configura las instalaciones de herramientas `JDK11` y `Maven3`,
ademas de las credenciales que ya utiliza el pipeline. El `Jenkinsfile` ejecuta
`mvn clean verify` con ese JDK, el tag de Cucumber elegido y archiva los reportes
del build, incluido el PDF. Si el archivo se genero, tambien lo envia adjunto a
`earcechin@gmail.com` mediante el plugin Email Extension. Configura el plugin y
el servidor SMTP saliente en Jenkins (Manage Jenkins > System) para habilitar el
envio.

## 📊 Estrategias de Recuperación

El sistema intenta en este orden:

1. **Localizador Principal** - El XPath/CSS original
2. **Localizadores Alternativos** - Opciones registradas
3. **Scroll** - Scroll automático + reintento
4. **Clickeable** - Espera a que sea interactuable
5. **Visibilidad** - Espera a que esté visible
6. **Partial Match** - Coincidencia parcial de atributos

## 📈 Estadísticas

Cada ejecución genera:
- ✅ Total de intentos
- ✅ Recuperaciones exitosas
- ✅ Fallos no recuperables
- ✅ Tasa de éxito en porcentaje

### Ejemplo:
```
=== HEALING STATISTICS ===
Total: 25 | Successful: 24 | Failed: 1 | Success Rate: 96.00%
```

## 📚 Documentación Completa

📖 **[AUTO_HEALING_GUIDE.md](../../AUTO_HEALING_GUIDE.md)** - Guía completa de integración

## 🔧 Configuración Avanzada

### Timeout personalizado

```java
// En AutoHealingManager (próxima versión)
private static final int DEFAULT_TIMEOUT = 15; // En segundos
```

### Registro de alternativas en tiempo de ejecución

```java
AutoHealingManager.registerAlternative("myElement", 
    "//div[@data-test='my-element']");
```

### Limpiar histórico

```java
AutoHealingManager.clearHistory(); // Entre tests
```

## 🐛 Troubleshooting

### El elemento no se recupera
- Agrega más alternativas
- Verifica que el XPath sea válido
- Aumenta timeouts si es necesario

### Generación de reportes falla
- Verifica permisos en `target/`
- Asegúrate de llamar a `HealingReporter` en @After

### Muchos fallos en healing
- Revisa si la aplicación cambió
- Actualiza localizadores
- Inspecciona el HTML actual

## 🎓 Ejemplos disponibles

1. **LoginBerserkerPageHealed** - Página de login con healing
2. **LoginStepHealing** - Step definition ejemplo
3. **AutoHealingDemoTest** - Demostración funcional
4. **AUTO_HEALING_GUIDE.md** - Documentación completa

## ✅ Checklist de Implementación

- [ ] Copia los archivos del healing
- [ ] Crea primer PageObject con HealablePageObject
- [ ] Registra localizadores y alternativas
- [ ] Ejecuta y genera reportes
- [ ] Revisa reportes HTML
- [ ] Ajusta según resultados
- [ ] Documenta decisiones de selectores

## 📞 Soporte

Para problemas o mejoras:
1. Revisa AUTO_HEALING_GUIDE.md
2. Verifica ejemplos en `healing/` folder
3. Consulta reportes HTML generados

## 🎯 Mejoras Futuras

- [ ] Configuración por YAML
- [ ] Integración con Jira/Xray
- [ ] Machine Learning para sugerir alternativas
- [ ] Dashboard web de healing analytics
- [ ] Soporte para Shadow DOM avanzado

---

**Última actualización:** 2026-07-13  
**Versión:** 1.0.0  
**Autor:** GitHub Copilot
