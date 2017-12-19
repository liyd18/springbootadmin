package com.wht.config;
//package com.gavin.config;
//
//import java.util.Arrays;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.expression.EvaluationContext;
//import org.springframework.expression.Expression;
//import org.springframework.expression.ParserContext;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.expression.spel.support.StandardEvaluationContext;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import de.codecentric.boot.admin.event.ClientApplicationEvent;
//import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
//
//@Configuration
//public class MailNotifier extends AbstractStatusChangeNotifier {
//
//	private Logger log = LoggerFactory.getLogger(MailNotifier.class);
//	
//	@Value("${spring.boot.admin.notify.mail.enabled}")
//	private boolean enabled;
//	
//	private static final String DEFAULT_SUBJECT = "#{application.name} (#{application.id}) is #{to.status}";
//	private static final String DEFAULT_TEXT = "#{application.name} (#{application.id})\nstatus changed from #{from.status} to #{to.status}\n\n#{application.healthUrl}";
//
//	private final SpelExpressionParser parser = new SpelExpressionParser();
//	private final JavaMailSender sender = new JavaMailSenderImpl();
//
//	/**
//	 * recipients of the mail
//	 */
//	private String to[] = { "1140703158@qq.com" };
//
//	/**
//	 * cc-recipients of the mail
//	 */
//	private String cc[];
//
//	/**
//	 * sender of the change
//	 */
//	private String from = "302979947@qq.com";
//
//	/**
//	 * Mail Text. SpEL template using event as root;
//	 */
//	private Expression text;
//
//	/**
//	 * Mail Subject. SpEL template using event as root;
//	 */
//	private Expression subject;
//
//	public MailNotifier(JavaMailSender sender) {
//		this.subject = parser.parseExpression(DEFAULT_SUBJECT, ParserContext.TEMPLATE_EXPRESSION);
//		this.text = parser.parseExpression(DEFAULT_TEXT, ParserContext.TEMPLATE_EXPRESSION);
//	}
//
//	@Override
//	protected void doNotify(ClientApplicationEvent event) {
//		EvaluationContext context = new StandardEvaluationContext(event);
//		log.info("------------发送邮件---------------");
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(to);
//		message.setFrom(from);
//		message.setSubject(DEFAULT_SUBJECT);
//		message.setText(DEFAULT_TEXT);
//		message.setCc(cc);
//		log.info("发送请求参数："+message.toString());
//		sender.send(message);
//	}
//
//	@Override
//	public void notify(ClientApplicationEvent event) {
//		System.out.println("=============="+shouldNotify(event));
//		doNotify(event);
//		if (enabled && shouldNotify(event)) {
//            try {
//                doNotify(event);
//            } catch (Exception ex) {
//                log.error("Couldn't notify for event {} ", event, ex);
//            }
//        }
//	}
//	
//	public void setTo(String[] to) {
//		this.to = Arrays.copyOf(to, to.length);
//	}
//
//	public void setCc(String[] cc) {
//		this.cc = Arrays.copyOf(cc, cc.length);
//	}
//
//	public void setFrom(String from) {
//		this.from = from;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = parser.parseExpression(subject, ParserContext.TEMPLATE_EXPRESSION);
//	}
//
//	public void setText(String text) {
//		this.text = parser.parseExpression(text, ParserContext.TEMPLATE_EXPRESSION);
//	}
//}
