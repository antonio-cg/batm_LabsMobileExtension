package com.generalbytes.batm.server.extensions.extra.examples.LabsMobile;

import com.generalbytes.batm.server.extensions.communication.ISmsErrorResponse;

public class LabsMobileErrorResponseImpl implements ISmsErrorResponse {

    private final String errorMessage;
    private final boolean blacklisted;

    public LabsMobileErrorResponseImpl(String errorMessage) {
        this.errorMessage = errorMessage;
        this.blacklisted = false;
    }

    public LabsMobileErrorResponseImpl(String errorMessage, boolean blacklisted) {
        this.errorMessage = errorMessage;
        this.blacklisted = blacklisted;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean isBlacklisted() {
        return blacklisted;
    }
}
