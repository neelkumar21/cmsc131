package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import photomanager.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void test01PhotoToStringAndConstructor() {
		System.out.println("test01 BELOW");
		Photo photo = new Photo("ronaldo.jpg", 300, 500, "12/13/2006-19:36");
		System.out.println(photo);
	}

	@Test
	public void test02PhotoCopyConstructor() {
		System.out.println("\ntest02 BELOW");
		Photo photo = new Photo("ronaldo.jpg", 300, 500, "12/13/2006-19:36");
		photo.addComments("Soccer");
		Photo copyPhoto = new Photo(photo);
		copyPhoto.addComments("Football");
		System.out.println("Original Photo: " + photo + "," + photo.getComments());
		System.out.println("PhotoCopy: " + copyPhoto + "," + copyPhoto.getComments());
	}

	@Test
	public void test03PhotoGetters() {
		System.out.println("\ntest03 BELOW");
		Photo photo = new Photo("ronaldo.jpg", 300, 500, "12/13/2006-19:36");
		System.out.println("Photo source, width, height, and date:");
		System.out.println(
				photo.getPhotoSource() + "\n" + photo.getWidth() + "\n" + photo.getHeight() + "\n" + photo.getDate());

	}

	@Test
	public void test04PhotoComments() {
		System.out.println("\ntest04 BELOW");
		Photo photo = new Photo("saka.jpg", 300, 500, "10/10/2004-07:21");
		photo.addComments("Arsenal Soccer Club");
		System.out.println(photo.getComments());
		photo.addComments("Best Soccer Team");
		System.out.println(photo.getComments());
	}

	@Test
	public void test05PhotoCompareTo() {
		System.out.println("\ntest05 BELOW");
		Photo photo = new Photo("ronaldo.jpg", 300, 500, "12/13/2006-19:36");
		Photo photo2 = new Photo("messi.jpg", 300, 500, "7/21/2008-19:36");
		Photo photo3 = new Photo("neymar.jpg", 300, 500, "12/13/2006-19:36");

		System.out.println("Before Date: " + photo.compareTo(photo2));
		System.out.println("Same Date: " + photo.compareTo(photo3));
		System.out.println("After Date: " + photo2.compareTo(photo));
	}

	@Test
	public void test06PhotoManagerToStringAndConstructor() {
		System.out.println("\ntest06 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:36");
		photoManager.addPhoto("messi.jpg", 10, 60, "7/21/2008-19:36");
		System.out.print("All Photos Added:\n" + photoManager);
	}

	@Test
	public void test07PhotoManagerAddPhoto() {
		System.out.println("\ntest07 BELOW");
		PhotoManager photoManager = new PhotoManager();
		System.out.println("Added Photo? " + photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:36"));
		System.out.println("Added Photo? " + photoManager.addPhoto(null, 10, 60, "12/13/2006-19:36"));
	}

	@Test
	public void test08PhotoManagerFindPhoto() {
		System.out.println("\ntest08 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:36");
		photoManager.addPhoto("messi.jpg", 10, 60, "7/21/2008-19:36");
		photoManager.addPhoto("neymar.jpg", 300, 500, "12/13/2006-19:36");
		System.out.println("Messi Index: " + photoManager.findPhoto("messi.jpg"));
		System.out.println("Neymar Index: " + photoManager.findPhoto("neymar.jpg"));
		System.out.println("Basketball Index: " + photoManager.findPhoto("basketball.jpg"));
	}

	@Test
	public void test09PhotoManagerComments() {
		System.out.println("\ntest09 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:36");
		photoManager.addPhoto("messi.jpg", 10, 60, "7/21/2008-19:36");
		photoManager.addComment("messi.jpg", "Plays Soccer");
		photoManager.addComment("messi.jpg", "Is really good");
		photoManager.addComment("ronaldo.jpg", "Scores goals");
		System.out.println("Ronaldo Comments: " + photoManager.getComments("ronaldo.jpg"));
		System.out.println("Messi Comments: " + photoManager.getComments("messi.jpg"));
	}

	@Test
	public void test10PhotoManagerRemoveAllPhotos() {
		System.out.println("\ntest10 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:36");
		photoManager.addPhoto("messi.jpg", 10, 60, "7/21/2008-19:36");
		System.out.print(photoManager);
		photoManager.removeAllPhotos();
		System.out.println("Removed Photos Successfully" + photoManager);
	}

	@Test
	public void test11PhotoManagerRemovePhoto() {
		System.out.println("\ntest11 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:36");
		photoManager.addPhoto("messi.jpg", 10, 60, "7/21/2008-19:36");
		photoManager.addPhoto("neymar.jpg", 300, 500, "12/13/2006-19:36");
		System.out.print(photoManager);
		photoManager.removePhoto("messi.jpg");
		System.out.print("Removing Photo\n" + photoManager);
	}

	@Test
	public void test12PhotoManagerLoadPhotos() {
		System.out.println("\ntest12 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.loadPhotos("/Users/neelkumar/Downloads/PhotoManager/ronaldo.txt");
		System.out.print(photoManager);
	}

	@Test
	public void test13PhotoManagerSortPhotosByDate() {
		System.out.println("\ntest13 BELOW");
		PhotoManager photoManager = new PhotoManager();
		photoManager.addPhoto("ronaldo.jpg", 10, 60, "12/13/2006-19:37");
		photoManager.addPhoto("messi.jpg", 10, 60, "7/21/2008-10:45");
		photoManager.addPhoto("neymar.jpg", 300, 500, "12/13/2006-19:36");
		photoManager.addPhoto("benzema.jpg", 300, 500, "10/27/2014-01:52");
		photoManager.addPhoto("saka.jpg", 300, 500, "10/10/2004-07:21");
		photoManager.sortPhotosByDate();
		System.out.println(photoManager + "Sorted Successfully");
	}
}