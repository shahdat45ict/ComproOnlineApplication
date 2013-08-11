package mum.compro.onlineapp;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EnglishProficiency")
public class EnglishProficiency {
	@Id
	@GeneratedValue
	private long id;
	private String howWellReadWriteEnglish;
	private String howWellSpeakEnglish;
	private String howWellUnderstandSpokenEnglish;
	private String toeflYearTaken;
	private String toeflScore;
	private String greYearTaken;
	private String greVerbalScore;
	private String greVerbalPercentile;
	private String greQuantitativeScore;
	private String greQuantitativePercentile;
	private String greAnalyticalScore;
	private String greAnalyticalPercentile;	
	private Date updatedOn;
	
	public EnglishProficiency() {	
		this.setUpdatedOn(new Date());
	}
	
	public EnglishProficiency(String howWellReadWriteEnglish, String howWellSpeakEnglish, String howWellUnderstandSpokenEnglish,
			String toeflYearTaken, String toeflScore,
			String greYearTaken, String greVerbalScore,String greVerbalPercentile,
			String greQuantitativeScore,String greQuantitativePercentile,
			String greAnalyticalScore,String greAnalyticalPercentile
			) {
		this.setHowWellReadWriteEnglish(howWellReadWriteEnglish);
		this.setHowWellSpeakEnglish(howWellReadWriteEnglish);
		this.setHowWellUnderstandSpokenEnglish(howWellUnderstandSpokenEnglish);
		this.setToeflScore(toeflScore);
		this.setToeflYearTaken(toeflYearTaken);
		this.setGreYearTaken(greYearTaken);
		this.setGreVerbalScore(greVerbalScore);
		this.setGreVerbalPercentile(greVerbalPercentile);
		this.setGreQuantitativeScore(greQuantitativeScore);
		this.setGreQuantitativePercentile(greQuantitativePercentile);
		this.setGreAnalyticalPercentile(greAnalyticalPercentile);
		this.setGreAnalyticalScore(greAnalyticalScore);		
		this.setUpdatedOn(new Date());
		
	}
	public long getId() {		
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getHowWellReadWriteEnglish() {
		return howWellReadWriteEnglish;
	}

	public void setHowWellReadWriteEnglish(String howWellReadWriteEnglish) {
		this.howWellReadWriteEnglish = howWellReadWriteEnglish;
	}

	public String getHowWellSpeakEnglish() {
		return howWellSpeakEnglish;
	}

	public void setHowWellSpeakEnglish(String howWellSpeakEnglish) {
		this.howWellSpeakEnglish = howWellSpeakEnglish;
	}

	public String getHowWellUnderstandSpokenEnglish() {
		return howWellUnderstandSpokenEnglish;
	}

	public void setHowWellUnderstandSpokenEnglish(
			String howWellUnderstandSpokenEnglish) {
		this.howWellUnderstandSpokenEnglish = howWellUnderstandSpokenEnglish;
	}

	public String getToeflYearTaken() {
		return toeflYearTaken;
	}

	public void setToeflYearTaken(String toeflYearTaken) {
		this.toeflYearTaken = toeflYearTaken;
	}

	public String getToeflScore() {
		return toeflScore;
	}

	public void setToeflScore(String toeflScore) {
		this.toeflScore = toeflScore;
	}

	public String getGreYearTaken() {
		return greYearTaken;
	}

	public void setGreYearTaken(String greYearTaken) {
		this.greYearTaken = greYearTaken;
	}

	public String getGreVerbalScore() {
		return greVerbalScore;
	}

	public void setGreVerbalScore(String greVerbalScore) {
		this.greVerbalScore = greVerbalScore;
	}

	public String getGreVerbalPercentile() {
		return greVerbalPercentile;
	}

	public void setGreVerbalPercentile(String greVerbalPercentile) {
		this.greVerbalPercentile = greVerbalPercentile;
	}

	public String getGreQuantitativeScore() {
		return greQuantitativeScore;
	}

	public void setGreQuantitativeScore(String greQuantitativeScore) {
		this.greQuantitativeScore = greQuantitativeScore;
	}

	public String getGreQuantitativePercentile() {
		return greQuantitativePercentile;
	}

	public void setGreQuantitativePercentile(String greQuantitativePercentile) {
		this.greQuantitativePercentile = greQuantitativePercentile;
	}

	public String getGreAnalyticalScore() {
		return greAnalyticalScore;
	}

	public void setGreAnalyticalScore(String greAnalyticalScore) {
		this.greAnalyticalScore = greAnalyticalScore;
	}

	public String getGreAnalyticalPercentile() {
		return greAnalyticalPercentile;
	}

	public void setGreAnalyticalPercentile(String greAnalyticalPercentile) {
		this.greAnalyticalPercentile = greAnalyticalPercentile;
	}

	public Date getUpdatedOn() {		
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
