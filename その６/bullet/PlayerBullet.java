package com.noma.invader.bullet;

import com.noma.invader.R;
import com.noma.invader.fighter.FighterBase;
import com.noma.invader.scene.GameSceneBase;

public class PlayerBullet extends BulletBase {
    public PlayerBullet(GameSceneBase scene, FighterBase shooter) {
        super(scene, shooter);
        sprite = loadSprite(R.drawable.bullet_player);
        setPosition(shooter.getPositionX(), shooter.getPostionY()); // 位置を発射した戦闘機に合わせる
    }

    @Override
    public void update() {
    }
}
