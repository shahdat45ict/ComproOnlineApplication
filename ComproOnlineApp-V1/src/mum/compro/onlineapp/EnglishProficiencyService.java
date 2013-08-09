package mum.compro.onlineapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class EnglishProficiencyService {
	private EnglishProficiencyDAO englishProficiencyDao;

	public void setEnglishProficiencyDao(EnglishProficiencyDAO englishProficiencyDao) {
		this.englishProficiencyDao = englishProficiencyDao;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public EnglishProficiency getEnglishProficiency(long id) {
		EnglishProficiency englishProficiency = englishProficiencyDao.load(id);	
		return englishProficiency;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void addNewEnglishProficiency(EnglishProficiency englishProficiency){
		englishProficiencyDao.create(englishProficiency);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateEnglishProficiency(EnglishProficiency englishProficiency) {
		englishProficiencyDao.update(englishProficiency);
	}

	public List<ReadWriteEngilshOption> getReadWriteEnglishOptions()
	{
		return new ArrayList<ReadWriteEngilshOption>(Arrays.asList(
				new ReadWriteEngilshOption("","Please select"),
				new ReadWriteEngilshOption("Barely","Barely able to read / write"),
				new ReadWriteEngilshOption("Basic","Able to read / write basic sentences"),
				new ReadWriteEngilshOption("Okay","Okay, but with some mistakes"),
				new ReadWriteEngilshOption("LikeNative","Like a native speaker")));
	}
	public List<SpeakEnglishOption> getSpeakEnglishOptions()
	{
		return new ArrayList<SpeakEnglishOption>(Arrays.asList(
				new SpeakEnglishOption("","Please select"),
				new SpeakEnglishOption("Barely","Barely able to Speak"),
				new SpeakEnglishOption("Basic","Able to speak basic sentences"),
				new SpeakEnglishOption("Okay","Okay, but with some mistakes"),
				new SpeakEnglishOption("LikeNative","Like a native speaker")));
	}
	public List<UnderstandSpokenEnglishOption> getUnderstandSpokenEnglishOptions()
	{
		return new ArrayList<UnderstandSpokenEnglishOption>(Arrays.asList(
				new UnderstandSpokenEnglishOption("","Please select"),
				new UnderstandSpokenEnglishOption("Barely","Barely able to Understand"),
				new UnderstandSpokenEnglishOption("Basic","Able to understand basic sentences"),
				new UnderstandSpokenEnglishOption("Okay","Okay, but with some mistakes"),
				new UnderstandSpokenEnglishOption("LikeNative","Like a native speaker")));		
	}
	public List<ToeflYearOption> getToeflYearOptions()
	{
		return new ArrayList<ToeflYearOption>(Arrays.asList(
				new ToeflYearOption("1997","1997"),
				new ToeflYearOption("1998","1998"),
				new ToeflYearOption("1999","1999"),
				new ToeflYearOption("2000","2000"),
				new ToeflYearOption("2001","2001"),
				new ToeflYearOption("2002","2002"),
				new ToeflYearOption("2003","2003"),
				new ToeflYearOption("2004","2004"),
				new ToeflYearOption("2005","2005"),
				new ToeflYearOption("2006","2006"),
				new ToeflYearOption("2007","2007"),
				new ToeflYearOption("2008","2008"),
				new ToeflYearOption("2009","2009"),
				new ToeflYearOption("2010","2010"),
				new ToeflYearOption("2011","2011"),
				new ToeflYearOption("2012","2012"),
				new ToeflYearOption("2013","2013")));
	}
	public List<GreYearOption> getGreYearOptions()
	{
		return new ArrayList<GreYearOption>(Arrays.asList(
				new GreYearOption("1997","1997"),
				new GreYearOption("1998","1998"),
				new GreYearOption("1999","1999"),
				new GreYearOption("2000","2000"),
				new GreYearOption("2001","2001"),
				new GreYearOption("2002","2002"),
				new GreYearOption("2003","2003"),
				new GreYearOption("2004","2004"),
				new GreYearOption("2005","2005"),
				new GreYearOption("2006","2006"),
				new GreYearOption("2007","2007"),
				new GreYearOption("2008","2008"),
				new GreYearOption("2009","2009"),
				new GreYearOption("2010","2010"),
				new GreYearOption("2011","2011"),
				new GreYearOption("2012","2012"),
				new GreYearOption("2013","2013")));
	}
}

