package com.josdem.mailosaur;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MailosaurSenderTest {

    private static final String SERVER_DOMAIN = ".mailosaur.net";

    private String apiKey = "YOUR_API_KEY";
    private String serverId = "SERVER_ID";

    @BeforeEach
    void setup() {
        serverId = System.getProperty("mailosaurServerId");
        apiKey = System.getProperty("mailosaurApiKey");
    }

    @Test
    @DisplayName("Sending email")
    void shouldSendEmail() throws MailosaurException, IOException {
        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("josdem@" + serverId + SERVER_DOMAIN);
        Message message = mailosaur.messages().get(params, criteria);

        assertNotNull(message);
        assertEquals("test", message.subject());
    }
}
