package br.com.prsribeiro.dslist.projections;

public interface GameMinProjection {

	Long getId();

	String getTitle();

	Integer getGameYear();

	String getImgUrl();

	String getLongDescription();

	Integer getPosition();
}
