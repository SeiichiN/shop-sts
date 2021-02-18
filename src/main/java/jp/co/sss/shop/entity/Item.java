package jp.co.sss.shop.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items_gen")
	@SequenceGenerator(name = "seq_items_gen", sequenceName = "seq_items", allocationSize = 1)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer price;
	
	public Integer getId() { return id; }
	public String getName() { return name; }
	public Integer getPrice() { return price; }
	
	public void setId( Integer id ) {
		this.id = id;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public void setPrice( Integer price ) {
		this.price = price;
	}
}
