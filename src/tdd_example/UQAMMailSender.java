/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd_example;

/**
 *
 * @author ec291267
 */
public class UQAMMailSender implements MailSender {

    @Override
    public void send(String permaCode, String subject, String message) {
        System.out.println("Message envoyé à " + permaCode);
    }
}
