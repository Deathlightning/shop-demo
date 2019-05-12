package xyz.kingsword.shopdemo.model.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wzh date: 2019-05-12 20:55
 * @version: 1.0
 **/
public class CDIContainer {
    private static final Map<String, Class> classMap = new HashMap<>(10);
    private static final String CLASS_PATH = CDIContainer.class.getResource("/").getPath();
    private static final String FILE_TYPE = "class";

    public static void main(String[] args) throws IOException {
        System.out.println(CLASS_PATH);
        System.out.println(CDIContainer.class);
        recursiveDirectory(new File(CLASS_PATH));
    }

    private static void recursiveDirectory(File parentFile) throws IOException {
        if (parentFile == null || !parentFile.isDirectory()) {
            return;
        }
        File[] files = parentFile.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                recursiveDirectory(file);
            } else {
                //找到.class文件
                String fileName = file.getName();
                if (FILE_TYPE.equals(fileName.split("\\.")[1])) {
                    String filePath = file.getCanonicalPath();
                    System.out.println(filePath.replace(CLASS_PATH, "").replace("\\/", "\\.") + fileName.split("\\.")[0]);
                }
            }
        }
    }
}
