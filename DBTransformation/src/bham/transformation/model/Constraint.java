package bham.transformation.model;

import java.util.List;

public class Constraint {
	private String name;
	private String type;
	private Reference reference;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Reference getReference() {
		return reference;
	}
	public void setReferences(Reference references) {
		this.reference = references;
	}
}
