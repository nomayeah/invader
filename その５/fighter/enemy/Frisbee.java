package com.noma.invader.fighter.enemy;


import com.noma.invader.R;
import com.noma.invader.scene.GameSceneBase;

public class Frisbee extends EnemyFighterBase {
    public Frisbee(GameSceneBase scene) {
        super(scene);
        sprite = loadSprite(R.drawable.enemy_00); // 敵画像読み込み
    }

    @Override
    public void update() {

    }
}