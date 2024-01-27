package com.dotcipher.explorecali;

import com.dotcipher.explorecali.domain.Difficulty;
import com.dotcipher.explorecali.domain.Region;
import com.dotcipher.explorecali.service.TourPackageService;
import com.dotcipher.explorecali.service.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class ExploreCaliforniaApplication implements CommandLineRunner {

	//private TourPackageService tourPackageService;
	//private TourService tourService;

	/*
	@Autowired
	public ExploreCaliforniaApplication(TourPackageService tourPackageService, TourService tourService){
		this.tourPackageService = tourPackageService;
		this.tourService = tourService;
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(ExploreCaliforniaApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception {
		// Create the Tour Package
		//createTourPackages();
		//long numOfPackages = tourPackageService.total();

		// Load the tours from an external Json File
		//createTours("ExploreCalifornia.json");
		//long numOfTours = tourService.total();
	}

	/*
	private void createTourPackages(){
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
	}

	private void createTours(String fileToImport) throws IOException {
		List<TourFromFile> toursFromFile = TourFromFile.read(fileToImport);
		long numOfTours = toursFromFile.size();
		toursFromFile.forEach((importedTour) -> tourService
				.createTour(importedTour.getTitle(),
						importedTour.getDescription(),
						importedTour.getBlurb(),
						importedTour.getPrice(),
						importedTour.getDuration(),
						importedTour.getBullets(),
						importedTour.getKeywords(),
						importedTour.getPackageName(),
						importedTour.getDifficulty(),
						importedTour.getRegion()));

	}
	*/

	private static class TourFromFile {

		private String packageName, title, description, blurb, price,duration, bullets, keywords, difficulty, region, length;

		static List<TourFromFile> read(String fileToImport) throws IOException {

			return new ObjectMapper()
						.setVisibility(FIELD, ANY)
						.readValue(new FileInputStream(fileToImport),  new TypeReference<List<TourFromFile>>() {});
		}

		protected TourFromFile(){}

		String getPackageName() { return packageName;}
		String getTitle() { return title;}
		public String getDescription() {
			return description;
		}
		public String getBlurb() {
			return blurb;
		}
		public Integer getPrice() {
			return Integer.parseInt(price);
		}
		public String getBullets() {
			return bullets;
		}
		public String getKeywords() {
			return keywords;
		}
		public Difficulty getDifficulty() {
			return Difficulty.valueOf(difficulty);
		}
		public Region getRegion() {
			return Region.findByLabel(region);
		}
		public String getDuration() {
			return duration;
		}
		String getLength() { return length; }

	}
}