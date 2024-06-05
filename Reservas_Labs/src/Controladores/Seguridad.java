package Controladores;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Seguridad {

    private static final String LLAVE = "LLAVESITA";

    private static String emailFrom = "lithubprogramadores@gmail.com";
    private static String contraseñaFrom = "xldw ibkk gotk qcqy";
    private String emailTo;
    private String asunto;
    private String contenido;
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    
    public void crearEmail( String correo,String contrasenia) {
        emailTo = correo;
        System.out.println(emailTo);
        System.out.println(contrasenia);
        asunto = "Recuperación de contraseña \"Universidad Tecnica de Ambato\" - Reservas Labs";
        contenido = "Estimado/a Usuario su clave de inicio de sesion es: "+contrasenia+". Gracias por utilizar FISEI-Reservas Labs";
        // Simple mail transier protocolo
        mProperties = new Properties();
        
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));//Remitente
            mCorreo.setSubject(asunto);
            mCorreo.setText(contenido,"ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, contraseñaFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            JOptionPane.showMessageDialog(null,
                    "Se ha enviado la contrasenia nueva a tu correo. Revisalo por favor.");

        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
