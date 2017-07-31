package com.nakaki.WarGame;

import com.nakaki.Trump.Card;
import com.nakaki.Trump.Deck;

/**
 * プレイヤークラス
 */
public class Player {
	/** 持ち札デッキ */
	private Deck deck = new Deck();
	/** 獲得札デッキ */
	private Deck acquiredDeck = new Deck();
	/** プレイヤー名 */
	private String name;

	/**
	 * コンストラクタ
	 * @param name プレイヤー名
	 */
	public Player(String name){
		this.name = name;
	}
	/**
	 * 持ち札の中から一番上の1枚を引く
	 * @return 引いたカード
	 */
	public Card draw() throws IndexOutOfBoundsException{
		return this.deck.draw(0);
	}
	/**
	 * 持ち札にカード追加
	 * @param c 追加するカード
	 */
	public void addCardToDeck(Card c){
		this.deck.addCard(c);
	}
	/**
	 * 獲得札デッキにカード追加
	 * @param d
	 */
	public void addAcquisition(Deck d){
		this.acquiredDeck.addCardList(d);
	}
	/**
	 * 持ち札の枚数取得
	 * @return 持ち札の枚数
	 */
	public int getDeckCount(){
		return this.deck.count();
	}
	/**
	 * 獲得札の枚数取得
	 * @return 獲得札の枚数
	 */
	public int getAcquiredCount(){
		return this.acquiredDeck.count();
	}
	/**
	 * プレイヤーの現在の状態を表した文字列取得
	 * @return 現在の状態を表した文字列
	 */
	public String getStatusStr(){
		return String.format("%sの持ち札：%d枚、獲得した札：%d枚", this.name, getDeckCount(), getAcquiredCount());
	}
	/**
	 * プレイヤーのゲーム結果を表した文字列取得
	 * @return ゲーム結果を表した文字列
	 */
	public String getResultStr(){
		return String.format("%sが獲得した札：%d枚", this.name, getAcquiredCount());
	}
}
