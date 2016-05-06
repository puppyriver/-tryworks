package tryworks.web.controller;

import com.alcatelsbell.nms.util.mail.MailUtil;
import tryworks.*;

import tryworks.common.fs.FileSystem;
import tryworks.model.*;
import tryworks.util.JdbcTemplateUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: Ronnie.Chen
 * Date: 2016/3/15
 * Time: 20:34
 * rongrong.chen@alcatel-sbell.com.cn
 */
@Controller
@RequestMapping("/*")
public class PMAjaxController extends AbstractAjaxController{
    private FileSystem fileSystem = FileSystem.getFileSystem("fs");
  //  private JdbcTemplate jdbcTemplate = Configuration.getJdbcTemplate();

//    @RequestMapping(value="insert",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    PM_DATA insert(@RequestBody PM_DATA pm_data) throws IOException {
//        pm_data.setId(111l);
//        return pm_data;
//    }



    @RequestMapping(value="sendMail")
    public @ResponseBody
    HashMap queryEntity(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String toAddress = request.getParameter("toAddress");
        if (toAddress == null)
            toAddress = "4278246@qq.com;rongrong.chen@alcatel-sbell.com.cn";
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        MailUtil.sendDirectMail(title, body, toAddress.split(";"));
        HashMap map = new HashMap();
        map.put("result","success");
        return map;
    }





}
