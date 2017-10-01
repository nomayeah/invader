package com.noma.invader.effect;

import com.noma.invader.GameSprite;
import com.noma.invader.scene.GameSceneBase;

public abstract class EffectBase extends GameSprite {
    public EffectBase(GameSceneBase scene) {
        super(scene);
    }

    public boolean isEnable() {
        return !sprite.isAnimationFinish();
    }

    @Override
    public void update() {
        sprite.nextFrame();
    }
}
