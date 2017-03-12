package com.ai.portalhome.web.sys;

import com.ai.paas.util.CacheUtil;
import com.ai.paas.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author yafei
 * @since 2017/2/8
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private HttpServletRequest request;
    /**
     * 上传图片服务
     * @param files
     */
    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImage(@RequestParam MultipartFile[] files) {
        Map<String, Object> result = new HashMap<String, Object>();
        ArrayList<String> initialPreview = new ArrayList<String>();
        ArrayList<Object> initialPreviewConfig = new ArrayList<Object>();
        try {
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                // 保存文件
                String extensionName = "." + getExtensionName(fileName);

                /** 支持文件拓展名：.jpg,.png,.jpeg,.gif */
                boolean flag = Pattern.compile("\\.(jpg)$|\\.(png)$|\\.(jpeg)$|\\.(gif)$")
                        .matcher(extensionName.toLowerCase()).find();
                if (!flag) {
                    result.put("error", "请选择图片文件(.jpg,.png,.jpeg,.gif)!");
                    logger.error("上传图片失败,原因---请选择图片文件(.jpg,.png,.jpeg,.gif)!");
                }

                byte[] datas = inputStream2Bytes(file.getInputStream());

                if (datas.length > 5 * 1024 * 1024) {
                    logger.error("上传的图片大于5M!");
                    result.put("error", "图片上传失败，上传的图片必须小于5M!");
                }
                
                //测试缓存是否正确
                CacheUtil.addItem("111", "1111111111111");
                
                
                String vfsId = ImageUtil.upLoadImage(datas, fileName);
                logger.info("vfsId:"+vfsId);
                logger.info("vfsId1:"+ImageUtil.getImageUrl(vfsId));
                logger.info("vfsId2:"+ImageUtil.getImageUrlCompress(vfsId, "100x100"));
//                logger.info("vfsId1:"+ImageUtil.getImageUrl(vfsId+"_180x180!"));
//                logger.info("vfsId2:"+ImageUtil.getScaleImage("", vfsId, "50x50", "jpg", true));
                

                initialPreview.add("<img src=\""+ImageUtil.getImageUrl(vfsId)+"\" class=\"file-preview-image\" alt=\""+fileName+"\" title=\""+fileName+"\">");
//                initialPreview.add("<img src=\""+ImageUtil.getImageUrlCompress(vfsId,"300x300")+"\" class=\"file-preview-image\" alt=\""+fileName+"\" title=\""+fileName+"\">");
                Map<String,String> previewConfig = new HashMap<String,String>();
                previewConfig.put("caption", fileName);
                // 删除图片的URL
                previewConfig.put("url", request.getContextPath()+"/image/deleteimg");
                previewConfig.put("key", vfsId);
                previewConfig.put("frameClass", "file-preview-frame file-preview-success");
                initialPreviewConfig.add(previewConfig);
            }
            result.put("initialPreview", initialPreview);
            result.put("initialPreviewConfig", initialPreviewConfig);
        } catch (Exception e) {
            logger.error("上传图片出错：",e);
            result.put("error", "上传图片出错!");
        }
        return result;
    }

    /**
     * 删除图片
     * @param key
     * @return
     */
    @RequestMapping(value = "/deleteimg", method = RequestMethod.POST)
    @ResponseBody
    public Object imageMgr(@RequestParam String key) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            ImageUtil.deleteImage(key);
            //delete image Ajax请求返回数据，暂测试不通过，待补充
            result.put("error", "测试图片删除失败提示");
        } catch (Exception e) {
            result.put("error", "图片删除失败！");
        }

        return result;
    }


    private String getExtensionName(String fileName) {
        if ((fileName != null) && (fileName.length() > 0)) {
            int dot = fileName.lastIndexOf('.');
            if ((dot > -1) && (dot < (fileName.length() - 1))) {
                return fileName.substring(dot + 1);
            }
        }
        return fileName;
    }

    private byte[] inputStream2Bytes(InputStream in) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[4096];
        int count = -1;
        while ((count = in.read(data, 0, 4096)) != -1)
            outStream.write(data, 0, count);
        return outStream.toByteArray();
    }
}
