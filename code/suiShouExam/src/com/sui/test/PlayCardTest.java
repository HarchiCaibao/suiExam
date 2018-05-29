package com.sui.test;

import java.util.ArrayList;
import java.util.List;

import com.sui.po.Card;
import com.sui.po.Player;
import com.sui.po.Waiter;

/**
 * 功能测试类 2018.5.29
 * 
 * @author 王汉志
 *
 */
public class PlayCardTest {
	public static void main(String[] args) {
		// 发牌者
		Waiter waiter = new Waiter();
		// 玩家
		List<Player> players = new ArrayList<>();
		// 发牌到每个玩家手中
		ArrayList<ArrayList<Card>> cards = waiter.sendCards();
		for (int i = 0; i < 4; i++) {
			players.add(new Player(String.valueOf(i), cards.get(i)));
		}
		// 打印每位玩家手中的牌
		waiter.showCards(players);

	}
}
