package com.generalbytes.batm.server.extensions.extra.examples.LabsMobile;


import com.generalbytes.batm.server.extensions.AbstractExtension;
import com.generalbytes.batm.server.extensions.communication.ICommunicationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

// uncomment in batm-extensions.xml
public class LabsMobileExtension extends AbstractExtension {
    Logger log = LoggerFactory.getLogger(LabsMobileExtension.class);

    @Override
    public String getName() {
        return "Labsmobile sms sender ";
    }

    @Override
    public Set<ICommunicationProvider> getCommunicationProviders() {
        Set<ICommunicationProvider> providers = new HashSet<>();
        providers.add(new LabsMobileSmsProvider());

        return providers;
    }
}
