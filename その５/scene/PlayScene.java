package com.noma.invader.scene;

import com.eaglesakura.lib.android.game.graphics.Color;
import com.eaglesakura.lib.android.game.scene.SceneBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;
import com.noma.invader.Define;
import com.noma.invader.InvaderGame;
import com.noma.invader.fighter.PlayerFighter;
import com.noma.invader.fighter.enemy.EnemyFighterBase;
import com.noma.invader.fighter.enemy.Frisbee;
import com.noma.invader.input.JoyStick;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 敵一覧
     */
    List<EnemyFighterBase> enemies = new ArrayList<EnemyFighterBase>();

    public PlayScene(InvaderGame game) {
        super(game);
    }

    @Override
    public void onSceneStart(SceneManager manager, SceneBase before) {
        joyStick = new JoyStick(this); // ジョイスティックを生成
        player = new PlayerFighter(this, joyStick); // プレイヤーを生成

        // 敵を全て生成させる
        initializeEnemy();
    }


    /**
     * 敵の初期値を行う
     */
    protected void initializeEnemy() {
        // 敵の配置テーブルを作成する
        final EnemyFighterBase[][] enemyTable = {
                // 後列
                {
                        new Frisbee(this), new Frisbee(this), new Frisbee(this), new Frisbee(this)
                },
                {
                        new Frisbee(this), new Frisbee(this), new Frisbee(this), new Frisbee(this)
                },
                {
                        new Frisbee(this), new Frisbee(this), new Frisbee(this), new Frisbee(this)
                },
        };

        // プレイエリアの左右から幅を取得する
        final int PLAY_AREA_WIDTH = Define.PLAY_AREA_RIGHT - Define.PLAY_AREA_LEFT;
        int y = 100;

        // 全ラインをfor文で見る
        for (int line = 0; line < enemyTable.length; ++line) {
            final int lineEnemyNum = enemyTable[line].length;

            // １ラインの横方向をfor文で見る
            for (int index = 0; index < lineEnemyNum; ++index) {
                //　配置対象の敵をテーブルから取り出す
                EnemyFighterBase enemy = enemyTable[line][index];

                // 配置する敵が存在する場合、位置を設定する
                if (enemy != null) {
                    // プレイエリアを等分して、現在のindexに割り当てる
                    int x = PLAY_AREA_WIDTH / lineEnemyNum * index;
                    x += PLAY_AREA_WIDTH / lineEnemyNum / 2;
                    enemy.setPosition(Define.PLAY_AREA_LEFT + x, y);

                    // 敵リストへ登録する
                    enemies .add(enemy);
                }
            }
            // Y位置を１ライン前線へ下げる
            y += 100;
        }
    }

    @Override
    public void onSceneExit(SceneManager manager, SceneBase next) {
    }

    @Override
    public void onFrameBegin(SceneManager manager) {
        player.update(); //プレイヤーの位置を更新する
        joyStick.update(); // コントローラーの位置を更新する

        // 敵を全て更新する
        for (EnemyFighterBase enemy : enemies) {
            enemy.update();
        }
    }

    @Override
    public void onFrameDraw(SceneManager manager) {
        getSpriteManager().clear(0, 0, 64, 255); // 宇宙の色に染める
        player.draw(); // プレイヤーを描画する

        // 敵を全て描画する
        for (EnemyFighterBase enemy : enemies) {
            enemy.draw();
        }

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