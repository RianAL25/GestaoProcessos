/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package util;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Gabriel Sizilio <gabriel.sizilio>
 */
@Stateless
public class MailService implements MailServiceLocal {

    @Resource(name = "java:/gestaoProcessoMail")
    private Session mailSession;

    @Override
    public void sendEmail(String nome, String to, String link) throws MessagingException {

        MimeMessage mail = new MimeMessage(mailSession);

        mail.setFrom("gestaoprocessoswebdev@outlook.com");
        mail.setSubject("Ativação de conta");
        mail.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));

        MimeMultipart content = new MimeMultipart();

        MimeBodyPart body = new MimeBodyPart();
        body.setContent(
                String.format("<html><h1>Sistema de ativação de conta</h1>"
                        + "<h2>Olá, %s!</h2>"
                        + "<p style=\"background-color: #eee; padding: .25em; border: solid #999 thin; border-left: solid #999 4px;\">"
                        + "Notamos que você acabou de efetuar um cadastro no sistema de gestão de processos seletivos. "
                        + "Para ativar sua conta é necessário que você clique em 'ativar conta' logo a seguir."
                        + "<a href=\"%s\" style=\"padding: 0 .25em; background-color: #ccc;\">ativar conta agora</a>"
                        + "to <b>activate</b> your account.</p>"
                        + "<p style=\"background-color: #eee; padding: .25em; border: solid #999 thin; border-left: solid #999 4px;\">"
                        + "Caso nos enganamos ao te enviar esse e-mail, basta desconsiderá-lo!</p>"
                        + "</html>", nome, link),
                "text/html; charset=utf-8");

        content.addBodyPart(body);
        mail.setContent(content);
        Transport.send(mail);

    }
    
    @Override
    public void recoveryPass(String nome, String to, String link) throws MessagingException {
        MimeMessage mail = new MimeMessage(mailSession);
        
        mail.setFrom("gestaoprocessoswebdev@outlook.com");
        
        mail.setSubject("Recuperacao de senha");
        mail.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));

        MimeMultipart content = new MimeMultipart();

        MimeBodyPart body = new MimeBodyPart();
        body.setContent(
                String.format("<html><h1>Recuperação de senha</h1>"
                        + "<h2>Olá, %s!</h2>"
                        + "<p>"
                        + "Notamos que você solicitou a recuperação de senha. "
                        + "Clique no link a seguir para cadastrar uma "
                        + "<a href=\"%s\" style=\"padding: 0 .25em; background-color: #ccc;\">nova senha</a></p>"
                        + "<p>"
                        + "Caso nos enganamos ao te enviar esse e-mail, basta desconsiderá-lo!</p>"
                        + "</html>", nome, link),
                "text/html; charset=utf-8");

        content.addBodyPart(body);
        mail.setContent(content);
        Transport.send(mail);

    }
}
