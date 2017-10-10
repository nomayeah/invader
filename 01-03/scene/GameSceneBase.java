package com.noma.invader.scene;

import com.eaglesakura.lib.android.game.graphics.ImageBase;
import com.eaglesakura.lib.android.game.graphics.gl11.SpriteManager;
import com.eaglesakura.lib.android.game.scene.SceneBase;
import com.noma.invader.InvaderGame;

public abstract class GameSceneBase extends SceneBase {
    /**
     * ゲームメインクラス
     */
    protected InvaderGame game = null;

    protected GameSceneBase(InvaderGame game) {
        this.game = game;
    }

    public SpriteManager getSpriteManager() {
        return game.getSpriteManager();
    }

    public ImageBase loadImageDrawable(int drawableId) {
        return game.loadImageDrawable(drawableId);
    }
}