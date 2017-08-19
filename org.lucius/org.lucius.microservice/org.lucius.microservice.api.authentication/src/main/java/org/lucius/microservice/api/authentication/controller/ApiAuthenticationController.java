package org.lucius.microservice.api.authentication.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.lucius.commons.utils.encrypt.AESUtils;
import org.lucius.commons.utils.model.Result;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ApiAuthenticationController {
	
	private static final Map<String, String> keyMap = new ConcurrentHashMap<String, String>();
	
	public Result<String> generateToken() throws Exception {
		
		String keyId = UUID.randomUUID().toString();
		String encryptKey = UUID.randomUUID().toString();
		
		keyMap.put(keyId, encryptKey);
		
		
        String content = "xxxxxxxxxxxxxxxxx";
        String compactJws = Jwts.builder()// 返回的字符串便是我们的jwt串了
				.claim("info", AESUtils.encrypt(content, encryptKey))
				.setExpiration(new Date(System.currentTimeMillis() + 10000000))// 过期时间
                .setAudience("clientId")// 请求者
                .setIssuer("API-AUTH")// 签发者
                .setSubject("subject001")// 主题
                .setIssuedAt(new Date())// 签发时间
                .setNotBefore(new Date(System.currentTimeMillis()))
                .setId(keyId)// 公钥ID作为签名ID
        		.signWith(SignatureAlgorithm.HS512, encryptKey)// 私钥作为签名Key
				.compact();// 这个是全部设置完成后拼成jwt串的方法
        
        System.out.println(compactJws);
        
        Claims claims = Jwts.parser().setSigningKey(encryptKey)
				.parseClaimsJws(compactJws).getBody();
        
        System.out.println(claims);
        String string = claims.get("info", String.class);
        System.out.println(AESUtils.decrypt(string, encryptKey));
		
		return null;
	}
	
	public Result<Boolean> checkToken(String jwts,String keyId) throws Exception {
		String encryptKey = keyMap.get(keyId);
        Claims claims = Jwts.parser().setSigningKey(encryptKey)
				.parseClaimsJws(jwts).getBody();
        System.out.println(claims);
        String string = claims.get("info", String.class);
        System.out.println(AESUtils.decrypt(string, encryptKey));
		return null;
	}
	
	public static void main(String[] args) {
		String keyId = UUID.randomUUID().toString();
		String encryptKey = UUID.randomUUID().toString();
		
		keyMap.put(keyId, encryptKey);
		
		
        String content = "xxxxxxxxxxxxxxxxx";
        String compactJws = Jwts.builder()// 返回的字符串便是我们的jwt串了
				.claim("info", AESUtils.encrypt(content, encryptKey))
				.setExpiration(new Date(System.currentTimeMillis() + 10000000))// 过期时间
                .setAudience("clientId")// 请求者
                .setIssuer("API-AUTH")// 签发者
                .setSubject("subject001")// 主题
                .setIssuedAt(new Date())// 签发时间
                .setNotBefore(new Date(System.currentTimeMillis()))
                .setId(keyId)// 公钥ID作为签名ID
        		.signWith(SignatureAlgorithm.HS512, encryptKey)// 私钥作为签名Key
				.compact();// 这个是全部设置完成后拼成jwt串的方法
        
        System.out.println(compactJws);
        
        Claims claims = Jwts.parser().setSigningKey(encryptKey)
				.parseClaimsJws(compactJws).getBody();
        
        System.out.println(claims);
        String string = claims.get("info", String.class);
        System.out.println(AESUtils.decrypt(string, encryptKey));
	}

}
