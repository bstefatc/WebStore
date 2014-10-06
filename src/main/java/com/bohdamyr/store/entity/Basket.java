package com.bohdamyr.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "BASKET")
@NamedQueries({
		@NamedQuery(name = "Basket.findBasketUserForLot", query = "select b "
				+ "from Basket w JOIN w.buyer b JOIN w.lot l where l.lotId = ?1"),
		@NamedQuery(name = "Basket.findBasketByUserAndLot", query = "select w from Basket w where w.buyer.login = ?1 AND w.lot.lotId = ?2") })
public class Basket extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BASKET_ID")
	private int basketId;

	@ManyToOne
	@JoinColumn(name = "BUYER")
	private User buyer;

	@ManyToOne
	@JoinColumn(name = "LOT")
	private Lot lot;

	public Basket() {
	}

	public Basket(User buyer, Lot lot) {
		this.buyer = buyer;
		this.lot = lot;
	}

	public int getBusketId() {
		return basketId;
	}

	public void setCartId(int id) {
		this.basketId = id;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}
}