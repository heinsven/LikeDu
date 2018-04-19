package com.cuit.likedu.common;

import com.cuit.likedu.utils.LogUtils;
import com.sinovoice.hcicloudsdk.player.TTSCommonPlayer;
import com.sinovoice.hcicloudsdk.player.TTSPlayerListener;

public class TTSEventProcess implements TTSPlayerListener {
    @Override
    public void onPlayerEventStateChange(TTSCommonPlayer.PlayerEvent playerEvent) {
        LogUtils.i(playerEvent);
    }

    @Override
    public void onPlayerEventProgressChange(TTSCommonPlayer.PlayerEvent playerEvent, int start, int end) {
        LogUtils.i(playerEvent);
    }

    @Override
    public void onPlayerEventPlayerError(TTSCommonPlayer.PlayerEvent playerEvent, int errorCode) {
        LogUtils.e(errorCode+":"+playerEvent);
    }
}