package com.noma.invader;

import android.content.Context;

import com.noma.invader.scene.PlaySceneStage1;
import com.eaglesakura.lib.android.game.loop.SpriteGameLoopManagerBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;

public class InvaderGame extends SpriteGameLoopManagerBase {

    /**
     * シーン管理クラスを追加
     */
    SceneManager sceneManager = new SceneManager(null);

    public InvaderGame(Context context, ILoopParent loopParent) {
        super(context, loopParent);
    }

    @Override
    protected void onGameInitialize() {
        super.onGameInitialize();

        /**
         * 最初のシーンを登録する
         */
        sceneManager.setNextScene(new PlaySceneStage1(this));
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
