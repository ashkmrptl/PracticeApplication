package com.akp.patterns.iterator;

public class NotificationCollection implements Collection {

	private static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	Notification[] notificationArray;

	public NotificationCollection() {
		notificationArray = new Notification[MAX_ITEMS];

		// adding some dummy notification
		addItem("Notification 1");
		addItem("Notification 2");
		addItem("Notification 3");

	}

	public void addItem(String str) {
		Notification notification = new Notification(str);
		if (numberOfItems >= MAX_ITEMS)
			System.err.println("Full");
		else {
			notificationArray[numberOfItems] = notification;
			numberOfItems = numberOfItems + 1;
		}
	}

	@Override
	public Iterator createIterator() {
		return new NotificationIterator(notificationArray);
	}

}
