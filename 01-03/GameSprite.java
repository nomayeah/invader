package com.noma.invader;

import com.eaglesakura.lib.android.game.graphics.ImageBase;
import com.eaglesakura.lib.android.game.graphics.Sprite;
import com.eaglesakura.lib.android.game.graphics.gl11.SpriteManager;
import com.noma.invader.scene.GameSceneBase;

public abstract class GameSprite {
    /**
     * 描画に利用する画像
     */
    protected Sprite sprite = null;

    /**
     * このスプライトを保持しているシーン
     */
    protected GameSceneBase scene = null;

    protected GameSprite(GameSceneBase scene) {
        this.scene = scene;
    }

    /**
     * 描画対象のスプライトを取得する
     * @return
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * drawableの画像からスプライトを作成する
     * @param drawableId
     * @return
     */
    protected Sprite loadSprite( int drawableId ) {
        ImageBase image = scene.loadImageDrawable(drawableId);
        Sprite result = new Sprite(image);
        return result;
    }

    /**
     * スプライト描画クラスを取得する
     * @return
     */
    protected SpriteManager getSpriteManager() {
        return scene.getSpriteManager();
    }

    /**
     * 描画を行う。
     */
    public void draw() {
        if (sprite != null) {
            getSpriteManager().draw(sprite);
        }
    }
}

