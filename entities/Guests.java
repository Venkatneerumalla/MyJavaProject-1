package com.project.EventManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
public class Guests {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "guest_id")
	    private int guestId;
	  	private String name;
	    private String email;
	    private String mobile_no;
	    private int eventId;

	    @ManyToOne
	    @JoinColumn(name = "event_id")
	    private Event event;

		public int getGuestId() {
			return guestId;
		}
		public void setGuestId(int guestId) {
			this.guestId = guestId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile_no() {
			return mobile_no;
		}
		public void setMobile_no(String mobile_no) {
			this.mobile_no = mobile_no;
		}
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		public Guests(int guestId, String name, String email, String mobile_no, int eventId) {
			super();
			this.guestId = guestId;
			this.name = name;
			this.email = email;
			this.mobile_no = mobile_no;
			this.eventId = eventId;
		}
		public Guests() {
			super();
		}
		@Override
		public String toString() {
			return "Guests [guestId=" + guestId + ", name=" + name + ", email=" + email + ", mobile_no=" + mobile_no
					+ ", eventId=" + eventId + "]";
		}
}