package com.KPenz.chat;

public class Room {
	public final String name;
	public enum Status{
			inside,
			ok,
			banned};
	private Status mStatus;
	private int mPeopleCount;
	private String mDescription;
	 
	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String Description) {
		this.mDescription = Description;
	}

	Room(String name){
		this.name=name;
	}

	public Status getStatus() {
		return mStatus;
	}

	public Room setStatus(Status status) {
		this.mStatus = status;
		return this;
	}

	public int getPeopleCount() {
		return mPeopleCount;
	}

	public Room setPeopleCount(int peopleCount) {
		this.mPeopleCount = peopleCount;
		return this;
	}
}
