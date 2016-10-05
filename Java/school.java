package in.ac.nitrkl.testtttttttttt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kamal pc on 15-Aug-16.
 */
public class school {

    public static final String key_rowid="_id";
    public static final String key_name="persons_name";
    public static final String key_school="persons_school";

    private static final String database_name="schooldb";
    private static final String database_table="schooltable";
    private static final int database_version=1;

    private DBHelper ourhelper;
    private Context ourcontext;
    private SQLiteDatabase ourdatabase;

    public long createEntry(String name, String school) {
        ContentValues cv=new ContentValues();
        cv.put(key_name,name);
        cv.put(key_school,school);
        return ourdatabase.insert(database_table,null,cv);
       // String str=name + school
    }

    public String getData() {
        Cursor c=ourdatabase.rawQuery( "select * from "+ database_table,null );
        String result="";

        int iRow=c.getColumnIndex(key_rowid);
        int iname=c.getColumnIndex(key_name);
        int ischool=c.getColumnIndex(key_school);

        //result= result + iRow + iname + ischool;
        if( c.moveToFirst() ) {
            while (c.moveToNext()) {
                result = result + c.getString(iRow) + " " + c.getString(iname) + " " + c.getString(ischool) + "\n";
            }
        }
        return result;
    }

    public String searchbyid(long l) {
        Cursor c=ourdatabase.rawQuery( "select * from "+ database_table+" where "+key_rowid + " ="+ l ,null );
        String result="";

        int iRow=c.getColumnIndex(key_rowid);
        int iname=c.getColumnIndex(key_name);
        int ischool=c.getColumnIndex(key_school);

        //result= result + iRow + iname + ischool;
        if( c.moveToFirst() ) {
            result = result + c.getString(iRow) + " " + c.getString(iname) + " " + c.getString(ischool);
            return result;
        }
        return "No Results Found";
    }

    public void editbyid(long l, String school) {
        ourdatabase.execSQL("UPDATE "+ database_table +" SET "+ key_school + "='"+ school +"' where " + key_rowid + "="+l);
    }

    public void deletebyid(long l) {
        ourdatabase.execSQL("DELETE FROM "+ database_table +" where " + key_rowid + "="+l);
    }


    private static class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context) {
            super(context, database_name,null,database_version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //first time when database is created it is called
            db.execSQL("Create table "+ database_table+" ( "+key_rowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+key_name+" TEXT NOT NULL, "+
                    key_school+" TEXT NOT NULL );"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //this function is called everytime
            db.execSQL("DROP TABLE IF EXISTS "+database_table);
            onCreate(db);
        }

    }

    public school(Context c){
        ourcontext=c;
    }

    public school open() throws SQLException{
        ourhelper=new DBHelper(ourcontext);
        ourdatabase=ourhelper.getWritableDatabase();
        return this;
    }

    public void close(){
        ourhelper.close();
    }

}
