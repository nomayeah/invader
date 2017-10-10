package com.noma.invader.input;

import android.graphics.Rect;

import com.eaglesakura.lib.android.game.input.MultiTouchInput;
import com.eaglesakura.lib.android.game.input.MultiTouchInput.TouchPoint;
import com.noma.invader.Define;
import com.noma.invader.GameSprite;
import com.noma.invader.R;
import com.noma.invader.scene.GameSceneBase;
import com.eaglesakura.lib.android.game.graphics.Sprite;


public class JoyStick extends GameSprite {

    /**
     * タッチに反応するエリア
     */
    Rect touchArea = new Rect(0, 500, 200, Define.VIRTUAL_DISPLAY_HEIGHT);

    /**
     * ジョイスティック取っ手のスプライト
     */
    Sprite stick = null;

    public JoyStick(GameSceneBase scene) {
        super(scene);

        //土台を読み込む
        sprite = loadSprite(R.drawable.ui_stickbase);
        stick = loadSprite(R.drawable.ui_stick); //　スティック本体の読み込み
        setPosition(70, Define.VIRTUAL_DISPLAY_HEIGHT - 120); // スプライトの位置を調整
    }

    /**
     * ジョイスティックとっての描画を行うメソッド
     */
    void drawStick() {
        getSpriteManager().draw(stick); // スティック本体の描画を行う
    }

    /**
     *  毎フレームの更新処理を行う
     */
    @Override
    public void update() {
        MultiTouchInput touch = scene.getMultiTouchInput();
        TouchPoint touchPoint = touch.getEnableTouchPoint(touchArea); // 指定したエリアに指があるか調べる

        if(touchPoint != null) {
            stick.setSpritePosition(touchPoint.getCurrentX(), touchPoint.getCurrentY()); // 指が置かれているため、その位置へジョイスティックを移動
        } else {
            stick.setSpritePosition((int) position.x, (int) position.y); //　指が置かれていないため、ジョイスティックを土台と同じ位置に戻す
        }
    }

    /**
     * オブジェクトの描画
     */
    @Override
    public void draw() {
        super.draw();
        drawStick();
    }
}