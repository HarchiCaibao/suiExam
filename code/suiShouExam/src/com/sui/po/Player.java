package com.sui.po;
/**
 * 2018.5.29
 * @author 王汉志
 * 玩家对象
 */

import java.util.ArrayList;

public class Player {
	private String name; // 玩家名称
	private ArrayList<Card> cards; // 玩家手里的牌

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public Player() {

	}

	public Player(String name, ArrayList<Card> cards) {
		this.name = name;
		this.cards = cards;
	}

}
