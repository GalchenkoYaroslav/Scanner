package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Bogdan on 4/14/2016.
 */
public class Serializer {
    public static boolean saveToHardDrive(String directory, String text){
        try {
            Date date = Calendar.getInstance().getTime();
            try(PrintWriter out = new PrintWriter(directory +
                    (date.getYear()+1900) + "-" + (date.getMonth()+1) + "-" + (date.getDate())+
                    "_" + date.getHours() + "-" + date.getMinutes() + "-" + date.getSeconds()
                    + ".txt")  ){
                out.println( text );
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
