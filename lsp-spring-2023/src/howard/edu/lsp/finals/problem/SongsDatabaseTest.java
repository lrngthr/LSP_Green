package howard.edu.lsp.finals.problem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

public class SongsDatabaseTest{
	@Test
	@DisplayName("Testing AddSong Method")
	public void testAddSong() {
	    SongsDatabase db = new SongsDatabase();
	    db.addSong("Pop", "All about that bass");
	    db.addSong("Rap", "No Flockin");
	    assertTrue(db.getSongs("Pop").contains("All about that bass"));
	    assertTrue(db.getSongs("Rap").contains("No Flockin"));
	    assertFalse(db.getSongs("Pop").contains("Let me love you"));
	}
	
	@Test
	@DisplayName("Testing GetSongs Method")
	public void testGetSongs() {
	    SongsDatabase db = new SongsDatabase();
	    db.addSong("R&B", "Mad");
	    db.addSong("R&B", "Little Lies");
	    db.addSong("R&B", "Let Me Go");
	    Set<String> rnbSongs = db.getSongs("R&B");
	    assertEquals(3, rnbSongs.size());
	    assertTrue(rnbSongs.contains("Mad"));
	    assertTrue(rnbSongs.contains("Little Lies"));
	    assertTrue(rnbSongs.contains("Let Me Go"));
	    assertFalse(rnbSongs.contains("Let Go"));
	    
	}
	
	@Test
	@DisplayName("Testing GetGenreOfSong Method")
	public void testGetGenreOfSong() {
	    SongsDatabase db = new SongsDatabase();
	    db.addSong("Neo Soul", "On & On");
	    db.addSong("Neo Soul", "Brown Sugar");
	    db.addSong("Neo Soul", "Didn't Cha Know");
	    assertEquals("Neo Soul", db.getGenreOfSong("On & On"));
	    assertEquals("Neo Soul", db.getGenreOfSong("Brown Sugar"));
	    assertEquals("Neo Soul", db.getGenreOfSong("Didn't Cha Know"));
	    assertEquals(null, db.getGenreOfSong("Fallin'"));
	}
}
