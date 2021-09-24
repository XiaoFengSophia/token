package com.zxf.jwttoken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/3/25 10:42
 */
public class JwtToken {
    // 公共密钥-保存在服务端，客户端不知道次密钥，以防被攻击
    public static String SECRET = "FreeMaNong";

    /**
     * 生成TOKEN
     * @return
     * @throws Exception
     */
    public static String creatToken() throws Exception {
        // 签发时间
        Date dateInit = new Date();
        //过期时间，这里是一分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);
        Date expireDate = nowTime.getTime();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("type", "JWT");
        String token = JWT.create()
                // 头信息
                .withHeader(map)
                .withClaim("name", "zxfeng")
                .withClaim("age", "25")
                .withClaim("org", "联友科技")
                // 签发时间
                .withIssuedAt(dateInit)
                // 过期时间
                .withExpiresAt(expireDate)
                // 加密
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 解密Token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) throws Exception {
        JWTVerifier Verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = Verifier.verify(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("登录凭证已过期，请重新登录！");
        }
        return jwt.getClaims();
    }

}
