package com.xkk.mango.backup.service;

/**
 * MySQL命令行备份恢复服务
 */
public interface MysqlBackupService {
    /**
     * 备份数据库
     * @param host
     * @param userName
     * @param password
     * @param backupFolderPath 备份的路径
     * @param fileName  备份的文件名
     * @param database  数据库名称
     * @return
     */
    boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception;

    /**
     * 恢复数据库
     * @param restoreFilePath   数据库备份的脚本路径
     * @param host
     * @param userName
     * @param password
     * @param database
     * @return
     */
    boolean restore(String restoreFilePath, String host, String userName, String password, String database);
}
