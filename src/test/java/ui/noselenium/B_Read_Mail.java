package test.java.ui.noselenium;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class B_Read_Mail {
    public static void main(String[] args) {
        //https://support.google.com/accounts/answer/6010255?authuser=1&p=lsa_blocked&hl=en&authuser=1&visit_id=637254208799399154-2796102227&rd=1
        //https://myaccount.google.com/
        //https://myaccount.google.com/lesssecureapps
        B_Read_Mail.readMail("pop.gmail.com", "pop3", "test.testing2022@gmail.com", "a1234567B");
    }

    public static void readMail(String host, String storeType, String user, String password) {
        try{
            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);
            for(Message message: messages) {
                System.out.println("************************************************");
                System.out.println("Subject: - " + message.getSubject());
                System.out.println("From: ---- " + message.getFrom()[0]);
                System.out.println("Text: ---- " + message.getContent().toString());
                if (message.isMimeType("text/plain")) {
                    System.out.println(message.getContent().toString());
                } else if (message.isMimeType("multipart/*")) {
                    MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                    System.out.println(B_Read_Mail.getTextFromMimeMultipart(mimeMultipart));
                }
                //message.setFlag(Flags.Flag.RECENT, true);
            }
            emailFolder.close(false);
            store.close();
        } catch (NoSuchProviderException nspe) {
            nspe.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }
}
