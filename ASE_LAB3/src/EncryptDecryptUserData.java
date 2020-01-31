import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class EncryptDecryptUserData {
	 public static void main(String args[]) throws Exception{
		 
	      Signature sign = Signature.getInstance("SHA256withRSA");
	      
	      //keypair generator object creation 
	      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	      
	      //keypair object initialization
	      keyPairGen.initialize(2048);
	      
	      //fetching keypair 
	      KeyPair pair = keyPairGen.generateKeyPair();      
		
	      //cipher object creation
	      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	        
	      //Cipher object initialization
	      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
		  
	      //data to be encrypted
	      byte[] input = "username@gmail.com".getBytes();	  
	      cipher.update(input);
		  
	      //encrypt data
	      byte[] cipherText = cipher.doFinal();	 
	      
	      
	      //decrypt the data and then display to the end user
	      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
	      
	      byte[] decipheredText = cipher.doFinal(cipherText);
	   }
}
