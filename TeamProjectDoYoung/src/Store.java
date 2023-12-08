import java.util.ArrayList;

public class Store {
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
   static ArrayList<Store> seat = new ArrayList<>();

   public Store(int d, String t, int an,  String st, int sn) {
      this.date = d;
      this.time = t;
      this.Areanum = an;
      this.seattype = st;
      this.seatnum = sn;
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