package musiqapp;

import java.security.SecureRandom;

class RandomGenerator {

	String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	SecureRandom rnd = new SecureRandom();
	
	def randomString(int len){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ )
		  sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
}
