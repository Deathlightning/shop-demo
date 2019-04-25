package xyz.kingsword.shopdemo.model.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: wzh date: 2019-04-22 10:06
 * @version: 1.0
 **/
public class CheckCodeUtil {
    private static Set<String> codeSet = new HashSet<>(10);

    public static void sendCode(String to) {
        String simpleUUID = IdUtil.simpleUUID();
        MailUtil.send(to, "验证码", "您的验证码：" + simpleUUID + "十分钟内有效", false);
        new Reminder(simpleUUID);
    }

    public static boolean cherifyCode(String code) {
        return codeSet.remove(code);
    }

    public static class Reminder {
        Timer timer;

        Reminder(String code) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    codeSet.remove(code);
                    timer.cancel();
                }
            }, 5000);
        }

    }
}
