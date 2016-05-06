package tryworks.rpc;

import com.alcatelsbell.nms.util.mail.MailUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 2016/4/27
 * Time: 15:55
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class Server implements ServerAPI{
    private Log logger = LogFactory.getLog(getClass());
    @Override
    public HashMap sendMail(String toAddress, String title,String body) throws IOException {
        logger.info("sendMail() called with " + "toAddress = [" + toAddress + "], title = [" + title + "], body = [" + body + "]");
        if (toAddress == null)
            toAddress = "4278246@qq.com;rongrong.chen@alcatel-sbell.com.cn";

        MailUtil.sendDirectMail(title, body, toAddress.split(";"));
        HashMap map = new HashMap();
        map.put("result","success");
        logger.info("sendMail() success");
        return map;
    }
}
