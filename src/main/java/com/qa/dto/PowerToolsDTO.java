package com.qa.dto;

public class PowerToolsDTO {
	
	private Integer id;
	
	private String name;
	
	private String usedFor;
	 
	private String easy;
	
	private Integer cost;
	
	private String dangerous;
	

	public PowerToolsDTO(Integer id, String name, String usedFor, String easy, Integer cost, String dangerous) {
		super();
		this.id = id;
		this.name = name;
		this.usedFor = usedFor;
		this.easy = easy;
		this.cost = cost;
		this.dangerous = dangerous;
	}
	
	public PowerToolsDTO() {
		super();
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsedFor() {
		return usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

	public String getEasy() {
		return easy;
	}

	public void setEasy(String easy) {
		this.easy = easy;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getDangerous() {
		return dangerous;
	}

	public void setDangerous(String dangerous) {
		this.dangerous = dangerous;
	}

	public void add(PowerToolsDTO ptDTO) {
		// TODO Auto-generated method stub
		
	}
	

}
