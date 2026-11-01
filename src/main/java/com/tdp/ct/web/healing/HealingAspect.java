package com.tdp.ct.web.healing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.stereotype.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aspecto AOP para interceptar operaciones de búsqueda de elementos
 * Nota: Requiere que se habilite @EnableAspectJAutoProxy en la configuración de Spring
 */
@Aspect
@Component
public class HealingAspect {
    private static final Logger logger = Logger.getLogger(HealingAspect.class.getName());

    /**
     * Intercepta métodos de búsqueda de elementos en PageObjects que extienden HealablePageObject
     * @param joinPoint Punto de unión AOP
     * @return Resultado del método
     * @throws Throwable Si el method lanza excepción
     */
    @Around("execution(* com.tdp.ct.web.healing.HealablePageObject+.findWithHealing(..))")
    public Object healElementFinding(ProceedingJoinPoint joinPoint) throws Throwable {
        String elementKey = (String) joinPoint.getArgs()[0];

        try {
            logger.log(Level.FINE, "Buscando elemento con healing: " + elementKey);
            Object result = joinPoint.proceed();
            logger.log(Level.FINE, "✓ Elemento encontrado: " + elementKey);
            return result;
        } catch (NoSuchElementException e) {
            logger.log(Level.SEVERE, "✗ Elemento no encontrado y no se pudo recuperar: " + elementKey);
            throw e;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Error en healing para elemento: " + elementKey);
            throw e;
        }
    }
}

