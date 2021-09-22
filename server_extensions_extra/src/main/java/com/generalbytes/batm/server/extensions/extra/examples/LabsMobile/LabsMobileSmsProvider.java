package com.generalbytes.batm.server.extensions.extra.examples.LabsMobile;

import com.generalbytes.batm.server.extensions.communication.ICommunicationProvider;
import com.generalbytes.batm.server.extensions.communication.ISmsResponse;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabsMobileSmsProvider implements ICommunicationProvider {
    private static final Logger log = LoggerFactory.getLogger("batm.server.extensions.extra.labsmobilek");

    @Override
    public String getName() {
        return "LabsMobile";
    }

    @Override
    public ISmsResponse sendSms(String credentials, String phoneNumber, String messageText) {
        String[] tokens = credentials.split(":");
        String username = tokens[0];
        String password = tokens[1];
        String sender = tokens[2];

        try {
            LabsMobileClient labsClient = new LabsMobileClient(username, password);

            LabsMobileResponse labsResponse = labsClient.SendMessage(phoneNumber, sender, messageText); //enviamos un mensaje mediante el cliente rest

            if (labsResponse != null && labsResponse.code == 0) {
                return new LabsMobileSmsResponseImpl(labsResponse.getSubId(), ISmsResponse.ResponseStatus.OK, BigDecimal.ZERO, null);
            } else {
                return new LabsMobileSmsResponseImpl(labsResponse.getSubId(), ISmsResponse.ResponseStatus.ERROR, null,
                        new LabsMobileErrorResponseImpl("Error while sending SMS: " + labsResponse.getCode() + " - " + labsResponse.getMessage()));
            }

        } catch (Throwable e) {
            log.error("sendSMS By Nexmo - Error.", e);
        }

        return new LabsMobileSmsResponseImpl(null, ISmsResponse.ResponseStatus.ERROR, null, new LabsMobileErrorResponseImpl("Error while sending SMS"));
    
    }

}
