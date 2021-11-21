package com.zxf.utils;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "zxf.jwt")
public class JwtUtils {

	private long expire;
	private String secret;
	private String header;

	// 生成jwt
	public String creatToken() {
		//当前时间
		Date dateInit = new Date();
		//过期时间
		Date expireDate = new Date(dateInit.getTime() + 1000 * expire);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("type", "JWT");

		Map<String, Object> mapClaim = new HashMap<String, Object>();
		mapClaim.put("name", "zxfeng");
		mapClaim.put("age", "25");
		mapClaim.put("org", "联友科技");

		return Jwts.builder()
				// 头信息
				.setHeader(map)
				.setClaims(mapClaim)
				// 设置主题
				.setSubject(header)
				// 签发时间
				.setIssuedAt(dateInit)
				// 过期时间
				.setExpiration(expireDate)// 分钟過期
				// 加密
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	// 解析jwt
	public Claims getClaimByToken(String jwt) {
		try {
			return Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(jwt)
					.getBody();
		} catch (Exception e) {
			return null;
		}
	}

	// jwt是否过期
	public boolean isTokenExpired(Claims claims) {
		return claims.getExpiration().before(new Date());
	}

}
