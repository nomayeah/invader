package com.noma.invader.fighter;


import com.noma.invader.Define;
import com.noma.invader.R;
import com.noma.invader.scene.GameSceneBase;
import com.noma.invader.input.JoyStick;
import com.eaglesakura.lib.android.game.math.Vector2;

public class PlayerFighter extends FighterBase {

    /**
     * 操作用のジョイスティック
     */
    JoyStick joyStick;

    public PlayerFighter(GameSceneBase scene, JoyStick joyStick) {
        super(scene);
        this.joyStick = joyStick;

        /**
         * プライヤー画像の読み込み
         */
        sprite = loadSprite(R.drawable.player);

        /**
         * 初期位置を画面の下側中央にする
         */
        setPosition(Define.VIRTUAL_DISPLAY_WIDTH / 2, Define.VIRTUAL_DISPLAY_HEIGHT - 100);

    }

    /**
     * プレイヤー位置を更新する
     */
    void updatePosition() {
        // 移動させたい向きのベクトルを取得する
        Vector2 move = joyStick.getMoveVector();

        // 1フレームで最大５ピクセル移動するようにする
        move.mul(5.0f);

        // その方向へ移動させる
        offsetPosition(move.x, move.y);

        //! 位置をプレイエリア内に補正する
        correctPosition();
    }

    @Override
    public void update() {
        updatePosition();
    }
}