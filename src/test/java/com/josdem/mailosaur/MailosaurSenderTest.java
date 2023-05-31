package com.josdem.mailosaur;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MailosaurSenderTest {

    private String apiKey = "YOUR_API_KEY";
    private String serverId = "SERVER_ID";
    private String serverDomain = "SERVER_DOMAIN";

    @Test
    @DisplayName("Sending email")
    void shouldSendEmail() throws MailosaurException, IOException {
        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("josdem@" + serverDomain);
        Message message = mailosaur.messages().get(params, criteria);

        assertNotNull(message);
        assertEquals("My email subject", message.subject());
    }
}
