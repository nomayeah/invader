package com.noma.invader;

import android.content.Context;

import com.eaglesakura.lib.android.game.loop.SpriteGameLoopManagerBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;
import com.noma.invader.scene.PlayScene;

public class InvaderGame extends SpriteGameLoopManagerBase {

    SceneManager sceneManager = new SceneManager(null);

    public InvaderGame(Context context, ILoopParent loopParent) {
        super(context, loopParent);
    }

    @Override
    protected void onGameInitialize() {
        super.onGameInitialize();

        sceneManager.setNextScene(new PlayScene(this));
    }

    @Override
    protected void onGameFrameBegin() {
        sceneManager.onFrameBegin();
    }

    @Override
    protected void onGameFrameDraw() {
        sceneManager.onFrameDraw();
    }

    @Override
    protected void onGameFrameEnd() {
        sceneManager.onFrameEnd();
    }

    @Override
    protected void onGamePause() {
        sceneManager.onGamePause();
    }

    @Override
    protected void onGameResume() {
        sceneManager.onGameResume();
    }

}
