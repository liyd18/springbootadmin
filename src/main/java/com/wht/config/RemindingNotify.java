package com.wht.config;
//package com.gavin.config;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//
//import de.codecentric.boot.admin.event.ClientApplicationDeregisteredEvent;
//import de.codecentric.boot.admin.event.ClientApplicationEvent;
//import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
//import de.codecentric.boot.admin.notify.Notifier;
///**
// * <p>Description: TODO(describe the types) </br>
// * @author liyd
// * @version 2017年11月22日
// */
//public class RemindingNotify implements Notifier  {
//	
//	private final ConcurrentHashMap<String, Reminder> reminders = new ConcurrentHashMap<>();
//	private long reminderPeriod = TimeUnit.MINUTES.toMillis(10L);
//	private String[] reminderStatuses = { "DOWN", "OFFLINE" , "UP" };
//	private final MailNotifier delegate;
//
//	public RemindingNotify(MailNotifier delegate) {
//		this.delegate = delegate;
//	}
//
//	@Override
//	public void notify(ClientApplicationEvent event) {
//		delegate.notify(event);
//		if (shouldEndReminder(event)) {
//			reminders.remove(event.getApplication().getId());
//		} else if (shouldStartReminder(event)) {
//			reminders.putIfAbsent(event.getApplication().getId(), new Reminder(event));
//		}
//	}
//
//	public void sendReminders() {
//		long now = System.currentTimeMillis();
//		for (Reminder reminder : new ArrayList<>(reminders.values())) {
//			System.out.println("-------"+(now - reminder.getLastNotification() > reminderPeriod));
//			if (now - reminder.getLastNotification() > reminderPeriod) {
//				System.out.println("true--------------");
//				reminder.setLastNotification(now);
//				delegate.notify(reminder.getEvent());
//			}
//		}
//	}
//
//	protected boolean shouldStartReminder(ClientApplicationEvent event) {
//		if (event instanceof ClientApplicationStatusChangedEvent) {
//			return Arrays.binarySearch(reminderStatuses,
//					event.getApplication().getStatusInfo().getStatus()) >= 0;
//		}
//		return false;
//	}
//
//	protected boolean shouldEndReminder(ClientApplicationEvent event) {
//		if (event instanceof ClientApplicationDeregisteredEvent) {
//			return true;
//		}
//		if (event instanceof ClientApplicationStatusChangedEvent) {
//			return Arrays.binarySearch(reminderStatuses,
//					event.getApplication().getStatusInfo().getStatus()) < 0;
//		}
//		return false;
//	}
//
//	public void setReminderPeriod(long reminderPeriod) {
//		this.reminderPeriod = reminderPeriod;
//	}
//
//	public void setReminderStatuses(String[] reminderStatuses) {
//		String[] copy = Arrays.copyOf(reminderStatuses, reminderStatuses.length);
//		Arrays.sort(copy);
//		this.reminderStatuses = copy;
//	}
//
//	private static class Reminder {
//		private final ClientApplicationEvent event;
//		private long lastNotification;
//
//		private Reminder(ClientApplicationEvent event) {
//			this.event = event;
//			this.lastNotification = event.getTimestamp();
//		}
//
//		public void setLastNotification(long lastNotification) {
//			this.lastNotification = lastNotification;
//		}
//
//		public long getLastNotification() {
//			return lastNotification;
//		}
//
//		public ClientApplicationEvent getEvent() {
//			return event;
//		}
//	}
//}
