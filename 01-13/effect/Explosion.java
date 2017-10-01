package com.noma.invader.effect;

import com.noma.invader.GameSprite;
import com.noma.invader.R;
import com.noma.invader.scene.GameSceneBase;

public class Explosion extends EffectBase {
    public Explosion(GameSceneBase scene, GameSprite parent) {
        super(scene);

        sprite = loadAnimatedSprite(R.drawable.explosion, 64, 64, 12);
        if(parent != null) {
            setPosition(parent.getPositionX(), parent.getPostionY());
        }
    }

}
