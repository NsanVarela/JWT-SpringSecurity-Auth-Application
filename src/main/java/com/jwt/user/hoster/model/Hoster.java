package com.jwt.user.hoster.model;

import java.util.Date;
import java.util.List;

import com.jwt.auth.enums.Events;
import com.jwt.auth.enums.Pets;
import com.jwt.auth.enums.Smoking;
import com.jwt.user.model.User;

public class Hoster extends User {
	
	private Smoking smoking;
	private Pets pets;
	private Events events;
	private Date openBooking;
	private Date closeBooking;
	private List<Reservation> reservations;
	private String address;
	private String latitude;
	private String longitude;
	private HomeCategory homeCategory;
	private String description;
    private Integer squareMeters;
    private Integer maxPeople;
    private Integer minOvernights;
    private Integer beds;
    private Integer bathrooms;
    private Integer bedrooms;
    private String transport;
    private String neighborhood;
    private String houseRules;
    private boolean amenities;
    private boolean elevator;
    private boolean heating;
    private boolean kitchen;
    private boolean parking;
    private boolean tv;
    private boolean wifi;
	
	public Hoster() { }
	
	public Hoster(String userName, String email, List<String> roles) {
		super(userName, email, roles);
	}

}
