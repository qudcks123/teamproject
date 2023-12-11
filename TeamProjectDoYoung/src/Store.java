import java.util.ArrayList;
import java.io.*;
public class Store implements Serializable{
   String name;
   String tel;
   int reseve;
   String mail;
   String server;
   int seatnum;
   String seattype;
   int date;
   String time;
   int Areanum;
   String birthday;
   int ReNum;

   public Store(int d, String t, int an,  String st, int sn, int rn) {
      this.date = d;
      this.time = t;
      this.Areanum = an;
      this.seattype = st;
      this.seatnum = sn;
      this.ReNum = rn;
   }
   
   public Store(String n, String tel, String m, String s, String b, int rn) {
      this.name = n;
      this.tel = tel;
      this.mail = m;
      this.server = s;
      this.birthday = b;
      this.ReNum = rn;
   }
}