/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd_example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ec291267
 */
public class MailTester implements MailSender {

    class TestMail {

        String to;
        String subject;
        String message;

        public TestMail(String to, String subject, String message) {
            this.to = to;
            this.subject = subject;
            this.message = message;
        }

    }

    List<TestMail> sentEmails = new ArrayList<>();

    @Override
    public void send(String permaCode, String subject, String message) {
        sentEmails.add(new TestMail(permaCode, subject, message));
    }

}
