package com.noma.invader.bullet;

import com.noma.invader.R;
import com.noma.invader.fighter.FighterBase;
import com.noma.invader.scene.GameSceneBase;
import com.noma.invader.scene.PlaySceneStage1;

public class FrisbeeBullet extends BulletBase {
    public FrisbeeBullet(GameSceneBase scene, FighterBase shooter) {
        super(scene, shooter);

        sprite = loadSprite(R.drawable.bullet_enemy); // 弾の画像を保持する
        setPosition(shooter.getPositionX(), shooter.getPostionY()); // 発射した弾を敵に合わせる
    }

    @Override
    public void update() {
        offsetPosition(0, 10); //　下に向かって移動

        FighterBase player = ((PlaySceneStage1) scene).getPlayer();
        // プレイヤーと弾が衝突していたらダメージ処理を行う
        if (player.isIntersect(this)) {
            enable = false;
            player.onDamage(this);
        }
    }
}
