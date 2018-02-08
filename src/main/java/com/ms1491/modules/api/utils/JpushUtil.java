package com.ms1491.modules.api.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;


/**
 * 极光通知配置
 * @author Administrator
 *
 */
@Component
public class JpushUtil {
	
    @Autowired
    private JPushClient jPushClient;
	
	//快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
    public PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
        
    }
    //构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 alert。
    public PushPayload buildPushObject_all_alias_alert(String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert(alert))
                .build();
    }
    //构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
    public PushPayload buildPushObject_android_tag_alertWithTitle(String alert,String title) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(alert, title, null))
                .build();
    }
    //构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，推送内容同时包括通知与消息 - 通知信息是 ALERT，
    //角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，
    //消息是 JPush 应用内消息通道的。APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
    public PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String alert,String content) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag_and("tag1", "tag_all"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(alert)
                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                 .setMessage(Message.content(content))
                 .setOptions(Options.newBuilder()
                         .setApnsProduction(true)
                         .build())
                 .build();
    }
    //构建推送对象：平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的并集）交（"alias1" 与 "alias2" 的并集），
    //推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。
    public PushPayload buildPushObject_ios_audienceMore_messageWithExtras(String content) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(content)
                        .addExtra("from", "JPush")
                        .build())
                .build();
    }
    
    
    //构建推送对象：ios-通知
    public PushPayload buildPushObject_ios_alias_alert(String content,String alia,Map<String, String> extras) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setNotification(Notification.ios(content, extras))
                .setOptions(Options.newBuilder()
                         .setApnsProduction(true)
                         .build())
                .build();
    }
    
    //构建推送对象：android-通知
    public PushPayload buildPushObject_android_alias_alert(String title,String content,String alia,Map<String, String> extras) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setNotification(Notification.android(title, content, extras))
                .build();
    }
    //构建推送对象： -message
    public PushPayload buildPushMessageObject_alias_alert(String title,String content,String alia,Map<String, String> extras) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alia))
                .setMessage(Message.newBuilder()
                        .setMsgContent(content)
                        .addExtras(extras)
                        .build())
                .build();
    }
	/**
	 * 给单个人推送消息
	 * @param message
	 */
	public void pushNotify(String title, String content, String alia,
			Map<String, String> extras) {

		PushPayload payloadAndroid = buildPushObject_android_alias_alert(title,
				content, alia, extras);
		PushPayload payloadIOS = buildPushObject_ios_alias_alert(content, alia,
				extras);
		try {
			PushResult result1 = jPushClient.sendPush(payloadAndroid);
			System.out.println("result1==" + result1);
		} catch (APIConnectionException e) {
			System.out.println("Connection error, should retry later");

		} catch (APIRequestException e) {
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}

		try {
			PushResult result2 = jPushClient.sendPush(payloadIOS);
			System.out.println("result2==" + result2);
		} catch (APIConnectionException e) {
			System.out.println("Connection error, should retry later");

		} catch (APIRequestException e) {
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}

	}
	/**
	 * 推送消息给所有人
	 * @param msgTitle
	 * @param msgContent
	 */
	public void pushNotifyToAll(String msgTitle, String msgContent) {
		PushPayload payload = buildPushObject_all_all_alert(msgContent);
		try {
			PushResult result = jPushClient.sendPush(payload);
			System.out.println("result=="+result);
		 } catch (APIConnectionException e) {
		    	System.out.println("Connection error, should retry later");

		    } catch (APIRequestException e) {
		    	System.out.println("HTTP Status: " + e.getStatus());
		    	System.out.println("Error Code: " + e.getErrorCode());
		    	System.out.println("Error Message: " + e.getErrorMessage());
		    }
	
	}
	

	
}
