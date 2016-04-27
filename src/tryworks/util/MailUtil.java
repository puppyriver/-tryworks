package tryworks.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2016/4/27
 * Time: 15:39
 * rongrong.chen@alcatel-sbell.com.cn
 */



import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

/**
 * Author: Ronnie.Chen
 * Date: 12-11-5
 * Time: 下午4:24
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class MailUtil {
    public static void sendDirectMail(String subject,String body,String[] toAddress) {
        try {
            String host = "smtp.126.com";
            String from = "inmsadmin@126.com";

            String username = "inmsadmin";
            String password = "inmsadmin123";

            SmtpAuth sa = new SmtpAuth();
            sa.getuserinfo(username, password);
            Session session;
            MimeMessage message;
            Properties props = System.getProperties();
//            props.setProperty("proxySet", "true");
//            props.setProperty("socksProxyHost", "192.168.1.1");
//            props.setProperty("socksProxyPort", "808");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", host);
            session = Session.getInstance(props, sa);
            session.setDebug(true);
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] internetAddresses = new InternetAddress[toAddress.length];
            for (int i = 0; i < toAddress.length; i++) {
                internetAddresses[i] = new InternetAddress(toAddress[i]);
            }
            message.addRecipients(Message.RecipientType.TO, internetAddresses);
            message.setSubject(subject);
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText(body);
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);
            message.setContent(mp);
            message.setSentDate(new java.util.Date());
            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            transport.send(message);
        } catch (MessagingException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    static class SmtpAuth extends javax.mail.Authenticator {
        private String user, password;

        public void getuserinfo(String getuser, String getpassword) {
            user = getuser;
            password = getpassword;
        }

        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(user, password);
        }
    }

    public static void main(String[] args) {
        //MailUtil.sendDirectMail(new String[]{"rongrong.chen@alcatel-sbell.com.cn","long.a.fei@alcatel-sbell.com.cn"});
    }
}

