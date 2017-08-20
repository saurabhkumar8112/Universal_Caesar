import java.util.Random;
import java.util.Scanner;;

public class Caesar {
	private static int b;
	private static int key;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
    	Random rn=new Random();
    	key=  rn.nextInt(128);
		System.out.println("Welcom to the caeser cipher's world\nWant to encrypt or Decypt Something ? Enter 1 and 0 accordingly: ");
		b=scn.nextInt();
		scn.nextLine();
		if(b==1)
		{
//			System.out.print("Enter the key for Encryption: ");  no need of this now
			System.out.println("Enter the Message to be encrypted: ");
	    	String str=scn.nextLine();
			String encrypted = en(str, key);
			System.out.println(encrypted);
			kValue(str,encrypted);
		}
//		weyvefl mw er ewwspi  && key=4

		else if(b==0)
		{
			while(true)
			{   
				System.out.println("Enter the Message: ");
		    	String str=scn.nextLine();
//				System.out.print("Enter the Key to decrypt: ");
				String decrypted = de(str, key);
				System.out.println(decrypted);
				System.out.println("Got the decrypted msg? enter 1 to confirm ");
				int i=scn.nextInt();
				if(i==1)
				{   kValue(str,decrypted);
					break;
				}
				else{continue;}
			}
		}
		else
		{
			System.out.println("Enter valid chice");
		}
	}

	public static String en(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder collector = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			int p = ch;
		
			p=(p+k)%128;
			
			collector.append((char) p);
			
		}
		return collector.toString();
	}

	public static String de(String str, int k) {
		String en1 = en(str, 128-k);
		return en1;

	}
	public static void kValue(String string1,String string2){
		if(string1.equals(string2)){
			System.out.println("The value of k is/was either 0 or 128");
		}
		else{
			int k= (string2.charAt(0)-string1.charAt(0))%128;
			if(k<0){
				k+=128;
			}
			if(Caesar.b==1){
			System.out.println("The value of k in this encrpypted code is "+k);}
			if(Caesar.b==0){
				k=(128-k)%128;
				System.out.println("The value of k was "+k);
			}
			if(Caesar.key==(k)){
				System.out.println("congratulations test case passed!!");
			}
		}
		
		
	}

}