package techpro.jdbc_exa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc3DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234");
		Statement st = con.createStatement();
		
		/*her sorguda öncekileri yoruma al hata vermesin
		   A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
		      dondurmeyen metotlar kullanilmalidir.(executeQuery kullanamayız) Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
		       1) execute() metodu 
		       2) excuteUpdate() metodu.  
		       
		   B) - execute() metodu hertur SQL ifadesiyle kullanilabilen genel bir komuttur.
		      - execute(), Boolean bir deger dondurur. DDL islemlerin false dondururken, 
		        DML islemlerinde true deger dondurur. 
		      - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
		        durumlarda tercih edilmektedir.  
		        
		   C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
		      - bu islemlerde islemden etkilenen satir sayisini dondurur.
		      - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
		*/
		
		//ORNEK1:isciler adinda bir tablo olusturunuz id NUMBER(3), 
		//birim VARCHAR2(10), maas NUMBER(5)
		
//		st.execute("CREATE TABLE isciler"  //st.executeUpdate("             ")  -->ikinici yolda bu sekildedir
//				
//				+ " (id NUMBER(3),"
//				+ " birim VARCHAR(10),"
//				+ " maas NUMBER(5))");
//		
//		System.out.println("isciler tablosu olustruldu");
//		System.out.println("========================================");
		
		
		
		
		
		//ornek2)isciler tablosunu kalici olarak siliniz
		
//		st.executeUpdate("DROP TABLE isciler PURGE");
//		
//		System.out.println("ISCILER TABLOSU SILINDI");
		
		
		
 //ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar2(20)} ekleyiniz.  
		
//		st.executeUpdate("ALTER TABLE isciler ADD isim VARCHAR(20)");
//		System.out.println("sutun eklendi");
		System.out.println("========================================");
		
		
		
		//ORNEK4:isciler tablosundaki soyisim sutunu siliniz.
		
//		st.execute("ALTER TABLE isciler DROP COLUMN maas");
//		System.out.println("islem tamam");
		System.out.println("========================================");
		//ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz. 
		
		st.executeUpdate("ALTER TABLE isciler RENAME TO calisanlar10");
		System.out.println("islem tamammmmmmm");
		
	}

}
