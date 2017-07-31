package com.nakaki.Trump;

/**
 * トランプのカード1枚に相当するクラス
 */
public class Card implements Comparable<Card>{
	/** カードのマーク */
	private Mark mark;
	/** カードの数字 */
	private int number;
	/** カードの強さ (数字が大きい方が強い) */
	private int rank;

	/** 一番小さいカードの数字 */
	private static final int MIN_NUMBER = 1;
	/** 一番大きいカードの数字 */
	private static final int MAX_NUMBER = 13;

	/**
	 * コンストラクタ
	 * @param mark カードのマーク
	 * @param number カードの数字
	 * @throws IllegalArgumentException カードの数字が不正な場合
	 */
	public Card(Mark mark, int number) throws IllegalArgumentException{
		if (! checkNumber(number)) {
			throw new IllegalArgumentException();
		}
		this.mark = mark;
		this.number = number;
		setRank(number);
	}
	/**
	 * 引数の数字がMIN_NUMBERとMAX_NUMBERの範囲内にあるかチェック
	 * @param number 数字
	 * @return 数字が、範囲内(true)・範囲外(false)
	 */
	private boolean checkNumber(int number){
		return (MIN_NUMBER <= number && number <= MAX_NUMBER);
	}
	/**
	 * カードの強さをセットする<br>
	 * 2が一番弱く、そこから数字が高い方が強くなり、Aは最も強いカード
	 * @param number カードの数字
	 */
	private void setRank(int number){
		if (number == 1) {
			// Aが一番強い
			this.number = MAX_NUMBER;
		} else {
			// A以外のカードは、自分の数字からAの分の1を引いた数字が自身の強さになる
			this.number = number - 1;
		}
	}
	/**
	 * カードの数字のゲッター
	 * @return カードの数字
	 */
	public int getNumber(){
		return this.number;
	}
	/**
	 * カードの数字を文字列として取得
	 * @return カードの数字を表した文字列
	 */
	public String getNumberAsStr(){
		switch (this.number) {
		case 1: return "A";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return String.valueOf(this.number);
		}
	}
	/**
	 * 文字列化
	 */
	@Override
	public String toString(){
		return this.mark.toString() + getNumberAsStr();
	}
	/**
	 * ハッシュコード生成
	 */
	@Override
	public int hashCode() {
		// 自動生成のコード
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + number;
		result = prime * result + rank;
		return result;
	}
	/**
	 * カードの等価確認
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }  // 等値
		if (obj == null) { return false; } // 比較対象がnull
		if (getClass() != obj.getClass()){ return false; } // 比較対象が別クラスのインスタンス
		// 比較対象をCardにキャスト
		Card other = (Card) obj;
		if (mark != other.mark) { return false; }     // マークが違う
		if (number != other.number) { return false; } // 数字が違う
		return true;
	}
	/**
	 * カードの強さ比較
	 */
	@Override
	public int compareTo(Card o) {
		return this.rank - o.rank;
	}
}
