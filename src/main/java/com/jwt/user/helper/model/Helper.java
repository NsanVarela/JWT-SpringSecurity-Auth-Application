package com.jwt.user.helper.model;

import java.util.List;

import com.jwt.user.hoster.model.Hoster;
import com.jwt.user.hoster.model.Reservation;
import com.jwt.user.model.Message;
import com.jwt.user.model.User;

public class Helper extends User {
	
	private List<KnowHow> knowHowList;
	private List<Hoster> hostersList;
	private List<Reservation> reservations;
	private List<Message> sentMessages;
	
	public Helper() { }
	
	public Helper(
		String userName, 
		String email, 
		List<String> roles, 
		List<KnowHow> knowHowList, 
		List<Hoster> hostersList, 
		List<Reservation> reservations, 
		List<Message> sentMessages
	) {
        super(userName, email, roles);
        this.knowHowList = knowHowList;
        this.hostersList = hostersList;
        this.reservations = reservations;
        this.sentMessages = sentMessages;
    }

}
