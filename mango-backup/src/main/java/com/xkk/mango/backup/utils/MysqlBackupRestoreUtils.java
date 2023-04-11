package com.xkk.mango.backup.utils;

import java.io.File;
import java.io.IOException;

/**
 * Mysql备份还原工具类
 */
public class MysqlBackupRestoreUtils {

    /**
     * 备份数据库
     * @param host
     * @param userName
     * @param password
     * @param backupFolderPath
     * @param fileName
     * @param database
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws IOException, InterruptedException {
        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在，则创建
            backupFolderFile.mkdirs();
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }
        // 拼接命令行的命令
        String backupFilePath = backupFolderPath + fileName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt ").append(" --add-drop-database ").append(" --add-drop-table ");
        stringBuilder.append(" -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database);
        // 调用外部执行 exe 文件的 Java API
        Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
        if (process.waitFor() == 0) {
            // 0 表示线程正常终止
            System.out.println("数据备份到" + backupFilePath + "文件中");
            return true;
        }
        return false;
    }

    /**
     * 还原数据库
     * @param restoreFilePath
     * @param host
     * @param userName
     * @param password
     * @param database
     * @return
     */
    public static boolean restore(String restoreFilePath, String host, String userName, String password, String database) {
        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从" + restoreFilePath + "导入到数据库中");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if (os.toLowerCase().startsWith("win")) {
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = { shell, c, command };
        return cmd;
    }
}
