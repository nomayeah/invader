package com.noma.invader.fighter;

import com.noma.invader.R;
import com.noma.invader.scene.GameSceneBase;

public class PlayerFighter extends FighterBase {

    public PlayerFighter(GameSceneBase scene) {
        super(scene);

        sprite = loadSprite(R.drawable.player);

    }

}