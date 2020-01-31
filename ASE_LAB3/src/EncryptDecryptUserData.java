import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class EncryptDecryptUserData {
	 public static void main(String args[]) throws Exception{
	      
	      //keypair generator object creation 
	      KeyPairGenerator kp = KeyPairGenerator.getInstance("RSA");
	      
	      //keypair object initialization
	      kp.initialize(2048);
	      
	      //fetching keypair 
	      KeyPair pair = kp.generateKeyPair();      
		
	      //cipher object creation
	      Cipher cipher_obj = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	        
	      //Cipher object initialization
	      cipher_obj.init(Cipher.ENCRYPT_MODE, pair.getPublic());
		  
	      //data to be encrypted
	      byte[] input = "Important Data of user".getBytes();	  
	      cipher_obj.update(input);
		  
	      //encrypt data
	      byte[] cipherData = cipher_obj.doFinal();	 
	      
	      System.out.println(new String(cipherData, "UTF8"));
	      
	      //decrypt the data and then display to the end user
	      cipher_obj.init(Cipher.DECRYPT_MODE, pair.getPrivate());
	      
	      byte[] decipheredText = cipher_obj.doFinal(cipherData);
	      System.out.println(new String(decipheredText));
	   }
}
