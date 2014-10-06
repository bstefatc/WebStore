package com.bohdamyr.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOT")
public class Lot extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOT_ID")
	private Integer lotId;

	@Column(name = "LOT_NAME")
	@Size(min = 3, message = "Name must be at least 3 characters!")
	private String lotName;

	@Lob
	@Column(name = "PICTURE")
	private String picture;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private Double price = 0.0;

	public Lot() {

	}

	private Lot(LotBuilder builder) {

		this.lotName = builder.lotName;
		this.description = builder.description;
		this.picture = builder.picture;
	}

	public Integer getLotId() {
		return lotId;
	}

	@SuppressWarnings("unused")
	private void setLotId(Integer lotId) {
		this.lotId = lotId;
	}

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static class LotBuilder {
		private Lot lot;
		private final User seller;
		private final Double price;

		private String lotName = "Without name";
		private String description = "Add description";
		private String picture = null;

		public LotBuilder(User seller, Double price) {
			this.seller = seller;
			this.price = price;
		}

		public LotBuilder lotName(String lotName) {
			this.lotName = lotName;
			return this;
		}

		public LotBuilder description(String description) {
			this.description = description;
			return this;
		}

		public LotBuilder picture(String picture) {
			this.picture = picture;
			return this;
		}

		public Lot buildLot() {
			lot = new Lot(this);
			return lot;

		}

	}

}
