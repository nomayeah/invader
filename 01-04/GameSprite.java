package com.noma.invader;

import com.eaglesakura.lib.android.game.graphics.ImageBase;
import com.eaglesakura.lib.android.game.graphics.Sprite;
import com.eaglesakura.lib.android.game.graphics.gl11.SpriteManager;
import com.eaglesakura.lib.android.game.math.Vector2;
import com.noma.invader.scene.GameSceneBase;

public abstract class GameSprite {
    /**
     * 描画に利用する画像
     */
    protected Sprite sprite = null;

    /**
     * 描画位置
     */
    protected Vector2 position = new Vector2();

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
     * 毎フレームの更新処理を行う
     */
    public abstract void update();

    /**
     * 描画を行う。
     */
    public void draw() {
        if (sprite != null) {
            getSpriteManager().draw(sprite);
        }
    }

    /**
     * 描画位置を指定する。
     * @param x
     * @param y
     */
    public void setPosition(float x, float y) {
        position.set(x, y);

        // スプライトに現在位置を伝える
        sprite.setSpritePosition((int) position.x, (int) position.y);
    }
}

