package com.noma.invader.bullet;

import com.noma.invader.GameSprite;
import com.noma.invader.fighter.FighterBase;
import com.noma.invader.scene.GameSceneBase;

public abstract class BulletBase extends GameSprite {

    /**
     * この弾を打った機体を保持
     */
    FighterBase shooter = null;

    public BulletBase(GameSceneBase scene, FighterBase shooter) {
        super(scene);
        this.shooter = shooter;
    }
}
