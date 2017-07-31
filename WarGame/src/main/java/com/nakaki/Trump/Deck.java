package com.nakaki.Trump;

import java.util.LinkedList;
import java.util.List;

/**
 * デッキクラス
 */
public class Deck {
	/** デッキのカードリスト */
	private List<Card> cardList = new LinkedList<>();

	/**
	 * デッキのカードリストのゲッター
	 * @return デッキのカードリスト
	 */
	public List<Card> getCardList() {
		return cardList;
	}
	/**
	 * デッキに含まれるカードの枚数取得
	 * @return デッキに含まれるカードの枚数
	 */
	public int count(){
		return this.cardList.size();
	}
	/**
	 * デッキにカードを追加
	 * @param c 追加するカード
	 */
	public void addCard(Card c){
		this.cardList.add(c);
	}
//	/**
//	 * デッキにカードを一括追加
//	 * @param cl 追加するカードのリスト
//	 */
//	public void addCardList(List<Card> cl){
//		this.cardList.addAll(cl);
//	}
	/**
	 * デッキにカードを一括追加
	 * @param d 追加するカードのデッキ
	 */
	public void addCardList(Deck d) {
		this.cardList.addAll(d.getCardList());
	}
	/**
	 * デッキを空にする
	 */
	public void clear(){
		this.cardList.clear();
	}
	/**
	 * デッキからカードを1枚引く
	 * @param index カードを引く位置
	 * @return デッキから引いたカード
	 * @throws IndexOutOfBoundsException カードを引く位置が不正な場合
	 */
	public Card draw(int index) throws IndexOutOfBoundsException{
		Card c = this.cardList.get(index); // カードを引く
		this.cardList.remove(index);       // 引いたカードをリストから削除
		return c;
	}
	/**
	 * デッキのカードをシャッフルする
	 */
	public void shuffle(){
		if (count() == 0) { return; } // デッキにカードがない場合、処理しない
		List<Card> workList = new LinkedList<>(); // 作業用のカードリスト
		while (count() > 0) {
			// デッキのカードをランダムに1枚引いて、作業用カードリストに追加する
			workList.add(draw(new java.util.Random().nextInt(count())));
		}
		this.cardList = workList; // シャッフルされた、作業用カードリストをデッキのカードリストとする
	}
}
