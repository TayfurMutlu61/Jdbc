package techpro.jdbc_exa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc5CRUD {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234");
		Statement st = con.createStatement();
	//   ORNEK1: urunler adinda bir tablo olusturalim id(NUMBER(3), 
	    //            isim VARCHAR2(10) fiyat NUMBER(7,2)   
	        
//	      st.execute("CREATE TABLE urunler ("
//	              + " id NUMBER(3),"
//	              + " isim VARCHAR2(10),"
//	              + " fiyat NUMBER(7,2))");
//	      System.out.println("tablo olusturuldu");
		
		
		
		
		
		
		
		//ornek2 urunler tablosuna asagidaki kayitlari toplu bir sekilde ekleyelim
		
		
		// Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir. 
		// PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir. 
		// Bunun icin; 
//		     1) Veri girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
//		     2) POJO Class nesnelerini saklayacak bir collection olusturulur
//	     3) bir dongu ile kayitlar eklenir. 
		
		List<Urun> kayitlar = new ArrayList<>();
		
		kayitlar.add(new Urun(101,"laptop", 6500));
		kayitlar.add(new Urun(102,"PC", 4500));
		kayitlar.add(new Urun(103,"Telefon", 4500));
		kayitlar.add(new Urun(104,"Anakart", 1500));
		kayitlar.add(new Urun(105,"Klavye", 200));
		kayitlar.add(new Urun(106,"Fare", 100));
		
		

		PreparedStatement pst=con.prepareStatement("INSERT INTO urunler VALUES(?,?,?)");
		
		
		for(Urun w : kayitlar) {
			pst.setInt(1, w.getId());
			pst.setString(2, w.getIsim());
			pst.setDouble(3,w.getFiyat());
			
			pst.addBatch();
			
		}
		pst.executeBatch();
		
		System.out.println("islem tamam");
		
		
		st.close();
		con.close();
		pst.close();
		
		
		
		
		
		 //tercih nedenleri
	      //1: h??zl??d??r, ??oklu sorgular?? bir seferde yollar
//	    2: haz??rlanan deyimlerin en ??nemli avantaj?? SQL enjeksiyon sald??r??lar??n?? ??nlemeye yard??mc?? olmas??d??r. SQL enjeksiyonu, SQL ifadelerinde istemci taraf??ndan sa??lanan verileri kullanan
//	    uygulamalardan k??t?? niyetli olarak yararlanma tekni??idir. Sald??rganlar, ??zel haz??rlanm???? dize giri??i sa??layarak SQL motorunu istenmeyen komutlar?? y??r??tmesi i??in kand??r??r,
//	    b??ylece k??s??tl?? verileri g??r??nt??lemek veya i??lemek i??in bir veritaban??na yetkisiz eri??im elde eder. SQL enjeksiyon tekniklerinin t??m??, uygulamadaki tek bir g??venlik a????????ndan yararlan??r
//	     Yanl???? do??rulanm???? veya do??rulanmam???? dize de??i??mezleri, dinamik olarak olu??turulmu?? bir SQL ifadesinde birle??tirilir ve SQL motoru taraf??ndan kod olarak yorumlan??r. 
//	    Haz??rlanan ifadeler, m????teri taraf??ndan sa??lanan verileri her zaman bir parametrenin i??eri??i olarak ele al??r ve asla bir SQL ifadesinin par??as?? olarak kabul etmez.
	      
		
		
		
	}

}
