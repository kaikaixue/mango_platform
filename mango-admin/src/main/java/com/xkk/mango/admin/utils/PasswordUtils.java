package com.xkk.mango.admin.utils;

/**
 * 密码工具类
 */
public class PasswordUtils {

    /**
     * 匹配密码
     * @param salt
     * @param rawPass 明文
     * @param encPass 密文
     * @return
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }
}
