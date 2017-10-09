package com.noma.invader.fighter.enemy;

import com.noma.invader.R;
import com.noma.invader.bullet.FrisbeeBullet;
import com.noma.invader.scene.GameSceneBase;
import com.noma.invader.scene.PlaySceneBase;

public class Frisbee extends EnemyFighterBase {
    public Frisbee(GameSceneBase scene) {
        super(scene);
        sprite = loadSprite(R.drawable.enemy_00); // 敵画像読み込み
    }

    void fire() {
        FrisbeeBullet bullet = new FrisbeeBullet(scene, this);
        ((PlaySceneBase) scene).addBullet(bullet);
    }

    @Override
    public void update() {
        // スーバークラスの処理を行わせる
        super.update();
        // 指定したフレームで処理を行わせる
        if (frameCount == 30 * 5) {
            // 150フレーム経過したら弾を撃つ、その後カウンターリセット
            fire(); // 毎フレーム　弾を撃つ
            resetFrameCount();
        } else if (frameCount % 30 == 0) {
            //30フレームに１回、15フレーム前進する
            offsetPosition(0, 15);
        }
    }
}
