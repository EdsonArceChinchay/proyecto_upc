package com.tdp.ct.web.healing.ranking;

import com.tdp.ct.web.healing.model.CandidateElement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Ranker inteligente de candidatos.
 * Calcula un score para cada candidato basado en:
 *  - Prioridad base (tipo de estrategia)
 *  - Unicidad (1 único elemento = más confiable)
 *  - Penalización por múltiples coincidencias
 */
public class CandidateRanker {

    private static final Logger logger = Logger.getLogger(CandidateRanker.class.getName());

    /**
     * Calcula el score de cada candidato y devuelve la lista completa
     * ordenada de mayor a menor score (el primero es el mejor).
     */
    public List<CandidateElement> rankAll(List<CandidateElement> candidates) {
        if (candidates == null || candidates.isEmpty()) return Collections.emptyList();

        logger.info("┌─── 🏆 AI-Ranking: Evaluando " + candidates.size() + " candidatos ───────────────────────");

        for (CandidateElement c : candidates) {
            double score = c.getBasePriority();

            // Bonus por unicidad
            if (c.getElementCount() == 1) {
                score += 0.6;       // elemento único → muy confiable
            } else if (c.getElementCount() <= 3) {
                score += 0.2;       // pocos elementos → aceptable
            } else {
                score -= 0.3;       // demasiados elementos → ambiguo
            }

            // Normalizar al rango [0, 1]
            score = Math.max(0, Math.min(score / 3.0, 1.0));
            c.setScore(score);
        }

        candidates.sort(Comparator.comparingDouble(CandidateElement::getScore).reversed());

        logger.info("│  Ranking de candidatos (mayor → menor score):");
        for (int i = 0; i < candidates.size(); i++) {
            CandidateElement c = candidates.get(i);
            logger.info("│  #" + (i + 1) + " " + c);
        }
        logger.info("└──────────────────────────────────────────────────────────────");

        return candidates;
    }

    /** Compatibilidad hacia atrás: devuelve solo el mejor. */
    public CandidateElement selectBest(List<CandidateElement> candidates) {
        List<CandidateElement> ranked = rankAll(candidates);
        return ranked.isEmpty() ? null : ranked.get(0);
    }
}
