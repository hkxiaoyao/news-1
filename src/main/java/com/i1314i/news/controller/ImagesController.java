package com.i1314i.news.controller;

import com.i1314i.news.utils.VerifyCodeUtils;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ImagesController {

    @RequestMapping(value = "/getimages")
    public void getImage(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setHeader("contentType", "text/html; charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 150, h = 37;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    @RequestMapping(value = "/verifycodeValidate", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    boolean verifycode(String verifycode, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String verify = (String) session.getAttribute("verCode");
        if (verify.equals(verifycode)) {
            return true;
        } else
            return false;
    }


    @RequestMapping(value = "admin/html/adminhtml/uploadImage")
    private void uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam MultipartFile[] upload) {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String callback = request.getParameter("CKEditorFuncNum");

        // 获得response,request
        Map<String, Object> m = new HashMap<String, Object>();

        if (!ServletFileUpload.isMultipartContent(request)) {
            m.put("error", 1);
            m.put("message", "请选择文件!");

        }

        String originalFileName = null;//上传的图片文件名
        String fileExtensionName = null;//上传图片的文件扩展名
        for (MultipartFile file : upload) {
            if (file.getSize() > 10 * 1024 * 1024) {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                        + ",''," + "'文件大小不得大于10M');");
                out.println("</script>");

            }

            originalFileName = file.getOriginalFilename();

            fileExtensionName = originalFileName.substring(
                    originalFileName.lastIndexOf("."), originalFileName.length()).toLowerCase();

            String[] imageExtensionNameArray = WebsiteConstant.IMAGE_EXTENSION_NAME_ARRAY;

            String allImageExtensionName = "";
            boolean isContain = false;//默认不包含上传图片文件扩展名
            for (int i = 0; i < imageExtensionNameArray.length; i++) {
                if (fileExtensionName.equals(imageExtensionNameArray[i])) {
                    isContain = true;
                }
                if (i == 0) {
                    allImageExtensionName += imageExtensionNameArray[i];
                } else {
                    allImageExtensionName += " , " + imageExtensionNameArray[i];
                }

            }

            String newFileName = java.util.UUID.randomUUID().toString() + fileExtensionName;
            String uploadPath = WebsiteConstant.PIC_APP_FILE_SYSTEM_CKEDITOR_LOCATION;
            if (isContain) {//包含
                File pathFile = new File(uploadPath);
                if (!pathFile.exists()) { // 如果路径不存在，创建
                    pathFile.mkdirs();
                }
                try {
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadPath, newFileName));
                    //    InputStream is=file.getInputStream();
                    //    File toFile = new File(uploadPath, newFileName);
                    //    OutputStream os = new FileOutputStream(toFile);
                    //    byte[] buffer = new byte[1024];
                    //    int length = 0;
                    //    while ((length = is.read(buffer)) > 0) {
                    //     os.write(buffer, 0, length);
                    //    }
                    //    is.close();
                    //    os.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                String imageUrl = WebsiteConstant.PIC_APP_SERVER_URL + "images/ckeditor/" + newFileName;
                // 返回"图像信息"选项卡并显示图片 ,在对应的文本框中显示图片资源url
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                        + ",'" + imageUrl + "','')");
                out.println("</script>");

            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                        + ",''," + "'文件格式不正确（必须为" + allImageExtensionName + "文件）');");
                out.println("</script>");
            }

        }
    }

    public static class WebsiteConstant {
        public static String[] IMAGE_EXTENSION_NAME_ARRAY = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        public  static String PIC_APP_SERVER_URL = "http://localhost:8080/Picture/";
        public  static String PIC_APP_FILE_SYSTEM_CKEDITOR_LOCATION = "D:/Picture/images/ckeditor/";
        public  final int SUCCESS = 1; // 操作成功
    }
}