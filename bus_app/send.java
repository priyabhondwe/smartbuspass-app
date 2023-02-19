package com.example.bus_app;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class send extends AsyncTask {


    private Context context;
    private String email;
    private String subject;
    private  String message;

    public send(Context context, String email, String subject, String message) {
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Toast.makeText(context,"Mail Send To" + email.toString(),Toast.LENGTH_LONG).show();
//        Toast.makeText(context,subject.toString(),Toast.LENGTH_LONG).show();
//        Toast.makeText(context,message.toString(),Toast.LENGTH_LONG).show();
    }



    @Override
    protected Object doInBackground(Object[] objects) {

        final String username = "madhuri.sct@gmail.com";
        String password = "twkdcllzeknurshe";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);

                    }
                });

        try {
            Message mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress("madhuri.sct@gmail.com"));
            mm.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            mm.setSubject("Bus Pass App");
            mm.setText(message);

            Transport.send(mm);

            //Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            System.out.println("Done");

        }catch (MessagingException e)

        {
            e.printStackTrace();
        }
        return null;

    }
}
