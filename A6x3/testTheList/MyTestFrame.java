package testTheList;

import static media.DVDFormat.NTSC;
import static media.DVDFormat.PAL;
import static media.MediaType.AUDIO;
import static media.MediaType.MOVIE;

import list.MyList;
import media.CD;
import media.DVD;
import media.Disc;

public class MyTestFrame {

	public static void main(String... args) {
		MyList<Disc> list = new MyList<Disc>();
		Disc cd1 = new CD("We Play With Fire", AUDIO, "Easy Shapes");
		Disc cd2 = new CD("CD2", AUDIO, "CD2 Artist");
		Disc dvd1 = new DVD("Trainspotting", MOVIE, PAL);
		Disc dvd2 = new DVD("Trainspotting 2", MOVIE, NTSC);

		list.putNo(0, dvd1);
		list.putNo(1, dvd2);
		list.putNo(2, cd1);
		list.putNo(3, cd2);

		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.getNo(i).toString());
		}
	}
}
