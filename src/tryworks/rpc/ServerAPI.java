package tryworks.rpc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 2016/4/27
 * Time: 15:56
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface ServerAPI  {
    public HashMap sendMail(String toAddress, String title, String body) throws IOException ;
}
