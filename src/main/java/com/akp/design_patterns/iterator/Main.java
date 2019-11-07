package com.akp.design_patterns.iterator;

class Main {
	public static void main(String args[]) {
		NotificationCollection nc = new NotificationCollection();
		NotificationBar nb = new NotificationBar(nc);
		nb.printNotifications();
	}
}
