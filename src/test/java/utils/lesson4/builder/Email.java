package utils.lesson4.builder;

import utils.lesson1.GenerateRandomData;

public class Email {
    private final String title;
    private final String emailBody;
    private final String receiver;

    private Email(EmailBuilder emailBuilder) {
        title = emailBuilder.title;
        receiver = emailBuilder.receiver;
        emailBody = emailBuilder.emailBody;
    }

    public String getTitle() {
        return title;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public static class EmailBuilder {
        GenerateRandomData generateRandomData = new GenerateRandomData();
        private String receiver = generateRandomData.generateRandomString(5) + "@yopmail.com";
        private String title = generateRandomData.generateRandomString(10);
        private String emailBody = generateRandomData.generateRandomString(150);

        public EmailBuilder setEmailBody(String emailBody) {
            this.emailBody = emailBody;
            return this;
        }

        public Email build() {

            return new Email(this);
        }
    }
}

