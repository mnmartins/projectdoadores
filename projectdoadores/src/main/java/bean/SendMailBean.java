package bean;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean(name = "emailBean")
@ViewScoped
public class SendMailBean {
	private String nome;
	private String email;
	private String mensagem;
	private String message;
	 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void enviarMensagemContato() {
		if((nome != null && !nome.trim().equals("")) && (email != null && !email.trim().equals("")) && (mensagem != null && !mensagem.trim().equals(""))) {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.auth", "true");
			//props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.debug", "true");
		    
		    Session sessao = Session.getInstance(props, new javax.mail.Authenticator() {
		    	protected PasswordAuthentication getPasswordAuthentication() {
		    		return new PasswordAuthentication("projectdoadores@gmail.com", "projetodoe");
		    		}
		    	});
		    
		    try {
		    	MimeMessage email = new MimeMessage(sessao);
		    	email.setFrom(new InternetAddress(this.email));
		    	email.addRecipient(Message.RecipientType.TO,new InternetAddress("projectdoadores@gmail.com"));
		    	email.setSubject("Mensagem de Contato");
		    	email.setText(mensagem);
		    	
		    	Transport.send(email);
		    	
		    	} catch (MessagingException mex) {
		    		mex.printStackTrace();
		    		
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    		
		    	} finally {
		    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem enviada!", "Mensagem enviada com sucesso!"));
		    	}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados incompletos!", "Impossível enviar mensagem, um dos campos do formulário não foi preenchido!"));
		}	
	}
}
