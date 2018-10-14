
//Giả sử thu mục là F:/DEMO
//Sau khi quét ta đc : 
//      1 ac.txt ----------------------------------> Sau khi tìm kiếm ký tự TGDD sẽ hiện ra file ac.txt
//------123TGDĐ
//      2-baitap.txt
//------truongquocthang

package baitapsearchstring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author admin
 */
public class ScanTimKiem {
    public static final String DEMO_FOLDER = "F:\\DEMO";
private final ArrayList<String> listFile;
private final ArrayList<String> listChecked;

 public ScanTimKiem() {
listFile = new ArrayList<>();
listChecked = new ArrayList<>();
}

 void listFileTxt() {
File folder = new File(DEMO_FOLDER);
File[] allFile = folder.listFiles();
for (File x : allFile) {
if (x.toString().endsWith(".txt")) {
listFile.add(x.toString());
}
}
}

 void filterFile(String byString) {
try {
for (String x : listFile) {
BufferedReader br = new BufferedReader(new FileReader(x));
String content;
while ((content = br.readLine()) != null) {
if (content.contains(byString)) {
listChecked.add(x);
}
}
br.close();
}
} catch (FileNotFoundException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}
}

 void displayAllTxt() throws IOException {
for (String x : listChecked) {
System.out.println(x);
 for(int i=0;i<listChecked.size();i++)
       {
           try {
               BufferedReader br = new BufferedReader(new FileReader(listChecked.get(i))); 
               String str;
                    while ((str=br.readLine()) != null) { 
                      //  System.out.println(str);
                           if(str.equalsIgnoreCase(x)  )
                                {
                                    System.out.println("Duong Dan:"+listChecked.get(i)); 
                                }
                        }
              
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Timfile.class.getName()).log(Level.SEVERE, null, ex); 
           }
            
       }

try {
			File file = new File(x);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Nội dung của File :");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
     public static void printLine() 
    { 
        System.out.println(); 
         
        for(int i = 1; i <= 100; i++) 
        { 
            if(i == 1 || i == 100) 
            { 
                System.out.print("+"); 
            } 
            else 
            { 
                System.out.print("-"); 
            } 
        } 
    } 

    public static void main(String[] args) throws IOException {  
         printLine(); 
        System.out.printf("\n| %-90s %7s", "Giả sử thu mục là F:/DEMO ", "|");
        System.out.printf("\n| %-90s %7s", "1     -ac.txt ", "|"); 
        System.out.printf("\n| %-90s %7s", "123TGDĐ", "|"); 
        System.out.printf("\n| %-90s %7s", "2     -baitap.txt ", "|"); 
        System.out.printf("\n| %-90s %7s", "truongquocthang", "|"); 
        System.out.printf("\n|------------------------------------------------------------------- |");
        System.out.printf("\n|--------------------------------------------------------------------|");
        System.out.printf("\n");
        
        System.out.printf("\n\f\f\f\f| %-90s %7s", "Menu: ", "|"); 
        System.out.printf("\n| %-90s %7s", "1. Quet thu muc.", "|"); 
        System.out.printf("\n| %-90s %7s", "2. Tim kiem ký tự (TGDĐ) trong file thu muc", "|"); 
        System.out.printf("\n| %-90s %7s", "3. Ket thuc", "|"); 
         System.out.printf("\n"); 
        
        printLine(); 
        int chon=0;
         
       
        while(chon!=3){
            System.out.print("\nBạn nhập vào chức năng: ");
             chon = new Scanner(System.in).nextInt();
        switch(chon) 
                { 
                    case 1: 
                    { 
                      System.out.println("Nhap duong dan folder ban muon scan ( Vi du : F:/DEMO) : "); // Vi DU : ( C:/ , F:/)
      Scanner s1 = new Scanner(System.in);
      String folderPath = s1.next();
      File folder = new File(folderPath);
      
      if (folder.isDirectory()) {
         File[] listOfFiles = folder.listFiles(); //Trả về một mảng các đối tượng File, là các tập tin và các thư mục con của thư mục hiện tại.

         if (listOfFiles.length < 1)System.out.println(
            "Khong co File nao trong folder");
         else System.out.println("Danh sach cac file va Folder");
         for (File file : listOfFiles) {
             if ( file.isDirectory() ) {
                System.out.println("Dir:" + file.getAbsoluteFile());
            }
            else {
                    System.out.println("File:" + file.getAbsoluteFile());
                  
            }
         } 
       
      }
      else System.out .println("Duong dan sai :" + folderPath);
        
                break;
                    } 
                    case 2: // Neu file nao co noi dung ben trong la "TGDD" thi in ra ten file
                    { 
                        Scanner sc = new Scanner(System.in);
                        ScanTimKiem main = new ScanTimKiem();
                        main.listFileTxt();
                        System.out.println("Xin Moi Nhap Chuoi Can Tim Trong Cac File:");
                        String chuoi = sc.nextLine();
                        main.filterFile(chuoi); //tim ky tu string co noi dung TGDD trong   cac filefile
                        main.displayAllTxt();
                       
                        break; 
                    } 
        
                    case 3 :
                    {
                       
                    }
    

        }   
    }
    }
   
}