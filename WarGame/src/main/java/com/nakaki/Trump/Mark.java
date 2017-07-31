package com.nakaki.Trump;

/**
 * トランプのマークに相当する列挙型
 */
public enum Mark {
	Diamonds("ダイヤ"),
	Hearts("ハート"),
	Clubs("クローバー"),
	Spades("スペード");

	/** マークの名称 */
	private String name;

	/**
	 * コンストラクタ
	 * @param name
	 */
	Mark(String name){
		this.name = name;
	}
	/**
	 * マークの文字列化
	 */
	@Override
	public String toString(){
		return this.name;
	}
}