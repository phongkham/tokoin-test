package com.mycompany.tokointest.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class Organization extends BaseEntity {

	public static final String COLLECTION_NAME = "Organizations";

	private String name;

	@JsonProperty("domain_names")
	private List<String> domainNames;

	private String details;

	@JsonProperty("shared_tickets")
	private boolean sharedTickets;
}