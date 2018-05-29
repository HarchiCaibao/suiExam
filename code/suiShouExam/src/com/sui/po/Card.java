package com.sui.po;

/**
 * 2018.5.29
 * 
 * @author 王汉志 
 * 扑克牌对象
 */
public class Card {
	private int value; // 扑克牌的面值
	private String color; // 扑克牌的花色
	private int weight; // 随机一个数字，用于后期扑克牌的打乱

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Card() {

	}

	public Card(int value, String color, int weight) {
		this.value = value;
		this.color = color;
		this.weight = weight;
	}

}
