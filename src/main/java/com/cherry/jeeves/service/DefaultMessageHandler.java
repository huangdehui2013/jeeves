package com.cherry.jeeves.service;

import com.cherry.jeeves.domain.shared.ChatRoomMember;
import com.cherry.jeeves.domain.shared.Contact;
import com.cherry.jeeves.domain.shared.Message;
import com.cherry.jeeves.domain.shared.RecommendInfo;
import com.cherry.jeeves.utils.MessageUtils;
import com.cherry.jeeves.utils.WechatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

public class DefaultMessageHandler implements MessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultMessageHandler.class);

    @Override
    public void onReceivingChatRoomTextMessage(Message message) {
        logger.info("[*] chatroom message:");
        logger.info("[*] from chatroom: " + message.getFromUserName());
        logger.info("[*] from person: " + MessageUtils.getSenderOfChatRoomTextMessage(message.getContent()));
        logger.info("[*] to: " + message.getToUserName());
        logger.info("[*] content:" + WechatUtils.textDecode(MessageUtils.getChatRoomTextMessageContent(message.getContent())));
    }

    @Override
    public void onReceivingChatRoomImageMessage(Message message, String thumbImageUrl, String fullImageUrl) {
        logger.info("onReceivingChatRoomImageMessage");
    }

    @Override
    public void onReceivingPrivateTextMessage(Message message) throws IOException {
        logger.info("[*] private message:");
        logger.info("[*] from: " + message.getFromUserName());
        logger.info("[*] to: " + message.getToUserName());
        logger.info("[*] content:" + WechatUtils.textDecode(message.getContent()));
    }

    @Override
    public void onReceivingPrivateImageMessage(Message message, String thumbImageUrl, String fullImageUrl) throws IOException {
        logger.info("onReceivingPrivateImageMessage");
    }

    @Override
    public boolean onReceivingFriendInvitation(RecommendInfo info) throws IOException {
        logger.info("[*] friend invitation message:");
        logger.info("[*] recommendinfo content:" + WechatUtils.textDecode(info.getContent()));
        return false;
    }

    @Override
    public void postAcceptFriendInvitation(Message message) throws IOException {
        logger.info("postAcceptFriendInvitation");
    }

    @Override
    public void onChatRoomMembersChanged(Contact chatRoom, Set<ChatRoomMember> membersJoined, Set<ChatRoomMember> membersLeft) {
        logger.info("onChatRoomMembersChanged");
    }

    @Override
    public void onNewChatRoomsFound(Set<Contact> chatRooms) {
        logger.info("onNewChatRoomsFound");
    }

    @Override
    public void onChatRoomsDeleted(Set<Contact> chatRooms) {
        logger.info("onChatRoomsDeleted");
    }

    @Override
    public void onNewFriendsFound(Set<Contact> contacts) {
        logger.info("onNewFriendsFound");
    }

    @Override
    public void onFriendsDeleted(Set<Contact> contacts) {
        logger.info("onFriendsDeleted");
    }

    @Override
    public void onNewMediaPlatformsFound(Set<Contact> mps) {
        logger.info("onNewMediaPlatformsFound");
    }

    @Override
    public void onMediaPlatformsDeleted(Set<Contact> mps) {
        logger.info("onMediaPlatformsDeleted");
    }
}
