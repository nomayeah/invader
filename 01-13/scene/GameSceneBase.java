package com.noma.invader.scene;

import com.eaglesakura.lib.android.game.input.MultiTouchInput;
import com.noma.invader.InvaderGame;
import com.eaglesakura.lib.android.game.graphics.ImageBase;
import com.eaglesakura.lib.android.game.graphics.gl11.SpriteManager;
import com.eaglesakura.lib.android.game.scene.SceneBase;

public abstract class GameSceneBase extends SceneBase {
    /**
     * ゲームメインクラス
     */
    protected InvaderGame game = null;

    protected GameSceneBase(InvaderGame game) {
        this.game = game;
    }

    /**
     * マルチタッチ解析クラスを取得
     */

    public MultiTouchInput getMultiTouchInput() {
        return game.getMultiTouchInput();
    }

    /**
     * スプライトマネージャを取得する
     * @return
     */

    public SpriteManager getSpriteManager() {
        return game.getSpriteManager();
    }

    /**
     * drawableのIDを指定して画像を読み込む
     * @param drawableId
     * @return
     */

    public ImageBase loadImageDrawable(int drawableId) {
        return game.loadImageDrawable(drawableId);
    }
}
