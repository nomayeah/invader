package com.noma.invader;

import android.content.Context;

import com.eaglesakura.lib.android.game.loop.SpriteGameLoopManagerBase;

public class InvaderGame extends SpriteGameLoopManagerBase {

    public InvaderGame(Context context, ILoopParent loopParent) {
        super(context, loopParent);
    }

    @Override
    protected void onGameFrameBegin() {
    }

    @Override
    protected void onGameFrameDraw() {
        getSpriteManager().clear(0, 0, 64, 255);
    }

    @Override
    protected void onGameFrameEnd() {
    }

    @Override
    protected void onGamePause() {
    }

    @Override
    protected void onGameResume() {
    }

}
