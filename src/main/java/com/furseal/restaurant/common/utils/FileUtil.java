package com.furseal.restaurant.common.utils;

import com.furseal.restaurant.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author hejishan
 */
@Slf4j
public class FileUtil {
    public static String uploadFile(MultipartFile file) {
        String uploadUrl = Constants.FILE_UPLOAD_DEFAULT_URL;
        if (StringUtils.isNotEmpty(PropertiesUtil.getValue(Constants.Properties.FILE_UPLOAD_URL))) {
            uploadUrl = PropertiesUtil.getValue(Constants.Properties.FILE_UPLOAD_URL);
        }
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int indexOf = fileName.lastIndexOf(".");
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static" + uploadUrl;
            fileName = StringUtil.getRandomUUID() + fileName.subSequence(indexOf, fileName.length());
            path = path + fileName;
            String realPath = path.replace('/', '\\').substring(1, path.length());
            File uploadFile = new File(realPath);
            if (!uploadFile.exists()) {
                //文件目录不存在，直接创建
                uploadFile.mkdirs();
            }
            file.transferTo(uploadFile);
        } catch (Exception e) {
            log.error("upload file error!!!");
            return null;
        }
        return "/static" + uploadUrl + "/" + fileName;
    }

    public static String uploadLogo(MultipartFile file) {
        String uploadUrl = Constants.FILE_UPLOAD_DEFAULT_URL;
        if (StringUtils.isNotEmpty(PropertiesUtil.getValue(Constants.Properties.FILE_UPLOAD_URL))) {
            uploadUrl = PropertiesUtil.getValue(Constants.Properties.FILE_UPLOAD_URL);
        }
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int indexOf = fileName.lastIndexOf(".");
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static" + uploadUrl + "/logo";
            path = path + "\\logo" + fileName.subSequence(indexOf, fileName.length());
            String realPath = path.replace('/', '\\').substring(1, path.length());
            File uploadFile = new File(realPath);
            if (!uploadFile.exists()) {
                //文件目录不存在，直接创建
                uploadFile.mkdirs();
            }
            file.transferTo(uploadFile);
        } catch (Exception e) {
            log.error("upload file error!!!");
            return null;
        }
        return "/static" + uploadUrl + "/logo/logo" + fileName.subSequence(indexOf, fileName.length());
    }
}
