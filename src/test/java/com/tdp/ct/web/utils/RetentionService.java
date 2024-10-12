package com.tdp.ct.web.utils;

import com.tdp.ct.web.step.HomeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetentionService {

        private final HomeStep homeStep;

        @Autowired
        RetentionService(HomeStep homeStep) {
            this.homeStep = homeStep;
        }

        public boolean isRetention() {
            return homeStep.isRetention() && homeStep.getChannelType().equals("CC");
        }

}
