package code.helper;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 用户上传文件(头像、附件等)的辅助类
 */
public class FileUpload  {

    //上传文件
    public static String saveFile(MultipartFile file){
        return saveFile(file, "upload");
    }

    public static String saveFile(MultipartFile file, String path){
        UUID uuid = UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename:" + originalFilename);

        String extendFilename = originalFilename.substring(originalFilename.lastIndexOf("."),
                originalFilename.length());
        System.out.println("extendFilename:" + extendFilename);

        String fileName = uuid.toString() + extendFilename;
        System.out.println("fileName:" + fileName);

        try {
            String staticPath = ResourceUtils.getURL("classpath:static").getPath()
                    .replace("%20", " ");
            System.out.println("staticPath:" + staticPath);

            File newFileName = new File(staticPath + "/" + path + "/" + fileName);
            if (!newFileName.getParentFile().exists()){
                newFileName.getParentFile().mkdir();
            }
            file.transferTo(newFileName);

            System.out.println("newFileName:" + staticPath + "/" + path + "/" + fileName);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return path + "/" + fileName;
    }
}
