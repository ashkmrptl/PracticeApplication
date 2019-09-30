package com.akp.patterns.iterator;

public class NotificationIterator implements Iterator {
	Notification[] notificationArray;

	// var to indicate current position
	int pos = 0;

	public NotificationIterator(Notification[] notificationArray) {
		this.notificationArray = notificationArray;
	}

	@Override
	public boolean hasNext() {
		if (pos >= notificationArray.length || notificationArray[pos] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Notification notification = notificationArray[pos];
		pos++;
		return notification;
	}

}
