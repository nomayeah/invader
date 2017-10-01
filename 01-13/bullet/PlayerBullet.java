package com.noma.invader.bullet;

import com.noma.invader.R;
import com.noma.invader.effect.Explosion;
import com.noma.invader.fighter.FighterBase;
import com.noma.invader.scene.GameSceneBase;
import com.noma.invader.scene.PlaySceneStage1;

public class PlayerBullet extends BulletBase {
    public PlayerBullet(GameSceneBase scene, FighterBase shooter) {
        super(scene, shooter);
        sprite = loadSprite(R.drawable.bullet_player);
        setPosition(shooter.getPositionX(), shooter.getPostionY()); // 位置を発射した戦闘機に合わせる
    }

    @Override
    public void update() {
        offsetPosition(0, -10); // 上に向かって移動

        if (((PlaySceneStage1) scene).intersectsEnemy(this) != null) {
            enable = false;

            {
                Explosion exp = new Explosion(scene, this);
                ((PlaySceneStage1) scene).addEffect(exp);
            }
        }
    }
}
