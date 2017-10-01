package com.noma.invader.scene;

import com.noma.invader.Define;
import com.noma.invader.InvaderGame;
import com.noma.invader.bullet.BulletBase;
import com.noma.invader.effect.EffectBase;
import com.noma.invader.figther.PlayerFighter;
import com.noma.invader.figther.enemy.EnemyFigtherBase;
import com.noma.invader.input.AttackButton;
import com.noma.invader.input.JoyStick;
import com.eaglesakura.lib.android.game.graphics.Color;
import com.eaglesakura.lib.android.game.scene.SceneBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class PlaySceneBase extends GameSceneBase {
    /**
     * プレイヤー機
     */
    PlayerFighter player = null;

    protected abstract void initializeEnemy();

    /**
     * ジョイスティック管理
     * @param game
     */
    JoyStick joyStick = null;

    /**
     * 発射ボタン
     */
    AttackButton shotButton = null;

    /**
     * 敵一覧
     */
    protected List<EnemyFigtherBase> enemies = new ArrayList<EnemyFigtherBase>();

    /**
     * 弾一覧
     */

    List<BulletBase> bullets = new ArrayList<BulletBase>();
    /**
     * エフェクト一覧
     */

    List<EffectBase> effects = new ArrayList<EffectBase>();

    public PlaySceneBase(InvaderGame game) {
        super(game);
    }

    /**
     * プレイヤー機のアクセサ
     * @return
     */
    public PlayerFighter getPlayer() {
        return player;
    }

    /**
     * 弾をステージへ追加する
     * @param bullet
     */
    public void addBullet(BulletBase bullet) {
        bullets.add(bullet);
    }

    /**
     * エフェクトをステージへ追加する
     * @param effect
     */
    public void addEffect(EffectBase effect){
        effects.add(effect);
    }

    /**
     * 敵との当たり判定を行い、当たっているオブジェクトがあったらその敵機を返す。
     * @param bullet
     * @return
     */
    public EnemyFigtherBase intersectsEnemy(BulletBase bullet) {
        for (EnemyFigtherBase enemy : enemies) {
            if (enemy.isIntersect(bullet)) {
                enemy.onDamage(bullet);
                return enemy;
            }
        }
        return null;
    }

    @Override
    public void onSceneStart(SceneManager manager, SceneBase before) {
        joyStick = new JoyStick(this);  //  ジョイスティックを生成する
        shotButton = new AttackButton(this); // 攻撃ボタンを生成する
        player = new PlayerFighter(this, joyStick, shotButton); // プレイヤーを生成する

        // 敵を全て生成させる
        initializeEnemy();
    }


    @Override
    public void onSceneExit(SceneManager manager, SceneBase next){

    }

    /**
     * 毎フレームの更新を行う
     */
    @Override
    public void onFrameBegin(SceneManager manager){
        // プレイヤーが死んでいなければ更新処理を行う
        if (!player.isDead()) {
            player.update(); // プレイヤーの位置を更新する
        }
        shotButton.update(); // 攻撃ボタンの状態を更新する
        joyStick.update(); // ジョイスティックの位置を更新する

        // 敵を全て更新する
        {
            Iterator<EnemyFigtherBase> iterator = enemies.iterator();
            while (iterator.hasNext()) {
                EnemyFigtherBase enemy = iterator.next();
                enemy.update();
                if (enemy.isDead() || !enemy.isAppeaedDisplay()) {
                    iterator.remove();
                }
            }
        }

        // 弾を全て更新する
        {
            Iterator<BulletBase> iterator = bullets.iterator();
            while (iterator.hasNext()) {
                BulletBase bullet = iterator.next();
                bullet.update();
                if (!bullet.isEnable() || !bullet.isAppeaedDisplay()) {
                    iterator.remove();
                }
            }
        }

        // エフェクトを全て更新する
        {
            Iterator<EffectBase> iterator = effects.iterator();
            while (iterator.hasNext()) {
                EffectBase effect = iterator.next();
                effect.update();
                if (!effect.isEnable()) {
                    // エフェクトが無効になったら排除する
                    iterator.remove();
                }
            }
        }
    }

    @Override
    public void onFrameDraw(SceneManager manager) {
        getSpriteManager().clear(0, 0, 64, 255);
        // プレイヤーが死んでいなければ描画処理を行う
        if (!player.isDead()) {
            player.draw(); //　プレイヤーを描画する
        }

        // 敵を全て描画する
        for (EnemyFigtherBase enemy : enemies) {
            enemy.draw();
        }

        // 弾を全て描画する
        for (BulletBase bullet : bullets) {
            bullet.draw();
        }

        // エフェクトを全て秒がする
        for (EffectBase effect : effects) {
            effect.draw();
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

        joyStick.draw(); //ジョイスティックを表示
        shotButton.draw(); // 攻撃ボタンを表示
    }

    /**
     * ゲームオーバー条件を満たしたらtrueを返す
     * @param
     */
    public boolean isGameover() {
        return player.isDead(); // プレイヤーが撃墜されたらゲームオーバー
    }

    /**
     * ゲームクリア条件を満たしたらtrueを返す
     */
    public boolean isGameclear() {
        return enemies.isEmpty(); // 敵が全滅状態になったらゲームクリア
    }

    /**
     * 条件を満たしたらシーンを切り替える
     */
    @Override
    public void onFrameEnd(SceneManager manager) {
        if (isGameover()) {
            // ゲームオーバーを条件を満たしたから、ゲームオーバーシーンへ切り替える
            GameOverScene nextScene = new GameOverScene(game);
            manager.setNextScene(nextScene);
        } else if (isGameclear()) {
            // ゲームクリア条件を満たしたら、ゲームクリアシーンへ切り替える
            GameClearScene nextScene = new GameClearScene(game);
            manager.setNextScene(nextScene);
        }
    }

    @Override
    public void onGamePause(SceneManager manager) {

    }

    @Override
    public void onGameResume(SceneManager manager) {

    }
}
