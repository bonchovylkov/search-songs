package com.homeassignment.myapplication;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bon on 12/8/2014.
 */
public class SongManager {

    private static String[] listDescriptions = new String[] {"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id orci a dui tincidunt hendrerit. Nam at elementum diam. Pellentesque rutrum dolor a est pellentesque pulvinar. Vivamus quis turpis a nunc interdum interdum. Nunc elit nunc, rhoncus non pulvinar non, scelerisque non massa.",
            "Vestibulum semper commodo justo vitae pretium. Nullam quis risus pellentesque, elementum eros ut, varius tellus. Aliquam sodales nulla erat, a eleifend sapien imperdiet ac. Quisque non turpis ac dui ultricies iaculis ornare vel nunc. Duis mollis congue nunc, a suscipit justo convallis id. Suspendisse congue lacus in velit",
            "Proin sed lobortis dui. Nunc sed eros at mi dignissim viverra. Nullam interdum aliquet feugiat. Nam sed nibh vitae ante ullamcorper semper. Praesent et congue magna. Aliquam maximus eu orci sed lobortis. Nullam molestie sem vitae finibus sollicitudin. Nam at ligula eget ipsum dignissim sollicitudin at at justo. ",
            "Fusce non dapibus magna, non sollicitudin ligula. Pellentesque dignissim sagittis ligula non consequat. Morbi rutrum ligula quam, et viverra libero aliquet vitae. Etiam pellentesque bibendum suscipit. Nullam non odio eu felis faucibus imperdiet in sit amet purus. Integer odio lectus, placerat eget ",
            "Curabitur fermentum cursus condimentum. Vivamus luctus pellentesque congue. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque nunc risus, scelerisque id congue et, mollis vel lorem. Donec sed nulla sit amet risus laoreet pellentesque. Nulla rhoncus odio quis magna vulputate suscipit. Nunc ac lacus sem.",
            "usce ex enim, malesuada sit amet nunc nec, sollicitudin accumsan nisi. Duis condimentum eros ut nunc pharetra egestas. Aliquam aliquet volutpat odio, eu euismod ante convallis ac. Etiam molestie erat semper urna viverra, non ornare velit volutpat. Etiam commodo elementum dolor, at varius tellus ullamcorper eu. ",
            "Aliquam in luctus diam. Mauris sed metus vitae est dictum gravida eu quis est. In hac habitasse platea dictumst. Sed vulputate sem sem, eu facilisis ligula aliquet sit amet. Donec imperdiet porttitor elit, et elementum dolor suscipit id. Etiam euismod tincidunt ante, ut porta massa tempus accumsan. In tincidunt, risus vel gravida finibus, ex mauris tempor justo, in ullamcorper metus libero ut ex.",
            "Sed sodales condimentum metus non vehicula. Sed at dui quis lorem lacinia pulvinar a sit amet tortor. Nulla luctus pulvinar ligula, sed vestibulum nisl tempor at. Nam nec neque odio. Phasellus viverra, ante vitae rhoncus rhoncus, odio magna blandit nisi, non imperdiet tellus libero vel urna. Nulla vitae tempus orci. ",
            "Ut in nisl nisi. In consequat porttitor purus. Morbi bibendum in lacus eget varius. Fusce pretium augue consequat nisl facilisis volutpat. Donec tempus vestibulum faucibus. Aliquam eget nunc est. Pellentesque vestibulum id tortor non vulputate. Nam sit amet mattis nisl. Sed efficitur fermentum nibh convallis elementum. Etiam viverra, nisl nec tincidunt consequat",
            "Fusce hendrerit laoreet ex, ut porta felis vehicula non. Aenean elementum, mi quis sollicitudin lacinia, augue magna condimentum nisl, egestas dignissim mi turpis eu felis. Fusce rhoncus venenatis tortor, sed lobortis ligula commodo nec. "};

    public static ArrayList<Song> songsList = new ArrayList<Song>();


    private static int songId = 9;
    private static SongManager instance = null;

    protected SongManager() {
        // Exists only to defeat instantiation.
    }

    public static SongManager getInstance() {
        if(instance == null) {
            instance = new SongManager();
            populateSongs();
        }
        return instance;
    }

    public int getSongId() {

        return ++songId;
    }

    public  void addNewSong(String name,String artist,String description)
    {
        Song newSong = new Song(getSongId(),name,artist,description);
        songsList.add(newSong);
    }


    private static void populateSongs() {

        //generation 10 new songs , with random description,there will be a duplicate description
        int i = 0;
        while (i<10) {

            Random rand = new Random();
            int  n = rand.nextInt(9) + 0;

            Song newSong = new Song((i), "Song " + (i+1), "Singer "+(i+1),listDescriptions[n]);
            songsList.add(newSong);
            i++;
        }
    }

}
