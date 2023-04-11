package com.xkk.mango.common.utils;

import java.io.*;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件相关操作
 */
public class FileUtils {
    /**
     * 下载文件
     * @param response
     * @param file
     * @param newFileName
     */
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsoluteFile());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归删除文件
     * @param file
     */
    public static void deleteFile(File file) {
        // 判断是否为目录，不是则跳过，如果是，先清空内部
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            // 遍历目录
            for (File subFile : subFiles) {
                // 递归删除
                deleteFile(subFile);
            }
        }
        // 删除文件或空目录
        file.delete();
    }
}
