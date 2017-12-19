package com.wht.config;
//package com.gavin.config;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import com.netflix.governator.annotations.binding.Primary;
//
//@Configuration
//@EnableScheduling
//public class NotifierConfiguration {
//
////    @Autowired
////    private MailNotifier mailNotifier;
//
//	private JavaMailSender sender = new JavaMailSenderImpl();
//	
//    @Bean
//    @Primary
//    public RemindingNotify remindingNotifier() {
//    	MailNotifier mailNotifier = new MailNotifier(sender);
//		RemindingNotify notify = new RemindingNotify(mailNotifier );
//        //时间窗口,每次报警的间隔,即这个时间窗口内不重复报警
//    	notify.setReminderPeriod(TimeUnit.SECONDS.toMillis(1));
//        return notify;
//    }
//
//    @Scheduled(fixedDelay = 1_000L) //每5秒调度一次
//    public void remind() {
//        System.out.println("remind....");
//        remindingNotifier().sendReminders();
//    }
//}