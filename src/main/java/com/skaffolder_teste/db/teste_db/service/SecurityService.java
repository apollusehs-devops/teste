/* 
* Generated by
* 
*      _____ _          __  __      _     _
*     / ____| |        / _|/ _|    | |   | |
*    | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __
*     \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
*     ____) |   < (_| | | | || (_) | | (_| |  __/ |
*    |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|
*
* The code generator that works in many programming languages
*
*			https://www.skaffolder.com
*
*
* You can generate the code from the command-line
*       https://npmjs.com/package/skaffolder-cli
*
*       npm install -g skaffodler-cli
*
*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
*
* To remove this comment please upgrade your plan here: 
*      https://app.skaffolder.com/#!/upgrade
*
* Or get up to 70% discount sharing your unique link:
*       https://app.skaffolder.com/#!/register?friend=5ea8cb8382f82d390e77f827
*
* You will get 10% discount for each one of your friends
* 
*/
package com.skaffolder_teste.db.teste_db.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.skaffolder_teste.db.teste_db.entity.User;

@Service
@PropertySource("classpath:application.properties")
public class SecurityService {
	
	@Value( "${token.secret}" )
	private String secret;
	
	
	public User verifyToken(String token) throws Exception {
		if(token == null)
			throw new Exception("Token not found");
		User user = null;
		try {
			//decode token
			Algorithm algorithm = Algorithm.HMAC256("secret");
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify((String)token);
			String userJSON = jwt.getClaims().get("user").asString();

			// Set user in Authentication Service
        	Gson gson = new Gson();
			User DecodedUser = gson.fromJson(userJSON, User.class);
			DecodedUser.setPassword(null);
			user = DecodedUser;
		} catch (IllegalArgumentException | UnsupportedEncodingException | SignatureVerificationException e) {
        	throw new Exception("Token not valid");
		}	
		return user;
	}
	
		public String verifyTokenJson(String token) throws Exception {
		if(token == null)
			throw new Exception("Token not found");
		User user = null;
		try {
			//decode token
			Algorithm algorithm = Algorithm.HMAC256("secret");
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify((String)token);
			String userJSON = jwt.getClaims().get("user").asString();
			return userJSON;
		} catch (IllegalArgumentException | UnsupportedEncodingException | SignatureVerificationException e) {
        	throw new Exception("Token not valid");
		}
	}
	

}
