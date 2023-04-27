package howard.edu.lsp.finals.problem;
import java.util.*;


public class SongsDatabase {
	/* Key is the genre, HashSet contains associated songs */
    		private Map<String, HashSet<String>> songsmap = 
new HashMap<String, HashSet<String>>();
	
	 		/* Add a song title to a genre */
    		public void addSong(String genre, String songTitle) {
					HashSet<String> songs = songsmap.get(genre);
					if (songs == null ) {
						songs = new HashSet<String>();
						songsmap.put(genre, songs);
					}
					songs.add(songTitle);
				}
    
    		/* Return the Set that contains all songs for a genre */
 		public Set<String> getSongs(String genre) {
 			HashSet<String> songs = songsmap.get(genre);
 	        if (songs == null) {
 	            songs = new HashSet<String>();
 	        }
 	        return songs;
    		}
	
    		/* Return genre, i.e., jazz, given a song title */
    		public String getGenreOfSong(String songTitle) {
    			for (Map.Entry<String, HashSet<String>> song : songsmap.entrySet()) {
    	            if (song.getValue().contains(songTitle)) {
    	                return song.getKey();
    	            }
    	        }
    	        return null;
    		}
}
