package com.tdp.ct.web.utils;

import com.tdp.ct.web.step.BandejaBackOfficeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetentionService {

        private final BandejaBackOfficeStep bandejaBackOfficeStep;

        @Autowired
        RetentionService(BandejaBackOfficeStep bandejaBackOfficeStep) {
            this.bandejaBackOfficeStep = bandejaBackOfficeStep;
        }

        public boolean isRetention() {
            return bandejaBackOfficeStep.isRetention();
        }

}
