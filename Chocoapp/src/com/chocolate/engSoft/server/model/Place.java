package com.chocolate.engSoft.server.model;

import java.util.List;
import java.util.Set;

import com.appsolut.api.cloudmade.geometry.Point;

/**
 * @author João Marco Maciel da Silva
 * 
 */
public class Place {

	private Long id;
	private Point point;
	private String name;
	private String description;
	private Set<String> tags;
	private List<Comment> comments;

	/**
	 * @param id
	 * @param point
	 * @param name
	 * @param description
	 * @param tags
	 * @param comments
	 */
	public Place(Long id, Point point, String name, String description,
			Set<String> tags, List<Comment> comments) {
		super();
		this.id = id;
		this.point = point;
		this.name = name;
		this.description = description;
		this.tags = tags;
		this.comments = comments;
	}

	/**
	 * @param id
	 * @param point
	 * @param name
	 * @param description
	 * @param tags
	 */
	public Place(Long id, Point point, String name, String description,
			Set<String> tags) {
		super();
		this.id = id;
		this.point = point;
		this.name = name;
		this.description = description;
		this.tags = tags;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the tags
	 */
	public Set<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
