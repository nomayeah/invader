package com.noma.invader.scene;

import com.eaglesakura.lib.android.game.scene.SceneBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;
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
        player = new PlayerFighter(this); // プレイヤーを生成
        joyStick = new JoyStick(this); // ジョイスティックを生成
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