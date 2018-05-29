package com.sui.po;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2018.5.29
 * 
 * @author 王汉志 
 * 发牌服务员
 */
public class Waiter {

	/**
	 * 发牌程序 使用最简单的冒泡排序对牌的权值排序实现打乱牌的次序
	 * 
	 * @return 返回四套次序随机的扑克牌
	 */
	public ArrayList<ArrayList<Card>> sendCards() {
		ArrayList<Card> cards = new ArrayList<>();

		// 得到有花色和面值的52张牌
		cards = produceCrads();

		// 打乱牌的次序，使用最简单的冒泡排序对权值排序即可实现
		boolean flag = true;
		int n = cards.size() - 1;
		for (int i = 0; i < n && flag; i++) {
			flag = false;
			for (int j = 0; j < n - i; j++) {
				Card c1 = cards.get(j);
				Card c2 = cards.get(j + 1);
				if (c1.getWeight() > c2.getWeight()) {
					// 做标记
					flag = true;
					// 交换
					cards.set(j, c2);
					cards.set(j + 1, c1);
				}
			}
		}
		// 将乱序的牌平均分成四套
		ArrayList<ArrayList<Card>> cardList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			ArrayList<Card> c = new ArrayList<>();
			for (int j = i * 13; j < 13 + i * 13; j++) {
				c.add(cards.get(j));
			}
			cardList.add(c);
		}
		return cardList;
	}

	/**
	 * 打印玩家手里的牌
	 * 
	 * @param player
	 *            待打印牌的玩家
	 */
	public void showCards(List<Player> players) {
		if (players.size() == 0) {
			System.out.println("参数错误");
			return;
		}
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			System.out.print("玩家" + player.getName() + "手中的牌为： ");
			ArrayList<Card> cards = player.getCards();
			for (int j = 0; j < cards.size(); j++) {
				String color = cards.get(j).getColor();
				int v = cards.get(j).getValue();
				String value;
				if (v == 11) {
					value = "J";
				} else if (v == 12) {
					value = "Q";
				} else if (v == 13) {
					value = "K";
				} else {
					value = String.valueOf(v);
				}
				System.out.print(color + value + " ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * 产生52牌的程序，牌的顺序一定
	 * 
	 * @return 返回顺序一定的52张牌
	 */
	private ArrayList<Card> produceCrads() {
		String[] colors = { "黑桃", "红桃", "方块", "梅花" };
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		ArrayList<Card> cards = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < values.length; j++) {
				// 随机权值
				int w = random.nextInt(10000) % (10000 - 1 + 1) + 1;
				Card card = new Card(values[j], colors[i], w);
				cards.add(card);
			}
		}
		return cards;
	}
}
