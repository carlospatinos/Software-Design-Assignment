package classes;

public class Player {
	private String name;
	private int shirt_number;
	private String dob;
	private String birthPlace;
	private String position;
	private String joined_club;
	private String joined_from;
	private String international;
	private String club_debut;
	private int apps;
	private int goals;

	// constructors
	public Player(String name, int shirt_number, String dob, String birthPlace,
			String position, String joined_club, String joined_from,
			String international, String club_debut, int apps, int goals) {
		super();
		this.name = name;
		this.shirt_number = shirt_number;
		this.dob = dob;
		this.birthPlace = birthPlace;
		this.position = position;
		this.joined_club = joined_club;
		this.joined_from = joined_from;
		this.international = international;
		this.club_debut = club_debut;
		this.apps = apps;
		this.goals = goals;
	}

	public Player() {
		super();
	}

	// getters
	public String getName() {
		return name;
	}

	public int getShirt_number() {
		return shirt_number;
	}

	public String getDob() {
		return dob;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public String getPosition() {
		return position;
	}

	public String getJoined_club() {
		return joined_club;
	}

	public String getJoined_from() {
		return joined_from;
	}

	public String getInternational() {
		return international;
	}

	public String getClub_debut() {
		return club_debut;
	}

	public int getApps() {
		return apps;
	}

	public int getGoals() {
		return goals;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setShirt_number(int shirt_number) {
		this.shirt_number = shirt_number;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setJoined_club(String joined_club) {
		this.joined_club = joined_club;
	}

	public void setJoined_from(String joined_from) {
		this.joined_from = joined_from;
	}

	public void setInternational(String international) {
		this.international = international;
	}

	public void setClub_debut(String club_debut) {
		this.club_debut = club_debut;
	}

	public void setApps(int apps) {
		this.apps = apps;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}
}
