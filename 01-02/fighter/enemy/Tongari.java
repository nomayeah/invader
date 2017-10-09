package com.noma.invader.fighter.enemy;

import com.noma.invader.R;
import com.noma.invader.bullet.DirectionBullet;
import com.noma.invader.scene.GameSceneBase;
import com.noma.invader.scene.PlaySceneBase;

public class Tongari extends EnemyFighterBase {
    public Tongari(GameSceneBase scene) {
        super(scene);
        sprite = loadSprite(R.drawable.enemy_01); // 敵画像読み込み
        hp = 50; // HP50のボスキャラにする。
    }

    void fire() {
        // 方向弾を生成する
        DirectionBullet bullet = new DirectionBullet(scene, this);

        // 現在のフレーム数の角度へ10の速度で打ち込む
        bullet.setup(120 + (frameCount % 120), 10);

        // シーンに弾を追加する
        ((PlaySceneBase) scene).addBullet(bullet);
    }

    @Override
    public void update() {
        // スーバークラスの処理を行わせる
        super.update();
        // 指定したフレームで処理を行わせる
        if (frameCount % 10 == 0) {
            // 10フレーム経過したら弾を撃つ
            fire();
        }
    }
}
