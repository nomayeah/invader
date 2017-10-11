package com.noma.invader.scene;

import com.eaglesakura.lib.android.game.graphics.Color;
import com.eaglesakura.lib.android.game.scene.SceneBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;
import com.noma.invader.Define;
import com.noma.invader.InvaderGame;
import com.noma.invader.fighter.PlayerFighter;
import com.noma.invader.input.JoyStick;

public class PlayScene extends GameSceneBase {

    /**
     * プレイヤー機
     */
    PlayerFighter player = null;

    /**
     * ジョイスティック管理
     * @param game
     */
    JoyStick joyStick = null;

    public PlayScene(InvaderGame game) {
        super(game);
    }

    @Override
    public void onSceneStart(SceneManager manager, SceneBase before) {
        joyStick = new JoyStick(this); // ジョイスティックを生成
        player = new PlayerFighter(this, joyStick); // プレイヤーを生成
    }

    @Override
    public void onSceneExit(SceneManager manager, SceneBase next) {
    }

    @Override
    public void onFrameBegin(SceneManager manager) {
        player.update(); //プレイヤーの位置を更新する
        joyStick.update(); // コントローラーの位置を更新する</span>
    }

    @Override
    public void onFrameDraw(SceneManager manager) {
        getSpriteManager().clear(0, 0, 64, 255); // 宇宙の色に染める
        player.draw(); // プレイヤーを描画する

        // 画面のプレイエリア外を塗りつぶす
        {
            // 左端
            getSpriteManager().fillRect(
                    //起点の座標
                    0,0,

                    //幅高さ
                    Define.PLAY_AREA_LEFT, Define.VIRTUAL_DISPLAY_HEIGHT,

                    //　描画する色
                    Color.toColorRGBA(255, 255, 255, 255));

            //　右端
            getSpriteManager().fillRect(
                    //起点
                    Define.PLAY_AREA_RIGHT, 0,

                    // 幅高さ
                    Define.VIRTUAL_DISPLAY_WIDTH - Define.PLAY_AREA_RIGHT, Define.VIRTUAL_DISPLAY_HEIGHT,

                    // 描画する色
                    Color.toColorRGBA(255, 255, 255, 255));
        }

        joyStick.draw();
    }

    @Override
    public void onFrameEnd(SceneManager manager) {
    }

    @Override
    public void onGamePause(SceneManager manager) {
    }

    @Override
    public void onGameResume(SceneManager manager) {
    }
}